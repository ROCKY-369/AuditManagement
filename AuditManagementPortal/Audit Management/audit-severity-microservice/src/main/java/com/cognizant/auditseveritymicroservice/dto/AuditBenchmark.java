package com.cognizant.auditseveritymicroservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "creating model class for bench mark microservice")
public class AuditBenchmark {
	/**
	 * Gets the audit type and no.of no's.
	 *
	 * @param auditType and NoAnswerNum .
	 * @return auditType and NoAnswerNum.
	 */
    @ApiModelProperty(value="type of audit")
    private String auditType;
    @ApiModelProperty(value="acceptable value of No's")
    private int noAnswersNum;
    
}
