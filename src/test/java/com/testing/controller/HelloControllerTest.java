package com.testing.controller;
import com.testing.model.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class HelloControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private HelloController helloController;
    @Test
    void hello()  throws Exception{
        System.out.println("Hello Test Called.....");
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello"));
    }


    @Test
    void insertStudent() throws  Exception{
        System.out.println("Insert Studnet calle....");
        Student s=new Student();
        s.setId(456);
        s.setMarks(567);
        s.setName("Sreenivas");
        mockMvc.perform(MockMvcRequestBuilders.post("/student/insert",s))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Inserted Successfully"));
    }

    @BeforeAll
    public void setUp() throws Exception{
        System.out.println("BeforeAll Called.......");
        MockitoAnnotations.initMocks(this);
        mockMvc= MockMvcBuilders.standaloneSetup(helloController).build();
    }

}