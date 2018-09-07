package com.infodart.peerhuntr.dto.user;

import java.util.Date;
import java.util.Set;

/**
 * DTO for the nationality_master database table.
 * 
 */

public class NationalityMasterDTO {
	
	private int nationalityId;
	private Date createdOn;
	private Date modifiedOn;
	private String nationality;
	private String remarks;
	private byte status;
	private String countryCode;
	
	
	
	

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public NationalityMasterDTO() {
	}

	public int getNationalityId() {
		return this.nationalityId;
	}

	public void setNationalityId(int nationalityId) {
		this.nationalityId = nationalityId;
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

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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