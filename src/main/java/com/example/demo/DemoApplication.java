package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping
	public List<Student> welcomeStudents(){
//		Long id, String names, LocalDate dob, int age, String email
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
