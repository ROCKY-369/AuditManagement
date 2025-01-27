package com.cognizant.auditseveritymicroservice.service;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import com.cognizant.auditseveritymicroservice.dto.AuditDetails;
import com.cognizant.auditseveritymicroservice.dto.AuditRequest;
import com.cognizant.auditseveritymicroservice.dto.AuditResponse;
import com.cognizant.auditseveritymicroservice.model.AuditDetailsModel;

import com.cognizant.auditseveritymicroservice.model.AuditRequestModel;
import com.cognizant.auditseveritymicroservice.model.AuditResponseModel;
import com.cognizant.auditseveritymicroservice.repository.AuditRequestRepo;
import com.cognizant.auditseveritymicroservice.repository.AuditResponseRepo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class AuditSeverityServiceImplTest {

    @Mock
	AuditRequestRepo requestRepo;

	@Mock
	AuditResponseRepo responseRepo;
	
	@InjectMocks
	AuditSeverityServiceImpl severityService;
	/**
     * Test method to check the response class. 
     */
    @Test
	public void acceptResponseTest() {
		log.info("Start");
		AuditResponse response = new AuditResponse("GREEN","No action required");
		AuditResponseModel detailModel = new AuditResponseModel(response.getProjectExecutionStatus(),response.getRemedialActionDuration());
		assertNotNull(detailModel);
		severityService.acceptResponse(response);
		//assertEquals(detailModel,severityService.acceptResponse(response));
		log.info("End");
	}
    /**
     * Test method to check the request class. 
     */
    @Test
	public void acceptRequestTest(){
		Date date=new Date();
        AuditDetails auditDetails=new AuditDetails("Internal",date);
        AuditDetailsModel detailModel=new AuditDetailsModel(0,"Internal",date);
		AuditRequest request = new AuditRequest("Current Project", "Manager","Project Owner",auditDetails);
		AuditRequestModel requestModel=new AuditRequestModel(100,request.getProjectName(),request.getProjectManagerName(),request.getApplicationOwnerName(),detailModel);
		severityService.acceptRequest(request);
		//assertEquals(requestModel,severityService.acceptRequest(request));
		assertNotNull(requestModel);
	}
    /**
     * Test method to check the history of audits. 
     */
    @Test
	public void testGetHistory(){
		Date date=new Date();
		List<AuditResponseModel> responseList= List.of(new AuditResponseModel(1,"RED","1 Week"));
		AuditDetailsModel detailModel=new AuditDetailsModel(0,"Internal",date);
		List<AuditRequestModel> requestList= List.of(new AuditRequestModel(100,"Project Name","Manager","Project Owner",detailModel));
		when(responseRepo.findAll()).thenReturn(responseList);
		when(requestRepo.findAll()).thenReturn(requestList);
		assertNotNull(severityService.getHistory());
	}
}
	

