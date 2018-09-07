package com.infodart.peerhuntr.jpa.entity.peerRating;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the social_network_master database table.
 * 
 */
@Entity
@Table(name="social_network_master")
@NamedQuery(name="SocialNetworkMaster.findAll", query="SELECT s FROM SocialNetworkMaster s where status=1")
public class SocialNetworkMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="social_network_id")
	private int socialNetworkId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	private String remarks;

	@Column(name="social_network_name")
	private String socialNetworkName;

	private byte status;

	//bi-directional many-to-one association to UserRating
	@OneToMany(mappedBy="socialNetworkMaster")
	private Set<UserRating> userRatings;

	public SocialNetworkMaster() {
	}

	public int getSocialNetworkId() {
		return this.socialNetworkId;
	}

	public void setSocialNetworkId(int socialNetworkId) {
		this.socialNetworkId = socialNetworkId;
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

	public String getSocialNetworkName() {
		return this.socialNetworkName;
	}

	public void setSocialNetworkName(String socialNetworkName) {
		this.socialNetworkName = socialNetworkName;
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
		userRating.setSocialNetworkMaster(this);

		return userRating;
	}

	public UserRating removeUserRating(UserRating userRating) {
		getUserRatings().remove(userRating);
		userRating.setSocialNetworkMaster(null);

		return userRating;
	}

}