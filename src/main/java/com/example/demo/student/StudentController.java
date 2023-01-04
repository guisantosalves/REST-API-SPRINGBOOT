package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// varre todos os arquivos que tem o annotation

@RestController
@RequestMapping(value = "/api/v1/student") // define the endpoint
public class StudentController {

    // non-changeable
    private final StudentService studentService;

    @Autowired // it will auto instace the studantService
    public StudentController(StudentService studentService){
        this.studentService = studentService; // like new studentService
    }

    // define method of the endpoint
    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

}
