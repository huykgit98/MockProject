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
		<form class="form-horizontal" action="functionUserController"
			method="get" enctype="multipart/form-data">
			<div class="form-group">
				<div class="col-sm-4">
					<input type="hidden" class="form-control" name="txt_id_name_user"
						value="${userEdit.idUser }" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Full Name:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="txt_full_name_user"
						value="${userEdit.fullNameUser }" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">User Name:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control"
						value="${userEdit.userName }" name="txt_name_user_login" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">Address :</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="txt_address_user"
						value="${userEdit.addressUser }" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2">NumberPhone:</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="txt_phone_user"
						value="${userEdit.phoneUser }" required="required">
				</div>
			</div>
			<div class="form-group">
				<label for="sel1" class="control-label col-sm-2">Select
					Role:</label>
				<div class="col-sm-4">
					<select class="form-control" name="idOptionRole">
						<option value="${userEdit.roleModel.roleId}">${userEdit.roleModel.roleName }</option>
						<c:forEach items="${listRoleF}" var="lRoleF">
							<c:if test="${lRoleF.roleId!= userEdit.roleModel.roleId}">
								<option value="${lRoleF.roleId}">${lRoleF.roleName }</option>
							</c:if>
						</c:forEach>
					</select> <input type="hidden" class="form-control" name="action"
						value="updateUser">
				</div>
			</div>


			<div class="form-group text-center ml-5">
				<button class="btn btn-primary" type="submit"
					onclick="javascript:window.location.reload()">Save</button>
				<a type="button" class="btn btn-danger" data-dismiss="modal" href="listUser.jsp">Close</a>
			</div>
		</form>
	</div>
</body>
</html>