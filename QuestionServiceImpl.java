package com.infodart.peerhuntr.jpa.service.Impl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infodart.peerhuntr.dto.personalityTest.AnswerIndicatorDTO;
import com.infodart.peerhuntr.dto.personalityTest.AnswerMasterDTO;
import com.infodart.peerhuntr.dto.personalityTest.QualityMasterDTO;
import com.infodart.peerhuntr.dto.personalityTest.QuestionMasterDTO;
import com.infodart.peerhuntr.dto.personalityTest.QuestionSectionQualityMappingDTO;
import com.infodart.peerhuntr.dto.personalityTest.SectionMasterDTO;
import com.infodart.peerhuntr.dto.personalityTest.SectionQualityMappingDTO;
import com.infodart.peerhuntr.dto.response.ResponseDTO;
import com.infodart.peerhuntr.dto.user.UserDTO;
import com.infodart.peerhuntr.jpa.dao.QuestionDao;
import com.infodart.peerhuntr.jpa.entity.personalityTest.AnswerIndicator;
import com.infodart.peerhuntr.jpa.entity.personalityTest.AnswerMaster;
import com.infodart.peerhuntr.jpa.entity.personalityTest.QuestionMaster;
import com.infodart.peerhuntr.jpa.entity.personalityTest.QuestionSectionQualityMapping;
import com.infodart.peerhuntr.jpa.entity.personalityTest.SectionMaster;
import com.infodart.peerhuntr.mapper.DozerMapping;

@Service
@Transactional
public  class QuestionServiceImpl implements QuestionService{


	@Autowired
	QuestionDao questionDao;

	private DozerMapping mapper;


	@Override
	public List<Object> getAllSections() {

		SectionMasterDTO  sectionMasterDTO = null;
		List<Object>  seDtos =  new ArrayList<Object>();

		List<SectionMaster>  daDegreeMasters = questionDao.getAllSection();
		for (SectionMaster sectionMaster : daDegreeMasters) {
			sectionMaster.setQuestionMasters(null);
			sectionMaster.setSectionQualityMappings(null);
			seDtos.add((SectionMasterDTO)mapper.convert(sectionMaster,sectionMasterDTO,SectionMasterDTO.class));
		}
		return seDtos;
		// TODO Auto-generated method stub
	}

	public ResponseDTO addQuestions(QuestionMasterDTO questionMasterDTO) {

		ResponseDTO responseDTO=new ResponseDTO();
		String m="";
		SectionMaster s=null;
		QuestionMaster questionMaster = null;
		
		try {
	
			AnswerMaster ansm=null;
			List<QuestionSectionQualityMapping>  lSectionMasters =null;
			java.util.Date dt = new java.util.Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String currentTime = sdf.format(dt);
			java.util.Date date = sdf.parse(currentTime);
			//questionMaster= (QuestionMaster) DozerMapping.convert(questionMasterDTO, questionMaster,QuestionMaster.class);
	            
			SectionMasterDTO sectionMasterDTO=questionMasterDTO.getSectionMaster();
			 lSectionMasters=questionDao.getSectionWithQuestionNumber(sectionMasterDTO.getSectionId(), questionMasterDTO.getQuestionId());
			  questionMaster= (QuestionMaster) DozerMapping.convert(questionMasterDTO, questionMaster,QuestionMaster.class);
			 if(lSectionMasters.size()==0) {
				 
				 		questionMaster.setStatus((byte)1);
						questionMaster.setModifiedOn(date);	
						Set<AnswerMaster> answerMasters = questionMaster.getAnswerMasters();
						
						for(AnswerMaster answerMaster:answerMasters) {
							answerMaster.setCreatedOn(date);
							answerMaster.setModifiedOn(date);
							answerMaster.setStatus((byte)1);
						}
						
					    
						SectionMaster ss=questionDao.getSectionMaster(questionMaster.getSectionMaster().getSectionId());
					
						ss.setModifiedOn(date);
						ss.setStatus((byte)1);
						
						questionMaster.setSectionMaster(ss);
						
						questionMaster.setAnswerMasters(answerMasters);
						questionDao.saveOrUpdate(questionMaster);
						
						responseDTO.setStatus("SUCCESS");
						 m="Section "+ss.getSectionName()+" Question Number "+questionMaster.getQuestionNumberId()+" Successfully Record Saved";
						responseDTO.setMessage(m);			    			    			    	
			    }else {
			    	
			    	
			    	questionMaster=lSectionMasters.get(0).getQuestionMaster();
			    	questionMaster.setQuestionId(questionMasterDTO.getQuestionId());
			    	questionMaster.setQuestionName(questionMasterDTO.getQuestionName());
			    	questionMaster.setStatus((byte)1);
					questionMaster.setModifiedOn(date);	
					
					Set<AnswerMaster> answerMasters = questionMaster.getAnswerMasters();
					
					for(AnswerMaster answerMaster:answerMasters) {
						answerMaster.setModifiedOn(date);
						answerMaster.setStatus((byte)1);
						answerMasters.add(answerMaster);
					}
		
					
					s=questionDao.getSectionMaster(questionMasterDTO.getSectionMaster().getSectionId());
					
					s.setModifiedOn(date);
					s.setStatus((byte)1);
					
					questionMaster.setSectionMaster(s);
					questionMaster.setAnswerMasters(answerMasters);
					questionDao.saveOrUpdate(questionMaster);
					
					responseDTO.setStatus("SUCCESS");
					 m="Section "+s.getSectionName()+" Question Number "+questionMaster.getQuestionNumberId()+" Successfully Updated";
					responseDTO.setMessage(m);
			    	
			    	
			    }
			
			
				return responseDTO;
		}catch (Exception e) {
			e.printStackTrace();

			responseDTO.setStatus("FAILURE");
			 m="Section "+s.getSectionName()+" Question Number "+questionMaster.getQuestionId()+" Data not Updated";
			responseDTO.setErrorMsg(m);
		
		    
		}
		return responseDTO;
	}
	
	

	
	
	

