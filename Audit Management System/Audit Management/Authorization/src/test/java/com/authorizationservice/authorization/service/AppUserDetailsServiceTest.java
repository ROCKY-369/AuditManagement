package com.authorizationservice.authorization.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import com.authorizationservice.authorization.model.AuthenticationRequest;
import com.authorizationservice.authorization.repository.AuthRequestRepo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(classes = AppUserDetailsService.class)
@Slf4j
public class AppUserDetailsServiceTest {

    @MockBean
    private AuthRequestRepo userRepo;

    @Autowired
    private AppUserDetailsService userService;
    /**
     * Test method to load the user by user name.
     */
    @Test
    void testloadUserByUsername() {
        log.info("Entering test");
        AuthenticationRequest user = new AuthenticationRequest("admin", "admin");
        when(userRepo.findById("admin")).thenReturn(Optional.of(user));
        UserDetails userDetails = new User("admin", "admin", new ArrayList<>());
        assertEquals(userDetails, userService.loadUserByUsername("admin"));
        log.info("Exiting test");
    }
    /**
     * Test method to check whether user details are loading or not.
     */
    @Test
    @DisplayName("Checking for AppUserDetailsService - if it is loading or not")
    public void appUserDetailsServiceNotNullTest() {
        log.info("Entering test");
        assertThat(userService).isNotNull();
    }
}
