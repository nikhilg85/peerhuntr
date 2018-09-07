/**
 * 
 */
package com.infodart.peerhuntr.spring.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * @author akanchha.kumari
 *
 */
public class CustomLogoutHandler implements LogoutSuccessHandler {

	/* (non-Javadoc)
	 * @see org.springframework.security.web.authentication.logout.LogoutSuccessHandler#onLogoutSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
	 */
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		//logger.info("Logout Sucessfull with Principal: " + authentication.getName());
		
		response.setStatus(HttpServletResponse.SC_OK);
        //redirect to login
		response.sendRedirect("/login");

	}

}
