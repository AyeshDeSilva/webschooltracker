<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Course To Instructor</title>
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
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/course/list">Courses</a></li>
				<li class="nav-item"><a class="nav-link active" href="${pageContext.request.contextPath}/instructor/list">Instructor</a></li>
			</ul>
		</div>
		<button class="btn btn-primary" type="button">Logout</button>
	</nav>
	<div class="text-center">
		<h1 class="display-1">COURSES</h1>
	</div>
	<table class="table table-hover table-dark table-striped">
		<thead class="table-dark">
			<tr>
				<th scope="col">Course Code</th>
				<th scope="col">Course Title</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<c:forEach var="tempCourse" items="${course}">

			<!-- add link to course with studentid -->
			<c:url var="addLink" value="/instructor/addCourseToInstructor">
				<c:param name="courseId" value="${tempCourse.id}" />
				<c:param name="instructorId" value="${instructor.id}" />
			</c:url>
						
			<c:if test="${id == tempCourse.instructor.id}">
			<tr>
				<td>${tempCourse.courseCode}</td>
				<td>${tempCourse.courseTitle}</td>
				<td>
				
					<a href="${addLink}" class="btn btn-primary btn-sm">Add</a>
				
				</td>
			</tr>
			</c:if>
		</c:forEach>
	</table>

</body>
</html>