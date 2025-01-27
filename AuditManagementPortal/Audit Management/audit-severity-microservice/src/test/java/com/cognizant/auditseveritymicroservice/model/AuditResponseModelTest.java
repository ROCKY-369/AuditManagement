package com.cognizant.auditseveritymicroservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuditResponseModelTest {
    private AuditResponseModel response;
	
	@BeforeEach
	public void setup() {
		response = new AuditResponseModel();
	}
	
	/**
     * Test method to check the set method for audit status. 
     */
	@Test
	public void testGetSetProjectExecutionStatus() {
		response.setProjectExecutionStatus("GREEN");
		assertEquals("GREEN", response.getProjectExecutionStatus());
	}
	/**
     * Test method to check the set method for audit action. 
     */
	@Test
	public void testGetSetRemedialActionDuration() {
		response.setRemedialActionDuration("No");
		assertEquals("No", response.getRemedialActionDuration());
	}
	/**
     * Test method to check the set method for audit response id. 
     */
	@Test
	public void testGetResponseId() {
		assertEquals(null, response.getResponseId());
	}
	/**
     * Test method to check the set method for audit id. 
     */
	@Test
	public void testGetSetAuditId(){
		response.setAuditId(1);
		assertEquals(1,response.getAuditId());
	}
	/**
     * Test method to check the constructor method. 
     */
	@Test
	public void testConstructor(){
		response=new AuditResponseModel(1,"GREEN","No");
		assertEquals(1,response.getAuditId());
		assertEquals("GREEN", response.getProjectExecutionStatus());
		assertEquals("No", response.getRemedialActionDuration());
	}
    
}
