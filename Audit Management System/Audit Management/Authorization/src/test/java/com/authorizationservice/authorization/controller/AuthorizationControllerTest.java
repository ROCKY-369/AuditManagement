package com.authorizationservice.authorization.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.authorizationservice.authorization.exceptions.LoginException;
import com.authorizationservice.authorization.model.AuthenticationRequest;
import com.authorizationservice.authorization.repository.AuthRequestRepo;
import com.authorizationservice.authorization.service.AppUserDetailsService;
import com.authorizationservice.authorization.util.JwtUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class AuthorizationControllerTest {

	@Mock                 // to create and inject mocked instances
	private JwtUtil jwtUtil;

	@Mock
	private AppUserDetailsService appUserDetailsService;

	@Mock
	private AuthRequestRepo authRequestRepo;

	@InjectMocks
	private AuthorizationController authenticationController;
    /**
     * Test method to check the valid user login credentials.
     * @throws LoginException
     */
	@Test
	void testValidLogin() throws LoginException {
		log.info("Entering test");
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("user", "user123");
		UserDetails userDetails = new User(authenticationRequest.getUserName(), authenticationRequest.getPassword(),
				new ArrayList<>());

		when(appUserDetailsService.loadUserByUsername("user")).thenReturn(userDetails);
		when(jwtUtil.generateToken(userDetails)).thenReturn("dummy-token");

		ResponseEntity<Object> authenticationResponse = authenticationController
				.createAuthorizationToken(authenticationRequest);
		assertEquals(HttpStatus.OK, authenticationResponse.getStatusCode());
		log.info("Exiting test");
	}

    /**
     * Test method to check the invalid user login credentials.
     */
	@Test
	void testInvalidLogin() {
		log.info("Entering test");
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("user", "user123");
		UserDetails userDetails = new User(authenticationRequest.getUserName(), "user", new ArrayList<>());
		
		when(appUserDetailsService.loadUserByUsername("user")).thenReturn(userDetails);
		Exception exception = Assertions.assertThrows(LoginException.class,
				() -> authenticationController.createAuthorizationToken(authenticationRequest));
		assertEquals("Invalid Username or Password", exception.getMessage());
		log.info("Exiting test");
	}
    /**
     * Test method to check the valid token.
     */
	@Test
	void testValidToken() {
		log.info("Entering test");
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("user", "user123");
		UserDetails userDetails = new User(authenticationRequest.getUserName(), authenticationRequest.getPassword(),
				new ArrayList<>());

		when(jwtUtil.validateToken("token", userDetails)).thenReturn(true);
		when(jwtUtil.extractUsername("token")).thenReturn("user");
		when(appUserDetailsService.loadUserByUsername("user")).thenReturn(userDetails);

		ResponseEntity<?> validity = authenticationController.validatingAuthorizationToken("Bearer token");
		assertTrue(validity.getBody().toString().contains("true"));
		log.info("Exiting test");
	}
    /**
     * Test method to check the invalid token.
     */
	@Test
	void testInvalidToken() {
		log.info("Entering test");
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("user", "user123");
		UserDetails userDetails = new User(authenticationRequest.getUserName(), authenticationRequest.getPassword(),
				new ArrayList<>());

		when(jwtUtil.validateToken("token", userDetails)).thenReturn(false);
		when(jwtUtil.extractUsername("token")).thenReturn("user");
		when(appUserDetailsService.loadUserByUsername("user")).thenReturn(userDetails);

		ResponseEntity<?> validity = authenticationController.validatingAuthorizationToken("Bearer token");
		assertEquals(true, validity.getBody().toString().contains("false"));
		log.info("Exiting test");
	}
    /**
     * Test method to check the token when the signature is invalid.
     */
	@Test
	void testInvalidTokenWhenSignatureInvalid() {
		log.info("Entering test");
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("user", "user123");
		UserDetails userDetails = new User(authenticationRequest.getUserName(), authenticationRequest.getPassword(),
				new ArrayList<>());

		when(jwtUtil.validateToken("token", userDetails)).thenThrow(SignatureException.class);
		when(jwtUtil.extractUsername("token")).thenReturn("user");
		when(appUserDetailsService.loadUserByUsername("user")).thenReturn(userDetails);

		ResponseEntity<?> validity = authenticationController.validatingAuthorizationToken("Bearer token");
		assertEquals(true, validity.getBody().toString().contains("false"));
		log.info("Exiting test");
	}
}
