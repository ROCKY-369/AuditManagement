package com.cognizant.auditseveritymicroservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuditRequestModelTest {
    private AuditRequestModel request;
	
	@BeforeEach
	public void setup() {
		request = new AuditRequestModel();
	}
	/**
     * Test method to check the set method for project name. 
     */
	@Test
	public void testGetSetProjectName() {
		request.setProjectName("Project Name");
		assertEquals("Project Name", request.getProjectName());
	}
	/**
     * Test method to check the set method for project manager name. 
     */
	@Test
	public void testGetSetProjectManagerName() {
		request.setProjectManagerName("Manager");
		assertEquals("Manager", request.getProjectManagerName());
	}
	/**
     * Test method to check the set method for owner name. 
     */
	@Test
	public void testGetSetOwnerName() {
		request.setApplicatonOwnerName("Project Owner");
		assertEquals("Project Owner", request.getApplicatonOwnerName());
	}
	/**
     * Test method to check the set method for audit request id. 
     */
	@Test
	public void testGetRequestId() {
        request.setRequestId(100);
		assertEquals(100, request.getRequestId());
	}
	/**
     * Test method to check the constructor method. 
     */
	@Test
	public void testConstructor(){
		Date date = new Date();
		AuditDetailsModel detailModel=new AuditDetailsModel(0,"Internal",date);
		request=new AuditRequestModel(100,"Project Name","Manager","Project Owner",detailModel);
		assertEquals(100, request.getRequestId());
		assertEquals("Project Name", request.getProjectName());
		assertEquals("Manager", request.getProjectManagerName());
		assertEquals("Project Owner", request.getApplicatonOwnerName());
		assertEquals(detailModel,request.getAuditDetails());
	}


    
}
