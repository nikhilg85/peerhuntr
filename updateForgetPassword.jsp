<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html class="no-js" lang="en" >
<head>
  <script type="text/javascript">
  function validate() {
	  //var string = "15455555a";
	  var string =document.updateForgetPaswrdForm.newPassword.value;
	 
		 var re = new RegExp("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");
		 if (re.test(string)) {
		     
		     
		 } else {
		    
		     document.getElementById('message').innerHTML="Combination of small,capital,numeric and min 8 char.";
		     
		 }
  }
  </script>
  </head>
    <body  ng-app="peerhuntr" ng-controller="PeerController"  ng-cloak>  
<style type="text/css">
.error {
	color: red;
}
</style>
       <jsp:include page="header.jsp"></jsp:include>
      <!-- start page title section -->
        <section class="wow fadeIn bg-extra-dark-gray padding-35px-tb page-title-small top-space">
            <div class="container">
                <div class="row equalize">
                    <div class="col-lg-8 col-md-6 col-sm-6 col-xs-12 display-table">
                        <div class="display-table-cell vertical-align-middle text-left xs-text-center">
                            <!-- start page title -->
                            <h1 class="alt-font text-white font-weight-600 no-margin-bottom text-uppercase">Change Password</h1>
                            <!-- end page title -->
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12 display-table text-right xs-text-left xs-margin-10px-top">
                        <div class="display-table-cell vertical-align-middle breadcrumb text-small alt-font">
                            <!-- start breadcrumb -->
                            <!--<ul class="xs-text-center">
                                <li><a href="#" class="text-dark-gray">Elements</a></li>
                                <li><a href="#" class="text-dark-gray">General elements</a></li>
                                <li class="text-dark-gray">Contact form</li>
                            </ul>-->
                            <!-- end breadcrumb -->
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- end page title section -->
        
        <section class="wow fadeIn big-section bg-light-gray" id="section-down">
         <form id="updateForgetPaswrdForm"  method="post"  name="updateForgetPaswrdForm" validate ng-submit="updateForgetPassword()" ng-cloak>
            <div class="container">
                <div class="row equalize sm-equalize-auto">
                    <div class="col-md-6 wow fadeIn center-col">
                        <div class="padding-fifteen-all bg-white border-radius-6 md-padding-seven-all xs-padding-30px-all height-100">
                            <input type="hidden"   id="referralCodeId" value=<%= request.getParameter("referralCode") %> >
                       <%--  <input     ng-model="userLogin.referralCode"    value=<%= request.getParameter("referralCode") %>></input> --%>
                                <div>
                                    <div id="success-contact-form" class="no-margin-lr"></div>
                                  
                                    <input required type="password"   ng-model="userLogin.newPassword"  name="newPassword" id="newPasswordId" onBlur="validate()" placeholder=" New Password" class="border-radius-4 input-bg medium-input" ></input>
                                    <span toggle="#newPasswordId" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                   <span  style='color:red' class="help-inline" ng-show="submitted && updateForgetPaswrdForm.newPassword.$error.required">New Password is Required</span><br/>
                                    <label id="message" style='color:red'></label>
                              
                                  <br/>
             				 
             					    <input required type="password" compare-to="userLogin.newPassword"  ng-model="userLogin.confirmPassword" name="confirmPassword" id="confirmPasswordId" placeholder=" Confirm Password" class="border-radius-4 input-bg medium-input" ></input>
             					    <span toggle="#confirmPasswordId" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                   <span  style='color:red' class="help-inline" ng-show="submitted && updateForgetPaswrdForm.confirmPassword.$error.required">Confirm Password is Required</span><br/>
                                    <span  style='color:red' ng-show="submitted && userLogin.newPassword != userLogin.confirmPassword">Password mismatch</span>
                                  <span style='color:red' class="help-inline" ng-show="submitted && updateForgetPaswrdForm.confirmPassword.$error.ngcompare" class="help-block">Password's don't match</span>
                                  
                                  <br/> 
                                   <div id="loading" > </div> 
                                  <!-- ng-disabled="userLogin.newPassword!=userLogin.confirmPassword" -->
                                   <button id="contact-us-button" type="submit"  ng-disabled="userLogin.newPassword!=userLogin.confirmPassword"  ng-click="submitted=true" class="btn btn-small border-radius-4 btn-dark-gray">Submit</button>
                                                              
                            
                        </div>
                    </div>
                  
                </div>
            </div>
            </div>
             </form>
        </section>
        
          <script src="<c:url value='/resources/js/angular.js' />"></script>
       <script src="<c:url value='/resources/js/angular.min.js' />"></script>
       <script src="<c:url value='/resources/js/angular-animate.js' />"></script>
        <script src="<c:url value='/resources/js/angular-flexslider.js' />"></script> 
        <script src="<c:url value='/resources/js/angular-route.js' />"></script>
         <script src="<c:url value='/resources/js/angular-ui-tree.js' />"></script>
        <script src="<c:url value='/resources/js/peerhuntr.js' />"></script>    
        <jsp:include page="footer.jsp"></jsp:include>
        