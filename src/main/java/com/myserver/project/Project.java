package com.myserver.project;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.myserver.portfolio.Portfolio;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
    @SequenceGenerator(name = "project_seq",
            sequenceName = "project_seq",
            allocationSize = 1)
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "project_seq")
    private Long id;
    private String name;
    private String description;
    private String imgLink;
    private String ghLink;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolioId")
    private Portfolio portfolio;

    public Project(String name, String description, String imgLink, String ghLink, Portfolio portfolio) {
        this.name = name;
        this.description = description;
        this.imgLink = imgLink;
        this.ghLink = ghLink;
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgLink='" + imgLink + '\'' +
                ", ghLink='" + ghLink + '\'' +
                ", portfolio=" + portfolio +
                '}';
    }
}
