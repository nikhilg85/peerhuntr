  <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Peer Rating</title>
<style>
.checked {
    color: orange;
}
</style>
<script>


</script>
</head>
<body>
 <div ng-app="peerhuntr" ng-controller="RatingController" ng-cloak>
 <jsp:include page="header.jsp"></jsp:include>
 <section>
 <div class="container">
 <div class="row">
 <div class="col-md-12">
 <p style="color:#000;">
 Welcome to the peerHuntr peer rating page!</p>

<p style="margin-bottom:5px; color:#000;">Thank you for taking a short moment to give me a peer rating for my peerHuntr profile.</p> 

<p style="margin-bottom:5px; color:#000;">I would like to ask you to rate me on a score from 1 "star" (never/very low) to 7 "stars" (always/very high) on the below eight parameters.</p>

<p style="margin-bottom:5px; color:#000;">In addition, I would like you to describe in one sentence only how you think of me as a colleague or work partner.</p>

<p style="margin-bottom:5px; color:#000;">Please note that your peer rating and comment will be completely anonymous. So please be honest in your rating of me. In other words, I will not know how you have rated me, but rely on your honest feedback.</p>

<p style="margin-bottom:5px; color:#000;">Thank you very much. </p>
<p style="margin-bottom:5px; color:#000;">Best regards, </p>
<p style="margin-bottom:5px; color:#000;"><%= request.getParameter("name")%></p>
 </div>
 </div>
 </div>
 </section>
