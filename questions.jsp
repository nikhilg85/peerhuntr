<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<style type="text/css">
.error {
	color: red;
}
</style>
<div ng-controller="PeerController" ng-cloak>
       <jsp:include page="header.jsp"></jsp:include>
               
      <!-- start page title section -->
        <section class="wow fadeIn bg-extra-dark-gray padding-35px-tb page-title-small top-space">
            <div class="container">
                <div class="row equalize">
                    <div class="col-lg-8 col-md-6 col-sm-6 col-xs-12 display-table">
                        <div class="display-table-cell vertical-align-middle text-left xs-text-center">
                            <!-- start page title -->
                            <h1 class="alt-font text-white font-weight-600 no-margin-bottom text-uppercase">Add Question Form</h1>
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
        <section class="wow fadeIn bg-light-gray" style="visibility: visible; animation-name: fadeIn;">
        <form id="addQuestionForm" method="post" enctype="multipart/form-data" name="addQuestionForm" action="javascript:void(0)" ng-submit="addQuestions()" ng-init="getSectionData()"> 
        <div class="container">
        <div class="row">
        <div class="col-md-6 wow fadeIn center-col" style="visibility: visible; animation-name: fadeIn;">
        <div class="padding-fifteen-all bg-white border-radius-6 md-padding-seven-all">
       <!--  <div class="alert alert-success">
    	<strong id="sucess"></strong>  <a href="#" class="alert-link" id="message"></a>.
 		 </div> -->
                            
                <div class="form-group">
    				<label>Sections :</label>
    				<select required  ng-model="section.sectionId" ng-options="s.sectionId as s.sectionName for s in sections" ng-change="getSectionQuestionAnswer()" id="sectionId" >
    						<option value="">-- Select Section --</option>
    				</select>
  			
  				
    				<label>Question Number  :</label>
    				<select id="questionselect"  ng-change="getSectionWithQuestionNumber()"  ng-model="section.questionNumber" ng-options="q.id as (q.index+1) for q in questionData">
    						<option value="">-- Select Question --</option>
    						
						                   </select>
  				
        
                
  				
    				<label>Question :</label>
    				<textarea required name="questionName" id ="questionName" ng-model="section.questionName" rows="4" cols="60"  class="input-bg"  ng-pattern="/^(\D)+$/"  ></textarea>

    				<label><span style='color:red' class="help-inline" ng-show="submitted && addQuestionForm.questionName.$valid">Question is Required</span></label>
                    <label><span style='color:red' class="help-inline" ng-show="submitted && addQuestionForm.questionName.$error.pattern">Numeric not allowed</span></label>
  				</div>
  				
  				
  				
  				<div class="form-group">
    				<label id="{{qualityA}}">Quality {{qualityA}}:</label>
    				<input required type="text"ng-pattern="/^(\D)+$/"  id="answerA" ng-model="question.answerA" name="answerA" size="60"  class="input-bg">
    				
    				<label><span style='color:red' class="help-inline" ng-show="submitted && addQuestionForm.answerA.$valid"">Answer A is Required</span></label>
                    <label><span style='color:red' class="help-inline" ng-show="submitted && addQuestionForm.answerA.$error.pattern">Numeric not allowed</span></label>
  				</div>
  				
  				<div class="form-group">
    				<label id="{{qualityB}}">Quality {{qualityB}} :</label>
    				<input  required  type="text" id="answerB" ng-model="question.answerB" name="answerB" size="60"  class="input-bg" ng-pattern="/^(\D)+$/" >
    				
    				<label><span style='color:red' class="help-inline" ng-show="submitted && addQuestionForm.answerB.$valid"">Answer B is Required</span></label>
                    <label><span style='color:red' class="help-inline" ng-show="submitted && addQuestionForm.answerB.$error.pattern">Numeric not allowed</span></label>
  				</div>
  				
  				<div class="form-group">
  				<button id="question-button" type="submit"  ng-click="submitted=true" class="btn btn-small border-radius-4 btn-dark-gray">Submit</button>
  				</div>
  				
       
  

</div>
</div>
</div>      
</div>
</form>
</section>

<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script> 
          <script src="<c:url value='/resources/js/angular.js' />"></script>
       <script src="<c:url value='/resources/js/angular.min.js' />"></script>
       <script src="<c:url value='/resources/js/angular-animate.js' />"></script>
       <script src="<c:url value='/resources/js/angular-flexslider.js' />"></script>
        <script src="<c:url value='/resources/js/angular-route.js' />"></script>
         <script src="<c:url value='/resources/js/angular-ui-tree.js' />"></script>
       <script src="<c:url value='/resources/js/peerhuntr.js' />"></script>
        <jsp:include page="footer.jsp"></jsp:include>
        
             </div>      