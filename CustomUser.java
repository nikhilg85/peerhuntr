package com.infodart.peerhuntr.jpa.entity.user;


import java.util.Collection;

import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;

import com.infodart.peerhuntr.propertyloader.PropertyLoader;

import org.springframework.security.core.userdetails.UserDetails;

@PropertySource("classpath:messages.properties")
public class CustomUser implements UserDetails {

	 private static final long serialVersionUID = 1L;

	    private byte emailvarified;
	    private int userId;
	    private byte userStautsId;
	    private UserBuilder builder = null;	
	    private String name;
	    private String imageUrl;
	    private int userLoginId;
	   
		public CustomUser(byte emailvarified,int userId,byte userStautsId,UserBuilder builder,String name,String imageUrl,int userLoginId) {
	    	this.userStautsId=userStautsId;
	    	this.emailvarified=emailvarified;
	    	this.userId=userId;
	    	this.builder=builder;
	    	this.name=name;
	    	this.imageUrl=imageUrl;
	    	this.userLoginId=userLoginId;
	    }



		public void setEmailvarified(byte emailvarified) {
			this.emailvarified = emailvarified;
		}


		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public int getUserStautsId() {
			return userStautsId;
		}


		public void setUserId(int userId) {
			this.userId = userId;
		}


		@Override
	    public String getUsername() {
	        return builder.build().getUsername();
	    }

	    @Override
	    public String getPassword() {
	        return builder.build().getPassword();
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	             return builder.build().getAuthorities();
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	      return true;
	    }
	    

	    public boolean getUserEmailVerified() {
	    	 if(emailvarified==(byte)1) {
			     return true;
		      }else
		        return false;
	    }

	    public int getUserId() {
	    	return userId;
	    }
	   

		public boolean getUserStatus() {
		    if(userStautsId==(byte)1) {
			     return true;
		      }
		    return false;	
		}


	    public String getImageUrl() {
			return PropertyLoader.iSelf.IMAGE_PATH + ""+imageUrl;
		}



		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}



		public int getUserLoginId() {
			return userLoginId;
		}



		public void setUserLoginId(int userLoginId) {
			this.userLoginId = userLoginId;
		}



}