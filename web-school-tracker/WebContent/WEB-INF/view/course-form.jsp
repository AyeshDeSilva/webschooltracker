<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Course Page</title>
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
</head>
<body>
	<nav
		class="navbar navbar-dark bg-dark navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}">HomePage</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/student/list">Student</a></li>
				<li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath}/course/list">Courses</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/instructor/list">Instructor</a></li>
			</ul>
		</div>
		<button class="btn btn-primary" type="button">Logout</button>
	</nav>
	<div class="text-center">
		<h1 class="display-1">ADD COURSES</h1>
	</div>
	<div id="container">

		<form:form action="saveCourse" modelAttribute="course" method="POST">

			<form:hidden path="id" />
			
			<div class="mb-3">
				<table>
					<tbody>
						<tr>
							<td><label class="form-label">Course Code</label></td>
							<td><form:input class="form-control" path="courseCode" /></td>
							<td>
						</tr>
						<tr>
							<td><label class="form-label">Course Title</label></td>
							<td><form:input class="form-control" path="courseTitle" /></td>
						</tr>
					</tbody>
				</table>
			</div>

			<button type="submit" class="btn btn-success">Submit</button>

			<div style="">

				<button type="button" class="btn btn-danger"
					onclick="window.location.href='list'; return false;">Cancel</button>


			</div>

		</form:form>

	</div>
</body>
</html>