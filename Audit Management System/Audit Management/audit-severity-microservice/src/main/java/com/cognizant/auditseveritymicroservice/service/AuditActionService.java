package com.cognizant.auditseveritymicroservice.service;

import java.util.List;



import com.cognizant.auditseveritymicroservice.dto.AuditBenchmark;
import com.cognizant.auditseveritymicroservice.dto.AuditQuestions;
import com.cognizant.auditseveritymicroservice.dto.AuditRequest;
import com.cognizant.auditseveritymicroservice.dto.AuditResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuditActionService {

    @Autowired
    private AuditSeverityService severityService;
    
    /**
     * This method will take the accepted value of no's from bench mark microservice and returns the status
     * and action needed to be taken based on no's. 
     * @param benchmarkList
     * @param questionsList
     * @param auditRequest
     * @return response
     */
    public AuditResponse predictAction(List<AuditBenchmark> benchmarkList,List<AuditQuestions> questionsList,AuditRequest auditRequest){

            int acceptedNoAnswers=0;
            int actualNoAnswers=0;
			severityService.acceptRequest(auditRequest);
            AuditResponse response=null;
			for(AuditBenchmark benchmark: benchmarkList) {	
				if(benchmark.getAuditType().equalsIgnoreCase(auditRequest.getAuditDetails().getAuditType())) {					
					acceptedNoAnswers = benchmark.getNoAnswersNum();
				}
			}
            for(AuditQuestions question: questionsList) {	
				if(question.getResponse().equalsIgnoreCase("No")) {
					actualNoAnswers++;
				}
			}
            if(actualNoAnswers<=acceptedNoAnswers) {
				response = new AuditResponse("GREEN","No action needed");
				severityService.acceptResponse(response);
			}else if(auditRequest.getAuditDetails().getAuditType().equalsIgnoreCase("Internal")) {
				response = new AuditResponse("RED","Action to be taken in 2 weeks");
				severityService.acceptResponse(response);
			}else if(auditRequest.getAuditDetails().getAuditType().equalsIgnoreCase("SOX")) {
				response = new AuditResponse("RED","Action to be taken in 1 week");
				severityService.acceptResponse(response);
			}
            return response;
    }
    
}
