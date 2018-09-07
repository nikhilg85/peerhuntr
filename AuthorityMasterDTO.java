package com.infodart.peerhuntr.dto.user;

import java.util.Date;
import java.util.Set;

/**
 * DTO for the authority_master database table.
 * 
 */

public class AuthorityMasterDTO  {
	

	
	private int authorityId;
	private String authority;
	private Date createdOn;
	private Date modifiedOn;
	private String remarks;
	private byte status;
	private Set<UserLoginDTO> userLogins;

	public AuthorityMasterDTO() {
	}

	public int getAuthorityId() {
		return this.authorityId;
	}

	public void setAuthorityId(int authorityId) {
		this.authorityId = authorityId;
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
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

	public Set<UserLoginDTO> getUserLogins() {
		return this.userLogins;
	}

	public void setUserLogins(Set<UserLoginDTO> userLogins) {
		this.userLogins = userLogins;
	}

	public UserLoginDTO addUserLogin(UserLoginDTO userLogin) {
		getUserLogins().add(userLogin);
		userLogin.setAuthorityMaster(this);

		return userLogin;
	}

	public UserLoginDTO removeUserLogin(UserLoginDTO userLogin) {
		getUserLogins().remove(userLogin);
		userLogin.setAuthorityMaster(null);

		return userLogin;
	}

}