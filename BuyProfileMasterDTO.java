package com.infodart.peerhuntr.dto.userCart;

import java.util.Date;

/**
 * DTO for the buy_profile_master database table.
 * 
 */

public class BuyProfileMasterDTO  {

	private int buyProfileId;
	private Date createdOn;
	private Date modifiedOn;
	private String remarks;
	private byte status;
	private ProfilePackageDTO profilePackage;

	public BuyProfileMasterDTO() {
	}

	public int getBuyProfileId() {
		return this.buyProfileId;
	}

	public void setBuyProfileId(int buyProfileId) {
		this.buyProfileId = buyProfileId;
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

	public ProfilePackageDTO getProfilePackage() {
		return this.profilePackage;
	}

	public void setProfilePackage(ProfilePackageDTO profilePackage) {
		this.profilePackage = profilePackage;
	}

}