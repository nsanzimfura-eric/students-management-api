package com.example.demo.student;

import jakarta.transaction.Transactional;
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

    //delete student
    public void deleteStudent (Long id){
        //check if the student exists
        boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw  new IllegalStateException("Student does not exist");
        }
         // delete user/student
        studentRepository.deleteById(id);

    }

    //update student
    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Student with id " + id + " does not exist."));

        if (name != null && !name.isEmpty() && !name.equals(student.getNames())) {
            student.setNames(name);
        }

        if (email != null && !email.isEmpty() && !email.equals(student.getEmail())) {
            Optional<Student> studentOptional = studentRepository.findByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email already taken.");
            }
            student.setEmail(email);
        }
    }
}
