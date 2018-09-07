package com.infodart.peerhuntr.spring.config;

import java.io.IOException;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author akanchha kumari
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.infodart.peerhuntr.*" })
public class WebConfig implements WebMvcConfigurer {

   @Bean
   public InternalResourceViewResolver resolver() {
      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
      resolver.setViewClass(JstlView.class);
      resolver.setPrefix("/WEB-INF/views/");
      resolver.setSuffix(".jsp");
    //  System.out.println("resolver==="+resolver.getApplicationContext());
      return resolver;
   }
   
   @Bean(name = "multipartResolver")
   public CommonsMultipartResolver getResolver() throws IOException {
       CommonsMultipartResolver resolver = new CommonsMultipartResolver();
       // no limit
       resolver.setMaxUploadSize(-1);
       return resolver;
   }
   
   @Override
   public void addViewControllers(ViewControllerRegistry registry) {
      registry.addViewController("/login").setViewName("login");
   }
   
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
       registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
 
   
   }
   
  /* @Override
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
       configurer.enable();
   }
*/
   @Bean("messageSource")
   public MessageSource messageSource() {
	      ReloadableResourceBundleMessageSource messageSource=new ReloadableResourceBundleMessageSource();
	      messageSource.setBasename("classpath:messages");
	      messageSource.setDefaultEncoding("UTF-8");
	      messageSource.setUseCodeAsDefaultMessage(true);
	      return messageSource;
	   }

	   @Bean
	   public LocaleResolver localeResolver() {
	      CookieLocaleResolver localeResolver = new CookieLocaleResolver();
	      return localeResolver;
	   }

	   @Override
	   public void addInterceptors(InterceptorRegistry registry) {

	      LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	      localeChangeInterceptor.setParamName("lang");
	      registry.addInterceptor(localeChangeInterceptor);
	   }

}
