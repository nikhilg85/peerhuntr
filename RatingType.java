package com.infodart.peerhuntr.jpa.entity.peerRating;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the rating_type database table.
 * 
 */
@Entity
@Table(name="rating_type")
@NamedQuery(name="RatingType.findAll", query="SELECT r FROM RatingType r where status=1")
public class RatingType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rating_type_id")
	private int ratingTypeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	@Column(name="rating_name")
	private String ratingName;

	@Column(name="rating_value")
	private byte ratingValue;

	private String remarks;

	private byte status;

	//bi-directional many-to-one association to UserRating
	@OneToMany(mappedBy="ratingType",fetch=FetchType.LAZY)
	private Set<UserRating> userRatings;

	public RatingType() {
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

	public Set<UserRating> getUserRatings() {
		return this.userRatings;
	}

	public void setUserRatings(Set<UserRating> userRatings) {
		this.userRatings = userRatings;
	}

	public UserRating addUserRating(UserRating userRating) {
		getUserRatings().add(userRating);
		userRating.setRatingType(this);

		return userRating;
	}

	public UserRating removeUserRating(UserRating userRating) {
		getUserRatings().remove(userRating);
		userRating.setRatingType(null);

		return userRating;
	}

}