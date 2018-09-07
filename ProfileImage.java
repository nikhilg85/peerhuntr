package com.infodart.peerhuntr.jpa.entity.user;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the profile_image database table.
 * 
 */
@Entity
@Table(name="profile_image")
@NamedQuery(name="ProfileImage.findAll", query="SELECT p FROM ProfileImage p where status=1")
public class ProfileImage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="profile_image_id")
	private int profileImageId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;



	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	private String remarks;

	private byte status;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name="hidden_image_url")
	private String hiddenImageUrl;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public ProfileImage() {
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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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