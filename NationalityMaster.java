package com.infodart.peerhuntr.jpa.entity.user;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the nationality_master database table.
 * 
 */
@Entity
@Table(name="nationality_master")
@NamedQuery(name="NationalityMaster.findAll", query="SELECT n FROM NationalityMaster n where status=1")
public class NationalityMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="nationality_id")
	private int nationalityId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;
	
	@Column(name="country_code")
	private String countryCode;

	private String nationality;

	private String remarks;

	private byte status;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="nationalityMaster")
	private Set<User> users;

	//bi-directional many-to-one association to UserArchive
	@OneToMany(mappedBy="nationalityMaster")
	private Set<UserArchive> userArchives;

	public NationalityMaster() {
	}

	
	
	public String getCountryCode() {
		return countryCode;
	}



	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}



	public int getNationalityId() {
		return this.nationalityId;
	}

	public void setNationalityId(int nationalityId) {
		this.nationalityId = nationalityId;
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

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setNationalityMaster(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setNationalityMaster(null);

		return user;
	}

	public Set<UserArchive> getUserArchives() {
		return this.userArchives;
	}

	public void setUserArchives(Set<UserArchive> userArchives) {
		this.userArchives = userArchives;
	}

	public UserArchive addUserArchive(UserArchive userArchive) {
		getUserArchives().add(userArchive);
		userArchive.setNationalityMaster(this);

		return userArchive;
	}

	public UserArchive removeUserArchive(UserArchive userArchive) {
		getUserArchives().remove(userArchive);
		userArchive.setNationalityMaster(null);

		return userArchive;
	}

}