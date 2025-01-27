package com.cognizant.auditseveritymicroservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="AuditRequest")
public class AuditRequestModel {
	/**
	 * Gets the requestId, project Manager name, Owner name and project name.
	 *
	 * @param requestId, project Manager name, Owner name and project name.
	 * @return arequestId, project Manager name, Owner name and project name.
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;

    private String projectName;

    private String projectManagerName;

    private String applicatonOwnerName;
    
    @OneToOne(cascade = CascadeType.ALL)
    private AuditDetailsModel auditDetails;

    
    
}
