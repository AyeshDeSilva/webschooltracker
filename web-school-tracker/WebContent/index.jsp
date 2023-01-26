<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web School Tracker</title>
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
	<!-- Navbar dark theme -->
	<nav
		class="navbar navbar-dark bg-dark navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">HomePage</a></li>
				<li class="nav-item"><a class="nav-link" href="student/list">Student</a></li>
				<li class="nav-item"><a class="nav-link" href="course/list">Courses</a></li>
				<li class="nav-item"><a class="nav-link" href="instructor/list">Instructor</a></li>
			</ul>
		</div>
		<button class="btn btn-primary" type="button">Logout</button>
	</nav>
	<!-- Display title page -->
	<div class="text-center">
		<h1 class="display-1">Web School Tracker</h1>
		<h2 class="display-4">Project By: Ayesh De Silva</h2>	
	</div>



</body>
</html>