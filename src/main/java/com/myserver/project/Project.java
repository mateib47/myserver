package com.myserver.project;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.myserver.portfolio.Portfolio;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    private String node_id;
    private String name;
    private String description;
    private String imgLink;
    private String html_url;
    private String homepage;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolioId")
    private Portfolio portfolio;
    private boolean display=true;
    @ElementCollection
    private List<String> topics;
    private String language;

    public Project(String name, String description, String imgLink, String html_url, Portfolio portfolio) {
        this.name = name;
        this.description = description;
        this.imgLink = imgLink;
        this.html_url = html_url;
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgLink='" + imgLink + '\'' +
                ", html_url='" + html_url + '\'' +
                ", homepage='" + homepage + '\'' +
                ", portfolio=" + portfolio +
                ", display=" + display +
                ", topics=" + topics +
                ", language='" + language + '\'' +
                '}';
    }
}
