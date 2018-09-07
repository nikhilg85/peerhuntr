package com.infodart.peerhuntr.jpa.service.Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infodart.peerhuntr.constants.Constants;
import com.infodart.peerhuntr.dto.personalityTest.SectionQualityMappingDTO;
import com.infodart.peerhuntr.dto.response.ResponseDTO;
import com.infodart.peerhuntr.dto.user.ProfileImageDTO;
import com.infodart.peerhuntr.dto.user.UserDTO;
import com.infodart.peerhuntr.dto.userCart.UserCartDTO;
import com.infodart.peerhuntr.dto.userCart.UserPurchasedCartDTO;
import com.infodart.peerhuntr.jpa.dao.UserCartDao;
import com.infodart.peerhuntr.jpa.dao.UserDao;
import com.infodart.peerhuntr.jpa.dao.UserDetailsDao;
import com.infodart.peerhuntr.jpa.dao.UserPurchasedCartDao;
import com.infodart.peerhuntr.jpa.entity.user.CustomUser;
import com.infodart.peerhuntr.jpa.entity.user.User;
import com.infodart.peerhuntr.jpa.entity.userCart.ProfilePackage;
import com.infodart.peerhuntr.jpa.entity.userCart.UserCart;
import com.infodart.peerhuntr.jpa.entity.userCart.UserPurchasedCart;
import com.infodart.peerhuntr.mapper.DozerMapping;
import com.infodart.peerhuntr.propertyloader.PropertyLoader;

@Service
@Transactional
public class UserPaymentServiceImp implements UserPaymentService {

	@Autowired
	UserCartDao userCartDAO;

	@Autowired
	UserPurchasedCartDao userPurchageCartDAO;
	@Autowired
	UserDao userDao;
	@Autowired
	UserDetailsDao userDetailsDao;

	private DozerMapping mapper;

	@Override
	public ResponseDTO addToCart(UserCartDTO userCart) {
		// TODO Auto-generated method stub

		ResponseDTO responseDTO = new ResponseDTO();

		try {

			java.util.Date dt = new java.util.Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String currentTime = sdf.format(dt);
			java.util.Date date = sdf.parse(currentTime);
			List<Object> list = new ArrayList<Object>();
			UserCart userCart2 = new UserCart();
            int id=0;
            int userID=0;
            
            
			if (userCart.getUserCart() == null) { // when come from web set user id//
				UserDTO user = new UserDTO();
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				CustomUser customUser = (CustomUser) auth.getPrincipal();
				userID = customUser.getUserId();
				user.setUserId(userID);	
				userCart.setUserCart(user);	
			}
			userCart2 = (UserCart) mapper.convert(userCart, userCart2, UserCart.class);

			if (userCartDAO.getPofileCartAlreadyAdded(userCart2.getUserCart().getUserId(), userCart.getUserProfile().getUserId())) {  //for item already added

			
				
				userCart2.setCreatedOn(date);
				userCart2.setModifiedOn(date);
				userCart2.setStatus((byte) 1);
				id = (Integer) userCartDAO.save(userCart2);
				UserCartDTO userCartDTO = new UserCartDTO();
				userCartDTO.setUserCartId(id);
				Set<UserCartDTO> userCartDTOs = new HashSet<UserCartDTO>();
				userCartDTOs.add(userCartDTO);
				User userDetails = userCartDAO.getUserDetails(userCart2.getUserProfile().getUserId());
				UserDTO userDTO = new UserDTO();
				String lastname = userDetails.getLastName().substring(0, 1);
				userDTO.setFirstName(userDetails.getFirstName().substring(0, 1).toUpperCase().trim() + "." + lastname.toUpperCase().trim() + ".");
				ProfileImageDTO profileImageDTO = new ProfileImageDTO();

				profileImageDTO.setImageUrl(PropertyLoader.iSelf.IMAGE_PATH + ""
						+ userDetails.getProfileImages().iterator().next().getImageUrl());
				profileImageDTO.setHiddenImageUrl(PropertyLoader.iSelf.IMAGE_PATH + ""
						+ userDetails.getProfileImages().iterator().next().getHiddenImageUrl());
				Set<ProfileImageDTO> dtos = new HashSet<ProfileImageDTO>();
				dtos.add(profileImageDTO);
				userDTO.setProfileImages(dtos);
				userDTO.setUserCarts1(userCartDTOs);
				list.add(userDTO);
				responseDTO.setResponseList(list);
				responseDTO.setStatus(Constants.SUCCESS_STATUS);
				responseDTO.setStatusCode(Constants.SUCCESS_STATUS_CODE);
				 responseDTO.setMessage("Profile successfully added ");

				}else {
				
		         responseDTO.setStatus(Constants.FAILURE_STATUS);
				 responseDTO.setStatusCode(Constants.FAILURE_STATUS_CODE);
				 responseDTO.setErrorMsg("Profile is already added");	
				}

			

			if (userCart.getUserCart() == null) {
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				CustomUser customUser = (CustomUser) auth.getPrincipal();
				 userID = customUser.getUserId();
				responseDTO.setCartCount("" + userCartDAO.cartCount(userID));
			} else {

				responseDTO.setCartCount("" + userCartDAO.cartCount(userCart.getUserCart().getUserId()));
			}

		} catch (Exception e) {

			responseDTO.setStatus(Constants.FAILURE_STATUS);
			responseDTO.setStatusCode(Constants.FAILURE_STATUS_CODE);
			// e.printStackTrace();
		}

		return responseDTO;
	}

