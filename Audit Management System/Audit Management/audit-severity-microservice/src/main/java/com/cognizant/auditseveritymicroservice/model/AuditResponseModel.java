package com.cognizant.auditseveritymicroservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "AuditResponse")
@ApiModel(description="model class for audit result")
public class AuditResponseModel {
	/**
	 * Gets the audit id, status and action to be  taken.
	 *
	 * @param audit id, status and action to be  taken.
	 * @return audit id, status and action to be  taken.
	 */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @ApiModelProperty(value="generated audit id")
    private int auditId;
    @ApiModelProperty(value="status of the audit based on no's")
    private String projectExecutionStatus;
    @ApiModelProperty(value="action to be taken")
    private String remedialActionDuration;

    public int getAuditId() {
        return this.auditId;
    }

    public void setAuditId(int auditId) {
        this.auditId = auditId;
    }

    public String getProjectExecutionStatus() {
        return this.projectExecutionStatus;
    }

    public void setProjectExecutionStatus(String projectExecutionStatus) {
        this.projectExecutionStatus = projectExecutionStatus;
    }

    public String getRemedialActionDuration() {
        return this.remedialActionDuration;
    }

    public void setRemedialActionDuration(String remedialActionDuration) {
        this.remedialActionDuration = remedialActionDuration;
    }


    public AuditResponseModel(int auditId, String projectExecutionStatus, String remedialActionDuration) {
        this.auditId = auditId;
        this.projectExecutionStatus = projectExecutionStatus;
        this.remedialActionDuration = remedialActionDuration;
    }

    public AuditResponseModel() {
    }
    
    public AuditResponseModel(String projectExecutionStatus, String remedialActionDuration){
        super();
        this.projectExecutionStatus=projectExecutionStatus;
        this.remedialActionDuration=remedialActionDuration;
    }

    public Object getResponseId() {
        return null;
    }
    
}
