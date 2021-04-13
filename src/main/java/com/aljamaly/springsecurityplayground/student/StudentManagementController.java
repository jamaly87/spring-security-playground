package com.aljamaly.springsecurityplayground.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private final static List<Student> STUDENTS = Arrays.asList(
            new Student (1, "Simon Cowell"),
            new Student (2, "Mina Baghdadi"),
            new Student (3, "Hamza Jamaly"),
            new Student (4, "Anna Cowell")
    );

    @GetMapping
    public List<Student> getStudents (){
        return STUDENTS;
    }

    @PostMapping
    public void registerNewStudent (@RequestBody Student student){
        System.out.println("Registered");
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent (@PathVariable("studentId") Integer studentId){
        System.out.println("deleted student with ID# "+studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent (@PathVariable("studentId") Integer studentId,
                               @RequestBody Student student){
        System.out.println(String.format("%s %s", studentId,student));
    }


}
