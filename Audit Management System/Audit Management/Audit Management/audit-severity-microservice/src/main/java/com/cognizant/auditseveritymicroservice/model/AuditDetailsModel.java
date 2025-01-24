package com.cognizant.auditseveritymicroservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="AuditDetais")
@ApiModel(description="Model table class for audit details")
public class AuditDetailsModel { 
	/**
	 * Gets the audit type, date and audit id.
	 *
	 * @param audit type, date and audit id
	 * @return audit type, date and audit id
	 */
	@ApiModelProperty(value="generated audit id ")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auditId;
	@ApiModelProperty(value="type of audit")
    private String auditType;
	@ApiModelProperty(value="todays date in which audit performed")
    @Temporal(TemporalType.DATE)
    private Date auditDate= new Date();

    public AuditDetailsModel(String auditType){
        super();
        this.auditType=auditType;
    }

    public AuditDetailsModel() {
    }

    public AuditDetailsModel(int auditId, String auditType, Date auditDate) {
        this.auditId = auditId;
        this.auditType = auditType;
        this.auditDate = auditDate;
    }

    public int getAuditId() {
        return this.auditId;
    }

    public void setAuditId(int auditId) {
        this.auditId = auditId;
    }

    public String getAuditType() {
        return this.auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public Date getAuditDate() {
        return this.auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

}
