package com.infodart.peerhuntr.dto.userCart;

import java.util.Date;
import java.util.Set;

/**
 * DTO for the profile_package database table.
 * 
 */

public class ProfilePackageDTO {
	
	
	private int packageId;
	private Date createdOn;
	private Date modifiedOn;
	private String packageName;
	private int price;
	private int quantity;
	private String remarks;
	private byte status;
	private Set<BuyProfileMasterDTO> buyProfileMasters;
	private Set<UserPurchasedCartDTO> userPurchasedCarts;

	public ProfilePackageDTO() {
	}

	public int getPackageId() {
		return this.packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
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

	public String getPackageName() {
		return this.packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public Set<BuyProfileMasterDTO> getBuyProfileMasters() {
		return this.buyProfileMasters;
	}

	public void setBuyProfileMasters(Set<BuyProfileMasterDTO> buyProfileMasters) {
		this.buyProfileMasters = buyProfileMasters;
	}

	public BuyProfileMasterDTO addBuyProfileMaster(BuyProfileMasterDTO buyProfileMaster) {
		getBuyProfileMasters().add(buyProfileMaster);
		buyProfileMaster.setProfilePackage(this);

		return buyProfileMaster;
	}

	public BuyProfileMasterDTO removeBuyProfileMaster(BuyProfileMasterDTO buyProfileMaster) {
		getBuyProfileMasters().remove(buyProfileMaster);
		buyProfileMaster.setProfilePackage(null);

		return buyProfileMaster;
	}

	public Set<UserPurchasedCartDTO> getUserPurchasedCarts() {
		return this.userPurchasedCarts;
	}

	public void setUserPurchasedCarts(Set<UserPurchasedCartDTO> userPurchasedCarts) {
		this.userPurchasedCarts = userPurchasedCarts;
	}

	public UserPurchasedCartDTO addUserPurchasedCart(UserPurchasedCartDTO userPurchasedCart) {
		getUserPurchasedCarts().add(userPurchasedCart);
		userPurchasedCart.setProfilePackage(this);

		return userPurchasedCart;
	}

	public UserPurchasedCartDTO removeUserPurchasedCart(UserPurchasedCartDTO userPurchasedCart) {
		getUserPurchasedCarts().remove(userPurchasedCart);
		userPurchasedCart.setProfilePackage(null);

		return userPurchasedCart;
	}

}