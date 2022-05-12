package com.myserver.person;

import com.myserver.portfolio.Portfolio;
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
public class Person {
    @SequenceGenerator(name = "person_seq",
            sequenceName = "person_seq",
            allocationSize = 1)
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_seq")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String description;
    private String profileImgLink;
    @ElementCollection
    private List<String> socialsLinks;
    @OneToMany
    private List<Portfolio> portfolios;


    public Person(String firstName, String lastName, String email, String description, String profileImgLink, List<String> socialsLinks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.description = description;
        this.profileImgLink = profileImgLink;
        this.socialsLinks = socialsLinks;
    }
}
