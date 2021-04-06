package com.aljamaly.springsecurityplayground.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private static final List<Student> STUDENTS =Arrays.asList(
            new Student (1, "Simon Cowell"),
            new Student (2, "Mina Baghdadi"),
            new Student (3, "Hamza Jamaly"),
            new Student (4, "Anna Cowell")
    );

    @GetMapping(path="{id}")
    public Student getStudent (@PathVariable Integer id){
        return STUDENTS.stream()
                .filter(student -> id.equals(student.getId()))
                .findFirst()
                .orElseThrow(()-> new IllegalStateException("student wit"+ id +"not found!"));
    }

}
