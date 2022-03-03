
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="login" class="database.LoginBean" scope="session"/>
<jsp:useBean id="register" class="database.RegisterBean"/>
<jsp:useBean id="window" class="database.WindowCombinationBean" />


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Window List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
	<div class="container-xxl text-center">
	<br>
	<h6>Welcome Customer ${register.customerId}</h6>
	<br><br>
	<h3>List of all Window Types</h3>
	<br>
	<table class="table table-sm">
  		<thead>
    		<tr>
      			<th scope="col">Product Number</th>
      			<th scope="col">Product Type</th>
      			<th scope="col">Standard Size</th>
      			<th scope="col">Product Rate</th>
      			<th scope="col">Stock</th>
    		</tr>
  		</thead>
  		<tbody>
  			<c:forEach var="entry" items="${ window.winc}"><tr>
      			<td scope="col">${entry.productNumber}</td>
      			<td scope="col">${entry.productType}</td>
      			<td scope="col">${entry.standardSize}</td>
      			<td scope="col">${entry.productRate}</td>
      			<td scope="col">${entry.stock}</td>
    		</c:forEach>
  		</tbody>
	</table> 
	
	<br><br><br><br>
	
		<a href='login.jsp'><button type="button" class="btn btn-dark">Login</button></a>
		
	</div>
	
	
</body>
</html>






