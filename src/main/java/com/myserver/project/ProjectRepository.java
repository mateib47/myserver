package com.myserver.project;

import com.myserver.portfolio.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    public List<Project> getAllByPortfolio(Portfolio portfolio);
    boolean existsProjectById(Long id);
    List<Project> getAllByDisplayTrue();
}
