<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html >

<html class="no-js" lang="en">
            <div ng-app="peerhuntr" ng-controller="PeerController" ng-init="getMyProfile()" ng-cloak>
       <jsp:include page="header.jsp"></jsp:include>
        <!-- start page title section --> 
        <section class="wow fadeIn bg-extra-dark-gray padding-35px-tb page-title-small ">
            <div class="container">
                <div class="row equalize">
                    <div class="col-lg-8 col-md-6 col-sm-6 col-xs-12 display-table">
                        <div class="display-table-cell vertical-align-middle text-left xs-text-center">
                            <!-- start page title -->
                            <h1 class="alt-font text-white font-weight-600 no-margin-bottom text-uppercase">My Profile</h1>
                            <!-- end page title -->
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12 display-table text-right xs-text-left xs-margin-10px-top">
                        <div class="display-table-cell vertical-align-middle breadcrumb text-small alt-font">
                            <!-- start breadcrumb -->
                            <ul class="xs-text-center">
                                <li><a href='<spring:url value="/home"/>' class="text-dark-gray">Home</a></li>
                                <li class="text-dark-gray">My Profile</li>
                            </ul>
                            <!-- end breadcrumb -->
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- end page title section -->
      <!--    
      <div ng-repeat="userRating in user.userRatings">
      	<div ng-if="userRating.ratingType.ratingName=='Comments'">{{userRating.remarks}}</div>
      </div> -->
        <!-- start info banner style 01 section -->
        <section class="wow fadeIn parallax" data-stellar-background-ratio="0.5" style="background-image: url('resources/images/parallax-bg18.jpg')">
            <div class="container">
               
                <div class="row equalize xs-equalize-auto">                   
                    <!-- start features box item -->
                    <div class="col-md-6 col-sm-6 card col-xs-12 sm-margin-four-bottom xs-margin-30px-bottom wow fadeInUp " style="border:1px solid #ddd; -webkit-box-shadow: 5px 7px 9px -4px rgb(158, 158, 158);
    -moz-box-shadow: 5px 7px 9px -4px rgb(158, 158, 158);
    box-shadow: 5px 7px 9px -4px rgb(158, 158, 158); background-color:{{user.personalityMaster.personalityColourCode}};">
                        <div class="bg-white card" >
                        <div class="col-md-12">
                        <div class="col-md-6 pull-left padding-10px-all">
                        <div ng-repeat="profileImage in user.profileImages|limitTo:1">
                        	<img class="img-responsive" src={{profileImage.imageUrl}} alt="card image" data-no-retina=""/>
                       </div>
                       <%--  <img class=" img-fluid" src="<c:url value='/resources/images/image-icon2.png' />" alt="card image" data-no-retina=""> --%>
                        
                        </div>
                       
                        <div class="col-md-6 pull-right">
                        <div class="card-body mt-4 padding-10px-all">
                        
                                    <h4 style="color:#fff;">{{user.firstName |uppercase }} {{user.lastName |uppercase}}</h4>
                                    <p style="margin:0 0 10px; color:#fff;"> <img style="margin-right:5px;" src="<c:url value='/resources/images/nationality.png'/>" data-no-retina=""> {{user.nationalityMaster.nationality}}</p>
                            		<p style="margin:0 0 10px; color:#fff;"> <img style="margin-right:5px;" src="<c:url value='/resources/images/age.png'/>" data-no-retina="">{{user.age}} Years</p>
									<p style="margin:0 0 10px; color:#fff;"> <img style="margin-right:5px;" src="<c:url value='/resources/images/education.png'/>" data-no-retina=""> {{user.specializationMaster.degreeMaster.degreeName}}, {{ user.specializationMaster.specializationName}}, {{user.universitySchool}}</p>
									<p style="margin:0 0 10px; color:#fff;"> <img style="margin-right:5px;" src="<c:url value='/resources/images/personality.png'/>" data-no-retina=""> {{user.personalityMaster.personalityRole}}</p>
									<p style="margin:0 0 10px; color:#fff;"> <img style="margin-right:5px;" src="<c:url value='/resources/images/rating.png'/>" data-no-retina=""> {{user.score}}/{{user.review}} Reviews</p>
                                    
                                </div>
                        </div>
                        </div>
                            <div class="col-md-12 padding-20px-bottom" >
                           
                                
                            <hr>
                            <h6 style="margin:0; color:#fff;" class="pull-left">Rating </h6>
                            <br>
                            <!-- start progress bar item -->
                             <div class="row">
                              <div class="col-md-12">
                                  <div class="flex-container" ng-init="ratingIndex = $index" ng-repeat="userAvgRating in user.userAvgRatings  track by $index ">
                                  	<span> {{userAvgRating.ratingType.ratingName}}</span>
                                  
                                <div  ng-init="ratingValIndex =$index" id={{ratingIndex}}{{ratingValIndex}} 
                                	ng-style="$index<=(userAvgRating.avgRatingValue|number:0)-1 && setColor(ratingValIndex,ratingIndex)" ng-repeat="n in [].constructor(userAvgRating.ratingType.ratingValue) track by $index">
    								{{ $index+1 }}
    								 <!-- <div ng-if=$index==(userAvgRating.avgRatingValue|number:0)-1>{{userAvgRating.avgRatingValue}} </div>  -->
								</div>
                                
                                
                                </div>
                              </div>
                              </div> 
                              
                           
                             <!-- end progress bar item -->
                         
                            <!-- end progress bar -->
                            
                           
                            <br>
                        	</div>
                        </div>
                    </div>
                    <!-- end features box item -->
                    
                    <!-- start features box item -->
                    <div class="col-md-6 col-sm-6 col-xs-12 sm-margin-four-bottom xs-no-margin-bottom wow fadeInUp" data-wow-delay="0.4s" >
                    
                    
                    
                        <div class="bg-white" style="border:1px solid #ddd; border:1px solid #ddd; -webkit-box-shadow: 5px 7px 9px -4px rgb(158, 158, 158);-moz-box-shadow: 5px 7px 9px -4px rgb(158, 158, 158);box-shadow: 5px 7px 9px -4px rgb(158, 158, 158); background-color:{{user.personalityMaster.personalityColourCode}};">
                        <h5 class="alt-font margin-35px-bottom xs-margin-15px-bottom padding-35px-top text-center" style="color:#fff;">Comments </h5>
                <div class="position-relative">
                
                    <div class="swiper-slider-second swiper-pagination-bottom swiper-container black-move testimonial-style2 padding-70px-bottom sm-padding-50px-bottom xs-sm-padding-30px-bottom wow fadeIn swiper-container-horizontal" style="visibility: visible; animation-name: fadeIn;">
                        <div class="swiper-wrapper" style="transform: translate3d(0px, 0px, 0px); transition-duration: 0ms;">
                        
                            <!-- start testimonial slider item -->
                            <div class="swiper-slide swiper-slide-active" style="width: 360px;">
                                <div class="col-md-12 center-col">
                                    <div class="testimonia-block width-90 xs-width-100 center-col"> 
                                        <div class="bg-white text-center padding-100px-all border-radius-6 xs-padding-20px-all">
                                            <p>Trust us we looked for a very long time and wasted thousands of dollars testing other teams, freelancers, and outsource companies. I wanted to hire the best and after looking at several other companies, I knew Jacob was the perfect guy for the job. He is a true professional.</p>
                                        </div>
                                        <div class="profile-box">
                                            <img src="images/avtar-07.jpg" alt="" class="width-20 xs-center-col border-radius-100 border-color-white border-width-4 border-solid margin-15px-bottom" data-no-retina="">
                                            <div class="width-100 last-paragraph-no-margin">
                                                <p class="alt-font text-small font-weight-600 text-black text-uppercase margin-5px-bottom">Alexander Harvard</p>
                                                <p class="text-uppercase text-extra-small text-medium-gray">Graphic Designer, Google inc</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div> 
                            <!-- end testimonial slider item -->
                            <!-- start testimonial slider item -->
                            <div class="swiper-slide swiper-slide-next" style="width: 360px;">
                                <div class="col-md-12 center-col">
                                    <div class="testimonia-block width-90 xs-width-100 center-col"> 
                                        <div class="bg-white text-center padding-60px-all border-radius-6 xs-padding-20px-all">
                                            <p>Trust us we looked for a VERY long time and wasted thousands of dollars testing other teams, freelancers, and outsource companies. I wanted to hire the best and after looking at several other companies, I knew Jacob was the perfect guy for the job. He is a true professional.</p>
                                        </div>
                                        <div class="profile-box">
                                            <img src="images/avtar-08.jpg" alt="" class="width-20 xs-center-col border-radius-100 border-color-white border-width-4 border-solid margin-15px-bottom" data-no-retina="">
                                            <div class="width-100 last-paragraph-no-margin">
                                                <p class="alt-font text-small font-weight-600 text-black text-uppercase margin-5px-bottom">Alexander Harvard</p>
                                                <p class="text-uppercase text-extra-small text-medium-gray">Graphic Designer, Google inc</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- end testimonial slider item -->
                            <!-- start testimonial slider item -->
                            <div class="swiper-slide" style="width: 360px;">
                                <div class="col-md-12 center-col">
                                    <div class="testimonia-block width-90 xs-width-100 center-col"> 
                                        <div class="bg-white text-center padding-60px-all border-radius-6 xs-padding-20px-all">
                                            <p>Trust us we looked for a very long time and wasted thousands of dollars testing other teams, freelancers, and outsource companies. I wanted to hire the best and after looking at several other companies, I knew Jacob was the perfect guy for the job. He is a true professional.</p>
                                        </div>
                                        <div class="profile-box last-paragraph-no-margin">
                                            <img src="images/avtar-09.jpg" alt="" class="width-20 xs-center-col border-radius-100 border-color-white border-width-4 border-solid margin-15px-bottom" data-no-retina="">
                                            <div class="width-100">
                                                <p class="alt-font text-small font-weight-600 text-black text-uppercase margin-5px-bottom">Alexander Harvard</p>
                                                <p class="text-uppercase text-extra-small text-medium-gray">Graphic Designer, Google inc</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- end testimonial slider item -->
                        </div>
                        <!-- start slider pagination -->                   
                        <div class="swiper-pagination swiper-pagination-second swiper-pagination-clickable swiper-pagination-bullets"><span class="swiper-pagination-bullet swiper-pagination-bullet-active"></span><span class="swiper-pagination-bullet"></span><span class="swiper-pagination-bullet"></span></div>
                        <div class="swiper-button-next slider-long-arrow-white display-none"></div>
                        <div class="swiper-button-prev slider-long-arrow-white display-none swiper-button-disabled"></div>
                        <!-- end slider pagination -->
                    </div>
                </div>
            </div> 
        
                        </div>
                    </div>
                    <!-- end features box item -->
                </div>
        </section>
        <!-- end info banner style 01 section -->
        
        <!-- start form style 03 section -->
        <section class="wow fadeIn" style="visibility: visible; animation-name: fadeIn;">
            <div class="container">
                <div class="row">
                    <div class="col-md-7 col-sm-12 col-xs-12 center-col text-center margin-100px-bottom xs-margin-40px-bottom">
                        <div class="position-relative overflow-hidden width-100">
                            <span class="text-small text-outside-line-full alt-font font-weight-600 text-uppercase">Share for Peer Rating</span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 col-sm-10 col-xs-10 center-col text-center elements-social social-icon-style-3 padding-50px-all">
                        <ul class="medium-icon">
                            <li><a class="facebook" ng-click="ratingLink('fa',user.referralCode,user.ratingLink,user.firstName,user.lastName)"><i class="fa fa-facebook"></i></a></li>
                            <li><a class="twitter" ng-click="ratingLink('tw',user.referralCode,user.ratingLink,user.firstName,user.lastName)"><i class="fa fa-twitter"></i></a></li>
                           	<li><a class="google" ng-click="ratingLink('em',user.referralCode,user.ratingLink,user.firstName,user.lastName)"><i class="fa fa-envelope-open"></i></a></li>
                            <li><a class="linkedin" ng-click="ratingLink('li',user.referralCode,user.ratingLink,user.firstName,user.lastName)"><i class="fa fa-linkedin"></i></a></li>
                            <li><a class="whatsapp" ng-click="ratingLink('wa',user.referralCode,user.ratingLink,user.firstName,user.lastName)"><i class="fa fa-whatsapp"></i></a></li>
                            
  
                        </ul>
                    </div>
                </div>
            </div>
        </section>
        <!-- end form style 02 section -->
        </div>
         
       </div>
         <script src="<c:url value='/resources/js/angular.js' />"></script>
       <script src="<c:url value='/resources/js/angular.min.js' />"></script>
       <script src="<c:url value='/resources/js/angular-animate.js' />"></script>
        <script src="<c:url value='/resources/js/angular-flexslider.js' />"></script> 
        <script src="<c:url value='/resources/js/angular-route.js' />"></script>
         <script src="<c:url value='/resources/js/angular-ui-tree.js' />"></script>
        <script src="<c:url value='/resources/js/peerhuntr.js' />"></script>   
                    </div> 
  <jsp:include page="footer.jsp" ></jsp:include>