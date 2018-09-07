package com.infodart.peerhuntr.jpa.dao.impl;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infodart.peerhuntr.dto.request.RequestDTO;
import com.infodart.peerhuntr.dto.user.SpecializationMasterDTO;
import com.infodart.peerhuntr.dto.user.UserLoginDTO;
import com.infodart.peerhuntr.jpa.dao.UserDao;
import com.infodart.peerhuntr.jpa.dao.impl.basedao.AbstractGenericDao;
import com.infodart.peerhuntr.jpa.entity.peerRating.RatingType;
import com.infodart.peerhuntr.jpa.entity.personalityTest.PersonalityMaster;
import com.infodart.peerhuntr.jpa.entity.user.DegreeMaster;
import com.infodart.peerhuntr.jpa.entity.user.NationalityMaster;
import com.infodart.peerhuntr.jpa.entity.user.SpecializationMaster;
import com.infodart.peerhuntr.jpa.entity.user.User;
import com.infodart.peerhuntr.jpa.entity.user.UserLogin;
import com.infodart.peerhuntr.util.AppUtil;



@Repository
public class UserDaoImpl extends AbstractGenericDao<User>  implements UserDao  {

	Session session = null;  
	@Autowired
	private SessionFactory sessionFactory;

	public boolean changePassword(UserLoginDTO userLogin) {

		try {
			Query query= getSession().createQuery("update UserLogin set loginPassword=? where userLoginId=?")
					.setParameter(0, userLogin.getLoginPassword())
					.setParameter(1, userLogin.getUserLoginId());
			int a= query.executeUpdate();
			System.out.println(a);
			return true;



		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}



	}

	public boolean forgetPassword(UserLoginDTO userLogin) {

		try {
			Query query= getSession().createQuery("update UserLogin set loginPassword=? where loginId=?")
					.setParameter(0, userLogin.getLoginPassword())
					.setParameter(1, userLogin.getLoginId());
			int a= query.executeUpdate();
			System.out.println(a);
			return true;



		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}



	}

	@Override
	public List<DegreeMaster> findAllDegree() {

		Query query = getSession().getNamedQuery("DegreeMaster.findAll");
		List<DegreeMaster> degreeMasters = query.list();
		return degreeMasters;
	}

	@Override
	public List<NationalityMaster> findAllNationality() {
		Query query = getSession().getNamedQuery("NationalityMaster.findAll");
		List<NationalityMaster> nationalityMaster = query.list();
		return nationalityMaster;
	}

	@Override
	public List<SpecializationMaster> findAllSpecialization() {
		Query query = getSession().getNamedQuery("SpecializationMaster.findAll");
		List<SpecializationMaster> specializationMaster = query.list();
		return specializationMaster;
	}

	@Override
	public User findByToken(String token) {	
		String hql = "from User s where s.userToken = :userToken";
		List<User> result = getSession().createQuery(hql)
				.setParameter("userToken", token)
				.list();

		if(result==null || result.size()==0)
			return null;

		return result.get(0);
	}

	@Override
	public int getUserIdByUserLogin(int userLoginId) {
		List<User> test = sessionFactory.getCurrentSession() .createQuery("from User where userLogin.userLoginId=?")
				.setParameter(0, userLoginId).list();
		return test.get(0).getUserId();
	}
	@Override
	public boolean checkEmailIdExistence(UserLoginDTO userLogin) {
		try {
			List<UserLogin> users = new ArrayList<UserLogin>();
			users = getSession() .createQuery("from UserLogin where loginId=?")
					.setParameter(0, userLogin.getLoginId()).list();
			if (users.size() > 0) {
				return true;
			} else {
				return false;
			} 

		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}


	}
	@Override
	public UserLogin getUserLogin(UserLoginDTO userLoginDTO) {
		try {
			List<UserLogin> userLogin = new ArrayList<UserLogin>();
			userLogin = getSession() .createQuery("from UserLogin where userLoginId=?")
					.setParameter(0, userLoginDTO.getUserLoginId()).list();
			if (userLogin.size() > 0) {
				return userLogin.get(0);
			} 

		}catch(Exception e) {
			e.printStackTrace();

		}

		return null;
	}

