<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>data entry</title>
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
	
	
$scope.products=[];

       var p1={"code":"","name":"","unitprice":null,"company":"","description":""};
       var p2={"code":"","name":"","unitprice":null,"company":"","description":""};
       var p3={"code":"","name":"","unitprice":null,"company":"","description":""};
       
       $scope.products.push(p1); $scope.products.push(p2); $scope.products.push(p3); 
       
       $scope.company=[];
       $scope.catagory=["electronics","grocery","construction","gas","pharmacy","other"];
       
   $scope.choosecatagory=function(){
	   $scope.company=[];
	   
	  if($scope.chcatagory=="electronics"){
		  
		  $scope.company.push("SAMSUNG");     $scope.company.push("SONY");
$scope.company.push("WALTON");
$scope.company.push("LG");
$scope.company.push("VISION");
$scope.company.push("HUAWEI");
$scope.company.push("REDMI");
$scope.company.push("VIVO");$scope.company.push("APPLE");$scope.company.push("XIAOMI");
	  } 
	  
	  if($scope.chcatagory=="grocery"){
		  $scope.company=[];
		  $scope.company.push("PRAN","SQUARE","BD FOOD","ACI");
	  } 
	  
	  if($scope.chcatagory=="construction"){
		  $scope.company=[];
		  $scope.company.push("ALTRATECH","HOLCIM","BSRM","KSRM","SHAH");
	  }  
	  
	  if($scope.chcatagory=="gas"){
		  $scope.company=[];
		  $scope.company.push("LP","TOTAL","JOMUNA","LPG");
	  }  
	  
	  if($scope.chcatagory=="pharmacy"){
		  $scope.company=[];
		  $scope.company.push("ACI","BEXIMCO","SQUARE","RADIANT","OPSONIN","ARISTO PHARMA","DRUG INTERNATIONAL");
	  }  
	  
	  if($scope.chcatagory=="other"){
		  $scope.company=[];
		  $scope.company.push("SQUARE","DELTA","MAGGIE");
	  } 
	  
	   
   }
       
    $scope.addrow=function(i){
    		
  var p={"code":"","name":"","unitprice":null,"company":"","description":""}; 
   	   
   	   $scope.products.splice(i,0,p);  
      
              
                             }      
       
       
  $scope.removerow=function(i){
	  
      if($scope.products.length>2){
		$scope.products.splice(i,1); 
      }
      
   	}        
       
 
  
$scope.saveentry=function(){
	
document.getElementById("k").style.display="none";
	
$http({
		method:"POST",
		url:"${pageContext.request.contextPath}/product/saveentry",
		data: angular.toJson($scope.products),
		headers: {"Content-Type":"application/json"}}).
		then(function(response){
		
			
			alert(response.data.company);
			
			document.getElementById("k").style.display="block";
			
		})	
		
		
}



$scope.searchbyname=function(){
	
	$http({
			method:"POST",
			url:"${pageContext.request.contextPath}/product/searchbyname",
			data: $scope.schname,
			headers: {"Content-Type":"text/plain","responseType":"application/json"}}).
			then(function(response){
			
				$scope.schnamer=response.data;
				
	})	
			
			
	}



$scope.searchbycode=function(){
			
	$http({
			method:"POST",
			url:"${pageContext.request.contextPath}/product/searchbycode",
			data:$scope.schcode,
			headers: {"Content-Type":"text/plain","responseType":"application/json"}}).
			then(function(response){
			
		$scope.schcoder=response.data;
						})	
			
			
	}




$scope.searchbycompany=function(){
			
	$http({
			method:"POST",
			url:"${pageContext.request.contextPath}/product/searchbycompany",
			data:$scope.schcompany,
			headers: {"Content-Type":"text/plain","responseType":"application/json"}}).
			then(function(response){
			
		$scope.schcompanyr=response.data;
					
				
			})	
			
	}
	
	
	$scope.shopid=null; 	$scope.email=null;
	
	$scope.theshop=null;
	
