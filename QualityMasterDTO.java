package com.infodart.peerhuntr.dto.personalityTest;

import java.util.Date;
import java.util.Set;

/**
 * DTO for the quality_master database table.
 * 
 */

public class QualityMasterDTO {


	private int qualityId;
	private Date createdOn;
	private Date modifiedOn;
	private String qualityType;
	private String remarks;
	private byte status;
	private Set<SectionQualityMappingDTO> sectionQualityMappings;

	public QualityMasterDTO() {
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

	public Set<SectionQualityMappingDTO> getSectionQualityMappings() {
		return this.sectionQualityMappings;
	}

	public void setSectionQualityMappings(Set<SectionQualityMappingDTO> sectionQualityMappings) {
		this.sectionQualityMappings = sectionQualityMappings;
	}

	public SectionQualityMappingDTO addSectionQualityMapping(SectionQualityMappingDTO sectionQualityMapping) {
		getSectionQualityMappings().add(sectionQualityMapping);
		sectionQualityMapping.setQualityMaster(this);

		return sectionQualityMapping;
	}

	public SectionQualityMappingDTO removeSectionQualityMapping(SectionQualityMappingDTO sectionQualityMapping) {
		getSectionQualityMappings().remove(sectionQualityMapping);
		sectionQualityMapping.setQualityMaster(null);

		return sectionQualityMapping;
	}

}