package com.infodart.peerhuntr.dto.personalityTest;

import java.util.Date;
import java.util.Set;

/**
 * DTO for the question_master database table.
 * 
 */

public class QuestionMasterDTO  {



	private int questionId;
	private Date createdOn;
	private Date modifiedOn;
	private String questionName;
	private String remarks;
	private byte status;
	private Set<AnswerMasterDTO> answerMasters;
	private SectionMasterDTO sectionMaster;
	private int sectionId;
	private String sectionName;
	private int questionNumberId;
	
	
	

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public QuestionMasterDTO() {
	}

	public int getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
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

	public String getQuestionName() {
		return this.questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
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

	public Set<AnswerMasterDTO> getAnswerMasters() {
		return this.answerMasters;
	}

	public void setAnswerMasters(Set<AnswerMasterDTO> answerMasters) {
		this.answerMasters = answerMasters;
	}

	public AnswerMasterDTO addAnswerMaster(AnswerMasterDTO answerMaster) {
		getAnswerMasters().add(answerMaster);
		answerMaster.setQuestionMaster(this);

		return answerMaster;
	}

	public AnswerMasterDTO removeAnswerMaster(AnswerMasterDTO answerMaster) {
		getAnswerMasters().remove(answerMaster);
		answerMaster.setQuestionMaster(null);

		return answerMaster;
	}

	public SectionMasterDTO getSectionMaster() {
		return this.sectionMaster;
	}

	public void setSectionMaster(SectionMasterDTO sectionMaster) {
		this.sectionMaster = sectionMaster;
	}
	
	public int getQuestionNumberId() {
		return questionNumberId;
	}

	public void setQuestionNumberId(int questionNumberId) {
		this.questionNumberId = questionNumberId;
	}

}