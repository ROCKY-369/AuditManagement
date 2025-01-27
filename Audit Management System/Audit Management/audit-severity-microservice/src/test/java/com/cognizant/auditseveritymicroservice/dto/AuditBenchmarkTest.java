package com.cognizant.auditseveritymicroservice.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuditBenchmarkTest {

	private AuditBenchmark benchmark;
	
	@BeforeEach
	public void init() {
		benchmark = new AuditBenchmark();
	}
	/**
	 * Test method to check the set method for audit type.
	 */
	@Test
	public void testGetSetAuditType() {
		benchmark.setAuditType("Internal");
		assertEquals("Internal", benchmark.getAuditType());
	}
	/**
	 * Test method to check the set method for No answers num.
	 */
	@Test
	public void testGetSetNoAnswersNum() {
		benchmark.setNoAnswersNum(3);
		assertEquals(3, benchmark.getNoAnswersNum());
	}
    /**
     * Test method to check the constructor class.
     */
	@Test
	public void testConstructor(){
		benchmark=new AuditBenchmark("Internal",3);
		assertEquals("Internal", benchmark.getAuditType());
		assertEquals(3, benchmark.getNoAnswersNum());
	}
}
