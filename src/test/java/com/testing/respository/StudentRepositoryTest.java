package com.testing.respository;

import com.testing.model.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


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