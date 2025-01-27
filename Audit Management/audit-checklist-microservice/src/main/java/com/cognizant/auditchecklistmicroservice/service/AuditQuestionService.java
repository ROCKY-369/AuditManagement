package com.cognizant.auditchecklistmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.auditchecklistmicroservice.Model.AuditQuestions;
import com.cognizant.auditchecklistmicroservice.repository.AuditRepository;

@Service
public class AuditQuestionService {
		
		@Autowired
		AuditRepository auditRepository;
		/**
		 * this methods checks the audit type. 
		 * @param auditType
		 * @return
		 * @throws IndexOutOfBoundsException
		 */
		public List<AuditQuestions> getQuestions(String auditType) throws IndexOutOfBoundsException {

			if(auditRepository.findByAuditType(auditType).isEmpty()) {
				throw new IndexOutOfBoundsException();
			}
			return auditRepository.findByAuditType(auditType);
		}
		/**
		 * This method saves the responses of questions.
		 * @param questionsResponse
		 * @return saved responses
		 */
		public List<AuditQuestions> saveResponses(List<AuditQuestions> questionsResponse) {

			return auditRepository.saveAll(questionsResponse);
		}
}


