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
							<th class="col-3 col-sm-2">BookingID</th>
							<th class="col-3 col-sm-2">Place Start</th>
							<th class="col-3 col-sm-2">Place End</th>
							<th class="col-3 col-sm-2">Date Start</th>
							<th class="col-3 col-sm-2">Time Start</th>
							<th class="col-3 col-sm-2">View detail</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach items="${listTicketOfCustomer}" var="lTicket">
							<tr>
								<td>${lTicket.bookingID }</td>
								<td>${lTicket.startPlace }</td>
								<td>${lTicket.finishPlace }</td>
								<td>${lTicket.dateStart }</td>
								<td>${lTicket.timeStart }</td>
								<td>
									<p data-placement="top" data-toggle="tooltip" title="Edit">
										<a class="btn btn-primary btn-xs" type="submit"
											style="margin-left: 30%" href="detailTicKetController?action=viewdetails&txtBookingId=${lTicket.bookingID}"
											>
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