	@Override
	public ResponseDTO deleteCart(UserCartDTO userCartDTO) {
		// TODO Auto-generated method stub

		UserCart userCart = new UserCart();
		userCart.setUserCartId(userCartDTO.getUserCartId());
		User user=new  User();
		ResponseDTO responseDTO=null;
		if(userCartDTO.getUserCart()==null) {   //for web
			
			CustomUser customUser=getloginUserDetails();
			int userID = customUser.getUserId();
		
			user.setUserId(userID);
			userCart.setUserCart(user);
			responseDTO = userCartDAO.deleteCart(userCart);
			responseDTO.setCartCount("" +userCartDAO.cartCount(userCart.getUserCart().getUserId()));
		}else {
			
			 responseDTO = userCartDAO.deleteCart(userCart);
				if (userCartDTO.getUserCart() != null) {
					
			 responseDTO.setCartCount("" +userCartDAO.cartCount(userCartDTO.getUserCart() .getUserId()));
				}
			
		}
		
	
		return responseDTO;
	}

	@Override
	public ResponseDTO getUserCart(UserCartDTO userCart) {
		ResponseDTO responseDTO2 = new ResponseDTO();
		List<Object> userCartDTOs = new ArrayList<Object>();
		try {

			User user = new User();
			user.setUserId(userCart.getUserCart().getUserId());
			UserCart uCart = new UserCart();
			uCart.setUserCart(user);

			List<UserCart> userCartData = userCartDAO.getUserCart(uCart);
			UserDTO userData =null;
			for (UserCart usercart : userCartData) {				
				userData = (UserDTO) mapper.convert(usercart.getUserProfile(), userData, UserDTO.class);
				UserCartDTO userCartDTO = new UserCartDTO();
				userCartDTO.setUserCartId(usercart.getUserCartId());
				Set<UserCartDTO> setUserCartDTO = new HashSet<UserCartDTO>();
				setUserCartDTO.add(userCartDTO);
				userData.setUserCarts1(setUserCartDTO);

				userData.setUserLogin(null);
				userData.setUserQuestionAnswers(null);
				userData.setUserPurchasedCartDTO(null);
				Set<ProfileImageDTO> profileImageDTOs = userData.getProfileImages();
				for (ProfileImageDTO p : profileImageDTOs) {
					p.setImageUrl(PropertyLoader.iSelf.IMAGE_PATH + "" + p.getImageUrl());
					p.setHiddenImageUrl(PropertyLoader.iSelf.IMAGE_PATH + "" + p.getHiddenImageUrl());

					System.out.println(p.getHiddenImageUrl());
				}

				userData.setProfileImages(profileImageDTOs);
				userCartDTOs.add(userData);
			}

			responseDTO2.setResponseList(userCartDTOs);
			responseDTO2.setStatus(Constants.SUCCESS_STATUS);
			responseDTO2.setStatusCode(Constants.SUCCESS_STATUS_CODE);

			if (userCart.getUserCart() == null) {
				Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				CustomUser customUser = (CustomUser) auth.getPrincipal();
				int userID = customUser.getUserId();
				responseDTO2.setCartCount("" + userCartDAO.cartCount(userID));
			} else {

				responseDTO2.setCartCount("" + userCartDAO.cartCount(userCart.getUserCart().getUserId()));
			}

		} catch (Exception e) {
			// TODO: handle exception
			responseDTO2.setStatus(Constants.FAILURE_STATUS);
			responseDTO2.setStatusCode(Constants.FAILURE_STATUS_CODE);

		}

		// TODO Auto-generated method stub
		return responseDTO2;
	}

