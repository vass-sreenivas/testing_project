package com.testing.demo.respository;

import com.testing.demo.model.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testFindByName(){

        System.out.println("Test findByName is called....");
        Student s=new Student();
        s.setName("SReenivas");
        s.setMarks(576);
        studentRepository.save(s);

    }

    @BeforeAll
    public void setUp() throws Exception{
        System.out.println("BeforeAll Called.......");
        MockitoAnnotations.initMocks(this);
    }
}
