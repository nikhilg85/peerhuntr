 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
 <jsp:include page="header.jsp" ></jsp:include>
  <div ng-controller="PersonalityController" ng-init="getTest()" ng-cloak>
 <!-- start page title section -->
        <section class="wow fadeIn bg-extra-dark-gray padding-35px-tb page-title-small ">
            <div class="container">
                <div class="row equalize">
                    <div class="col-lg-8 col-md-6 col-sm-6 col-xs-12 display-table">
                        <div class="display-table-cell vertical-align-middle text-left xs-text-center">
                            <!-- start page title -->
                            <h1 class="alt-font text-white font-weight-600 no-margin-bottom text-uppercase">Personality Test</h1>
                            <!-- end page title -->
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12 display-table text-right xs-text-left xs-margin-10px-top">
                        <div class="display-table-cell vertical-align-middle breadcrumb text-small alt-font">
                            <!-- start breadcrumb -->
                            <ul class="xs-text-center">
                                <li><a href='<spring:url value="/home"/>' class="text-dark-gray">Home</a></li>
                                <li class="text-dark-gray">Personality Test</li>
                            </ul>
                            <!-- end breadcrumb -->
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- end page title section -->
         <div class="form-group">

         
      
        <div ng-init="testAgain()">
       
        <label style="display:none;"id="userIdlabel">{{userIdd}}</label>
        </div>

									 <input type="hidden" class="form-control" id="sectionID" >
									</div>
									<div class="form-group">
									  <input type="hidden" class="form-control" id="questionID">
									</div>
									<div class="form-group">
									  <input type="hidden" class="form-control" id="ansAIndicatorID">
									</div>
									<div class="form-group">
									<input type="hidden" class="form-control" id="ansAID">
									</div>
									<div class="form-group">
									  <input type="hidden" class="form-control" id="ansBIndicatorID">
									</div>
									<div class="form-group">
									<input type="hidden" class="form-control" id="ansBID">
									</div>
        <!-- start contact form section -->
         <form id="contact-form" action="javascript:void(0)" method="post">
        <section class="parallax wow fadeIn" data-stellar-background-ratio="0.4" style="background-image: url(&quot;resources/images/parallax-bg21.jpg&quot;); visibility: visible; animation-name: fadeIn; padding: 60px 0;">
            <div class="container">
                <div class="row equalize sm-equalize-auto">
                <div class="col-md-12 col-sm-12 col-xs-12 ">
                <span class="text-large font-weight-600 alt-font text-extra-dark-gray margin-5px-bottom display-block" id="question"></span>
                </div>
                    
                    <div class="col-md-12 col-sm-12 col-xs-12 last-paragraph-no-margin wow fadeInRight">
                        <div id="optionA" class="bg-white border-radius-6 sm-text-center" ng-click="questionNumber!=totalNoFromDB1&&nextQuestion('optionA')" style="padding:10px;">
                         	<!-- <input id="radioA" type="radio" name="optradio" ng-model="modelRadio" ng-click="questionNumber==lastQuestionNumber&&questionNumber!=totalNoFromDB1&&nextQuestion()" ng-required="true" style="width:auto;"> -->
      									<label id="AnswerA"></label>
						
                        </div>
                    </div>
                    
                    <div class="col-md-12 col-sm-12 col-xs-12 last-paragraph-no-margin wow fadeInRight" style="margin-top:2%">
                        <div id="optionB" class="bg-white border-radius-6 sm-text-center" ng-click="questionNumber!=totalNoFromDB1&&nextQuestion('optionB')" style="padding:10px;">
                           
								      <label id="AnswerB"></label> <br/>
						
                        </div>
                        
                        <input type="hidden" id="valueSelected"><br/>
                        
                        <button  id="submit"   style="display:none;" type="submit" class="btn btn-small border-radius-4 btn-dark-gray" ng-click="submitTest()">Submit</button>
                    </div>
                    
                </div>
            </div>
        </section>
        <section class="wow fadeIn" style="padding: 60px 0;">
            <div class="container">
                <div class="row equalize sm-equalize-auto">
                    
                    <div class="col-md-12 col-sm-12 col-xs-12 last-paragraph-no-margin wow fadeInRight">
                        
                            
                           
                                <div class="pull-left">
                                    <button id="back" style="display:none;" type="submit" 
                                    	class="btn btn-small border-radius-4 btn-dark-gray" ng-click="backQuestion()">Back</button> </div>      
                                    <div class="pull-right">
                                    <button id="contact-us-button" ng-show="questionNumber!=lastQuestionNumber" ng-click="nextButtonQuestion()" type="submit" class="btn btn-small border-radius-4 btn-dark-gray">Next</button>                                </div>
                          
                         
                    </div>
                </div>
           
        </section>
          </form>
             </div>
        <!-- end contact form section -->
          <script src="<c:url value='/resources/js/angular.js' />"></script>
       <script src="<c:url value='/resources/js/angular.min.js' />"></script>
       <script src="<c:url value='/resources/js/angular-animate.js' />"></script>
        <script src="<c:url value='/resources/js/angular-flexslider.js' />"></script> 
        <script src="<c:url value='/resources/js/angular-route.js' />"></script>
         <script src="<c:url value='/resources/js/angular-ui-tree.js' />"></script>
        <script src="<c:url value='/resources/js/peerhuntr.js' />"></script>    
        <jsp:include page="footer.jsp"></jsp:include>
   