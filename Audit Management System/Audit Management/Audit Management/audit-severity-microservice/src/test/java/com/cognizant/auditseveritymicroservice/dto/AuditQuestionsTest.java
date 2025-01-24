package com.cognizant.auditseveritymicroservice.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuditQuestionsTest {

    private AuditQuestions auditQuestions;

    @BeforeEach
    public void init(){
        auditQuestions = new AuditQuestions();
    }
    /**
     * Test method to check set method of question id. 
     */
    @Test
    public void testGetSetQuestionId(){
        auditQuestions.setQuestionId(1);
        assertEquals(1, auditQuestions.getQuestionId());
    }
    /**
     * Test method to check set method of questions. 
     */
    @Test
    public void testGetSetQuestion(){
        auditQuestions.setQuestion("Sample Question?");
        assertEquals("Sample Question?", auditQuestions.getQuestion());
    }
    /**
     * Test method to check set method of audit type. 
     */
    @Test
    public void testGetSetAuditType(){
        auditQuestions.setAuditType("Internal");
        assertEquals("Internal", auditQuestions.getAuditType());
    }
    /**
     * Test method to check set method of response. 
     */
    @Test
    public void testGetSetResponse(){
        auditQuestions.setResponse("response");
        assertEquals("response", auditQuestions.getResponse());
    }
    /**
     * Test method to check constructor method. 
     */
    @Test
    public void testConstructor(){
        auditQuestions=new AuditQuestions(1,"Internal","Sample Question?","Yes");
        assertEquals(1, auditQuestions.getQuestionId());
        assertEquals("Sample Question?", auditQuestions.getQuestion());
        assertEquals("Internal", auditQuestions.getAuditType());
        assertEquals("Yes", auditQuestions.getResponse());
    }

}
