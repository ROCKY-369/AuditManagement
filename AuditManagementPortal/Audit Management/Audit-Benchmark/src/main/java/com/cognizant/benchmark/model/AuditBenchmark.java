package com.cognizant.benchmark.model;

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
@ApiModel(description="model class for bench mark microservice")
public class AuditBenchmark {
	/**
	 *It gets the type of audit and acceptable value
	 *@param auditType and noAnswersNum
	 *@return auditType and noAnswersNum
	 */
	@ApiModelProperty(value="type of audit")
	private String auditType;
	@ApiModelProperty(value="acceptable value of no's based on audit type")
	private Integer noAnswersNum;
}
