package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudents(){
        return List.of(
                new Student(
                        1L,
                        "Nsanzimfura Eric",
                        LocalDate.of(2000, Month.FEBRUARY, 2),
                        23,
                        "erickykress1@gmail.com"

                )
        );
    }
}
