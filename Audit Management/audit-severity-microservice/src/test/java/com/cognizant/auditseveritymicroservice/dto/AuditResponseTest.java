package com.cognizant.auditseveritymicroservice.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuditResponseTest {
    private AuditResponse response;
	
	@BeforeEach
	public void init() {
		response = new AuditResponse();
	}
	/**
     * Test method to check set method of audit id. 
     */
	@Test
	public void testGetSetAuditId() {
		response.setAuditId(1);
		assertEquals(1, response.getAuditId());
	}
	/**
     * Test method to check set method of action to be taken. 
     */
    @Test
	public void testGetSetRemedialActionDuration() {
		response.setRemedialActionDuration("NA");
		assertEquals("NA", response.getRemedialActionDuration());
	}
    /**
     * Test method to check set method of Status of project. 
     */
	@Test
	public void testGetSetProjectExecutionStatus() {
		response.setProjectExecutionStatus("GREEN");
		assertEquals("GREEN", response.getProjectExecutionStatus());
	}
	/**
     * Test method to check constructor method . 
     */
	@Test
	public void testConstructor(){
		response=new AuditResponse(1,"GREEN","No");
		assertEquals(1,response.getAuditId());
		assertEquals("GREEN", response.getProjectExecutionStatus());
		assertEquals("No", response.getRemedialActionDuration());
	}
	
    
}
