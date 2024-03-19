package com.example.demo.student;

import java.time.LocalDate;

public class Student {
    private Long id;
    private String names;
    private LocalDate dob;
    private int age;
    private String email;

//constructors
    public Student() {
    }

    public Student(Long id, String names, LocalDate dob, int age, String email) {
        this.id = id;
        this.names = names;
        this.dob = dob;
        this.age = age;
        this.email = email;
    }

    public Student(String names, LocalDate dob, int age, String email) {
        this.names = names;
        this.dob = dob;
        this.age = age;
        this.email = email;
    }

    //getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
