package com.cognizant.auditseveritymicroservice.exception;

import static org.assertj.core.api.Assertions.assertThat;

import com.cognizant.auditseveritymicroservice.exceptions.InvalidTokenException;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class InvalidTokenExceptionTest {

	InvalidTokenException exception = new InvalidTokenException("Exception");
	/**
     * Test method to check the invalid token exception method. 
     */
	@Test
	 void componentTyepNotFoundExceptionIsLoaded() {
		assertThat(exception).isNotNull();
	}

}
