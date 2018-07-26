package com.infodart.peerhuntr.jpa.entity.user;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the user_login database table.
 * 
 */
@Entity
@Table(name="user_login")
@NamedQuery(name="UserLogin.findAll", query="SELECT u FROM UserLogin u")
public class UserLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_login_id")
	private int userLoginId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Column(name="login_attempts")
	private byte loginAttempts;

	@Column(name="login_id")
	private String loginId;

	@Column(name="login_password")
	private String loginPassword;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	private String remarks;

	private byte status;

	/*//bi-directional many-to-one association to User
	@OneToMany(mappedBy="userLogin")
	private Set<User> users;

	//bi-directional many-to-one association to UserArchive
	@OneToMany(mappedBy="userLogin")
	private Set<UserArchive> userArchives;*/

	//bi-directional many-to-one association to AuthorityMaster
	@ManyToOne
	@JoinColumn(name="authority_id",insertable=true, updatable=true)
	private AuthorityMaster authorityMaster;

	public UserLogin() {
	}

	public int getUserLoginId() {
		return this.userLoginId;
	}

	public void setUserLoginId(int userLoginId) {
		this.userLoginId = userLoginId;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public byte getLoginAttempts() {
		return this.loginAttempts;
	}

	public void setLoginAttempts(byte loginAttempts) {
		this.loginAttempts = loginAttempts;
	}

	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
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

	/*public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setUserLogin(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setUserLogin(null);

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
		userArchive.setUserLogin(this);

		return userArchive;
	}

	public UserArchive removeUserArchive(UserArchive userArchive) {
		getUserArchives().remove(userArchive);
		userArchive.setUserLogin(null);

		return userArchive;
	}
*/
	public AuthorityMaster getAuthorityMaster() {
		return this.authorityMaster;
	}

	public void setAuthorityMaster(AuthorityMaster authorityMaster) {
		this.authorityMaster = authorityMaster;
	}

}
