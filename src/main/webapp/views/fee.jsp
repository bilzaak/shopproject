<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>admin page</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/static/theme/bootstrap431.css" /> " rel="stylesheet">
<script src="<c:url value="/static/theme/jquery340.js" />" > </script> 
<script src="<c:url value="/static/theme/popper114.js" />" > </script>
<script src="<c:url value="/static/theme/angular1.8.2.js" />" > </script>
<script src="<c:url value="/static/theme/bootstrap431.js" />" > </script>
<style>
table th{
background-color:black;
color:white;
padding:8px;

}

table td{
background-color:skyblue;
padding:8px;
}

</style>
<script>

var mod=angular.module("pressapp",[]);

mod.controller("presscon",function($scope,$http){
	
$scope.di=null;
$scope.ser={
		"district":"any","thana":"any","shopname":"any"
		
};

$scope.thana=null;
$scope.shopname=[];
$scope.shopid=null;

    $scope.paid=[];
	$scope.unpaid=[];
	
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

$scope.users=null;


$scope.update=function(x){
	
	var d=x;
	$http({
		method:"POST",
		url:"${pageContext.request.contextPath}/fee/update",
		data: angular.toJson(d),
		headers: {"Content-Type":"application/json"}}).
		then(function(response){
		
		alert(response.data.district);
			
		})	
	
}



$scope.findbyshopid=function(){
	
	
	$http({
		method:"POST",
		url:"${pageContext.request.contextPath}/fee/findbyshopid",
		data: angular.toJson($scope.shopid),
		headers: {"Content-Type":"application/json"}}).
		then(function(response){
		
			$scope.users=response.data;
			
		})	
	
}	


$scope.seldistrict=function(){
	
var s=$scope.ser.district;

angular.forEach($scope.finder,function(v,i){
	
var t=v.district;

if(t==s){
	$scope.thana=v.thanas;

}
	
})



$http({
	method:"POST",
	url:"${pageContext.request.contextPath}/fee/finduser",
	data: angular.toJson($scope.ser),
	headers: {"Content-Type":"application/json"}}).
	then(function(response){
	
		$scope.users=response.data;
		$scope.shopname=[];
		angular.forEach($scope.users,function(v,i){
			
			$scope.shopname.push(v.shopname);
		})
		
	 })	



	
}

$scope.selthana=function(){
	
	$http({
		method:"POST",
		url:"${pageContext.request.contextPath}/fee/finduser",
		data: angular.toJson($scope.ser),
		headers: {"Content-Type":"application/json"}}).
		then(function(response){
		
			$scope.users=response.data;
			$scope.shopname=[];
	angular.forEach($scope.users,function(v,i){
		
		$scope.shopname.push(v.shopname);
	})
	
		
		})	
		
	}




$scope.selshopname=function(){
	
	$http({
		method:"POST",
		url:"${pageContext.request.contextPath}/fee/findbyshopname",
		data: angular.toJson($scope.ser),
		headers: {"Content-Type":"application/json"}}).
		then(function(response){
		
			$scope.users=response.data;
			
	
		})	
		
		}



$scope.seeall=function(){
	
	
	$http({
		method:"GET",
		url:"${pageContext.request.contextPath}/fee/seeall",
		headers: {"Content-Type":"application/json"}}).
		then(function(response){
		
			$scope.users=response.data;
			
		})	
		
     }
     
     
     




		
});

</script>

</head>


<body ng-app="pressapp" ng-controller="presscon" style="text-align:center;background-color:#B0E0E6;padding:20px;border:1px solid black;margin:20px;">


<h4>find user fee details</h4> <br/>
<table align="center">
<tr>
<th> shop id </th>
<th> district </th>
<th> thana </th>
<th> shop name </th>
<th> all shop </th>
</tr>
<tr>

<td>
<input type="text" ng-model="shopid"   ng-keyup="findbyshopid()" /> </td>
<td>

<select   ng-model="ser.district" ng-options="c.district as c.district for c in finder" ng-change="seldistrict()">

</select> 

</td>

<td>

<select   ng-model="ser.thana" ng-options="c for c in thana" ng-change="selthana()">

</td>

<td>

<select   ng-model="ser.shopname"  ng-options="c for c in shopname" ng-change="selshopname()">

</td>

<td>

<button ng-click="seeall()">see all</button>

</td>

</tr>

</table>

<br/>

<table align="center">

<tr>
<th>shop id</th>
<th>district</th>
<th>thana</th>
<th>shop name</th>
<th>phone</th>
<th>catagory</th>
<th>payment</th>
<th>update</th>
</tr>
<tr ng-repeat="x in users">
<th>{{x.shopid}}</th>
<th>{{x.district}}</th>
<th>{{x.thana}}</th>
<th><input type="text" ng-model="x.shopname" /></th>
<th><input type="text" ng-model="x.phone" /></th>
<th>{{x.catagory}}</th>
<th><input type="text" ng-model="x.paystatus" /></th>
<th><button  class="btn btn-sm btn-success" ng-click="update(x)">update</button></th>
</tr>


</table>


</body>


</html>