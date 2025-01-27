package com.cognizant.auditseveritymicroservice.client;

import java.util.List;

import com.cognizant.auditseveritymicroservice.dto.AuditBenchmark;

import io.swagger.annotations.Api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(name="audit-benchmark",url="http://localhost:9093/")
@Api(value="Interacting with benchmark microservice using feign client")
public interface AuditBenchmarkClient {
    /**
     * This method is used to interact with benchmark microservice.
     * @param token.
     * @return .
     */
	@GetMapping("/AuditBenchmark")
	public ResponseEntity<List<AuditBenchmark>> getBenchmarkMap(@RequestHeader("Authorization") String token);
}
