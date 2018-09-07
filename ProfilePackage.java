package com.infodart.peerhuntr.jpa.entity.userCart;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the profile_package database table.
 * 
 */
@Entity
@Table(name="profile_package")
@NamedQuery(name="ProfilePackage.findAll", query="SELECT p FROM ProfilePackage p where status=1")
public class ProfilePackage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="package_id")
	private int packageId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	@Column(name="package_name")
	private String packageName;

	private int price;

	private int quantity;

	private String remarks;

	private byte status;

	//bi-directional many-to-one association to BuyProfileMaster
	@OneToMany(mappedBy="profilePackage")
	private Set<BuyProfileMaster> buyProfileMasters;

	//bi-directional many-to-one association to UserPurchasedCart
	@OneToMany(mappedBy="profilePackage")
	private Set<UserPurchasedCart> userPurchasedCarts;

	public ProfilePackage() {
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

	public Set<BuyProfileMaster> getBuyProfileMasters() {
		return this.buyProfileMasters;
	}

	public void setBuyProfileMasters(Set<BuyProfileMaster> buyProfileMasters) {
		this.buyProfileMasters = buyProfileMasters;
	}

	public BuyProfileMaster addBuyProfileMaster(BuyProfileMaster buyProfileMaster) {
		getBuyProfileMasters().add(buyProfileMaster);
		buyProfileMaster.setProfilePackage(this);

		return buyProfileMaster;
	}

	public BuyProfileMaster removeBuyProfileMaster(BuyProfileMaster buyProfileMaster) {
		getBuyProfileMasters().remove(buyProfileMaster);
		buyProfileMaster.setProfilePackage(null);

		return buyProfileMaster;
	}

	public Set<UserPurchasedCart> getUserPurchasedCarts() {
		return this.userPurchasedCarts;
	}

	public void setUserPurchasedCarts(Set<UserPurchasedCart> userPurchasedCarts) {
		this.userPurchasedCarts = userPurchasedCarts;
	}

	public UserPurchasedCart addUserPurchasedCart(UserPurchasedCart userPurchasedCart) {
		getUserPurchasedCarts().add(userPurchasedCart);
		userPurchasedCart.setProfilePackage(this);

		return userPurchasedCart;
	}

	public UserPurchasedCart removeUserPurchasedCart(UserPurchasedCart userPurchasedCart) {
		getUserPurchasedCarts().remove(userPurchasedCart);
		userPurchasedCart.setProfilePackage(null);

		return userPurchasedCart;
	}

}