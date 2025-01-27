package com.cognizant.auditseveritymicroservice.dto;


public class AuditResponse {
	/**
	 * Gets the audit id, status and action to be  taken.
	 *
	 * @param audit id, status and action to be  taken.
	 * @return audit id, status and action to be  taken.
	 */
    private int auditId;
	private String projectExecutionStatus;
	private String remedialActionDuration;


    public AuditResponse() {
    }

    public AuditResponse( String projectExecutionStatus, String remedialActionDuration){
        super();
        this.projectExecutionStatus = projectExecutionStatus;
        this.remedialActionDuration = remedialActionDuration;
    }

    public AuditResponse(int auditId, String projectExecutionStatus, String remedialActionDuration) {
        this.auditId = auditId;
        this.projectExecutionStatus = projectExecutionStatus;
        this.remedialActionDuration = remedialActionDuration;
    }

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

}
    
