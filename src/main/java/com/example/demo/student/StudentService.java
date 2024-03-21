package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> findStudentByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    public void addNewStudent(Student student){
        Optional<Student> studentByEmail= studentRepository.findByEmail(student.getEmail());
        System.out.println(studentByEmail);

        if(studentByEmail.isPresent()){
            throw  new IllegalStateException("Email already exists");
        }
        //save student
        studentRepository.save(student);

    }
}
