package com.infodart.peerhuntr.jpa.entity.userCart;

import java.io.Serializable;
import javax.persistence.*;
import com.infodart.peerhuntr.jpa.entity.user.User;


/**
 * The persistent class for the user_purchased_cart database table.
 * 
 */
@Entity
@Table(name="user_purchased_cart")
@NamedQuery(name="UserPurchasedCart.findAll", query="SELECT u FROM UserPurchasedCart u where status=1")
public class UserPurchasedCart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="created_on")
	private String createdOn;

	public User getUserCart() {
		return userCart;
	}

	public void setUserCart(User userCart) {
		this.userCart = userCart;
	}

	@Column(name="modified_on")
	private String modifiedOn;

	private double price;

	
	@ManyToOne
	@JoinColumn(name="profile_id")
	private User userProfile;

	private int quantity;

	private String remarks;

	private byte status;

	@Column(name="transaction_id")
	private int transactionId;

	//bi-directional many-to-one association to ProfilePackage
	@ManyToOne
	@JoinColumn(name="package_id")
	private ProfilePackage profilePackage;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User userCart;
	

	/*//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user2;
*/
	public UserPurchasedCart() {
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


	public User getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(User userProfile) {
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

	public ProfilePackage getProfilePackage() {
		return this.profilePackage;
	}

	public void setProfilePackage(ProfilePackage profilePackage) {
		this.profilePackage = profilePackage;
	}

	
	/*public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}*/

}