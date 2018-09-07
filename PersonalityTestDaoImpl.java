package com.infodart.peerhuntr.jpa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infodart.peerhuntr.jpa.dao.PersonalityTestDao;
import com.infodart.peerhuntr.jpa.dao.impl.basedao.AbstractGenericDao;
import com.infodart.peerhuntr.jpa.entity.personalityTest.PersonalityMaster;
import com.infodart.peerhuntr.jpa.entity.personalityTest.QuestionSectionQualityMapping;
import com.infodart.peerhuntr.jpa.entity.personalityTest.SectionMaster;
import com.infodart.peerhuntr.jpa.entity.personalityTest.SectionQualityMapping;
import com.infodart.peerhuntr.jpa.entity.personalityTest.UserQuestionAnswer;
import com.infodart.peerhuntr.jpa.entity.user.User;

@Repository
public class PersonalityTestDaoImpl extends AbstractGenericDao<UserQuestionAnswer> implements PersonalityTestDao{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Object> getTest() {
	
		List<Object> questions = new ArrayList<Object>();

		/*questions = sessionFactory.getCurrentSession() .createQuery("from QuestionMaster q,AnswerMaster a "
				+ " where a.questionMaster.questionId=q.questionId and q.status = ? order by q.questionNumberId,q.sectionMaster.sectionId,a.answerId")
				.setParameter(0, (byte)1).list();*/
		questions = getSession().createQuery("from QuestionMaster  where status = ? order by questionNumberId,sectionMaster.sectionId")
				.setParameter(0, (byte)1).list();
		
		return questions;
	}

	
	@Override
	public boolean updatePersonalityType(int personalityId,int userId) {
		 Query query= getSession().createQuery("update User set personalityMaster.personalityId=?,status=? where userId=?")
					.setParameter(0, personalityId)
					.setParameter(1, (byte)1)
					.setParameter(2, userId);
					
				 int a= query.executeUpdate();
				if(a==1)
					return true;
				else
					return false;
				 
	}
	
	@Override
	public boolean updateUserLoginStatus(int userLoginId) {
		 Query query= getSession().createQuery("update UserLogin set status=? where userLoginId=?")
					.setParameter(0, (byte)1)
					.setParameter(1, userLoginId);
					
				 int a= query.executeUpdate();
				if(a==1)
					return true;
				else
					return false;
				 
	}
	@Override
	public int getUserLoginId(int userId) {

		
		List<User> test = getSession().createQuery("from User where userId=?")
				.setParameter(0, userId).list();
		return test.get(0).getUserLogin().getUserLoginId();
		
	
	
	}
	@Override
	public boolean testGivenByUser(int userId) {
	
		List<Object> test = getSession().createQuery("from UserQuestionAnswer where user.userId=?")
				.setParameter(0, userId).list();
		
		
		if(test.size()>0)
			return true;
		else
			return false;
	}
	@Override
	public void deleteTest(int userId) {

		 
		try {
		 Query query= getSession().createQuery("delete from UserQuestionAnswer u where user.userId=:userId")
			.setParameter("userId", userId);
		int a= query.executeUpdate();
		System.out.println(a);
		
				       
    	  
      }catch(Exception e) {
			e.printStackTrace();
			
		}
		
		 
		
	  
		
	}


	@Override
	public List<SectionQualityMapping> getAllSectionQualities() {
		Query query = getSession().getNamedQuery("SectionQualityMapping.findAll");
		return query.list();
		
	}


	@Override
	public List<PersonalityMaster> getAllPersonalities() {
		Query query = getSession().getNamedQuery("PersonalityMaster.findAll");
		return query.list();
	}
	public List<QuestionSectionQualityMapping> getAllQuestionQualities(){
		Query query = getSession().getNamedQuery("QuestionSectionQualityMapping.findAll");
		return query.list();
	}

}
