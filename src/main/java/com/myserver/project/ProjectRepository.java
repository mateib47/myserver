package com.myserver.project;

import com.myserver.portfolio.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> getAllByPortfolio(Portfolio portfolio);
    List<Project> getAllByDisplayTrue();
    Optional<Project> findProjectByNodeId(String node_id);

    @Transactional
    @Modifying
    @Query("update Project p set p.name = :name, p.description=:description, p.homepage=:homepage, p.ghUrl=:ghUrl, p.language=:language where p.id = :id")
    void updateProject(@Param(value = "id") Long id, @Param(value = "name") String name,
                     @Param(value = "description") String description,@Param(value = "ghUrl") String ghUrl,
                     @Param(value = "homepage") String homepage,@Param(value = "language") String language);//fix update topics @Param(value = "topics") List<String> topics

    @Transactional
    @Modifying
    @Query("update Project p set p.portfolio = :portfolio where p.id = :id")
    void updateProjectPortfolio(@Param(value = "id") Long id, @Param(value = "portfolio") Portfolio portfolio);

    @Transactional
    @Modifying
    @Query("UPDATE Project p set p.topics=:topics WHERE p.id = :id")
    void updateTopic(@Param(value = "id") Long id, @Param(value = "topics") List<String> topics);

}
