package com.infodart.peerhuntr.jpa.entity.personalityTest;

import java.io.Serializable;
import javax.persistence.*;

import com.infodart.peerhuntr.jpa.entity.user.User;

import java.util.Date;


/**
 * The persistent class for the user_question_answers database table.
 * 
 */
@Entity
@Table(name="user_question_answers")
@NamedQuery(name="UserQuestionAnswer.findAll", query="SELECT u FROM UserQuestionAnswer u where status=1")
public class UserQuestionAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_question_answers_id")
	private int userQuestionAnswersId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	private String remarks;

	private byte status;

	@Column(name="test_no")
	private int testNo;

	//bi-directional many-to-one association to AnswerMaster
	@ManyToOne
	@JoinColumn(name="answer_id")
	private AnswerMaster answerMaster;

	//bi-directional many-to-one association to QuestionMaster
	@ManyToOne
	@JoinColumn(name="question_id")
	private QuestionMaster questionMaster;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public UserQuestionAnswer() {
	}

	public int getUserQuestionAnswersId() {
		return this.userQuestionAnswersId;
	}

	public void setUserQuestionAnswersId(int userQuestionAnswersId) {
		this.userQuestionAnswersId = userQuestionAnswersId;
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

	public int getTestNo() {
		return this.testNo;
	}

	public void setTestNo(int testNo) {
		this.testNo = testNo;
	}

	public AnswerMaster getAnswerMaster() {
		return this.answerMaster;
	}

	public void setAnswerMaster(AnswerMaster answerMaster) {
		this.answerMaster = answerMaster;
	}

	public QuestionMaster getQuestionMaster() {
		return this.questionMaster;
	}

	public void setQuestionMaster(QuestionMaster questionMaster) {
		this.questionMaster = questionMaster;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}