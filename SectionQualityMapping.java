package com.infodart.peerhuntr.jpa.entity.personalityTest;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the section_quality_mapping database table.
 * 
 */
@Entity
@Table(name="section_quality_mapping")
@NamedQuery(name="SectionQualityMapping.findAll", query="SELECT s FROM SectionQualityMapping s where status=1")
public class SectionQualityMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="section_quality_id")
	private int sectionQualityId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	private String remarks;

	private byte status;

	//bi-directional many-to-one association to AnswerIndicator
	@ManyToOne
	@JoinColumn(name="indicator_type_id")
	private AnswerIndicator answerIndicator;

	//bi-directional many-to-one association to QualityMaster
	@ManyToOne
	@JoinColumn(name="quality_id")
	private QualityMaster qualityMaster;

	//bi-directional many-to-one association to SectionMaster
	@ManyToOne
	@JoinColumn(name="section_id")
	private SectionMaster sectionMaster;

	public SectionQualityMapping() {
	}

	public int getSectionQualityId() {
		return this.sectionQualityId;
	}

	public void setSectionQualityId(int sectionQualityId) {
		this.sectionQualityId = sectionQualityId;
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

	public AnswerIndicator getAnswerIndicator() {
		return this.answerIndicator;
	}

	public void setAnswerIndicator(AnswerIndicator answerIndicator) {
		this.answerIndicator = answerIndicator;
	}

	public QualityMaster getQualityMaster() {
		return this.qualityMaster;
	}

	public void setQualityMaster(QualityMaster qualityMaster) {
		this.qualityMaster = qualityMaster;
	}

	public SectionMaster getSectionMaster() {
		return this.sectionMaster;
	}

	public void setSectionMaster(SectionMaster sectionMaster) {
		this.sectionMaster = sectionMaster;
	}

}