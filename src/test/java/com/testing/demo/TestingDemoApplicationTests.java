package com.testing.demo;

import com.testing.respository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest(classes = StudentRepository.class)
class TestingDemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
