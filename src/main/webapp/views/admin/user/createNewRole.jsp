<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">

			<div class="col-md-12">
				<h3>Add new Role</h3>
				<br>
				<form class="form-horizontal" action="functionServlet" method="get"
					enctype="multipart/form-data">

					<div class="form-group">
						<label class="control-label col-sm-2">Name Role:</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="name_role" required>
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
</body>
</html>