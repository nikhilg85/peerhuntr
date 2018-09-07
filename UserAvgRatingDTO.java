package com.infodart.peerhuntr.dto.peerRating;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;




public class UserAvgRatingDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private int userAvgRatingId;
	private double avgRatingValue;
	private Date createdOn;
	private Date modifiedOn;
	private String remarks;
	private byte status;
	private RatingTypeDTO ratingType;
	private int totalReviews;
	

	public UserAvgRatingDTO() {
	}

	public int getUserAvgRatingId() {
		return this.userAvgRatingId;
	}

	public int getTotalReviews() {
		return totalReviews;
	}

	public void setTotalReviews(int totalReviews) {
		this.totalReviews = totalReviews;
	}

	public void setUserAvgRatingId(int userAvgRatingId) {
		this.userAvgRatingId = userAvgRatingId;
	}

	public double getAvgRatingValue() {
		return this.avgRatingValue;
	}

	public void setAvgRatingValue(double avgRatingValue) {
		this.avgRatingValue = avgRatingValue;
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

	public RatingTypeDTO getRatingType() {
		return this.ratingType;
	}

	public void setRatingType(RatingTypeDTO ratingType) {
		this.ratingType = ratingType;
	}

	

}