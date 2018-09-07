<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html >
 
  <!-- FOr Header Area -->
  <jsp:include page="header.jsp"></jsp:include>
  
  <!-- start page title section -->
  <section class="wow fadeIn bg-extra-dark-gray padding-35px-tb page-title-small ">
   <div class="container">
   <div class="row equalize">
   <div class="col-lg-8 col-md-6 col-sm-6 col-xs-12 display-table">
   <div class="display-table-cell vertical-align-middle text-left xs-text-center">
   
   <!-- start page title Area-->
   <h1 class="alt-font text-white font-weight-600 no-margin-bottom text-uppercase">Login Form</h1>
   
   <!--Here end page title Area -->
    </div>
     </div>
     <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12 display-table text-right xs-text-left xs-margin-10px-top">
      <div class="display-table-cell vertical-align-middle breadcrumb text-small alt-font">
                           
  <!-- end breadcrumb -->
     </div>
     </div>
     </div>
     </div>
     </section>
  <!-- Here end page title section -->
        
  <!-- Here style 03 section Area -->
        <section class="wow fadeIn bg-light-gray">
            <div class="container">
       
                <form id="contact-form-3" action='<spring:url value="/loginAction"/>'  method="post">
                  <% String bool= request.getParameter("profile");
 				response.addHeader("profile",bool);
 				response.setHeader("profile",bool);
 				request.setAttribute("profile",bool);
 				%>
                    <div class="row"> 
                        <div class="col-md-6 wow fadeIn center-col">
                            <div class="padding-fifteen-all bg-white border-radius-6 md-padding-seven-all">
                                <div class="text-extra-dark-gray alt-font text-large font-weight-600 margin-30px-bottom">LOGIN</div> 
                                <div>
		                             <c:if test="${param.error != null}">
										<div class="alert alert-danger">
											<p>Invalid email or password</p>
										</div>
									</c:if>
									 <c:if test="${param.email != null}">
										<div class="alert alert-danger">
											<p>Please verify your email</p>
										</div>
									</c:if>
									<c:if test="${param.logout != null}">
										<div class="alert alert-success">
											<p>You have been logged out successfully.</p>
										</div>
									</c:if>
                                     <div id="success-contact-form-3" class="no-margin-lr"></div>
                                    
                                    <!--<input type="text" name="name" id="name" placeholder="Name*" class="input-bg">-->
                                    <input type="hidden" name="profile" id="profile" value=<%= request.getParameter("profile")%>>
                                    <input type="text" name="username" id="username" placeholder="username" class="input-bg">
                                    
                                    <input type="password" name="password" id="password" class="form-control" placeholder="Password" >
                                     <span toggle="#password" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                     
                                    <button id="contact-us-button-3" type="submit" class="btn btn-small border-radius-4 btn-black">LOGIN</button>
                                </div>
                                <br>
                                <div class="pull-left"> <a href='<spring:url value="/sendMail/forgetPassword"/>' style="color:#7bd10d; text-decoration:underline;">Forgot Password?</a></div>
                               
                                <div class="pull-right"><a href='<spring:url value="/home/register"/>' style="color:#7bd10d; text-decoration:underline;">Signup</a></div>
                       
                               <%--  <form action='<spring:url value="/registerAction"/>' method="post">
                                <a href
                                </form> --%>
                                
                            </div>
                        </div>
                    </div>
                </form>
            </div>     
        </section>
        <!-- end form style 02 section -->
        <jsp:include page="footer.jsp"></jsp:include>
    
    