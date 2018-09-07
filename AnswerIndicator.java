package com.infodart.peerhuntr.jpa.entity.personalityTest;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the answer_indicator database table.
 * 
 */
@Entity
@Table(name="answer_indicator")
@NamedQuery(name="AnswerIndicator.findAll", query="SELECT a FROM AnswerIndicator a where status=1")
public class AnswerIndicator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="answer_indicator_id")
	private int answerIndicatorId;

	
	@Column(name="created_on")
	private Date createdOn;

	@Column(name="indicator_type")
	private String indicatorType;

	
	@Column(name="modified_on")
	private Date modifiedOn;

	private String remarks;

	private byte status;

	//bi-directional many-to-one association to AnswerMaster
	@OneToMany(mappedBy="answerIndicator")
	private Set<AnswerMaster> answerMasters;

	//bi-directional many-to-one association to SectionQualityMapping
	@OneToMany(mappedBy="answerIndicator")
	private Set<SectionQualityMapping> sectionQualityMappings;

	public AnswerIndicator() {
	}

	public int getAnswerIndicatorId() {
		return this.answerIndicatorId;
	}

	public void setAnswerIndicatorId(int answerIndicatorId) {
		this.answerIndicatorId = answerIndicatorId;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getIndicatorType() {
		return this.indicatorType;
	}

	public void setIndicatorType(String indicatorType) {
		this.indicatorType = indicatorType;
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

	public Set<AnswerMaster> getAnswerMasters() {
		return this.answerMasters;
	}

	public void setAnswerMasters(Set<AnswerMaster> answerMasters) {
		this.answerMasters = answerMasters;
	}

	public AnswerMaster addAnswerMaster(AnswerMaster answerMaster) {
		getAnswerMasters().add(answerMaster);
		answerMaster.setAnswerIndicator(this);

		return answerMaster;
	}

	public AnswerMaster removeAnswerMaster(AnswerMaster answerMaster) {
		getAnswerMasters().remove(answerMaster);
		answerMaster.setAnswerIndicator(null);

		return answerMaster;
	}

	public Set<SectionQualityMapping> getSectionQualityMappings() {
		return this.sectionQualityMappings;
	}

	public void setSectionQualityMappings(Set<SectionQualityMapping> sectionQualityMappings) {
		this.sectionQualityMappings = sectionQualityMappings;
	}

	public SectionQualityMapping addSectionQualityMapping(SectionQualityMapping sectionQualityMapping) {
		getSectionQualityMappings().add(sectionQualityMapping);
		sectionQualityMapping.setAnswerIndicator(this);

		return sectionQualityMapping;
	}

	public SectionQualityMapping removeSectionQualityMapping(SectionQualityMapping sectionQualityMapping) {
		getSectionQualityMappings().remove(sectionQualityMapping);
		sectionQualityMapping.setAnswerIndicator(null);

		return sectionQualityMapping;
	}

}