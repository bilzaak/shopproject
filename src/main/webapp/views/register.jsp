<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/static/theme/bootstrap431.css" /> " rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="<c:url value="/static/theme/jquery340.js" />" > </script> 
<script src="<c:url value="/static/theme/angular1.8.2.js" />" > </script>
<script src="<c:url value="/static/theme/bootstrap431.js" />" > </script>

<script>
var second=0; var minite=0;	var timer;

function timestart(){
	
	timer=setInterval(myTimer,1000);
	     
	              }

function myTimer(){
if(second==60){
	second=0;
	minite=minite+1;
         }
else if(minite==3){
	location.reload();
            }
    else{
	  second=second+1;
        }
var p = minite+":"+second;
document.getElementById("t").innerHTML=p;

}



var ep1="y";
var ep2="y"
var le="y";
var se="y"
	
var mod=angular.module("regapp",[]);

mod.controller("regcon",function($scope,$http){
	
	$scope.finder=[
		{"district":"any","thanas":["any"]},
		{"district":"chittagong", "thanas":["any","demra","savar","omar"] },
		{"district":"noakhali", "thanas":["any","daudkandi","titas","meghna"] },
		{"district":"feni", "thanas":["any","kasba","akhaura","nabinagar"] },
		{"district":"rangamati", "thanas":["any","guda gari","bera","sadar"] },
		{"district":"comilla", "thanas":["any","khansama","dinajpur sadar","fulbari"] },
		{"district":"brahmanbaria", "thanas":["any","demra","savar","omar"] },
		{"district":"chadpur", "thanas":["any","daudkandi","titas","meghna"] },
		{"district":"laxmipur", "thanas":["any","kasba","akhaura","nabinagar"] },
		{"district":"chadpur", "thanas":["any","daudkandi","titas","meghna"] },
		{"district":"coxsbazar", "thanas":["any","kasba","akhaura","nabinagar"] },
		{"district":"bandarban", "thanas":["any","daudkandi","titas","meghna"] },
		{"district":"khulna", "thanas":["any","guda gari","bera","sadar"] },
		{"district":"satkhira", "thanas":["any","khansama","dinajpur sadar","fulbari"] },
		{"district":"jessore", "thanas":["any","demra","savar","omar"] },
		{"district":"kustia", "thanas":["any","daudkandi","titas","meghna"] },
		{"district":"bagerhat", "thanas":["any","khansama","dinajpur sadar","fulbari"] },
		{"district":"chuadanga", "thanas":["any","kasba","akhaura","nabinagar"] },
		{"district":"narail", "thanas":["any","guda gari","bera","sadar"] },
		{"district":"magura", "thanas":["any","khansama","dinajpur sadar","fulbari"] },
		{"district":"jhenidah", "thanas":["any","kasba","akhaura","nabinagar"] },
		{"district":"meherpur", "thanas":["any","guda gari","bera","sadar"] },
		{"district":"magura", "thanas":["any","khansama","dinajpur sadar","fulbari"] },
		{"district":"barishal", "thanas":["any","kasba","akhaura","nabinagar"] },
		{"district":"potuakhali", "thanas":["any","guda gari","bera","sadar"] },
		{"district":"barguna", "thanas":["any","khansama","dinajpur sadar","fulbari"] },
		{"district":"bhola", "thanas":["any","kasba","akhaura","nabinagar"] },
		{"district":"pirujpur", "thanas":["any","kasba","akhaura","nabinagar"] },
		{"district":"jhalkathi", "thanas":["any","guda gari","bera","sadar"] },
		{"district":"rajshahi", "thanas":["any","demra","savar","omar"] },
		{"district":"pabna", "thanas":["any","daudkandi","titas","meghna"] },
		{"district":"sirajganj", "thanas":["any","kasba","akhaura","nabinagar"] },
		{"district":"tangail", "thanas":["any","guda gari","bera","sadar"] },
		{"district":"chapainababganj", "thanas":["any","khansama","dinajpur sadar","fulbari"] },
		{"district":"natore" , "thanas":["any","demra","savar","omar"] },
		{"district":"rangpur", "thanas":["any","daudkandi","titas","meghna"] },
		{"district":"dinajpur", "thanas":["any","kasba","akhaura","nabinagar"] },
		{"district":"nilphamari", "thanas":["any","guda gari","bera","sadar"] },
		{"district":"lalmonirhat", "thanas":["any","khansama","dinajpur sadar","fulbari"] },
		{"district":"joypurhat", "thanas":["any","demra","savar","omar"] },
		{"district":"bogura", "thanas":["any","daudkandi","titas","meghna"] },
		{"district":"gaibandha", "thanas":["any","daudkandi","titas","meghna"] },
	    {"district":"sylhet", "thanas":["any","kasba","akhaura","nabinagar"] },
		{"district":"hobiganj", "thanas":["any","guda gari","bera","sadar"] },
		{"district":"maulivibazar", "thanas":["any","khansama","dinajpur sadar","fulbari"] },
		{"district":"sunamganj", "thanas":["any","demra","savar","omar"] },
		{"district":"dhaka", "thanas":["any","kasba","akhaura","nabinagar"] },
		{"district":"narsingdi", "thanas":["any","guda gari","bera","sadar"] },
		{"district":"tangail", "thanas":["any","khansama","dinajpur sadar","fulbari"] },
		{"district":"gazipur", "thanas":["any","demra","savar","omar"] },
		{"district":"munsiganj", "thanas":["any","daudkandi","titas","meghna"] },
		{"district":"manikganj", "thanas":["any","kasba","akhaura","nabinagar"] },
		{"district":"rajbari", "thanas":["any","guda gari","bera","sadar"] },
		{"district":"shoriotpur", "thanas":["any","khansama","dinajpur sadar","fulbari"] },
		{"district":"madaripur", "thanas":["any","demra","savar","omar"] },
		{"district":"narayanganj", "thanas":["any","khansama","dinajpur sadar","fulbari"] },
		{"district":"kishoreganj", "thanas":["any","demra","savar","omar"] },
	    {"district":"faridpur", "thanas":["any","khansama","dinajpur sadar","fulbari"] },
		{"district":"gopalganj", "thanas":["any","khansama","dinajpur sadar","fulbari"] },
		{"district":"mymensingh", "thanas":["any","daudkandi","titas","meghna"] },
		{"district":"netrokona", "thanas":["any","kasba","akhaura","nabinagar"] },
		{"district":"jamalpur", "thanas":["any","guda gari","bera","sadar"] },
	    {"district":"sherpur", "thanas":["any","khansama","dinajpur sadar","fulbari"] } ];
	
	
	
	
	
	$scope.confirm="";
	$scope.reg={"email":"","password":"","code":"","district":"", "thana":"","phone":"","catagory":"","shopname":""};
	
	$scope.catagory=["grocery","electronics","confectionary","hardware","pharmacy",""];
	
	
$scope.checkmail=function(){

		var el=$scope.reg.email.length;
	
if($scope.reg.email.indexOf("@gmail.com")!=-1){
	
	
		se="n";
		
		}
	
if($scope.reg.email.indexOf("@gmail.com")==-1){

	se="y";
	}
		

if(el<11){
	
	le="y";	
}

if(el>10){
	

	le="n";	
}


if(le=="y"){
	document.getElementById("le").innerHTML="invalid length";
	document.getElementById("le").style.color="red";
}
if(le=="n"){
	document.getElementById("le").innerHTML="";
}

if(se=="y"){
	document.getElementById("se").innerHTML="must add @gmail.com";
	document.getElementById("se").style.color="red";	
}

if(se=="n"){
	document.getElementById("se").innerHTML="";
	
}

	
}

	


		
	
$scope.checkpass1=function(){
	var x = $scope.reg.password.length;
	
		if(x<4){
		document.getElementById("pm1").innerHTML="need minimum 4 character";	
		document.getElementById("pm1").style.color="red";
		ep1="y"
	}	
		
		if(x>3){
			document.getElementById("pm1").innerHTML="valid length";
			document.getElementById("pm1").style.color="green";
			ep1="n"
		}	
		
if($scope.confirm!=$scope.reg.password)	{
			
			document.getElementById("pm2").innerHTML="password not match";
			document.getElementById("pm2").style.color="red";
			ep2="y"	
		}

if($scope.confirm==$scope.reg.password)	{
	
	document.getElementById("pm2").innerHTML="password matched";	
	document.getElementById("pm1").style.color="green";
	ep2="y"	
}


		
}	
		$scope.checkpass2=function(){
			var x = $scope.confirm.length;
			

		if($scope.confirm!=$scope.reg.password)	{
			
			document.getElementById("pm2").innerHTML="password not match";	
			document.getElementById("pm2").style.color="red";
			ep2="y"	
		}	
		
		if(x<4)	{
			
			document.getElementById("pm2").innerHTML="need minimum 4 character";	
			document.getElementById("pm2").style.color="red";
			ep2="y"	
		}	
	
		if($scope.confirm==$scope.reg.password && x>3){
			
			document.getElementById("pm2").innerHTML="password matched";
			document.getElementById("pm2").style.color="green";
			ep1="n" ; ep2="n";
		}

	
}

		
		
		
		
		$scope.register=function(){

			
if(ep1=="n" && ep2=="n" && se=="n" && le=="n"){
	
	$http({
		method:"POST",
		url:"${pageContext.request.contextPath}/register",
		data: angular.toJson($scope.reg),
		headers: {"Content-Type":"application/json"}}).
		then(function(response){
		
            if(response.data.code=="ok"){
        document.getElementById("adminreg").style.display="none";
        document.getElementById("regcode").style.display="block";
            	
            }
            else{
            	alert(response.data.code);
            	
            }

                             
		        })	
}		
				        
	if(ep1!="n" && ep2!="n" && se!="n" && le!="n"){
	
	alert("invalid form, try again")
}				        
				        
				        
				        
				        
				        
		}
		$scope.thana=null;
		
		$scope.seldistrict=function(){
			
			var s=$scope.reg.district;

			angular.forEach($scope.finder,function(v,i){
				
			var t=v.district;

			if(t==s){
				$scope.thana=v.thanas;

			}
				
			})
			
		}
		
		
		
$scope.regfinal=function(){
	

	$http({
		method:"POST",
		url:"${pageContext.request.contextPath}/regfinal",
		data: angular.toJson($scope.reg),
		headers: {"Content-Type":"application/json"}}).
		then(function(response){
		
		if(response.data.code=="ok"){
			document.getElementById("spancode").innerHTML="successfull login now";
			document.getElementById("spancode").style.color="green";	
		}	
		else{
			document.getElementById("spancode").innerHTML="code not matched,try again";
			document.getElementById("spancode").style.color="red";		
			
		}
			
			
		        })	
		        
	        

		}		
		
		
		
$scope.forgot={
	"email":"","password":"","code":""	
		
};

$scope.checkm=function(){

	var el=$scope.forgot.email.length;

	var err=null;
var se="g";
	var err=null;
var le="t";

if($scope.forgot.email.indexOf("@gmail.com")!=-1){
	se="n";
	
	}

if($scope.forgot.email.indexOf("@gmail.com")==-1){

se="y";
}
	

if(el<11){

le="y";	
}

if(el>10){

le="n";	
}

if(se=="y" || le=="y"){
	err=0;
}

if(se=="n" && le=="n"){
	err=3;
} 


return err;
}	
				


$scope.recover=function(){

	var xc = $scope.checkm();
	
	if(xc>2){
		$http({
			method:"POST",
			url:"${pageContext.request.contextPath}/recover",
			data: angular.toJson($scope.forgot),
			headers: {"Content-Type":"application/json"}}).
			then(function(response){
			
			if(response.data.code=="ok"){
				document.getElementById("fbody").style.display="none";
				document.getElementById("fcbody").style.display="block";	
				timestart();
			}	
			else{
				
				document.getElementById("fsms").innerHTML=response.data.code;
				document.getElementById("fsms").style.color="red";	
			}
				
				
			        })	
	}
	
	if(xc<2){
		
		alert("email is wrong");
	}	
	
	
}
	
	
$scope.finalrec=function(){
	var le="y";
	var se="y";
	
var ml="";
var ms="";
	
	if($scope.forgot.password==$scope.fconfirm){
		
		se="no";
	}
	

	if($scope.forgot.password.length>3){
		le="no";
	}
	
	
	if(le=="no" && se=="no"){
	$http({
		method:"POST",
		url:"${pageContext.request.contextPath}/finalrec",
		data: angular.toJson($scope.forgot),
		headers: {"Content-Type":"application/json"}}).
		then(function(response){
		
		alert(response.data.code);
	$scope.forgot.email="";$scope.forgot.code="";$scope.forgot.password="";
	if(response.data.code=="successfull"){
	document.getElementById("reclose").click();	
		
	}
		
		        })	
		        
	}
	
	else{
	
if(le=="y"){ml="length size minimum 4";} if(se=="y"){ ms="password not match"}	
	
	alert(ml+ms);
}
	
	
}	
	
	
		

$scope.backr=function(){
	
	document.getElementById("fbody").style.display="block";
	document.getElementById("fcbody").style.display="none";	
	
}


$scope.backreg=function(){
	
    document.getElementById("adminreg").style.display="block";
    document.getElementById("regcode").style.display="none";
	
}



	
})




