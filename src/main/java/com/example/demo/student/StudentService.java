package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Spring Data JPA, part of the larger Spring Data family, makes it easy to easily 
 * implement JPA based repositories. This module deals with enhanced support for JPA based data access layers
 */


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired // auto instace
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return List.of(new Student(
                1L,
                "guilherme",
                "guilherme@gmail.com",
                20,
                LocalDate.of(2002, Month.FEBRUARY, 15)));
    }

}
