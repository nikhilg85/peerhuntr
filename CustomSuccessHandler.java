package com.infodart.peerhuntr.spring.config.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.infodart.peerhuntr.jpa.entity.user.CustomUser;
import com.infodart.peerhuntr.propertyloader.PropertyLoader;

import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;

@Component
@PropertySource("classpath:messages.properties")
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	CustomUser customUser =null;
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String profile=(String)request.getParameter("profile");  		
		String os= request.getHeader("os");	    
		customUser = (CustomUser) authentication.getPrincipal();
		 final HttpSession session = request.getSession(false);
	        if (session != null) {
	            session.setMaxInactiveInterval(30 * 60);
	        }
		if(os!=null && (os.equals("iOS") || os.equals("Android"))) {
	 		 	response.setStatus(HttpServletResponse.SC_OK);
		        response.addHeader("WWW-Authenticate", "Basic realm= PEARHUNTR_REALM");
		        PrintWriter writer = response.getWriter();
		        
		        writer.print("{\"ROLE\":\""+customUser.getAuthorities()+"\", \"username\":\""+authentication.getName()+"\","
		        		+"\"userId\":\""+customUser.getUserId()+"\","
		        		+"\"emailVarifed\":\""+customUser.getUserEmailVerified()+"\","
		        		+"\"userStatus\":\""+customUser.getUserStatus()+"\","
		        		+"\"userLoginId\":\""+customUser.getUserLoginId()+"\","
		        		+"\"imageUrl\":\""+PropertyLoader.iSelf.IMAGE_PATH + "" +customUser.getImageUrl()+"\","
		        		+ "\"statusCode\":\""+HttpServletResponse.SC_OK+"\",\"message\":\"User Found\"}");
		        writer.flush();
		        writer.close();
		 }	else {
			 String targetUrl = determineTargetUrl(customUser,profile);
		  redirectStrategy.sendRedirect(request, response, targetUrl);
		 }
	 	
		if (response.isCommitted()) {
			System.out.println("Can't redirect");
			return;
		}
		
	}

	/*
	 * This method extracts the roles of currently logged-in user and returns
	 * appropriate URL according to his/her role.
	 */
	protected String determineTargetUrl(CustomUser customUser,String profile) {
		String url = "";
		Collection<? extends GrantedAuthority> authorities = customUser.getAuthorities();

		List<String> roles = new ArrayList<String>();

		for (GrantedAuthority a : authorities) {
			roles.add(a.getAuthority());
		}

		 if (isAdmin(roles)) {
			url = "/admin";
		} else if (isUser(roles)&&customUser.getUserEmailVerified()&&customUser.getUserStatus()) {
			if(profile!=null && profile.equals("true"))
			url = "/dashboard/myProfile";
			else
			url = "/dashboard";		
		}
		else if(customUser.getUserEmailVerified()&&!customUser.getUserStatus()) {
				url = "/personalityTestInfo?user="+customUser.getUserId();
			}
			else if(isUser(roles)&&!customUser.getUserEmailVerified()&&!customUser.getUserStatus()) {
					url = "/login?email=false";
		} else {
			url = "/accessDenied";
		}

		return url;
	}

	private boolean isUser(List<String> roles) {
		if (roles.contains("ROLE_USER")) {
			return true;
		}
		return false;
	}

	private boolean isAdmin(List<String> roles) {
		if (roles.contains("ROLE_ADMIN")) {
			return true;
		}
		return false;
	}



	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

}