package com.myserver.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectRequest {
    private String name;
    private String description;
    private String imgLink;
    private String ghLink;
    private String portfolioName;
}
