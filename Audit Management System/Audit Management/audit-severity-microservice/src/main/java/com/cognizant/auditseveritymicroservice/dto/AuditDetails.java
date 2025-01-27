package com.cognizant.auditseveritymicroservice.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@ApiModel(description="model class for audit details")
public class AuditDetails {
	/**
	 * Gets the audit type and date.
	 *
	 * @param auditType and date .
	 * @return auditType and date.
	 */
    @JsonProperty
    @ApiModelProperty(value="type of audit")
    private String auditType;
    @ApiModelProperty(value="date in which audit taken")
    private Date auditDate=new Date();

    public AuditDetails() {
        this.auditDate=new Date();
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
