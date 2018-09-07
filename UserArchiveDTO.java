package com.infodart.peerhuntr.dto.user;

import java.util.Date;

import com.infodart.peerhuntr.dto.personalityTest.PersonalityMasterDTO;

/**
 * DTOfor the user_archive database table.
 * 
 */

public class UserArchiveDTO  {
	
	private int userId;
	private String contactNo;
	private Date createdOn;
	private String customerCode;
	private Date dateOfBirth;
	private String emailId;
	private byte emailVerified;
	private String firstName;
	private String lastName;
	private Date modifiedOn;
	private String remarks;
	private byte status;
	private String universitySchool;
	private String userInterface;
	private DegreeMasterDTO degreeMaster;
	private NationalityMasterDTO nationalityMaster;
	private PersonalityMasterDTO personalityMaster;
	private SpecializationMasterDTO specializationMaster;
	private UserLoginDTO userLogin;

	public UserArchiveDTO() {
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

	public DegreeMasterDTO getDegreeMaster() {
		return this.degreeMaster;
	}

	public void setDegreeMaster(DegreeMasterDTO degreeMaster) {
		this.degreeMaster = degreeMaster;
	}

	public NationalityMasterDTO getNationalityMaster() {
		return this.nationalityMaster;
	}

	public void setNationalityMaster(NationalityMasterDTO nationalityMaster) {
		this.nationalityMaster = nationalityMaster;
	}

	public PersonalityMasterDTO getPersonalityMaster() {
		return this.personalityMaster;
	}

	public void setPersonalityMaster(PersonalityMasterDTO personalityMaster) {
		this.personalityMaster = personalityMaster;
	}

	public SpecializationMasterDTO getSpecializationMaster() {
		return this.specializationMaster;
	}

	public void setSpecializationMaster(SpecializationMasterDTO specializationMaster) {
		this.specializationMaster = specializationMaster;
	}

	public UserLoginDTO getUserLogin() {
		return this.userLogin;
	}

	public void setUserLogin(UserLoginDTO userLogin) {
		this.userLogin = userLogin;
	}

}