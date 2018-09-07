package com.infodart.peerhuntr.jpa.entity.user;

import java.io.Serializable;
import javax.persistence.*;

import org.dozer.Mapping;

import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the degree_master database table.
 * 
 */
@Entity
@Table(name="degree_master")
@NamedQuery(name="DegreeMaster.findAll", query="SELECT d FROM DegreeMaster d where status=1")
public class DegreeMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="degree_id")
	private int degreeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Column(name="degree_name")
	private String degreeName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	@Version
	private Date modifiedOn;

	private String remarks;

	private byte status;

	public DegreeMaster() {
	}

	public int getDegreeId() {
		return this.degreeId;
	}

	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getDegreeName() {
		return this.degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
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
}