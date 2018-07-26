<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html >
<style>


#suggestion { 
  position: absolute;
  width: 85%;
  padding-top:15px;
  z-index:1;
}

#suggestion ul {
  padding: 0;
  max-height: 150px;
  overflow-y: auto;
  margin-top: 25px;
  border-left: none;
  border-right: none;
}

#suggestion ul li {

  list-style: none;
  background-color: rgba(255, 255, 255, 0.9);
  background-image: 
    linear-gradient(
      90deg,
      #7bd10d 10px,
      #7bd10d 10px,
      #7bd10d 11px,
      transparent 11px);
  padding: 5px;
  border: 1px solid #F4F4F4;
  width: 100%;
  box-sizing: border-box;
  cursor: pointer;
  text-align:left;
  color:#555;
  padding-left:20px;  
}

/*--css for search bar--*/

.dropdown.dropdown-lg .dropdown-menu {
    margin-top: -1px;
    padding: 6px 20px;
    width: 100%;
}
.input-group-btn .btn-group {
    display: flex !important;
}
.btn-group .btn {
    border-radius: 0;
    margin-left: -1px;
}
.btn-group .btn:last-child {
    border-top-right-radius: 4px;
    border-bottom-right-radius: 4px;
}
.btn-group .form-horizontal .btn[type="submit"] {
  border-top-left-radius: 4px;
  border-bottom-left-radius: 4px;
}
.form-horizontal .form-group {
    margin-left: 0;
    margin-right: 0;
}
.form-group .form-control:last-child {
    border-top-left-radius: 4px;
    border-bottom-left-radius: 4px;
}
.dropdown {
    position:static !important;
}
@media screen and (min-width: 768px) {
    #adv-search {
        width: 500px;
        margin: 0 auto;
    }
    .dropdown.dropdown-lg {
        position: static !important;
    }
    .dropdown.dropdown-lg .dropdown-menu {
        min-width: 500px;
    }
    
.modal-close:after {
 /* content: 'x';*/
  position: absolute;
  top: 25px;
  left: 40%;
  z-index: 20;
  /*margin-left: 285px;
  background: #fff;
  border-radius: 2px;
  padding: 2px 8px;
  font-size: 1.2em;*/
  text-decoration: none;
  text-indent: 0;
}
 .modal-close {
    right: auto;
    text-decoration: none;
  }
 .modal-close:before {
    display: none;
  }
  /* .modal-close:after {
    content: 'Close';
    top: 0.4em;
    left: 1em;
    z-index: 40;
    margin-left: 0;
    font-size: 1em;
    padding: 0.5em 1em;
  } */



