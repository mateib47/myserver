package com.myserver.portfolio;

import com.myserver.project.Project;
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
    public List<Project> getProjects(@RequestParam("section") String name){
        return portfolioService.getProjects(name);
    }

    @PostMapping(path = "create")
    public boolean addPortfolio(@RequestParam("name") String name){
        return portfolioService.create(name);
    }
}
