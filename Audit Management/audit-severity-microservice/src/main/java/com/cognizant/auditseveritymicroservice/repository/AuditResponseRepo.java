package com.cognizant.auditseveritymicroservice.repository;

import com.cognizant.auditseveritymicroservice.model.AuditResponseModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * This is a Jpa repository class for Audit response model class
 *
 */
@Repository
public interface AuditResponseRepo extends JpaRepository<AuditResponseModel,Integer> {
    
}
