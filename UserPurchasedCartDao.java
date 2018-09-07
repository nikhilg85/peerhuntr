package com.infodart.peerhuntr.jpa.dao;

import java.util.List;

import com.infodart.peerhuntr.dto.user.UserDTO;
import com.infodart.peerhuntr.dto.userCart.UserPurchasedCartDTO;
import com.infodart.peerhuntr.jpa.dao.impl.basedao.GenericDao;
import com.infodart.peerhuntr.jpa.entity.user.User;
import com.infodart.peerhuntr.jpa.entity.userCart.UserPurchasedCart;

public interface UserPurchasedCartDao extends  GenericDao<UserPurchasedCart>{
	
	
	public List<UserPurchasedCart> getPurchasedCart(UserPurchasedCartDTO  userPurchageCart);
	
  
}
