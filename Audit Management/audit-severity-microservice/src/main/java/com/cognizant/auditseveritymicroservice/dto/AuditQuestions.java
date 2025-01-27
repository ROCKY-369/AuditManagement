package com.cognizant.auditseveritymicroservice.dto;

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
@ApiModel(description="model class for list of questions")
public class AuditQuestions {
	/**
	 * Gets the audit type, question id, question and response.
	 *
	 * @param audit type, question id, question and response.
	 * @return audit type, question id, question and response.
	 */
	@ApiModelProperty(value="question id")
    private int questionId;
	@ApiModelProperty(value="type of audit")
    private String auditType;
	@ApiModelProperty(value="question")
    private String question;
	@ApiModelProperty(value="response to the question(yes/no)")
    private String response;
    
}
