var peerhuntr = angular.module('peerhuntr',['lazy-scroll']);
peerhuntr.directive("datepicker", function () {
    return {
        restrict: "A",
        link: function (scope, el, attr) {
            el.datepicker({
                           // dateFormat: 'dd.mm.yy'
            				dateFormat: 'yy-mm-dd',
            				changeMonth: true,
            				 changeYear: true,
            				 yearRange: "1900:",
            				 maxDate: new Date(),
            				 
                        });
        }
    };
})
peerhuntr.controller('PeerController',['$rootScope','$scope','PeerService', function ($rootScope,$scope,PeerService){	
	$scope.submitted = false;
	$rootScope.userInfo={};
	var imagesrc="";
	 var filerParameter;
	var pageNo=1; 

	var pageNo=0;
	var pageSize=20;
	$scope.userSelectData=[];
	var reachLast = false; // to check the page ends last or not
	var totalPage=0;
	var requestDTO;
	var b=false;
	var sorByRatingVal='';
	var filterVal='';
	var filterParam='';
	$scope.ratingColors=['#bbbbbb',	'#bbbbbb','#bbbbbb','#bbbbbb','#bbbbbb','#bbbbbb','#bbbbbb'];
	$scope.lastOpenedSide;
	$scope.side;
	var s=false;
	var search="";
	  angular.element(document.querySelector("#userData")).bind('scroll', function(){
	      alert('scrolling is cool!');
	    })
	    
	
	$scope.addQuestions = function() {
		$scope.submitted = true;
		PeerService.addQuestions($scope.section)
		.then 
		(function success(response){
			
			 $scope.data = response.data;
       	  if($scope.data.status=="SUCCESS"){	    		 
	    		 swal({
					 title: "Update Question!",
					text:$scope.data.message,
					type:"success",
					 
					function() {
						
						
					}}
				);
     	    		
     	    	}else if( $scope.data.status=="FAILURE"){
     	    		
           		  
     	    	}
		},
		function error(response){	
			 angular.forEach(response.data.fieldErrors,function(value,index){
	                if(angular.equals(value.field, "questionName")){
	                	
	                	$scope.errorQuestion =value.code;
	                	
	                }
	                if(angular.equals(value.field, "answerMasters")){
	                	
	                	$scope.errorAnswers =value.code;
	                	
	                }
	                
	            });

		});
	}
	

	  
	//fetch all user profile //
	
	 $scope.fetchUser = function () {
	    	
	    	 
	    		  PeerService.fetchUser()
	              .then (function success(response){
	            	  $scope.users = response.data.responseList;
	            	 
	              },
	              function error(response){
	            	  
	            	  
	              });
	    	  
	    }
	
	 
	//*********************************Fetch User Card with Rating and Specialization ,degree etc**********************// 
	 
		$scope.fetchUsersCard = function (bol) {
			if(bol==true){
				var filterText=$("#filter").val();
				totalPage=0;
				pageNo=0;
				$scope.userSelectData=[];
				requestDTO={};	
			}
			
			if(pageNo==0 || ((pageNo*pageSize) < totalPage)) {
				pageNo=pageNo+1;
				requestDTO={"pageNo":pageNo};
				
				if((sorByRatingVal=='5' || sorByRatingVal=='6')&&(filterVal!="" && filterParam!="")){
					requestDTO={"pageNo":pageNo,"sortByRating":sorByRatingVal,"filterParamter":filterParam.trim(),"keyname":filterVal.trim()};			
				}else if(filterVal!="" && filterParam!=""){
					requestDTO={"pageNo":pageNo,"filterParamter":filterParam.trim(),"keyname":filterVal.trim()};
				}else if((sorByRatingVal=='5' || sorByRatingVal=='6')){
					requestDTO={"pageNo":pageNo,"sortByRating":sorByRatingVal};
				}
				PeerService.fetchUsersCard(requestDTO)
				.then (function success(response){  
					totalPage=response.data.totalPage;
					$scope.load="display:none"; 
					if(response.data.responseList==""){
						$scope.noRecord="No Record Found";
					}else{
						angular.forEach(response.data.responseList, function(value, key) {
							$scope.noRecord="";
							$scope.imagesrc="/resources/images/star-line-30.png";
							$scope.userSelectData.push(value);
						});
					}

				},
				function error(response){

				});
			}

		}
		$scope.flip = function (side){
		
			
			$scope.side=side;
			if($scope.side="frontside"){
				$scope.lastOpenedSide='backside';
			}else if($scope.side="backside"){
				$scope.lastOpenedSide='frontside';
			}
			
			$('.card-design').toggleClass('flipped');
			
		
		}
		
		$('.modal-close').on('click', function () {
			$('#modal-popup2').hide();
			
			$('.card-design').removeClass('flipped');
		}); 	
		$scope.removeClass	= function(){
			$('.card-design').removeClass('flipped');
		}
	
	 $scope.showUserPop = function (user,a) {
		 $('#modal-popup2').show();
		
			$scope.userProfile=user;
			
			$scope.userId=user.userId;
			$scope.indexes=[];
			$scope.restComment=[];
			
			
			var i=0;
			for(i=0;i<user.comments.length;i++){
				
				if(i==0)
					$scope.firstComment=user.comments[i];
				else{
					$scope.restComment.push(user.comments[i]);
				
				$scope.indexes.push(user.userId+""+i)
				}
				
			/*	var str={index:user.userId+""+i,comments:user.comments[i]};
				
				$scope.comments.push(str);*/
				
			}
			
			
			if($scope.side==undefined){
			}
			
			/*if($scope.lastOpenedSide=='backside')
				{
					$('.card-design').toggleClass('flipped');
				('$backside').hide();
				('$frontside').show();
				
					$scope.lastOpenedSide='frontside';
				}*/
		
		
			
	}
	 	 $scope.viewDetails = function (user) {
	 		PeerService
			.saveData(
					"viewProfileData",
					user);
			window.location.href="/peerhuntr/user/profileGallery";
	}
	 	 
	 	 $scope.viewDetailProfile =function(){
	 		 var retrieved_object = sessionStorage.getItem("viewProfileData");
				var data = JSON.parse(retrieved_object);
				$scope.profilDetail=data;
				
	 	 }
	 	 
	 	 
	 	 
	 	 
	 	 
	 	 $scope.viewCart = function () {
		 		
				window.location.href="/peerhuntr/user/viewCartPage";
		}
	 	 
	
	 	 /**
	 	  * Updating profile in database
	 	  */
	 	 $scope.updateProfile= function () {
	 		var vcfData = new FormData();
	 		vcfData.append("image", image.files[0]);
	 		vcfData.append('jsondata', JSON.stringify($scope.user));
	 		
	 		var imgVal = $('#image').val(); 
	 		if(imgVal!=''){
	 		 var oFile = document.getElementById("image").files[0]; 
			 	
			 		 if (oFile.size > 15000000) // 15 mb for bytes.
			            {
			            	document.getElementById('fileSize').innerHTML="File size must under 15mb! ";
			            	return;
			            }
			 	}
	           
	 		 if ($scope.updateCustomerForm.$valid){
		 		 $.ajax({
		 			    url: "/peerhuntr/updateProfile",
		 			    data: vcfData,
		 		        dataType: "text",
		 		        contentType:false,
		 		       processData: false,
		 		       type: "POST", 
		 		  success: function(data){
		 			 var obj = JSON.parse(data);
		 			 
		 			
		 			swal({
						 title: "Update Profile!",
						text:obj.message,
						type:"success",
						 
						function() {
							
							
						}}
					);
					
		 			document.getElementById('fileSize').innerHTML="";
		 		    	 	    	
		 		    }, 		  
		 		   error: function(xhr, status, error) {
		 			  
		 			}	 		
		 		  });	
	 		 }
	 				
	 		 
	 	 }
	 	 /**
	 	  * Register user in database
	 	  */
	 	$scope.registerUser= function () {
	 		var error=false;
	 		 var re = new RegExp("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");
	 		var string =document.registerCustomerForm.loginPassword.value;
			 if (re.test(string)) {
			     
			     
			 } else {
			    
			     document.getElementById('message').innerHTML="Combination of small,capital,numeric and min 8 char. ";
			     error=true;
			 }
			 
			 if(string!=document.registerCustomerForm.confirmPassword.value){
				 document.getElementById('passwordMatch').innerHTML="Password mismatch ";
				 error=true;
			 }
			 var imgVal = $('#image').val(); 
	            if(imgVal=='') 
	            { 
	            	document.getElementById('imageRequired').innerHTML="Image is required! ";
	                error=true;
	            } 
			 var oFile = document.getElementById("image").files[0]; 
			 	if(imgVal!=''){
			 		 if (oFile.size > 15000000) // 15 mb for bytes.
			            {
			            	document.getElementById('fileSize').innerHTML="File size must under 15mb! ";
			            	error=true;
			            }
			 	}
	           
	           

			 if(error==true)
				 return;
			 
			
	 		var vcfData = new FormData();
	 		vcfData.append("image", image.files[0]);
	 		vcfData.append('jsondata', JSON.stringify($scope.user));
	 		if ($scope.registerCustomerForm.$valid){
	 			 scrollShow();
	 		 $.ajax({
	 			    url: "/peerhuntr/registerUser",
	 			    data: vcfData,
	 		        dataType: "text",
	 		        contentType:false,
	 		       processData: false,
	 		       type: "POST", 
	 		  success: function(data){
	 			 scrollHide();
	 			 var obj = JSON.parse(data);
	 			 if(obj.status=="SUCCESS"){
	 			/*	document.getElementById('message').innerHTML="";
	 				document.getElementById('passwordMatch').innerHTML="";
	 				document.getElementById('imageRequired').innerHTML="";
	 				document.getElementById('fileSize').innerHTML="";*/
	 			
	 				swal({
	 					 title: "User Registration!",
	 					text:obj.message,
	 					type:"success",
	 					 showConfirmButton: false,
	 					function() {
	 						
	 						
	 					}}
	 				);
	 				
	 				setTimeout(function(){
	 					 location.reload();
	 					 }, 
	 					 5000);
	 				 
	 				
	 			 }else{
	 				swal({
	 					 title: "User Registration!",
	 					text:obj.errorMsg,
	 					type:"error",
	 					function() {
	 					
	 					}}
	 				);
	 				
	 				
	 			 }
	 			 
	 			//window.location.href="/peerhuntr/home/register"    	
	 		    }, 		  
	 		   error: function(xhr, status, error) {
	 			  
	 			}	 		
	 		  });	
	 	}
	 				
	 		 
	 	 }
	 	 /**
	 	  * Getting nationality,specilization and degree data for registration page 
	 	  */
	 	
	 	
	 	function addCombo() {
	 		var textb = document.getElementById("txtCombo");
	 		var combo = document.getElementById("combo");
	 		
	 		var option = document.createElement("option");
	 		option.text = textb.value;
	 		option.value = textb.value;
	 		try {
	 			combo.add(option, null); //Standard 
	 		}catch(error) {
	 			combo.add(option); // IE only
	 		}
	 		textb.value = "";
	 	}
	 	
	 	
	 	$scope.getRegisterData = function () {
	    	
	  		  PeerService.getRegisterData()
	            .then (function success(response){
	            	var arrayCount=0,i=0;
	          	$scope.nationality=response.data.responseMap.Nationality;
	          	$scope.degree=response.data.responseMap.Degree;
	          	$scope.specilization=response.data.responseMap.Specialization;
	          	
	          	

	          	$scope.specilizationSelected=[];
	          	for(i=0;i<$scope.specilization.length;i++){
		 			if($scope.user.specializationMaster.degreeMaster.degreeId==$scope.specilization[i].degreeMaster.degreeId){
			 			$scope.specilizationSelected[arrayCount]=$scope.specilization[i];
			 			arrayCount++;
			 		}
		 		}
	          	
	            },
	            function error(response){
	          	  
	          	  
	            });
	  	  
	  }
	 	$scope.getUserProfile = function () {
	    	
	    	 
  		  PeerService.getUserProfile()
            .then (function success(response){
          	  var users = response.data.responseList;
          	  var i;
          	
          	for (i = 0; i < users.length; i++) {
          		$scope.user=users[i];
          		
          	}
          	$scope.nationality=response.data.responseMap.Nationality;
          	$scope.degree=response.data.responseMap.Degree;
          	$scope.specilization=response.data.responseMap.Specialization;
          	
          
          	
          	
          	var arrayCount=0,i=0;
          	$scope.specilizationSelected=[];
          	for(i=0;i<$scope.specilization.length;i++){
	 			if($scope.user.specializationMaster.degreeMaster.degreeId==$scope.specilization[i].degreeMaster.degreeId){
		 			$scope.specilizationSelected[arrayCount]=$scope.specilization[i];
		 			arrayCount++;
		 		}
	 		}
          	
            },
            function error(response){
          	  
          	  
            });
  	  
  }
	 	$scope.getMyProfile = function () {
	    	
	 		$scope.userLogin;
	  		  PeerService.getUserProfile()
	            .then (function success(response){
	          	  var users = response.data.responseList;
	          	  var i;
	          	
	          	for (i = 0; i < users.length; i++) {
	          		$scope.user=users[i];
	          		
	          	}
	          
	          	
	            },
	            function error(response){
	          	  
	          	  
	            });
	  	  
	  }
	 	$scope.ratingLink = function(network,referralCode,link,firstName,lastName) {
	 		//var bodyText="Please provide rating %0D%0A %0D%0A";
	 		var mailLink='';
	 		if(network=="tw"){
	 			mailLink=link+"?referralCode="+referralCode+"&n="+network;
	 		}else{
	 			mailLink=link+"?referralCode%3D"+referralCode+"%26n%3D"+network+"%26name%3D"+firstName;
	 		}
	 		
	 		var bodyText="Hello!%0D%0A %0D%0A";
	 		bodyText=bodyText+"I would appreciate if you could take a short moment to give me a completely anonymous peer rating for my peerHuntr profile..%0D%0A %0D%0A"

	 		//var bodyText="Welcome to the peerHuntr peer rating page!%0D%0A %0D%0A";

 		    bodyText=bodyText+"In addition, I would like you to describe in one sentence only how you think of me as a colleague or work partner.%0D%0A %0D%0A"
 		    
 		    bodyText=bodyText+"Please access this link and follow the instructions: %0D%0A %0D%0A"
 		    
 		    var bodytext1= bodyText+mailLink+"%0D%0A %0D%0A";
	 		bodytext1=bodytext1+"Thank you very much.%0D%0A %0D%0A";
 		    bodyText=bodyText+"Thank you very much.%0D%0A %0D%0A"; 
	 	
	 		var regards="%0D%0A %0D%0ABest Regards %0D%0A"+firstName +" "+lastName;
			/*var mailLink="Please provide rating %0D%0A %0D%0A %0D%0A"+link+"?referralCode="+referralCode+"%26n="+network+"%0D%0A %0D%0A %0D%0A Best Regards %0D%0A %0D%0A %0D%0A "+name;*/
			
			if(network=="em")
				window.location.href = "mailto:?subject=PeerHuntr%20Rating&body="+bodytext1+regards;
			if(network=="li")
				window.location.href = "https://www.linkedin.com/shareArticle?mini=true&url="+mailLink+"&title=Peerhuntr Rating&summary="+bodyText+regards;
			if(network=="wa"){
					window.open(
						  'https://web.whatsapp.com/send?text='+bodytext1+regards,
						  '_blank' 
						);
			}
			
			if(network=="fa"){
				 window.open(
					      'https://www.facebook.com/sharer/sharer.php?u='+mailLink, 
					      'facebook-share-dialog', 
					      'width=626,height=436'); 
				
				
			}
			if(network=="tw"){
				window.open('http://twitter.com/share?url='+encodeURIComponent(mailLink)+'&text='+encodeURIComponent(bodyText+regards), '', 'left=0,top=0,width=550,height=450,personalbar=0,toolbar=0,scrollbars=0,resizable=0');
			}
			
			
		}
		

	 	
	 	$scope.getSpec = function (id) {
	 		var arrayCount=0;
	 		$scope.specilizationSelected=[];
	 		var i=0;
	 		for(i=0;i<$scope.specilization.length;i++){
	 			if(id==$scope.specilization[i].degreeMaster.degreeId){
		 			$scope.specilizationSelected[arrayCount]=$scope.specilization[i];
		 			arrayCount++;
		 		}
	 		}
	 		
	 		}
	 	
	 	
		$scope.getCountryCode = function (id) {
	 		
		
	 		var i=0;
	 		for(i=0;i<$scope.nationality.length;i++){
	 			
	 			if(id==$scope.nationality[i].nationalityId)
	 				{
	 				
	 				}
	 			
	 			
	 		}
	 		
	 		}
	
	 $scope.changePassword = function () {
		 
		  var string =document.changePaswrdForm.newPassword.value;
			 
			 var re = new RegExp("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");
			 if (re.test(string)) {
			     
			     
			 } else {
			    
			     document.getElementById('message').innerHTML="Combination of small,capital,numeric and min 8 char. ";
			     return;
			 }
	    	$scope.submitted = true;
	    	  if ($scope.changePaswrdForm.$valid){
	    		  PeerService.changePassword($scope.userLogin)
	              .then (function success(response){
	            	  $scope.data = response.data;
	            	  document.getElementById('message').innerHTML="";
	            	  if($scope.data.status=="SUCCESS"){
	            		 
	            		  swal({
	              			  title: "Change Password!",
	              			  text: $scope.data.message,
	              			  type: "success",
	              			  timer: 10000,
	              			  
	              			}); 
		      	    		
		      	    	}else if( $scope.data.status=="FAILURE"){
		      	    		 swal({
		              			  title: "Change Password!",
		              			  text: $scope.data.errorMsg,
		              			  type: "failure",
		              			  timer: 10000,
		              			  
		              			}); 
		      	    	}
	            	  
	            	  setTimeout(function(){
		 					 location.reload();
		 					 }, 
		 					 5000);
	              },
	              function error(response){
	            	  
	            	  
	              });
	    	  }
	    }
	 
	 
	 
	//load Question Answer//
	 
	 $scope.loadQuestionAnswer = function () {
		 
	    		  PeerService.loadQuestionAnswer()
	              .then (function success(response){
	            	  $scope.data = response.data;
	      
		            	  angular.forEach($scope.data.responseList, function(value, key){
		            		
		            		  $("#questionId").val(value.questionName);
		            		  $("#qId").val(value.questionId);
		            		  angular.forEach(value.answerMasters, function(ans, key){
			            		  
			            		  if(ans.answerIndicator.answerIndicatorId==1){
			            			  
			            			  $("#answerAId").val(ans.answer);
			            		  }else{
			            			  
			            			  $("#answerBId").val(ans.answer);
			            		  }
			            	
			            		
			            	      });
		             	       });
	              },
	              function error(response){
	            	  
	            	  
	              });
	    		 
	    	  
	    }
	 $scope.getSections = function(){

		 
		  PeerService.getSections()
        .then (function success(response){
        	$scope.data=response.data;
      	  $scope.section = response.data.responseList;
      	  $scope.Question = response.data.responseList;
      	
      
        },
        function error(response){
      	  alert("error");
      	  
        });
		 
	  

	 }
	 $scope.getSectionQuestionUI = function(sectionId){


	 		var arrayCount=0;
	 		$scope.questionSelected=$scope.section;
	 		var i=0;
	 		for(i=0;i<$scope.questions.length;i++){
	 			if(sectionId==$scope.section[i].sectionId){
		 			
	 				
	 				$scope.questions
		 		}
	 		}	 		
	 		

	 }
	 
	 
	 //GET Section Question And Answer//
	 
	 $scope.getSectionQuestionAnswer = function () {
		 var sectionText=$("#sectionId option:selected").text();
      	  $scope.questionData=[];

		 var sectionId=$scope.section.sectionId;
			var sectionQuality=sectionText.split('or');
			$scope.qualityA = sectionQuality[0];
			$scope.qualityB = sectionQuality[1];
		  PeerService.getSectionQuestionAnswer(sectionId)
         .then (function success(response){
       	  $scope.data = response.data;
       	  var i=0;
       	  angular.forEach($scope.data.responseList, function(value, key){  
       		angular.forEach(value.sectionMaster.questionMasters, function(value1, key1){
       			if(value1.questionId!=null){
				var str={id:value1.questionId,index:i};
       			$scope.questionData[i]=str;
       			i++;
       			}
       		});
       		
       			 // $("#questionId").val(++i);
       			// $("#qId").val(value.questionMaster.questionId);
    		if(value.qualityMaster.qualityType==$scope.qualityA){
    			$("#answerA").val(value.answerMaster.answer);
    		}else if(value.qualityMaster.qualityType==$scope.qualityB){
    			$("#answerB").val(value.answerMaster.answer);
    		}
    		 
     	       });
       	  
       	if( $scope.data.status=="FAILURE"){
       		
       		
	    		alert($scope.data.errorMsg);
	    		 $("#questionName").val('');
	    		 $("#answerA").val('');
	    		 $("#answerB").val('');
	    		
	    	}
       	  
         },
         function error(response){
       	  
       	  
         });
		 
	  
}
	 
	 
	 //GET DATA SECTION WITH QUESTION NUMBER//
	 
	 
	 $scope.getSectionWithQuestionNumber = function () {
		
 		 var sectionID=$scope.section.sectionId;
		 var questionNumberId=$scope.section.questionNumber;	
		 if(questionNumberId!=null){
		  PeerService.getSectionWithQuestionNumber(sectionID,questionNumberId)
         .then (function success(response){
       	  $scope.data = response.data;
       	  angular.forEach($scope.data.responseList, function(value, key){       		 
       			  $("#questionName").val(value.questionMaster.questionName);
    		if(value.qualityMaster.qualityType==$scope.qualityA){
    			$("#answerA").val(value.answerMaster.answer);
    		}else if(value.qualityMaster.qualityType==$scope.qualityB){
    			$("#answerB").val(value.answerMaster.answer);
    		}
    		 
     	       });
       	  
       	if( $scope.data.status=="FAILURE"){
       		
	    		alert($scope.data.errorMsg);
	    		 $("#questionName").val('');
	    		 $("#answerA").val('');
	    		 $("#answerB").val('');
	    		
	    	}
       	  
         },
         function error(response){
       	  
       	  
         });
		}
	  
}
	 
	 $scope.updateForgetPassword = function () {

		  scrollShow();
		  $scope.userLogin.referralCode= $("#referralCodeId").val();
	    	$scope.submitted = true;
	    	  if ($scope.updateForgetPaswrdForm.$valid){
	    		 
	    		  
	    		  PeerService.updateForgetPassword($scope.userLogin)
	              .then (function success(response){
	            	  scrollHide();
	            	$scope.data = response.data;
	            	if($scope.data.status=="SUCCESS"){
	            		
	            		swal({
		          			  title: "Update Password!",
		          			  text: $scope.data.message
		          			  
		          			}); 
         		
	      	    		
	      	    	}else if( $scope.data.status=="FAILURE"){
	      	    		swal({
		          			  title: "Update Password!",
		          			  text:$scope.data.errorMsg
		          			  
		          			}); 
	      	    		
	      	    	}
	            	
	            	 setTimeout(function(){
	 					 location.reload();
	 					 }, 
	 					 2000);
	              },
	              function error(response){
	            	 
	            	  
	              });
	    	  }
	    }

	  
	  $scope.forgetPassword = function () {

		  scrollShow();
	    	$scope.submitted = true;
	    	  if ($scope.forgetPaswrdForm.$valid){
	    		  PeerService.forgetPassword($scope.userLogin)
	              .then (function success(response){
	            	  scrollHide();
	            	$scope.data = response.data;
	            	if($scope.data.status=="SUCCESS"){
	            		
	            		swal({
		          			  title: "Forgot Password!",
		          			  text: $scope.data.message
		          			  
		          			}); 
          		
	      	    		
	      	    	}else if( $scope.data.status=="FAILURE"){
	      	    		swal({
		          			  title: "Forgot Password!",
		          			  text:$scope.data.errorMsg
		          			  
		          			}); 
	      	    		
	      	    	}
	            	
	            	 setTimeout(function(){
	 					 location.reload();
	 					 }, 
	 					 2000);
	              },
	              function error(response){
	            	 
	            	  
	              });
	    	  }
	    }
	  
	  
		function scrollShow(){
			 document.getElementById('loading').className = 'loading';
		}
		function scrollHide(){
			 document.getElementById('loading').className = 'none';
		}
	//*********************************addToCart**********************************************
		
		  $scope.addToCart = function(profilDetail) {
			
			PeerService.addToCart(profilDetail)
	          .then (function success(response){
	        	  $scope.suggestionload="display:none";
	        	  $scope.data = response.data;
	        	  
	        	  if($scope.data.status=="SUCCESS"){
	            		 
            		  swal({
              			  text: "Profile Shortlisted!",
              			  type: "success",
              			  timer: 10000,
              			  
              			}); 
	      	    		
	      	    	}else if( $scope.data.status=="FAILURE"){
	      	    		 swal({
	              			  title: "Cart exist!",
	              			  text: $scope.data.errorMsg,
	              			  type: "failure",
	              			  timer: 10000,
	              			  
	              			}); 
	      	    	}
	        	  
	        
	        	  
	        	  var courtCount=$scope.data.cartCount;
	        	  $("#caratCount").text(courtCount);
	        	  var myEl = angular.element( document.querySelector( '#bag' ) );
	        	  angular.forEach($scope.data.responseList, function(value, key){
	        		  angular.forEach(value.profileImages, function(img, key){
	        			
	        			  $("#caratCount").text(courtCount);
	        			  var src="src="+img.hiddenImageUrl+"";
	        			  if(src==''){
	        				  alert("Your image is not supported")
	        			  }
	              		 
	              		  var cart= " <li>" +

	            		  "                  <span class=\"item\">" +
	            		  "                    <span class=\"item-left\">" +
	            		  "<img class=\" img-fluid\"  "+src+"     alt=\"card image\" data-no-retina=\"\">"+
	            		  "                        <span class=\"item-info\">" +
	            		  "                            <span>"+value.firstName ;"</span>" +
	            		  "                            <span>23$</span>" +
	            		  "                        </span>" +
	            		  "                    </span>" +
	              
	            		  "                </span> " +
	            		  "<span class=\"item-right\">" +
	            		  
	            		  " </li>";
	            		  		
	            		  myEl.append(cart);
	            		  
	        			  });
	        		
	        		  });
	        	  
	         	  
	        	  
	          },
	          function error(response){
	        	  
	          });
			}
		
			
		
//*****************************Get User Cart in Bag**********************************************//
				  
		  $scope.getUserCart = function () {
			    
				  PeerService.getUserCart()
		         .then (function success(response){
		        	  $scope.data = response.data;
		        	  var courtCount=$scope.data.cartCount;
		        	  $("#caratCount").text(courtCount);
		        	  var i =0;
		        	  var myEl = angular.element( document.querySelector( '#bag' ) );
		        	  angular.forEach($scope.data.responseList, function(value, key){

		        		
		        		  angular.forEach(value.profileImages, function(img, key){
		        			  if(++i<=4){
		        			  var src="src="+img.hiddenImageUrl+"";
		        			  if(src==''){
		        				  alert("Your image is not supported")
		        			  }

		            		  var cart= " <li>" +
		            		  "                  <span class=\"item\">" +
		            		  "                    <span class=\"item-left\">" +
		            		  "<img class=\" img-fluid\"  "+src+"     alt=\"card image\" data-no-retina=\"\">"+
		            		  "                        <span class=\"item-info\">" +
		            		  "                            <span>"+value.firstName.substring(0,1).toUpperCase()+"." +" "+value.lastName.substring(0,1).toUpperCase()+".";+"</span>" +
		            		  "                            <span>23$</span>" +
		            		  "                        </span>" +
		            		  "                    </span>" +
		              
		            		  "                </span> " +
		            		  "<span class=\"item-right\">" +
		              		  


		            		  "<span class=\"item-right\">" +		            		  

		            		  " </li>";
		            		
		            		  myEl.append(cart);
		            		  }
		        		  });
		        		
		        		
		        		
		        	  });
		        	  
		            
		         },
		         function error(response){
		       	  
		       	  
		         });
				 
			  
		}
		  
		  
		  
		  /****************************Find ALL cart***********************/
		  
		   $scope.viewAllCart=function(){
			  PeerService.getUserCart()
		         .then (function success(response){
		        	  $scope.allCartData = response.data;
		        	
		        	  
		         },
		         function error(response){
		       	  
		       	  
		         });
				 
			  
		}
		   
		  //*************************Delete cart************* **//
		  
		  $scope.deleteCart=function(userCart,id){
	
		
			  PeerService.deleteCart(userCart)
		         .then (function success(response){
		        	  
		        	  $scope.data = response.data;
		        	 if($scope.data.status=="SUCCESS"){
		        		 var courtCount=$scope.data.cartCount;
		        		  $("#caratCount").text(courtCount);
		        		 // alert(courtCount);
	            		  swal({
	              			  title: "Delete Profile!",
	              			  text: $scope.data.message,
	              			  type: "success",
	              			  timer: 10000,
	              			  
	              			}); 
	            		  
	            		  var a="#"+""+id;
	            		  $(a).remove();
	            		  
	            		  setTimeout(function(){
	 	 					 location.reload();
	 	 					 }, 
	 	 					 2000);
		      	    	}else if( $scope.data.status=="FAILURE"){
		      	    		 swal({
		              			  title: "Delete Profile!",
		              			  text: $scope.data.errorMsg,
		              			  type: "error",
		              			  timer: 10000,
		              			  
		              			}); 
		      	    	}
		        	 
		        	 
		           },
		         function error(response){
		       	  
		       	  
		         });
				 
		  }
		  
//*************************************************Filter********************************************************//
		  
			$scope.filterName = function()
			{
				filerParameter=$scope.singleSelect.singleFilter.value;
				alert($scope.singleSelect.singleFilter.value);
				search="Search "+filerParameter;
				filterParam=filerParameter;
				$("#filter").val("");
				$("#filter").attr("placeholder",search);
				$scope.sugestionList={};
				$scope.suggestionList();
				
			}
		 
		  //*************************************************Get Suggettion List*********************************//
		  
			$scope.suggestionList=function(){	
				var keyname=$("#filter").val();	
				
				var requestDTO= {"filterParamter":filerParameter,"keyname":keyname};
				
				PeerService.suggestionList(requestDTO)
				.then (function success(response){
					 $scope.suggestionload="display:block";
					$scope.filterOption="display:none";
					$( "#singleSelect").val("");
					$scope.sugestionList = response.data.responseList;
					$scope.data=[];
					for(var i=0;i<$scope.sugestionList.length;i++){
						if(filerParameter=="nationality"){
							var str={id:$scope.sugestionList[i].nationalityId,name:$scope.sugestionList[i].nationality}
							$scope.data[i]=str;
							
							
						}
						else if(filerParameter=="specialization"){
							var str={id:$scope.sugestionList[i].specializationId,name:$scope.sugestionList[i].specializationName}
							$scope.data.push(str);
							
							
						}else if(filerParameter=="degree"){
							var str={id:$scope.sugestionList[i].degreeId,name:$scope.sugestionList[i].degreeName}
							$scope.data.push(str);
							
							
						}else if(filerParameter=="personalityType"){
							var str={id:$scope.sugestionList[i].personalityId,name:$scope.sugestionList[i].personalityRole}
							$scope.data.push(str);
							
							
						}
					}
					
				
				},
				function error(response){

				});

			}
			
			
			 
			  
				
	 
		  $scope.setFilterValue=function($event){
			var suggestedData=$event.target.id;
			  $("#filter").val(suggestedData);	
			  filterVal=suggestedData;
			  $scope.suggestionload="display:none";
		  }
		 
		  $scope.sortByNationality=function(){
			  var sortByNationality=$scope.sortNationality.singleSort.value;
			  sortByNationalityVal=sortByNationality;
				$scope.sortNationality(true);
		}
		
		  /*
		  $scope.sortNationality=function(){
			  PeerService.sortNationality()
	         .then (function success(response){
	        	  $scope.sortNationalityList = response.data.responseList;
	        	  return sortNationalityList;*/
		  
		  $scope.sortByspecialization=function(){
			  var sortByspecialization=$scope.sortSpecialization.singleSort.value;
			  sortByspecializationVal=sortByspecialization;
				$scope.fetchUsersCard(true);
		}
		  
		  $scope.sortByRating=function(){
			  var sortByRating=$scope.sortRating.singleSort.value;
				sorByRatingVal=sortByRating;
				$scope.fetchUsersCard(true);

			}
 
		  $scope.displayFilter=function(){
			  
			  $scope.filterOption="display:block";
		  }
		  
		  $scope.purchasedCart=function(){
					  PeerService.purchasedCart()
			         .then (function success(response){
			        	  $scope.purchasedList = response.data.responseList;
			        	  scrollHide();
			          },
			         function error(response){
			       	
			         });
				   
			  }
		  
		  $scope.getSectionData =function(){
					PeerService.getSectionData()
					.then (function success(response){
						$scope.data = response.data;
						$scope.sections = response.data.responseList;
						
						
					},function error(response){

					});	
				}
		  
		  $scope.loginToSystem = function(){
			  $('#modal-popup2').hide();
			  swal({
      			  title: "Login!",
      			  text: "Please Login into the System",
      			  type: "error",  
      			  showConfirmButton: true,
      			}); 
			  setTimeout(function(){
  	    		window.location.href="/peerhuntr/login";
			  }, 3000); 
		  }
		  
}]);



