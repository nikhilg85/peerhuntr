package com.infodart.peerhuntr.jpa.entity.user;

import java.io.Serializable;
import javax.persistence.*;



import com.infodart.peerhuntr.jpa.entity.peerRating.UserRating;
import com.infodart.peerhuntr.jpa.entity.personalityTest.PersonalityMaster;
import com.infodart.peerhuntr.jpa.entity.personalityTest.UserQuestionAnswer;
import com.infodart.peerhuntr.jpa.entity.userCart.UserCart;
import com.infodart.peerhuntr.jpa.entity.userCart.UserPurchasedCart;
import com.infodart.peerhuntr.jpa.entity.peerRating.UserAvgRating;



import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u where status=? and emailVerified=?")
public class User implements Serializable  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;

	@Column(name="contact_no")
	private String contactNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_on",updatable=false)
	private Date createdOn;

	@Column(name="user_token")
	private String userToken;

	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;

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
	
	@Column(name="referral_code")
	private String referralCode;

	private byte status;

	@Column(name="university_school")
	private String universitySchool;

	@Column(name="user_interface")
	private String userInterface;

	//bi-directional many-to-one association to ProfileImage
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name="user_id")
	private Set<ProfileImage> profileImages;

	
	//bi-directional many-to-one association to UserAvgRating
	   @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	   @JoinColumn(name="user_id")
	 
		private Set<UserAvgRating> userAvgRatings;
	   
	   @Column(name="country_code")
		private String countryCode;

		
	//bi-directional many-to-one association to DegreeMaster
	/*@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name="degree_id",insertable=false, updatable=false)
	private DegreeMaster degreeMaster;
*/
	//bi-directional many-to-one association to NationalityMaster
	@ManyToOne
	@JoinColumn(name="nationality_id" ,insertable=true, updatable=true)
	private NationalityMaster nationalityMaster;

	//bi-directional many-to-one association to PersonalityMaster
	@ManyToOne
	@JoinColumn(name="personality_type_id")
	private PersonalityMaster personalityMaster;

	//bi-directional many-to-one association to SpecializationMaster
	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name="specialization_id" ,insertable=true, updatable=true)
	private SpecializationMaster specializationMaster;

	//bi-directional many-to-one association to UserLogin
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="user_login_id",insertable=true, updatable=false)
	private UserLogin userLogin;

	//bi-directional many-to-one association to UserCart
	@OneToMany(mappedBy="userCart")
	private Set<UserCart> userCarts1;

	/*//bi-directional many-to-one association to UserCart
	@OneToMany(mappedBy="user2")
	private Set<UserCart> userCarts2;
*/
	//bi-directional many-to-one association to UserPurchasedCart
	@OneToMany(mappedBy="userCart")
	private Set<UserPurchasedCart> userPurchasedCartDTO;

	/*//bi-directional many-to-one association to UserPurchasedCart
	@OneToMany(mappedBy="user2")
	private Set<UserPurchasedCart> userPurchasedCarts2;*/

	//bi-directional many-to-one association to UserQuestionAnswer
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY)
	private Set<UserQuestionAnswer> userQuestionAnswers;

	//bi-directional many-to-one association to UserRating
	@OneToMany(mappedBy="user")
	private Set<UserRating> userRatings;
	
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expiry_date")
	private Date expirydate;
	
	
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	public User() {
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

	public Set<ProfileImage> getProfileImages() {
		return this.profileImages;
	}

	public void setProfileImages(Set<ProfileImage> profileImages) {
		this.profileImages = profileImages;
	}

	public ProfileImage addProfileImage(ProfileImage profileImage) {
		getProfileImages().add(profileImage);
		profileImage.setUser(this);

		return profileImage;
	}
	
	


	public ProfileImage removeProfileImage(ProfileImage profileImage) {
		getProfileImages().remove(profileImage);
		profileImage.setUser(null);

		return profileImage;
	}

	/*public DegreeMaster getDegreeMaster() {
		return this.degreeMaster;
	}

	public void setDegreeMaster(DegreeMaster degreeMaster) {
		this.degreeMaster = degreeMaster;
	}*/

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

	public Set<UserCart> getUserCarts1() {
		return this.userCarts1;
	}

	public void setUserCarts1(Set<UserCart> userCarts1) {
		this.userCarts1 = userCarts1;
	}

	public UserCart addUserCarts1(UserCart userCarts1) {
		getUserCarts1().add(userCarts1);
		userCarts1.setUserCart(this);

		return userCarts1;
	}

	public UserCart removeUserCarts1(UserCart userCarts1) {
		getUserCarts1().remove(userCarts1);
		userCarts1.setUserCart(null);

		return userCarts1;
	}

/*	public Set<UserCart> getUserCarts2() {
		return this.userCarts2;
	}

	public void setUserCarts2(Set<UserCart> userCarts2) {
		this.userCarts2 = userCarts2;
	}*/

	/*public UserCart addUserCarts2(UserCart userCarts2) {
		getUserCarts2().add(userCarts2);
		userCarts2.setUser2(this);

		return userCarts2;
	}

	public UserCart removeUserCarts2(UserCart userCarts2) {
		getUserCarts2().remove(userCarts2);
		userCarts2.setUser2(null);

		return userCarts2;
	}*/

	

	public UserPurchasedCart addUserPurchasedCarts1(UserPurchasedCart userPurchasedCarts1) {
		getUserPurchasedCartDTO().add(userPurchasedCarts1);
		userPurchasedCarts1.setUserCart(null);

		return userPurchasedCarts1;
	}

	public Set<UserPurchasedCart> getUserPurchasedCartDTO() {
		return userPurchasedCartDTO;
	}

	public void setUserPurchasedCartDTO(Set<UserPurchasedCart> userPurchasedCartDTO) {
		this.userPurchasedCartDTO = userPurchasedCartDTO;
	}

	public UserPurchasedCart removeUserPurchasedCarts1(UserPurchasedCart userPurchasedCartDTO) {
		getUserPurchasedCartDTO().remove(userPurchasedCartDTO);
		userPurchasedCartDTO.setUserCart(null);

		return userPurchasedCartDTO;
	}

	/*public Set<UserPurchasedCart> getUserPurchasedCarts2() {
		return this.userPurchasedCarts2;
	}

	public void setUserPurchasedCarts2(Set<UserPurchasedCart> userPurchasedCarts2) {
		this.userPurchasedCarts2 = userPurchasedCarts2;
	}*/

	/*public UserPurchasedCart addUserPurchasedCarts2(UserPurchasedCart userPurchasedCarts2) {
		getUserPurchasedCarts2().add(userPurchasedCarts2);
		userPurchasedCarts2.setUser2(this);

		return userPurchasedCarts2;
	}

	public UserPurchasedCart removeUserPurchasedCarts2(UserPurchasedCart userPurchasedCarts2) {
		getUserPurchasedCarts2().remove(userPurchasedCarts2);
		userPurchasedCarts2.setUser2(null);

		return userPurchasedCarts2;
	}*/

	public Set<UserQuestionAnswer> getUserQuestionAnswers() {
		return this.userQuestionAnswers;
	}

	public void setUserQuestionAnswers(Set<UserQuestionAnswer> userQuestionAnswers) {
		this.userQuestionAnswers = userQuestionAnswers;
	}

	public UserQuestionAnswer addUserQuestionAnswer(UserQuestionAnswer userQuestionAnswer) {
		getUserQuestionAnswers().add(userQuestionAnswer);
		userQuestionAnswer.setUser(this);

		return userQuestionAnswer;
	}

	public UserQuestionAnswer removeUserQuestionAnswer(UserQuestionAnswer userQuestionAnswer) {
		getUserQuestionAnswers().remove(userQuestionAnswer);
		userQuestionAnswer.setUser(null);

		return userQuestionAnswer;
	}

	public Set<UserRating> getUserRatings() {
		return this.userRatings;
	}

	public void setUserRatings(Set<UserRating> userRatings) {
		this.userRatings = userRatings;
	}

	public UserRating addUserRating(UserRating userRating) {
		getUserRatings().add(userRating);
		userRating.setUser(this);

		return userRating;
	}

	public UserRating removeUserRating(UserRating userRating) {
		getUserRatings().remove(userRating);
		userRating.setUser(null);

		return userRating;
	}

	public String getReferralCode() {
		return referralCode;
	}

	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}

	public Set<UserAvgRating> getUserAvgRatings() {
		return userAvgRatings;
	}

	public void setUserAvgRatings(Set<UserAvgRating> userAvgRatings) {
		this.userAvgRatings = userAvgRatings;
	}
	public UserAvgRating addUserAvgRating(UserAvgRating userAvgRating) {
		getUserAvgRatings().add(userAvgRating);
		userAvgRating.setUser(this);

		return userAvgRating;
	}

	public UserAvgRating removeUserAvgRating(UserAvgRating userAvgRating) {
		getUserAvgRatings().remove(userAvgRating);
		userAvgRating.setUser(null);

		return userAvgRating;
	}

}
