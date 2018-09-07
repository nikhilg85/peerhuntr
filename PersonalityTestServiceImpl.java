package com.infodart.peerhuntr.jpa.service.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infodart.peerhuntr.constants.Constants;
import com.infodart.peerhuntr.dto.personalityTest.AnswerIndicatorDTO;
import com.infodart.peerhuntr.dto.personalityTest.AnswerMasterDTO;
import com.infodart.peerhuntr.dto.personalityTest.QuestionMasterDTO;
import com.infodart.peerhuntr.dto.personalityTest.UserQuestionAnswerDTO;
import com.infodart.peerhuntr.dto.response.ResponseDTO;
import com.infodart.peerhuntr.dto.user.UserDTO;
import com.infodart.peerhuntr.jpa.dao.PersonalityTestDao;
import com.infodart.peerhuntr.jpa.dao.UserDao;
import com.infodart.peerhuntr.jpa.entity.personalityTest.AnswerIndicator;
import com.infodart.peerhuntr.jpa.entity.personalityTest.AnswerMaster;
import com.infodart.peerhuntr.jpa.entity.personalityTest.PersonalityMaster;
import com.infodart.peerhuntr.jpa.entity.personalityTest.QuestionMaster;
import com.infodart.peerhuntr.jpa.entity.personalityTest.QuestionSectionQualityMapping;
import com.infodart.peerhuntr.jpa.entity.personalityTest.SectionQualityMapping;
import com.infodart.peerhuntr.jpa.entity.personalityTest.UserQuestionAnswer;
import com.infodart.peerhuntr.jpa.entity.user.ProfileImage;
import com.infodart.peerhuntr.jpa.entity.user.User;
import com.infodart.peerhuntr.mapper.DozerMapping;
import com.infodart.peerhuntr.spring.controller.HomeController;
import com.infodart.peerhuntr.util.AppUtil;

@Service
@Transactional
public class PersonalityTestServiceImpl implements PersonalityTestService{

	@Autowired
	private PersonalityTestDao personalityTestDao;
	
	@Autowired
	private UserDao userDao;


