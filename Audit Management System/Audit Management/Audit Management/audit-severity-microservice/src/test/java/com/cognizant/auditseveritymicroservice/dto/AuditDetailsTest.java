package com.cognizant.auditseveritymicroservice.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuditDetailsTest {

    private AuditDetails auditDetails;

    @BeforeEach
    public void init(){
        auditDetails = new AuditDetails();
    }
    /**
     * Test method to check set method of audit type. 
     */
    @Test
    public void testGetSetAuditType(){
        auditDetails.setAuditType("Internal");
        assertEquals("Internal",auditDetails.getAuditType());

    }
    /**
     * Test method to check set method of audit date. 
     */
    @Test
    public void testGetSetAuditDate(){
        Date date=new Date();
        auditDetails.setAuditDate(date);
        assertEquals(date, auditDetails.getAuditDate());
    }
    /**
     * Test method to check constructor method. 
     */
    @Test
    public void testConstructor(){
        Date date=new Date();
        auditDetails=new AuditDetails("Internal",date);
        assertEquals("Internal",auditDetails.getAuditType());
        assertEquals(date, auditDetails.getAuditDate());
    }

}
