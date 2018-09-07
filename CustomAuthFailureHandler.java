package com.infodart.peerhuntr.spring.config.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.infodart.peerhuntr.dto.response.ResponseDTO;

import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;

@Component
public class CustomAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler  {
	
	 @Override
	    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
	            AuthenticationException exception) throws IOException, ServletException {
		 String os= request.getHeader("os");	    
			if(os!=null && (os.equals("iOS") || os.equals("Android"))) {
	 		 	response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		        response.addHeader("WWW-Authenticate", "Basic realm= PEARHUNTR_REALM");
		        PrintWriter writer = response.getWriter();
		        String badCredential=exception.getMessage();
		        if(exception.getMessage().equals("Bad credentials")) {
		        	badCredential="Please enter valid emailId or password";
		        }
		        writer.print("{\"message\":\""+badCredential+"\",\"statusCode\":\""+HttpServletResponse.SC_BAD_REQUEST+"\"}");
		        writer.flush();
		        writer.close();
		 }	else
	       getRedirectStrategy().sendRedirect(request, response, "/login?error=true");

	    }
}
