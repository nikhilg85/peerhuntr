<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


 
 
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
                            <h1 class="alt-font text-white font-weight-600 no-margin-bottom text-uppercase">Registration Form</h1>
                            <!-- end page title -->
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12 display-table text-right xs-text-left xs-margin-10px-top">
                        <div class="display-table-cell vertical-align-middle  text-small alt-font">
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
         <form:form enctype="multipart/form-data" id="contact-form" action='${pageContext.request.contextPath}/registerAction' method="post" modelAttribute="userDTO"   >
           						<c:if test="${registrationsuccess!=null}">
										<div class="alert alert-danger">
											<p>${registrationsuccess}</p>
										</div>
									</c:if>

            <div class="container">
                <div class="row equalize sm-equalize-auto">
                    <div class="col-md-6 col-sm-12 col-xs-12 sm-margin-30px-bottom wow fadeInLeft">
                        <div class="padding-fifteen-all bg-white border-radius-6 md-padding-seven-all xs-padding-30px-all height-100">
                                <div>
                                    <div id="success-contact-form" class="no-margin-lr"></div>
                                   <form:input type="text" path="firstName" class="border-radius-4 input-bg medium-input" placeholder="First Name" value=""></form:input>
                				<form:errors path="firstName" cssClass="error"></form:errors>
                                 <form:input type="text" path="userLogin.loginId" name="userLogin.loginId" id="loginId" placeholder="E-mail" class="border-radius-4 input-bg medium-input" value=""></form:input>
                                   <form:errors path="userLogin.loginId" cssClass="error"></form:errors>
                                    <form:input type="password" path="userLogin.loginPassword" name="userLogin.loginPassword" id="loginPassword" placeholder="Password" class="border-radius-4 input-bg medium-input" value=""></form:input>
                                  <form:errors path="userLogin.loginPassword" cssClass="error"></form:errors>
                                  <form:input type="number" path="contactNo" name="contactNo" id="contactNo" placeholder="Contact No" class="border-radius-4 input-bg medium-input" value=""></form:input>
                                    <form:errors path="contactNo" cssClass="error"></form:errors>
                                    <form:select path="specializationMaster.degreeMaster.degreeId" items="${degreelist}" itemValue="degreeId" itemLabel="degreeName"  class="border-radius-4 input-bg medium-input" style="margin-bottom: 15px;" onchange="/getSpecialization">
								   </form:select>
								     <form:errors path="specializationMaster.degreeMaster.degreeId" cssClass="error"></form:errors>
								    <form:select path="specializationMaster.specializationId" itemValue="specializationId" itemLabel="specializationName" items="${specializationlist}"  class="border-radius-4 input-bg medium-input" style="margin-bottom: 15px;">
								  		<option>select</option>
								   </form:select>
                                    <form:errors path="specializationMaster.specializationId" cssClass="error"></form:errors>
                                    
                                    <div class="checkbox pull-left">
                                      <form:checkbox path="termsNcondition" value="termsNcondition" style="margin-left:-75px;"/>
                                      <label><a href="/termsNconditions">Terms and Conditions</a></label>
                                      
                                       
                                      </div> 
                                     <form:errors path="termsNcondition" cssClass="error"></form:errors>
								   								   
                                </div>
                            
                        </div>
                    </div>
                    <div class="col-md-6 col-sm-12 col-xs-12 sm-margin-30px-bottom wow fadeInLeft">
                        <div class="padding-fifteen-all bg-white border-radius-6 md-padding-seven-all xs-padding-30px-all height-100">
                            
                          
                                <div>
                                    <div id="success-contact-form" class="no-margin-lr"></div>
                                    <form:input type="text" path="lastName" class="border-radius-4 input-bg medium-input" placeholder="Last Name" value=""></form:input>
                                   <form:errors path="lastName" cssClass="error"></form:errors>                                  
                                   <form:input type="text" path="universitySchool" class="border-radius-4 input-bg medium-input" placeholder="University" value=""></form:input>
                                   <form:errors path="universitySchool" cssClass="error"></form:errors>
                                  <form:input type="password" path="confirmPassword" class="border-radius-4 input-bg medium-input" placeholder="Confirm Password" value=""></form:input>
                                   <form:errors path="confirmPassword" cssClass="error"></form:errors>
                                 	<form:select path="nationalityMaster.nationalityId" items="${nationalitylist}" itemValue="nationalityId" itemLabel="nationality" class="border-radius-4 input-bg medium-input" style="margin-bottom: 15px;">
								   </form:select>
                                    <form:errors path="nationalityMaster.nationalityId" cssClass="error"></form:errors>    
                                    <form:input type="text" name="dateOfBirth" path="dateOfBirth" class="border-radius-4 input-bg medium-input" placeholder="Date of Birth" value=""></form:input>
                                   <form:errors path="dateOfBirth" cssClass="error"></form:errors>    
                                 <form:input type="file" path="image" name="image" accept="image/x-png,image/gif,image/jpeg"  class="border-radius-4 input-bg medium-input" style="margin-bottom: 15px;"></form:input>
                                    <form:button id="contact-us-button" type="submit" class="btn btn-small border-radius-4 btn-dark-gray">Submit</form:button>
                                 <form:errors path="image" cssClass="error"></form:errors>    
                                
                                </div>
                           
                        </div>
                    </div>
                </div>
            </div>
             </form:form>
        </section>
          <script src="<c:url value='/resources/js/angular.js' />"></script>
       <script src="<c:url value='/resources/js/angular.min.js' />"></script>
       <script src="<c:url value='/resources/js/angular-animate.js' />"></script>
        <script src="<c:url value='/resources/js/angular-flexslider.js' />"></script> 
        <script src="<c:url value='/resources/js/angular-route.js' />"></script>
         <script src="<c:url value='/resources/js/angular-ui-tree.js' />"></script>
        <script src="<c:url value='/resources/js/peerhuntr.js' />"></script>    
        <jsp:include page="footer.jsp"></jsp:include>
      
       
    