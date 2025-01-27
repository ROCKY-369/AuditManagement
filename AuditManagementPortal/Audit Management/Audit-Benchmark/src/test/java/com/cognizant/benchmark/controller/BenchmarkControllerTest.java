package com.cognizant.benchmark.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.benchmark.auth.AuthClient;
import com.cognizant.benchmark.model.AuditBenchmark;
import com.cognizant.benchmark.service.AuditBenchmarkService;
import com.cognizant.benchmark.service.TokenValidationService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Test class for BenchmarkController 
 */

@RunWith(SpringRunner.class)
@ContextConfiguration 
@Slf4j
@ExtendWith(MockitoExtension.class)
public class BenchmarkControllerTest {

	/**
	 * Mocking all required objects
	 */
	@Mock
	AuthClient authClient;
		
	@Mock
	TokenValidationService tokenService;
	
	@Mock
	AuditBenchmarkService benchmarkService;
	
	@Mock
	AuditBenchmark auditBenchmark;

    
	@InjectMocks
	BenchmarkController controller;
	
	/**
	 * Testing the methods
	 */
	@Test
	public void testGetBenchmarkMap() {
		log.info("Audit Benchmark Test Starts");
		List<AuditBenchmark> auditBenchmarkList = new ArrayList<>();
		auditBenchmarkList.add(new AuditBenchmark("Internal", 3));
		when(tokenService.checkValidity("token")).thenReturn(true);
		when(benchmarkService.fetchBenchmarkList()).thenReturn(auditBenchmarkList);
		assertNotNull(controller.getBenchmarkMap("token").getBody());
		log.info("Audit Benchmark Test Ends");
	}
	
	@Test
	public void testTokenInvalid() {
		when(tokenService.checkValidity("token")).thenReturn(false);
		assertEquals(HttpStatus.FORBIDDEN,controller.getBenchmarkMap("token").getStatusCode());
	}
}
