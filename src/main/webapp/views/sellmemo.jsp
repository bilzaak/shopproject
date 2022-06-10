<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cash memo of sells</title>
</head>
<body>

<section align="center" style="margin-top:60px;">
<b>cash memo id : ${sellm.sells[0].memokey}</b> <br/> <br/>
printing date :-<input type="text" name="xc" /> <br/><br/>
customer name:- ${sellm.sells[0].customername} <br/>
selling date:-${sellm.sells[0].stringselldate} <br/>

</section>

<br/>
<section align="center">
total Bill:: ${sellm.totalsell} TK<br/>
total due:: ${sellm.totaldue} TK<br/>
total payment:: <c:out value="${sellm.totalsell-sellm.totaldue}" /> TK

</section>
<br/>

<table align="center" border="1">
<tr>
<th>product info</th>
<th>unit price</th>
<th>quantity</th>
<th>total</th>
</tr>
<c:forEach var="x" items="${sellm.sells}">
<tr>
<td>
company:${x.company} <br/>
product: ${x.name} <br/>
code: ${x.code}<br/>
</td>
<td>
${x.unitprice}
</td>
<td>${x.amount}</td>
<td>${x.totalprice}</td>

</tr>
 </c:forEach> 
</table>
</body>
</html>