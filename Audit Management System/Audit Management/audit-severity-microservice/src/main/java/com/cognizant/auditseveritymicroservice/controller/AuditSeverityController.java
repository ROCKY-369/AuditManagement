package com.cognizant.auditseveritymicroservice.controller;

import java.util.List;

import com.cognizant.auditseveritymicroservice.client.AuditBenchmarkClient;
import com.cognizant.auditseveritymicroservice.client.AuditChecklistClient;
import com.cognizant.auditseveritymicroservice.dto.AuditBenchmark;
import com.cognizant.auditseveritymicroservice.dto.AuditQuestions;
import com.cognizant.auditseveritymicroservice.dto.AuditRequest;
import com.cognizant.auditseveritymicroservice.dto.AuditResponse;
import com.cognizant.auditseveritymicroservice.dto.AuditType;
import com.cognizant.auditseveritymicroservice.model.AuditHistory;
import com.cognizant.auditseveritymicroservice.service.AuditActionService;
import com.cognizant.auditseveritymicroservice.service.AuditSeverityService;
import com.cognizant.auditseveritymicroservice.service.TokenValidationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
/**
 * -> URL="http:localhost:8009/ProjectExecutionStatus".
 * Use post mapping to give details.
 * Provide the audit type, Manager Name, application owner name and project name in body in json format.
 * It returns the status of the audit.
 * 
 * We use get mapping to get the audit info.
 */
@RestController
@Api(value="End point for severity microservice to perform audit execution process")
@CrossOrigin("*")
@Slf4j
public class AuditSeverityController {
    
    @Autowired
    private TokenValidationService tokenValidator;

    @Autowired
    private AuditBenchmarkClient benchmarkClient;

    @Autowired
    private AuditChecklistClient checklistClient;

	@Autowired
	private AuditActionService auditaction;

    @Autowired
    private AuditSeverityService severityService;
    /**
     * This method gives the status of audit based on questions answered.
     * @param token.
     * @param auditRequest.
     * @return response.
     */
    @PostMapping("/ProjectExecutionStatus")
    @ApiOperation(value = "Audit info", notes = "takes user Audit details like project Name, Manager Name, and owner Name after answering the list of questions", httpMethod = "POST", response = ResponseEntity.class)
	public ResponseEntity<?> auditSeverityCheck(@ApiParam (name = "Audit Info", value = "Audit details of the user")@RequestHeader(name = "Authorization",required = true)String token,@RequestBody AuditRequest auditRequest) {
        log.info("auditSeverityCheck called");
        if(tokenValidator.checkValidity(token)){
            log.info("token validated");
            List<AuditBenchmark> benchmarkList = benchmarkClient.getBenchmarkMap(token).getBody();	
			AuditType auditType=new AuditType(auditRequest.getAuditDetails().getAuditType());
			List<AuditQuestions> questionsList = (checklistClient.getChecklist(token, auditType)).getBody();
			AuditResponse response=auditaction.predictAction(benchmarkList, questionsList, auditRequest);
			return new ResponseEntity<AuditResponse>(response,HttpStatus.OK);
        }
		else{
            log.error("token expired");
			return new ResponseEntity<String>("Token Invalid or expired",HttpStatus.FORBIDDEN);
		}
    }
    /**
     * This method gets the deatils of all audits done. 
     * @param token.
     * @return audit history.
     */
    @GetMapping("/getAuditHistory")
    @ApiOperation(value = "Audit info", notes = "gives user Audit details like project Name, Manager Name, Date and owner Name", httpMethod = "GET", response = ResponseEntity.class)
    public ResponseEntity<?> auditHistory(@ApiParam (name = "Audit Info", value = "get Audit details of the user")@RequestHeader(name = "Authorization",required = true)String token){
        if(tokenValidator.checkValidity(token)){
            List<AuditHistory> historyList=severityService.getHistory();
            return new ResponseEntity<List<AuditHistory>>(historyList,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Token Invalid or expired",HttpStatus.FORBIDDEN);
        }
    }
}
