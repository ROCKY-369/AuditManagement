package com.cognizant.benchmark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.benchmark.auth.AuthClient;
import com.cognizant.benchmark.exception.InvalidTokenException;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TokenValidationServiceImpl implements TokenValidationService{

    @Autowired
    private AuthClient authClient;

    /**
     * this is exception service class where all the exceptions are handled here.
     * @param 
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
            log.info("Exception",e);
            valid =false;
			throw new InvalidTokenException("Token is either expired or invalid...");
		}
        log.info("Token is valid");
        valid=true;
		return valid;
    }    
}
