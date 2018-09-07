package com.infodart.peerhuntr.dto.peerRating;

import java.util.Date;
import java.util.Set;

/**
 * DTO for the social_network_master database table.
 * 
 */

public class SocialNetworkMasterDTO  {


	private int socialNetworkId;
	private Date createdOn;
	private Date modifiedOn;
	private String remarks;
	private String socialNetworkName;
	private byte status;

	public SocialNetworkMasterDTO() {
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

/*	public Set<UserRatingDTO> getUserRatings() {
		return this.userRatings;
	}

	public void setUserRatings(Set<UserRatingDTO> userRatings) {
		this.userRatings = userRatings;
	}
*/
	public UserRatingDTO addUserRating(UserRatingDTO userRating) {
		//getUserRatings().add(userRating);
		userRating.setSocialNetworkMaster(this);

		return userRating;
	}

	public UserRatingDTO removeUserRating(UserRatingDTO userRating) {
		//getUserRatings().remove(userRating);
		userRating.setSocialNetworkMaster(null);

		return userRating;
	}

}