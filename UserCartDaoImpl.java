package com.infodart.peerhuntr.jpa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infodart.peerhuntr.constants.Constants;
import com.infodart.peerhuntr.dto.response.ResponseDTO;
import com.infodart.peerhuntr.jpa.dao.UserCartDao;
import com.infodart.peerhuntr.jpa.dao.impl.basedao.AbstractGenericDao;
import com.infodart.peerhuntr.jpa.entity.user.User;
import com.infodart.peerhuntr.jpa.entity.userCart.UserCart;
@Repository
public class UserCartDaoImpl  extends AbstractGenericDao<UserCart> implements UserCartDao{

	@Autowired
	UserCartDao userCartDAO;
	
	
	@Override
	@Transactional
	public ResponseDTO deleteCart(UserCart userCart) {
		// TODO Auto-generated method stub
		ResponseDTO responseDTO=new ResponseDTO();
	      try {
	    	  
	    	  Query qry = getSession().createQuery("delete from UserCart c where c.userCartId=:user_cart_id ");
			  qry.setParameter("user_cart_id",userCart.getUserCartId());
			  qry.executeUpdate();
			 
			  responseDTO.setStatus(Constants.SUCCESS_STATUS);
			  responseDTO.setStatusCode(Constants.SUCCESS_STATUS_CODE);
			  responseDTO.setMessage("Profile Deleted from Cart!");    
	    	  
	      }catch(Exception e) {
	    	  e.printStackTrace();
	    	  
	    	  responseDTO.setStatus(Constants.FAILURE_STATUS);
			  responseDTO.setStatusCode(Constants.FAILURE_STATUS_CODE);
			  responseDTO.setErrorMsg("Profile can't be deleted from cart!");
	      }
		  
		
		
		return responseDTO;
	}

	@Override
	public List<UserCart> getUserCart(UserCart userCart) {
		// TODO Auto-generated method stub		
		List<UserCart> userCartList=new ArrayList<UserCart>();		
		
		try {
			
			userCartList  = getSession() .createQuery("from UserCart  where userCart.userId=? and  status=1").setParameter(0,userCart.getUserCart().getUserId()).list();

			}catch(Exception e) {
				e.printStackTrace();
				
			}	
		return userCartList;
	}

	@Override
	public User getUserDetails(Integer userID) {
		// TODO Auto-generated method stub
		List<User> userList=new ArrayList<User>();
		try {			
			userList  = getSession() .createQuery("from User  where userId=? and status=1").setParameter(0,userID).list();
			}catch(Exception e) {
				e.printStackTrace();			
			}
		User userDetails=userList.get(0);		
		return userDetails;
	}

	@Override
	public int cartCount(Integer userID) {
		// TODO Auto-generated method stub
		Integer count=0;
		try {
			List<UserCart> countList  = getSession() .createQuery("from UserCart where userCart.userId=? ").setParameter(0,userID).list();
			count=countList.size();
			}catch(Exception e) {
				//e.printStackTrace();
				
			}
		
		
		return count;
	}

	@Override
	public int getCartCountByuserId(int userId) {

		Integer count=0;
		try {	
			List<UserCart> countList  = getSession() .createQuery("from UserCart where userCart.userId=? ").setParameter(0,userId).list();	
			count=countList.size(); 
			}catch(Exception e) {
				e.printStackTrace();
				
			}		
		return count;	
	}

	@Override
	public boolean getPofileCartAlreadyAdded(int userId, int profileID) {		
		boolean b=false;
		int count=0;
		try {			
		    String SQL_QUERY = "SELECT count(*) FROM UserCart u where u.userCart.userId=? and u.userProfile.userId=? ";
			List<Object[]> list=null;
	        Query query= getSession().createQuery(SQL_QUERY);
	        query.setParameter(0, userId);
	        query.setParameter(1, profileID);
			count = Integer.valueOf(""+(query.list().get(0)));
					
			if(count==0) {
				b=true;
			}
			}catch(Exception e) {
				e.printStackTrace();
				
			}
		
		
		return b;
	
	}
}
