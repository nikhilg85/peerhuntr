<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
            <div ng-app="peerhuntr" ng-controller="PeerController" ng-init="getMyProfile()" ng-cloak>
       <jsp:include page="header.jsp"></jsp:include>
        <!-- start page title section --> 
        <section class="wow fadeIn bg-extra-dark-gray padding-35px-tb page-title-small " ng-cloak>
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
   
        <!-- start info banner style 01 section -->
              <section class="wow fadeIn parallax" data-stellar-background-ratio="0.5" style="background-image: url('<%=request.getContextPath() %>/resources/images/parallax-bg21.jpg')" ng-cloak>
            <div class="container" ng-cloak>
                
                <div class="row equalize xs-equalize-auto">                   
                    <!-- start features box item -->
                    <div class="col-md-4 col-sm-4 card col-xs-12 sm-margin-four-bottom xs-margin-30px-bottom wow fadeInUp " >
                        <div class="card-container">
  <div class="card-design">
    <div class="frontside">
    <div class="frame1"  style="background-image: url(&quot;<%=request.getContextPath() %>/resources/images/card-bg-full.png&quot;); visibility: visible; animation-name: fadeIn; background-repeat:no-repeat; background-color:{{user.personalityMaster.personalityColourCode}};">
    <p class="name">{{user.firstName|uppercase}} {{user.lastName |uppercase}} </p>
  <div class="center1" style="height:430px">
    
		<div class="profile">
			<div class="image" ng-repeat="profileImage in user.profileImages|limitTo:1">
				<img class="img-circle" src="{{profileImage.imageUrl}}" style="border:{{user.personalityMaster.personalityColourCode}} 5px solid;">
			</div>
		</div>
		
		<div class="stats1">
			<div class="box">
			
		
        					<p style="margin: 0 0 5px; color:#fff; text-align:left; font-size:12px;">
                            <img src="<c:url value='/resources/images/nationality.png'/>" style="width:20px; height:auto;margin-right:3px;"> {{user.nationalityMaster.nationality}}</p>
                            <p style="margin: 0 0 5px; color:#fff; text-align:left; font-size:12px;">
                            <img src="<c:url value='/resources/images/age.png'/>" style="width:20px; height:auto;margin-right:3px;"> {{user.age}} Years</p>
                           <p style="margin: 0 0 5px; color:#fff; text-align:left; font-size:12px;">
                                                       <img  src="<c:url value='/resources/images/education.png'/>" style="width:20px; height:auto;margin:0 0 -5px; margin-right:3px;">{{user.specializationMaster.degreeMaster.degreeName}}, <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {{ user.specializationMaster.specializationName}}, <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{user.universitySchool| limitTo : 17 : 0}}</p>
                           
                           
                           
                           
                           <%--  <img  src="<c:url value='/resources/images/education.png'/>" style="width:20px; height:auto;margin-right:3px;">{{user.specializationMaster.degreeMaster.degreeName| limitTo : 4 : 0}},{{ user.specializationMaster.specializationName | limitTo : 10 : 0}}...</p>
                            <p style="margin: -7px 0 0px; color:#fff; text-align:left; font-size:12px;">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {{user.universitySchool| limitTo : 16 : 0}}...</p> --%>
							<p style="margin: 0 0 5px; color:#fff; text-align:left; font-size:12px;">
                            <img src="<c:url value='/resources/images/personality-type.png'/>" style="width:20px; height:auto;margin-right:3px;">{{user.personalityMaster.personalityRole}} ({{user.personalityMaster.personalityType}})</p>
                                    <p style="margin: 0 0 5px; color:#fff; text-align:left; font-size:12px;">
                            <img  src="<c:url value='/resources/images/score.png'/>" style="width:20px; height:auto;margin-right:3px;"> {{user.score|number:1}} ({{user.review}} reviews)</p> 
                            
			</div>
			
		</div>
		
			<div ng-init="ratingIndex = $index" ng-repeat="userAvgRating in user.userAvgRatings  track by $index ">
        <div class="profile1">
        	<span style="font-size:12px; line-height:3; color:#fff;">{{userAvgRating.ratingType.ratingName}}</span>
     
        </div>
  
         <div align="center" style="float: left; padding-left: 8px; padding-top: 0px; color:#fff;">
                  
                <!--  <input type="radio"  name="rating" /> -->
                  	<span class="fa fa-star" aria-hidden="true" name="rating" ng-init="ratingValIndex =$index" id={{ratingIndex}}{{ratingValIndex}} 
                                	ng-style="$index<=(userAvgRating.avgRatingValue|number:0)-1 && setColor(ratingValIndex,ratingIndex)" 
                  	ng-repeat="n in [].constructor(userAvgRating.ratingType.ratingValue) track by $index"></span>
                  	
                 <%--  <label class="bad border" ng-init="ratingValIndex =$index" id={{ratingIndex}}{{ratingValIndex}} 
                                	ng-style="$index<=(userAvgRating.avgRatingValue|number:0)-1 && setColor(ratingValIndex,ratingIndex)" 
                  	ng-repeat="n in [].constructor(userAvgRating.ratingType.ratingValue) track by $index">{{$index+1}}</label> --%>
                
                </div> 
                
                
                </div>
     
   
  </div>
