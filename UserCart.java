package com.infodart.peerhuntr.jpa.entity.userCart;

import java.io.Serializable;
import javax.persistence.*;
import com.infodart.peerhuntr.jpa.entity.user.User;
import java.util.Date;


/**
 * The persistent class for the user_cart database table.
 * 
 */
@Entity
@Table(name="user_cart")
@NamedQuery(name="UserCart.findAll", query="SELECT u FROM UserCart u where status=1")
public class UserCart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_cart_id")
	private int userCartId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	@ManyToOne
	@JoinColumn(name="profile_id")
	private User userProfile;

	private String remarks;

	private byte status;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User userCart;

	/*//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user2;
*/
	public UserCart() {
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

	

	public User getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(User userProfile) {
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

	public User getUserCart() {
		return userCart;
	}

	public void setUserCart(User userCart) {
		this.userCart = userCart;
	}

}