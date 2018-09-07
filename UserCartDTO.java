package com.infodart.peerhuntr.dto.userCart;

import java.util.Date;

import com.infodart.peerhuntr.dto.user.UserDTO;
import com.infodart.peerhuntr.jpa.entity.user.User;

/**
 * DTO for the user_cart database table.
 * 
 */

public class UserCartDTO  {
	
	private int userCartId;
	private Date createdOn;
	private Date modifiedOn;
	private UserDTO userProfile;
	private String remarks;
	private byte status;
	private UserDTO userCart;

	
	public UserDTO getUserCart() {
		return userCart;
	}

	public void setUserCart(UserDTO userCart) {
		this.userCart = userCart;
	}

	public UserCartDTO() {
	}

	public int getUserCartId() {
		return this.userCartId;
	}

	public void setUserCartId(int userCartId) {
		this.userCartId = userCartId;
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

	public UserDTO getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserDTO userProfile) {
		this.userProfile = userProfile;
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

	




}