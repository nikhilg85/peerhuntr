package com.infodart.peerhuntr.dto.personalityTest;

import java.util.Date;
import java.util.Set;

/**
 * DTO for the section_master database table.
 * 
 */

public class SectionMasterDTO  {


	private int sectionId;
	private Date createdOn;
	private Date modifiedOn;
	private String remarks;
	private String sectionName;
	private byte status;
	private Set<QuestionMasterDTO> questionMasters;
	private Set<SectionQualityMappingDTO> sectionQualityMappings;

	public SectionMasterDTO() {
	}

	public int getSectionId() {
		return this.sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
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

	public String getSectionName() {
		return this.sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public Set<QuestionMasterDTO> getQuestionMasters() {
		return this.questionMasters;
	}

	public void setQuestionMasters(Set<QuestionMasterDTO> questionMasters) {
		this.questionMasters = questionMasters;
	}

	public Set<SectionQualityMappingDTO> getSectionQualityMappings() {
		return this.sectionQualityMappings;
	}

	public void setSectionQualityMappings(Set<SectionQualityMappingDTO> sectionQualityMappings) {
		this.sectionQualityMappings = sectionQualityMappings;
	}

	public SectionQualityMappingDTO addSectionQualityMapping(SectionQualityMappingDTO sectionQualityMapping) {
		getSectionQualityMappings().add(sectionQualityMapping);
		sectionQualityMapping.setSectionMaster(this);

		return sectionQualityMapping;
	}

	public SectionQualityMappingDTO removeSectionQualityMapping(SectionQualityMappingDTO sectionQualityMapping) {
		getSectionQualityMappings().remove(sectionQualityMapping);
		sectionQualityMapping.setSectionMaster(null);

		return sectionQualityMapping;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((questionMasters == null) ? 0 : questionMasters.hashCode());
		result = prime * result + ((sectionQualityMappings == null) ? 0 : sectionQualityMappings.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SectionMasterDTO other = (SectionMasterDTO) obj;
		if (questionMasters == null) {
			if (other.questionMasters != null)
				return false;
		} else if (!questionMasters.equals(other.questionMasters))
			return false;
		if (sectionQualityMappings == null) {
			if (other.sectionQualityMappings != null)
				return false;
		} else if (!sectionQualityMappings.equals(other.sectionQualityMappings))
			return false;
		return true;
	}

}