$scope.byshopid=function(){

		$http({
			method:"POST",
			url:"${pageContext.request.contextPath}/shopbyid",
			data:$scope.shopid,
			headers: {"Content-Type":"text/plain","responseType":"application/json"}}).
			then(function(response){
			
		$scope.theshop=response.data;
		
			if($scope.theshop.district=="not"){
				alert("no record found");
				
			}	
				
			})	
			
	}	
	


$scope.byemail=function(){
	

	$http({
			method:"POST",
			url:"${pageContext.request.contextPath}/shopbyemail",
			data:$scope.email,
			headers: {"Content-Type":"text/plain","responseType":"application/json"}}).
			then(function(response){
			
		$scope.theshop=response.data;
		
		if($scope.theshop.district=="not"){
			alert("no record found");
			
		}		
				
			})	
			
	}	
	
	
	
	
$scope.update=function(p){
	
	$http({
			method:"PUT",
			url:"${pageContext.request.contextPath}/product/update",
			data:angular.toJson(p),
			headers: {"Content-Type":"application/json"}}).
			then(function(response){
			
	alert(response.data.company);
					
				
			})	
	
}





});

</script>

</head>


<body ng-app="pressapp" ng-controller="presscon" style="text-align:center;background-color:#B0E0E6;padding:20px;border:1px solid black;margin:20px;" id="k" >


<div class="row">
<script type="text/javascript">
var a = ['1','2','3','4'];

function showdiv(i){
	for(var k=0;k<4;k++){
	if(i==a[k]){
	document.getElementById(a[k]).style.display="block";
	}	

	if(i!=a[k]){
		document.getElementById(a[k]).style.display="none";
	}
		
	}

	
}

function seex(){
	var s=["productname","productcode","company"];
	
var r=document.getElementById("chv").value;

for(var i=0;i<3;i++){
	
if(s[i]==r){
	document.getElementById(s[i]).style.display="block";
}	
else{
	document.getElementById(s[i]).style.display="none";
}

	
}

}

</script>


<div class="col" onclick="showdiv(1)" style="background-color:white;">
<h4>enter product info</h4>
</div>

<div class="col" onclick="showdiv(2)" style="background-color:darkslategrey;">
<h4 style="color:white;">edit product</h4>
</div>
<div class="col" onclick="showdiv(3)" style="background-color:gray;">
<h4 style="color:white;">find shop</h4>
</div>

</div>


<div id="3" style="display:none;">
<h4>search a shop by id or email</h4>

<span>
<input type="text" ng-model="shopid" placeholder="enter shop id" /> 
<button ng-click="byshopid()" class="btn btn-dark btn-sm">search</button>
</span>

<span><input type="text" ng-model="email" placeholder="email id of shop" />
<button ng-click="byemail()" class="btn btn-dark btn-sm">search</button>
</span>

<br/>
<br/>
<table ng-if="theshop.district!='not' && theshop!=null" align="center">
<tr><td>shop id:{{theshop.uid}}</td></tr>
<tr><td>catagory:{{theshop.catagory}}</td></tr>
<tr><td>district:{{theshop.district}}</td></tr>
<tr><td>thana:{{theshop.thana}}</td></tr>
<tr><td>phone:{{theshop.phone}}</td></tr>
<tr><td>email:{{theshop.email}}</td></tr>
</table>


</div>


<div id="2" style="display:none;background-color:#6f4e37;">
<br/>
<h4>Search By::</h4>
<select id="chv"  onchange="seex();">
<option value="--">---</option>
<option value="productname" >product name</option>
<option value="productcode">product code</option>
<option value="company">company</option>
</select>

