<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Student</title>
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
				<li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath}/student/list">Student</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/course/list">Courses</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/instructor/list">Instructor</a></li>
			</ul>
		</div>
		<button class="btn btn-primary" type="button">Logout</button>
	</nav>
	<div class="text-center">
		<h1 class="display-1">${student.firstName} ${student.lastName }</h1>
		<h1 class="header-4">${student.email}</h1>
		<c:url var="addCourse" value="/student/listCourse">
			<c:param name="studentId" value="${student.id }" />
		</c:url>
	    <a href="${addCourse}" class="btn btn-primary btn-sm">Add Course</a>
	</div>
	<table class="table table-hover table-dark table-striped">
		<thead class="table-dark">
			<tr>
				<th scope="col">Course Code</th>
				<th scope="col">Course Title</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<c:forEach var="tempStudent" items="${student.courses}">

			<c:url var="removeLink" value="/student/removeCourseFromStudent">
				<c:param name="courseId" value="${tempStudent.id}"></c:param>
				<c:param name="studentId" value="${student.id}"></c:param>
			</c:url>
			
			<tr>
				<td>${tempStudent.courseCode}</td>
				<td>${tempStudent.courseTitle}</td>
				<td>
						
					<a href="${removeLink}"
						class="btn btn-danger btn-sm"
						onclick="if (!(confirm('Are you aure you want to delete this Course from ${student.firstName}?'))) return false">Delete</a>

				</td>
			</tr>

		</c:forEach>
	</table>
	<div style="">
		<p>
			<button type="button" class="btn btn-danger" onclick="window.location.href='list'; return false;">Back</button>
		</p>
	</div>
</body>
</html>