package com.myserver.project;

import com.myserver.portfolio.Portfolio;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ProjectRequest {
    private String title;
    private String description;
    private String imgLink;
    private String ghLink;
    private ProjectSection section;
    private String portfolioName;

}
