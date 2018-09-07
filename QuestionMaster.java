package com.infodart.peerhuntr.jpa.entity.personalityTest;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the question_master database table.
 * 
 */
@Entity
@Table(name="question_master")
@NamedQuery(name="QuestionMaster.findAll", query="SELECT q FROM QuestionMaster q where status=1")
public class QuestionMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="question_id")
	private int questionId;

	
	@Column(name="created_on")
	private Date createdOn;

	
	@Column(name="modified_on")
	private Date modifiedOn;

	@Column(name="question_name")
	private String questionName;
	
	@Column(name="question_number_id")
	private int questionNumberId;


	private String remarks;

	private byte status;
	

	//bi-directional many-to-one association to AnswerMaster
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="question_id",insertable=true,updatable=true)
	//@OrderBy("questionMaster.questionId,answerId ASC")
	private Set<AnswerMaster> answerMasters;
	
	//bi-directional many-to-one association to SectionMaster
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="section_id")
	private SectionMaster sectionMaster;

	//bi-directional many-to-one association to UserQuestionAnswer
	@OneToMany(mappedBy="questionMaster")
	private Set<UserQuestionAnswer> userQuestionAnswers;
	
	//bi-directional many-to-one association to QuestionSectionQualityMapping
	@OneToMany(mappedBy="questionMaster")
	private Set<QuestionSectionQualityMapping> questionSectionQualityMappings;


	public QuestionMaster() {
	}

	public int getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
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

	public String getQuestionName() {
		return this.questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
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



	public SectionMaster getSectionMaster() {
		return this.sectionMaster;
	}

	public void setSectionMaster(SectionMaster sectionMaster) {
		this.sectionMaster = sectionMaster;
	}

	public Set<UserQuestionAnswer> getUserQuestionAnswers() {
		return this.userQuestionAnswers;
	}

	public void setUserQuestionAnswers(Set<UserQuestionAnswer> userQuestionAnswers) {
		this.userQuestionAnswers = userQuestionAnswers;
	}

	public UserQuestionAnswer addUserQuestionAnswer(UserQuestionAnswer userQuestionAnswer) {
		getUserQuestionAnswers().add(userQuestionAnswer);

		return userQuestionAnswer;
	}

	public UserQuestionAnswer removeUserQuestionAnswer(UserQuestionAnswer userQuestionAnswer) {
		getUserQuestionAnswers().remove(userQuestionAnswer);

		return userQuestionAnswer;
	}

	public int getQuestionNumberId() {
		return questionNumberId;
	}

	public void setQuestionNumberId(int questionNumberId) {
		this.questionNumberId = questionNumberId;
	}

	public Set<QuestionSectionQualityMapping> getQuestionSectionQualityMappings() {
		return questionSectionQualityMappings;
	}

	public void setQuestionSectionQualityMappings(Set<QuestionSectionQualityMapping> questionSectionQualityMappings) {
		this.questionSectionQualityMappings = questionSectionQualityMappings;
	}

}