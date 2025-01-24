package com.cognizant.auditchecklistmicroservice.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import org.springframework.web.bind.annotation.RestController;

import com.cognizant.auditchecklistmicroservice.Auth.AuthClient;
import com.cognizant.auditchecklistmicroservice.Model.AuditQuestions;
import com.cognizant.auditchecklistmicroservice.Model.AuditType;
import com.cognizant.auditchecklistmicroservice.service.AuditQuestionService;
import com.cognizant.auditchecklistmicroservice.service.TokenValidationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
/**
 * -> URL="http://localhost:8092/AuditCheckListQuestions"
 * we use post mapping to give the list of questions to be answered.
 *
 *-> URL="http://localhost:8092/saveResponses"
 * we use post mapping to give responses to list of questions.
 */


@RestController
@Api(value="End point to give the list of questions based on audit type")
@CrossOrigin("*")
@Slf4j
public class AuditChecklistController {
   
	@Autowired
	private TokenValidationService tokenValidator;
	
	@Autowired
	AuthClient authClient;
	
	@Autowired
	AuditQuestionService questionsService;
	/**
	 * This method validates the token and it displays the list of questions based on audit type.
	 * @param token
	 * @param auditType
	 * @return ListOfQuestions
	 */
	@PostMapping("/AuditCheckListQuestions")
	@ApiOperation(value = "List Of Questions", notes = "gives List of questions to answer based on audit type", httpMethod = "POST", response = ResponseEntity.class)
	public ResponseEntity<?> getChecklist(@RequestHeader(name = "Authorization",required = true)String token,@RequestBody AuditType auditType){
		log.info("getChecklist method");
		if(tokenValidator.checkValidity(token)) {
			log.info("token validated");
			List<AuditQuestions> questionsList = new ArrayList<>();
			ResponseEntity<?> responseEntity;
			try {
				questionsList = questionsService.getQuestions(auditType.getAuditType());
			}catch(IndexOutOfBoundsException e) {
				responseEntity= new ResponseEntity<String>("Internal Server Error",HttpStatus.INTERNAL_SERVER_ERROR);
				return responseEntity;
			}
			responseEntity = new ResponseEntity<List<AuditQuestions>>(questionsList,HttpStatus.OK);
			return responseEntity;
		}
		else {
			log.error("token expired");
			return new ResponseEntity<String>("Token Invalid or expired",HttpStatus.FORBIDDEN);
		}
		
	}
	/**
	 * This method takes the responses for the questions.
	 * @param token
	 * @param questionsResponse
	 * @return responses
	 */
	@PostMapping("/saveResponses")
	@ApiOperation(value = "Saved Responses", notes = "saves the responses given to question", httpMethod = "POST", response = ResponseEntity.class)
	public ResponseEntity<?> saveResponses(@RequestHeader(name = "Authorization",required = true)String token,@RequestBody List<AuditQuestions> questionsResponse){
		log.info("saveResponse method called");
		if(tokenValidator.checkValidity(token)) {
			log.info("token validated");
			List<AuditQuestions> questionsList = new ArrayList<>();
			ResponseEntity<?> responseEntity;
			questionsList = questionsService.saveResponses(questionsResponse);
			responseEntity = new ResponseEntity<List<AuditQuestions>>(questionsList,HttpStatus.OK);

			return responseEntity;
		}
		else {
			log.error("token expired");
			return new ResponseEntity<String>("Token Invalid or expired",HttpStatus.FORBIDDEN);
		}
	}
	
}