</style>
  <div ng-controller="PeerController" ng-cloak ng-init="fetchUsersCard(false)">
       <jsp:include page="header.jsp"></jsp:include>
      <!-- start slider section -->
      
      
          <!-- start slider section -->
        <section class="no-padding main-slider height-100 mobile-height wow fadeIn ">
            <div class="swiper-full-screen swiper-container height-100 width-100 black-move">
                <div class="swiper-wrapper" style="height:500px;">
                    <!-- start slider item -->
                    <div class="swiper-slide padding-100px-all cover-background position-relative xs-padding-20px-all" style="background-image:url(resources/images/webimage1.png);">
                        <div class="position-relative width-40 md-width-60 sm-width-85 xs-width-100 display-inline-block slide-banner last-paragraph-no-margin">
                            <div class="padding-80px-all bg-black-opacity sm-padding-40px-all xs-padding-30px-all xs-text-center xs-width-100">
                                 <h6 class="alt-font text-white width-90 sm-width-100" style="color:#fff;">Create your profile card</h6>
                                <!--  <p class="width-90 sm-width-100"></p>-->
                            </div> 
                        </div>
                    </div>
                    <!-- end slider item -->
                    <!-- start slider item -->
                    <div class="swiper-slide padding-100px-all cover-background position-relative xs-padding-20px-all" style="background-image:url(resources/images/webimage2.png);">
                        <div class="position-relative width-40 md-width-60 sm-width-85 xs-width-100 display-inline-block slide-banner last-paragraph-no-margin">
                            <div class="padding-80px-all bg-black-opacity sm-padding-40px-all xs-padding-30px-all xs-text-center xs-width-100">
                                        <h6 class="alt-font text-white width-90 sm-width-100" style="color:#fff;">Complete the personality test</h6>
                                <!-- <p class="width-90 sm-width-100">Complete the personality test</p>-->
                                </div> 
                        </div>    
                    </div>
                    <!-- end slider item -->
                    <!-- start slider item -->
                    <div class="swiper-slide padding-100px-all cover-background position-relative xs-padding-20px-all" style="background-image:url(resources/images/webimage3.png)">
                        <div class="position-relative width-40 md-width-60 sm-width-85 xs-width-100 display-inline-block slide-banner last-paragraph-no-margin">
                            <div class="padding-80px-all bg-black-opacity sm-padding-40px-all xs-padding-30px-all xs-text-center xs-width-100">
                                     <h6 class="alt-font text-white width-90 sm-width-100" style="color:#fff;">Ask for peer reviews</h6>
                                <!-- <p class="width-90 sm-width-100">Ask for peer reviews</p> -->
                                  </div> 
                        </div>      
                    </div>
                    <!-- end slider item -->
                </div>
                <!-- start slider pagination -->
                <div class="swiper-pagination"></div>
                <div class="swiper-button-next swiper-button-black-highlight display-none"></div>
                <div class="swiper-button-prev swiper-button-black-highlight display-none"></div>
                <!-- end slider pagination -->
            </div>
        </section>
        <!-- end slider section -->
        
          
        
        <section class="parallax wow fadeIn" data-stellar-background-ratio="0.4" style="background-image: url(&quot;resources/images/parallax-bg21.jpg&quot;); visibility: visible; animation-name: fadeIn;">
        <div class="row">
                    <div class="col-md-7 col-sm-12 col-xs-12 center-col text-center margin-100px-bottom xs-margin-40px-bottom">
                        <div class="position-relative overflow-hidden">
                            <span class="text-big text-outside-line-full alt-font font-weight-600 text-uppercase">Profile Card Gallery</span>
                        </div>
                    </div>
                </div>
                
               
        <div class="row center-col">
        <div class="col-md-4"></div>
        
        <div class="col-md-4">
                            <div class="input-group text-center margin-100px-bottom margin-40px-top xs-margin-40px-bottom">
                            <input type="text" class="search-query form-control" placeholder="Search for peerHuntr" id="filter" ng-keypress="suggestionList()"/>
                <div id="suggestion">
	                <ul style="{{suggestionload}}" >
	               <div ng-model="mySuggestion" ng-repeat="suggestData in data" ng-click="setFilterValue($event)">
	                <li id="{{suggestData.name}}" >{{suggestData.name}}</li>
	                </div>
	                </ul>
   				</div>
                                <span class="input-group-btn">
                                    <button class="btn btn-danger" type="button" ng-click="fetchUsersCard(true)">
                                        <span class=" glyphicon glyphicon-search"></span>
                                    </button>
                                </span>
                            </div>
                        </div>
                        <div class="col-md-4"></div>
                        </div> 
                        
      
      
                        
        <div class="row center-col">
        <div class="col-md-4"></div>
       <div class="col-md-2">
         <div class="form-group" style="margin-top:5px; margin-bottom:0px;">
                                     <select name="singleFilter" id="singleSelect" ng-model="singleSelect.singleFilter.value" ng-change="filterName()"  style="border:1px solid #eee; padding:8px 10px; margin:0px;" ng-change="sortByRating()">
                                        <option selected="selected" id="selectFilter" value="">--Select NationalityType--</option>
                                        <option id="nationalityType"value="nationalityType">NationalityType</option>       
                                    </select>                         
                            </div>
        </div>
        
        
         <div class="col-md-2">
          <div class="form-group" style="margin-top:5px; margin-bottom:0px;">
                                     
                                      <select name="singleFilter" id="singleSelect" ng-model="singleSelect.singleFilter.value" ng-change="filterName()" 
                                      style="border:1px solid #eee; padding:8px 10px; margin:0px;" ng-change="sortByRating()">
                                      <option selected="selected" id="selectFilter" value="">-Select SpecializationType--</option>
                                     <option id="specialization" value=specialization>Specialization</option>  
                                      <option></option>
                                    </select>
                                  </div>
        </div>
        
        <div class="col-md-2">
        <div class="form-group" style="margin-top:5px; margin-bottom:0px;">
                                     
                                      <select name="singleFilter" id="singleSelect" ng-model="singleSelect.singleFilter.value"  ng-change="filterName()" style="border:1px solid #eee; padding:8px 10px; margin:0px;" ng-change="sortByRating()">
                                      <option selected="selected" id="selectFilter" value="">--Select DegreeType--</option>
                                     <option id="degree" value="degree">Degree</option>  
                                      <option></option>
                                    </select>
                                  </div>
        </div>
        <div class="col-md-2">
          <div class="form-group" style="margin-top:5px; margin-bottom:0px;">
        <select name="singleFilter" id="singleSelect" ng-model="singleSelect.singleFilter.value" ng-change="filterName()" style="border:1px solid #eee; padding:8px 10px; margin:0px;">
                                        <option selected="selected" id="selectFilter" value="">--Select personalityType --</option>
                                        <option id="personalityType"value="personalityType">personalityType</option>
                                        <option></option>
                                    </select> 
                                  </div>
     <!-- <div class="form-group" style="margin-top:5px; margin-bottom:0px;">
        
                                    <select name="singleFilter" id="singleSelect" ng-model="singleSelect.singleFilter.value" ng-change="filterName()" style="border:1px solid #eee; padding:8px 10px; margin:0px;">
                                       <option selected="selected" id="selectFilter" value="">----Please Filter---</option>
                                        <option id="nationality" value="nationality">Nationality</option>
                                        <option id="specialization" value="specialization">Specialization</option>
                                        <option id="degree" value="degree">Degree</option>
                                        <option id="personalityType" value="personalityType">Personality Type</option>
                                    </select>
                                  </div> 
        </div> -->
        
        <div class="col-md-2">       
        <div class="form-group" style="margin-top:5px; margin-bottom:0px;">
                                     <select name="singleSort" id="sortRating" ng-model="sortRating.singleSort.value" style="border:1px solid #eee; padding:8px 10px; margin:0px;" ng-change="sortByRating()">
                                        <option id="select" selected="selected" value="">---Please Select Sort---</option>
                                        <option id="gtrTnFive" value="5">>5</option>
                                        <option id="gtrTnSix" value="6" >>6</option>
                                    </select>
                                  </div>                         
        </div>
        <div class="col-md-4"></div>
        </div>
        
       <div class="loading" style="{{load}}">Loading&#8230;</div>
       <p class="row" style="margin-left: 43%; color:red;  font-size:20px;margin-top: 20px;" ng-cloak>
            										{{noRecord}}
            										</p> 
       <div class="container">
       <div class="row">   
       
       
       <!-- dummy start modal pop-up -->
       <a class="popup-with-zoom-anim wow fadeInUp" data-wow-delay="0.6s" href="#modal-popup2">