peerhuntr.service('PeerService',['$http', function ($http) {
	
	this.changePassword = function changePassword(userLogin){
		return $http({
			method: 'POST',
			url:'/peerhuntr/sendMail/changePasswordAction',
			data : userLogin,
			contentType : 'application/json',
			dataType : "json"
		});
	}
	
    this.forgetPassword = function forgetPassword(userLogin){
        return $http({
          method: 'POST',
          url:'/peerhuntr/sendMail/forgetPasswordAction',
          data : userLogin,
          contentType : 'application/json',
	      dataType : "json"
        });
    }
    this.updateForgetPassword = function updateForgetPassword(userLogin){
        return $http({
          method: 'POST',
          url:'/peerhuntr/sendMail/updateForgetPasswordAction',
          data : userLogin,
          contentType : 'application/json',
	      dataType : "json"
        });
    }
    

    this.fetchUsersCard = function fetchUsersCard(requestDTO){
    	return $http({
          method: 'POST',
          url:'/peerhuntr/fetchUsersCard',
          data: requestDTO,
          contentType : 'application/json',
	      dataType : "json"
        });
    }
    
    this.updateCustomer = function updateCustomer(form_data){
		return $http({
			method: 'POST',
			url:'/peerhuntr/updateCustomerAction',
			data : form_data,
			contentType : 'application/json',
			dataType : "json"
		});
	}
   

	
	this.getRegisterData=function getRegisterData(){
		  
		   return $http({
		          method: 'GET',
		          url:'/peerhuntr/getRegisterData',
		          contentType : 'application/json',
			      dataType : "json"
		        });
		
	}
	

	this.getUserProfile=function getUserProfile(){
		  
		   return $http({
		          method: 'GET',
		          url:'/peerhuntr/getUserData',
		          contentType : 'application/json',
			      dataType : "json"
		        });
		
	}
	
    
    this.fetchUser = function fetchUser(){
        return $http({
          method: 'GET',
          url:'/peerhuntr/fetchAllUserProfile',
          contentType : 'application/json',
	      dataType : "json"
        });
    }
   
  
	this.addQuestions = function addQuestions(section){	
		var answerA = document.getElementById("answerA").value;
		var answerB = document.getElementById("answerB").value;
		var sectionMaster = section.sectionId;
		var questionName = document.getElementById("questionName").value;
		var questionId=section.questionNumber;
		if(angular.equals(answerB, "") ||angular.equals(answerB, "") ){
			var questionMasterDTO= {"questionName":questionName, "sectionMaster":{"sectionId":sectionMaster}};
		}else{
			var questionMasterDTO= {"questionId":questionId,"questionName":questionName, "answerMasters":[{"answer":answerA},{"answer":answerB}], "sectionMaster":{"sectionId":sectionMaster}};
		}
		
		return $http({
			method: 'POST',
			url:'/peerhuntr/admin/addQuestion',
			data : questionMasterDTO,
			contentType : 'application/json',
			dataType : "json"
		});
	}
	// Get all section
	this.getSections=function getSections(){
		return $http({
	          method: 'GET',
	          url:'/peerhuntr/admin/getSections',
	          contentType : 'application/json',
		      dataType : "json"
	        });
	}
	// Default A SECTION Question and Answer Question
	
	this.loadQuestionAnswer=function loadQuestionAnswer(){
		  
		   return $http({
		          method: 'GET',
		          url:'/peerhuntr/loadQuestionAnswer',
		          contentType : 'application/json',
			      dataType : "json"
		        });
		
	}
	
	//Load Question And Answer

	
	this.getSectionQuestionAnswer=function getSectionQuestionAnswer(sectionId){
		
		var sectionDTO= {"sectionId":sectionId};
		   return $http({
		          method: 'POST',
		          url:'/peerhuntr/getSectionQuestionAnswer',
		          data :sectionDTO,
		          contentType : 'application/json',
			      dataType : "json"
		        });
		
	}
	
	this.getSectionWithQuestionNumber=function getSectionWithQuestionNumber(sectionID,questionNumberId){	   
		var questionMasterDTO= {"questionNumberId":questionNumberId,  "sectionMaster":{"sectionId":sectionID}};
		   return $http({
		          method: 'POST',
		          url:'/peerhuntr/getSectionWithQuestionNumber',
		          data :questionMasterDTO,
		          contentType : 'application/json',
			      dataType : "json"
		        });
		
	}
	
	this.addToCart=function addToCart(profilDetail){
		 var userCartDTO= {"userProfile":{"userId":profilDetail.userId}};
		 return $http({
				method: 'POST',
				url:'/peerhuntr/cart/addToCartAction',
				data : userCartDTO,
				contentType : 'application/json',
				dataType : "json"
			});
	}
	
	

    this.getUserCart = function getUserCart(){
        	 var userCartDTO= {};
        	 
    	return $http({
          method: 'POST',
          url:'/peerhuntr/cart/getUserCartAction',
          data : userCartDTO,
          contentType : 'application/json',
	      dataType : "json"
        });
    }
    
	

    this.deleteCart = function deleteCart(userCart){
    	
    	return $http({
          method: 'POST',
          url:'/peerhuntr/cart/deleteCartAction',
          data: userCart,
          contentType : 'application/json',
	      dataType : "json"
        });
    }
    

    this.suggestionList = function suggestionList(requestDTO){
    	return $http({
          method: 'POST',
          url:'/peerhuntr/getSuggestionsList',
          data: requestDTO,
          contentType : 'application/json',
	      dataType : "json"
        });
    }
    
    this.purchasedCart = function purchasedCart(){
    	var userPurchageCart={};
    	return $http({
          method: 'POST',
          url:'/peerhuntr/cart/getPurchasedCartAction',
          data: userPurchageCart,
          contentType : 'application/json',
	      dataType : "json"
        });
    }
    
	this.getSectionData = function getSectionData(){
		return $http({
			method: 'GET',
			url:'/peerhuntr/admin/getSections',
			contentType : 'application/json',
			dataType : "json"
		});
	}
    
	this.saveData = function(key, data1) {
		sessionStorage.setItem(key, JSON
				.stringify(data1));

	};
	this.retrieveData = function(key) {
		return sessionStorage.getItem(key);
	};

	this.clearData = function() {
		sessionStorage.clear();
	};

	this.removeData = function(key) {
		sessionStorage.removeItem(key)
	};

	this.saveDataLocal = function(key, data1) {
		localStorage
		.setItem(key, JSON.stringify(data1))
	}

	this.retrieveDataLocal = function(key) {
		return localStorage.getItem(key);
	};

	this.removeDataLocal = function(key) {
		localStorage.removeItem(key)
	};

	
}]);

