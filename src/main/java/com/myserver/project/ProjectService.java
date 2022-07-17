package com.myserver.project;

import com.myserver.portfolio.Portfolio;
import com.myserver.portfolio.PortfolioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectService {
    private ProjectRepository projectRepository;
    private PortfolioRepository portfolioRepository;

//    public List<Project[]> getProjects(String name) {
//        //return projectRepository.getAllByPortfolio(portfolioRepository.get());
//    }

    public Long addProject(ProjectRequest projectRequest) {
        Optional<Portfolio> portfolio = portfolioRepository.findPortfolioByName(projectRequest.getPortfolioName());
        if(portfolio.isEmpty()){
            return null;
        }
        Project project = new Project(projectRequest.getTitle(),
                projectRequest.getDescription(),
                projectRequest.getImgLink(),
                projectRequest.getGhLink(),
                projectRequest.getSection(),
                portfolio.get());
        projectRepository.save(project);
      //  portfolioRepository.
        return project.getId();
    }
}
