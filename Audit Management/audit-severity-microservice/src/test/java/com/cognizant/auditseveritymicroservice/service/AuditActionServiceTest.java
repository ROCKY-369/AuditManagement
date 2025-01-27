package com.cognizant.auditseveritymicroservice.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import com.cognizant.auditseveritymicroservice.dto.AuditBenchmark;
import com.cognizant.auditseveritymicroservice.dto.AuditDetails;
import com.cognizant.auditseveritymicroservice.dto.AuditQuestions;
import com.cognizant.auditseveritymicroservice.dto.AuditRequest;
import com.cognizant.auditseveritymicroservice.dto.AuditResponse;
import com.cognizant.auditseveritymicroservice.model.AuditRequestModel;
import com.cognizant.auditseveritymicroservice.model.AuditResponseModel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AuditActionServiceTest {
	
	@Mock
	AuditSeverityService service;
	
	@InjectMocks
	AuditActionService action;
	/**
     * Test method to check the audit details, responses and status of audit. 
     */
	@Test
    public void testPredictAction(){
        List<AuditBenchmark> benchmarkList = List.of(
            new AuditBenchmark("Internal",3),
            new AuditBenchmark("SOX",1)
        );
        List<AuditQuestions> questionsList= List.of(
            new AuditQuestions(1,"Internal","Question 1","Yes"),
            new AuditQuestions(2,"Internal","Question 2","No"),
            new AuditQuestions(3,"Internal","Question 3","No"),
            new AuditQuestions(4,"Internal","Question 4","Yes"),
            new AuditQuestions(5,"Internal","Question 5","No")
        );
        
        AuditRequestModel model1=new AuditRequestModel();
        AuditResponseModel model2=new AuditResponseModel();
        Date date=new Date();
        AuditDetails auditDetails=new AuditDetails("Internal",date);
		AuditRequest request = new AuditRequest("Current Project", "Manager","Project Owner",auditDetails);
        
		when(service.acceptRequest(Mockito.any(AuditRequest.class))).thenReturn(model1);
        when(service.acceptResponse(Mockito.any(AuditResponse.class))).thenReturn(model2);
        
        AuditResponse response=action.predictAction(benchmarkList, questionsList, request);
        assertEquals("GREEN", response.getProjectExecutionStatus());

        questionsList= List.of(
            new AuditQuestions(1,"Internal","Question 1","Yes"),
            new AuditQuestions(2,"Internal","Question 2","No"),
            new AuditQuestions(3,"Internal","Question 3","No"),
            new AuditQuestions(4,"Internal","Question 4","No"),
            new AuditQuestions(5,"Internal","Question 5","No"));

        auditDetails=new AuditDetails("Internal",date);
        request = new AuditRequest("Current Project", "Manager","Project Owner",auditDetails);
        
        when(service.acceptRequest(Mockito.any(AuditRequest.class))).thenReturn(model1);
        when(service.acceptResponse(Mockito.any(AuditResponse.class))).thenReturn(model2);
        
        response=action.predictAction(benchmarkList, questionsList, request);
        assertEquals("RED", response.getProjectExecutionStatus());

        questionsList= List.of(
            new AuditQuestions(1,"SOX","Question 1","Yes"),
            new AuditQuestions(2,"SOX","Question 2","No"),
            new AuditQuestions(3,"SOX","Question 3","No"),
            new AuditQuestions(4,"SOX","Question 4","No"),
            new AuditQuestions(5,"SOX","Question 5","No"));

        auditDetails=new AuditDetails("SOX",date);
        request = new AuditRequest("Current Project", "Manager","Project Owner",auditDetails);
        
        when(service.acceptRequest(Mockito.any(AuditRequest.class))).thenReturn(model1);
        when(service.acceptResponse(Mockito.any(AuditResponse.class))).thenReturn(model2);
        
        response=action.predictAction(benchmarkList, questionsList, request);
        assertEquals("RED", response.getProjectExecutionStatus());


    }
    
}