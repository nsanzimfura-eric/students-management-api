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

    @GetMapping
    public List<Student> getListOfStudents(){
        return  this.studentServices.getStudents();
    }

    @PostMapping
    public  void  registerNewStudent (@RequestBody Student student){
        studentServices.addNewStudent(student);

    }

//    @ExceptionHandler(IllegalStateException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public String handleIllegalStateException(IllegalStateException e) {
//        return e.getMessage();
//    }

}
