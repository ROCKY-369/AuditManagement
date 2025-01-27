package com.cognizant.auditchecklistmicroservice.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@ContextConfiguration

public class AuditQuestionsTest {
	
	AuditQuestions questions = new AuditQuestions();
	/**
     * Test method to check the Audit Questions Constructor. 
     */
	@Test
	public void testAuditQuestionsConstructor() {
		assertNotNull(questions);
	}
	/**
     * Test method to check the Audit Parameterized Questions Constructor. 
     */
	@Test
	public void testAuditQuestionsParameterizedConstructor() {
		AuditQuestions parameterizedQuestions = new AuditQuestions(1,"Internal","Is data deleted with permission of user?","Yes");
		assertEquals("Internal",parameterizedQuestions.getAuditType());
	}
	/**
	 * Test method to check the set method of questions id.
	 */
	@Test
	public void testSetQUestionId() {
		questions.setQuestionId(2);
		assertEquals(2,questions.getQuestionId().intValue());
	}
	/**
	 * Test method to check the audit type.
	 */
	@Test
	public void testAuditType() {
		questions.setAuditType("SOX");
		assertEquals("SOX",questions.getAuditType());
	}
	/**
	 * Test method to check the questions.
	 */
	@Test
	public void testQuestion() {
		questions.setQuestion("How are you");
		assertEquals("How are you",questions.getQuestion());
	}
	/**
	 * Test method to test the responses.
	 */
	@Test
	public void testResponse() {
		questions.setResponse("No");
		assertEquals("No",questions.getResponse());
	}

}
