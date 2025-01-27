package com.cognizant.auditchecklistmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.auditchecklistmicroservice.Auth.AuthClient;
import com.cognizant.auditchecklistmicroservice.exception.InvalidTokenException;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TokenValidationServiceImpl implements TokenValidationService {

	 @Autowired
	private AuthClient authClient;

        /**
         * This method validates the token.
         */
	    @Override
	    public boolean checkValidity(String token) {
	        boolean valid = false;
			log.info(token);
			try {
				if (!authClient.getsValidity(token).isValidStatus()) {
					valid=false;
					log.info("Invalid Token");
					throw new InvalidTokenException("Token is either expired or invalid...");
				}
			}
			catch(FeignException e) {
				valid =false;
				throw new InvalidTokenException("Token is either expired or invalid...");
			}
			valid=true;
			return valid;
			}    
}
