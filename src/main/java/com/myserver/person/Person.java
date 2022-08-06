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
    private String status;
    @ElementCollection
    private List<String> attributes;
    private String description;
    @ElementCollection
    private List<String> boldedWords;

    private String email;
    private String github;
    private String linkedin;
    @ElementCollection
    private List<WordCloud> words;
    private String profileImgLink;

//    @OneToMany
//    private List<Portfolio> portfolios;


    public Person(String firstName, String lastName, String status, List<String> attributes, String description, List<String> boldedWords, String email, String github, String linkedin, List<WordCloud> words, String profileImgLink) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.attributes = attributes;
        this.description = description;
        this.boldedWords = boldedWords;
        this.email = email;
        this.github = github;
        this.linkedin = linkedin;
        this.words = words;
        this.profileImgLink = profileImgLink;
       // this.portfolios = portfolios;
    }
}
