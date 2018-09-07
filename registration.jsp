<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!doctype html>
<html class="no-js" lang="en">
<head>
  <script type="text/javascript">
  function validate() {
	  //var string = "15455555a";
	  var string =document.registerCustomerForm.loginPassword.value;
	
		 var re = new RegExp("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");
		 if (re.test(string)) {
			 document.getElementById('message').innerHTML="";
		 } else {
		    
		     document.getElementById('message').innerHTML="Combination of small,capital,numeric and min 8 char.";
		     
		 }
  }
  </script>
  </head>


 
  <div ng-app="peerhuntr" ng-controller="PeerController"  ng-cloak ng-init="getRegisterData()">
  <jsp:include page="header.jsp"></jsp:include>
  <!-- start page title section -->
        <!-- start page title section -->
        <section class="wow fadeIn bg-extra-dark-gray padding-35px-tb page-title-small top-space">
            <div class="container">
                <div class="row equalize">
                    <div class="col-lg-8 col-md-6 col-sm-6 col-xs-12 display-table">
                        <div class="display-table-cell vertical-align-middle text-left xs-text-center">
                            <!-- start page title -->
                            <h1 class="alt-font text-white font-weight-600 no-margin-bottom text-uppercase">Register Profile</h1>
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
				 
<form  id="registerCustomerForm" enctype="multipart/form-data" name="registerCustomerForm" action="javascript:void(0)" method="post" ng-submit="registerUser()" ng-cloak >
                    <div class="row"> 
                      <div class="col-md-6 col-sm-12 col-xs-12 sm-margin-30px-bottom wow fadeInLeft">
                        <div class="padding-fifteen-all bg-white border-radius-6 md-padding-seven-all xs-padding-30px-all height-100" style="padding-bottom:8%">
                              
                                <div>
                                    <div id="success-contact-form-3" class="no-margin-lr"></div>
                                    <div id="success-contact-form" class="no-margin-lr"></div>
                                    
                                   <input required maxlength="20" type="text" ng-model="user.firstName"  ng-pattern="/^[a-zA-Z]*$/" name="firstName" id="subject" placeholder="First Name" class="border-radius-4 input-bg medium-input">
                                   <span style='color:red' class="help-inline" ng-show="submitted && registerCustomerForm.firstName.$error.required">First Name is Required</span><br/>
                                    <span style='color:red' class="help-inline" ng-show="submitted && registerCustomerForm.firstName.$error.pattern">
  										  Please enter only characters
  									</span>
                                   
                                   <input required type="text" ng-model="user.userLogin.loginId"  ng-pattern="/^[a-z]+[a-z0-9._]+@[a-z0-9]+\.[a-z.]{1,5}$/" name="loginId" id="subject" placeholder="Email" class="border-radius-4 input-bg medium-input" >
                                   <span style='color:red' class="help-inline" ng-show="submitted && registerCustomerForm.loginId.$error.required">Email is Required</span><br/>
                                    <span style='color:red' class="help-inline" ng-show="submitted && registerCustomerForm.loginId.$error.pattern">
  										  Not valid email!
  									</span>
  									
                                    <input required type="password" ng-model="user.userLogin.loginPassword"  name="loginPassword" id="password" onBlur="validate()" placeholder="Password" class="form-control"  >
                                    <span toggle="#password" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                    
                                     <!-- <input type="password" name="password" id="password" class="form-control" placeholder="Password" > -->
                                    
                                     
                                    <!--  <span toggle="#password" class="fa fa-fw fa-eye field-icon toggle-password"></span> -->
                                   <span style='color:red'  class="help-inline" ng-show="submitted && registerCustomerForm.loginPassword.$error.required">Password is Required</span><br/>
                                   <span id="message" style='color:red'></span>
                                   
                                  <select  required id="countryCode" ng-model="user.countryCode" ng-options="n.countryCode as n.countryCode for n in nationality" name="countryCode" class="border-radius-4 input-bg medium-input" style="width:17%; padding:8px 10px;" >
    									<option value="">ISD</option>
									</select>
									
									
									<input required ng-pattern="/^\d{1,20}$/" minlength="6" maxlength="20" type="text" ng-model="user.contactNo"  name="contactNo" id="subject" placeholder="Telephone number " class="border-radius-4 input-bg medium-input" style="width:82%;">
                                    
  									
  									<div class="pull-left"><span style='color:red' class="help-inline" ng-show="submitted && registerCustomerForm.countryCode.$error.required">Country Code is Required</span></div>
  									<div class="pull-right">
  									<span style='color:red' class="help-inline" ng-show="submitted && registerCustomerForm.contactNo.$error.required">Contact No is Required</span><br/>
                                  	 <span style='color:red' class="help-inline" ng-show="registerCustomerForm.contactNo.$error.pattern">
  										 Only numeric is allowed
  									</span> 
  									<span style='color:red' class="help-inline" ng-show="submitted && registerCustomerForm.contactNo.$error.minlength">
  										Minimum 6 numeric characters
  									</span>
  									</div>
                                   
                                  
                                    <select required ng-model="user.specializationMaster.degreeMaster.degreeId" ng-options="d.degreeId as d.degreeName for d in degree" ng-change="getSpec(user.specializationMaster.degreeMaster.degreeId)" class="border-radius-4 input-bg medium-input" name="degree" placeholder="Degree">
    									<option value="">-- Select Degree --</option>
									</select>
									<span style='color:red' class="help-inline" ng-show="submitted && registerCustomerForm.degree.$error.required">Degree is Required</span><br/>
									
									
									<select  required  ng-model="user.specializationMaster.specializationId" ng-options="s.specializationId as s.specializationName for s in specilizationSelected" name="specialization" class="border-radius-4 input-bg medium-input" placeholder="Specialization" style="padding: 8px 20px;">
    									<option value="">-- Select Specialization --</option>
									</select>
                                    <span style='color:red' class="help-inline" ng-show="submitted && registerCustomerForm.specialization.$error.required">Specialization is Required</span>
                                   
                                   <label style="margin-top:10px;"> <input required type="checkbox" ng-model="termsNcondition" name="termsNcondition" id="termsNcondition" style="width:auto;"> <a href='<spring:url value="/termsNcondition"/>'>Terms and Conditions</a></label><br/>
                                    <span style='color:red' class="help-inline" ng-show="submitted && registerCustomerForm.termsNcondition.$error.required">Please check Terms & Conditions</span>
                                 
                                      
                 
                                </div>
                            </div>
                        </div>
                        
                        
                         <div class="col-md-6 col-sm-12 col-xs-12 sm-margin-30px-bottom wow fadeInLeft">
                        <div class="padding-fifteen-all bg-white border-radius-6 md-padding-seven-all xs-padding-30px-all height-100">
                                
                                <div>
                                    <div id="success-contact-form-3" class="no-margin-lr"></div>
                                    <div id="success-contact-form" class="no-margin-lr"></div>
                                     <input maxlength="20" required type="text" ng-pattern="/^[a-zA-Z]*$/" ng-model="user.lastName"  name="lastName" id="subject" placeholder="Last Name" class="border-radius-4 input-bg medium-input" >
                                     <span style='color:red' class="help-inline" ng-show="submitted && registerCustomerForm.lastName.$error.required">Last Name is Required</span><br/>
                                     <span style='color:red' class="help-inline" ng-show="submitted && registerCustomerForm.lastName.$error.pattern">
  										  Please enter only characters
  									</span>
  									
                                       <input required  maxlength="16" type="text" ng-pattern="/^[a-zA-Z ]*$/" ng-model="user.universitySchool"  name="universitySchool" id="subject" placeholder="Institute" class="border-radius-4 input-bg medium-input">
                                    <span style='color:red' class="help-inline" ng-show="submitted && registerCustomerForm.universitySchool.$error.required">University/School is Required</span><br/>
         <!--                           <input name="limitedtextfield" type="text" onKeyDown="limitText(this.form.limitedtextfield,this.form.countdown,15);" 