	@Override
	public QuestionMasterDTO getQuestionAnswer() {
		// TODO Auto-generated method stub
		
		List<QuestionMaster> questionMasters=questionDao.getAllQuestionAnswer();
		
		QuestionMaster questionMaster=questionMasters.get(0);
		QuestionMasterDTO masterDTO=new QuestionMasterDTO();
	
		QuestionMasterDTO questionMasterDTO=null;
		Set<AnswerMasterDTO> answerMasterDTO=new HashSet<AnswerMasterDTO>();
		AnswerMasterDTO answerMasterDTO2=null;
		AnswerIndicatorDTO ansInd=null;
		
		questionMasterDTO= (QuestionMasterDTO) mapper.convert(questionMaster, questionMasterDTO,QuestionMasterDTO.class);
    
		masterDTO.setQuestionId(questionMasterDTO.getQuestionId());
		
		masterDTO.setQuestionName(questionMasterDTO.getQuestionName());
	    Set<AnswerMasterDTO> answerMasterDTOs=questionMasterDTO.getAnswerMasters();
		
	    for(AnswerMasterDTO a:answerMasterDTOs) {
	    	
	    	answerMasterDTO2=new AnswerMasterDTO();
	    	answerMasterDTO2.setAnswer(a.getAnswer());
	    	
	    	answerMasterDTO.add(answerMasterDTO2);
	    	ansInd=new AnswerIndicatorDTO();
	    	ansInd.setAnswerIndicatorId(a.getAnswerIndicator().getAnswerIndicatorId());
	    	answerMasterDTO2.setAnswerIndicator(ansInd);
	    }
	    masterDTO.setAnswerMasters(answerMasterDTO);
		return masterDTO;
	}

