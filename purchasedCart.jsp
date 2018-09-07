<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html class="no-js" lang="en">
  
       <jsp:include page="header.jsp"></jsp:include>
        <!-- start page title section -->
        <section class="wow fadeIn bg-extra-dark-gray padding-35px-tb page-title-small ">
            <div class="container">
                <div class="row equalize">
                    <div class="col-lg-8 col-md-6 col-sm-6 col-xs-12 display-table">
                        <div class="display-table-cell vertical-align-middle text-left xs-text-center">
                            <!-- start page title -->
                            <h1 class="alt-font text-white font-weight-600 no-margin-bottom text-uppercase">Purchased cart</h1>
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
        
          <section class="parallax wow fadeIn" data-stellar-background-ratio="0.4" style="background-image: url(&quot;images/parallax-bg21.jpg&quot;); visibility: visible; animation-name: fadeIn;">
        
        <div class="row">
                    <div class="col-md-7 col-sm-12 col-xs-12 center-col text-center margin-100px-bottom xs-margin-40px-bottom">
                        <div class="position-relative overflow-hidden">
                            <span class="text-big text-outside-line-full alt-font font-weight-600 text-uppercase">Purchased Profile Cards</span>
                        </div>
                    </div>
                </div>


       <section id="team" class="pb-5">
    <div class="">
        <div class="">
            <div class="item active">
                    <!-- Team member -->
            <div class="col-md-3" >
                <div class="image-flip" ontouchstart="this.classList.toggle('hover');" >
                    <div class="mainflip">
                        <div class="frontside">
                            <div class="card" style="background-color:#0c7bd3;">
                                <div class="card-body padding-10px-top">
                                    
            <div class=" padding-10px-all">
                <div class="row">
                    <div class="col-sm-6 col-md-4">
                        <img src="<c:url value='/resources/images/3.jpg'/>" alt="" class="img-responsive" />
                        
                        <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/personality.png'/>" style="width:auto; height:auto;"> Analyst</p>
                            <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/rating.png'/>" style="width:auto; height:auto;"> 3.5/8</p>
                    </div>
                    <div class="col-sm-6 col-md-8">
                    <h4 style="margin:0; color:#fff;">Johne S.</h4>
                        <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/nationality.png'/>" style="width:auto; height:auto;"> Indian</p>
                            <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/age.png'/>" style="width:auto; height:auto;"> 25 Years</p>
                            <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/education.png'/>" style="width:auto; height:auto;"> B. Tech, Computer Science.</p>
                            
                        
                    </div>
                </div>
            </div>
        
                                </div>
                            </div>
                        </div>
                        <div class="backside">
                            <div class="card" style="background-color:#0c7bd3;">
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
            <!-- ./Team member -->
            <!-- Team member -->
            <div class="col-md-3">
                <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                    <div class="mainflip">
                        <div class="frontside">
                            <div class="card" style="background-color:#ffd03e;">
                                <div class="card-body padding-10px-top">
                                    
            <div class=" padding-10px-all">
                <div class="row">
                    <div class="col-sm-6 col-md-4">
                        <img src="<c:url value='/resources/images/4.jpg'/>" alt="" class="img-responsive" />
                        
                        <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/personality.png'/>" style="width:auto; height:auto;"> Analyst</p>
                            <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/rating.png'/>" style="width:auto; height:auto;"> 3.5/8</p>
                    </div>
                    <div class="col-sm-6 col-md-8">
                    <h4 style="margin:0; color:#fff;">Johne S.</h4>
                        <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/nationality.png'/>" style="width:auto; height:auto;"> Indian</p>
                            <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/age.png'/>" style="width:auto; height:auto;"> 25 Years</p>
                            <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/education.png'/>" style="width:auto; height:auto;"> B. Tech, Computer Science.</p>
                            
                        
                    </div>
                </div>
            </div>
        
                                </div>
                            </div>
                        </div>
                        <div class="backside">
                            <div class="card" style="background-color:#ffd03e;">
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
            <!-- ./Team member -->
            <!-- Team member -->
            <div class="col-md-3" >
                <div class="image-flip" ontouchstart="this.classList.toggle('hover');" >
                    <div class="mainflip">
                        <div class="frontside">
                            <div class="card" style="background-color:#4cbb17;">
                                <div class="card-body padding-10px-top">
                                    
            <div class=" padding-10px-all">
                <div class="row">
                    <div class="col-sm-6 col-md-4">
                        <img src="<c:url value='/resources/images/2.jpg'/>" alt="" class="img-responsive" />
                        
                        <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/personality.png'/>" style="width:auto; height:auto;"> Analyst</p>
                            <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/rating.png'/>" style="width:auto; height:auto;"> 3.5/8</p>
                    </div>
                    <div class="col-sm-6 col-md-8">
                    <h4 style="margin:0; color:#fff;">Johne S.</h4>
                        <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/nationality.png'/>" style="width:auto; height:auto;"> Indian</p>
                            <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/age.png'/>" style="width:auto; height:auto;"> 25 Years</p>
                            <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/education.png'/>" style="width:auto; height:auto;"> B. Tech, Computer Science.</p>
                            
                        
                    </div>
                </div>
            </div>
        
                                </div>
                            </div>
                        </div>
                        <div class="backside">
                            <div class="card" style="background-color:#4cbb17;">
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
            <!-- ./Team member -->
            <!-- Team member -->
            <div class="col-md-3">
                <div class="image-flip" ontouchstart="this.classList.toggle('hover');">
                    <div class="mainflip">
                        <div class="frontside">
                            <div class="card" style="background-color:#f34135;">
                                <div class="card-body padding-10px-top">
                                    
            <div class=" padding-10px-all">
                <div class="row">
                    <div class="col-sm-6 col-md-4">
                        <img src="<c:url value='/resources/images/1.jpg'/>" alt="" class="img-responsive" />
                        
                        <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/personality.png'/>" style="width:auto; height:auto;"> Analyst</p>
                            <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/rating.png'/>" style="width:auto; height:auto;"> 3.5/8</p>
                    </div>
                    <div class="col-sm-6 col-md-8">
                    <h4 style="margin:0; color:#fff;">Johne S.</h4>
                        <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/nationality.png'/>" style="width:auto; height:auto;"> Indian</p>
                            <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/age.png'/>" style="width:auto; height:auto;"> 25 Years</p>
                            <p style="margin: 0 0 5px; color:#fff; font-size:12px;">
                            <img src="<c:url value='/resources/images/education.png'/>" style="width:auto; height:auto;"> B. Tech, Computer Science.</p>
                            
                        
                    </div>
                </div>
            </div>
        
                                </div>
                            </div>
                        </div>
                        <div class="backside">
                            <div class="card" style="background-color:#f34135;">
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
            <!-- ./Team member -->
            <!-- /Slide1 --> 
            <div class="item">
                    <!-- Team member -->
            
            
              </div><!-- /Slide2 --> 
            <div class="item">
                    
            
              </div><!-- /Slide3 --> 
        </div>
        
       
	   
	   <!-- /.control-box -->   
                              
    </div><!-- /#myCarousel -->
        

</section>


   </section>         

        <!-- end form style 02 section -->
           
         <script src="<c:url value='/resources/js/angular.js' />"></script>
       <script src="<c:url value='/resources/js/angular.min.js' />"></script>
       <script src="<c:url value='/resources/js/angular-animate.js' />"></script>
        <script src="<c:url value='/resources/js/angular-flexslider.js' />"></script> 
        <script src="<c:url value='/resources/js/angular-route.js' />"></script>
         <script src="<c:url value='/resources/js/angular-ui-tree.js' />"></script>
        <script src="<c:url value='/resources/js/peerhuntr.js' />"></script>   
        

<jsp:include page="footer.jsp"></jsp:include>
      
       
    </body>

</html>