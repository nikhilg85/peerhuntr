package com.infodart.peerhuntr.dto.userCart;

import com.infodart.peerhuntr.dto.user.UserDTO;

/**
 * DTO for the user_purchased_cart database table.
 * 
 */

public class UserPurchasedCartDTO {
	

	private int id;
	private String createdOn;
	private String modifiedOn;
	private double price;
	private UserDTO userProfile;
	private int quantity;
	private String remarks;
	private byte status;
	private int transactionId;
	private ProfilePackageDTO profilePackage;
	private UserDTO userCart;


	public UserPurchasedCartDTO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getModifiedOn() {
		return this.modifiedOn;
	}

	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public UserDTO getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserDTO userProfile) {
		this.userProfile = userProfile;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public int getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public ProfilePackageDTO getProfilePackage() {
		return this.profilePackage;
	}

	public void setProfilePackage(ProfilePackageDTO profilePackage) {
		this.profilePackage = profilePackage;
	}

	public UserDTO getUserCart() {
		return userCart;
	}

	public void setUserCart(UserDTO userCart) {
		this.userCart = userCart;
	}


}