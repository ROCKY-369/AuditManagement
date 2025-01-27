package com.cognizant.auditseveritymicroservice.repository;

import com.cognizant.auditseveritymicroservice.model.AuditDetailsModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * This is a Jpa repository class for Audit deatils model class
 *
 */
@Repository
public interface AuditDetailsRepo extends JpaRepository<AuditDetailsModel, Integer>{
    
}
