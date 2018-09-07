package com.infodart.peerhuntr.jpa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.infodart.peerhuntr.dto.response.ResponseDTO;
import com.infodart.peerhuntr.dto.user.UserDTO;
import com.infodart.peerhuntr.dto.userCart.UserCartDTO;
import com.infodart.peerhuntr.dto.userCart.UserPurchasedCartDTO;
import com.infodart.peerhuntr.jpa.dao.UserPurchasedCartDao;
import com.infodart.peerhuntr.jpa.dao.impl.basedao.AbstractGenericDao;
import com.infodart.peerhuntr.jpa.entity.user.User;
import com.infodart.peerhuntr.jpa.entity.userCart.UserCart;
import com.infodart.peerhuntr.jpa.entity.userCart.UserPurchasedCart;

@Repository
public class UserPurchasedCartDaoImpl  extends AbstractGenericDao<UserPurchasedCart> implements UserPurchasedCartDao {

	@Override
	public List<UserPurchasedCart> getPurchasedCart( UserPurchasedCartDTO  userPurchageCart  ) {
		// TODO Auto-generated method stub
		

		
		List<UserPurchasedCart> userCartList=new ArrayList<UserPurchasedCart>();
		try {
			
			userCartList  = getSession() .createQuery("from UserPurchasedCart  where userCart.userId=?").setParameter(0,userPurchageCart.getUserCart().getUserId()).list();
			

			}catch(Exception e) {
				e.printStackTrace();
				
			}
		
		
		return userCartList;
	}

	
	
	
	}