	@Override
	public ResponseDTO buyProfileCard(UserDTO userDTO) {
		// TODO Auto-generated method stub
		ResponseDTO responseDTO = new ResponseDTO();

		try {
			java.util.Date dt = new java.util.Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String currentTime = sdf.format(dt);
			java.util.Date date = sdf.parse(currentTime);

			Set<UserPurchasedCartDTO> userPurchasedCarts = userDTO.getUserPurchasedCartDTO();

			for (UserPurchasedCartDTO userpCart : userPurchasedCarts) {

				UserPurchasedCart userPurchasedCart = new UserPurchasedCart();
				userPurchasedCart.setQuantity(userpCart.getQuantity());
				userPurchasedCart.setPrice(userpCart.getPrice());
				userPurchasedCart.setTransactionId(userpCart.getTransactionId());
			//	userPurchasedCart.setProfileId(userpCart.getProfileId());

				User user = new User();
				user.setUserId(userDTO.getUserId());
				userPurchasedCart.setUserCart(user);

				ProfilePackage package1 = new ProfilePackage();

				package1.setPackageId(userpCart.getProfilePackage().getPackageId());
				userPurchasedCart.setProfilePackage(package1);

				userPurchasedCart.setCreatedOn("" + date);
				userPurchasedCart.setModifiedOn("" + date);
				userPurchasedCart.setStatus((byte) 1);

				userPurchageCartDAO.save(userPurchasedCart);

				userPurchageCartDAO.flush();
				userPurchageCartDAO.clear();
			}

			responseDTO.setStatus(Constants.SUCCESS_STATUS);
			responseDTO.setStatusCode(Constants.SUCCESS_STATUS_CODE);

		} catch (Exception e) {
			// TODO: handle exception
			responseDTO.setStatus(Constants.FAILURE_STATUS);
			responseDTO.setStatusCode(Constants.FAILURE_STATUS_CODE);

			e.printStackTrace();
		}

		return responseDTO;
	}

	@Override
	public ResponseDTO getPurchasedCart(UserPurchasedCartDTO userPurchageCart) {
		// TODO Auto-generated method stub
		int userId = 0;
		if(userPurchageCart.getUserCart()==null) {   //for web
			UserDTO userCart =new UserDTO();
			CustomUser customUser=getloginUserDetails();
			userId = customUser.getUserId();
			userCart.setUserId(userId);
			userPurchageCart.setUserCart(userCart);
		}
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			List<UserPurchasedCart> userPurchaseCarts = userPurchageCartDAO.getPurchasedCart(userPurchageCart);
			ArrayList<Object> arrayList = new ArrayList<Object>();
			for (UserPurchasedCart upc : userPurchaseCarts) {

				UserPurchasedCartDTO userPurchasedCartDTO = new UserPurchasedCartDTO();
			/*	userPurchasedCartDTO.setId(upc.getId());
				userPurchasedCartDTO.setPrice(upc.getPrice());
				userPurchasedCartDTO.setQuantity(upc.getQuantity());
			//	userPurchasedCartDTO.setProfileId(upc.getProfileId());
				userPurchasedCartDTO.setCreatedOn(upc.getCreatedOn());
				userPurchasedCartDTO.setModifiedOn(upc.getCreatedOn());
				userPurchasedCartDTO.setStatus(upc.getStatus());
				ProfilePackageDTO packageDTO = new ProfilePackageDTO();
				packageDTO.setPackageId(upc.getProfilePackage().getPackageId());
				userPurchasedCartDTO.setProfilePackage(packageDTO);*/

				UserDTO userDTO = new UserDTO();

				User user2 = upc.getUserCart();

				user2.setUserCarts1(null);
				user2.setUserQuestionAnswers(null);
				user2.setUserPurchasedCartDTO(null);

				userDTO = (UserDTO) mapper.convert(user2, userDTO, UserDTO.class);
				
				userPurchasedCartDTO.setUserCart(userDTO);

				arrayList.add(userPurchasedCartDTO);
			}
			responseDTO.setResponseList(arrayList);
			responseDTO.setStatus(Constants.SUCCESS_STATUS);
			responseDTO.setStatusCode(Constants.SUCCESS_STATUS_CODE);

		} catch (Exception e) {

			responseDTO.setStatus(Constants.FAILURE_STATUS);
			responseDTO.setStatusCode(Constants.FAILURE_STATUS_CODE);
		}

		return responseDTO;
	}

	@Override
	public UserDTO getUserProfileByID(int profileId) {
		// TODO Auto-generated method stub

		User user = userDetailsDao.fetchUserById(profileId);
		UserDTO userDTO = new UserDTO();

		try {

			userDTO = ((UserDTO) mapper.convert(user, userDTO, UserDTO.class));

		} catch (Exception e) {

		}

		return userDTO;
	}

	private CustomUser getloginUserDetails() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CustomUser customUser = (CustomUser) auth.getPrincipal();
		 return customUser;
	}
}
