package com.infodart.peerhuntr.dto.personalityTest;

import java.util.Date;

import com.infodart.peerhuntr.dto.user.UserDTO;

/**
 * DTO for the user_question_answers database table.
 * 
 */

public class UserQuestionAnswerDTO {
	

	private int userQuestionAnswersId;
	private Date createdOn;
	private Date modifiedOn;
	private String remarks;
	private byte status;
	private int testNo;
	private AnswerMasterDTO answerMaster;
	private QuestionMasterDTO questionMaster;
	private UserDTO user;

	public UserQuestionAnswerDTO() {
	}

	public int getUserQuestionAnswersId() {
		return this.userQuestionAnswersId;
	}

	public void setUserQuestionAnswersId(int userQuestionAnswersId) {
		this.userQuestionAnswersId = userQuestionAnswersId;
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

	public int getTestNo() {
		return this.testNo;
	}

	public void setTestNo(int testNo) {
		this.testNo = testNo;
	}

	public AnswerMasterDTO getAnswerMaster() {
		return this.answerMaster;
	}

	public void setAnswerMaster(AnswerMasterDTO answerMaster) {
		this.answerMaster = answerMaster;
	}

	public QuestionMasterDTO getQuestionMaster() {
		return this.questionMaster;
	}

	public void setQuestionMaster(QuestionMasterDTO questionMaster) {
		this.questionMaster = questionMaster;
	}

	public UserDTO getUser() {
		return this.user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}