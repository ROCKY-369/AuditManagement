package com.authorizationservice.authorization.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootApplication
public class AuthenticationRequestTest
{
   @Autowired
   @Mock
   private AuthenticationRequest authenticationRequest;
   /**
    * Test method to check the authentication request.
    */
   @Test
   @DisplayName("Checking for AuthenticationRequest - if it is loading or not")
   public void authenticationRequestNotNullTest(){
       assertThat(authenticationRequest).isNull();
   }
    /**
     * Test method to check the user login bean.
     */
	@Test
	void testUserLoginBean() {
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(AuthenticationRequest.class);
	}

    /**
     * Test method to check the user token bean.
     */
	@Test
	void testUserTokenBean() {
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(AuthenticationResponse.class);
	}
    /**
     * Test method to verify user token.
     */
	@Test
	void testUserTokenEqualsAndHashCode2() {
		EqualsVerifier.simple().forClass(AuthenticationResponse.class).verify();
	}
    /**
     * Test method to check user login credentials.
     */
	@Test
	void testUserLoginAllArgs() {
		AuthenticationRequest authenticationRequest = new AuthenticationRequest("user", "dummy");
		assertEquals("user", authenticationRequest.getUserName());
		assertEquals("dummy", authenticationRequest.getPassword());
	}
    /**
     * Test method to check the user token.
     */
	@Test
	void testUserTokenAllArgs() {
		AuthenticationResponse authenticationResponse = new AuthenticationResponse("user", "token");
		assertEquals("user", authenticationResponse.getUserName());
		assertEquals("token", authenticationResponse.getJwtAuthToken());
	}
}
