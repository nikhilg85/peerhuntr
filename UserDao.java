package com.infodart.peerhuntr.jpa.dao;




import java.util.List;

import com.infodart.peerhuntr.dto.request.RequestDTO;
import com.infodart.peerhuntr.dto.user.SpecializationMasterDTO;
import com.infodart.peerhuntr.dto.user.UserDTO;
import com.infodart.peerhuntr.dto.user.UserLoginDTO;
import com.infodart.peerhuntr.jpa.dao.impl.basedao.GenericDao;
import com.infodart.peerhuntr.jpa.entity.peerRating.RatingType;
import com.infodart.peerhuntr.jpa.entity.peerRating.UserRating;
import com.infodart.peerhuntr.jpa.entity.personalityTest.PersonalityMaster;
import com.infodart.peerhuntr.jpa.entity.user.DegreeMaster;
import com.infodart.peerhuntr.jpa.entity.user.NationalityMaster;
import com.infodart.peerhuntr.jpa.entity.user.SpecializationMaster;
import com.infodart.peerhuntr.jpa.entity.user.User;
import com.infodart.peerhuntr.jpa.entity.user.UserLogin;

public interface UserDao extends  GenericDao<User> {


	public List<DegreeMaster> findAllDegree();
	public List<NationalityMaster> findAllNationality();
	public List<SpecializationMaster>  findAllSpecialization();
	public User findByToken(String token) ;
	public boolean changePassword(UserLoginDTO userLogin);
	public boolean forgetPassword(UserLoginDTO userLogin);
	public boolean checkEmailIdExistence(UserLoginDTO userLogin);
	public List<Object> fetchAllUserProfile();
	public List<SpecializationMaster>  getSpecializationOnDegree(SpecializationMasterDTO specializationMasterDTO);
	public int getUserLoginIdByEmail(String email);
	public UserLogin getUserLogin(UserLoginDTO userLoginDTO);
	public boolean updateProfileImageURL(String imagePath,String imageBlurPath,int profileId);
	public int getUserIdByUserLogin(int userLoginId);
	public List<RatingType> fetchRatingType();
	
	//*************************************Filteration Method*******************************************************//
	public List<Object[]> fetchUsersCardWithoutParameter(RequestDTO resquestDTO,int startFirstResult,int startMaxResult,int userID); //Fetch User  without paramter
    public Integer getUserCount();
    public boolean updateCustomer(User user);
    public List<Object[]> getUserProfileActiveUser(int userId);
    public List<NationalityMaster> getNationalitySuggetionList(String keyname);
    public List<SpecializationMaster> getSpecializationSuggetionList(String keyname);
    public List<DegreeMaster> getDegreeSuggetionList(String keyname);
    public List<PersonalityMaster> getPersonalityMasterSuggetionList(String keyname);//
    public List<Object[]> getUserByNationalityList(String key,String rating,int startFirstResult,int startMaxResult,int userID);
    public List<Object[]> getUserByDegreeList(String key,String rating,int startFirstResult,int startMaxResult,int userID);
    public List<Object[]> getUserBySpecialization(String key,String rating,int startFirstResult,int startMaxResult,int userID);
    public List<Object[]> getUserByPersonalityMasterList(String key,String rating,int startFirstResult,int startMaxResult,int userID);
    public Integer getCountUserByNationality(String key,int userID);
    public Integer getCountUserByDegree(String key,int userID);
    public Integer getCountUserByPersonality(String key,int userID); 
    public Integer getCountUserBySpecialization(String key,int userID); 
    public boolean updateReferralCode(User user);
    public User getReferralCode(UserLoginDTO userLoginDTO);
    public int getUserLoginIdByReferralCode(String referralCode);
    public List<Object[]> getUserBySortByRating(String sortbyRating,int startFirstResult,int startMaxResult,int userID);
    public Integer getUserBySortByRatingCount(String sortbyRating,int userID);
    public List<Object[]> getUserSortByRatingAndNationality(String sortyByRatingVal,String key,int startFirstResult,int startMaxResult,int userID);
    public List<Object[]> getUserSortByRatingAndByDegreeList(String key,String rating,int startFirstResult,int startMaxResult,int userID);
    public List<Object[]> getUserSortByRatingAndBySpecialization(String key,String rating,int startFirstResult,int startMaxResult,int userID);
    public List<Object[]> getUserSortByRatingAndByPersonalityMasterList(String key,String rating,int startFirstResult,int startMaxResult,int userID);
    public Integer getCountUserSortByRatingAndNationality(String sortyByRatingVal,String key,int userID);
    public Integer getCountUserSortByRatingAndByDegreeList(String key,String rating,int userID);
    public Integer getCountUserSortByRatingAndBySpecialization(String key,String rating,int userID);
    public Integer getCountUserSortByRatingAndByPersonalityMasterList(String key,String rating,int userID);
	
    
    public Integer fetchUsersCardWithoutParameterCount(RequestDTO resquestDTO,int userID);
	public List<Object[]> getUserList(List<String> nationalityData, List<String> specializationData,
			List<String> personalityData, List<String> degreeData, int startFirstResult,
			int startMaxResult, int userID);

	public Integer getUserListCount(List<String> nationalityData, List<String> specializationData,
			List<String> personalityData, List<String> degreeData, int userID) ;
	
	public List<Object[]> getUsersListSortByRating(List<String> nationalityData, List<String> specializationData,
			List<String> personalityData, List<String> degreeData,String rating, int startFirstResult, int startMaxResult, int userID);
	public Integer getCountUsersListSortByRating(List<String> nationalityData, List<String> specializationData,
			List<String> personalityData, List<String> degreeData,String rating,int userID);
    
}
