package com.infodart.peerhuntr.jpa.service.Impl;

import java.util.List;

import com.infodart.peerhuntr.dto.user.DegreeMasterDTO;
import com.infodart.peerhuntr.dto.user.NationalityMasterDTO;
import com.infodart.peerhuntr.dto.user.SpecializationMasterDTO;
import com.infodart.peerhuntr.dto.user.UserDTO;
import com.infodart.peerhuntr.dto.user.UserLoginDTO;
import com.infodart.peerhuntr.jpa.entity.user.User;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.infodart.peerhuntr.dto.request.RequestDTO;
import com.infodart.peerhuntr.dto.response.ResponseDTO;



public interface UserService {
	
	public ResponseDTO registerUser(UserDTO userDTO,HttpServletRequest request);

	public String validateVerificationToken(String token);
	public List<Object> getDegree();
	public List<Object> getNationality();
	public List<Object> getSpecialization();
	public ResponseDTO getSpecializationOnDegree(SpecializationMasterDTO specializationMasterDTO);
	public User getUser(String token);
	public ResponseDTO  forgetPassword(UserLoginDTO userLoginDTO);
	public ResponseDTO  changePassword(UserLoginDTO userLoginDTO);
	public ResponseDTO  fetchAllUserProfile();
	public ResponseDTO fetchUsersCard(RequestDTO resquestDTO);
	public ResponseDTO getUserProfile(int userId);
	public boolean saveRegisterImage(UserDTO userDTO,HttpServletRequest request);
	public ResponseDTO updateCustomer(UserDTO userDTO,HttpServletRequest request);
	public boolean updateRegisterImage(UserDTO userDTO,HttpServletRequest request);
	public ResponseDTO getSuggetionList(String filterParamter,String keyname); // suggetion for filtering 
	public void updateReferralCode(User user);
	public ResponseDTO updateForgetPassword(UserLoginDTO userLoginDTO);

	public List<Object> getgetMultiFilterKeyOnNationalty(SpecializationMasterDTO specializationMaster);
}
