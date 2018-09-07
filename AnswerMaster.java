package com.infodart.peerhuntr.jpa.entity.personalityTest;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the answer_master database table.
 * 
 */
@Entity
@Table(name="answer_master")
@NamedQuery(name="AnswerMaster.findAll", query="SELECT a FROM AnswerMaster a where status=1")
public class AnswerMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="answer_id")
	private int answerId;

	private String answer;

	
	@Column(name="created_on")
	private Date createdOn;

	
	@Column(name="modified_on")
	private Date modifiedOn;

	private String remarks;

	private byte status;

	//bi-directional many-to-one association to QuestionMaster
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="question_id")
	private QuestionMaster questionMaster;

	//bi-directional many-to-one association to AnswerIndicator
	@ManyToOne
	@JoinColumn(name="indicator_type_id")
	private AnswerIndicator answerIndicator;

	//bi-directional many-to-one association to UserQuestionAnswer
	@OneToMany(mappedBy="answerMaster")
	private Set<UserQuestionAnswer> userQuestionAnswers;
	
	//bi-directional many-to-one association to QuestionSectionQualityMapping
	@OneToMany(mappedBy="answerMaster")
	private Set<QuestionSectionQualityMapping> questionSectionQualityMappings;


	public AnswerMaster() {
	}

	public int getAnswerId() {
		return this.answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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

	public AnswerIndicator getAnswerIndicator() {
		return this.answerIndicator;
	}
	
	public void setAnswerIndicator(AnswerIndicator answerIndicator) {
		this.answerIndicator = answerIndicator;
	}
	
	@Basic(fetch = FetchType.LAZY)
	public Set<UserQuestionAnswer> getUserQuestionAnswers() {
		return this.userQuestionAnswers;
	}

	public void setUserQuestionAnswers(Set<UserQuestionAnswer> userQuestionAnswers) {
		this.userQuestionAnswers = userQuestionAnswers;
	}

	public UserQuestionAnswer addUserQuestionAnswer(UserQuestionAnswer userQuestionAnswer) {
		getUserQuestionAnswers().add(userQuestionAnswer);
		userQuestionAnswer.setAnswerMaster(this);

		return userQuestionAnswer;
	}

	public UserQuestionAnswer removeUserQuestionAnswer(UserQuestionAnswer userQuestionAnswer) {
		getUserQuestionAnswers().remove(userQuestionAnswer);
		userQuestionAnswer.setAnswerMaster(null);

		return userQuestionAnswer;
	}

	public Set<QuestionSectionQualityMapping> getQuestionSectionQualityMappings() {
		return questionSectionQualityMappings;
	}

	public void setQuestionSectionQualityMappings(Set<QuestionSectionQualityMapping> questionSectionQualityMappings) {
		this.questionSectionQualityMappings = questionSectionQualityMappings;
	}

}