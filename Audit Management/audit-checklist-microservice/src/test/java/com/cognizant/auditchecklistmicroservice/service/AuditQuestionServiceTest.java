package com.cognizant.auditchecklistmicroservice.service;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.auditchecklistmicroservice.Model.AuditQuestions;
import com.cognizant.auditchecklistmicroservice.repository.AuditRepository;


@RunWith(SpringRunner.class)
@ContextConfiguration 
@ExtendWith(MockitoExtension.class)
public class AuditQuestionServiceTest {
	
	@Mock
	AuditRepository questionsRespository;
	
	@InjectMocks
	AuditQuestionService auditquestionService;
	/**
	 * Test method to check the get method of questions list.
	 */
	@Test
	public void testGetQuestionsList() throws IndexOutOfBoundsException{
		List<AuditQuestions> questions = new ArrayList<>();
		questions.add(new AuditQuestions(1,"Internal","Have all Change requests followed SDLC before PROD move?","Yes"));
		when(questionsRespository.findByAuditType("Internal")).thenReturn(questions);
		assertNotNull(auditquestionService.getQuestions("Internal"));
	}
	/**
	 * Test method to check the index out of bounds exception in questions list.
	 */
	@Test
	public void testQuestionsListthrowsIndexOutOfBoundsException() {
		List<AuditQuestions> questions = new ArrayList<>();
		when(questionsRespository.findByAuditType("Internal")).thenReturn(questions);
		assertThrows(IndexOutOfBoundsException.class,() -> auditquestionService.getQuestions("Internal"));
	}
	
	/**
	 * Test method to check the saved responses.
	 */
	@Test
	public void testSaveResponses() {
		List<AuditQuestions> questions = new ArrayList<>();
		questions.add(new AuditQuestions(1,"Internal","Have all Change requests followed SDLC before PROD move?","Yes"));
		when(questionsRespository.saveAll(questions)).thenReturn(questions);
		assertNotNull(auditquestionService.saveResponses(questions));
	}

}
