package com.cognizant.auditseveritymicroservice.model;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuditHistoryTest {

    private AuditHistory auditHistory;
    
    @BeforeEach
    public void init(){
        auditHistory=new AuditHistory();
    }
    /**
     * Test method to check the set method for audit id. 
     */
    @Test
    public void testGetSetAuditId(){
        auditHistory.setAuditId(1);
        assertEquals(1, auditHistory.getAuditId());
    }
    /**
     * Test method to check the set method for project name. 
     */
    @Test
    public void testGetSetProjectName(){
        auditHistory.setProjectName("Demo Project");
        assertEquals("Demo Project", auditHistory.getProjectName());
    }
    /**
     * Test method to check the set method for project manager name. 
     */
    @Test
    public void testGetSetProjectManagerName(){
        auditHistory.setProjectManagerName("Project Manager Name");
        assertEquals("Project Manager Name", auditHistory.getProjectManagerName());
    }
    /**
     * Test method to check the set method for application owner name. 
     */
    @Test
    public void testGetSetApplicationOwnerName(){
        auditHistory.setApplicatonOwnerName("Application Owner");
        assertEquals("Application Owner", auditHistory.getApplicatonOwnerName());
    }
    /**
     * Test method to check the set method for audit type. 
     */
    @Test
    public void testGetSetAuditType(){
        auditHistory.setAuditType("SOX");
        assertEquals("SOX", auditHistory.getAuditType());
    }
    /**
     * Test method to check the set method for audit date. 
     */
    @Test
    public void testGetSetAuditDate(){
        auditHistory.setAuditDate("2021-07-14");
        assertEquals("2021-07-14", auditHistory.getAuditDate());
    }
    /**
     * Test method to check the set method for audit status. 
     */
    @Test
    public void testGetSetProjectExecutionStatus(){
        auditHistory.setProjectExecutionStatus(true);
        assertTrue(auditHistory.isProjectExecutionStatus());

    }
    /**
     * Test method to check the set method for action to be taken. 
     */
    @Test
    public void testGetSetRemedialActionDuration(){
        auditHistory.setRemedialActionDuration("2weeks");
        assertEquals("2weeks", auditHistory.getRemedialActionDuration());
    }

    
}
