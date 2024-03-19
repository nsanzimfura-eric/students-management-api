package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    private final StudentService studentServices;

    @Autowired
    public StudentController(StudentService studentServices) {
        this.studentServices = studentServices;
    }

    @GetMapping
    public List<Student> getListOfStudents(){
        return  this.studentServices.getStudents();
    }

}
