package com.myserver.portfolio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, String>{
     Optional<Portfolio> findPortfolioByName(String name);
     List <String> getAllByNameIsNotNull();

}
