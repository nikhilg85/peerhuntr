<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!doctype html>
<html class="no-js" lang="en" ng-app="peerhuntr">
    
<head>

        <!-- title -->
        <title>peerHuntr</title>
        <meta charset="utf-8">
      
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
          <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1" />
        <meta name="author" content="ThemeZaa">
        <!-- description -->
        <meta name="description" content="">
        <!-- keywords -->
        <meta name="keywords" content="">
        <!-- favicon -->
      <link rel="shortcut icon" href="<c:url value='/resources/images/favicon.png' />">
		<link rel="apple-touch-icon" href="<c:url value='/resources/images/apple-touch-icon-57x57.png' />">
		<link rel="apple-touch-icon" sizes="72x72" href="<c:url value='/resources/images/apple-touch-icon-72x72.png' />">
		<link rel="apple-touch-icon" sizes="114x114" href="<c:url value='/resources/images/apple-touch-icon-114x114.png' />">
        <!-- animation -->
        <link rel="stylesheet" href="<c:url value='/resources/css/animate.css' />">
         
        <!-- bootstrap -->
         <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css' />">
        <!-- et line icon --> 
        <link rel="stylesheet" href="<c:url value='/resources/css/et-line-icons.css' />">
        <!-- font-awesome icon -->
        <link rel="stylesheet" href="<c:url value='/resources/css/font-awesome.min.css' />">        <!-- themify icon -->
           <!-- themify icon -->
      <link rel="stylesheet" href="<c:url value='/resources/css/themify-icons.css'/>">
        <!-- swiper carousel -->
       <link rel="stylesheet" href="<c:url value='/resources/css/swiper.min.css'/>">
        <!-- justified gallery  -->
        <link rel="stylesheet" href="<c:url value='/resources/css/justified-gallery.min.css'/>">
        <!-- magnific popup -->
        <link rel="stylesheet" href="<c:url value='/resources/css/magnific-popup.css' />">
       <!-- revolution slider -->
        <link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/resources/revolution/css/settings.css'/>">
       <link rel="stylesheet" type="text/css" href="<c:url value='/resources/revolution/css/layers.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/resources/revolution/css/navigation.css'/>">
        <!-- bootsnav -->
        <link rel="stylesheet" href="<c:url value='/resources/css/bootsnav.css'/>">
        <!-- style -->
       <link rel="stylesheet" href="<c:url value='/resources/css/style.css' />">
       <!-- card -->
       <link rel="stylesheet" href="<c:url value='/resources/css/card.css' />">
       <link rel="stylesheet" href="<c:url value='/resources/css/new-card.css' />">
        <!-- responsive css -->
        <link rel="stylesheet" href="<c:url value='/resources/css/responsive.css' />">
        <!--[if IE]>
            <script src="js/html5shiv.js"></script>
        <![endif]-->
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">
      
<%--         <link rel="stylesheet" type="text/css"   href="<c:url value='/resources/css/slideviewer.css' />"/>
 --%>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
 <!-- <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/themes/smoothness/jquery-ui.min.css" rel="stylesheet" type="text/css" />  -->
  <link rel="stylesheet" href="<c:url value='/resources/css/jquery-ui.min.css' />"> 
   <link rel="stylesheet" href="<c:url value='/resources/css/password-icon.css' />">
 <script>
 window.history.forward();
	function noBack() { window.history.forward(); }
</script>
<style>

/*----model css--*/


.has-overlay {
  overflow: hidden;
}
.has-overlay > body {
  height: 100%;
  overflow-y: scroll;
}

