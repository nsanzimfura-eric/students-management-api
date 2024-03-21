package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            // define list of students
               Student eric=      new Student(
                            "Nsanzimfura Eric",
                            LocalDate.of(2000, Month.FEBRUARY, 2),
                            23,
                            "erickykress1@gmail.com"

                    );
           Student gts =  new Student(
                    "Gatesi Uwase Kevine",
                    LocalDate.of(2003, Month.JULY, 18),
                    21,
                    "kevinegatesiuwase@gmail.com"

            );
            Student lastSt =  new Student(
                    "Last Test Student",
                    LocalDate.of(2007, Month.JUNE, 11),
                    18,
                    "lasttest@gmail.com"

            );

           ///save to the db
           studentRepository.saveAll(List.of(eric, gts, lastSt));
        };
    }
}
