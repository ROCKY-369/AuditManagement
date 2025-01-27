package com.cognizant.controller;

import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.auditchecklistmicroservice.Auth.AuthClient;
import com.cognizant.auditchecklistmicroservice.Controller.AuditChecklistController;
import com.cognizant.auditchecklistmicroservice.Model.AuditQuestions;
import com.cognizant.auditchecklistmicroservice.Model.AuditType;
import com.cognizant.auditchecklistmicroservice.repository.AuditRepository;
import com.cognizant.auditchecklistmicroservice.service.AuditQuestionService;
import com.cognizant.auditchecklistmicroservice.service.TokenValidationService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


import lombok.extern.slf4j.Slf4j;
/**
 * 		 	This class contains test cases for the AuthController
 *          class which are written using junit and mockito
 */
@RunWith(SpringRunner.class)
@ContextConfiguration 
@Slf4j
@ExtendWith(MockitoExtension.class)
public class AuditCheckListControllerTest {

	@Mock
	AuthClient authClient;
	
	@Mock
	TokenValidationService tokenService;
	
	@Mock
	AuditType auditType;
	
	@Mock
	AuditQuestionService questionsService;
	
	
	@InjectMocks
	AuditChecklistController auditCheckListController;
	
	@Mock
	AuditRepository questionsRepository;
	
	@Test
	public void contextLoads() {
		assertNotNull(auditCheckListController);
	}
	/**
	 * To test testGetCheckList method
	 */
	@Test
	public void testGetChecklist() {
		log.info("checklist test starts");
		ResponseEntity<?> responseEntity = null;
		List<AuditQuestions> questionsList = new ArrayList<>();
		questionsList.add(new AuditQuestions(1,"Internal","How are you","Yes"));
		auditType=new AuditType("Internal");
		when(tokenService.checkValidity("token")).thenReturn(true);
		when(questionsService.getQuestions("Internal")).thenReturn(questionsList);
		responseEntity = auditCheckListController.getChecklist("token", auditType);
		assertNotNull(responseEntity);
		log.info("checklist test ends");
	}
	
	@Test
	public void testGetChecklistTokenInvalid() {
		ResponseEntity<?> responseEntity = null;
		when(tokenService.checkValidity("token")).thenReturn(false);
		responseEntity = auditCheckListController.getChecklist("token", auditType);
		assertEquals(HttpStatus.FORBIDDEN,responseEntity.getStatusCode());
	}
	
	
	
	@Test
	public void testSaveResponses() {
		List<AuditQuestions> questionsList = new ArrayList<AuditQuestions>();
		questionsList.add(new AuditQuestions(1,"Internal","How are you","Yes"));
		when(tokenService.checkValidity("token")).thenReturn(true);
		assertEquals(HttpStatus.OK,auditCheckListController.saveResponses("token", questionsList).getStatusCode());
	}
	
	@Test
	public void testSaveResponseTokenInvalid() {
		ResponseEntity<?> responseEntity = null;
		List<AuditQuestions> questionsList = new ArrayList<AuditQuestions>();
		questionsList.add(new AuditQuestions(1,"Internal","How are you","Yes"));
		when(tokenService.checkValidity("token")).thenReturn(false);
		responseEntity = auditCheckListController.saveResponses("token",questionsList);
		assertEquals(HttpStatus.FORBIDDEN,responseEntity.getStatusCode());
	}
	
	
	
	
}
