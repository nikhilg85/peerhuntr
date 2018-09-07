<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html >
  
       <jsp:include page="header.jsp"></jsp:include>
        <!-- start page title section -->
        <section class="wow fadeIn bg-extra-dark-gray padding-35px-tb page-title-small ">
            <div class="container">
                <div class="row equalize">
                    <div class="col-lg-8 col-md-6 col-sm-6 col-xs-12 display-table">
                        <div class="display-table-cell vertical-align-middle text-left xs-text-center">
                            <!-- start page title -->
                            <h1 class="alt-font text-white font-weight-600 no-margin-bottom text-uppercase">Thank you Form</h1>
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
        
        <!-- start form style 03 section -->
         <section class="wow fadeIn bg-light-gray">
            <div class="container">
                
                <form id="contact-form-3" action="javascript:void(0)" method="post">
                    <div class="row"> 
                        <div class="col-md-6 wow fadeIn center-col">
                            <div class="padding-fifteen-all bg-white border-radius-6 md-padding-seven-all">
                                <h2>Thank You</h2> 
                                <div>
                                    <div id="success-contact-form-3" class="no-margin-lr"></div>
                                    <p style="text-align:justify;">Thank you very much for your peer rating.</p>
									<p style="text-align:justify;">
									If you would like to also create your peerHuntr profile card and learn more about your own professional character, please access the following link: <a href='www.peerhuntr.com'style='color:blue'> www.peerhuntr.com </a> or download the peerHuntr app from the Apple Store (iOS) or Google Play (Android)."</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>     
        </section>
        <!-- end form style 02 section -->
        <jsp:include page="footer.jsp"></jsp:include>
    