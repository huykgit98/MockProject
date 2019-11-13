<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">

			<div class="col-md-12">

				<h3>Add new user</h3>
				<br>
				<a href="">Back</a>
				<form class="form-horizontal" action="functionUserController"
					method="get" enctype="multipart/form-data">

					<div class="form-group">
						<label class="control-label col-sm-2">Full Name:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="txt_full_name_user"
								required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">User Name:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"
								name="txt_name_user_login" required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">Address :</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="txt_address_user"
								required>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">NumberPhone:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="txt_phone_user"
								id="txt_phone_user" pattern="[0-9]{10}">
						</div>
					</div>
					<div class="form-group">
						<label for="sel1" class="control-label col-sm-2">Select
							Role:</label>
						<div class="col-sm-4">
							<select class="form-control" name="idOptionRole">
								<c:forEach items="${listRole}" var="lRole">
									<option value="${lRole.roleId}">${lRole.roleName}</option>
								</c:forEach>
							</select> <input type="hidden" class="form-control" name="action"
								value="insertNewUser">
						</div>
					</div>
					<div class="form-group text-center ml-5">
						<button class="btn btn-primary" type="submit">Add User</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>
				</form>
			</div>
			</div>
			</div>
</body>
</html>