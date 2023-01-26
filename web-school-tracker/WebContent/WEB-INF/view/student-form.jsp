<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student Page</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>


<style>
.error {
	color: red
}
</style>

</head>
<body>
	<nav
		class="navbar navbar-dark bg-dark navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}">HomePage</a></li>
				<li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath}/student/list">Student</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/course/list">Courses</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/instructor/list">Instructor</a></li>
			</ul>
		</div>
		<button class="btn btn-primary" type="button">Logout</button>
	</nav>

	<div class="text-center">
		<h1 class="display-1">ADD STUDENT</h1>
	</div>

	<div id="container">

		<form:form action="saveStudent" modelAttribute="student"
			method="POST">

			<form:hidden path="id" />
			<div class="mb-3">
				<table>
					<tbody>
						<tr>
							<td><label class="form-label">First name</label></td>
							<td><form:input class="form-control" path="firstName" /></td>
							<td><strong><form:errors path="firstName" cssClass="error"></form:errors></strong><td>
						</tr>
						<tr>
							<td><label class="form-label">Last name</label></td>
							<td><form:input class="form-control" path="lastName" /></td>
							<td><strong><form:errors path="lastName" cssClass="error"></form:errors></strong><td>
						</tr>
						<tr>
							<td><label class="form-label">email</label></td>
							<td><form:input class="form-control" path="email" /></td>
							<td><strong><form:errors path="email" cssClass="error"></form:errors></strong><td>
						</tr>

					</tbody>
				</table>
			</div>

			<button type="submit" style="margin-top: 20px" class="btn btn-success">Submit</button>


			<div style="">

					<button type="button" class="btn btn-danger"
						onclick="window.location.href='list'; return false;">Cancel</button>


			</div>

		</form:form>

	</div>



</body>
</html>