onKeyUp="limitText(this.form.limitedtextfield,this.form.countdown,15);" maxlength="15"><br>
<font size="1">(Maximum characters: 15)<br>

                       You have <input readonly type="text" name="countdown" size="3" value="15"> characters left.</font> -->
                        <span style='color:red' class="help-inline" ng-show="submitted && registerCustomerForm.universitySchool.$error.pattern">
  						Please enter only characters
  						</span>
  									
                                     <input required type="password"   name="confirmPassword" id="confirmPassword" placeholder="Confirm Password" class="border-radius-4 input-bg medium-input" >
                                     <span toggle="#confirmPassword" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                   <span style='color:red' class="help-inline" ng-show="submitted && registerCustomerForm.confirmPassword.$error.required">Confirm Password is Required</span><br/>
                                     <span id="passwordMatch" style='color:red'></span>
                                   
                                   
                                    <select  required ng-model="user.nationalityMaster.nationalityId"  ng-options="n.nationalityId as n.nationality for n in nationality" ng-change="getCountryCode(user.nationalityMaster.nationalityId)" class="border-radius-4 input-bg medium-input" name="nationality" placeholder="Nationality" >
    									<option value="">-- Select Nationality --</option>
									</select>
									<span style='color:red' class="help-inline" ng-show="submitted && registerCustomerForm.nationality.$error.required">Nationality is Required</span><br/>
									
									<input required type="text" datepicker ng-model="user.dateOfBirth"  name="dateOfBirth" id="dateOfBirth" placeholder="DOB" class="border-radius-4 input-bg medium-input" >
									<span style='color:red' class="help-inline" ng-show="submitted && registerCustomerForm.dateOfBirth.$error.required">DOB is Required</span><br/>
									
                                     <input   type="file" file-model="user.image" ng-model="user.image" id="image" name="image" accept="image/x-png,image/gif,image/jpeg"  placeholder="Upload Image" class="border-radius-4 input-bg medium-input" form="registerCustomerForm"  />
                                      <span id="imageRequired" style='color:red'></span>
                                   <span id="fileSize" style='color:red'></span>
                                     
                                  <!-- <button type="submit"  ng-click="uploadImage()">Upload Image</button><br/> -->
                                     <!-- <input type="file" ng-model="user.image" ng2FileSelect [uploader]="upload" multiple formControlName="file" id="file" accept="image/x-png,image/gif,image/jpeg"/> -->
                                    <div id="loading" > </div>  
                                    
                                   
                                </div>
                            </div>
                        </div>
                
                    </div>
                     </div>
		                <div class="row equalize sm-equalize-auto">
		                <div class="col-md-6">
		               
		                </div>
		                <div class="col-md-6">
		                <br>
		                <button id="contact-us-button" type="submit" class="btn btn-small border-radius-4 btn-dark-gray pull-right" ng-click="submitted=true" >Submit</button>
		                </div>
		                </div>
                </form>
                
				
                    
                    
               
                
            </div>
        </section>
       
  
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script> 
          <script src="<c:url value='/resources/js/angular.js' />"></script>
       <script src="<c:url value='/resources/js/angular.min.js' />"></script>
       <script src="<c:url value='/resources/js/angular-animate.js' />"></script>
       <script src="<c:url value='/resources/js/angular-flexslider.js' />"></script>
        <script src="<c:url value='/resources/js/angular-route.js' />"></script>
         <script src="<c:url value='/resources/js/angular-ui-tree.js' />"></script>
       <script src="<c:url value='/resources/js/peerhuntr.js' />"></script>
       

      <jsp:include page="footer.jsp"></jsp:include>
           </div>