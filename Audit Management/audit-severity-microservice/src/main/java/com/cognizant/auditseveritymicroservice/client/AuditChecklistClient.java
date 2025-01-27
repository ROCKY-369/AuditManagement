package com.cognizant.auditseveritymicroservice.client;

import java.util.List;

import com.cognizant.auditseveritymicroservice.dto.AuditQuestions;
import com.cognizant.auditseveritymicroservice.dto.AuditType;

import io.swagger.annotations.Api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(name="audit-checklist",url="http://localhost:8092/")
@Api(value="Interacting with checklist microservice using feign client")
public interface AuditChecklistClient {
	/**
     * This method is used to interact with checklist microservice.
     * @param token.
     * @return .
     */
	@PostMapping("/AuditCheckListQuestions")
	public ResponseEntity<List<AuditQuestions>> getChecklist(@RequestHeader(name = "Authorization",required = true)String token,@RequestBody AuditType auditType);
}