//--------------- personality test controller--------------

peerhuntr.controller('PersonalityController',['$rootScope','$scope','PersonalityService', function ($rootScope,$scope,PersonalityService){	
	$scope.submitted = false;
	$scope.questions;
	var questionCount=1;
	$scope.useranswerdata=[];
	$scope.questionNumber=1;
	$scope.lastQuestionNumber=1;
	$scope.totalNoFromDB=0;
	$scope.totalNoFromDB1=0;
	var color="lightblue";
	var noColor="white";
	$scope.lastQuestionSelected=false;
	
	
	  $scope.personalityTest=function(){
		  PersonalityService.save("userId",$("#userId").val());
		  window.location.href="/peerhuntr/personalitytest";
		  
	  }
	  // fetch all test questions
	  $scope.getTest = function () {
		  if(sessionStorage.getItem("userId")!=null){
		  	var data = JSON.parse(sessionStorage.getItem("userId"));
		  		$scope.userIdd=data;
	  }
		  
	    var c=0,ansCount=0;
	     
	     PersonalityService.getTest()
          .then (function success(response){
        	  $scope.questions = response.data.responseList;
        	  $scope.totalNoFromDB=$scope.questions.length;
        	  $scope.totalNoFromDB1=$scope.totalNoFromDB+1;
        	 
        	 angular.forEach( $scope.questions , function(value, key){
        		 
        		  c++;
        		  
                 
                  if(c==1){
                	  $("#questionID").val(value.questionId);
                	  $("#sectionID").val(value.sectionId);
                  $("#question").text(value.questionName);	  
                  
        		  angular.forEach(value.answerMasters, function(ans, key){
        			  ansCount++;
        			  
        			 
        			 if(ansCount==1){
        				 $("#AnswerA").text(ans.answer);
        				 $("#ansAIndicatorID").val(ans.answerIndicator.answerIndicatorId);  
        				 $("#ansAID").val(ans.answerId);  	
        				 $("#optionA").val(ans.answerId);
        			 }else{
        				 $("#AnswerB").text(ans.answer);
        				 $("#ansBIndicatorID").val(ans.answerIndicator.answerIndicatorId);  	
        				 $("#ansBID").val(ans.answerId);  	
        				 $("#optionB").val(ans.answerId);
        			 }
        			
        			 document.getElementById("optionA").style.backgroundColor = "none";
        			 document.getElementById("optionB").style.backgroundColor = "none";
        			 return;
        			 
        		  });
                  }
                 
         	       });
        	 
          },
          function error(response){
          
          });
	  
}
	  
	
	  $scope.submitTest = function() {
		  var userId;
		  if(userId=="null" || userId==undefined){
			  userId=document.getElementById("userIdlabel").innerHTML;
			  
		  }
		 
		  saveData();
		  var data={ "userId":userId,"userQuestionAnswers":$scope.useranswerdata};
		  
		  PersonalityService.submitTest(data)
          .then (function success(response){
        	  $scope.data = response.data;
        	  if($scope.data.status=="SUCCESS"){
        		  swal({
          			  title: "Personality Test!",
          			  text: $scope.data.message,
          			  type: "success",
          			  timer: 20000,
          			  
          			}); 
      	    		
        			PersonalityService.saveData("data",$scope.data);
      	    		PersonalityService.saveData("userId",userId);
      	    		PersonalityService.saveData("colorCode",$scope.data.colorCode);
      	    		PersonalityService.saveData("remarks",$scope.data.remarks);
      	    		window.location.href="/peerhuntr/personalityTestResult"
      	    		
      	    	
      	    		
      	    		//
      	    	}else if( $scope.data.status=="FAILURE"){
      	    		 swal({
             			  title: "Personality Test!",
             			  text: $scope.data.errorMsg,
             			  type: "success",
             			  timer: 20000,
             			  
             			}); 
      	    	}
          },
          function error(response){
        	  
          });
		}
		
	  $scope.getPersonality= function() {
		  var retrieved_object = sessionStorage.getItem("data");
			var data = JSON.parse(retrieved_object);
			$scope.type=data.type;
			$scope.role=data.role;
			$scope.remarks=data.remarks;			
			$scope.colorCode=data.colorCode;
			
	  }
	  
	  $scope.testAgain= function() {
		  var data = JSON.parse(sessionStorage.getItem("userId"));
		  $scope.userIdd=data;
		  
		  
	  }
	  
	 saveData = function() {

		 radioValue= $("#valueSelected").val();
		// alert(radioValue);
		 var sectionID=$("#sectionID").val();
		 var questionID=$("#questionID").val();
	
		 var data={ "answerMaster":{"answerId":radioValue},"questionMaster":{"questionId":questionID,"sectionMaster":{"sectionId":sectionID}}};
		 $scope.useranswerdata[questionCount]=data;
		 //alert(JSON.stringify( $scope.useranswerdata));
		
		  		
	}

	  //NEXT QUESTION CLICK ON RADIO BUTTON//
	  
		$scope.nextQuestion = function(option) {
			 if(option=="optionA"){
				
				 $("#valueSelected").val($("#optionA").val());
				 document.getElementById("optionA").style.backgroundColor = color;
				 document.getElementById("optionB").style.backgroundColor = noColor;
			 }
			 else{
				 
				 $("#valueSelected").val($("#optionB").val());
				 document.getElementById("optionB").style.backgroundColor = color;
				 document.getElementById("optionA").style.backgroundColor = noColor;
			 }
			 if($scope.questionNumber==$scope.totalNoFromDB){
				 $scope.lastQuestionSelected=true;
			 }
			 else  if($scope.questionNumber==$scope.lastQuestionNumber){

				 saveData();
			 }
			 setTimeout(function(){
					
					 if($scope.questionNumber==$scope.lastQuestionNumber){

						// saveData();
							
							
							if(questionCount==$scope.totalNoFromDB)
								
								{
								 $("#submit").show();
									return;
								}
							
							
							 $("#back").show();
						   	  questionCount++;
						   	$scope.questionNumber=questionCount;
						   	
						   	$scope.lastQuestionNumber++;
						   	
						   	  var count=0,ansCount=0;
						   	  var answers=[];
						   	 angular.forEach( $scope.questions , function(value, key){
				        		 count++;
				               
				                 if(questionCount==count){
				                $("#questionID").val(value.questionId);
				                $("#sectionID").val(value.sectionId);
				                 $("#question").text(value.questionName);
				                
				             	  angular.forEach(value.answerMasters, function(ans, key){
				             		  ansCount++;
				        			  answers.push(ans.answerIndicator.answerIndicatorId);
				        			 
				        			 if(ansCount==1){
				        				 $("#AnswerA").text(ans.answer);
				        				 $("#ansAIndicatorID").val(ans.answerIndicator.answerIndicatorId);  
				        				 $("#ansAID").val(ans.answerId);  	
				        				 $("#optionA").val(ans.answerId);
				        			 }else{
				        				 $("#AnswerB").text(ans.answer);
				        				 $("#ansBIndicatorID").val(ans.answerIndicator.answerIndicatorId);  	
				        				 $("#ansBID").val(ans.answerId);  	
				        				 $("#optionB").val(ans.answerId);
				        			 }
				       			 
				       		  });
				             	  
				             	 document.getElementById("optionA").style.backgroundColor = noColor;
				        			 document.getElementById("optionB").style.backgroundColor = noColor;
				             	  
					       		  return;
				                 }
				       		 
				        	       });
							 
					 }
					 }, 
					 300);
			 
			
		   	   		
		}
		
		$scope.backQuestion = function() {
			$("#submit").hide();
			if($scope.lastQuestionSelected==false && $scope.questionNumber==$scope.totalNoFromDB){
				
			}
			else{
				saveData();
			}
			  questionCount--;
				$scope.questionNumber=questionCount;
				
		   	  var count=0,ansCount=0;
		   	  var answers=[];
		   	  var data=$scope.useranswerdata[questionCount];
		   	
		   	  
		   	 angular.forEach( $scope.questions , function(value, key){
        		 count++;
               
                 if(questionCount==count){
	                $("#questionID").val(value.questionId);
	                $("#sectionID").val(value.sectionId);
	                 $("#question").text(value.questionName);
                
             	  angular.forEach(value.answerMasters, function(ans, key){
             		  ansCount++;
        			  answers.push(ans.answerIndicator.answerIndicatorId);
        			
        			 if(ansCount==1){
        				 $("#AnswerA").text(ans.answer);
        				 $("#ansAIndicatorID").val(ans.answerIndicator.answerIndicatorId);  
        				 $("#ansAID").val(ans.answerId);  	
        				 $("#optionA").val(ans.answerId);
        				    
        			 }else{
        				 $("#AnswerB").text(ans.answer);
        				 $("#ansBIndicatorID").val(ans.answerIndicator.answerIndicatorId);  	
        				 $("#ansBID").val(ans.answerId);  	
        				 $("#optionB").val(ans.answerId);
        			 }
        			 
       			 
       		  });
             	 $("#valueSelected").val(data.answerMaster.answerId);
             	 if($("#optionA").val()==data.answerMaster.answerId){
             		
             		document.getElementById("optionA").style.backgroundColor = color;
             		 document.getElementById("optionB").style.backgroundColor = noColor;
            			 
    			 }else{
    				 document.getElementById("optionB").style.backgroundColor = color;
    				 document.getElementById("optionA").style.backgroundColor = noColor;
            			
    			 }
             	 
             	// saveData();
             	 
             	 if(questionCount==1)
             		$("#back").hide();
       		  return;
                 }
       		 
        	       });
		   	  	}
		
		
		$scope.nextButtonQuestion = function() {
			 saveData();
			  questionCount++;
				$scope.questionNumber=questionCount;
		   	  var count=0,ansCount=0;
		   	  var answers=[];
		   	 var data=$scope.useranswerdata[questionCount];
		   	 angular.forEach( $scope.questions , function(value, key){
      		 count++;
      		 
      		$("#back").show();
             
               if(questionCount==count){
              $("#questionID").val(value.questionId);
              $("#sectionID").val(value.sectionId);
               $("#question").text(value.questionName);
              
           	  angular.forEach(value.answerMasters, function(ans, key){
           		  ansCount++;
      			  answers.push(ans.answerIndicator.answerIndicatorId);
      			 
      			 if(ansCount==1){
      				 $("#AnswerA").text(ans.answer);
      				 $("#ansAIndicatorID").val(ans.answerIndicator.answerIndicatorId);  
      				 $("#ansAID").val(ans.answerId);  	
      				 $("#optionA").val(ans.answerId);
      			 }else{
      				 $("#AnswerB").text(ans.answer);
      				 $("#ansBIndicatorID").val(ans.answerIndicator.answerIndicatorId);  	
      				 $("#ansBID").val(ans.answerId);  	
      				 $("#optionB").val(ans.answerId);
      			 }
     			 
     		  });
           	 if($scope.totalNoFromDB==$scope.lastQuestionNumber && $scope.lastQuestionSelected==true){

            		$("#valueSelected").val(data.answerMaster.answerId);
 	           	 if($("#optionA").val()==data.answerMaster.answerId){
 	           		document.getElementById("optionA").style.backgroundColor = color;
            		 document.getElementById("optionB").style.backgroundColor = noColor;
 				 }else{
 					 document.getElementById("optionB").style.backgroundColor = color;
             		 document.getElementById("optionA").style.backgroundColor = noColor;
 				 }
            	  
           	 }
           	 
           	  
           	 else  if($scope.questionNumber==$scope.lastQuestionNumber){
           		 
           		 
           			  document.getElementById("optionA").style.backgroundColor = noColor;
           			  document.getElementById("optionB").style.backgroundColor = noColor;
           		  
           		
         	  
           	  }else{
           		$("#valueSelected").val(data.answerMaster.answerId);
	           	 if($("#optionA").val()==data.answerMaster.answerId){
	           		document.getElementById("optionA").style.backgroundColor = color;
           		 document.getElementById("optionB").style.backgroundColor = noColor;
				 }else{
					 document.getElementById("optionB").style.backgroundColor = color;
            		 document.getElementById("optionA").style.backgroundColor = noColor;
				 }
           	  }
           		 
           	  
         	
     		  return;
               }
     		 
      	       });
		   	  	}
		}]);

