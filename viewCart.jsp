<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html >

<html class="no-js" lang="en">
<div ng-app="peerhuntr" ng-controller="PeerController" ng-cloak>
       <jsp:include page="header.jsp"></jsp:include>

    <section class="wow fadeIn bg-extra-dark-gray padding-35px-tb page-title-small ">
            <div class="container">
                <div class="row equalize">
                    <div class="col-lg-8 col-md-6 col-sm-6 col-xs-12 display-table">
                        <div class="display-table-cell vertical-align-middle text-left xs-text-center">
                            <!-- start page title -->
                            <h1 class="alt-font text-white font-weight-600 no-margin-bottom text-uppercase">My Cart</h1>
                            <!-- end page title -->
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12 display-table text-right xs-text-left xs-margin-10px-top">
                        <div class="display-table-cell vertical-align-middle breadcrumb text-small alt-font">
                            <!-- start breadcrumb -->
                            <ul class="xs-text-center">
                                <li><a href="#" class="text-dark-gray">Home</a></li>
                                <li class="text-dark-gray">Cart</li>
                            </ul>
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
           
                <div class="row panel padding-50px-all">
              
	<table id="cart" class="table table-hover table-condensed" ng-init="viewAllCart()">
    				<thead>
    		          
						<tr>
							<th style="width:50%">Profile</th>
							<th style="width:10%">Price</th>
							<th style="width:8%"></th>
							<th style="width:22%" class="text-center"></th>
							<th style="width:10%">Delete</th>
						</tr>
					</thead>
				
			        <tbody ng-repeat="cart in allCartData" >
				       <div id="loading" > </div>  
				       
					   <tr  id={{usercarData.userId}}    ng-repeat="usercarData in cart" >
					
							<td data-th="Product" >
								<div class="row" ng-if="usercarData.firstName">
									<div class="col-sm-2 hidden-xs"  ng-repeat="image in usercarData.profileImages">
									
								  <img src="{{image.hiddenImageUrl}}"/>
							
									</div>
									<div class="col-sm-10">
										<h6 ng-cloak style="margin:0;">  {{usercarData.firstName|uppercase| limitTo : 1 : 0}}. {{usercarData.lastName |uppercase| limitTo : 1 : 0}}.</h6>
										<p ng-cloak style="margin:0;">{{usercarData.personalityMaster.personalityRole}}</p>
										
									</div>
								</div>
							</td>
							<td data-th="Price" ng-cloak ng-if="usercarData.firstName">{{100}}</td>
							<td data-th="Quantity">
								<!-- <input type="number" class="form-control text-center" value="1"> -->
								
							</td>
							<td data-th="Subtotal" class="text-center"></td>
							<td class="actions" data-th="">
							<div ng-repeat="cart in usercarData.userCarts1">
								
								<button  class="btn btn-danger btn-sm" ng-if=" usercarData.userCarts1" ng-click="deleteCart(cart,usercarData.userId)"><i class="fa fa-trash-o"></i></button>	
							</div>							
							</td>
							
						</tr>
						
                      
					</tbody>

              		<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong></strong></td>
						</tr>
						<tr>
							<td><a href="/peerhuntr/home" class="btn btn-info"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs">Total:{{300}}</td>
							<td class="hidden-xs text-center"><strong></strong></td>
							<td><a href="/peerhuntr/underProcess" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
						</tr>
					</tfoot>
				</table>
</div>
                
            </div>     
        </section>
        <!-- end form style 02 section -->




	<!-- end info banner style 01 section -->
	  
        </div>
          <script src="<c:url value='/resources/js/angular.js' />"></script>
       <script src="<c:url value='/resources/js/angular.min.js' />"></script>
       <script src="<c:url value='/resources/js/angular-animate.js' />"></script>
        <script src="<c:url value='/resources/js/angular-flexslider.js' />"></script> 
        <script src="<c:url value='/resources/js/angular-route.js' />"></script>
         <script src="<c:url value='/resources/js/angular-ui-tree.js' />"></script>
        <script src="<c:url value='/resources/js/peerhuntr.js' />"></script>    
  <jsp:include page="footer.jsp"></jsp:include>     
