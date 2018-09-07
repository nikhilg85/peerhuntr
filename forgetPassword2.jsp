<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html class="no-js" lang="en">
 
    <body  ng-app="myApp" >  
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
                            <h1 class="alt-font text-white font-weight-600 no-margin-bottom text-uppercase">Forget Password</h1>
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
         <form:form id="contact-form" action='${pageContext.request.contextPath}/sendMail/forgetPasswordAction' method="post" modelAttribute="userLoginDTO" >
            <div class="container">
                <div class="row equalize sm-equalize-auto">
                    <div class="col-md-6 wow fadeIn center-col">
                        <div class="padding-fifteen-all bg-white border-radius-6 md-padding-seven-all xs-padding-30px-all height-100">
                            
                       
                                <div>
                                    <div id="success-contact-form" class="no-margin-lr"></div>
                                   
                                 <form:input type="text" path="loginId" name="loginId" id="loginId" placeholder="E-mail" class="border-radius-4 input-bg medium-input" value="a@a.com"></form:input>
                                   <form:errors path="loginId" cssClass="error"></form:errors>
                                   
                                    <button id="contact-us-button" type="submit" class="btn btn-small border-radius-4 btn-dark-gray">Submit</button>
                                                              
                            
                        </div>
                    </div>
                  
                </div>
            </div>
            </div>
             </form:form>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>
      
       
    </body>

</html>