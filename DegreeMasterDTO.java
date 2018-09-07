package com.infodart.peerhuntr.dto.user;

import java.util.Date;
import java.util.Set;

import org.dozer.Mapping;

/**
 * DTO for the degree_master database table.
 * 
 */

public class DegreeMasterDTO  {
	

	private int degreeId;
	private Date createdOn;
	private String degreeName;
	private Date modifiedOn;
	private String remarks;
	private byte status;
	public DegreeMasterDTO() {
	}

	public int getDegreeId() {
		return this.degreeId;
	}

	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getDegreeName() {
		return this.degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
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