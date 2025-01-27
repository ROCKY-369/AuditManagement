package com.cognizant.auditseveritymicroservice.service;

import org.springframework.stereotype.Service;

@Service
public interface TokenValidationService {

    public boolean checkValidity(String Token);
    
}
