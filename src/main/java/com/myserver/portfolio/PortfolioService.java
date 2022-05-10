package com.myserver.portfolio;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PortfolioService {
    private PortfolioRepository portfolioRepository;

    public List<Project> getProjects(){
        return portfolioRepository.getAll();
    }
}
