<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>	

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link href="<c:url value='${pageContext.request.contextPath}/template/login/style.css' />" rel="stylesheet" type="text/css" media="all"/>
	  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/template/login/style.css">
</head>
<body>
	<div class="container">
	<p style="color: red;">${errorString}</p>
	
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form" >
			<div class="main-div">
				<form id="formLogin" method="POST" action="${pageContext.request.contextPath}/login">
					<input type="hidden" name="redirectId" value="${param.redirectId}" />
					
					<div class="form-group">
						<input type="text" class="form-control" id="userName" name="userName" value="${user.userName}"
							placeholder="Enter Username">
					</div>

					<div class="form-group">
						<input type="password" class="form-control" id="password" name="password" value="${user.password}"
							placeholder="Enter Password">
					</div>
					
					<button type="submit" class="btn btn-primary" >Login</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>