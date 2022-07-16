package com.myserver.project;

import com.myserver.portfolio.Portfolio;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Project {
    @SequenceGenerator(name = "project_seq",
            sequenceName = "project_seq",
            allocationSize = 1)
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "project_seq")
    private Long id;
    private String title;
    private String description;
    private String imgLink;
    private String ghLink;
    private ProjectSection section;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolioId")
    private Portfolio portfolio;

    public Project(String title, String description, String imgLink, String ghLink, ProjectSection section, Portfolio portfolio) {
        this.title = title;
        this.description = description;
        this.imgLink = imgLink;
        this.ghLink = ghLink;
        this.section = section;
        this.portfolio = portfolio;
    }
}
