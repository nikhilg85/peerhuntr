<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html >

<html class="no-js" lang="en">

  <div ng-app="peerhuntrpersonality" ng-controller="PeerController" ng-init="viewDetailProfile()" ng-cloak>
       <jsp:include page="header.jsp"></jsp:include>
        <!-- start page title section -->
        <section class="wow fadeIn bg-extra-dark-gray padding-35px-tb page-title-small ">
            <div class="container">
                <div class="row equalize">
                    <div class="col-lg-8 col-md-6 col-sm-6 col-xs-12 display-table">
                        <div class="display-table-cell vertical-align-middle text-left xs-text-center">
                            <!-- start page title -->
                            <h1 class="alt-font text-white font-weight-600 no-margin-bottom text-uppercase">Profile Details</h1>
                            <!-- end page title -->
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12 display-table text-right xs-text-left xs-margin-10px-top">
                        <div class="display-table-cell vertical-align-middle breadcrumb text-small alt-font">
                            <!-- start breadcrumb -->
                            <ul class="xs-text-center">
                                <li><a href="#" class="text-dark-gray">Home</a></li>
                                <li><a href="#" class="text-dark-gray">Gallery</a></li>
                                <li class="text-dark-gray">Profie Card Details</li>
                            </ul>
                            <!-- end breadcrumb -->
                        </div>
                    </div>
                </div>
              </div>
        </section>
        <!-- end page title section -->
        <!-- start info banner style 01 section -->
        <section class="wow fadeIn parallax" data-stellar-background-ratio="0.5" style="background-image: url('resources/images/parallax-bg18.jpg')">
            <div class="container">
                
                <div class="row equalize xs-equalize-auto" >                   
                    <!-- start features box item -->
                    <div class="col-md-6 col-sm-6 card col-xs-12 sm-margin-four-bottom xs-margin-30px-bottom wow fadeInUp " style="border:1px solid #ddd; -webkit-box-shadow: 5px 7px 9px -4px rgb(158, 158, 158);
    -moz-box-shadow: 5px 7px 9px -4px rgb(158, 158, 158);
    box-shadow: 5px 7px 9px -4px rgb(158, 158, 158); background-color:{{profilDetail.personalityMaster.personalityColourCode}};">
                        <div class="bg-white card" >
                        <div class="col-md-12">
                        <div class="col-md-6 pull-left padding-10px-all">
                        <div ng-repeat="profileImage in profilDetail.profileImages|limitTo:1">
                        	<img class="img-responsive" src={{profileImage.hiddenImageUrl}} alt="card image" data-no-retina=""/>
                       </div>
                       <%--  <img class=" img-fluid" src="<c:url value='/resources/images/image-icon2.png' />" alt="card image" data-no-retina=""> --%>
                        
                        </div>
                        <div class="col-md-6 pull-right">
                        <div class="card-body mt-4 padding-10px-all">
                                    <h4 style="color:#fff;">{{profilDetail.firstName|uppercase| limitTo : 1 : 0}}. {{profilDetail.lastName |uppercase| limitTo : 1 : 0}}.</h4>
                                    <p style="margin:0 0 10px; color:#fff;"> <img style="margin-right:5px;" src="<c:url value='/resources/images/nationality.png' />" data-no-retina="" /> {{profilDetail.nationalityMaster.nationality}}</p>
                            		<p style="margin:0 0 10px; color:#fff;"> <img style="margin-right:5px;" src="<c:url value='/resources/images/age.png' />" data-no-retina=""/>{{profilDetail.age}}</p>
									<p style="margin:0 0 10px; color:#fff;"> <img style="margin-right:5px;" src="<c:url value='/resources/images/education.png'/>" data-no-retina=""/>{{profilDetail.specializationMaster.degreeMaster.degreeName}},{{ user.specializationMaster.specializationName}},{{user.universitySchool}}</p>
									<p style="margin:0 0 10px; color:#fff;"> <img style="margin-right:5px;"  src="<c:url value='/resources/images/personality.png'/>" data-no-retina=""/>{{profilDetail.personalityMaster.personalityRole}}({{profilDetail.personalityMaster.personalityType}}) </p>
									<p style="margin:0 0 10px; color:#fff;"> <img style="margin-right:5px;" src="<c:url value='/resources/images/rating.png'/>" data-no-retina=""/> {{profilDetail.score}}/8</p>
                                    
                                </div>
                        </div>
                        </div>
                            <div class="col-md-12 padding-20px-bottom" >
                           
                                
                            <hr>
                            <h6 style="margin:0; color:#fff;" class="pull-left">Rating </h6>
                            <br><br>
                            <!-- start progress bar item -->
                            
                                <!-- start progress bar item -->
                                <div class="row">
                              <div class="col-md-12">
                                  <div class="flex-container">
                                  	<span>Energetic </span>
                                    <div>1</div>
                                    <div>2</div>
                                    <div>3</div>  
                                    <div>4</div>
                                    <div>5</div>
                                    <div>6</div>  
                                    <div>7</div>
                                </div>
                              </div>
                              </div>
                                <!-- end progress bar item -->
                                <!-- start progress bar item -->
                                <!-- start progress bar item -->
                                <div class="row">
                              <div class="col-md-12">
                                  <div class="flex-container">
                                  	<span>Honest</span>
                                    <div>1</div>
                                    <div>2</div>
                                    <div>3</div>  
                                    <div>4</div>
                                    <div>5</div>
                                    <div>6</div>  
                                    <div>7</div>
                                </div>
                              </div>
                              </div>
                                <!-- end progress bar item -->
                                <!-- end progress bar item -->
                                <!-- start progress bar item -->
                                <div class="row">
                              <div class="col-md-12">
                                  <div class="flex-container">
                                  	<span>Responsible</span>
                                    <div>1</div>
                                    <div>2</div>
                                    <div>3</div>  
                                    <div>4</div>
                                    <div>5</div>
                                    <div>6</div>  
                                    <div>7</div>
                                </div>
                              </div>
                              </div>
                                <!-- end progress bar item -->
                                
                                <!-- start progress bar item -->
                                <div class="row">
                              <div class="col-md-12">
                                  <div class="flex-container">
                                  	<span>Teamplayer </span>
                                    <div>1</div>
                                    <div>2</div>
                                    <div>3</div>  
                                    <div>4</div>
                                    <div>5</div>
                                    <div>6</div>  
                                    <div>7</div>
                                </div>
                              </div>
                              </div>
                              
                              
                              
                              <div class="row">
                              <div class="col-md-12">
                                  <div class="flex-container">
                                  	<span>Leader</span>
                                    <div>1</div>
                                    <div>2</div>
                                    <div>3</div>  
                                    <div>4</div>
                                    <div>5</div>
                                    <div>6</div>  
                                    <div>7</div>
                                </div>
                              </div>
                              </div>
                                <!-- end progress bar item -->
                           
                            
                        	</div>
                        </div>
                    </div>
                    <!-- end features box item -->
                    
                    <!-- start features box item -->
                    <div class="col-md-6 col-sm-6 col-xs-12 sm-margin-four-bottom xs-no-margin-bottom wow fadeInUp" data-wow-delay="0.4s" >
                    
                    
                    
                        <div class="bg-white" style="border:1px solid #ddd; border:1px solid #ddd; -webkit-box-shadow: 5px 7px 9px -4px rgb(158, 158, 158);-moz-box-shadow: 5px 7px 9px -4px rgb(158, 158, 158);box-shadow: 5px 7px 9px -4px rgb(158, 158, 158); background-color:{{profilDetail.personalityMaster.personalityColourCode}};">
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
        
        <section class="wow fadeIn padding-60px-tb sm-padding-40px-tb bg-deep-pink" style="visibility: visible; animation-name: fadeIn;">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-sm-12 center-col position-relative text-center">
                        <a class="btn btn-white btn-medium vertical-align-top xs-no-margin-left margin-10px-right popup-with-zoom-anim wow fadeInUp" data-wow-delay="0.6s"   ng-click="addToCart(profilDetail)" >Shortlist <i class="fa fa-shopping-cart"></i></a>
                        <!-- start modal pop-up -->
                        <div id="modal-popup2" class="zoom-anim-dialog mfp-hide col-lg-3 col-md-6 col-sm-7 col-xs-11 center-col bg-white text-center modal-popup-main padding-50px-all">
                           <!--  <span class="text-extra-dark-gray text-uppercase alt-font text-extra-large font-weight-600 margin-15px-bottom display-block">Modal dialog</span> -->
                            <p class="margin-four">Profile shortlisted added to Cart</p>
                            <a class="btn btn-medium btn-rounded btn-dark-gray popup-modal-dismiss" href="#">Ok</a>
                        </div>
                        <!-- end modal pop-up -->
                        <a  class="btn btn-white btn-medium vertical-align-top xs-no-margin-right margin-10px-left">Purchase Card <i class="fa fa-shopping-cart"></i></a>
                    </div>                    
                </div>
            </div>
        </section>
       <!-- end form style 02 section -->    
       
        </div> 
          <script src="<c:url value='/resources/js/angular.js' />"></script>
       <script src="<c:url value='/resources/js/angular.min.js' />"></script>
       <script src="<c:url value='/resources/js/angular-animate.js' />"></script>
        <script src="<c:url value='/resources/js/angular-flexslider.js' />"></script> 
        <script src="<c:url value='/resources/js/angular-route.js' />"></script>
         <script src="<c:url value='/resources/js/angular-ui-tree.js' />"></script>
        <script src="<c:url value='/resources/js/peerhuntr.js' />"></script>    
  <jsp:include page="footer.jsp" ></jsp:include>
    