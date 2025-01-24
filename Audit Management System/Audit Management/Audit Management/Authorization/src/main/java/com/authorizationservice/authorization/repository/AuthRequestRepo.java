package com.authorizationservice.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * This is a jpa repository class for authentication request class.
 */

import com.authorizationservice.authorization.model.AuthenticationRequest;

public interface AuthRequestRepo extends JpaRepository<AuthenticationRequest, String> {

}
