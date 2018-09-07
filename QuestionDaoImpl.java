package com.infodart.peerhuntr.jpa.dao.impl;




import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.infodart.peerhuntr.dto.personalityTest.QualityMasterDTO;
import com.infodart.peerhuntr.jpa.dao.QuestionDao;
import com.infodart.peerhuntr.jpa.dao.impl.basedao.AbstractGenericDao;
import com.infodart.peerhuntr.jpa.entity.personalityTest.QuestionMaster;
import com.infodart.peerhuntr.jpa.entity.personalityTest.QuestionSectionQualityMapping;
import com.infodart.peerhuntr.jpa.entity.personalityTest.SectionMaster;
import com.infodart.peerhuntr.jpa.entity.user.UserLogin;
@Repository
public  class QuestionDaoImpl extends AbstractGenericDao<QuestionMaster> implements QuestionDao {
	private static final Logger logger = LoggerFactory.getLogger(QuestionDaoImpl.class);

	@Override
	public List<SectionMaster> getAllSection() {

		Query query = getSession().getNamedQuery("SectionMaster.findAll");
		List<SectionMaster> sectionMasters = query.list();
		return sectionMasters;
	}

	@Override
		// TODO Auto-generated method stub
	public List<QuestionMaster> getAllQuestionAnswer() {
		Query query = getSession().getNamedQuery("QuestionMaster.findAll");
		List<QuestionMaster> questionMasters=query.list();
		return questionMasters;
	}

	@Override
	public List<QuestionSectionQualityMapping> getSectionQuestionAnswer(Integer sectionID) {
		// TODO Auto-generated method stub
		
		List<QuestionSectionQualityMapping> questionMaster=new ArrayList<QuestionSectionQualityMapping>();
		try {
			
			Query query  = getSession() .createQuery("from QuestionSectionQualityMapping where sectionMaster.sectionId=? group by questionMaster.questionId").setParameter(0,sectionID);
			
			questionMaster=query.list();
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		
		return questionMaster;
			
			 

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionSectionQualityMapping> getSectionWithQuestionNumber(Integer sectionID, Integer questionNumberID) {
		// TODO Auto-generated method stub
		
		

		List<QuestionSectionQualityMapping> questionMaster=new ArrayList<QuestionSectionQualityMapping>();
		try {
			
			questionMaster = getSession() .createQuery("from QuestionSectionQualityMapping where sectionMaster.sectionId=? and questionMaster.questionId=?")
					.setParameter(0,sectionID).setParameter(1, questionNumberID).list();
			
		
			}catch(Exception e) {
				e.printStackTrace();
				
			}
	
		
		return questionMaster;
	}
	
	
	
	
	
	
	
	
	
	

	@Override
	public SectionMaster getSectionMaster(Integer sectionID) {
		// TODO Auto-generated method stub
		
		

		List<SectionMaster> sectionMaster=new ArrayList<SectionMaster>();
		try {
			
			sectionMaster = getSession() .createQuery("from SectionMaster where sectionId=? ").setParameter(0,sectionID).list();
			
		
			}catch(Exception e) {
				e.printStackTrace();
				
			}
	
		SectionMaster  s=sectionMaster.get(0);
		
		
		return s;
	}

	






	/*@Override
     public void addQuestion(QuestionMasterDTO user) {
	Session session = this.sessionFactory.getCurrentSession();
	session.persist(user);
	logger.info("question saved successfully, question="+user);





    	 return ;
     }

	@Override
	public List<AnswerMasterDTO> listAnswer() {
		Session session = this.sessionFactory.getCurrentSession();
		List<AnswerMasterDTO> AnswerList = session.createQuery("from Answer").list();
		for(AnswerMasterDTO user : AnswerList){
			logger.info("Answer List::"+user);
		// TODO Auto-generated method stub

	}


		return AnswerList;






	}
	 */




}




