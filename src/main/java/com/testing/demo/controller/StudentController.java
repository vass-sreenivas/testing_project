package com.testing.demo.controller;

import com.testing.demo.model.Student;
import com.testing.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public void saveStudent(@RequestBody  Student s){

        studentService.saveStudent(s);


    }

    @GetMapping("/student")
    public List<Student> getAllStudent(){

        return studentService.getAllStudents();
    }

    @GetMapping("/student/{name}")
    public Student getStudent(@PathVariable("name") String name) throws Exception{

        return studentService.getStudent(name);
    }

}
