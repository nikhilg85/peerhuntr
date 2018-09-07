package com.infodart.peerhuntr.dto.user;

import java.util.Date;
import java.util.Set;

/**
 * DTO for the specialization_master database table.
 * 
 */

public class SpecializationMasterDTO {


	
	private int specializationId;
	private Date createdOn;
	private Date modifiedOn;
	private String remarks;
	private String specializationName;
	private byte status;
	private DegreeMasterDTO degreeMaster;


	public SpecializationMasterDTO() {
	}

	public int getSpecializationId() {
		return this.specializationId;
	}

	public void setSpecializationId(int specializationId) {
		this.specializationId = specializationId;
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

	public String getSpecializationName() {
		return this.specializationName;
	}

	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public DegreeMasterDTO getDegreeMaster() {
		return this.degreeMaster;
	}

	public void setDegreeMaster(DegreeMasterDTO degreeMaster) {
		this.degreeMaster = degreeMaster;
	}

	



	

}