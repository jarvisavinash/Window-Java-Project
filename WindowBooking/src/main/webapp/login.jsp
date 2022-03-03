

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="login" class="database.LoginBean" />
<jsp:setProperty name="login" property="*" />

<!DOCTYPE html>
<html>
<head>
	<title>Login - Sales Application</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<link rel="stylesheet" href="Login.css">	
</head>
<body>

	<section class="vh-100">
  <div class="container-fluid h-custom">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-md-9 col-lg-6 col-xl-5">
        <img src="https://images.unsplash.com/photo-1551524163-d00af9f12253?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=725&q=80" class="img-fluid rounded"
          alt="Sample image" width="600" height="600">
      </div>
      <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
        <form method="post" action="login">

          <div class="divider d-flex align-items-center my-4">
            <p class="text-center fw-bold mx-3 mb-0">Log In</p>
            
          </div>
          
          <!-- Customer ID input -->
          <div class="form-outline mb-4">
            <input type="text" name="customerId" id="form3Example3" class="form-control form-control-lg"
              placeholder="Enter a valid Customer ID" />
          </div>

          <!-- Password input -->
          <div class="form-outline mb-3">
            <input type="password" name="customerPassword" id="form3Example4" class="form-control form-control-lg"
              placeholder="Enter password" />
          </div>

          <div class="text-center text-lg-start mt-4 pt-2">

            <button type="submit" name="submit" value="Login" class="btn btn-primary btn-lg"
              style="padding-left: 2.5rem; padding-right: 2.5rem;">Log In</button>
              <p><br>
				${param.failed ? "<b style='color:red'>Authentication Failed</b>" : "Authentication Required" } 
			</p>
            <p class="small fw-bold mt-2 pt-1 mb-0">Don't have an account? <a href="register.jsp"
                class="link-danger">Register</a></p>
          </div>

        </form>
      </div>
    </div>
  </div>
 
    <!-- Right -->
    <div>
      <a href="#!" class="text-white me-4">
        <i class="fab fa-facebook-f"></i>
      </a>
      <a href="#!" class="text-white me-4">
        <i class="fab fa-twitter"></i>
      </a>
      <a href="#!" class="text-white me-4">
        <i class="fab fa-google"></i>
      </a>
      <a href="#!" class="text-white">
        <i class="fab fa-linkedin-in"></i>
      </a>
    </div>
</section>

</body>
</html>

