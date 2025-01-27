package com.cognizant.auditchecklistmicroservice.exception;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TokenExpeiredExceptionTest {
	InvalidTokenException exception = new InvalidTokenException("Exception");
	/**
     * Test method to check the invalid token exception method. 
     */
		@Test
		 void componentTyepNotFoundExceptionIsLoaded() {
			assertThat(exception).isNotNull();
		}

}
