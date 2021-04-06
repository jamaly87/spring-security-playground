package com.aljamaly.springsecurityplayground.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Student {
    private final Integer id;
    private final String name;
}