function myFunction() {
  var x = document.getElementById("myInput");
  if (x.type === "password") {
    x.type ="text";
  } else {
    x.type = "password";
  }
}

</script>


<style>



#forgothover:hover{
shadow:5px solid black;
background-color:skyblue;
text-shadow:2px 2px green;

}

.grid-contain{
margin:5%px;
display:grid;
grid-template-columns: auto auto;
grid-template-rows: auto;
grid-row-gap: 10px solid white;
grid-column-gap: 10px solid white;
background-color:ghostwhite;
}


.forgotgrid{
margin:5%px;
display:grid;
grid-template-columns: auto auto;
grid-template-rows: auto;
grid-row-gap: 10px solid white;
grid-column-gap: 10px solid white;
}

span{
font-size:0.70em;

}
#admin,#adminreg{
padding:10px;
width:40%;
margin:auto;
border:1px solid black;
background-color:ghostwhite;
border-radius:8%;
}

.container{
margin-left:5%;
margin-right:5%;
border:2px solid black;
padding:5%;;
background-color:darkslategrey;

}



#reg{
padding:10px;
width:40%;
margin:auto;
border:1px solid black;
}

#reg button{
float:right;

}

.modal-dialog{
width:500px;


}


} 
#k input{
margin-top:15px;
text-align:center;
}

