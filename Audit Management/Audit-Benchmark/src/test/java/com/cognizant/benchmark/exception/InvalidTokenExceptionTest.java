package com.cognizant.benchmark.exception;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class InvalidTokenExceptionTest {

	InvalidTokenException exception = new InvalidTokenException("Exception");
    /**
     * Test method to check the in valid token exception class.
     */
	@Test
	 void componentTyepNotFoundExceptionIsLoaded() {
		assertThat(exception).isNotNull();
	}

}
