package com.myserver.portfolio;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.myserver.person.Person;
import com.myserver.project.Project;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Portfolio {
    @Id
    @Column(name = "portfolio_id", unique = true, nullable = false)
    private String name;

    @JsonManagedReference
    private List<Project> projects;

    @OneToMany(targetEntity=Project.class, mappedBy="portfolio", fetch=FetchType.EAGER)
    public List<Project> getProjects() {
        return projects;
    }
   // @ManyToOne
   // private Person person;
    //testimonials - name - description
    //person name email...


    public Portfolio(String name) {
        this.name = name;
        this.projects = new ArrayList<>();
    }

    @Id
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
