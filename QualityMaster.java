package com.infodart.peerhuntr.jpa.entity.personalityTest;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the quality_master database table.
 * 
 */
@Entity
@Table(name="quality_master")
@NamedQuery(name="QualityMaster.findAll", query="SELECT q FROM QualityMaster q where status=1")
public class QualityMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="quality_id")
	private int qualityId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	@Column(name="quality_type")
	private String qualityType;

	private String remarks;

	private byte status;

	//bi-directional many-to-one association to SectionQualityMapping
	@OneToMany(mappedBy="qualityMaster")
	private Set<SectionQualityMapping> sectionQualityMappings;

	public QualityMaster() {
	}

	public int getQualityId() {
		return this.qualityId;
	}

	public void setQualityId(int qualityId) {
		this.qualityId = qualityId;
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

	public String getQualityType() {
		return this.qualityType;
	}

	public void setQualityType(String qualityType) {
		this.qualityType = qualityType;
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

	public Set<SectionQualityMapping> getSectionQualityMappings() {
		return this.sectionQualityMappings;
	}

	public void setSectionQualityMappings(Set<SectionQualityMapping> sectionQualityMappings) {
		this.sectionQualityMappings = sectionQualityMappings;
	}

	public SectionQualityMapping addSectionQualityMapping(SectionQualityMapping sectionQualityMapping) {
		getSectionQualityMappings().add(sectionQualityMapping);
		sectionQualityMapping.setQualityMaster(this);

		return sectionQualityMapping;
	}

	public SectionQualityMapping removeSectionQualityMapping(SectionQualityMapping sectionQualityMapping) {
		getSectionQualityMappings().remove(sectionQualityMapping);
		sectionQualityMapping.setQualityMaster(null);

		return sectionQualityMapping;
	}

}