<div id="productname" style="display:none;">
<h4>type product name</h4> <input type="text"  ng-keyup="searchbyname()" ng-model="schname"/>
<br/>
<table align="center" ng-if="schnamer.length>0">
<tr>
<th>index</th>
<th>company name</th>
<th>product name</th>
<th>product code</th>
<th>unit price</th>
<th>update</th>
</tr>

<tr ng-repeat="x in schnamer">
<th>{{$index+1}}</th>
<th><input type="text" ng-model="x.company" style="width:100px;" /></th>
<th><input type="text" ng-model="x.name" style="width:100px;" /></th>
<th><input type="text" ng-model="x.code" style="width:100px;" /></th>
<th><input type="number"  ng-model="x.unitprice" /></th>
<th><button ng-click="update(x)" class="btn btn-sm btn-primary">update</button></th>
</tr>
</table>
<br/>
<br/>
</div>

<div id="productcode" style="display:none;">
<h4>type product code::</h4><input type="text" ng-keyup="searchbycode()" ng-model="schcode"/>
<br/>
<table align="center" ng-if="schcoder.length>0">
<tr>
<th>index</th>
<th>company name</th>
<th>product name</th>
<th>product code</th>
<th>unit price</th>
<th>update</th>
</tr>

<tr ng-repeat="x in schcoder">
<th>{{$index+1}}</th>
<th><input type="text"  ng-model="x.company" /></th>


<th><input type="text" ng-model="x.name" style="width:100px;" /></th>
<th><input type="text" ng-model="x.code" style="width:100px;" /></th>
<th><input type="number"  ng-model="x.unitprice" style="width:100px;" /></th>
<th><button ng-click="update(x)" class="btn btn-sm btn-primary">update</button></th>
</tr>

</table>
<br/>
<br/>

</div>




<div id="company" style="display:none;">
<h4>type company</h4><input type="text" ng-keyup="searchbycompany()" ng-model="schcompany"/>
<br/>
<table align="center" ng-if="schcompanyr.length>0">
<tr>
<th>index</th>
<th>company name</th>
<th>product name</th>
<th>product code</th>
<th>unit price</th>
<th>update</th>
</tr>

<tr ng-repeat="x in schcompanyr">
<th>{{$index+1}}</th>
<th><input type="text" ng-model="x.company" style="width:100px;" /></th>
<th><input type="text" ng-model="x.name" style="width:100px;" /></th>
<th><input type="text" ng-model="x.code" style="width:100px;" /></th>
<th><input type="number"  ng-model="x.unitprice" /></th>
<th><button ng-click="update(x)" class="btn btn-sm btn-primary">update</button></th>
</tr>

</table>
<br/>
<br/>
</div>

</div>





<div id="1" style="display:none;">
<h4 >enter product info</h4> <br/>

<br/>
<br/>
<b>catagory:</b><select ng-options="c for c in catagory"  ng-model="chcatagory" style="width:100px;" ng-change="choosecatagory()"></select>
<b>enter company:</b><select ng-options="c for c in company"  ng-model="products[0].company" style="width:100px;"></select>
<br/><br/>

<table align="center">
<tr>
<th>entry no</th>
<th> name </th>
<th>code </th>
<th>unit price</th>
<th>task</th>
</tr>

<tr ng-repeat="x in products" >
<td><b>{{$index+1}}</b></td>

<td>
<input  type="text"  ng-model="x.name" style="width:100px;" placeholder="product name"  />
</td>

<td>
<input  type="text"  ng-model="x.code" style="width:100px;"  placeholder="product code"  />
</td>

<td>
<input  type="number"  ng-model="x.unitprice" style="width:70px;"  />
</td>

<td>

<button class="btn btn-xsm btn-success" ng-click="removerow($index)"><h4>-</h4></button> 

<button class="btn btn-xsm btn-success" ng-click="addrow($index)" ><h4>+</h4></button>

</td>

</tr>

</table>
<br/>
<br/>
<button ng-click="saveentry()" class="btn btn-sm btn-success">save entry</button>

</div>




</body>




</html>