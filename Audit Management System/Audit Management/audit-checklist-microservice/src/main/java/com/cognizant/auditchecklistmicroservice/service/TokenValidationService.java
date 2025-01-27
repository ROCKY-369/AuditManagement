package com.cognizant.auditchecklistmicroservice.service;

import org.springframework.stereotype.Service;

@Service
public interface TokenValidationService {
		
		public boolean checkValidity(String Token);

	}