<div>
<div ng-repeat="user in userSelectData">
<div class="col-md-4" ng-click="showUserPop(user,'a')">
<!-- <a class="call-modal" > -->
<div class="frame" style="margin-top:20px;"  ng-click="removeClass()">
<div id="A" class="center"  style="background-image: url(&quot;resources/images/card-bg.png&quot;); visibility: visible; animation-name: fadeIn; background-repeat:no-repeat; background-color:{{user.personalityMaster.personalityColourCode}};">
    <p class="name">{{user.firstName|uppercase| limitTo : 1 : 0}}. {{user.lastName|uppercase| limitTo : 1 : 0}}.</p>
		<div class="profile">
			<div class="image" ng-repeat="profileImage in user.profileImages|limitTo:1">
				<img class="img-circle" src="{{profileImage.hiddenImageUrl}}" style="border:{{user.personalityMaster.personalityColourCode}} 5px solid;">
			</div>
		</div>	
		<div class="stats">
			<div class="box">		
        <p style="margin: 0 0 5px; color:#fff; text-align:left; font-size:12px;">
                            <img src="<c:url value='/resources/images/nationality.png'/>" style="width:20px; height:auto;margin-right:3px;"> {{user.nationalityMaster.nationality}}</p>
                            <p style="margin: 0 0 5px; color:#fff; text-align:left; font-size:12px;">
                            <img src="<c:url value='/resources/images/age.png'/>" style="width:20px; height:auto;margin-right:3px;"> {{user.age}} Years</p>
                            <p style="margin: 0 0 5px; color:#fff; text-align:left; font-size:12px;">
                            <img  src="<c:url value='/resources/images/education.png'/>" style="width:20px; height:auto;margin:0 0 -5px; margin-right:3px;">{{user.specializationMaster.degreeMaster.degreeName}}, <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {{ user.specializationMaster.specializationName}}, <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{user.universitySchool| limitTo : 17 : 0}}</p>
                            
							<p style="margin: 0 0 5px; color:#fff; text-align:left;font-size:12px;">
                            <img src="<c:url value='/resources/images/personality-type.png'/>" style="width:20px; height:auto;margin-right:3px;">{{user.personalityMaster.personalityRole}} ({{user.personalityMaster.personalityType}})</p>
                            <p style="margin: 0 0 5px; color:#fff; text-align:left; font-size:12px;">
                            <img  src="<c:url value='/resources/images/score.png'/>" style="width:20px; height:auto;margin-right:3px;">{{user.score|number:1}} ({{user.review}} reviews)</p>                                       
                            
			</div>		
		</div>     
