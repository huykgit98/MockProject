<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<body>
	<div class="container">
		<div class="row">

			<div class="col-md-12">

				<a type="button" class="btn btn-success float-right btn-sm" href="createNewUser.jsp">
					<i class="fas fa-plus"></i> Insert User
				</a>
				
				<br> <br>
				<script language="JavaScript"
					src="https://code.jquery.com/jquery-1.11.1.min.js"
					type="text/javascript"></script>
				<script language="JavaScript"
					src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"
					type="text/javascript"></script>
				<script language="JavaScript"
					src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js"
					type="text/javascript"></script>
				<link rel="stylesheet" type="text/css"
					href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

				<link rel="stylesheet" type="text/css"
					href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">

				<table id="datatable" class="table table-striped table-bordered"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th>ID</th>
							<th>User Name</th>
							<th>PassWord</th>
							<th>Full Name</th>
							<th>Address</th>
							<th>Number Phone</th>
							<th>Status</th>
							<th>Role</th>
							<th>Edit</th>

						</tr>
					</thead>

					<tbody>
						<c:forEach items="${listUser}" var="lUser">
							<tr>
								<td>${lUser.idUser}</td>
								<td>${lUser.userName}</td>
								<td>${lUser.passWord}</td>
								<td>${lUser.fullNameUser}</td>
								<td>${lUser.addressUser}</td>
								<td>${lUser.phoneUser}</td>
								<td><c:if test="${lUser.statusUser==false}">
										<c:out value="Block"></c:out>
									</c:if> <c:if test="${lUser.statusUser==true}">
										<c:out value="Access"></c:out>
									</c:if></td>

								<td>${lUser.roleModel.roleName}</td>
								<td>
									<p data-placement="top" data-toggle="tooltip" title="Edit">
										<a class="btn btn-primary btn-xs" type="submit"
											style="margin-left: 30%"
											href="functionUserController?action=edit&txtIdUser=${lUser.idUser}">
											<span class="glyphicon glyphicon-pencil" style="color: white"></span>
										</a>
									</p>
								</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>


	<script>
		$(document).ready(function() {
			$('#datatable').dataTable();

			$("[data-toggle=tooltip]").tooltip();

		});
	</script>


</body>