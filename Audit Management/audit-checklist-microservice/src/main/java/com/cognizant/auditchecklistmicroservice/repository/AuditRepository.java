package com.cognizant.auditchecklistmicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.auditchecklistmicroservice.Model.AuditQuestions;
/**
 * THis is a jpa repository class for audit questions.
 *
 */
@Repository
public interface AuditRepository extends JpaRepository<AuditQuestions, Integer> {
	
	List<AuditQuestions> findByAuditType(String i);

}
