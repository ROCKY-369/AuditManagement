package com.cognizant.auditseveritymicroservice.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuditRequestTest {

	private AuditRequest request;
	
	@BeforeEach
	public void init() {
		request = new AuditRequest();
	}
	/**
     * Test method to check set method of project name. 
     */
	@Test
	public void testGetSetProjectName() {
		request.setProjectName("Current Project");
		assertEquals("Current Project", request.getProjectName());
	}
	/**
     * Test method to check set method of project manager name. 
     */
	@Test
	public void testGetSetProjectManagerName() {
		request.setProjectManagerName("Manager");
		assertEquals("Manager", request.getProjectManagerName());
	}
	/**
     * Test method to check set method of owner name. 
     */
	@Test
	public void testGetSetOwnerName() {
		request.setApplicationOwnerName("Project Owner");
		assertEquals("Project Owner", request.getApplicationOwnerName());
	}
	/**
     * Test method to check set method of audit details. 
     */
	@Test
	public void testGetSetAuditDetails() {
		AuditDetails auditDetails = new AuditDetails();
		request.setAuditDetails(auditDetails);
		assertEquals(auditDetails, request.getAuditDetails());
	}
	/**
     * Test method to check constructor method. 
     */
	@Test
	public void testConstructor(){
		Date date=new Date();
        AuditDetails auditDetails=new AuditDetails("Internal",date);
		AuditRequest request = new AuditRequest("Current Project", "Manager","Project Owner",auditDetails);
		assertEquals("Current Project", request.getProjectName());
		assertEquals("Manager", request.getProjectManagerName());
		assertEquals("Project Owner", request.getApplicationOwnerName());
		assertEquals(auditDetails, request.getAuditDetails());
	}
}
