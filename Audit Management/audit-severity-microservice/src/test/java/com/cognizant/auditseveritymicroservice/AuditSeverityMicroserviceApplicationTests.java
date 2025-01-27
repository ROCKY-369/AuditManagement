package com.cognizant.auditseveritymicroservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class AuditSeverityMicroserviceApplicationTests {

	@Mock
	AuditSeverityMicroserviceApplication application;

	@Test
	public void contextLoads() {
		assertNotNull(application);
	}
	

}