peerhuntr.service('PersonalityService',['$http', function ($http) {
	this.submitTest=function submitTest(data){
		
		 //alert(JSON.stringify(data));
		 return $http({
				method: 'POST',
				url:'/peerhuntr/submitTest',
				data : data,
				contentType : 'application/json',
				dataType : "json"
			});
	}
	 this.getTest = function getTest(){
	        return $http({
	          method: 'GET',
	          url:'/peerhuntr/getTest',
	          contentType : 'application/json',
		      dataType : "json"
	        });
	    }
	 
	 this.personalityTestResult = function personalityTestResult(data){
	        return $http({
	          method: 'POST',
	          url:'/peerhuntr/personalityTestResult',
	          data:data,
	          contentType : 'application/json',
		      dataType : "json"
	        });
	    }
	 
	 this.save = function(key, data) {
			sessionStorage.setItem(key, data);

		};
	 this.saveData = function(key, data1) {
			sessionStorage.setItem(key, JSON.stringify(data1));

		};
	this.retrieveData = function(key) {
			return sessionStorage.getItem(key);
		};

	this.clearData = function() {
			 sessionStorage.clear();
		};
		
	this.removeData = function(key) {
			sessionStorage.removeItem(key)
		};
		
		
	this.saveDataLocal = function(key, data1)
		{
			localStorage.setItem(key, JSON.stringify(data1))
		}
		
	this.retrieveDataLocal = function(key) {
			return localStorage.getItem(key);
		};
		
	this.removeDataLocal = function(key) {
			localStorage.removeItem(key)
		};

}]);

