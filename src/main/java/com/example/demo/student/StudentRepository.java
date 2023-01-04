package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/*
 * JPA REPOSITORY
 * Spring Data JPA focuses on using JPA to store data in a relational database
 * Is JPA an ORM?
The Java Persistence API (JPA) is a specification that defines how to persist data in Java applications
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // select * from student where email = ?
    @Query("SELECT s FROM Student s where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
