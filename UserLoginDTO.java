package com.infodart.peerhuntr.dto.user;

import java.util.Date;
import java.util.Set;

/**
 * DTO for the user_login database table.
 * 
 */

public class UserLoginDTO  {
	

	private int userLoginId;
	private Date createdOn;
	private byte loginAttempts;
	private String loginId;
	private String loginPassword;
	private Date modifiedOn;
	private String remarks;
	private byte status;
	private Set<UserDTO> users;
	private Set<UserArchiveDTO> userArchives;
	private AuthorityMasterDTO authorityMaster;
	private String confirmPassword;
	private String newPassword;
	private int userId;
	private String oldPassword;
	private String referralCode;

	public String getReferralCode() {
		return referralCode;
	}

	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public UserLoginDTO() {
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

	public Set<UserDTO> getUsers() {
		return this.users;
	}

	public void setUsers(Set<UserDTO> users) {
		this.users = users;
	}

	public UserDTO addUser(UserDTO user) {
		getUsers().add(user);
		user.setUserLogin(this);

		return user;
	}

	public UserDTO removeUser(UserDTO user) {
		getUsers().remove(user);
		user.setUserLogin(null);

		return user;
	}

	public Set<UserArchiveDTO> getUserArchives() {
		return this.userArchives;
	}

	public void setUserArchives(Set<UserArchiveDTO> userArchives) {
		this.userArchives = userArchives;
	}

	public UserArchiveDTO addUserArchive(UserArchiveDTO userArchive) {
		getUserArchives().add(userArchive);
		userArchive.setUserLogin(this);

		return userArchive;
	}

	public UserArchiveDTO removeUserArchive(UserArchiveDTO userArchive) {
		getUserArchives().remove(userArchive);
		userArchive.setUserLogin(null);

		return userArchive;
	}

	public AuthorityMasterDTO getAuthorityMaster() {
		return this.authorityMaster;
	}

	public void setAuthorityMaster(AuthorityMasterDTO authorityMaster) {
		this.authorityMaster = authorityMaster;
	}

}