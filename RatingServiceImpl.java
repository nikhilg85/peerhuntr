package com.infodart.peerhuntr.jpa.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infodart.peerhuntr.constants.Constants;
import com.infodart.peerhuntr.dto.peerRating.UserRatingDTO;
import com.infodart.peerhuntr.dto.response.ResponseDTO;
import com.infodart.peerhuntr.jpa.dao.RatingDao;
import com.infodart.peerhuntr.jpa.dao.UserDao;
import com.infodart.peerhuntr.jpa.entity.peerRating.RatingType;
import com.infodart.peerhuntr.jpa.entity.peerRating.SocialNetworkMaster;
import com.infodart.peerhuntr.jpa.entity.peerRating.UserAvgRating;
import com.infodart.peerhuntr.jpa.entity.peerRating.UserRating;
import com.infodart.peerhuntr.jpa.entity.user.User;
import com.infodart.peerhuntr.util.AppUtil;

@Service
@Transactional
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingDao ratingDao;
	
	public ResponseDTO submitRating(UserRatingDTO userRatingDTO) {
		
		
		ResponseDTO responseDTO=new ResponseDTO();
		try {
			UserRating userRating;
			List<User> user=ratingDao.getUserIdByReferralCode(userRatingDTO.getReferralCode());
			
			/*setUser(String User) {
			this.User = User; // store the name
		      }*/
			User user1 = user.get(0);
			
			
			String email =user1.getUserLogin().getLoginId();
			
			
			
			
			int networkId=ratingDao.getNetworkId(userRatingDTO.getNetwork());
			List<RatingType> ratings=ratingDao.getAllRatingTypes();
			
			Pattern address=Pattern.compile("([\\w\\.]+)@([\\w\\.]+\\.\\w+)");
		    Matcher match1=address.matcher(email1);
		    Matcher match2=address.matcher(email2);
		    if(!match1.find() || !match2.find()) return false; //Not an e-mail address? Already false
		    if(!match1.group(2).equalsIgnoreCase(match2.group(2))) return false; //Not same serve? Already false
		    switch(match1.group(2).toLowerCase()) {
		    case "gmail.com":
		        String gmail1=match1.group(1).replace(".", "");
		        String gmail2=match2.group(1).replace(".", "");
		        return gmail1.equalsIgnoreCase(gmail2);
		    default: return match1.group(1).equalsIgnoreCase(match2.group(1));
		    }
		
			
	        for (Map.Entry<String,Integer> entry : userRatingDTO.getRatings().entrySet()) {
	        	userRating=new UserRating();
				User user=new User();
				RatingType ratingType =new RatingType();
				SocialNetworkMaster social=new SocialNetworkMaster();
	        	
				
				user.setUserId(userId);
				social.setSocialNetworkId(networkId);
				
	        	// Fetch rating type id
				for(RatingType rating:ratings) {
					if(rating.getRatingName().equalsIgnoreCase(entry.getKey())) {
						if(rating.getRatingName().equalsIgnoreCase("comments"))
						{
							ratingType.setRatingTypeId(rating.getRatingTypeId());
							userRating.setRemarks(userRatingDTO.getRemarks());
							userRating.setUserRatingValue(entry.getValue());
							break;
						}else {
							ratingType.setRatingTypeId(rating.getRatingTypeId());
							userRating.setRemarks("NA");
							userRating.setUserRatingValue(entry.getValue());
							break;
						}
					}
						
				}
				
				
				
				userRating.setUser(user); 
				userRating.setSocialNetworkMaster(social);
				userRating.setRatingType(ratingType);
				userRating.setNetworkUser(userRatingDTO.getNetworkUser());
				userRating.setEmailId(userRatingDTO.getEmailId());
				userRating.setCreatedOn(AppUtil.getCurrentDate());
				userRating.setModifiedOn(AppUtil.getCurrentDate());
				
				userRating.setStatus((byte)1);
				
				
				String exists=ratingDao.saveRating(userRating);
				 if(exists.equalsIgnoreCase("true")) {
					 responseDTO.setStatus(Constants.FAILURE_STATUS);
					responseDTO.setStatusCode(Constants.FAILURE_STATUS_CODE);
					responseDTO.setErrorMsg("Rating already provided by the user");
					 return responseDTO;
				 }
				
				 else if(ReferralCode == UserId){  
				        (exits.eqalsIgnoreCase("false"))  
				    }

   }else{  
				        System.out.println("Invalid!");  
				    }  
	
	        }
	        saveUserAvgRating(userId);
	        responseDTO.setStatus(Constants.SUCCESS_STATUS);
	        responseDTO.setStatusCode(Constants.SUCCESS_STATUS_CODE);
	        responseDTO.setMessage("Rating completed successfully");
			
			
		}catch(org.hibernate.exception.ConstraintViolationException ce) {
			ce.printStackTrace();
		}
		catch(Exception e) {
			responseDTO.setStatus(Constants.FAILURE_STATUS);
			responseDTO.setStatusCode(Constants.FAILURE_STATUS_CODE);
			responseDTO.setErrorMsg("Rating data cannot be inserted as "+e.getMessage());
			e.printStackTrace();
		}
		return responseDTO;
	}
	
	private boolean saveUserAvgRating(int userid) {
		try {
			List<UserAvgRating> calAvgRatingList=ratingDao.calculateRatingAverage(userid);
	
			
			List<UserAvgRating> avgRatingList=ratingDao.getUserRatingAverage(userid);
			
			if(avgRatingList.size()!=0) {
				for(UserAvgRating userAvgRating:calAvgRatingList) {
					
					userAvgRating.setModifiedOn(AppUtil.getCurrentDate());
					ratingDao.updateAverageRating(userAvgRating,userid);
				}
			}else {
			
			for(UserAvgRating userAvgRating:calAvgRatingList) {
				userAvgRating.setCreatedOn(AppUtil.getCurrentDate());
				userAvgRating.setModifiedOn(AppUtil.getCurrentDate());
				userAvgRating.setRemarks("NA");
				userAvgRating.setStatus((byte)1);
				ratingDao.saveAverageRating(userAvgRating);
			}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
