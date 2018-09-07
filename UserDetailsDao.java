package com.infodart.peerhuntr.jpa.dao;

import com.infodart.peerhuntr.jpa.entity.user.User;
import com.infodart.peerhuntr.jpa.entity.user.UserLogin;

public interface UserDetailsDao {
	
		  UserLogin findUserByUsername(String userName);
		  User checkUserEmailVarified(String userName);
		  public User fetchUser(String userName);
		  public User fetchUserById(int id) ;
}
