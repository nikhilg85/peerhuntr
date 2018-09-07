package com.infodart.peerhuntr.jpa.dao;

import java.util.List;

import com.infodart.peerhuntr.dto.personalityTest.QualityMasterDTO;
import com.infodart.peerhuntr.jpa.dao.impl.basedao.GenericDao;
import com.infodart.peerhuntr.jpa.entity.personalityTest.QuestionMaster;
import com.infodart.peerhuntr.jpa.entity.personalityTest.QuestionSectionQualityMapping;
import com.infodart.peerhuntr.jpa.entity.personalityTest.SectionMaster;


public interface QuestionDao  extends  GenericDao<QuestionMaster>{
	public List<SectionMaster> getAllSection();
	public List<QuestionMaster> getAllQuestionAnswer();
	public List<QuestionSectionQualityMapping> getSectionQuestionAnswer(Integer sectionID);
	public List<QuestionSectionQualityMapping> getSectionWithQuestionNumber(Integer sectionID,Integer questionNumberID);
	
	public  SectionMaster getSectionMaster(Integer sectionID);
	

}
