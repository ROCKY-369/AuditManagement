package com.cognizant.auditseveritymicroservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuditDetailsModelTest {

    private AuditDetailsModel detailModel;
	
	@BeforeEach
	public void init() {
		detailModel = new AuditDetailsModel();
	}
	/**
     * Test method to check the set method for audit type. 
     */
	@Test
	public void testGetSetAuditType() {
		detailModel.setAuditType("Internal");
		assertEquals("Internal", detailModel.getAuditType());
	}
	/**
     * Test method to check the set method for audit date. 
     */
	@Test
	public void testGetSetAuditDate() {
		Date date = new Date();
		detailModel.setAuditDate(date);
		assertEquals(date, detailModel.getAuditDate());
	}
	/**
     * Test method to check the set method for audit id. 
     */
	@Test
	public void testGetAuditId() {
		detailModel.setAuditId(0);
		assertEquals(0, detailModel.getAuditId());
	}
	/**
     * Test method to check the SingleArgsConstructor annotation. 
     */
	@Test
	public void testSingleArgsConstructor(){
		detailModel=new AuditDetailsModel("Internal");
		assertEquals("Internal", detailModel.getAuditType());
	}
	/**
     * Test method to check the AllArgsConstructor annotation. 
     */
	@Test
	public void testAllArgsConstructor(){
		Date date = new Date();
		detailModel=new AuditDetailsModel(0,"Internal",date);
		assertEquals(0, detailModel.getAuditId());
		assertEquals("Internal", detailModel.getAuditType());
		assertEquals(date, detailModel.getAuditDate());
	}

}
