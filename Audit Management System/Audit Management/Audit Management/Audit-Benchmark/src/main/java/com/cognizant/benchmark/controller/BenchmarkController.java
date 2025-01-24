package com.cognizant.benchmark.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.benchmark.auth.AuthClient;
import com.cognizant.benchmark.model.AuditBenchmark;
import com.cognizant.benchmark.service.AuditBenchmarkService;
import com.cognizant.benchmark.service.TokenValidationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * -> URL="http://localhost:9093/AuditBenchmark"
 * use get mapping to get the acceptable benchmark value for the audit type.
 *
 */
@RestController
@Api(value="End point for benchmark service")
@CrossOrigin("*")
@Slf4j
public class BenchmarkController {

	@Autowired
	AuthClient authClient;	
	
	@Autowired
    private TokenValidationService tokenValidator;

	@Autowired
	private AuditBenchmarkService benchmarkService;

	/**
	 * This method gives the bench mark value for audit type.
	 * @param token
	 * @return acceptable value
	 */

	@GetMapping("/AuditBenchmark")
	@ApiOperation(value = "acceptable value", notes = "gives the acceptable value based on audit type", httpMethod = "GET", response = ResponseEntity.class)
	public ResponseEntity<?> getBenchmarkMap(@RequestHeader("Authorization") String token){
		log.info("getBenchmarkMap method");
		if(tokenValidator.checkValidity(token)){
			log.info("token validated");
			ResponseEntity<?> responseEntity=null;
			responseEntity = new ResponseEntity<List<AuditBenchmark>>(benchmarkService.fetchBenchmarkList(),HttpStatus.OK);
			return responseEntity;
		}
		else{
			return new ResponseEntity<String>("Token Invalid or expired",HttpStatus.FORBIDDEN);
		}

	}
}