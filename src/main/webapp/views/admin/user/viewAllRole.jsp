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

<style type="text/css">
#menu ul li {
	display: inline;
}

#menu ul a {
	margin-top: 10px;
	text-decoration: none;
	width: 150px;
	float: left;
	color: #fff;
	font-weight: bold;
	text-align: center;
	line-height: 35px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div style="height: 50px; background-color: #6699ff;" id="menu">
					<ul>
						<li><a href="#"><b>Admin HomePage</b></a></li>
						<li><a href="listUser.jsp">Manager User</a></li>
						<li><a style="float: right" href="#">Logout</a></li>
					</ul>
				</div>
			</div>
			<div class="col-sm-offset-2 col-sm-8">
				<br>
				<br>
				<div>
					<a class="btn btn-success float-right" data-toggle="modal" href="#"
						data-target=".bd-example-modal-lg"> <i class="fas fa-plus"></i></i>
						Insert Role
					</a><a type="button" class="btn btn-danger" data-dismiss="modal"
						href="listUser.jsp">Close</a>
				</div>
				<br>
				<table id="datatable" class="table table-striped table-bordered"
					cellspacing="1">
					<thead>
						<tr>
							<th width="15%">Id</th>
							<th width="25%">Name role</th>
							<th width="50%">Description</th>
							<th width="10%">Update</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listRoleController}" var="lRole">
							<tr>
								<td>${lRole.roleId}</td>
								<td>${lRole.roleName}</td>
								<td>${lRole.roleDescription}</td>
								<td><a class="btn btn-primary btn-xs" type="submit"
									style="margin-left: 30%"
									href="functionServlet?action=editRole&txtId=${lRole.roleId}">
										<span class="glyphicon glyphicon-pencil" style="color: white"></span>
								</a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog"
		aria-labelledby="myLargeModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="container mt-2">
					<h3>Add new Role</h3>
					<br>
					<form class="form-horizontal" action="functionServlet" method="get"
						enctype="multipart/form-data">

						<div class="form-group">
							<label class="control-label col-sm-2">Name Role:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="name_role"
									required>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-2">Description Role:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" name="description_role"
									required> <input type="hidden" class="form-control"
									name="action" value="addNewRole">
							</div>

						</div>


						<div class="form-group text-center ml-5">
							<button class="btn btn-primary" type="submit"
								onclick="javascript:window.location.reload()">Add Role</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>