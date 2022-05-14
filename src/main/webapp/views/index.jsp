<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>my favourite shop</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/static/theme/bootstrap431.css" /> " rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="<c:url value="/static/theme/jquery340.js" />" > </script> 
<script src="<c:url value="/static/theme/angular1.8.2.js" />" > </script>
<script src="<c:url value="/static/theme/bootstrap431.js" />" > </script>


<script>
var module=angular.module("sellapp",[]);
module.controller("sellcontrol",function($scope,$http){
	$scope.year=[];
	
	$scope.inityear=function(){
		for(i=2015;i<2040;i++){
			$scope.year.push(i);
		}
			}


$scope.day=["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"];
	
$scope.month=["1","2","3","4","5","6","7","8","9","10","11","12"];
	
	

//order1

$scope.products=[];
$scope.check=["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1",
"1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"];
		

$scope.checkfilt=function(i){
			
		if($scope.check[i]=="0"){
			return true;
		}	
	 	
		if($scope.check[i]=="1"){
			return  false;
		}
		
	                  }
		
		
	
var r=0;
$scope.findproduct=function(i,sby){
	
	if($scope.check[i]=="0"){
		r=i;
		$scope.psh={"name":$scope.order[i].name,"company":$scope.order[0].company,"sby":sby,"code":$scope.order[i].code};
		
		$http({
			method:"POST",
			data:angular.toJson($scope.psh),
			url:"${pageContext.request.contextPath}/product/filterproduct",
	        headers:{"Content-Type":"application/json"}}
			
		).then(function(response){
			
			$scope.products=response.data;
		
		})
	}
	
	if($scope.check[i]=="1"){

		alert("click edit button to edit");
	}
	
}



$scope.filltext=function(v){
	

	$scope.order[r]=v; 
	$scope.order[r].totalprice=v.unitprice*v.amount;
	$scope.check[r]="1";
	
	$scope.products=[];
	
	
}

$scope.setprice=function(i,v){
	r=i;
	$scope.order[r].totalprice=v.unitprice*v.amount;	
}



$scope.editorder=function(i){

	$scope.check[i]="0";
		
}



   $scope.orderday=""; $scope.ordermonth=""; $scope.orderyear=""; 
	
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
	
	
var o1={"trid":"","company":"","shopid":"", "name":"","code":"","amount":"","unitprice":"",
		"totalprice":"","due":"","stringorderdate":""};  
	
var o2={"trid":"","company":"","shopid":"", "name":"","code":"","amount":"","unitprice":"",
		"totalprice":"","due":"","stringorderdate":""};   
			
var o3={"trid":"","company":"","shopid":"", "name":"","code":"","amount":"","unitprice":"",
		"totalprice":"","due":"","stringorderdate":""};  

$scope.order=[]; 
$scope.order.push(o1,o2,o3);	
	

$scope.addorder=function(i){
var o={"trid":"","company":"","shopid":"", "name":"","code":"","amount":"","unitprice":"",
			"totalprice":"","due":"","stringorderdate":""};  
	$scope.order.splice(i,0,o);
}


$scope.removeorder=function(i){
	if($scope.order.length>1){
		$scope.order.splice(i,1);
	}

}	

$scope.saveorder=function(){
	
	$scope.order[0].stringorderdate=$scope.orderday+"/"+$scope.ordermonth+"/"+$scope.orderyear;
	
	$http({
		
		method:"POST",
		data:angular.toJson($scope.order),
		url:"${pageContext.request.contextPath}/order/saveorder",
        headers:{"Content-Type":"application/json"}}
		
	).then(function(response){
		
	alert(response.data.company);
	
	})
	
	}
	

})



var arr=["1","2","3","4","5","6","7","8","9","c","d","e","x","y","z"];
function showdiv(i){
	for(var x=0;x<15;x++){
		
		if(arr[x]==i){
			
			document.getElementById(arr[x]).style.display="block";
		
		
		}
		
		if(arr[x]!=i){
			
			
			document.getElementById(arr[x]).style.display="none";
			
			
			}
	}
	
}


