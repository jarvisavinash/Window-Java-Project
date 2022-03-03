<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="login" class="database.LoginBean" scope="session"/>
<jsp:useBean id="inv" class="database.InvoiceBean"/>

<!DOCTYPE html>
<html>
	<head>
		<title>Order - Sales Application</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		
	</head>
	<body>
		<div class="container-xxl text-center" style="padding-top:30px"><br>
		<h5>Welcome Customer <b>${login.customerId }</b></h5><br>
		
		<table class="table">
  			<thead>
   			 	<tr>
      				<th scope="col">Order Number</th>
      				<th scope="col">Order Date</th>
      				<th scope="col">Product Number</th>
      				<th scope="col">Quantity</th>
      				<th scope="col">Amount</th>
    			</tr>
  			</thead>
  			<tbody>
				<c:forEach var="entry" items="${inv.getInvoiceOf(login.customerId)}"><tr>
      				<td scope="col">${entry.orderNumber}</td>
      				<td scope="col">${entry.orderDate}</td>
      				<td scope="col">${entry.productNumber}</td>
      				<td scope="col">${entry.qty}</td>
      				<td scope="col">${entry.amount}</td>
    			</c:forEach>
    				<tr>
					<th colspan="4" align="right">Total Payment : </th>
					<td>$</td>
					</tr>
					
					<c:forEach var="entry" items="${inv.getInvoiceOf(login.customerId)}"></c:forEach>
					
  			</tbody>
			</table>
			
			<p>
			<a href="logout"><button type="button" class="btn btn-dark">Logout</button></a>
			</p><br>
			
		</div>
	</body>
</html>
