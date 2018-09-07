package com.infodart.peerhuntr.jpa.entity.personalityTest;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the section_master database table.
 * 
 */
@Entity
@Table(name="section_master")
@NamedQuery(name="SectionMaster.findAll", query="SELECT s FROM SectionMaster s where status=1")
public class SectionMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="section_id")
	private int sectionId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	private String remarks;

	@Column(name="section_name")
	private String sectionName;

	private byte status;

	//bi-directional many-to-one association to QuestionMaster
	@OneToMany(mappedBy="sectionMaster")
	private Set<QuestionMaster> questionMasters;

	//bi-directional many-to-one association to SectionQualityMapping
	@OneToMany(mappedBy="sectionMaster")
	private Set<SectionQualityMapping> sectionQualityMappings;

	public SectionMaster() {
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

	public Set<QuestionMaster> getQuestionMasters() {
		return this.questionMasters;
	}

	public void setQuestionMasters(Set<QuestionMaster> questionMasters) {
		this.questionMasters = questionMasters;
	}

	public QuestionMaster addQuestionMaster(QuestionMaster questionMaster) {
		getQuestionMasters().add(questionMaster);
		questionMaster.setSectionMaster(this);

		return questionMaster;
	}

	public QuestionMaster removeQuestionMaster(QuestionMaster questionMaster) {
		getQuestionMasters().remove(questionMaster);
		questionMaster.setSectionMaster(null);

		return questionMaster;
	}

	public Set<SectionQualityMapping> getSectionQualityMappings() {
		return this.sectionQualityMappings;
	}

	public void setSectionQualityMappings(Set<SectionQualityMapping> sectionQualityMappings) {
		this.sectionQualityMappings = sectionQualityMappings;
	}

	public SectionQualityMapping addSectionQualityMapping(SectionQualityMapping sectionQualityMapping) {
		getSectionQualityMappings().add(sectionQualityMapping);
		sectionQualityMapping.setSectionMaster(this);

		return sectionQualityMapping;
	}

	public SectionQualityMapping removeSectionQualityMapping(SectionQualityMapping sectionQualityMapping) {
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
		SectionMaster other = (SectionMaster) obj;
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