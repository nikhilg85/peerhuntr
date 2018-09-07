package com.infodart.peerhuntr.jpa.entity.personalityTest;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the question_section_quality_mapping database table.
 * 
 */
@Entity
@Table(name="question_section_quality_mapping")
@NamedQuery(name="QuestionSectionQualityMapping.findAll", query="SELECT q FROM QuestionSectionQualityMapping q where status=1")
public class QuestionSectionQualityMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="question_section_quality_id")
	private int questionSectionQualityId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	private String remarks;

	private byte status;

	//bi-directional many-to-one association to QuestionMaster
	@ManyToOne
	@JoinColumn(name="question_id")
	private QuestionMaster questionMaster;

	//bi-directional many-to-one association to QualityMaster
	@ManyToOne
	@JoinColumn(name="quality_id")
	private QualityMaster qualityMaster;

	//bi-directional many-to-one association to SectionMaster
	@ManyToOne
	@JoinColumn(name="section_id")
	private SectionMaster sectionMaster;
	
	//bi-directional many-to-one association to AnswerMaster
	@ManyToOne
	@JoinColumn(name="answer_id")
	private AnswerMaster answerMaster;

	public QuestionSectionQualityMapping() {
	}

	public int getQuestionSectionQualityId() {
		return this.questionSectionQualityId;
	}

	public void setQuestionSectionQualityId(int questionSectionQualityId) {
		this.questionSectionQualityId = questionSectionQualityId;
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

	public QuestionMaster getQuestionMaster() {
		return this.questionMaster;
	}

	public void setQuestionMaster(QuestionMaster questionMaster) {
		this.questionMaster = questionMaster;
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

	public AnswerMaster getAnswerMaster() {
		return answerMaster;
	}

	public void setAnswerMaster(AnswerMaster answerMaster) {
		this.answerMaster = answerMaster;
	}

}