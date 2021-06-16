package com.testing.demo.service;

import com.testing.demo.exception.StudentNotFoundException;
import com.testing.demo.model.Student;
import com.testing.demo.respository.StudentRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public void saveStudent(Student s){
        System.out.println(s.getName()+" -->"+s.getMarks());
        studentRepository.save(s);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudent(String name) throws StudentNotFoundException{
        Student student=studentRepository.findByName(name);
        if(student==null){
          throw new StudentNotFoundException(name+" Not Found");
        }
        return student;
    }
}
