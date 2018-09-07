package com.infodart.peerhuntr.dto.personalityTest;

import java.util.Date;
import java.util.Set;

import com.infodart.peerhuntr.dto.user.UserArchiveDTO;
import com.infodart.peerhuntr.dto.user.UserDTO;

/**
 * DTO for the personality_master database table.
 * 
 */

public class PersonalityMasterDTO  {
	

	private int personalityId;
	private Date createdOn;
	private Date modifiedOn;
	private String personalityRole;
	private String personalityType;
	private String remarks;
	private byte status;
	private String personalityColourCode;

	public PersonalityMasterDTO() {
	}

	public int getPersonalityId() {
		return this.personalityId;
	}

	public void setPersonalityId(int personalityId) {
		this.personalityId = personalityId;
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

	public String getPersonalityRole() {
		return this.personalityRole;
	}

	public void setPersonalityRole(String personalityRole) {
		this.personalityRole = personalityRole;
	}

	public String getPersonalityType() {
		return this.personalityType;
	}

	public void setPersonalityType(String personalityType) {
		this.personalityType = personalityType;
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

	public String getPersonalityColourCode() {
		return personalityColourCode;
	}

	public void setPersonalityColourCode(String personalityColourCode) {
		this.personalityColourCode = personalityColourCode;
	}



	
}