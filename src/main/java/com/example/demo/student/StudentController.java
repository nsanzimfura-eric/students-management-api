package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    private final StudentService studentServices;

    @Autowired
    public StudentController(StudentService studentServices) {
        this.studentServices = studentServices;
    }
//get all users/students
    @GetMapping
    public List<Student> getListOfStudents(){
        return  this.studentServices.getStudents();
    }
//add user
    @PostMapping
    public  void  registerNewStudent (@RequestBody Student student){
        studentServices.addNewStudent(student);

    }
//delete user/student
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentServices.deleteStudent(studentId);

    }


}
