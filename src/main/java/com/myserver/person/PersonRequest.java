package com.myserver.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.myserver.portfolio.Portfolio;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonRequest {
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

}
