package com.cognizant.auditseveritymicroservice.repository;

import com.cognizant.auditseveritymicroservice.model.AuditRequestModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * This is a Jpa repository class for Audit request model class
 *
 */
@Repository
public interface AuditRequestRepo extends JpaRepository<AuditRequestModel,Integer> {

}
    
