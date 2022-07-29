package com.myserver.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/project")
@AllArgsConstructor
public class ProjectController {
    private ProjectService projectService;

    @PostMapping(path = "add")
    public Long addProject(@RequestBody ProjectRequest projectRequest){
        return projectService.addProject(projectRequest);
    }

    @PutMapping(path = "update")
    private String update()
    {
        if(projectService.updateProjects()){
            return "success";
        }else{
            return "error";
        }
    }
    @CrossOrigin
    @GetMapping(path = "get")
    public List<Project> getProjects(){
        return projectService.getProjects();
    }

    @PutMapping(path = "addPortfolio")
    public String addPortfolioToProj(@RequestParam Long projectId, @RequestParam String portfolioId){
        return projectService.addPortfolioToProj(projectId, portfolioId);
    }
}
