package com.infodart.peerhuntr.jpa.service.Impl;

import java.util.List;

import com.infodart.peerhuntr.dto.response.ResponseDTO;
import com.infodart.peerhuntr.dto.user.UserDTO;
import com.infodart.peerhuntr.dto.userCart.UserCartDTO;
import com.infodart.peerhuntr.dto.userCart.UserPurchasedCartDTO;

public interface UserPaymentService {

	public ResponseDTO addToCart(UserCartDTO userCart);
	public ResponseDTO deleteCart(UserCartDTO userCart);
	public ResponseDTO getUserCart(UserCartDTO userCart);
	
	public ResponseDTO getPurchasedCart(UserPurchasedCartDTO userCart);
	public ResponseDTO buyProfileCard(UserDTO  userDTO);
	
	public UserDTO getUserProfileByID(int profileId);
	
	
}
