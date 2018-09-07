package com.infodart.peerhuntr.jpa.entity.userCart;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the buy_profile_master database table.
 * 
 */
@Entity
@Table(name="buy_profile_master")
@NamedQuery(name="BuyProfileMaster.findAll", query="SELECT b FROM BuyProfileMaster b where status=1")
public class BuyProfileMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="buy_profile_id")
	private int buyProfileId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	private String remarks;

	private byte status;

	//bi-directional many-to-one association to ProfilePackage
	@ManyToOne
	@JoinColumn(name="package_type_id")
	private ProfilePackage profilePackage;

	public BuyProfileMaster() {
	}

	public int getBuyProfileId() {
		return this.buyProfileId;
	}

	public void setBuyProfileId(int buyProfileId) {
		this.buyProfileId = buyProfileId;
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

	public ProfilePackage getProfilePackage() {
		return this.profilePackage;
	}

	public void setProfilePackage(ProfilePackage profilePackage) {
		this.profilePackage = profilePackage;
	}

}