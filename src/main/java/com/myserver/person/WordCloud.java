package com.myserver.person;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class WordCloud {
    private String text;
    private int value;
}
