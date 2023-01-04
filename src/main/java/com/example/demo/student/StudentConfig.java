package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    /*
     * Spring Boot will automatically call the run method of all beans implementing 
     * this interface after the application context has been loaded
     */
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student gui = new Student(
                "guilherme",
                "guizap.jamal@gmail.com",
                LocalDate.of(2002, Month.FEBRUARY, 15)
            );

            Student beatriz = new Student(
                "beatriz",
                "beagato@gmail.com",
                LocalDate.of(2003, Month.DECEMBER, 19)
            );

            Student Luanzin = new Student(
                "luan",
                "luanzinhodev@gmail.com",
                LocalDate.of(1998, Month.AUGUST, 12)
            );

            repository.saveAll(List.of(gui, beatriz, Luanzin));
        };
    }
}
