package com.cognizant.auditseveritymicroservice.auth;

import com.cognizant.auditseveritymicroservice.dto.ValidatingDTO;

import io.swagger.annotations.Api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(name = "auth-client", url = "http://localhost:8008/authorization")
@Api(value="validating the user authentication using JWT token")
public interface AuthClient {
	 /**
	  * This method validates the token.
	  * @param token.
	  * @return .
	  */
	 @GetMapping(value = "/validate")
     public ValidatingDTO getsValidity(@RequestHeader(name = "Authorization", required = true) String token);

}