package com.infodart.peerhuntr.dto.user;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.infodart.peerhuntr.dto.peerRating.UserAvgRatingDTO;
import com.infodart.peerhuntr.dto.peerRating.UserRatingDTO;
import com.infodart.peerhuntr.dto.personalityTest.PersonalityMasterDTO;
import com.infodart.peerhuntr.dto.personalityTest.UserQuestionAnswerDTO;
import com.infodart.peerhuntr.dto.userCart.UserCartDTO;
import com.infodart.peerhuntr.dto.userCart.UserPurchasedCartDTO;
import com.infodart.peerhuntr.jpa.entity.peerRating.UserAvgRating;



/**
 * DTO for the user database table.
 * 
 */

public class UserDTO  {
	
	private int userId;
	private String contactNo;
	private Date createdOn;
	private String userToken;
	private Date dateOfBirth;
	private byte emailVerified;
	private String firstName;
	private String lastName;
	private Date modifiedOn;
	private String remarks;
	private byte status;
	private String universitySchool;
	private String userInterface;
	private String confirmPassword;
	private Set<ProfileImageDTO> profileImages;
	private NationalityMasterDTO nationalityMaster;
	private PersonalityMasterDTO personalityMaster;
	private SpecializationMasterDTO specializationMaster;
	private UserLoginDTO userLogin;
	private Set<UserCartDTO> userCarts1;
	private Set<UserPurchasedCartDTO> userPurchasedCartDTO;
	private Set<UserQuestionAnswerDTO> userQuestionAnswers;
	private Set<UserRatingDTO> userRatings;
	private int age;
	private ProfileImageDTO profileImageDTO;
	private byte[] imageInBytes;
	private MultipartFile image;
	private String termsNcondition;
	private String base64Encoded;
	private String base64EncodedBlur;
	private String stringDateOfBirth;
	private String stringCreatedOn;
	private double score=0.0;
	private int review=0;
	private String referralCode;
	private String ratingLink;
	private Set<UserAvgRatingDTO> userAvgRatings;
	private String countryCode;
	private Set<String> comments;
	
	
	
	

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	

	
	

	public Set<UserAvgRatingDTO> getUserAvgRatings() {
		return userAvgRatings;
	}

	public void setUserAvgRatings(Set<UserAvgRatingDTO> userAvgRatings) {
		this.userAvgRatings = userAvgRatings;
	}

	public String getRatingLink() {
		return ratingLink;
	}

	public void setRatingLink(String ratingLink) {
		this.ratingLink = ratingLink;
	}

	public String getReferralCode() {
		return referralCode;
	}

	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}

	public String getStringCreatedOn() {
		return stringCreatedOn;
	}

	public void setStringCreatedOn(String stringCreatedOn) {
		this.stringCreatedOn = stringCreatedOn;
	}

	private String stringModifiedOn;
	

	public String getStringModifiedOn() {
		return stringModifiedOn;
	}

	public void setStringModifiedOn(String stringModifiedOn) {
		this.stringModifiedOn = stringModifiedOn;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	

	
	public String getBase64EncodedBlur() {
		return base64EncodedBlur;
	}

	public void setBase64EncodedBlur(String base64EncodedBlur) {
		this.base64EncodedBlur = base64EncodedBlur;
	}

	public String getBase64Encoded() {
		return base64Encoded;
	}

	public void setBase64Encoded(String base64Encoded) {
		this.base64Encoded = base64Encoded;
	}

	public byte[] getImageInBytes() {
		return imageInBytes;
	}

	public void setImageInBytes(byte[] imageInBytes) {
		this.imageInBytes = imageInBytes;
	}

	public ProfileImageDTO getProfileImageDTO() {
		return profileImageDTO;
	}

	public void setProfileImageDTO(ProfileImageDTO profileImageDTO) {
		this.profileImageDTO = profileImageDTO;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

	

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	public Set<ProfileImageDTO> getProfileImages() {
		return this.profileImages;
	}

	public void setProfileImages(Set<ProfileImageDTO> profileImages) {
		this.profileImages = profileImages;
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

	public Set<UserCartDTO> getUserCarts1() {
		return this.userCarts1;
	}

	public void setUserCarts1(Set<UserCartDTO> userCarts1) {
		this.userCarts1 = userCarts1;
	}




	public Set<UserPurchasedCartDTO> getUserPurchasedCartDTO() {
		return userPurchasedCartDTO;
	}

	public void setUserPurchasedCartDTO(Set<UserPurchasedCartDTO> userPurchasedCartDTO) {
		this.userPurchasedCartDTO = userPurchasedCartDTO;
	}

	public Set<UserQuestionAnswerDTO> getUserQuestionAnswers() {
		return this.userQuestionAnswers;
	}

	public void setUserQuestionAnswers(Set<UserQuestionAnswerDTO> userQuestionAnswers) {
		this.userQuestionAnswers = userQuestionAnswers;
	}

	

	public Set<UserRatingDTO> getUserRatings() {
		return this.userRatings;
	}

	public void setUserRatings(Set<UserRatingDTO> userRatings) {
		this.userRatings = userRatings;
	}

	public String getTermsNcondition() {
		return termsNcondition;
	}

	public void setTermsNcondition(String termsNcondition) {
		this.termsNcondition = termsNcondition;
	}


	public String getStringDateOfBirth() {
		return stringDateOfBirth;
	}

	public void setStringDateOfBirth(String stringDateOfBirth) {
		this.stringDateOfBirth = stringDateOfBirth;
	}


	

	public int getReview() {
		return review;
	}

	public void setReview(int review) {
		this.review = review;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getScore() {
		return score;
	}

	public Set<String> getComments() {
		return comments;
	}

	public void setComments(Set<String> comments) {
		this.comments = comments;
	}

	


}