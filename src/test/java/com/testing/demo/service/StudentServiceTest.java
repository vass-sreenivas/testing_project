package com.testing.demo.service;

import com.testing.demo.exception.StudentNotFoundException;
import com.testing.demo.model.Student;
import com.testing.demo.respository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import java.util.List;

class StudentServiceTest {


    StudentService studentServiceTest;

    @Mock
    StudentRepository studentRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        studentServiceTest=new StudentService(studentRepository);
    }

    @Test
    public void saveStudent(){
        Student s=new Student();
        s.setName("Sreenivas");
        s.setMarks(567);

        studentServiceTest.saveStudent(s);

        ArgumentCaptor<Student> argumentCaptor=ArgumentCaptor.forClass(Student.class);

        verify(studentRepository).save(argumentCaptor.capture());

        assertThat(argumentCaptor.getValue()).isEqualTo(s);
    }

    @Test
    public void canGetAllStudents(){
        List<Student> list=studentServiceTest.getAllStudents();
        System.out.println("Before List Size:"+list.size());
        verify(studentRepository).findAll();
        System.out.println("After List Size:"+list.size());
    }

    @Test
    public void findByNameTest() throws Exception{




       given(studentRepository.findByName("sreenivas")).willReturn(null);

        assertThatThrownBy(()->studentServiceTest.getStudent("sreenivas"))
                .isInstanceOf(StudentNotFoundException.class)
                .hasMessageContaining("sreenivas"+" Not Foundjj");



    }



}