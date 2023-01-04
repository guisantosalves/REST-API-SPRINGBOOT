package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(method = RequestMethod.POST)
    public void registerNewStudent(@RequestBody Student student) {
        // System.out.println(student);
        studentService.addNewStudant(student);
    }

    // declarate the path - using that path in the PathVariable
    @RequestMapping(path = "{studentId}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
        // System.out.println(id);
    }

}
