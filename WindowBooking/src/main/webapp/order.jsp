<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="login" class="database.LoginBean" scope="session"/>
<jsp:useBean id="order" class="database.OrderBean" scope="session"/>
<jsp:useBean id="product" class="database.WindowCombinationBean" scope="session"/>

<!DOCTYPE html>
<html>
	<head>
		<title>Order - Sales Application</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	</head>
	<body><br><br>
		<div class = "container text-center border" style="padding-left: 400px; padding-top: 50px; padding-bottom: 50px">
			<form method="post">
				<table border="1">
					<tbody>
						<div class="card" style="width: 30rem; height:28rem">
  						<ul class="list-group list-group-flush">
  						
  						<li class="list-group-item">
    					<p><h5>Welcome Customer ${login.customerId }</h5></p>
    					</li>
    					<li class="list-group-item">
    					<p>
							Product Number <br/>
							<select name="productNumber">						
								<c:forEach var="entry" items="${ product.winc }">
									<option>${entry.productNumber }</option>
								</c:forEach>
							</select>
						</p>
    					</li>
    					<li class="list-group-item"><p>Quantity <br/><input type="text" name="qty" /></p></li>
    					<li class="list-group-item"><p><input class="btn btn-dark" type="submit" name="submit" value="Order" /></p></li>
    					<li class="list-group-item"><p><a href="invoice.jsp"><button type="button" class="btn btn-dark">Invoice</button></a></p></li>
    					<li class="list-group-item"><c:if test="${param.submit == 'Order' }">
						<b>New Order Number : </b> ${ order.placeOrder(login.customerId, param.productNumber, param.qty)}<br></c:if></p></li>
  						</ul>
						</div>		
					</tbody>
				</table>
			</form>	
		</div><br>
	</body>
</html>









    