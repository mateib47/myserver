package com.myserver.portfolio;

import com.myserver.project.Project;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PortfolioService {
    private PortfolioRepository portfolioRepository;

    public Portfolio getProjects(Long id){
        return portfolioRepository.getPortfolioById(id);
    }
}
