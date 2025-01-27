package com.cognizant.auditseveritymicroservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description="model classs for audit details")
public class AuditRequest {
	/**
	 * Gets the audit details,project Manager name, Owner name and project name.
	 *
	 * @param audit details,project Manager name, Owner name and project name.
	 * @return audit details,project Manager name, Owner name and project name.
	 */
    @JsonProperty
    @ApiModelProperty(value="project Name to which audit performed")
    private String projectName;

    @JsonProperty
    @ApiModelProperty(value="Name of the project Manager")
    private String projectManagerName;

    @JsonProperty
    @ApiModelProperty(value="Owner Name of the project")
    private String applicationOwnerName;   

    @JsonProperty
    @ApiModelProperty(value="audit details")
    private AuditDetails auditDetails;

}
