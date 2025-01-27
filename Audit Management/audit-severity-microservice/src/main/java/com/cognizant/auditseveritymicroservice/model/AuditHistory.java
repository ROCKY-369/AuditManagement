package com.cognizant.auditseveritymicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuditHistory {
	/**
	 * Gets the audit type, date ,audit id, project name, manager name, application owner name, status and action.
	 *
	 * @param audit type, date ,audit id, project name, manager name, application owner name, status and action
	 * @return audit type, date ,audit id, project name, manager name, application owner name, status and action
	 */

    private int auditId;

    private String projectName;

    private String projectManagerName;

    private String applicatonOwnerName;

    private String auditType;

    private String auditDate;

    private boolean projectExecutionStatus;

    private String remedialActionDuration;
    
}
