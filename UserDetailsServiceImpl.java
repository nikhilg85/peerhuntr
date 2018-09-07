package com.infodart.peerhuntr.jpa.service.Impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infodart.peerhuntr.jpa.dao.UserDetailsDao;
import com.infodart.peerhuntr.jpa.entity.user.CustomUser;
import com.infodart.peerhuntr.jpa.entity.user.ProfileImage;
import com.infodart.peerhuntr.jpa.entity.user.User;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	  private UserDetailsDao userDetailsDao;

	  @Transactional(readOnly = true)
	  @Override
	  public UserDetails loadUserByUsername(String userLoginID) throws UsernameNotFoundException {
		  
		  UserBuilder builder = null;		  
			  User user = userDetailsDao.fetchUser(userLoginID);
		 if (user != null) { 
	      builder = org.springframework.security.core.userdetails.User.withUsername(userLoginID);
	      builder.password(user.getUserLogin().getLoginPassword());
	      String authority = user.getUserLogin().getAuthorityMaster().getAuthority().toString(); 
	      if(user.getEmailVerified()==(byte)1 &&user.getStatus()==(byte)0) {
	    	  authority = "ROLE_ANONYMOUS";
	      }
	      
	      builder.authorities(authority);
	    } else {
	      throw new UsernameNotFoundException("User not found.");
	    }
		 ProfileImage profileImage =null;
		 
		 /*while(user.getProfileImages().iterator().hasNext()) {
			 profileImage=(ProfileImage)user.getProfileImages().iterator().next();
			 profileImage.setUser(null);
		 }*/
		 
		 Iterator itr =  user.getProfileImages().iterator();
			Set<ProfileImage> profileImageSet = new HashSet<ProfileImage>();
		  while(itr.hasNext()) {
			  profileImage =  (ProfileImage)itr.next();
			  profileImage.setUser(null);
			  profileImageSet.add(profileImage);				 
		  }

		  return  new CustomUser(user.getEmailVerified(),user.getUserId(),user.getStatus(),builder,user.getFirstName(),profileImage.getImageUrl(),user.getUserLogin().getUserLoginId());
	  }
}