</div>
    
    </div>
   
</div>

</div>
                        
                        
                        
                    </div>
                    <!-- end features box item -->
                    
                    <!-- start features box item -->
                    <div class="col-md-4 col-sm-4 col-xs-12 sm-margin-four-bottom xs-no-margin-bottom wow fadeInUp" data-wow-delay="0.4s" >
                    <div class="card-container">
                    <div class="card-design">
    
    <div class="frontside">
    
     <div id="testimonial" style="background-color:{{user.personalityMaster.personalityColourCode}};">
    
          
            <div class="padding-10px-all text-center"> 
                    
                        <p class="name">Comments</p>
                        <i class="fa fa-quote-right"></i>
                        
                        
                        <div id="slider" class="carousel slide" data-ride="carousel" style="height:250px; color:#fff;">
                        
                            <ol class="carousel-indicators">
                                <li data-target="#slider" data-slide-to="0" class="active"></li>
                                <li data-target="#slider" data-slide-to="1"></li>
                                <li data-target="#slider" data-slide-to="2"></li>
                            </ol>
                            
               
               
                   			<div class="carousel-inner">
								        <div class="item" ng-class="{active:!$index}"  ng-repeat="comments in user.comments track by $index">
								           {{comments}}
								        </div>
								        
								        							
   
								    </div><!-- carousel inner -->
								 
	
							
                        </div>  <!-- carousel slide -->
                        
            </div>
            
     
</div>
            
     
</div>
  </div>
</div>
</div>
                    
                    <!-- end features box item -->
                     <div class="col-md-4 col-sm-4 col-xs-12 sm-margin-four-bottom xs-no-margin-bottom wow fadeInUp" data-wow-delay="0.4s" style="margin-top:2%;">
                     <div class="center"  style=" background-color:#104953; height:500px;">
                   
                <div class="row">
                    <div class="col-md-12 col-sm-10 col-xs-10 center-col text-center elements-social social-icon-style-3 padding-50px-all">
                    <div class="position-relative overflow-hidden width-100">
                            <span class="text-small text-outside-line-full alt-font font-weight-600 text-uppercase" style="color:#FFF;">Share for Peer Rating</span>
                        </div>
                        <ul class="medium-icon">
                            <li style="padding:10px;"><a class="facebook" ng-click="ratingLink('fa',user.referralCode,user.ratingLink,user.firstName,user.lastName)"><i class="fa fa-facebook"></i></a></li>
                            <li style="padding:10px;"><a class="twitter" ng-click="ratingLink('tw',user.referralCode,user.ratingLink,user.firstName,user.lastName)"><i class="fa fa-twitter"></i></a></li>
                            <li style="padding:10px;"><a class="google" ng-click="ratingLink('em',user.referralCode,user.ratingLink,user.firstName,user.lastName)"><i class="fa fa-envelope-open"></i></a></li>
                            <li style="padding:10px;"><a class="linkedin" ng-click="ratingLink('li',user.referralCode,user.ratingLink,user.firstName,user.lastName)"><i class="fa fa-linkedin"></i></a></li>
                            <li style="padding:10px;"><a class="whatsapp" ng-click="ratingLink('wa',user.referralCode,user.ratingLink,user.firstName,user.lastName)"><i class="fa fa-whatsapp"></i></a></li>
                           
                        </ul>
                    </div>
                </div></div>
                     </div>
                </div>
            </div>
        </section>
        <!-- end info banner style 01 section -->
        
     
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