</div>
</div>
 </a> -->
</div>
</div>

</div>

</a>
                        <!-- start modal pop-up -->
                        <div id="modal-popup2" class="card-container zoom-anim-dialog mfp-hide center-col modal-popup-main padding-50px-all">
                           <!-- start popup -->
                           <div style="float:right; margin-top: -17%; margin-right: -46%;">
<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
	 
	     <a ng-click="loginToSystem()"><img style="width:30px; height:auto; border:0; padding:5px;" src="<c:url value='/resources/images/cart-60-white.png'/>"></a>  
	     <a ng-click="loginToSystem()" ><img style="width:30px; height:auto; border:0;  padding:5px;" src="<c:url value='/resources/images/payment-60.png'/>"></a>
     
    </sec:authorize>
    
      <sec:authorize access="hasRole('ROLE_USER')">
	      
	     <a ng-click="addToCart(userProfile)"> <img style="width:15px; height:auto; border:0;" src="<c:url value='/resources/images/cart-60.png'/>"></a>  
	     <a><img style="width:15px; height:auto; border:0;" src="<c:url value='/resources/images/payment-60-black.png'/>"></a>
	     
    </sec:authorize>

</div>

  <div class="card-design">
    <div class="frontside" id="frontside"  ng-click="flip('frontside')">
    <div class="frame1"  style="background-image: url(&quot;resources/images/card-bg-full.png&quot;); visibility: visible; animation-name: fadeIn; background-repeat:no-repeat; background-color:{{userProfile.personalityMaster.personalityColourCode}};">
    <p class="name">{{userProfile.firstName|uppercase| limitTo : 1 : 0}}. {{userProfile.lastName|uppercase| limitTo : 1 : 0}}.</p>
  <div class="center1" style="height:430px">
    		<div class="profile">
			<div class="image1" ng-repeat="profileImage in userProfile.profileImages|limitTo:1">
				<img class="img-circle" src="{{profileImage.hiddenImageUrl}}" style="border:{{userProfile.personalityMaster.personalityColourCode}} 5px solid;">
			</div>
		</div>
		
		<div class="stats1">
			<div class="box">
		
        <p style="margin: 0 0 5px; color:#fff; text-align:left; font-size:12px;">
                            <img src="<c:url value='/resources/images/nationality.png'/>"  style="width:20px; height:auto;margin-right:3px;"> {{userProfile.nationalityMaster.nationality}}</p>
                            <p style="margin: 0 0 5px; color:#fff; text-align:left; font-size:12px;">
                            <img src="<c:url value='/resources/images/age.png'/>" style="width:20px; height:auto;margin-right:3px;"> {{userProfile.age}} Years</p>
                            <p style="margin: 0 0 5px; color:#fff; text-align:left; font-size:12px;">
                            <img  src="<c:url value='/resources/images/education.png'/>" style="width:20px; height:auto;margin:0 0 -5px; margin-right:3px;">{{userProfile.specializationMaster.degreeMaster.degreeName}}, <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {{userProfile.specializationMaster.specializationName}}, <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{{userProfile.universitySchool| limitTo : 17 : 0}}</p>
                            <p style="margin: 7px 0 5px; color:#fff; text-align:left; font-size:12px;">
                            <img src="<c:url value='/resources/images/personality-type.png'/>" style="width:20px; height:auto;margin-right:3px;">{{userProfile.personalityMaster.personalityRole}} ({{userProfile.personalityMaster.personalityType}})</p>
                            <p style="margin: 0 0 5px; color:#fff; text-align:left; font-size:12px;">
                            <img src="<c:url value='/resources/images/score.png'/>" style="width:20px; height:auto;margin-right:3px;"> {{userProfile.score|number:1}} ({{userProfile.review}} reviews)</p>
        

				
                            
                            
			</div>
			
		</div>
		
		<div ng-init="ratingIndex = $index" ng-repeat="userAvgRating in userProfile.userAvgRatings  track by $index ">
        <div class="profile1">
        	<span style="font-size:12px; line-height:3">{{userAvgRating.ratingType.ratingName}}</span>
     
        </div>
  
         <div align="center" style="float: left; padding-left: 8px; padding-top: 0px;">
          <span  ng-init="ratingValIndex =$index" ng-repeat="n in [].constructor(userAvgRating.ratingType.ratingValue) track by $index">
         			<div class="star" ng-if="$index<=(userAvgRating.avgRatingValue|number:0)-1" style="display:inline">
        	        <img style="width:15px;display:inline" src="<c:url value='/resources/images/star-30.png'/>" id={{ratingIndex}}{{ratingValIndex}} 
                    /></div>
                  	<div class="star" ng-if="$index>(userAvgRating.avgRatingValue|number:0)-1" style="display:inline">
                  	 <img style="width:15px;display:inline" src="<c:url value='/resources/images/star-line-30.png'/>" id={{ratingIndex}}{{ratingValIndex}} 
                    /></div>
                  	
                </span> 		
         
                </div> 
                
                
                </div>
              
               
               
  </div>
