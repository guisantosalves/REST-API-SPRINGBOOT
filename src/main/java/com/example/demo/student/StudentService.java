package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
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
        return studentRepository.findAll();
    }
    
    public void addNewStudant(Student student){
        
        Optional<Student> studentEmail = studentRepository.findStudentByEmail(student.getEmail());
        
        // verifying if the email is in the body request
        // any new request out of the list in repository, is give this way
        if(studentEmail.isPresent()){
            // search in database if it has an email equals of the body request 
            throw new IllegalStateException("email already exist");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long idLong){
        boolean verifyingidStudent = studentRepository.existsById(idLong);

        if(verifyingidStudent) {
            studentRepository.deleteById(idLong);
        }else{
            throw new IllegalStateException("Id não existente");
        }
    }

}
