package com.infodart.peerhuntr.jpa.entity.peerRating;

import java.io.Serializable;
import javax.persistence.*;

import com.infodart.peerhuntr.jpa.entity.user.User;

import java.util.Date;


/**
 * The persistent class for the user_rating database table.
 * 
 */
@Entity
@Table(name="user_rating")
@NamedQuery(name="UserRating.findAll", query="SELECT u FROM UserRating u where status=1")
public class UserRating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_rating_id")
	private int userRatingId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	@Column(name="network_user")
	private String networkUser;
	
	/*@Column(name="Relationship_id")
	private String relationshipId1;*/
	

	private String remarks;

	private byte status;

	//bi-directional many-to-one association to RatingType
	@ManyToOne
	@JoinColumn(name="rating_type_id")
	private RatingType ratingType;

	//bi-directional many-to-one association to SocialNetworkMaster
	@ManyToOne
	@JoinColumn(name="social_network_id")
	private SocialNetworkMaster socialNetworkMaster;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	
	@Column(name="rating_value")
	private int userRatingValue;
	
	@Column(name="email_id")
	private String emailId;
	
	
	@Column(name="relationship")
	private String relationship;
	
	public UserRating() {
	}

	
	public String getRelationshipId() {
		return relationship;
	}
	
	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public int getUserRatingId() {
		return this.userRatingId;
	}

	public void setUserRatingId(int userRatingId) {
		this.userRatingId = userRatingId;
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

	public String getNetworkUser() {
		return this.networkUser;
	}

	public void setNetworkUser(String networkUser) {
		this.networkUser = networkUser;
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

	public SocialNetworkMaster getSocialNetworkMaster() {
		return this.socialNetworkMaster;
	}

	public void setSocialNetworkMaster(SocialNetworkMaster socialNetworkMaster) {
		this.socialNetworkMaster = socialNetworkMaster;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUserRatingValue() {
		return userRatingValue;
	}

	public void setUserRatingValue(int userRatingValue) {
		this.userRatingValue = userRatingValue;
	}

}