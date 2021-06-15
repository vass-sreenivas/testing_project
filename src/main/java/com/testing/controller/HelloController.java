package com.testing.controller;

import com.testing.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/student/insert")
    public String insert(Student student){
        System.out.println("Inserting student....");
        return "Inserted Successfully";
    }
}
