package com.infodart.peerhuntr.jpa.service.Impl;

import com.infodart.peerhuntr.dto.personalityTest.*;
import com.infodart.peerhuntr.dto.response.ResponseDTO;

import java.util.List;

public interface QuestionService {

	public List<Object> getAllSections();
	public ResponseDTO addQuestions(QuestionMasterDTO questionMasterDTO);
	public QuestionMasterDTO getQuestionAnswer();
	
	public ResponseDTO getSectionQuestionAnswer(Integer sectionID);
	public ResponseDTO getSectionWithQuestionNumber(Integer sectionID,Integer questionNumberID);
	
	

}