	@Override
	public ResponseDTO getSectionQuestionAnswer(Integer sectionID) {
		// TODO Auto-generated method stub
		
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			
			
			List<QuestionSectionQualityMapping>  questionSectionQualityMappings=questionDao.getSectionQuestionAnswer(sectionID);
			 if(questionSectionQualityMappings.size()==0) {
			    	responseDTO.setStatus("FAILURE");
			    	responseDTO.setErrorMsg("Please Add Section Question and Answer");
			    }else {
			    /*	
			    	System.out.println("size================lSectionMasters====="+lSectionMasters.size());
					AnswerIndicatorDTO ansInd=null;
					QuestionSectionQualityMappingDTO questionSectionQualityMappingDTO = new QuestionSectionQualityMappingDTO();
					QuestionMasterDTO masterDTO=new QuestionMasterDTO();
					Set<AnswerMasterDTO> answerMasterDTO=new HashSet<AnswerMasterDTO>();
					AnswerMasterDTO answerMasterDTO2=null;
				//	masterDTO.setQuestionId(lSectionMasters.get(0).getQuestionId());
				//	masterDTO.setQuestionName(lSectionMasters.get(0).getQuestionName());
					Set<AnswerMaster> answerMasters=new HashSet<AnswerMaster>();		    
				//	answerMasters= lSectionMasters.get(0).getAnswerMasters();
				//	Iterator itr =  lSectionMasters.get(0).getQuestionSectionQualityMappings().iterator();
					Set<QuestionSectionQualityMappingDTO> stMappings = new HashSet<QuestionSectionQualityMappingDTO>();
				  while(itr.hasNext()) {
					  QuestionSectionQualityMappingDTO questionSectionQualityMapping=  (QuestionSectionQualityMappingDTO)itr.next();
					  
					  questionSectionQualityMapping.setSectionMaster(null);
					  stMappings.add(questionSectionQualityMapping);				 
				  }
				//  questionSectionQualityMappingDTO.setAnswerMaster(answerMaster);
				 //lSectionMasters.get(0).setQuestionSectionQualityMappings(stMappings);
				  
					for(AnswerMaster a:answerMasters) {
				    
						answerMasterDTO2=new AnswerMasterDTO();
				    	answerMasterDTO2.setAnswer(a.getAnswer());
				    	answerMasterDTO.add(answerMasterDTO2);
				    	ansInd=new AnswerIndicatorDTO();
				    	ansInd.setAnswerIndicatorId(a.getAnswerIndicator().getAnswerIndicatorId());
				    	answerMasterDTO2.setAnswerIndicator(ansInd);
				    	
				    }
					
					
				    
				    masterDTO.setAnswerMasters(answerMasterDTO);
					*/
					List<QuestionSectionQualityMappingDTO>  quDtos =  new ArrayList<QuestionSectionQualityMappingDTO>();
					List<Object>  quDtoTOsend =  new ArrayList<Object>();


					for (QuestionSectionQualityMapping qualityMapping : questionSectionQualityMappings) {
						quDtos.add((QuestionSectionQualityMappingDTO)mapper.convert(qualityMapping,quDtos,QuestionSectionQualityMappingDTO.class));
					}
					for (QuestionSectionQualityMappingDTO quDTO:quDtos) {
						quDTO.setAnswerMaster(null);
						quDTO.setQualityMaster(null);
						quDTO.setQuestionMaster(null);
						Set<QuestionMasterDTO> questionMasterDTOs = quDTO.getSectionMaster().getQuestionMasters();
						Set<QuestionMasterDTO> questionMasterDTOs1 = new HashSet<QuestionMasterDTO>();
						for(QuestionMasterDTO questionMasterDTO :questionMasterDTOs) {
							questionMasterDTO.setSectionMaster(null);
							Set<AnswerMasterDTO> answerMasters = questionMasterDTO.getAnswerMasters();
							Set<AnswerMasterDTO> answerMasters1 = new HashSet<AnswerMasterDTO>();
						
							for(AnswerMasterDTO answerMaster:answerMasters) {
								answerMaster.setQuestionMaster(null);
								answerMasters1.add(answerMaster);
							}
							questionMasterDTO.setAnswerMasters(answerMasters1);
							questionMasterDTOs1.add(questionMasterDTO);
						}
						Set<SectionQualityMappingDTO> sectionQualityMappingDTOs = quDTO.getSectionMaster().getSectionQualityMappings();
						Set<SectionQualityMappingDTO> sectionQualityMappingDTOs1 = new HashSet<SectionQualityMappingDTO>();
						for(SectionQualityMappingDTO sectionQualityMappingDTO:sectionQualityMappingDTOs) {
							sectionQualityMappingDTO.setSectionMaster(null);
							sectionQualityMappingDTO.getQualityMaster().setSectionQualityMappings(null);;
							sectionQualityMappingDTOs1.add(sectionQualityMappingDTO);
						}
						
						quDTO.getSectionMaster().setQuestionMasters(questionMasterDTOs1);
						quDTO.getSectionMaster().setSectionQualityMappings(sectionQualityMappingDTOs1);
						quDtoTOsend.add(quDTO);
					}
					
				    responseDTO.setResponseList(quDtoTOsend);
			    	
			    }
			
		    
		   
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		return responseDTO;
	}

