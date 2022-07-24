package com.myserver.project;

import com.myserver.portfolio.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> getAllByPortfolio(Portfolio portfolio);
    List<Project> getAllByDisplayTrue();
    Optional<Project> findProjectByNode_id(String id);

    @Modifying
    @Query("update Project p set p.name = :name, p.description=:description, p.homepage=:homepage, p.html_url=:html_url, p.language=:language where p.id = :id")
    void updateProject(@Param(value = "id") String id, @Param(value = "name") String name,
                     @Param(value = "description") String description,@Param(value = "html_url") String html_url,
                     @Param(value = "homepage") String homepage,@Param(value = "language") String language);
}