	private DozerMapping mapper;
	@Override
	public ResponseDTO getTest() {
		QuestionMasterDTO questionMasterDTO=null;
		AnswerMasterDTO answerMasterDTO=null;
		AnswerIndicatorDTO answerIndicatorDTO=null;
		Set<AnswerMasterDTO> answers;
		Set<AnswerIndicatorDTO> answerIndicator;
		ResponseDTO response=new ResponseDTO();
		List<Object> responseList=new ArrayList<>();
		try {
			
			List<Object> questions=personalityTestDao.getTest();
			Iterator itr = questions.iterator();
			while (itr.hasNext())
			{
				QuestionMaster questionMaster=(QuestionMaster)itr.next();
				questionMasterDTO= new QuestionMasterDTO();
				
				
				questionMasterDTO.setQuestionId(questionMaster.getQuestionId());
				questionMasterDTO.setQuestionName(questionMaster.getQuestionName());
				questionMasterDTO.setSectionId(questionMaster.getSectionMaster().getSectionId());
				questionMasterDTO.setSectionName(questionMaster.getSectionMaster().getSectionName());
				
				answers=new LinkedHashSet<>();
				
				for(AnswerMaster ans:questionMaster.getAnswerMasters()) {
					answerMasterDTO=new AnswerMasterDTO();
					answerMasterDTO.setAnswerId(ans.getAnswerId());
					answerMasterDTO.setAnswer(ans.getAnswer());
					
					AnswerIndicatorDTO ansIndDTO=new AnswerIndicatorDTO();
					ansIndDTO.setAnswerIndicatorId(ans.getAnswerIndicator().getAnswerIndicatorId());
					answerMasterDTO.setAnswerIndicator(ansIndDTO);
					
					answers.add(answerMasterDTO);
				}
				List<AnswerMasterDTO> list = new ArrayList<AnswerMasterDTO>(answers);
				
				Collections.sort(list, new Comparator<AnswerMasterDTO>(){
					   public int compare(AnswerMasterDTO o1, AnswerMasterDTO o2){
					      return o1.getAnswerId() - o2.getAnswerId();
					   }
					});
				answers = new LinkedHashSet(list);
				questionMasterDTO.setAnswerMasters(answers);
				
				
				responseList.add(questionMasterDTO);

			}
			response.setResponseList(responseList);

		}catch(Exception e) {
			response.setStatus(Constants.FAILURE_STATUS);
			response.setStatusCode(Constants.FAILURE_STATUS_CODE);
			response.setErrorMsg("Questions data cannot be fetched as "+e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
	@Override
	public ResponseDTO submitTest(UserDTO userDTO) {

		int userLoginId;
		ResponseDTO response=new ResponseDTO();
		UserDTO uDTO=new UserDTO();
		try {
			if(userDTO.getUserId()==0  ) {
				userLoginId=userDao.getUserLoginIdByEmail(HomeController.getPrincipal());
				userDTO.setUserId(userDao.getUserIdByUserLogin(userLoginId));
			}
		UserQuestionAnswer userQuestionAnswer=null;
	
		Set<UserQuestionAnswerDTO> userQuestionAnswerDTOList=userDTO.getUserQuestionAnswers();	
		
		if(personalityTestDao.testGivenByUser(userDTO.getUserId())==true) {
			personalityTestDao.deleteTest(userDTO.getUserId());
		}
			for(UserQuestionAnswerDTO userQuestionAnswerDTO:userQuestionAnswerDTOList) {
				if(userQuestionAnswerDTO!=null) {
				uDTO.setUserId(userDTO.getUserId());
				userQuestionAnswerDTO.setUser(uDTO);
				userQuestionAnswer= (UserQuestionAnswer) mapper.convert(userQuestionAnswerDTO, userQuestionAnswer,UserQuestionAnswer.class);
				userQuestionAnswer.setTestNo(1);
				userQuestionAnswer.setCreatedOn(AppUtil.getCurrentDate());
				userQuestionAnswer.setModifiedOn(AppUtil.getCurrentDate());
				userQuestionAnswer.setRemarks("NA");
				userQuestionAnswer.setStatus((byte)1);
			
				personalityTestDao.save(userQuestionAnswer);
				}
				
			
		}
		
		

		}catch(Exception e) {
			response.setStatus(Constants.FAILURE_STATUS);
			response.setStatusCode(Constants.FAILURE_STATUS_CODE);
			response.setErrorMsg("Test data cannot be added as "+e.getMessage());
			e.printStackTrace();
		}
		return response;
	
	}
	@Override
	public ResponseDTO updateUserPersonality(UserDTO userDTO) {
		ResponseDTO response=new ResponseDTO();
		int personalityTypeId=0;
		String personalityType="",role="",colorCode="",remarks="";
		
		
		
		try {
			//List<SectionQualityMapping> qualities=personalityTestDao.getAllSectionQualities();
			List<PersonalityMaster> personalities=personalityTestDao.getAllPersonalities();
			List<QuestionSectionQualityMapping> questionQualities=personalityTestDao.getAllQuestionQualities();
			Set<UserQuestionAnswerDTO> userQuestionAnswer=userDTO.getUserQuestionAnswers();
			Set<Integer> sectionIds=new HashSet<>();
			
		
			
			//Fetching sections
			for(QuestionSectionQualityMapping section:questionQualities) {
				sectionIds.add(section.getSectionMaster().getSectionId());
			}
			
			
			for(int sectionId:sectionIds) {
				
				personalityType+=getQualities(sectionId, questionQualities, userQuestionAnswer);
			/*	//Get answer count
				int count[]=getAnswerCount(sectionId, answerIndicatorA, answerIndicatorB, userDTO);
				
				// Fetching qualities
				personalityType+=getQualities(sectionId, qualities, answerIndicatorA, answerIndicatorB,count[0],count[1]);*/
				
					
			}
			System.out.println(personalityType);
			
			// Update personality
			for(PersonalityMaster personality:personalities) {
				if(personality.getPersonalityType().equalsIgnoreCase(personalityType)) {
					personalityTypeId=personality.getPersonalityId();
					role=personality.getPersonalityRole();
					colorCode=personality.getPersonalityColourCode();
					remarks=personality.getRemarks();
					break;
				}
			}
			personalityTestDao.updatePersonalityType(personalityTypeId, userDTO.getUserId());
			personalityTestDao.updateUserLoginStatus(personalityTestDao.getUserLoginId(userDTO.getUserId()));
		
			response.setStatus(Constants.SUCCESS_STATUS);
			response.setStatusCode(Constants.SUCCESS_STATUS_CODE);
			response.setMessage("Personality test completed successfully");
			response.setType(personalityType);
			response.setRole(role);
			response.setColorCode(colorCode);
			response.setRemarks(remarks);
			System.out.println(response.getColorCode());
		}
		catch(Exception e) {
			response.setStatus(Constants.FAILURE_STATUS);
			response.setStatusCode(Constants.FAILURE_STATUS_CODE);
			response.setErrorMsg("Personality data cannot be updated as "+e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
	public char getQualities(int sectionId,List<QuestionSectionQualityMapping> qualities,Set<UserQuestionAnswerDTO> userQuestionAnswer) {

		char sectionQuality=0;
		String qualityStr="";
			try {
				for(UserQuestionAnswerDTO userQuesAns:userQuestionAnswer) {
					if(userQuesAns!=null) {
					if(userQuesAns.getQuestionMaster().getSectionMaster().getSectionId()==sectionId) {
						String quality=getQualityFromAns(qualities, userQuesAns.getAnswerMaster().getAnswerId());
						qualityStr+=quality;
						
					}
				}
			}
				
				System.out.println(qualityStr);
				sectionQuality=getMaxOccuringChars(qualityStr);
			
				
			}
			catch(Exception e) {
				
				e.printStackTrace();
			}
			
		
			
			
			return sectionQuality;
			
		}
	
	public String getQualityFromAns(List<QuestionSectionQualityMapping> qualities,int answesId) {
		
		try {
			for(QuestionSectionQualityMapping q:qualities) {
				if(q.getAnswerMaster().getAnswerId()==answesId)
					return q.getQualityMaster().getQualityType();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	  private char getMaxOccuringChars(String str) {
		  char c = 0 ;
         char[] arr = str.toCharArray();
         /* Assuming all characters are ascii */
         int[] arr1 = new int[256];
         int maxoccuring = 0;

         for (int i = 0; i < arr.length; i++) {
             if (arr[i] != ' ') { // ignoring space
                 int val = (int) arr[i];
                 arr1[val]++;
                 if (arr1[val] > maxoccuring) {
                     maxoccuring = arr1[val];
                 }
             }

         }

         for (int k = 0; k < arr1.length; k++) {
             if (maxoccuring == arr1[k]) {
                  c = (char) k;
                 System.out.print(c + " ");

             }

         }
         return c;
     }

	
	public int getIndicatorId(List<SectionQualityMapping> qualities,String indicator) {
		
					for(SectionQualityMapping section:qualities) {
						if(indicator.equalsIgnoreCase(section.getAnswerIndicator().getIndicatorType()))
							return section.getAnswerIndicator().getAnswerIndicatorId();
					}
				return 0;
	}
	
	public int[] getAnswerCount(int sectionId,int answerIndicatorA,int answerIndicatorB,UserDTO userDTO) {
		
		int answerACount=0,answerBCount=0;
		
		int count[]=new int[2];
		
		try {
			Set<UserQuestionAnswerDTO> userQuestionAnswerDTOList=userDTO.getUserQuestionAnswers();	
			
		
			// Set answer count
		
				answerACount=0;answerBCount=0;
				for(UserQuestionAnswerDTO userQuestionAnswerDTO:userQuestionAnswerDTOList) {
					
					if(userQuestionAnswerDTO.getQuestionMaster().getSectionMaster().getSectionId()==sectionId) {
						if(userQuestionAnswerDTO.getAnswerMaster().getAnswerIndicator().getAnswerIndicatorId()==answerIndicatorA)
							answerACount++;
						else
							answerBCount++;
					}
					
					
				}
				
			count[0]=answerACount;
			count[1]=answerBCount;
					
			
	
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	/*public String getQualities(int sectionId,List<SectionQualityMapping> qualities,int answerIndicatorA, int answerIndicatorB,int answerACount,int answerBCount) {

	String sectionQuality=null;
	
		
		try {
			
	
				
				// Fetch quality
				for(SectionQualityMapping quality:qualities) {
					if(quality.getSectionMaster().getSectionId()==sectionId) {
						
						if(answerACount>answerBCount) {
							if(quality.getAnswerIndicator().getAnswerIndicatorId()==answerIndicatorA) {
								sectionQuality=quality.getQualityMaster().getQualityType();
								break;
							}
						}
							
						else {
							
							if(quality.getAnswerIndicator().getAnswerIndicatorId()==answerIndicatorB) {
								sectionQuality=quality.getQualityMaster().getQualityType();
								break;
							}
						}
							
					}
				}
		
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
	
		
		
		return sectionQuality;
		
	}*/
	
}
