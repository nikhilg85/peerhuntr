package com.infodart.peerhuntr.dto.peerRating;

import java.util.Date;
import java.util.Set;

/**
 * DTO for the rating_type database table.
 * 
 */

public class RatingTypeDTO {
	

	
	private int ratingTypeId;
	private Date createdOn;
	private Date modifiedOn;
	private String ratingName;
	private byte ratingValue;
	private String remarks;
	private byte status;
	

	public RatingTypeDTO() {
	}

	public int getRatingTypeId() {
		return this.ratingTypeId;
	}

	public void setRatingTypeId(int ratingTypeId) {
		this.ratingTypeId = ratingTypeId;
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

	public String getRatingName() {
		return this.ratingName;
	}

	public void setRatingName(String ratingName) {
		this.ratingName = ratingName;
	}

	public byte getRatingValue() {
		return this.ratingValue;
	}

	public void setRatingValue(byte ratingValue) {
		this.ratingValue = ratingValue;
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

	public UserRatingDTO addUserRating(UserRatingDTO userRating) {
		userRating.setRatingType(this);

		return userRating;
	}

	public UserRatingDTO removeUserRating(UserRatingDTO userRating) {
		userRating.setRatingType(null);

		return userRating;
	}

}