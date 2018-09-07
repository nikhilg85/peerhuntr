 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!doctype html>
 <jsp:include page="header.jsp" ></jsp:include>
 <body ng-controller="PersonalityController">

<!-- start page title section -->
        <section class="wow fadeIn bg-extra-dark-gray padding-35px-tb page-title-small ">
            <div class="container">
                <div class="row equalize">
                    <div class="col-lg-8 col-md-6 col-sm-6 col-xs-12 display-table">
                        <div class="display-table-cell vertical-align-middle text-left xs-text-center">
                            <!-- start page title -->
                            <h1 class="alt-font text-white font-weight-600 no-margin-bottom text-uppercase">Personality Test Instructions</h1>
                            <!-- end page title -->
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12 display-table text-right xs-text-left xs-margin-10px-top">
                        <div class="display-table-cell vertical-align-middle breadcrumb text-small alt-font">
                            <!-- start breadcrumb -->
                            <ul class="xs-text-center">
                                <li><a href='<spring:url value="/home"/>' class="text-dark-gray">Home</a></li>
                                <li class="text-dark-gray">Personality Test Instructions</li>
                            </ul>
                            <!-- end breadcrumb -->
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- end page title section -->
        
     <%--   user attribute <%=  request.getAttribute("user") %>;
       user header <%=  request.getHeader("user") %>;
       response user  <%=  response.getHeader("user")%>; --%>
           
        <section class="parallax wow fadeIn" data-stellar-background-ratio="0.4" style="background-image: url(&quot;resources/images/parallax-bg21.jpg&quot;); visibility: visible; animation-name: fadeIn;">
            <div class="container">
                
                <div class="row equalize xs-equalize-auto">
                    <!-- start features box item -->
                    <div class="col-md-7 col-sm-7 col-xs-7 center-col sm-margin-four-bottom xs-margin-30px-bottom wow fadeInUp last-paragraph-no-margin" style="visibility: visible; animation-name: fadeInUp;">
                        <div class="border-color-extra-medium-gray border-solid border-width-1 padding-eighteen-tb border-radius-4 position-relative inner-match-height padding-40px-all" style="background:#fff; -webkit-box-shadow: 5px 7px 9px -4px rgb(158, 158, 158); -moz-box-shadow: 5px 7px 9px -4px rgb(158, 158, 158);
    box-shadow: 5px 7px 9px -4px rgb(158, 158, 158);">
    
    
    
    <h5 style="color:#7bd10d;">Welcome to the peerHuntr personality test!</h5>
    <p>The test is based on the different personality types proposed by the Swiss psychologist Carl Jung in his book <q>Psychological Types</q>. There are sixteen different psychological types in the peerHuntr personality test.</p>
    <p>The test is composed of 28 questions, each having 2 answer options. Each option constitutes a preference related to the question. It should only take around 5 minutes to complete the test.</p>
    <p>There are no right and wrong answers in the personality test. Your answers should therefore be honest and intuitive. Do not think too long and hard. Just go with your instinct. This will provide the most authentic test result.</p>
    <p>&nbsp;</p>
    <h5 style="color:#7bd10d;">Let's get started!</h5>
    
                            <input type="hidden" class="btn btn-very-small btn-black md-margin-15px-bottom sm-display-table sm-margin-lr-auto" id="userId" value=<%= request.getParameter("user") %> >
<button  class="btn btn-very-small btn-black md-margin-15px-bottom sm-display-table sm-margin-lr-auto" ng-click="personalityTest()"> Start Test</button>
                        </div>
                        
                    </div>
                    <!-- end features box item -->
                    
                </div>
            </div>
            
        </section>
        
        <section class="wow fadeIn" style="padding-top:0;">
            <div class="container">
                <div class="row equalize sm-equalize-auto">
                    
                    <div class="col-md-7 col-sm-7 col-xs-7 center-col">
                           
                           
                           
                        
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
      <jsp:include page="footer.jsp" ></jsp:include>

 </body>    
  