package com.infodart.peerhuntr.dto.personalityTest;

import java.util.Date;
import java.util.Set;

/**
 * DTO for the answer_master database table.
 * 
 */

public class AnswerMasterDTO  {
	


	private int answerId;
	private String answer;
	private Date createdOn;
	private Date modifiedOn;
	private String remarks;
	private byte status;
	private QuestionMasterDTO questionMaster;
	private AnswerIndicatorDTO answerIndicator;
	

	public AnswerMasterDTO() {
	}

	public int getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public QuestionMasterDTO getQuestionMaster() {
		return this.questionMaster;
	}

	public void setQuestionMaster(QuestionMasterDTO questionMaster) {
		this.questionMaster = questionMaster;
	}

	public AnswerIndicatorDTO getAnswerIndicator() {
		return this.answerIndicator;
	}

	public void setAnswerIndicator(AnswerIndicatorDTO answerIndicator) {
		this.answerIndicator = answerIndicator;
	}

	

	

}