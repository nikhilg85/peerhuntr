package com.infodart.peerhuntr.jpa.dao;

import java.util.List;

import com.infodart.peerhuntr.jpa.dao.impl.basedao.GenericDao;
import com.infodart.peerhuntr.jpa.entity.personalityTest.PersonalityMaster;
import com.infodart.peerhuntr.jpa.entity.personalityTest.QuestionSectionQualityMapping;
import com.infodart.peerhuntr.jpa.entity.personalityTest.SectionQualityMapping;
import com.infodart.peerhuntr.jpa.entity.personalityTest.UserQuestionAnswer;


public interface PersonalityTestDao extends  GenericDao<UserQuestionAnswer> {

	public List<Object> getTest();
	public boolean testGivenByUser(int UserId);
	public void deleteTest(int userId);
	public boolean updatePersonalityType(int personalityId,int userId);
	public List<SectionQualityMapping> getAllSectionQualities();
	public List<PersonalityMaster> getAllPersonalities();
	public List<QuestionSectionQualityMapping> getAllQuestionQualities();
	public boolean updateUserLoginStatus(int userLoginId);
	public int getUserLoginId(int userId);
}
