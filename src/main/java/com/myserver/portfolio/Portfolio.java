package com.myserver.portfolio;

import com.myserver.person.Person;
import com.myserver.project.Project;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Portfolio {
    @SequenceGenerator(name = "portfolio_seq",
            sequenceName = "portfolio_seq",
            allocationSize = 1)
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "portfolio_seq")
    private Long id;
    private String name;
    @OneToMany
    private List<Project> projects;
    @ManyToOne
    private Person person;
    //testimonials - name - description
    //person name email...


    public Portfolio(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
