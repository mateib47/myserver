package com.myserver.portfolio;

import com.myserver.project.Project;
import com.myserver.project.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PortfolioService {
    private PortfolioRepository portfolioRepository;
    private ProjectRepository projectRepository;

    public List<Project> getProjects(String name) {
        Optional<Portfolio> portfolio = portfolioRepository.findPortfolioByName(name);
        if(portfolio.isEmpty()){
           // throw new Exception("Portfolio not found");
            return null;
        }else{
            return projectRepository.getAllByPortfolio(portfolio.get());
        }
    }
    public int create(String name){
        Portfolio portfolio = new Portfolio(name);
        System.out.println(portfolio.getId());
        portfolioRepository.save(portfolio);
        return portfolio.getId();
    }
}