	@Override
	public List<Object> fetchAllUserProfile() {
		List<Object> users=null;
		try {
			Query query = getSession().getNamedQuery("User.findAll")
					.setParameter(0, (byte)1)
					.setParameter(1, (byte)1);
			users = query.list();

		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public List<SpecializationMaster> getSpecializationOnDegree(SpecializationMasterDTO specializationMasterDTO) {
		List<SpecializationMaster> specializationMaster=null ;
		try {

			Query query= getSession().createQuery("from SpecializationMaster where degreeMaster.degreeId=? and status=?")
					.setParameter(0, specializationMasterDTO.getDegreeMaster().getDegreeId())
					.setParameter(1, (byte)1);
			specializationMaster = query.list();




		}catch(Exception e) {
			e.printStackTrace();

		}


		return specializationMaster;

	}

	@Override
	public int getUserLoginIdByEmail(String email) {

		String hql = "from UserLogin u where u.loginId = :email";
		List<UserLogin> result = getSession().createQuery(hql)
				.setParameter("email", email)
				.list();


		return result.get(0).getUserLoginId();

	}
	public boolean updateProfileImageURL(String imagePath,String imageBlurPath,int profileId) {


		try {
			Query query= getSession().createQuery("update ProfileImage set imageUrl=? , hiddenImageUrl=? where profileImageId=?")
					.setParameter(0, imagePath)
					.setParameter(1, imageBlurPath)
					.setParameter(2, profileId);
			int a= query.executeUpdate();
			System.out.println(a);
			return true;



		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}




	}

	@Override
	public Integer getUserCount() {
		// TODO Auto-generated method stub

		Query query= getSession().createQuery("from User  where  status='1'");

		List<User> list = query.list();
		Integer siInteger=list.size();

		return siInteger;
	}	


	@Override
	public boolean updateCustomer(User user) {



		try {
			String queryStr="update User set modified_on='"+AppUtil.getCurrentDateString()+"',";
			/*if(user.getNationalityMaster()!=null) {
				if(user.getNationalityMaster().getNationality()!=null || user.getNationalityMaster().getNationalityId()!=0)
					queryStr+=" nationalityMaster.nationalityId="+user.getNationalityMaster().getNationalityId()+",";
			}*/

			if(user.getSpecializationMaster()!=null) {
				if(user.getSpecializationMaster().getSpecializationName()!=null || user.getSpecializationMaster().getSpecializationId()!=0)
					queryStr+=" specializationMaster.specializationId="+user.getSpecializationMaster().getSpecializationId()+",";

				/*if(user.getSpecializationMaster().getDegreeMaster()!=null) {
					if(user.getSpecializationMaster().getDegreeMaster().getDegreeName()!=null || user.getSpecializationMaster().getDegreeMaster().getDegreeId()!=0) {
						queryStr+=" specializationMaster.degreeMaster.degreeId="+user.getSpecializationMaster().getDegreeMaster().getDegreeId()+",";
			}

			}*/
			}

			if(user.getNationalityMaster()!=null) {

				queryStr+=" nationalityMaster.nationalityId="+user.getNationalityMaster().getNationalityId()+",";

			}

			if(user.getUniversitySchool()!=null)
				queryStr+=" universitySchool='"+user.getUniversitySchool()+"',";

			if(user.getContactNo()!=null)
				queryStr+=" contactNo='"+user.getContactNo()+"',";

			if(user.getCountryCode()!=null)
				queryStr+=" countryCode='"+user.getCountryCode()+"',";



			if (queryStr.endsWith(",")) {
				queryStr = queryStr.substring(0, queryStr.length() - 1);
			}
			if(user.getProfileImages()!=null) {

			}


			queryStr+=" where userId="+user.getUserId();
			Query query= getSession().createQuery(queryStr);
			int a= query.executeUpdate();
			System.out.println(a);
			return true;



		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}





	}

	@Override
	public List<Object[]> getUserProfileActiveUser(int userId) {

		List<Object[]> users = null;
		users = sessionFactory.getCurrentSession() .createQuery("SELECT sum(av.avgRatingValue*av.totalReviews)/(av.totalReviews*8),av.totalReviews,u  FROM User u  LEFT JOIN u.userAvgRatings av where u.userId=? and u.status=?  group by u.userId  order by u.userId desc")
				.setParameter(0, userId)
				.setParameter(1, (byte)1).list();

		/*	users = sessionFactory.getCurrentSession() .createQuery("from User u where u.userId=? and u.status=? ")
				.setParameter(0, userId)
				.setParameter(1, (byte)1).list();*/
		if (users.size() > 0) {
			return users;
		} else {
			return null;
		}
	}

	@Override
	public List<NationalityMaster> getNationalitySuggetionList( String keyname) {
		// TODO Auto-generated method stub
		List<NationalityMaster> nationalityMasterList=null;

		try {
			String key= '%'+keyname+'%';
			String hql = "from NationalityMaster nm where nm.nationality like :nationality and status='1' order by nm.nationality";
			nationalityMasterList = getSession().createQuery(hql)
					.setParameter("nationality", key)
					.list();

		}catch (Exception e) {
			// TODO: handle exception
		}






		return nationalityMasterList;
	}

	@Override
	public List<SpecializationMaster> getSpecializationSuggetionList(String keyname) {
		// TODO Auto-generated method stub
		List<SpecializationMaster> specializationMasters=null;

		try {
			String key= '%'+keyname+'%';
			String hql = "from SpecializationMaster sm where sm.specializationName like :specializationName and status='1' group by sm.specializationName order by sm.specializationName";
			specializationMasters = getSession().createQuery(hql)
					.setParameter("specializationName", key)
					.list();

		}catch (Exception e) {
			// TODO: handle exception
		}


		return specializationMasters;
	}

	@Override
	public List<DegreeMaster> getDegreeSuggetionList(String keyname) {
		// TODO Auto-generated method stub
		List<DegreeMaster> degreeMasters=null;

		try {
			String key= '%'+keyname+'%';
			String hql = "from DegreeMaster dm where dm.degreeName like :degreeName and status='1'";
			degreeMasters = getSession().createQuery(hql)
					.setParameter("degreeName", key)
					.list();

		}catch (Exception e) {
			// TODO: handle exception
		}


		return degreeMasters;
	}

	@Override
	public List<PersonalityMaster> getPersonalityMasterSuggetionList(String keyname) {

		// TODO Auto-generated method stub
		List<PersonalityMaster> personalityMasters=null;

		try {
			String key= '%'+keyname+'%';
			String hql = "from PersonalityMaster pm where pm.personalityRole like :personalityRole and status='1'";
			personalityMasters = getSession().createQuery(hql)
					.setParameter("personalityRole", key)
					.list();

		}catch (Exception e) {
			// TODO: handle exception
		}


		return personalityMasters;

	}


	@Override
	public List<Object[]> getUserByNationalityList(String key,String rating,int startFirstResult,int startMaxResult,int userID) {

		key= '%'+key+'%';
		String SQL_QUERY = "SELECT sum(av.avgRatingValue*av.totalReviews)/(av.totalReviews*8),av.totalReviews,u  FROM User u  LEFT JOIN u.userAvgRatings av where u.status='1' and u.userId!=? and  u.nationalityMaster.nationality like :nationality group by u.userId  order by u.userId desc";
		List<Object[]> list=null;
		Query query= getSession().createQuery(SQL_QUERY);
		query.setParameter("nationality", key);
		query.setParameter(0,userID);
		query.setFirstResult(startFirstResult);
		query.setMaxResults(startMaxResult);
		list = query.list();
		return list;

	}

	@Override
	public List<Object[]> getUserByDegreeList(String key,String rating,int startFirstResult,int startMaxResult,int userID) {
		key= '%'+key+'%';
		String SQL_QUERY = "SELECT sum(av.avgRatingValue*av.totalReviews)/(av.totalReviews*8),av.totalReviews,u  FROM User u  LEFT JOIN u.userAvgRatings av where u.status='1' and u.userId!=? and  u.specializationMaster.degreeMaster.degreeName like :degreename group by u.userId  order by u.userId desc";   
		List<Object[]> list=null;
		Query query= getSession().createQuery(SQL_QUERY);
		query.setParameter("degreename", key);
		query.setParameter(0,userID);
		query.setFirstResult(startFirstResult);
		query.setMaxResults(startMaxResult);
		list = query.list();
		return list;

	}

	@Override
	public List<Object[]> getUserBySpecialization(String key,String rating,int startFirstResult,int startMaxResult,int userID) {


		key= '%'+key+'%';
		String SQL_QUERY = "SELECT sum(av.avgRatingValue*av.totalReviews)/(av.totalReviews*8),av.totalReviews,u  FROM User u  LEFT JOIN u.userAvgRatings av where u.status='1' and u.userId!=? and  u.specializationMaster.specializationName like :specializationName group by u.userId  order by u.userId desc";
		List<Object[]> list=null;
		Query query= getSession().createQuery(SQL_QUERY);
		query.setParameter("specializationName", key);
		query.setParameter(0,userID);
		query.setFirstResult(startFirstResult);
		query.setMaxResults(startMaxResult);
		list = query.list();
		return list;

	}

	@Override
	public List<Object[]> getUserByPersonalityMasterList(String key,String rating,int startFirstResult,int startMaxResult,int userID) {

		// TODO Auto-generated method stub
		String SQL_QUERY = "SELECT sum(av.avgRatingValue*av.totalReviews)/(av.totalReviews*8),av.totalReviews,u  FROM User u  LEFT JOIN u.userAvgRatings av where u.status='1' and u.userId!=? and  u.personalityMaster.personalityRole =? group by u.userId  order by u.userId desc";
		List<Object[]> list=null;
		Query query= getSession().createQuery(SQL_QUERY);
		query.setParameter(0,userID);
		query.setParameter(1, key);
		query.setFirstResult(startFirstResult);
		query.setMaxResults(startMaxResult);
		list = query.list();
		return list;


	}

	@Override
	public List<Object[]> fetchUsersCardWithoutParameter(RequestDTO resquestDTO, int startFirstResult, int startMaxResult,int userID) {
		// TODO Auto-generated method stub
		List<Object[]> users=null;
		String SQL_QUERY = "SELECT sum(av.avgRatingValue*av.totalReviews)/(av.totalReviews*8),av.totalReviews,u  FROM User u  LEFT JOIN u.userAvgRatings av where u.status='1' and u.userId!=? group by u.userId  order by u.userId desc";
		Query query= getSession().createQuery(SQL_QUERY);
		query.setParameter(0,userID);
		query.setFirstResult(startFirstResult);
		query.setMaxResults(startMaxResult);
		users = query.list();
		return users;
	}

	@Override
	public Integer fetchUsersCardWithoutParameterCount(RequestDTO resquestDTO,int userID) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		String SQL_QUERY = "SELECT count(*) FROM User u LEFT JOIN u.userAvgRatings av where u.status='1' and u.userId!=? group by u.userId  order by u.userId desc";
		Query query= getSession().createQuery(SQL_QUERY);
		query.setParameter(0,userID);
		list = query.list();
		return Integer.parseInt(""+list.size());
	}

	@Override
	public Integer getCountUserByNationality(String key,int userID) {

		key= '%'+key+'%';
		String SQL_QUERY = "SELECT count(*) FROM User u  LEFT JOIN u.userAvgRatings av where u.status='1' and u.userId!=? and   u.nationalityMaster.nationality like :nationality group by u.userId  order by u.userId desc";
		List<Object[]> list=null;
		Query query= getSession().createQuery(SQL_QUERY);
		query.setParameter(0,userID);
		query.setParameter("nationality", key);
		list = query.list();
		return Integer.parseInt(""+list.size());

	}



	@Override
	public Integer getCountUserByDegree(String key,int userID) {
		key= '%'+key+'%';
		String SQL_QUERY = "SELECT count(*)  FROM User u  LEFT JOIN u.userAvgRatings av where u.status='1' and u.userId!=? and  u.specializationMaster.degreeMaster.degreeName like :degreename group by u.userId  order by u.userId desc";
		List<Object[]> list=null;
		Query query= getSession().createQuery(SQL_QUERY);
		query.setParameter("degreename", key);
		query.setParameter(0,userID);
		list = query.list();
		return Integer.parseInt(""+list.size());

	}

	@Override
	public Integer getCountUserByPersonality(String key,int userID) {
		// TODO Auto-generated method stub

		String SQL_QUERY = "SELECT count(*)  FROM User u  LEFT JOIN u.userAvgRatings av where u.status='1' and u.userId!=? and  u.personalityMaster.personalityRole =? group by u.userId  order by u.userId desc";
		List<Object[]> list=null;
		Query query= getSession().createQuery(SQL_QUERY);
		query.setParameter(0,userID);
		query.setParameter(1, key);
		list = query.list();
		return Integer.parseInt(""+list.size());

	}

	@Override
	public boolean updateReferralCode(User user) {


		try {
			Query query= getSession().createQuery("update User set referralCode=? where userId=?")
					.setParameter(0, user.getReferralCode())
					.setParameter(1, user.getUserId());
			int a= query.executeUpdate();
			System.out.println(a);
			return true;



		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getReferralCode(UserLoginDTO userLoginDTO) {
		List<User> test = sessionFactory.getCurrentSession() .createQuery("from User where userLogin.loginId=?")
				.setParameter(0, userLoginDTO.getLoginId()).list();
		return test.get(0);
	}

	@Override
	public int getUserLoginIdByReferralCode(String referralCode) {
		int userLoginId=0;
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("SELECT user_login_id from user where referral_code='"+referralCode+"'");

		List<Integer> rows = query.list();
		for(Integer row : rows){
			userLoginId=row;

		}
		session.close();
		return userLoginId;
	}


	@Override
	public List<Object[]> getUserBySortByRating(String sortbyRating,int startFirstResult,int startMaxResult,int userID) {
		// TODO Auto-generated method stub
		String SQL_QUERY = "SELECT sum(av.avgRatingValue*av.totalReviews)/(av.totalReviews*8),av.totalReviews,u  FROM User u  RIGHT JOIN u.userAvgRatings av where u.status='1' and u.userId!=?  group by av.user.userId  having sum((av.avgRatingValue*av.totalReviews)/(av.totalReviews*8))>=? order by u.userId desc";
		Query query= getSession().createQuery(SQL_QUERY);
		query.setFirstResult(startFirstResult);
		query.setMaxResults(startMaxResult);
		query.setParameter(0,userID);
		query.setParameter(1, Double.parseDouble(sortbyRating));
		List<Object[]> usersObject = query.list();
		return  usersObject;  


	}


	@Override
	public Integer getUserBySortByRatingCount(String sortbyRating,int userID) {

		// TODO Auto-generated method stub
		List<User> list=null;

		String SQL_QUERY = "SELECT count(*) FROM User u  RIGHT JOIN u.userAvgRatings av where u.status='1' and u.userId!=? group by av.user.userId  having sum((av.avgRatingValue*av.totalReviews)/(av.totalReviews*8))>=? order by u.userId desc";
		Query query= getSession().createQuery(SQL_QUERY);
		query.setParameter(0,userID);
		query.setParameter(1, Double.parseDouble(sortbyRating));
		list = query.list();
		return Integer.parseInt(""+list.size());

	}

	@Override
	public List<Object[]> getUserSortByRatingAndNationality(String sortyByRatingVal, String key,
			int startFirstResult, int startMaxResult,int userID) {
		key= '%'+key+'%';
		// TODO Auto-generated method stub
		String SQL_QUERY = "SELECT sum(av.avgRatingValue*av.totalReviews)/(av.totalReviews*8), av.totalReviews,u  FROM User u  RIGHT JOIN u.userAvgRatings av where u.status='1' and u.userId!=? and  u.nationalityMaster.nationality like :nationality  group by av.user.userId  having sum((av.avgRatingValue*av.totalReviews)/(av.totalReviews*8))>=:rating order by u.userId desc";
		Query query= getSession().createQuery(SQL_QUERY);
		query.setFirstResult(startFirstResult);
		query.setMaxResults(startMaxResult);
		query.setParameter("nationality", key);
		query.setParameter("rating", Double.parseDouble(sortyByRatingVal));
		query.setParameter(0,userID);
		List<Object[]> usersObject = query.list();
		return  usersObject;  



	}

	@Override
	public Integer getCountUserBySpecialization(String key,int userID) {

		key= '%'+key+'%';
		String SQL_QUERY = "SELECT count(*)  FROM User u  LEFT JOIN u.userAvgRatings av where u.status='1' and u.userId!=? and  u.specializationMaster.specializationName like :specializationName group by u.userId  order by u.userId desc";
		List<Object[]> list=null;
		Query query= getSession().createQuery(SQL_QUERY);
		query.setParameter("specializationName", key);
		query.setParameter(0,userID);
		list = query.list();
		return Integer.parseInt(""+list.size());
	}

	@Override
	public List<Object[]> getUserSortByRatingAndByDegreeList(String key, String rating, int startFirstResult,
			int startMaxResult,int userID) {
		key= '%'+key+'%';
		// TODO Auto-generated method stub
		String SQL_QUERY = "SELECT sum(av.avgRatingValue*av.totalReviews)/(av.totalReviews*8),av.totalReviews,u  FROM User u  RIGHT JOIN u.userAvgRatings av where u.status='1'  and u.userId!=? and  u.specializationMaster.degreeMaster.degreeName like :degreeName  group by av.user.userId  having sum((av.avgRatingValue*av.totalReviews)/(av.totalReviews*8))>=:rating order by u.userId desc";
		Query query= getSession().createQuery(SQL_QUERY);
		query.setFirstResult(startFirstResult);
		query.setMaxResults(startMaxResult);
		query.setParameter("degreeName", key);
		query.setParameter("rating", Double.parseDouble(rating));
		query.setParameter(0,userID);
		List<Object[]> usersObject = query.list();
		return  usersObject;  
	}

	@Override
	public List<Object[]> getUserSortByRatingAndBySpecialization(String key, String rating, int startFirstResult,
			int startMaxResult,int userID) {
		key= '%'+key+'%';
		// TODO Auto-generated method stub
		String SQL_QUERY = "SELECT sum(av.avgRatingValue*av.totalReviews)/(av.totalReviews*8),av.totalReviews,u  FROM User u  RIGHT JOIN u.userAvgRatings av where u.status='1'  and u.userId!=? and  u.specializationMaster.specializationName like :specializationName  group by av.user.userId  having sum((av.avgRatingValue*av.totalReviews)/(av.totalReviews*8))>=:rating order by u.userId desc";
		Query query= getSession().createQuery(SQL_QUERY);
		query.setFirstResult(startFirstResult);
		query.setMaxResults(startMaxResult);
		query.setParameter("specializationName", key);
		query.setParameter("rating", Double.parseDouble(rating));
		query.setParameter(0,userID);
		List<Object[]> usersObject = query.list();
		return  usersObject;  



	}

	@Override
	public List<Object[]> getUserSortByRatingAndByPersonalityMasterList(String key, String rating, int startFirstResult,
			int startMaxResult,int userID) {

		key= '%'+key+'%';
		// TODO Auto-generated method stub
		String SQL_QUERY = "SELECT sum(av.avgRatingValue*av.totalReviews)/(av.totalReviews*8), av.totalReviews,u  FROM User u  RIGHT JOIN u.userAvgRatings av where u.status='1' and u.userId!=? and  u.personalityMaster.personalityRole like :personalityRole  group by av.user.userId  having sum((av.avgRatingValue*av.totalReviews)/(av.totalReviews*8))>=:rating order by u.userId desc";
		Query query= getSession().createQuery(SQL_QUERY);
		query.setFirstResult(startFirstResult);
		query.setMaxResults(startMaxResult);
		query.setParameter("personalityRole", key);
		query.setParameter("rating", Double.parseDouble(rating));
		query.setParameter(0,userID);
		List<Object[]> usersObject = query.list();
		return  usersObject;  




	}

	@Override
	public Integer getCountUserSortByRatingAndNationality(String sortyByRatingVal, String key,int userID) {

		key= '%'+key+'%';
		// TODO Auto-generated method stub
		String SQL_QUERY = "SELECT count(*)  FROM User u  RIGHT JOIN u.userAvgRatings av where u.status='1' and u.userId!=? and  u.nationalityMaster.nationality like :nationality  group by av.user.userId  having sum((av.avgRatingValue*av.totalReviews)/(av.totalReviews*8))>=:rating order by u.userId desc";
		Query query= getSession().createQuery(SQL_QUERY);
		query.setParameter("nationality", key);
		query.setParameter("rating", Double.parseDouble(sortyByRatingVal));
		query.setParameter(0,userID);
		List<Object[]> usersObject = query.list();
		return Integer.parseInt(""+usersObject.size());
	}

	@Override
	public Integer getCountUserSortByRatingAndByDegreeList(String key, String rating,int userID) {

		key= '%'+key+'%';
		String SQL_QUERY = "SELECT count(*)  FROM User u  LEFT JOIN u.userAvgRatings av where u.status='1' and u.userId!=? and  u.specializationMaster.degreeMaster.degreeName like :degreeName group by u.userId  order by u.userId desc";
		List<Object[]> list=null;
		Query query= getSession().createQuery(SQL_QUERY);
		query.setParameter("degreeName", key);
		query.setParameter(0,userID);
		list = query.list();
		return Integer.parseInt(""+list.size());

	}

	@Override
	public Integer getCountUserSortByRatingAndBySpecialization(String key, String rating,int userID) {
		key= '%'+key+'%';
		// TODO Auto-generated method stub
		String SQL_QUERY = "SELECT count(*) FROM User u  RIGHT JOIN u.userAvgRatings av where u.status='1' and u.userId!=? and  u.specializationMaster.specializationName like :specializationName  group by av.user.userId  having sum((av.avgRatingValue*av.totalReviews)/(av.totalReviews*8))>=:rating order by u.userId desc";
		Query query= getSession().createQuery(SQL_QUERY);
		query.setParameter("specializationName", key);
		query.setParameter("rating", Double.parseDouble(rating));
		query.setParameter(0,userID);
		List<Object[]> usersObject = query.list();
		return Integer.parseInt(""+usersObject.size());
	}

	@Override
	public Integer getCountUserSortByRatingAndByPersonalityMasterList(String key, String rating,int userID) {

		key= '%'+key+'%';
		// TODO Auto-generated method stub
		String SQL_QUERY = "SELECT count(*)  FROM User u  RIGHT JOIN u.userAvgRatings av where u.status='1' and u.userId!=? and  u.personalityMaster.personalityRole like :personalityRole  group by av.user.userId  having sum((av.avgRatingValue*av.totalReviews)/(av.totalReviews*8))>=:rating order by u.userId desc";
		Query query= getSession().createQuery(SQL_QUERY);
		query.setParameter("personalityRole", key);
		query.setParameter("rating", Double.parseDouble(rating));
		query.setParameter(0,userID);
		List<Object[]> usersObject = query.list();
		return Integer.parseInt(""+usersObject.size()); 
	}

	@Override
	public List<RatingType> fetchRatingType() {


		Query query = getSession().getNamedQuery("RatingType.findAll");
		return query.list();
	}



	@Override
	public List<Object[]> getUserList(List<String> nationalityData, List<String> specializationData,
			List<String> personalityData, List<String> degreeData, int startFirstResult,
			int startMaxResult, int userID) {

		String SQL_QUERY = "SELECT sum(av.avgRatingValue*av.totalReviews)/(av.totalReviews*8),av.totalReviews,u FROM User u  LEFT JOIN u.userAvgRatings av where u.status='1' and u.userId!=? "
				+ "";
		if(!nationalityData.isEmpty()) {
			SQL_QUERY= SQL_QUERY+ " and u.nationalityMaster.nationality in(";
			{
				Iterator iterator = (Iterator) nationalityData.iterator();
				while (iterator.hasNext()) {
					SQL_QUERY=SQL_QUERY+"'"+iterator.next()+"',";
				}
				SQL_QUERY=SQL_QUERY.substring(0, SQL_QUERY.length()-1);
				SQL_QUERY=SQL_QUERY+")";
			}

		}

		if(!specializationData.isEmpty()) {
			SQL_QUERY= SQL_QUERY+ " and  u.specializationMaster.specializationName in(";
			{
				Iterator iterator = (Iterator) specializationData.iterator();
				while (iterator.hasNext()) {
					SQL_QUERY=SQL_QUERY+"'"+iterator.next().toString()+"',";
				}
				SQL_QUERY=SQL_QUERY.substring(0, SQL_QUERY.length()-1);
				SQL_QUERY=SQL_QUERY+")";
			}
		}

		if(!personalityData.isEmpty()) {
			SQL_QUERY= SQL_QUERY+ " and u.personalityMaster.personalityRole in(";
			{
				Iterator iterator = (Iterator) personalityData.iterator();
				while (iterator.hasNext()) {
					SQL_QUERY=SQL_QUERY+"'"+iterator.next().toString()+"',";
				}
				SQL_QUERY=SQL_QUERY.substring(0, SQL_QUERY.length()-1);
				SQL_QUERY=SQL_QUERY+")";
			}
		}
		if(!degreeData.isEmpty()) {
			SQL_QUERY= SQL_QUERY+ " and u.specializationMaster.degreeMaster.degreeName in(";
			{
				Iterator iterator = (Iterator) degreeData.iterator();
				while (iterator.hasNext()) {
					SQL_QUERY=SQL_QUERY+"'"+iterator.next().toString()+"',";
				}
				SQL_QUERY=SQL_QUERY.substring(0, SQL_QUERY.length()-1);
				SQL_QUERY=SQL_QUERY+")";
			}
		}

		SQL_QUERY=SQL_QUERY+"group by u.userId  order by u.userId desc";
		
		Query query= getSession().createQuery(SQL_QUERY);
		query.setParameter(0,userID);
		query.setFirstResult(startFirstResult);
		query.setMaxResults(startMaxResult);
		List<Object[]> usersObject = query.list();
		return usersObject;
	}

	@Override
	public Integer getUserListCount(List<String> nationalityData, List<String> specializationData,
			List<String> personalityData, List<String> degreeData, int userID) {
						
		String SQL_QUERY = "SELECT count(*) FROM User u  LEFT JOIN u.userAvgRatings av where u.status='1' and u.userId!=? "
				+ "";
		if(!nationalityData.isEmpty()) {
			SQL_QUERY= SQL_QUERY+ "and u.nationalityMaster.nationality in(";
			{
				Iterator iterator = (Iterator) nationalityData.iterator();
				while (iterator.hasNext()) {
					SQL_QUERY=SQL_QUERY+"'"+iterator.next()+"',";
				}
				SQL_QUERY=SQL_QUERY.substring(0, SQL_QUERY.length()-1);
				SQL_QUERY=SQL_QUERY+")";
			}

		}

		if(!specializationData.isEmpty()) {
			SQL_QUERY= SQL_QUERY+ " and  u.specializationMaster.specializationName in(";
			{
				Iterator iterator = (Iterator) specializationData.iterator();
				while (iterator.hasNext()) {
					SQL_QUERY=SQL_QUERY+"'"+iterator.next().toString()+"',";
				}
				SQL_QUERY=SQL_QUERY.substring(0, SQL_QUERY.length()-1);
				SQL_QUERY=SQL_QUERY+")";
			}
		}

		if(!personalityData.isEmpty()) {
			SQL_QUERY= SQL_QUERY+ " and u.personalityMaster.personalityRole in(";
			{
				Iterator iterator = (Iterator) personalityData.iterator();
				while (iterator.hasNext()) {
					SQL_QUERY=SQL_QUERY+"'"+iterator.next().toString()+"',";
				}
				SQL_QUERY=SQL_QUERY.substring(0, SQL_QUERY.length()-1);
				SQL_QUERY=SQL_QUERY+")";
			}
		}
		if(!degreeData.isEmpty()) {
			SQL_QUERY= SQL_QUERY+ " and u.specializationMaster.degreeMaster.degreeName in(";
			{
				Iterator iterator = (Iterator) degreeData.iterator();
				while (iterator.hasNext()) {
					SQL_QUERY=SQL_QUERY+"'"+iterator.next().toString()+"',";
				}
				SQL_QUERY=SQL_QUERY.substring(0, SQL_QUERY.length()-1);
				SQL_QUERY=SQL_QUERY+")";
			}
		}

		SQL_QUERY=SQL_QUERY+" group by u.userId  order by u.userId desc";
		
		Query query= getSession().createQuery(SQL_QUERY);
		query.setParameter(0,userID);
		List<Object[]> usersObject = query.list();
		return Integer.parseInt(""+usersObject.size());
	}

	public List<Object[]> getUsersListSortByRating(List<String> nationalityData, List<String> specializationData,
			List<String> personalityData, List<String> degreeData,String rating, int startFirstResult, int startMaxResult,int userID){
	
	String SQL_QUERY = "SELECT sum(av.avgRatingValue*av.totalReviews)/(av.totalReviews*8), av.totalReviews,u  FROM User u  RIGHT JOIN u.userAvgRatings av where u.status='1' and u.userId!=?";
	
	if(!nationalityData.isEmpty()) {
		SQL_QUERY= SQL_QUERY+ " and u.nationalityMaster.nationality in(";
		{
			Iterator iterator = (Iterator) nationalityData.iterator();
			while (iterator.hasNext()) {
				SQL_QUERY=SQL_QUERY+"'"+iterator.next()+"',";
			}
			SQL_QUERY=SQL_QUERY.substring(0, SQL_QUERY.length()-1);
			SQL_QUERY=SQL_QUERY+")";
		}

	}

	if(!specializationData.isEmpty()) {
		SQL_QUERY= SQL_QUERY+ " and  u.specializationMaster.specializationName in(";
		{
			Iterator iterator = (Iterator) specializationData.iterator();
			while (iterator.hasNext()) {
				SQL_QUERY=SQL_QUERY+"'"+iterator.next().toString()+"',";
			}
			SQL_QUERY=SQL_QUERY.substring(0, SQL_QUERY.length()-1);
			SQL_QUERY=SQL_QUERY+")";
		}
	}

	if(!personalityData.isEmpty()) {
		SQL_QUERY= SQL_QUERY+ " and u.personalityMaster.personalityRole in(";
		{
			Iterator iterator = (Iterator) personalityData.iterator();
			while (iterator.hasNext()) {
				SQL_QUERY=SQL_QUERY+"'"+iterator.next().toString()+"',";
			}
			SQL_QUERY=SQL_QUERY.substring(0, SQL_QUERY.length()-1);
			SQL_QUERY=SQL_QUERY+")";
		}
	}
	if(!degreeData.isEmpty()) {
		SQL_QUERY= SQL_QUERY+ " and u.specializationMaster.degreeMaster.degreeName in(";
		{
			Iterator iterator = (Iterator) degreeData.iterator();
			while (iterator.hasNext()) {
				SQL_QUERY=SQL_QUERY+"'"+iterator.next().toString()+"',";
			}
			SQL_QUERY=SQL_QUERY.substring(0, SQL_QUERY.length()-1);
			SQL_QUERY=SQL_QUERY+")";
		}
	}

	SQL_QUERY=SQL_QUERY+" group by av.user.userId  having sum((av.avgRatingValue*av.totalReviews)/(av.totalReviews*8))>=:rating order by u.userId desc";
	
	Query query= getSession().createQuery(SQL_QUERY);
	query.setFirstResult(startFirstResult);
	query.setMaxResults(startMaxResult);
	query.setParameter("rating", Double.parseDouble(rating));
	query.setParameter(0,userID);
	List<Object[]> usersObject = query.list();
	return usersObject;
	}
	
	@Override
	public Integer getCountUsersListSortByRating(List<String> nationalityData, List<String> specializationData,
			List<String> personalityData, List<String> degreeData,String rating,int userID) {

	String SQL_QUERY = "SELECT count(*)  FROM User u  RIGHT JOIN u.userAvgRatings av where u.status='1' and u.userId!=?";
	
	if(!nationalityData.isEmpty()) {
		SQL_QUERY= SQL_QUERY+ " and u.nationalityMaster.nationality in(";
		{
			Iterator iterator = (Iterator) nationalityData.iterator();
			while (iterator.hasNext()) {
				SQL_QUERY=SQL_QUERY+"'"+iterator.next()+"',";
			}
			SQL_QUERY=SQL_QUERY.substring(0, SQL_QUERY.length()-1);
			SQL_QUERY=SQL_QUERY+")";
		}

	}

	if(!specializationData.isEmpty()) {
		SQL_QUERY= SQL_QUERY+ " and  u.specializationMaster.specializationName in(";
		{
			Iterator iterator = (Iterator) specializationData.iterator();
			while (iterator.hasNext()) {
				SQL_QUERY=SQL_QUERY+"'"+iterator.next().toString()+"',";
			}
			SQL_QUERY=SQL_QUERY.substring(0, SQL_QUERY.length()-1);
			SQL_QUERY=SQL_QUERY+")";
		}
	}

	if(!personalityData.isEmpty()) {
		SQL_QUERY= SQL_QUERY+ " and u.personalityMaster.personalityRole in(";
		{
			Iterator iterator = (Iterator) personalityData.iterator();
			while (iterator.hasNext()) {
				SQL_QUERY=SQL_QUERY+"'"+iterator.next().toString()+"',";
			}
			SQL_QUERY=SQL_QUERY.substring(0, SQL_QUERY.length()-1);
			SQL_QUERY=SQL_QUERY+")";
		}
	}
	if(!degreeData.isEmpty()) {
		SQL_QUERY= SQL_QUERY+ " and u.specializationMaster.degreeMaster.degreeName in(";
		{
			Iterator iterator = (Iterator) degreeData.iterator();
			while (iterator.hasNext()) {
				SQL_QUERY=SQL_QUERY+"'"+iterator.next().toString()+"',";
			}
			SQL_QUERY=SQL_QUERY.substring(0, SQL_QUERY.length()-1);
			SQL_QUERY=SQL_QUERY+")";
		}
	}

	SQL_QUERY=SQL_QUERY+" group by av.user.userId  having sum((av.avgRatingValue*av.totalReviews)/(av.totalReviews*8))>=:rating order by u.userId desc";
	
	Query query= getSession().createQuery(SQL_QUERY);
	query.setParameter("rating", Double.parseDouble(rating));
	query.setParameter(0,userID);
	
	List<Object[]> usersObject = query.list();
	return Integer.parseInt(""+usersObject.size());
	}
}	

