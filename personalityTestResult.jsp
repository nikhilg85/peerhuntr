 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
 <jsp:include page="header.jsp" ></jsp:include>
  <div  ng-controller="PersonalityController"  ng-init="getPersonality()" ng-cloak>
   <!-- start page title section -->
        <section class="wow fadeIn bg-extra-dark-gray padding-35px-tb page-title-small ">
            <div class="container">
                <div class="row equalize">
                    <div class="col-lg-8 col-md-6 col-sm-6 col-xs-12 display-table">
                        <div class="display-table-cell vertical-align-middle text-left xs-text-center">
                            <!-- start page title -->
                            <h1 class="alt-font text-white font-weight-600 no-margin-bottom text-uppercase">Personality Test Result</h1>
                            <!-- end page title -->
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12 display-table text-right xs-text-left xs-margin-10px-top">
                        <div class="display-table-cell vertical-align-middle breadcrumb text-small alt-font">
                            <!-- start breadcrumb -->
                            <ul class="xs-text-center">
                                <li><a href='<spring:url value="/home"/>' class="text-dark-gray">Home</a></li>
                                <li class="text-dark-gray">Personality Test Result</li>
                            </ul>
                            <!-- end breadcrumb -->
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- end page title section -->
        
        
        
        <section class="wow fadeIn" style="visibility: visible; animation-name: fadeIn;">
            <div class="container">
                
                <div class="row equalize xs-equalize-auto">
                    <!-- start features box item -->
                    <div class="col-md-10 col-sm-10 col-xs-10 center-col wow fadeInUp last-paragraph-no-margin" style="visibility: visible; animation-name: fadeInUp;">
                        <div class="border-color-extra-medium-gray padding-30px-all border-solid border-width-1 text-center border-radius-4 position-relative inner-match-height" style="background:{{colorCode}}; -webkit-box-shadow: 5px 7px 9px -4px rgb(158, 158, 158); -moz-box-shadow: 5px 7px 9px -4px rgb(158, 158, 158);
    box-shadow: 5px 7px 9px -4px rgb(158, 158, 158);">
                            <div class="display-inline-block margin-20px-bottom"><img src="<c:url value='/resources/images/result.png'/>" style="width:50%"></div>
                            <h4 style="color:#FFF;">Well Done!</h4>
                            <h5 class="center-col" style="color:#000">You have completed the test.</h5>
                            <h6 style="color:#fff">Your Profile is</h6>
                            <h4 style="color:#FFF;">{{role}} ({{type}})</h4>
                            <p style="color:#FFF; padding:10px; text-align:justify; ">{{remarks}}</div>
                    </div>
                    <!-- end features box item -->
                    
                </div>
            </div>
            
        </section>
        
        <section class="wow fadeIn" style="padding-top:0;">
            <div class="container">
                <div class="row equalize sm-equalize-auto center-col" style="text-align:center;">
                    
                    <div class="col-md-12 center-col">
                        
                            <sec:authorize access="hasRole('ROLE_ANONYMOUS')"> 
                            
                                
                                    <a  href='<spring:url value="/login?profile=true"/>' class="btn btn-very-small btn-transparent-black md-margin-15px-bottom sm-display-table sm-margin-lr-auto">Generate Profile Card</a>                              
                                    
                                    
                           
        					</sec:authorize>
        					
        					 <sec:authorize access="hasRole('ROLE_USER')"> 
                            
                                    <a  href='<spring:url value="/dashboard/myProfile"/>' class="btn btn-very-small btn-transparent-black md-margin-15px-bottom sm-display-table sm-margin-lr-auto">Generate Profile Card</a>                         
        					</sec:authorize>
                    </div>
                    <div class="col-md-12 center-col" style="margin-top:2%;">
                    <sec:authorize access="hasRole('ROLE_ANONYMOUS')"> 
                                    
                                    <a  href="personalitytest" class="btn btn-very-small btn-transparent-black md-margin-15px-bottom sm-display-table sm-margin-lr-auto">Take Test Again</a>                                
                           
        					</sec:authorize>
        					
        					 <sec:authorize access="hasRole('ROLE_USER')"> 
                            
                                    <a  href="personalitytest" class="btn btn-very-small btn-transparent-black md-margin-15px-bottom sm-display-table sm-margin-lr-auto">Take Test Again</a>                                
                           
        					</sec:authorize>
                    </div>
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
     
