<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<br> <br>
		<form class="form-horizontal" action="functionServlet" method="get"
			enctype="multipart/form-data">
			<div class="form-group">

				<div class="col-sm-4">
					<input type="hidden" class="form-control" name="txt_id_role"
						value="${roleEdit.roleId }" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Name Role:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="txt_name_role"
						value="${roleEdit.roleName }" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Description Role:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="description_role"
						name="txt_description_role" value="${roleEdit.roleDescription }"
						required> <input type="hidden" class="form-control"
						name="action" value="updateRole">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">

					<button class="btn btn-success" type="submit" value="submit">
						Save</button>
					<a type="button" class="btn btn-danger" data-dismiss="modal" href="viewAllRole.jsp">Close</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>