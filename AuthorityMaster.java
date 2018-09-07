package com.infodart.peerhuntr.jpa.entity.user;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the authority_master database table.
 * 
 */
@Entity
@Table(name="authority_master")
@NamedQuery(name="AuthorityMaster.findAll", query="SELECT a FROM AuthorityMaster a where status=1")
public class AuthorityMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="authority_id")
	private int authorityId;

	private String authority;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	private String remarks;

	private byte status;

	/*//bi-directional many-to-one association to UserLogin
	@OneToMany(mappedBy="authorityMaster")
	private Set<UserLogin> userLogins;
*/
	public AuthorityMaster() {
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

	/*public Set<UserLogin> getUserLogins() {
		return this.userLogins;
	}

	public void setUserLogins(Set<UserLogin> userLogins) {
		this.userLogins = userLogins;
	}*/

	/*public UserLogin addUserLogin(UserLogin userLogin) {
		getUserLogins().add(userLogin);
		userLogin.setAuthorityMaster(this);

		return userLogin;
	}

	public UserLogin removeUserLogin(UserLogin userLogin) {
		getUserLogins().remove(userLogin);
		userLogin.setAuthorityMaster(null);

		return userLogin;
	}
*/
}