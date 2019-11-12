<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	$(document).ready(function() {
		$('#datatable').dataTable();

		$("[data-toggle=tooltip]").tooltip();

	});
</script>
<!------ Include the above in your HEAD tag ---------->

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
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<table id="datatable" class="table table-striped table-bordered"
					cellspacing="0" width="100%">
					<thead>
						<tr>
							<th class="col-3 col-sm-2">Seat</th>
							<th class="col-3 col-sm-2">Price</th>
							<th class="col-3 col-sm-2">Number Plate</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="listDetailBooking" var="list">
							<tr>
								<td><c:out value="${list.seatList }"></c:out></td>
								<td><c:out value="${list.price }"></c:out></td>
								<td><c:out value="${list.NumberPlate }"></c:out></td>
							</tr>
						</c:forEach>
						<%-- <c:forEach var="listDetail" items="${listDetailBooking}" >
							<tr>
								<td>${listDetail.seatList }</td>
								<td>${listDetail.price }</td>
								<td>${listDetail.NumberPlate }</td>
							</tr>
						</c:forEach> --%>
					</tbody>
				</table>
			</div>
		</div>
	</div>