/*** Rating controller***/

peerhuntr.controller('RatingController',['$rootScope','$scope','RatingService', function ($rootScope,$scope,RatingService){

	
	$scope.obj = {
		    'honest': 0,
		    'responsible': 0,
		    'coachable':0,
		    'teamplayer':0,
		    'leader':0,
		    'energetic':0,
		    'innovative':0,
		    'emotionally intelligent':0,
		    "comments":0
		    
		};
	$scope.add = function(ths,sno) {

		var a=ths;
		$scope.obj[a]=sno;
		

	for (var i=1;i<=7;i++){
	var cur=document.getElementById(ths+i)
	cur.className="fa fa-star"
	}

	for (var i=1;i<=sno;i++){
	var cur=document.getElementById(ths+i)
	if(cur.className=="fa fa-star")
	{
	cur.className="fa fa-star checked"
	}
	}

	
	}
	
	$scope.submitRating = function() {
		var network;
		var n=$('#n').val();
		if(n=='tw')
			network="Twitter";
		else if(n=='fa')
			network="Facebook";
		else if(n=='li')
			network="LinkedIn";
		else if(n=='em')
			network="Email";
		else if(n=='wa')
			network="Whats App";
			
	
		
		
		$scope.userRating= {
			referralCode:$('#referralCode').val(),
			network:network,
			networkUser:$('#name').val(),
			remarks:$('#comments').val(),
			emailId:$('#email').val(),
			ratings:$scope.obj
		};
		
		 if ($scope.peerRatingForm.$valid){
			 RatingService.submitRating($scope.userRating)
	         .then (function success(response){
	       	  $scope.data = response.data;
	       	  if($scope.data.status=="SUCCESS"){
	       		  
	      		window.location.href="/peerhuntr/thankYouPeerRating";
	       		  
	       	  }else if( $scope.data.status=="FAILURE"){
	       		swal({
       			  title: "Rating!",
       			  text: $scope.data.errorMsg,
       			  type: "error",
       			  timer: 10000,
       			  
       			}); 
	       		
	       		setTimeout(function(){
					 location.reload();
					 }, 
					 5000);
	       	  }
	         },
	         function error(response){
	        	 swal({
	       			  title: "Rating!",
	       			  text: obj.message,
	       			  type: "success",
	       			  timer: 10000,
	       			  
	       			}); 
	         });
		 }

		
		
	}
	
		
		}]);

peerhuntr.service('RatingService',['$http', function ($http) {
	
	
	 this.submitRating = function submitRating(data){
	        return $http({
	          method: 'POST',
	          url:'/peerhuntr/submitRating',
	          data:data,
	          contentType : 'application/json',
		      dataType : "json"
	        });
	    }
	 
	 
	
	

}]);



