package com.infodart.peerhuntr.jpa.entity.user;

import java.io.Serializable;
import javax.persistence.*;
import com.infodart.peerhuntr.jpa.entity.personalityTest.PersonalityMaster;
import java.util.Date;


/**
 * The persistent class for the user_archive database table.
 * 
 */
@Entity
@Table(name="user_archive")
@NamedQuery(name="UserArchive.findAll", query="SELECT u FROM UserArchive u")
public class UserArchive implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;

	@Column(name="contact_no")
	private String contactNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on")
	private Date createdOn;

	@Column(name="customer_code")
	private String customerCode;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

	@Column(name="email_id")
	private String emailId;

	@Column(name="email_verified")
	private byte emailVerified;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_on")
	private Date modifiedOn;

	private String remarks;

	private byte status;

	@Column(name="university_school")
	private String universitySchool;

	@Column(name="user_interface")
	private String userInterface;

	//bi-directional many-to-one association to DegreeMaster
	@ManyToOne
	@JoinColumn(name="degree_id")
	private DegreeMaster degreeMaster;

	//bi-directional many-to-one association to NationalityMaster
	@ManyToOne
	@JoinColumn(name="nationality_id")
	private NationalityMaster nationalityMaster;

	//bi-directional many-to-one association to PersonalityMaster
	@ManyToOne
	@JoinColumn(name="personality_type_id")
	private PersonalityMaster personalityMaster;

	//bi-directional many-to-one association to SpecializationMaster
	@ManyToOne
	@JoinColumn(name="specialization_id")
	private SpecializationMaster specializationMaster;

	//bi-directional many-to-one association to UserLogin
	@ManyToOne
	@JoinColumn(name="user_login_id")
	private UserLogin userLogin;

	public UserArchive() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCustomerCode() {
		return this.customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public byte getEmailVerified() {
		return this.emailVerified;
	}

	public void setEmailVerified(byte emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getUniversitySchool() {
		return this.universitySchool;
	}

	public void setUniversitySchool(String universitySchool) {
		this.universitySchool = universitySchool;
	}

	public String getUserInterface() {
		return this.userInterface;
	}

	public void setUserInterface(String userInterface) {
		this.userInterface = userInterface;
	}

	public DegreeMaster getDegreeMaster() {
		return this.degreeMaster;
	}

	public void setDegreeMaster(DegreeMaster degreeMaster) {
		this.degreeMaster = degreeMaster;
	}

	public NationalityMaster getNationalityMaster() {
		return this.nationalityMaster;
	}

	public void setNationalityMaster(NationalityMaster nationalityMaster) {
		this.nationalityMaster = nationalityMaster;
	}

	public PersonalityMaster getPersonalityMaster() {
		return this.personalityMaster;
	}

	public void setPersonalityMaster(PersonalityMaster personalityMaster) {
		this.personalityMaster = personalityMaster;
	}

	public SpecializationMaster getSpecializationMaster() {
		return this.specializationMaster;
	}

	public void setSpecializationMaster(SpecializationMaster specializationMaster) {
		this.specializationMaster = specializationMaster;
	}

	public UserLogin getUserLogin() {
		return this.userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

}