</style>

</head>




<body ng-app="regapp"   ng-controller="regcon" style="margin-top:35px;">

<form action="/admin" method="get" align="center">
<button type="submit"  class="btn btn-md btn-dark" >admin</button>
</form>
<br/>
<br/>
<!--  admin login form   -->

<div class="container">
<div class="form-group" id="admin">
<form action="/userlogin" method="post" id="k">
       
                         <br/>
          <span style="color:red;font-size:0.85em" >${sms}</span>   
          <br/>            
    <input type="text" class="form-control form-control-sm" name="email" placeholder="email">
   <br/>
    <input id="myInput" type="password" class="form-control form-control-sm" name="password" placeholder="password"><span><input type="checkbox" onclick="myFunction()">Show</span>
    <br/>
    <div class="forgotgrid"> 
    <div>
      <button type="submit" class="btn btn-success btn-sm">submit</button> 
    </div>
   <div style="color:red;text-align:right;" id="forgothover"><b data-toggle="modal" data-target="#forgotmodal">forgot password??</b></div>
    </div>
 </form>
</div>


<br/>
<div id="reg" class="grid-contain">
<div><b>not registered??</b></div>
<div><button   class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">register</button></div>
</div>


<!-- forgot password then check -->

<div id="forgotmodal" class="modal fade" role="dialog">
  <div class="modal-dialog">
 <!-- Modal content-->
      <div class="modal-content">
      <div class="modal-header" style="background-color:gray;">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"></h4>
      </div>
      <div class="modal-body">
      <div class="form-group" style="padding:5px;margin:auto;width:45%;border:1px solid green;" id="fbody">
