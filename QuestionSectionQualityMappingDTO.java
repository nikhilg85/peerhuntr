package com.infodart.peerhuntr.dto.personalityTest;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the question_section_quality_mapping database table.
 * 
 */
public class QuestionSectionQualityMappingDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int questionSectionQualityId;
	private Date createdOn;
	private Date modifiedOn;
	private String remarks;
	private byte status;
	private QuestionMasterDTO questionMaster;
	private QualityMasterDTO qualityMaster;
	private SectionMasterDTO sectionMaster;
	private AnswerMasterDTO answerMaster;

	public QuestionSectionQualityMappingDTO() {
	}

	public int getQuestionSectionQualityId() {
		return this.questionSectionQualityId;
	}

	public void setQuestionSectionQualityId(int questionSectionQualityId) {
		this.questionSectionQualityId = questionSectionQualityId;
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
		return questionMaster;
	}

	public void setQuestionMaster(QuestionMasterDTO questionMaster) {
		this.questionMaster = questionMaster;
	}

	public QualityMasterDTO getQualityMaster() {
		return qualityMaster;
	}

	public void setQualityMaster(QualityMasterDTO qualityMaster) {
		this.qualityMaster = qualityMaster;
	}

	public SectionMasterDTO getSectionMaster() {
		return sectionMaster;
	}

	public void setSectionMaster(SectionMasterDTO sectionMaster) {
		this.sectionMaster = sectionMaster;
	}

	public AnswerMasterDTO getAnswerMaster() {
		return answerMaster;
	}

	public void setAnswerMaster(AnswerMasterDTO answerMaster) {
		this.answerMaster = answerMaster;
	}
}