package com.infodart.peerhuntr.jpa.entity.user;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class AddDate<E> {
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private String createdOn;


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private String modifiedOn;


	public String getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}


	public String getModifiedOn() {
		return modifiedOn;
	}


	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	
}
