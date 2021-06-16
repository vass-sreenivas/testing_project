package com.testing.demo;

import com.testing.demo.respository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest(classes = StudentRepository.class)
class TestingDemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