<section class="wow fadeIn bg-light-gray" id="section-down">
<form id="peerRatingForm" name="peerRatingForm" method="post" validate ng-submit="submitRating()"  >
            <div class="container" >
                <div class="row equalize sm-equalize-auto">
                    <div class="col-md-6 col-sm-12 col-xs-12 sm-margin-30px-bottom wow fadeInLeft">
                        <div class="padding-ten-all bg-white border-radius-6 md-padding-seven-all xs-padding-30px-all height-100">
                         <input type="hidden" id="referralCode" value=<%= request.getParameter("referralCode") %> >
                         <input type="hidden" id="n" value=<%= request.getParameter("n") %> >
                         
                        <div class="text-extra-dark-gray alt-font text-large font-weight-600 margin-30px-bottom">Rating</div> 
                            <div class="col-md-6">
                                <p style="margin:0;">Honest</p>
								<span class="fa fa-star" id="honest1" ng-init="add('honest',1)" ng-click="add('honest',1)"></span>
								<span class="fa fa-star" id="honest2" ng-click="add('honest',2)"></span>
								<span class="fa fa-star" id="honest3" ng-click="add('honest',3)"></span>
								<span class="fa fa-star" id="honest4" ng-click="add('honest',4)"></span>
								<span class="fa fa-star" id="honest5" ng-click="add('honest',5)"></span>
								<span class="fa fa-star" id="honest6" ng-click="add('honest',6)"></span>
								<span class="fa fa-star" id="honest7" ng-click="add('honest',7)"></span>
                                </div>
                                <div class="col-md-6">
                                <p style="margin:0;">Responsible</p>
								<span class="fa fa-star" id="responsible1" ng-init="add('responsible',1)" ng-click="add('responsible',1)"></span>
								<span class="fa fa-star" id="responsible2" ng-click="add('responsible',2)"></span>
								<span class="fa fa-star" id="responsible3" ng-click="add('responsible',3)"></span>
								<span class="fa fa-star" id="responsible4" ng-click="add('responsible',4)"></span>
								<span class="fa fa-star" id="responsible5" ng-click="add('responsible',5)"></span>
								<span class="fa fa-star" id="responsible6" ng-click="add('responsible',6)"></span>
								<span class="fa fa-star" id="responsible7" ng-click="add('responsible',7)"></span>
                                </div>
                                <div class="col-md-6">
                                <p style="margin:0;">Coachable</p>
								<span class="fa fa-star" id="coachable1" ng-init="add('coachable',1)" ng-click="add('coachable',1)"></span>
								<span class="fa fa-star" id="coachable2" ng-click="add('coachable',2)"></span>
								<span class="fa fa-star" id="coachable3" ng-click="add('coachable',3)"></span>
								<span class="fa fa-star" id="coachable4" ng-click="add('coachable',4)"></span>
								<span class="fa fa-star" id="coachable5" ng-click="add('coachable',5)"></span>
								<span class="fa fa-star" id="coachable6" ng-click="add('coachable',6)"></span>
								<span class="fa fa-star" id="coachable7" ng-click="add('coachable',7)"></span>
                                </div>
                                <div class="col-md-6">
                                <p style="margin:0;">Teamplayer</p>
								<span class="fa fa-star" id="teamplayer1" ng-init="add('teamplayer',1)" ng-click="add('teamplayer',1)"></span>
								<span class="fa fa-star" id="teamplayer2" ng-click="add('teamplayer',2)"></span>
								<span class="fa fa-star" id="teamplayer3" ng-click="add('teamplayer',3)"></span>
								<span class="fa fa-star" id="teamplayer4" ng-click="add('teamplayer',4)"></span>
								<span class="fa fa-star" id="teamplayer5" ng-click="add('teamplayer',5)"></span>
								<span class="fa fa-star" id="teamplayer6" ng-click="add('teamplayer',6)"></span>
								<span class="fa fa-star" id="teamplayer7" ng-click="add('teamplayer',7)"></span>
                                </div>
                                <div class="col-md-6">
                                <p style="margin:0;">Leader</p>
								<span class="fa fa-star" id="leader1" ng-init="add('leader',1)" ng-click="add('leader',1)"></span>
								<span class="fa fa-star" id="leader2" ng-click="add('leader',2)"></span>
								<span class="fa fa-star" id="leader3" ng-click="add('leader',3)"></span>
								<span class="fa fa-star" id="leader4" ng-click="add('leader',4)"></span>
								<span class="fa fa-star" id="leader5" ng-click="add('leader',5)"></span>
								<span class="fa fa-star" id="leader6" ng-click="add('leader',6)"></span>
								<span class="fa fa-star" id="leader7" ng-click="add('leader',7)"></span>
                                </div>
                                <div class="col-md-6">
                                <p style="margin:0;">Energetic</p>
								<span class="fa fa-star" id="energetic1" ng-init="add('energetic',1)" ng-click="add('energetic',1)"></span>
								<span class="fa fa-star" id="energetic2" ng-click="add('energetic',2)"></span>
								<span class="fa fa-star" id="energetic3" ng-click="add('energetic',3)"></span>
								<span class="fa fa-star" id="energetic4" ng-click="add('energetic',4)"></span>
								<span class="fa fa-star" id="energetic5" ng-click="add('energetic',5)"></span>
								<span class="fa fa-star" id="energetic6" ng-click="add('energetic',6)"></span>
								<span class="fa fa-star" id="energetic7" ng-click="add('energetic',7)"></span>
                                </div>
                                <div class="col-md-6">
                                <p style="margin:0;">Innovative</p>
								<span class="fa fa-star" id="innovative1" ng-init="add('innovative',1)" ng-click="add('innovative',1)"></span>
								<span class="fa fa-star" id="innovative2" ng-click="add('innovative',2)"></span>
								<span class="fa fa-star" id="innovative3" ng-click="add('innovative',3)"></span>
								<span class="fa fa-star" id="innovative4" ng-click="add('innovative',4)"></span>
								<span class="fa fa-star" id="innovative5" ng-click="add('innovative',5)"></span>
								<span class="fa fa-star" id="innovative6" ng-click="add('innovative',6)"></span>
								<span class="fa fa-star" id="innovative7" ng-click="add('innovative',7)"></span>
                                </div>
                                <div class="col-md-6">
                                <p style="margin:0;">Emotionally intelligent</p>
								<span class="fa fa-star" id="emotionally intelligent1" ng-init="add('emotionally intelligent',1)" ng-click="add('emotionally intelligent',1)"></span>
								<span class="fa fa-star" id="emotionally intelligent2" ng-click="add('emotionally intelligent',2)"></span>
								<span class="fa fa-star" id="emotionally intelligent3" ng-click="add('emotionally intelligent',3)"></span>
								<span class="fa fa-star" id="emotionally intelligent4" ng-click="add('emotionally intelligent',4)"></span>
								<span class="fa fa-star" id="emotionally intelligent5" ng-click="add('emotionally intelligent',5)"></span>
								<span class="fa fa-star" id="emotionally intelligent6" ng-click="add('emotionally intelligent',6)"></span>
								<span class="fa fa-star" id="emotionally intelligent7" ng-click="add('emotionally intelligent',7)"></span>
                                </div>
                            
                        </div>
                    </div>
                    <div class="col-md-6 col-sm-12 col-xs-12 sm-margin-30px-bottom wow fadeInLeft">

                            
                    <div class="row"> 
                        <div class="col-md-12 wow fadeIn">
                            <div class="padding-ten-all bg-white border-radius-6 md-padding-seven-all">
                                <div class="text-extra-dark-gray alt-font text-large font-weight-600 margin-30px-bottom">Comment</div> 
                                <div>
                                    <div id="success-contact-form-3" class="no-margin-lr"></div>
                                  <input required type="text"  ng-pattern="/^[a-z]+[a-z0-9._]+@[a-z0-9]+\.[a-z.]{1,5}$/" ng-model="email" name="email" id="email" placeholder="Email" class="input-bg" ></input>
                                 <span style='color:red' class="help-inline" ng-show="submitted && peerRatingForm.email.$error.required">Email is Required</span><br/>
                                   <span style='color:red' class="help-inline" ng-show="submitted && peerRatingForm.email.$error.pattern">
  										  Not valid email!
  									</span>
  									
                                 
                                   	  
                                 	 <input required type="DropDown" ng-pattern="/^[a-zA-Z ]*$/" ng-model="name" name="name" id="name" placeholder="Name"  class="input-bg"></input>
                                 	 <span style='color:red' class="help-inline" ng-show="submitted && peerRatingForm.name.$error.required">Name is Required</span><br/>
                                 	 <span style='color:red' class="help-inline" ng-show="submitted && peerRatingForm.name.$error.pattern">
  										  Please enter only characters
  									</span>
  									<!-- /^[a-zA-Z0-9_@.#$=!%^ )]*[a-zA-Z][a-zA-Z0-9_@.#$=!%^)]*$/ -->
  									
   <!--<select name="Relationship between Peer rater & sender" > -->
   <select name = "Relationship ">
   <option>Select your Relationship</option>
    <option>Colleague (current or former)</option>          
    <option>Subordinate (current or former)</option>  
    <option>Superior (current or former)</option>
    <option>Professional work partner (not colleagues)</option>      
    <option> Friend</option>  
    <option>Relative</option>
       
       
       <select name required type="DropDown" ng-model="Select your Relationship" name="Select your Relationship" id="Select your Relationship" placeholder="Select your Relationship"  class="input-bg"></input>
                                 	 <span style='color:red' class="help-inline" ng-show="submitted && peerRatingForm.name.$error.required">Relationship is Required</span><br/>
                                 	 <span style='color:red' class="help-inline" ng-show="submitted && peerRatingForm.name.$error.pattern">
  										  Please Select the Relationship
  									</span>
    
    </select>   
  
  									
                                     <textarea required ng-pattern="/^[a-zA-Z0-9_@.#$=!%:*/,?'()^ )]*[a-zA-Z][a-zA-Z0-9_@.#$=!%:*/,?'()^)]*$/" maxlength="100" ng-model="comment" name="comment" id="comments" placeholder="Your Comments" class="input-bg"></textarea>
<!--                                       <span style='color:red' class="help-inline" ng-show="submitted && peerRatingForm.comment.$error.required">Comment is Required</span><br/>
 -->                                       <span style='color:red' class="help-inline" ng-show="submitted && peerRatingForm.comment.$error.pattern">
  										  Atleast one character should be present (_@.#$=!%:*/,?'() only allowed)
  									</span>
                                      <br/>
                                    <button id="contact-us-button-3" type="submit"  ng-click="submitted=true" class="btn btn-small border-radius-4 btn-black">Submit</button>
                                </div>
                            </div>
                        </div>
                    </div>
             <%--  Welcome to the peerHuntr peer rating page!</p>

<p style="margin-bottom:5px; color:#000;">Thank you for taking a short moment to give me a peer rating for my peerHuntr profile.</p> 

<p style="margin-bottom:5px; color:#000;">I would like to ask you to rate me on a score from 1 "star" (never/very low) to 7 "stars" (always/very high) on the below eight parameters.</p>

<p style="margin-bottom:5px; color:#000;">In addition, I would like you to describe in one sentence only how you think of me as a colleague or work partner.</p>

<p style="margin-bottom:5px; color:#000;">Please note that your peer rating and comment will be completely anonymous. So please be honest in your rating of me. In other words, I will not know how you have rated me, but rely on your honest feedback.</p>

<p style="margin-bottom:5px; color:#000;">Thank you very much. </p>
<p style="margin-bottom:5px; color:#000;">Best regards, </p>
<p style="margin-bottom:5px; color:#000;"><%= request.getParameter("name")%></p> --%>
                            
                        
                    </div>
                </div>
            </div>
            </form>
        </section>
           <script src="<c:url value='/resources/js/angular.js' />"></script>
       <script src="<c:url value='/resources/js/angular.min.js' />"></script>
       <script src="<c:url value='/resources/js/angular-animate.js' />"></script>
        <script src="<c:url value='/resources/js/angular-flexslider.js' />"></script> 
        <script src="<c:url value='/resources/js/angular-route.js' />"></script>
         <script src="<c:url value='/resources/js/angular-ui-tree.js' />"></script>
        <script src="<c:url value='/resources/js/peerhuntr.js' />"></script>   
         <jsp:include page="footer.jsp"></jsp:include>
         </div>
</body>
</html>