</div>
    
    </div>
    <div class="backside" id="backside" ng-click="flip('backside')">
    
    
    
    
    <div id="testimonial" style="background-color:{{userProfile.personalityMaster.personalityColourCode}};">
    
          
            <div class="padding-10px-all text-center"> 
                    
                        <p class="name">Comments</p>
                        <i class="fa fa-quote-right"></i>
                        
                        
                        <div id="slider" style="height:250px;"  class="carousel slide" data-ride="carousel" >
                        
                            <ol class="carousel-indicators">
                                <li data-target="#slider" data-slide-to="0" class="active"></li>
                                <li data-target="#slider" data-slide-to="1"></li>
                                <li data-target="#slider" data-slide-to="2"></li>
                            </ol>
	
      							 <div class="carousel-inner">  				
								         <div class="item carousel-content" ng-class="{active:!$index}" ng-repeat="comments in userProfile.comments track by $index">
								          <p> {{comments}}</p>
								        </div>  
								        
								      <!--   <div class="item {{::($index === 0 ? 'active' : '')}}" ng-repeat="c in userProfile.comments track by $index">
             							<div class="row">
               									 <div class="col-xs-3">{{c}}</div>
           								  </div>
          </div> -->
								    </div><!-- carousel inner -->
            </div>
    
</div>
  </div>
