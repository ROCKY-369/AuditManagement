package com.cognizant.benchmark.service;
import org.springframework.stereotype.Service;

@Service
public interface TokenValidationService {
    public boolean checkValidity(String token);
}
