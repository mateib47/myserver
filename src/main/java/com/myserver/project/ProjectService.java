package com.myserver.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myserver.portfolio.Portfolio;
import com.myserver.portfolio.PortfolioRepository;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectService {
    private ProjectRepository projectRepository;
    private PortfolioRepository portfolioRepository;

//    public List<Project[]> getProjects(String name) {
//        //return projectRepository.getAllByPortfolio(portfolioRepository.get());
//    }

    public Long addProject(ProjectRequest projectRequest) {
        System.out.println(projectRequest.getPortfolioName());
        Optional<Portfolio> portfolio = portfolioRepository.findPortfolioByName(projectRequest.getPortfolioName());
        if (portfolio.isEmpty()) {
            return null;
        }
        Project project = new Project(projectRequest.getName(),
                projectRequest.getDescription(),
                projectRequest.getImgLink(),
                projectRequest.getGhLink(),
                portfolio.get());
        System.out.println(portfolio.get());
        projectRepository.save(project);
        //  portfolioRepository.
        return project.getId();
    }

    @Transactional
    public boolean updateProjects() {
        final String uri = "https://api.github.com/users/mateib47/repos";
        RestTemplate restTemplate = new RestTemplate();
        /*//String result = restTemplate.getForObject(uri, String.class);
        ResponseEntity<Object[]> responseEntity =
                restTemplate.getForEntity(uri, Object[].class);
        Object[] objects = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();

        System.out.println(Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, Project.class))
                .collect(Collectors.toList()));*/

        ResponseEntity<List<Project>> responseEntity =
                restTemplate.exchange(
                        uri,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Project>>() {
                        }
                );
        List<Project> projects = responseEntity.getBody();
        projects.forEach((project -> {
            Optional<Project> existingProj = projectRepository.findProjectByNodeId(project.getNodeId());
            if(existingProj.isPresent()){
                Project existingPr = existingProj.get();
                existingPr.setGhUrl(project.getGhUrl());
                existingPr.setHomepage(project.getHomepage());
                existingPr.setTopics(project.getTopics());
                existingPr.setDescription(project.getDescription());
                existingPr.setName(normalizeName(project.getName()));
//                projectRepository.updateProject(existingProj.get().getId(),
//                        project.getName(), project.getDescription(),
//                        project.getGhUrl(),
//                        project.getHomepage(),
//                        project.getLanguage()
//                       ); // project.getTopics()
//                System.out.println(project.getTopics());
//                List list  = new ArrayList();
//                list.add("okk");
//                projectRepository.updateTopic(existingProj.get().getId(), null);

            }else{
                project = normalizeProject(project);
                System.out.println(project);
                projectRepository.save(project);
            }
        }));

        System.out.println(projects);
        return true;
    }

    public Project normalizeProject(Project project){
        project.setName(normalizeName(project.getName()));
        return project;
    }
    public String normalizeName(String name){
        name = name.replaceAll("-", " ");
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
    public List<Project> getProjects(){
        return projectRepository.getAllByDisplayTrue();
    }

    public String addPortfolioToProj(Long projectId, String portfolioId) {
        Optional<Portfolio> portfolio =  portfolioRepository.findPortfolioByName(portfolioId);
        Optional <Project> project = projectRepository.findById(projectId);
        if(portfolio.isEmpty()) return String.format("Portfolio with name %s not found", portfolioId);
        if(project.isEmpty()) return String.format("Project with name %s not found", projectId);

        projectRepository.updateProjectPortfolio(projectId, portfolio.get());
        return "success";
    }
}