<br/>
<input type="text" class="form-control form-control-sm" ng-model="forgot.email" placeholder="entere email">
<span id="fsms"></span>
<br/>
<button type="submit" class="btn btn-success btn-sm" ng-click="recover()" style="margin-top:10px;">submit</button> 

</div>


 <div class="form-group" style="padding:5px;margin:auto;width:45%;border:1px solid green;display:none;" id="fcbody">
<br/>
<p style="font-size:0.80em;">to get code "turn on" less secure app setting of your email</p>
<p>enter 4 digit code within 3 minite</p> <p id="t"></p>
<input type="text" class="form-control form-control-sm" ng-model="forgot.code" placeholder="4 digite code">
<br/>
<input type="password" class="form-control form-control-sm" ng-model="forgot.password" placeholder="new password">
<br/>
<input type="password" class="form-control form-control-sm" ng-model="fconfirm" placeholder="confirm password">
<br/>
<button type="submit" class="btn btn-success btn-sm" ng-click="finalrec()" style="margin-top:10px;">submit</button> 
 <br/>
<button class="btn btn-success btn-sm" ng-click="backr()" style="margin-top:10px;">back</button> 
 <br/>
</div>


 </div>
<div class="modal-footer">
  <button type="button" class="btn btn-default" data-dismiss="modal" id="reclose">Close</button>
