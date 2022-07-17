package com.myserver.portfolio;

import com.myserver.project.Project;
import com.myserver.project.ProjectRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/portfolio")
@AllArgsConstructor
public class PortfolioController {
    private PortfolioService portfolioService;

    @GetMapping(path = "get")
    public List<Project> getProjects(@Param("section") String name){
        return portfolioService.getProjects(name);
    }

    @PostMapping(path = "create")
    public Long addPortfolio(@RequestParam("name") String name){
        return portfolioService.create(name);
    }
}
