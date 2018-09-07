package com.infodart.peerhuntr.propertyloader;

import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

	public String SMTP_HOST;
	public String MAIL_FROM;
	public String AUTH_USER;
	public String MAIL_PASS;
	public String MAIL_PORT;
	public 	String PROJECT_LINK;
	public 	String IMAGE_PATH;
	public 	String REGISTRATION_SUBJECT;
	public 	String CONFIRM_REGISTRATION_SUBJECT;
	public String FORGET_PASSWORD_SUBJECT;
	public static PropertyLoader iSelf=null;
	private PropertyLoader() {
		
		
		
		
	        
	}
	public void loadProperties() {
		try {
			Properties configuration = new Properties();
	        InputStream inputStream = PropertyLoader.class
	  	          .getClassLoader()
	  	          .getResourceAsStream("application.properties");
	  	        configuration.load(inputStream);
	  	        inputStream.close();
	  	        
	  	        
	  	      this.SMTP_HOST = configuration.getProperty("SMTP_HOST");
	  	      this.MAIL_FROM = configuration.getProperty("MAIL_FROM");
	  	      this.AUTH_USER = configuration.getProperty("AUTH_USER");
	  	      this.MAIL_PASS = configuration.getProperty("MAIL_PASS");
	  	      this.MAIL_PORT = configuration.getProperty("MAIL_PORT");
	  	      this.PROJECT_LINK = configuration.getProperty("PROJECT_LINK");
	  	      this.REGISTRATION_SUBJECT = configuration.getProperty("REGISTRATION_SUBJECT");
	  	      this.CONFIRM_REGISTRATION_SUBJECT = configuration.getProperty("CONFIRM_REGISTRATION_SUBJECT");
	  	      this.FORGET_PASSWORD_SUBJECT = configuration.getProperty("FORGET_PASSWORD_SUBJECT");
	  	      this.IMAGE_PATH=configuration.getProperty("IMAGE_PATH");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	public static PropertyLoader getInstance() {
		if(iSelf==null) {
			iSelf=new PropertyLoader();
		}
		
		return iSelf;
	}
}
