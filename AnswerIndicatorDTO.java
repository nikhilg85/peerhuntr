package com.infodart.peerhuntr.dto.personalityTest;

import java.util.Date;
import java.util.Set;

/**
 * DTO for the answer_indicator database table.
 * 
 */

public class AnswerIndicatorDTO {



	private int answerIndicatorId;
	private Date createdOn;
	private String indicatorType;
	private Date modifiedOn;
	private String remarks;
	private byte status;
	

	public AnswerIndicatorDTO() {
	}

	public int getAnswerIndicatorId() {
		return this.answerIndicatorId;
	}

	public void setAnswerIndicatorId(int answerIndicatorId) {
		this.answerIndicatorId = answerIndicatorId;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getIndicatorType() {
		return this.indicatorType;
	}

	public void setIndicatorType(String indicatorType) {
		this.indicatorType = indicatorType;
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

	

	




}