</div>

</div>

                       
                        <!-- dummy end modal pop-up -->
         
<div  lazy-scroll='fetchUsersCard(false)' lazy-scroll-trigger="90" >
</div>
<a href="" class="modal-close mfp-close" title="Close this modal"
					data-dismiss="modal">&times;</a>
<!-- end popup -->
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
        
             <script>
             $(document).ready(function() { 
            	//$('#modal-popup2').hide();

             });

             </script>
<!-- Model . js -->
<script>


(function (global) {

	'use strict';

	// Storage variable
	var modal = {};

	// Store for currently active element
	modal.lastActive = undefined;
	modal.activeElement = undefined;

	// Polyfill addEventListener for IE8 (only very basic)
	document._addEventListener = document.addEventListener || function (event, callback) {
		document.attachEvent('on' + event, callback);
	};

	// Hide overlay when ESC is pressed
	document._addEventListener('keyup', function (event) {
		var hash = window.location.hash.replace('#', '');

		// If hash is not set
		if (hash === '' || hash === '!') {
			return;
		}

		// If key ESC is pressed
		if (event.keyCode === 27) {
			window.location.hash = '!';

			if (modal.lastActive) {
				return false;
			}

			// Unfocus
			modal.removeFocus();
		}
	}, false);

	// Conveniance function to trigger event
	modal._dispatchEvent = function (event, modal) {
		var eventTigger;

		if (!document.createEvent) {
			return;
		}

		eventTigger = document.createEvent('Event');

		eventTigger.initEvent(event, true, true);
		eventTigger.customData = { 'modal': modal };

		document.dispatchEvent(eventTigger);
	};


	// When showing overlay, prevent background from scrolling
	window.onhashchange = function () {
		var hash = window.location.hash.replace('#', '');
		var modalElement = document.getElementById(hash);
		var modalChild;

		// If the hash element exists
		if (modalElement) {

			// Get first element in selected element
			modalChild = modalElement.children[0];

			// When we deal with a modal and class `has-overlay` is not set on html yet
			if (modalChild && modalChild.className.match(/modal-inner/) && !document.documentElement.className.match(/has-overlay/)) {

				// Set an html class to prevent scrolling
				document.documentElement.className += ' has-overlay';

				// Mark modal as active
				modalElement.className += ' is-active';
				modal.activeElement = modalElement;

				// Set the focus to the modal
				modal.setFocus(hash);

				// Fire an event
				modal._dispatchEvent('cssmodal:show', modal.activeElement);
			}
		} else {
			document.documentElement.className = document.documentElement.className.replace(' has-overlay', '');

			// If activeElement is already defined, delete it
			if (modal.activeElement) {
				modal.activeElement.className = modal.activeElement.className.replace(' is-active', '');

				// Fire an event
				modal._dispatchEvent('cssmodal:hide', modal.activeElement);

				// Reset active element
				modal.activeElement = null;

				// Unfocus
				modal.removeFocus();
			}
		}
	};


	/*
	 * Accessibility
	 */

	// Focus modal
	modal.setFocus = function () {
		if (modal.activeElement) {

			// Set element with last focus
			modal.lastActive = document.activeElement;

			// New focussing
			modal.activeElement.focus();
		}
	};

	// Unfocus
	modal.removeFocus = function () {
		if (modal.lastActive) {
			modal.lastActive.focus();
		}
	};


	global.CSSModal = modal;

}(window));


</script>
        </div>
 <jsp:include page="footer.jsp" ></jsp:include>