</script>


 <script type="text/javascript">
 var ss=["p","q","r","s","t"];
 
 function shos(i,el){
	 	 
	for(var x=0;x<5;x++){
		
		if(ss[x]==i){
			document.getElementById(ss[x]).style.display="block";
		
		}
		if(ss[x]!=i){
			document.getElementById(ss[x]).style.display="none";
	
		}	
		
	}
	
	
	
	
	var chil = document.getElementById("fat").children;
	
	var l=chil.length;
	
	for(var t=0;t<l;t++){

		chil[t].style.background="skyblue";
		
		if(el==chil[t]){
		el.style.background="green";	el.style.color="white";
		
		}


		}
	
	
	
	
	 
 }
 
 
 </script>

<style>


body{
box-sizing:border-box;
background-image:url("/static/theme/sea.jpg");
background-size:1400px 500px;

}


span:hover{
color:red;
background-color:skyblue;
}
table td:hover{
background-color:silver; color:green;

}

input:hover{
background-color:maroon; color:white;

}

table{
overflow-x:scroll;
}

table th{
wrap-word:break-word;
background-color:black;
color:white;
padding:8px;
}

table td{
wrap-word:break-word;
background-color:white;
color:black;
text-align:center;
}

a:hover{
background-color:steelblue;

}


.dropdown-menu a:hover{
background-color:steelblue;

}

</style>

</head>
<body  ng-controller="sellcontrol"  ng-app="sellapp"  ng-init="inityear();" id="mbd">
<%
if(session.getAttribute("adminuser")==null && session.getAttribute("adminpass")==null){
	response.sendRedirect("${pageContext.request.contextPath}"); 
	}

	  %>


	

<nav class="navbar navbar-expand-lg" style="margin-right:7%;margin-left:8%;margin-top:2%;border-radius:8px;background-color:darkslategrey;">
  <a class="navbar-brand" href="#" style="margin-left:5%;color:maroon;background-color:orange;">দোকানের হিসাব খাতা </a>
   <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon" style="color:white;"><b>click</b></span>
  </button> 

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" style="margin-left:5%;color:white;" role="button" 
        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          মাল অর্ডার
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#" onclick="showdiv('1');">অর্ডার  Invoice  লিখুন</a> <!-- //order1 -->
          <a class="dropdown-item" href="#" onclick="showdiv('2');">মাসিক অর্ডার দেখুন </a> <!-- //order2 -->
          <a class="dropdown-item" href="#" onclick="showdiv('x');"> আজকের  অর্ডার </a>  <!-- //order3 -->
          <a class="dropdown-item" href="#" onclick="window.open('${pageContext.request.contextPath}/searchorder')">আরও  সার্চ করুন </a>
             </div>
       </li>
    
       <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" style="margin-left:5%;color:white;" role="button" 
        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          মাল বিক্রি 
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
        <a class="dropdown-item" href="#" onclick="showdiv('4');">বিক্রির  INVOICE লিখুন</a> <!-- //sell1 -->
        <a class="dropdown-item" href="#" onclick="showdiv('5');">মাসিক  বিক্রি দেখুন</a> <!-- //sell2 -->
       <a class="dropdown-item" href="#" onclick="showdiv('y');"> আজকের  বিক্রি  </a>  <!-- //sell3 --> 
   <a class="dropdown-item" href="#" onclick="window.open('${pageContext.request.contextPath}/searchsell')">আরও  সার্চ করুন </a>
      
        </div>
       </li>     
      
      
    <li class="nav-item dropdown" style="padding-left:20px;">  <!-- //stock -->
      <a class="nav-link" href="#" style="margin-left:5%;color:white;" role="button"  onclick="showdiv('e');" 
        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        স্টক </a>

     </li> 
     
     
       <li class="nav-item dropdown" style="padding-left:20px;">   <!-- //bank -->
      <a class="nav-link" href="#" style="margin-left:5%;color:white;" role="button"  onclick="showdiv('z');"
        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
      ব্যাংক </a>       

     </li>   
     
             
              <li class="nav-item dropdown" style="padding-left:20px;">    <!--   //due1 -->  <!--   //due2 -->
      <a class="nav-link" href="#" style="margin-left:5%;color:white;" role="button" 
        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         বকেয়া </a>
               <div class="dropdown-menu" aria-labelledby="navbarDropdown">
         <a class="dropdown-item" href="#" onclick="showdiv('c');">বিক্রির  বকেয়া</a>     
         <a class="dropdown-item" href="#" onclick="showdiv('d');">অর্ডারের বকেয়া </a>

            </div>
             </li>   
      
       
    
     
               <li class="nav-item dropdown" style="padding-left:20px;">
      <a class="nav-link" href="#" style="margin-left:5%;color:white;" role="button"  onclick="showdiv('3');"
        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        ক্যালকুলেটর  </a>

     </li> 
        </ul>
      </div>
