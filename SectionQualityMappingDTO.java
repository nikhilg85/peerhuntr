package com.infodart.peerhuntr.dto.personalityTest;

import java.util.Date;

/**
 * DTO for the section_quality_mapping database table.
 * 
 */

public class SectionQualityMappingDTO {
	


	private int sectionQualityId;
	private Date createdOn;
	private Date modifiedOn;
	private String remarks;
	private byte status;
	private AnswerIndicatorDTO answerIndicator;
	private QualityMasterDTO qualityMaster;
	private SectionMasterDTO sectionMaster;

	public SectionQualityMappingDTO() {
	}

	public int getSectionQualityId() {
		return this.sectionQualityId;
	}

	public void setSectionQualityId(int sectionQualityId) {
		this.sectionQualityId = sectionQualityId;
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

	public AnswerIndicatorDTO getAnswerIndicator() {
		return this.answerIndicator;
	}

	public void setAnswerIndicator(AnswerIndicatorDTO answerIndicator) {
		this.answerIndicator = answerIndicator;
	}

	public QualityMasterDTO getQualityMaster() {
		return this.qualityMaster;
	}

	public void setQualityMaster(QualityMasterDTO qualityMaster) {
		this.qualityMaster = qualityMaster;
	}

	public SectionMasterDTO getSectionMaster() {
		return this.sectionMaster;
	}

	public void setSectionMaster(SectionMasterDTO sectionMaster) {
		this.sectionMaster = sectionMaster;
	}

}