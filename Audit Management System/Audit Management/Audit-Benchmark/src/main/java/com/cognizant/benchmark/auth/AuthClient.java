package com.cognizant.benchmark.auth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.benchmark.dto.ValidatingDTO;

import io.swagger.annotations.Api;

@FeignClient(name = "auth-client", url = "http://localhost:8008/authorization")
@Api(value="validating authentication")
public interface AuthClient {
	
	/**
	 * This method validates the token.
	 * @param token
	 * @return ValidatingDTO
	 */
	@GetMapping(value = "/validate")
	public ValidatingDTO getsValidity(@RequestHeader(name="Authorization",required=true) String token) ;


}

	
