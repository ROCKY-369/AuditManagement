package com.cognizant.benchmark;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuditBenchmarkApplicationTest {
    
	@Mock
	AuditBenchmarkApplication application;

	@Test
	public void contextLoads() {
		assertNotNull(application);
	}
    
}
