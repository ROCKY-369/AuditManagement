package com.cognizant.auditseveritymicroservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuditType {
	/**
	 * Gets the audit type.
	 *
	 * @param audit type.
	 * @return audit type.
	 */
    @JsonProperty
	String auditType;
	
	public AuditType() {
		
	}
	
	public AuditType(String auditType) {
		super();
		this.auditType = auditType;
	}

	public String getAuditType() {
		return auditType;
	}

	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}
	
}
