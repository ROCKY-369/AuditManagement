package com.cognizant.auditchecklistmicroservice.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name="AuditQuestion")
@ApiModel(description="model table class for List of questions and responses")
public class AuditQuestions {
	/**
	 * Gets the audit type, question id, question and response.
	 *
	 * @param audit type, question id, question and response.
	 * @return audit type, question id, question and response.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="questionId")
	@ApiModelProperty(value="question id")
	private Integer questionId;
	
	@Column(name="auditType")
	@ApiModelProperty(value="type of audit")
	private String auditType;
	
	@Column(name="questions")
	@ApiModelProperty(value="questions")
	private String question;
	
	@Column(name="response")
	@ApiModelProperty(value="responses saved")
	private String response;
	
	public AuditQuestions() {
	
	}
	
	
	public AuditQuestions(Integer questionId, String auditType, String question, String response) {
		super();
		this.questionId = questionId;
		this.auditType = auditType;
		this.question = question;
		this.response = response;
	}
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getAuditType() {
		return auditType;
	}
	public void setAuditType(String auditType) {
		this.auditType = auditType;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	
}

