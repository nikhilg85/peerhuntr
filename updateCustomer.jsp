 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!doctype html>
<html class="no-js" lang="en">
  <div ng-app="peerhuntr" ng-controller="PeerController"  ng-cloak ng-init="getUserProfile()">
 <jsp:include page="header.jsp"></jsp:include>
  <!-- start page title section -->
        <!-- start page title section -->
        <section class="wow fadeIn bg-extra-dark-gray padding-35px-tb page-title-small top-space">
            <div class="container">
                <div class="row equalize">
                    <div class="col-lg-8 col-md-6 col-sm-6 col-xs-12 display-table">
                        <div class="display-table-cell vertical-align-middle text-left xs-text-center">
                            <!-- start page title -->
                            <h1 class="alt-font text-white font-weight-600 no-margin-bottom text-uppercase">Update Profile</h1>
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
        
        <section class="wow fadeIn bg-light-gray" id="section-down">
            <div class="container">
                <div class="row equalize sm-equalize-auto">
				 
<form  id="updateCustomerForm" enctype="multipart/form-data" name="updateCustomerForm" action="javascript:void(0)" method="post" ng-submit="updateProfile()" ng-cloak >
                    <div class="row"> 
                      <div class="col-md-8 col-sm-12 col-xs-12 sm-margin-30px-bottom wow fadeInLeft center-col">
                        <div class="padding-ten-all bg-white border-radius-6 md-padding-seven-all xs-padding-30px-all height-100" style="padding-bottom: 65px;">
                              
                                <div>
                                    <div id="success-contact-form-3" class="no-margin-lr"></div>
                                    <div id="success-contact-form" class="no-margin-lr"></div>
                                    
                                   <input required type="text" ng-model="user.firstName" value={{user.firstName}} name="firstName" id="subject" placeholder="First Name" class="border-radius-4 input-bg medium-input" disabled>
                                   <input required type="text" ng-model="user.lastName" value={{user.lastName}} name="lastName" id="subject" placeholder="Last Name" class="border-radius-4 input-bg medium-input" disabled>
                                   
                                   <input required type="text" ng-model="user.userLogin.loginId" value=user.userLogin.loginId}} name="loginId" id="subject" placeholder="Email" class="border-radius-4 input-bg medium-input" disabled>
                                 
                                 
                                 	  <select  required  ng-model="user.countryCode" value={{user.countryCode}} ng-options="n.countryCode as n.countryCode for n in nationality" name="countryCode" class="border-radius-4 input-bg medium-input"  style="width:17%; padding:8px 10px;">
    									
									</select>
									<span style='color:red' class="help-inline" ng-show="submitted && updateCustomerForm.countryCode.$error.required">Country Code is Required</span>
									
									
									 <input required ng-pattern="/^\d{1,20}$/" minlength="6" maxlength="20" type="text" ng-model="user.contactNo" value={{user.contactNo}} name="contactNo" id="subject" placeholder="Telephone number " class="border-radius-4  medium-input" style="width:82%;" >
                                    <span style='color:red' class="help-inline" ng-show="submitted && updateCustomerForm.contactNo.$error.required">Contact No is Required</span><br/>
                                  	 <span style='color:red' class="help-inline" ng-show="updateCustomerForm.contactNo.$error.pattern">
  										 Only numeric is allowed
  									</span> 
                                  <span style='color:red' class="help-inline" ng-show="submitted && updateCustomerForm.contactNo.$error.minlength">
  										Minimum 6 numeric characters
  									</span> 
  									
  									
                                
                                    <select  ng-model="user.specializationMaster.degreeMaster.degreeId" ng-options="d.degreeId as d.degreeName for d in degree" ng-change="getSpec(user.specializationMaster.degreeMaster.degreeId)" class="border-radius-4 input-bg medium-input" >
    									
									</select>
									
									<select  required  ng-model="user.specializationMaster.specializationId" ng-options="s.specializationId as s.specializationName for s in specilizationSelected" name="specialization" class="border-radius-4 input-bg medium-input" >
    									
									</select>
                                    <span style='color:red' class="help-inline" ng-show="submitted && updateCustomerForm.specialization.$error.required">Specialization is Required</span><br/>
                                   
                                   <input required maxlength="16" type="text" ng-pattern="/^[a-zA-Z ]*$/" ng-model="user.universitySchool" value={{user.universitySchool}} name="universitySchool" id="subject" placeholder="Institute" class="border-radius-4 medium-input">
                                    <span style='color:red' class="help-inline" ng-show="submitted && updateCustomerForm.universitySchool.$error.required">University/School is Required</span><br/>
                                     <span style='color:red' class="help-inline" ng-show="submitted && updateCustomerForm.universitySchool.$error.pattern">
  										  Please enter only characters
  									</span>
                                  
                                  <select  required  ng-model="user.nationalityMaster.nationalityId" ng-options="n.nationalityId as n.nationality for n in nationality" name="nationality" class="border-radius-4 input-bg medium-input" >
    									
									</select>
									
									<input required type="text" ng-model="user.stringDateOfBirth" value="{{user.stringDateOfBirth}}" name="dateOfBirth" id="dateOfBirth" placeholder="DOB" class="border-radius-4 input-bg medium-input" disabled>
									
                                     <input  type="file" file-model="user.image" ng-model="user.image" id="image" name="image" accept="image/x-png,image/gif,image/jpeg"  placeholder="Upload Image" class="border-radius-4 medium-input" form="updateCustomerForm" />
                                     <span id="fileSize" style='color:red'></span>                 
                                </div>
                            </div>
                        </div>               
                  <div class="col-md-8 center-col ">
		                <p class="pull-right padding-ten-all">
		                <button id="contact-us-button" type="submit" class="btn btn-small border-radius-4 btn-dark-gray" ng-click="submitted=true" >Submit</button>
		                </p>
		                </div>
                    </div>
                </form>
				
                    
                    
                </div>
            </div>
        </section>
      
          <script src="<c:url value='/resources/js/angular.js' />"></script>
       <script src="<c:url value='/resources/js/angular.min.js' />"></script>
       <script src="<c:url value='/resources/js/angular-animate.js' />"></script>
       <script src="<c:url value='/resources/js/angular-flexslider.js' />"></script>
        <script src="<c:url value='/resources/js/angular-route.js' />"></script>
         <script src="<c:url value='/resources/js/angular-ui-tree.js' />"></script>
       <script src="<c:url value='/resources/js/peerhuntr.js' />"></script>
       
     </div>
      <jsp:include page="footer.jsp"></jsp:include>