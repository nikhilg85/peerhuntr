package com.infodart.peerhuntr.jpa.entity.personalityTest;

import java.io.Serializable;
import javax.persistence.*;

import com.infodart.peerhuntr.jpa.entity.user.User;
import com.infodart.peerhuntr.jpa.entity.user.UserArchive;

import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the personality_master database table.
 * 
 */
@Entity
@Table(name="personality_master")
@NamedQuery(name="PersonalityMaster.findAll", query="SELECT p FROM PersonalityMaster p where status=1")
public class PersonalityMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="personality_id")
	private int personalityId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	@Column(name="personality_role")
	private String personalityRole;

	@Column(name="personality_type")
	private String personalityType;

	private String remarks;

	private byte status;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="personalityMaster")
	private Set<User> users;

	//bi-directional many-to-one association to UserArchive
	@OneToMany(mappedBy="personalityMaster")
	private Set<UserArchive> userArchives;
	
	@Column(name="personality_colour_code")
	private String personalityColourCode;

	public PersonalityMaster() {
	}

	public int getPersonalityId() {
		return this.personalityId;
	}

	public void setPersonalityId(int personalityId) {
		this.personalityId = personalityId;
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

	public String getPersonalityRole() {
		return this.personalityRole;
	}

	public void setPersonalityRole(String personalityRole) {
		this.personalityRole = personalityRole;
	}

	public String getPersonalityType() {
		return this.personalityType;
	}

	public void setPersonalityType(String personalityType) {
		this.personalityType = personalityType;
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
		user.setPersonalityMaster(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setPersonalityMaster(null);

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
		userArchive.setPersonalityMaster(this);

		return userArchive;
	}

	public UserArchive removeUserArchive(UserArchive userArchive) {
		getUserArchives().remove(userArchive);
		userArchive.setPersonalityMaster(null);

		return userArchive;
	}

	public String getPersonalityColourCode() {
		return personalityColourCode;
	}

	public void setPersonalityColourCode(String personalityColourCode) {
		this.personalityColourCode = personalityColourCode;
	}

}