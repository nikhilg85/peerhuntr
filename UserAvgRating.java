package com.infodart.peerhuntr.jpa.entity.peerRating;

import java.io.Serializable;
import javax.persistence.*;

import com.infodart.peerhuntr.jpa.entity.user.User;

import java.util.Date;


/**
 * The persistent class for the user_avg_rating database table.
 * 
 */
@Entity
@Table(name="user_avg_rating")
@NamedQuery(name="UserAvgRating.findAll", query="SELECT u FROM UserAvgRating u")
public class UserAvgRating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_avg_rating_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userAvgRatingId;

	@Column(name="avg_rating_value")
	private double avgRatingValue;
	
	@Column(name="total_reviews")
	private int totalReviews;
	

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	private String remarks;

	private byte status;

	
	//bi-directional many-to-one association to RatingType
	@ManyToOne
	@JoinColumn(name="rating_type_id")
	private RatingType ratingType;
	
	

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;

	public UserAvgRating() {
	}

	public int getUserAvgRatingId() {
		return this.userAvgRatingId;
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

	public RatingType getRatingType() {
		return this.ratingType;
	}

	public void setRatingType(RatingType ratingType) {
		this.ratingType = ratingType;
	}

	public int getTotalReviews() {
		return totalReviews;
	}

	public void setTotalReviews(int totalReviews) {
		this.totalReviews = totalReviews;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

}