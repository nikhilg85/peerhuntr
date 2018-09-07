package com.infodart.peerhuntr.jpa.entity.user;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the specialization_master database table.
 * 
 */
@Entity
@Table(name="specialization_master")
@NamedQuery(name="SpecializationMaster.findAll", query="SELECT s FROM SpecializationMaster s where status=1 order by specializationName")
public class SpecializationMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="specialization_id")
	private int specializationId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	private String remarks;

	@Column(name="specialization_name")
	private String specializationName;

	private byte status;

	//bi-directional many-to-one association to DegreeMaster
	@ManyToOne
	@JoinColumn(name="degree_id",insertable=true, updatable=true)
	private DegreeMaster degreeMaster;

	public SpecializationMaster() {
	}

	public int getSpecializationId() {
		return this.specializationId;
	}

	public void setSpecializationId(int specializationId) {
		this.specializationId = specializationId;
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

	public String getSpecializationName() {
		return this.specializationName;
	}

	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public DegreeMaster getDegreeMaster() {
		return this.degreeMaster;
	}

	public void setDegreeMaster(DegreeMaster degreeMaster) {
		this.degreeMaster = degreeMaster;
	}

}