</div>
</div>
</div>
</div>





<!--  admin register form  pop up  -->

<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
 <!-- Modal content-->
      <div class="modal-content">
      <div class="modal-header" style="background-color:gray;">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"></h4>
      </div>
      
      
      <div class="modal-body">
      
<div class="form-group" id="adminreg">

  <input  type="text"       ng-model="reg.phone"     class="form-control form-control-sm"  placeholder="phone"  />
  <br/>
    <input  type="text"       ng-model="reg.shopname"     class="form-control form-control-sm"  placeholder="shop name" />
    <br/>
      <select  class="form-control form-control-sm" ng-model="reg.district"    ng-options="c.district as c.district for c in finder"  class="form-control form-control-sm"  placeholder="district" ng-change="seldistrict()" ></select>
      <br/>
      <select  class="form-control form-control-sm"  ng-model="reg.thana" ng-options="c for c in thana" ></select>
         
      <br/>
      
        <select       ng-model="reg.catagory"     class="form-control form-control-sm" ng-options="c for c in catagory" ></select>
        <br/>
        
   <input  type="text"       ng-model="reg.email"     class="form-control form-control-sm"  placeholder="email"  ng-keyup="checkmail()" />
   
<span id="le" style="color:red"></span>
<span id="se" style="color:red;"></span>
 <br/>

  <input  type="password"   ng-model="reg.password"  class="form-control form-control-sm"  placeholder="password" ng-keyup="checkpass1()" />
  <span id="pm1"></span>
  <br/>
  <input  type="password"   ng-model="confirm"        class="form-control form-control-sm"   placeholder="confirm password" ng-keyup="checkpass2()" />
<span id="pm2"></span>
   <br/>
  <button  class="btn btn-success btn-sm" ng-click="register()">submit</button> 
  
</div>


<div class="form-group" id="regcode" style="display:none;width:40%;margin:auto;padding:10px;border:1px">
        
 <input  type="text" ng-model="reg.code" class="form-control form-control-sm"  placeholder="code"/>
 <br/>
 <span id="spancode"></span>
<button  class="btn btn-success btn-sm" ng-click="regfinal()">submit</button> 
<br/> <br/>
  <button  class="btn btn-success btn-sm" ng-click="backreg()">back</button> 
</div>
 </div>
    
  <div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
</div>

</body>
</html>