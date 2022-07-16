package com.myserver.portfolio;

import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/portfolio")
@AllArgsConstructor
public class PortfolioController {
    private PortfolioService portfolioService;

    @GetMapping(path = "projects")
    public Portfolio getProjects(@Param("id") Long id){
        return portfolioService.getProjects(id);
    }
}