</nav>



<!-- //stock -->
 <div  style="margin-left:8%;text-align:center;background-color:white;width:85%;display:none;font-size:0.80em;padding-bottom:15px;" id="e">

 <h>stock</h>

</div>



<div style="text-align:center;background-color:white;width:85%;display:none;font-size:0.80em;margin-left:8%;" id="3">
 
<style>
 
 .container {
    max-width: 400px;
    margin: 10vh auto 0 auto;
    box-shadow: 0px 0px 43px 17px rgba(153,153,153,1);
}

#display {
    text-align: right;
    height: 70px;
    line-height: 70px;
    padding: 8px;
    font-size: 25px;
}

.buttons {
    display: grid;
    border-bottom: 1px solid #999;
    border-left: 1px solid#999;
    grid-template-columns: 1fr 1fr 1fr 1fr;
}

.buttons > div {
    border-top: 1px solid #999;
    border-right: 1px solid#999;
}

.button {
    border: 0.5px solid #999;
    line-height: 50px;
    text-align: center;
    font-size: 25px;
    cursor: pointer;
}

#equal {
    background-color: rgb(85, 85, 255);
    color: white;
}

.button:hover {
    background-color: #323330;
    color: white;
    transition: 0.5s ease-in-out;
}
 
 </style>
 
<h4 style="color:white;">মাল এর  অর্ডার   লিখুন</h4>
 <div class="container">
            <div id="display"></div>
            <div class="buttons">
                <div class="button">C</div>
                <div class="button">/</div>
                <div class="button">*</div>
                <div class="button">&larr;</div>
                <div class="button">7</div>
                <div class="button">8</div>
                <div class="button">9</div>
                <div class="button">-</div>
                <div class="button">4</div>
                <div class="button">5</div>
                <div class="button">6</div>
                <div class="button">+</div>
                <div class="button">1</div>
                <div class="button">2</div>
                <div class="button">3</div>
                <div class="button">.</div>
                <div class="button">(</div>
                <div class="button">0</div>
                <div class="button">)</div>
                <div id="equal" class="button">=</div>
            </div>
        </div>
        
        <script type="text/javascript">
        var display = document.getElementById('display');

        var buttons = Array.from(document.getElementsByClassName('button'));

        buttons.map( button => {
            button.addEventListener('click', (e) => {
                switch(e.target.innerText){
                    case 'C':
                        display.innerText = '';
                        break;
                    case '=':
                        try{
                            display.innerText = eval(display.innerText);
                        } catch {
                            display.innerText = "Error"
                        }
                        break;
                    case '←':
                        if (display.innerText){
                           display.innerText = display.innerText.slice(0, -1);
                        }
                        break;
                    default:
                        display.innerText += e.target.innerText;
                }
            });
        });

        
        </script>
<br/>
<br/>

</div>
 
 
 
 <!--  //order1 -->
 

 <div  style="text-align:center;background-color:darkseagreen;width:85%;display:none;font-size:0.80em;margin-left:8%;" id="1">
<h4 style="color:white;">অর্ডার  INVOICE লিখুন</h4>
<br/><br/>

<span><b>Date(day/month/year):-</b>
day:<select ng-options="c for c in day" ng-model="orderday"></select>

month:<select  ng-options="c for c in month" ng-model="ordermonth" ></select>

year:<select  ng-options="c for c in year" ng-model="orderyear" ></select>
</span> <br/>

<b>catagory:</b><select ng-options="c for c in catagory"  ng-model="chcatagory" style="width:100px;" ng-change="choosecatagory()"></select>
<b>enter company:</b><select ng-options="c for c in company"  ng-model="order[0].company" style="width:100px;"></select>
<br/><br/>

