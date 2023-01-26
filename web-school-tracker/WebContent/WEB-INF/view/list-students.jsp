<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List Page</title>

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
</head>
<body>
	<nav
		class="navbar navbar-dark bg-dark navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"href="${pageContext.request.contextPath}">HomePage</a></li>
				<li class="nav-item"><a class="nav-link active" href="#">Student</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/course/list">Courses</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/instructor/list">Instructor</a></li>
			</ul>
		</div>
		<button class="btn btn-primary" type="button">Logout</button>
	</nav>
	<div class="text-center">
		<h1 class="display-1">STUDENTS</h1>
		<input type="button" value="Add Student"
			onclick="window.location.href='showFormForAdd'; return false;"
			class="btn btn-success btn-sm" />
	</div>

	<table class="table table-hover table-dark table-striped">
		<thead class="table-dark">
			<tr>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Email</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<c:forEach var="tempStudent" items="${students}">

			<!-- Construct an update link with customer id -->
			<c:url var="updateLink" value="/student/showFormForUpdate">
				<c:param name="studentId" value="${tempStudent.id}"></c:param>
			</c:url>

			<c:url var="deleteLink" value="/student/delete">
				<c:param name="studentId" value="${tempStudent.id}"></c:param>
			</c:url>

			<c:url var="viewLink" value="/student/view">
				<c:param name="studentId" value="${tempStudent.id}"></c:param>
			</c:url>
			<tr>
				<td>${tempStudent.firstName}</td>
				<td>${tempStudent.lastName}</td>
				<td>${tempStudent.email}</td>
				<td>
					<a href="${viewLink}" class="btn btn-primary btn-sm">View</a>

					<a href="${updateLink}" class="btn btn-info btn-sm">Update</a> 
					
					<a href="${deleteLink}" class="btn btn-danger btn-sm"
						
						onclick="if (!(confirm('Are you aure you want to delete this student?'))) return false">Delete</a>

				</td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>