<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}"
	scope="session" />
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>User List</title>
<link href="${ctx}/resources/bootstrap-3.2.0-dist/css/bootstrap.min.css"
	rel="stylesheet">

<script src="${ctx}/resources/js/jquery-1.11.1.min.js"></script>
<script src="${ctx}/resources/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h3>User List</h3>
				<table class="table table-bordered">
					<thead>
						<tr class="info">
							<th>Id</th>
							<th>UserName</th>
							<th>Password</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="u" items="${users}">
							<tr>
								<td>${u.id}</td>
								<td>${u.username}</td>
								<td>${u.password}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-md-6"></div>
		</div>

		<div class="row">
			<div class="col-md-4">
				<form:form method="post" action="${ctx}/save" modelAttribute="user">
					<div class="form-group">
						<label>Id</label>
						<form:input path="id" cssClass="form-control col-md-2" />
					</div>
					<div class="form-group">
						<label>User Name</label>
						<form:input path="username" cssClass="form-control" />
					</div>
					<div class="form-group">
						<label>Password</label>
						<form:input path="password" cssClass="form-control" />
					</div>
					<button type="submit" class="btn btn-primary btn-sm">Add</button>
				</form:form>
			</div>
			<div class="col-md-6"></div>
		</div>
	</div>

</body>
</html>