<b>Bank transaction id:-</b> <input type="text" ng-model="order[0].trid" /> <br/>
<b>Shop id:-</b> <input type="text" ng-model="order[0].shopid" /> <br/>
<b>due:-</b> <input type="text" ng-model="order[0].due" /> <br/>

<br/> <br/>
		
<table border="1" align="center" > 
<tr>
<th>index</th>
<th>product name</th>
<th>product code</th>
<th>amount</th>
<th>unit price</th>
<th>total price</th>
<th>task</th>
<th>edit</th>
</tr>
<tr  ng-repeat="x in order">
<td>{{$index+1}}</td>
<td>
<input type="text"  ng-model="x.name"  ng-keyup="findproduct($index,'byname')" />
<ul class="list-group" ng-if="checkfilt($index)">
<li class="list-group-item" ng-repeat="k in products" ng-click="filltext(k)">{{k.code}} {{k.name}}
</li>
</ul>

</td>
<td><input type="text"  ng-model="x.code"  ng-keyup="findproduct($index,'bycode')"  />
<ul class="list-group" ng-if="checkfilt($index)">
<li class="list-group-item" ng-repeat="k in products" ng-click="filltext(k)">{{k.code}} {{k.name}}
</li>
</ul>

</td>

<td><input type="number"  ng-model="x.amount" ng-keyup="setprice($index,x)" /></td>
<td><input type="number"  ng-model="x.unitprice" /></td>
<td><input type="number"  ng-model="x.totalprice" /></td>
<td><button class="btn btn-primary btn-sm" ng-click="addorder($index)">(+)</button> <br/> <br/>
<button class="btn btn-primary btn-sm" ng-click="removeorder($index)">(-)</button></td>
<td>

<button class="btn btn-primary btn-sm" ng-click="editorder($index)">edit</h4></button>

</td>
</tr>

</table>
<br/>
<button class="btn btn-success btn-sm" ng-click="saveorder()" >submit</button>


<br/>
<br/>
<br/>

</div>




 <!--  //order2 -->
<div  style="margin-left:8%;background-color:skyblue;width:85%;display:none;font-size:0.80em;padding:20px;text-align:center;" id="2">
<h4>মাসিক  অর্ডার দেখুন  ==id=2</h4>

</div>


 <!--  //order3 -->
<div  style="margin-left:8%;background-color:skyblue;width:85%;display:none;font-size:0.80em;padding:20px;text-align:center;" id="x">
<h4>আজকের মোট অর্ডার   id=x</h4>

</div>


<div  style="margin-left:8%;background-color:darkcyan;width:85%;display:none;font-size:0.80em;padding:20px" id="3">

<h5 style="margin-left:30%;color:white;">আরও  অর্ডারের তথ্য খুজুন   id="3"</h5>
	 
</div>


<!-- -//sell1 -->
<div  style="text-align:center;margin-left:8%;background-color:gray;width:85%;display:none;font-size:0.80em;padding:20px" id="4">


<h4 style="color:white;">বিক্রির  Invoice লিখুন  id="4"</h4>


</div>


<!-- -//sell2 -->
<div  style="margin-left:8%;text-align:center;background-color:burlywood;width:85%;display:none;font-size:0.80em;" id="5">

  <h4 style="text-align:center;color:white;">মাসিক  বিক্রি হিসাব  id="5"</h4>

</div>


<!-- -//sell3 -->
<div  style="margin-left:8%;background-color:skyblue;width:85%;display:none;font-size:0.80em;padding:20px;text-align:center;" id="y">
<h4> আজকের  মোট বিক্রি id=y</h4>

</div>



<!-- //bank -->
<div  style="margin-left:8%;background-color:skyblue;width:85%;display:none;font-size:0.80em;padding:20px;text-align:center;" id="z">
<h4>ব্যাংক এর স্টক </h4>

</div>


<!-- //due1 -->
<div  style="text-align:center;margin-left:8%;background-color:gray;width:85%;display:none;font-size:0.80em;padding:20px" id="c">

<h>id="c"</h>


</div>


<!-- //due2 -->

<div  style="text-align:center;margin-left:8%;background-color:gray;width:85%;display:none;font-size:0.80em;padding:20px" id="d">

<h>id="d"</h>

</div>



</body>

</html>