.semantic-content {
  -webkit-transform: translate(0, 100%);
  -moz-transform: translate(0, 100%);
  -o-transform: translate(0, 100%);
  -ms-transform: translate(0, 100%);
  transform: translate(0, 100%);
  -webkit-transform: translate3d(0, 100%, 0);
  transform: translate3d(0, 100%, 0);
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: 999;
  opacity: 0;
  color: #fff;
  line-height: 1.3;
  display: none\9;
}
.semantic-content:target {
  -webkit-transform: translate(0, 0);
  -moz-transform: translate(0, 0);
  -o-transform: translate(0, 0);
  -ms-transform: translate(0, 0);
  transform: translate(0, 0);
  opacity: 1;
}
.is-active.semantic-content {
  display: block\9;
}
.semantic-content .modal-inner {
  position: absolute;
  top: 50px;
  left: 40%;
  z-index: 20;
  /*margin-left: -325px;
  width: 650px;
  overflow-x: hidden;
  border-radius: 2px;
  background: #fff;*/
  -webkit-box-shadow: 0 0 30px rgba(0, 0, 0, 0.6);
  box-shadow: 0 0 30px rgba(0, 0, 0, 0.6);
}
.semantic-content .modal-inner > img,
.semantic-content .modal-inner > video,
.semantic-content .modal-inner > iframe {
  width: 100%;
  /*height: auto;
  min-height: 300px;*/
}
.semantic-content .modal-inner > img {
  width: auto;
  max-width: 100%;
}
/*.semantic-content header {
  border-bottom: 1px solid #dddddd;
  padding: 0 1.2em;
}
.semantic-content header > h2 {
  margin: 0.5em 0;
}
.semantic-content .modal-content {
  max-height: 400px;
  max-height: 70vh;
  border-bottom: 1px solid #dddddd;
  padding: 15px 1.2em;
  overflow-x: hidden;
  overflow-y: auto;
}
.semantic-content .modal-content > * {
  max-width: 100%;
}
.semantic-content footer {
  border-top: 1px solid white;
  padding: 0 1.2em 18px;
  background: #f0f0f0;
  border-radius: 2px;
}*/
.semantic-content .modal-close {
  display: block;
  text-indent: -100px;
  overflow: hidden;
}
.semantic-content .modal-close:before {
  content: '';
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: 10;
  background: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAEElEQVR42gEFAPr/AAAAAMwA0QDNTiUx4gAAAABJRU5ErkJggg==");
}
.semantic-content .modal-close:after {
  content: 'x';
  position: absolute;
  top: 25px;
  left: 40%;
  z-index: 20;
  /*margin-left: 285px;*/
  background: #fff;
  border-radius: 2px;
  padding: 2px 8px;
  font-size: 1.2em;
  text-decoration: none;
  text-indent: 0;
}
@media screen and (max-width: 690px) {
  .semantic-content .modal-inner {
    width: auto;
    left: 20px;
    right: 20px;
    margin-left: 0;
  }
  .semantic-content .modal-close {
    left: auto;
    right: 33px;
    margin-left: 0;
  }
  .semantic-content .modal-close:after {
    margin-left: 40%;
  }
}
@media screen and (max-width: 30em) {
  .semantic-content {
    -webkit-transform: translate(0, 400px);
    -webkit-transform: translate3d(0, 100%, 0);
    transform: translate3d(0, 100%, 0);
    -webkit-transition: -webkit-transform 0.25s ease-in-out, opacity 1ms 0.25s;
    -moz-transition: -moz-transform 0.25s ease-in-out, opacity 1ms 0.25s;
    -o-transition: -o-transform 0.25s ease-in-out, opacity 1ms 0.25s;
    -ms-transition: -ms-transform 0.25s ease-in-out, opacity 1ms 0.25s;
    transition: transform 0.25s ease-in-out, opacity 1ms 0.25s;
    display: block;
    height: 100%;
    bottom: auto;
  }
  .semantic-content:target {
    -webkit-transition: -webkit-transform 0.25s ease-in-out;
    -moz-transition: -moz-transform 0.25s ease-in-out;
    -o-transition: -o-transform 0.25s ease-in-out;
    -ms-transition: -ms-transform 0.25s ease-in-out;
    transition: transform 0.25s ease-in-out;
  }
  .semantic-content:before {
    background-color: #27aae2;
    background-image: -webkit-gradient(linear, left top, left bottom, from(#27aae2), to(#1c9cd3));
    background-image: -webkit-linear-gradient(top, #27aae2, #1c9cd3);
    background-image: -moz-linear-gradient(top, #27aae2, #1c9cd3);
    background-image: -o-linear-gradient(top, #27aae2, #1c9cd3);
    background-image: linear-gradient(to bottom, #27aae2, #1c9cd3);
    content: '';
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    z-index: 30;
    height: 3em;
    -webkit-box-shadow: 0 0 5px rgba(0, 0, 0, 0.6);
    box-shadow: 0 0 5px rgba(0, 0, 0, 0.6);
  }
  .semantic-content .modal-inner {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
    top: 0;
    left: 0;
    right: 0;
    padding-top: 3em;
    height: 100%;
    overflow: scroll;
    -webkit-box-shadow: none;
    box-shadow: none;
  }
  .semantic-content .modal-content {
    max-height: none;
  }
  .semantic-content .modal-close {
    right: auto;
    text-decoration: none;
  }
  .semantic-content .modal-close:before {
    display: none;
  }
  .semantic-content .modal-close:after {
    content: 'Close';
    top: 0.4em;
    left: 1em;
    z-index: 40;
    margin-left: 0;
    font-size: 1em;
    padding: 0.5em 1em;
  }
}
@media screen and (max-height: 46em) and (min-width: 30em) {
  .semantic-content .modal-content {
    max-height: 340px;
    max-height: 50vh;
  }
}
@media screen and (max-height: 36em) and (min-width: 30em) {
  .semantic-content .modal-content {
    max-height: 265px;
    max-height: 40vh;
  }
}

@media screen and (min-width: 30em) {
  .semantic-content {
    -webkit-transition: opacity 0.4s;
    -o-transition: opacity 0.4s;
    transition: opacity 0.4s;
  }
}
</style>
  </head>
    <body onload="noBack();" 
	onpageshow="if (event.persisted) noBack();" onunload="" >   
        <!-- start header -->
        <header>
            <!-- start navigation -->
            <nav class="navbar navbar-default bootsnav bg-transparent navbar-scroll-top nav-box-width header-light" style="background-color:#7bd10d;">
                <div class="container-fluid nav-header-container">
                    <div class="row">
                       
                        <div class="col-md-7 col-xs-2 width-auto pull-right accordion-menu xs-no-padding-right">
                       
                        <div class="navbar-header">
                            <button type="button" id="sidebarCollapse" class="btn btn-default navbar-btn" style="background-color:#7bd10d; color:#FFF;">
                                <i class="glyphicon glyphicon-align-left"></i>
                            </button>
                        </div>
		               
                            <!-- Sidebar Holder -->
            <div id="sidebar">
                <div id="dismiss">
                    <i class="glyphicon glyphicon-arrow-left"></i>
                </div>




                <div class="sidebar-header">
                    <a href="#" title="" class="img-responsive"><img src="<c:url value='/resources/images/logo-update.png' />"></a>
                </div>

                <ul class="list-unstyled components">
             
         
				
             
                   
                   <li class="active">
                        <a href='<spring:url value="/home"/>'><img  src="<c:url value='/resources/images/home.png' />">Home</a>
                    </li>
                   
                       <sec:authorize access="hasRole('ROLE_ANONYMOUS')"> 
                    <li>
                        <a href='<spring:url value="/login"/>'><img style="width:25px;" src="<c:url value='/resources/images/Login@3x.png' />">Login</a>
                    </li>
                    </sec:authorize>
                     <sec:authorize access="hasRole('ROLE_USER')"> 
                  
                  
                    <li>
                        <a href='<spring:url value="/dashboard/myProfile"/>'><img  src="<c:url value='/resources/images/MyProfile.png' />">My Profile</a>
                    </li>
                      <li>
                        <a href='<spring:url value="/personalityTestInfo"/>'><img  src="<c:url value='/resources/images/TakeTest.png' />">Take Test Again</a>
                    </li>
                    <li>
                        <a href='<spring:url value="/dashboard/purchasedCart"/>'><img src="<c:url value='/resources/images/purchased-profile-48.png' />" style="width:31px;">Purchased Card</a>
                    </li>
                      </sec:authorize>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li>
                    	 <a href='<spring:url value="/admin/questions"/>' ><img  src="<c:url value='/resources/images/TakeTest.png' />">Add Questions</a>
					</li>
					    
                    </sec:authorize>  
                    <li>
                        <a href='<spring:url value="/contactUs"/>'><img  src="<c:url value='/resources/images/contact.png' />">Contact Us</a>
                    </li>       
                     <li>
                        <a href='<spring:url value="/termsNcondition"/>'><img  src="<c:url value='/resources/images/TermsAndCondition.png' />">Terms & Conditions</a>
                    </li>
                     <li>
                        <a href='<spring:url value="/commercialTerms"/>'><img  src="<c:url value='/resources/images/15.png' />">Commercial Terms</a>
                    </li>     
                    <li>
                        <a href='<spring:url value="/privacyNpolicy"/>'><img  src="<c:url value='/resources/images/PrivacyPolicy.png' />">Privacy Policy</a>
                    </li>
                    <li>
                        <a href='<spring:url value="/aboutUs"/>'><img  src="<c:url value='/resources/images/about-48.png' />" style="width:32px;">About Us</a>
                    </li>
                   
                </ul>

                
            </div>
                        </div>
                         <!-- start logo -->
                        <div class="col-md-2 col-xs-5 center-logo">
                            <a href='<spring:url value="/home"/>' title="" class="logo"><img src="<c:url value='/resources/images/logo.png'/>" class="logo-dark default" alt=""><img src="<c:url value='/resources/images/logo-white.png'/>"  alt="" class="logo-light"></a>
                        </div>
                        <!-- end logo -->
                        <div class="col-md-2 col-xs-5 width-auto">
                           
                             <sec:authorize access="hasAnyRole('ROLE_USER')">
                            <div class="btn-group dropdown-style-1 header-social-icon xs-display-none display-inline-block">
                                <div class="btn dropdown-toggle xs-width-100" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="ti-shopping-cart"></i> <span class="caret"></span> <span id="caratCount"></span>
                                </div>
                                <ul class="dropdown-menu dropdown-cart">
                  
				                  <div id="bag" ng-init="getUserCart()" ng-controller="PeerController">
				                
				                  
				                  </div>
				            
				              <li class="divider"></li>
				         
				              <li><a class="text-center" href ng-click="viewCart()"  >View Cart</a></li>
				                                </ul>
                            </div>
                              </sec:authorize>
                            
                           
                            
                             <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
                            <div class="btn-group dropdown-style-1 header-social-icon xs-display-none display-inline-block">
                                <div class="btn dropdown-toggle xs-width-100" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-user"></i> <span class="caret"></span>
                                </div>
                               
                                <ul class="dropdown-menu xs-width-100">
                                	<li><a href='<spring:url value="/dashboard/myProfile"/>' style="text-transform: capitalize"><span class="icon-country"></span>HELLO  <sec:authentication property="principal.name" /> </a></li>
                                    <li><a href='<spring:url value="/dashboard/updateCustomer"/>'><span class="icon-country"></span>Update Profile</a></li>
                                    <li><a href='<spring:url value="/dashboard/resetPassword"/>'><span class="icon-country"></span>Reset Password</a></li>
                                    <li><a href='<spring:url value="/logout"/>'><span class="icon-country"></span>Logout</a></li>
                                </ul>
                               
                            </div>
                             </sec:authorize>
                            
                    </div>
                </div>
                </div>
        </nav>
            <!-- end navigation --> 
        </header>   
        <!-- end header -->