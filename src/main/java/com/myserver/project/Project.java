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
    @ManyToOne
    private Portfolio portfolio;
}
