package com.myserver.portfolio;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class ProjectSection {
    @SequenceGenerator(name = "section_seq",
            sequenceName = "section_seq",
            allocationSize = 1)
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "section_seq")
    private Long id;
    private String title;
}