	@Override
	public ResponseDTO getSectionWithQuestionNumber(Integer sectionID, Integer questionNumberID) {
		// TODO Auto-generated method stub
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			
			List<QuestionSectionQualityMapping>  questionSectionQualityMappings=questionDao.getSectionWithQuestionNumber(sectionID,questionNumberID);
			 if(questionSectionQualityMappings.size()==0) {
			    	responseDTO.setStatus("FAILURE");
			    	responseDTO.setErrorMsg("No Data Found");
			    }else {
			    	
					List<QuestionSectionQualityMappingDTO>  quDtos =  new ArrayList<QuestionSectionQualityMappingDTO>();
					List<Object>  quDtoTOsend =  new ArrayList<Object>();


					for (QuestionSectionQualityMapping qualityMapping : questionSectionQualityMappings) {
						quDtos.add((QuestionSectionQualityMappingDTO)mapper.convert(qualityMapping,quDtos,QuestionSectionQualityMappingDTO.class));
					}
					for (QuestionSectionQualityMappingDTO quDTO:quDtos) {
						//quDTO.getQuestionMaster().set
						//quDTO.getAnswerMaster().setUserQuestionAnswers(null);
						quDTO.getAnswerMaster().setQuestionMaster(null);
						quDTO.getQualityMaster().setSectionQualityMappings(null);
						quDTO.getSectionMaster().setSectionQualityMappings(null);
						quDTO.getQuestionMaster().setAnswerMasters(null);
						quDTO.getSectionMaster().setQuestionMasters(null);
						quDtoTOsend.add(quDTO);
					}
					
				    responseDTO.setResponseList(quDtoTOsend);
			    	
			    }
		    
				
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return responseDTO;
	}

	/*@Override
	public ResponseDTO getSections() {
		
		List<Object> responseList=new ArrayList<>();
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			SectionMasterDTO sectionMasterDTO=null;
			List<SectionMaster>  sections = questionDao.getAllSection();
			for (SectionMaster sectionMaster : sections) {
				sectionMasterDTO=(SectionMasterDTO) mapper.convert(sectionMaster,sectionMasterDTO,SectionMasterDTO.class);
			
				Set<QuestionMasterDTO> questionMasters=new HashSet<>();
				for(QuestionMasterDTO questionMasterDTO:sectionMasterDTO.getQuestionMasters()) {
					questionMasterDTO.setSectionMaster(null);
					
					Set<AnswerMasterDTO> answers=new HashSet<>();
					for(AnswerMasterDTO answerMasterDTO:questionMasterDTO.getAnswerMasters()) {
						answerMasterDTO.setQuestionMaster(null);
						answers.add(answerMasterDTO);
						
						
					}
					questionMasterDTO.setAnswerMasters(answers);
					
					questionMasters.add(questionMasterDTO);
				}
				
				
				Set<SectionQualityMappingDTO> sectionQualityMappingList=new HashSet<>();
				for(SectionQualityMappingDTO sectionQualityMappingDTO:sectionMasterDTO.getSectionQualityMappings()) {
					sectionQualityMappingDTO.setSectionMaster(null);
					sectionQualityMappingDTO.getQualityMaster().setSectionQualityMappings(null);
					
					
					sectionQualityMappingList.add(sectionQualityMappingDTO);
				}
				
				sectionMasterDTO.setQuestionMasters(questionMasters);
				sectionMasterDTO.setSectionQualityMappings(sectionQualityMappingList);
				responseList.add(sectionMasterDTO);	
			}
			
			responseDTO.setResponseList(responseList);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return responseDTO;
	
	}*/
	
 


}