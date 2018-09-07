<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html >
<style>


#suggestion { 
  position: absolute;
  width: 83%;
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

</style>

  <div ng-controller="PeerController" ng-cloak>
       <jsp:include page="header.jsp"></jsp:include>
        <div class="" ng-app="peerhuntr" ng-controller="PeerController">
      <!-- start slider section -->
        <section class="wow fadeIn no-padding">
            <div class="swiper-auto-height-container position-relative width-100">
                <div class="swiper-wrapper overflow-hidden">
                    <!-- start slider item -->
                    <div class="swiper-slide padding-60px-all cover-background position-relative xs-padding-20px-all" style="background-image:url(resources/images/parallax-bg32.jpg)">
                        <div class="position-relative width-40 md-width-60 sm-width-85 xs-width-100 display-inline-block slide-banner last-paragraph-no-margin">
                            <div class="padding-20px-all bg-black-opacity sm-padding-40px-all xs-padding-30px-all xs-text-center xs-width-100">
                                <h5 class="alt-font text-white width-90 sm-width-100">peerHuntr website Guide</h5>
                                <p class="width-90 sm-width-100">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged...</p>
                                <a href="#" class="margin-35px-top sm-margin-15px-top btn btn-small btn-white">Read More</a>
                            </div> 
                        </div>
                    </div>
                    <!-- end slider item -->
                    <!-- start slider item -->
                    <div class="swiper-slide padding-60px-all cover-background position-relative xs-padding-20px-all" style="background-image:url(resources/images/parallax-bg41.jpg)">
                        <div class="position-relative width-40 md-width-60 sm-width-85 xs-width-100 display-inline-block slide-banner last-paragraph-no-margin"> 
                            <div class="padding-20px-all bg-black-opacity sm-padding-40px-all xs-padding-30px-all xs-text-center xs-width-100">
                                <h5 class="alt-font text-white width-90 sm-width-100">peerHuntr Guidance</h5>
                                <p class="width-90 sm-width-100">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                                <a href="#" class="margin-35px-top sm-margin-15px-top btn btn-small btn-white">Read More</a>
                            </div>  
                        </div>
                    </div>
                    <!-- end slider item -->
                    <!-- start slider item -->
                    <div class="swiper-slide padding-60px-all cover-background position-relative xs-padding-20px-all" style="background-image:url(resources/images/parallax-bg33.jpg)">
                        <div class="position-relative width-40 md-width-60 sm-width-85 xs-width-100 display-inline-block slide-banner last-paragraph-no-margin">
                            <div class="padding-20px-all bg-black-opacity sm-padding-40px-all xs-padding-30px-all xs-text-center xs-width-100">
                                <h5 class="alt-font text-white width-90 sm-width-100">peerHuntr Guide</h5>
                                <p class="width-90 sm-width-100">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                                <a href="#" class="margin-35px-top sm-margin-15px-top btn btn-small btn-white">Read More</a>
                        </div>
                    </div>
                    </div>
                    <!-- end slider item -->
                
                <div class="navigation-area">
                    <div class="swiper-button-next swiper-next-style4 bg-primary text-white"><i class="fa fa-arrow-up" aria-hidden="true"></i></div>
                    <div class="swiper-button-prev swiper-prev-style4"><i class="fa fa-arrow-down" aria-hidden="true"></i></div>
                </div>
            </div>
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
                
                <div class="row">    
       <div class="col-md-8 center-col text-center margin-100px-bottom margin-40px-top xs-margin-40px-bottom">
		    <div class="input-group">
		     
		     <div class="input-group-btn search-panel">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    	<span id="sortby">Sort Rating by</span> <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu" >
                      <li  ><a data-ng-click="sortByRating(5)" id="gtrTnFive">>5</a></li>
                     <li  ><a  data-ng-click="sortByRating(6)" id="gtrTnSix">>6</a></li>
                    
                    </ul>
                </div> &nbsp
                
                <div class="input-group-btn search-panel">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    	<span id="search_concept">Filter by</span> <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu" >
                      <li  ><a data-ng-click="filterName($event)" id="nationality">Nationality</a></li>
                     <li  ><a data-ng-click="filterName($event)" id="specialization">Specialization</a></li>
                     <li  ><a href="#" id="degree" data-ng-click="filterName($event)">Degree</a></li>
                     <li  ><a href="#"  data-ng-click="filterName($event)" id="personalityType">Personality Type</a></li>
                    </ul>
                </div>
                <input type="hidden" name="search_param" value="all" id="search_param">         
  				<input type="text" class="form-control" name="x" placeholder="Search"  id="filter" ng-keypress="suggestionList()">              
                 <div id="suggestion">
  
  
				  <ul id="suggestionName">
				    <li ng-repeat="suggestData in sugestionList" ng-click="getSuggetion($event)" class="autocomplete-group" >
				      <strong id="{{suggestData.nationality}}
                 	{{suggestData.specializationName}}
                  	{{suggestData.degreeName}}
                    {{suggestData.personalityRole}}" ng-click="getSuggetion($event)" >
   			    	{{suggestData.nationality}}
                 	{{suggestData.specializationName}}
                  	{{suggestData.degreeName}}
                    {{suggestData.personalityRole}}
   				   
   				   </strong>
				      
				    </li>
				  </ul>
  
				</div>
                
                <span class="input-group-btn">
                    <button class="btn degreeNamebtn-default" type="button" ng-click="fetchUsersCard(true)"><span class="glyphicon glyphicon-search"></span></button>

                </span>
                
                 
            </div>
            
       
        </div>
	</div>

       <section id="team" class="pb-5">
       <div class="loading" style="{{load}}">Loading&#8230;</div>
    <div class="">

          <div  lazy-scroll='fetchUsersCard(false,$event)' lazy-scroll-trigger="90" >
            <div class="item active" ng-repeat="user in userSelectData">
                    <!-- Team member -->
            <div class="col-md-3" >
                <div class="image-flip" ontouchstart="this.classList.toggle('hover');" >
                    <div class="mainflip">
                        <div class="frontside">
                        
                            <div class="card" style="background-color:{{user.personalityMaster.personalityColourCode}};">
                                <div class="card-body padding-10px-top">
                                    
            <div class=" padding-10px-all">
                <div class="row">
                    <div class="col-md-5">
                     <div ng-repeat="profileImage in user.profileImages|limitTo:1">
                        	<img class="img-responsive" src={{profileImage.hiddenImageUrl}} alt="card image" data-no-retina=""/>
                       </div> 
                       <%--  <img src="<c:url value='/resources/images/image-icon2.png'/>" alt="" class="img-responsive" /> --%>
                        
                        <p style="margin: 0 0 5px; color:#fff;  font-size:12px;">
                            <img src="<c:url value='/resources/images/personality.png'/>" style="width:auto; height:auto; margin-right:5px;"> {{user.personalityMaster.personalityRole}} ({{user.personalityMaster.personalityType}})</p>
                            <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/rating.png'/>" style="width:auto; height:auto; margin-right:5px;"> {{user.score}}/{{user.review}} reviews</p>
                    </div>
                    <div class="col-md-7">
                    <h4 style="margin:0; color:#ffffff;">{{user.firstName|uppercase| limitTo : 1 : 0}}. {{user.lastName |uppercase| limitTo : 1 : 0}}.</h4>
                        <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/nationality.png'/>" style="width:auto; height:auto; margin-right:5px;"> {{user.nationalityMaster.nationality}}</p>
                            <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/age.png'/>" style="width:auto; height:auto; margin-right:5px;">{{user.age}}</p>
                            <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/education.png'/>" style="width:auto; height:auto; margin-right:5px;"> {{user.specializationMaster.degreeMaster.degreeName}}, {{ user.specializationMaster.specializationName}}, {{user.universitySchool}}</p>
                            
                        
                    </div>
                </div>
            </div>
        
                                </div>
                            </div>
                        </div>
                        <div class="backside">
                            <div class="card" style="background-color:{{user.personalityMaster.personalityColourCode}};">
                                <div class="card-body mt-4 padding-10px-all">
                                    
                        <div class="">
                            <h6 style="margin:0; color:#fff;" class="pull-left">Rating </h6>
                            <a href=""  id="{{user.userId}}" class="pull-right btn-default btn-xs"  ng-click="viewDetails(user)">View Detail</a>
                            <!-- start progress bar item -->
                            <!-- start progress bar item -->
                            
                            <div class="col-md-12">
                                  <div class="flex-container">
                                  	<span>Honest</span>
                                    <div style="color:#3f3f3f">1</div>
                                    <div style="color:#545454">2</div>
                                    <div style="color:#696969">3</div>  
                                    <div style="color:#7e7e7e">4</div>
                                    <div style="color:#939393">5</div>
                                    <div style="color:#a8a8a8">6</div>  
                                    <div style="color:#bdbdbd">7</div>
                                </div>
                              </div>
                              <div class="col-md-12">
                                  <div class="flex-container">
                                  	<span>Coachable</span>
                                    <div style="color:#3f3f3f">1</div>
                                    <div style="color:#545454">2</div>
                                    <div style="color:#696969">3</div>  
                                    <div style="color:#7e7e7e">4</div>
                                    <div style="color:#939393">5</div>
                                    <div style="color:#a8a8a8">6</div>  
                                    <div style="color:#bdbdbd">7</div>
                                </div>
                              </div>
                              <div class="col-md-12">
                                  <div class="flex-container">
                                  	<span>Leader</span>
                                     <div style="color:#3f3f3f">1</div>
                                    <div style="color:#545454">2</div>
                                    <div style="color:#696969">3</div>  
                                    <div style="color:#7e7e7e">4</div>
                                    <div style="color:#939393">5</div>
                                    <div style="color:#a8a8a8">6</div>  
                                    <div style="color:#bdbdbd">7</div>
                                </div>
                              </div>
                              <div class="col-md-12">
                                  <div class="flex-container">
                                  	<span>Responsible</span>
                                     <div style="color:#3f3f3f">1</div>
                                    <div style="color:#545454">2</div>
                                    <div style="color:#696969">3</div>  
                                    <div style="color:#7e7e7e">4</div>
                                    <div style="color:#939393">5</div>
                                    <div style="color:#a8a8a8">6</div>  
                                    <div style="color:#bdbdbd">7</div>
                                </div>
                              </div>
                              
                              
                              </div>
                            <!-- end progress bar -->
                            <!-- end progress bar -->
                        </div>
                    
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ./Team member -->
            
            
              </div><!-- /Slide2 --> 
            <div class="item">
                  
              </div><!-- /Slide3 --> 
        
        
       
	   
	   <!-- /.control-box -->   
                              
    </div><!-- /#myCarousel -->
        

</section>


   </section>      
        </div>         
         <script src="<c:url value='/resources/js/angular.js' />"></script>
       <script src="<c:url value='/resources/js/angular.min.js' />"></script>
       <script src="<c:url value='/resources/js/angular-animate.js' />"></script>
        <script src="<c:url value='/resources/js/angular-flexslider.js' />"></script> 
        <script src="<c:url value='/resources/js/angular-route.js' />"></script>
         <script src="<c:url value='/resources/js/angular-ui-tree.js' />"></script>
        <script src="<c:url value='/resources/js/peerhuntr.js' />"></script>   
        
 <jsp:include page="footer.jsp" ></jsp:include>

