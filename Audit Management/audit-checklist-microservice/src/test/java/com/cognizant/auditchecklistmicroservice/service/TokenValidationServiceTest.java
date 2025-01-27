package com.cognizant.auditchecklistmicroservice.service;



import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.cognizant.auditchecklistmicroservice.Auth.AuthClient;
import com.cognizant.auditchecklistmicroservice.DTO.ValidatingDTO;
import com.cognizant.auditchecklistmicroservice.exception.InvalidTokenException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@ExtendWith(MockitoExtension.class)
public class TokenValidationServiceTest {
	
	@Mock
	AuthClient authClient;
	
	@Mock
	ValidatingDTO validity;
	
	@Mock
	ResponseEntity<ValidatingDTO> entity;
	
	@InjectMocks
	TokenValidationServiceImpl tokenService;
 
	/**
	 * test to check the validity of token when token is valid 
	 */
	@Test
	public void testCheckTokenValidityWhenTokenIsValid() {		
		when(authClient.getsValidity("token")).thenReturn(new ValidatingDTO(true));
		assertEquals(true, tokenService.checkValidity("token"));
	

	}
	/**
	 * test to check the validity of token when token gives null pointer exception
	 */
	@Test
	public void testCheckTokenValidityWhenTokenNullPointerException() {
        when(authClient.getsValidity("token")).thenReturn(null);
		assertThrows(NullPointerException.class,()->tokenService.checkValidity("token"));
	}
	/**
	 * test to check the validity of token when token is invalid
	 */
	@Test
	public void testCheckTokenValidityWhenTokenIsInvalid() {
		
        when(authClient.getsValidity("token")).thenReturn(new ValidatingDTO(false));
        assertThrows(InvalidTokenException.class,()->tokenService.checkValidity("token"));
	
		
    }

}