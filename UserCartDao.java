package com.infodart.peerhuntr.jpa.dao;

import java.util.List;

import com.infodart.peerhuntr.dto.response.ResponseDTO;
import com.infodart.peerhuntr.jpa.dao.impl.basedao.GenericDao;
import com.infodart.peerhuntr.jpa.entity.user.User;
import com.infodart.peerhuntr.jpa.entity.userCart.UserCart;

public interface UserCartDao  extends  GenericDao<UserCart>{

	public ResponseDTO deleteCart(UserCart userCart);
	public List<UserCart> getUserCart(UserCart userCart);
	public User getUserDetails(Integer userID);
	public int cartCount(Integer userID);
	public int getCartCountByuserId(int userId);
	public boolean getPofileCartAlreadyAdded(int userId,int profileID);
}
