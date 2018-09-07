package com.infodart.peerhuntr.dto.user;

import java.util.Date;

import javax.persistence.Column;

/**
 * DTO for the profile_image database table.
 * 
 */

public class ProfileImageDTO  {


	private int profileImageId;
	private Date createdOn;
	private Date modifiedOn;
	private String remarks;
	private byte status;
	private String imageUrl;
	private String hiddenImageUrl;
	

	public ProfileImageDTO() {
	}

	public int getProfileImageId() {
		return this.profileImageId;
	}

	public void setProfileImageId(int profileImageId) {
		this.profileImageId = profileImageId;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getHiddenImageUrl() {
		return hiddenImageUrl;
	}

	public void setHiddenImageUrl(String hiddenImageUrl) {
		this.hiddenImageUrl = hiddenImageUrl;
	}


}