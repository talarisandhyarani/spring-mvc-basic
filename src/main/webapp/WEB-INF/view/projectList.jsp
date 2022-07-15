<html>
<head>
    <title>All Projects</title>
</head>

<body>
	<h1>View All Projects</h1>
    <c:forEach var="project" items="${projectList}" >
        ${project}
    </c:forEach>
</body>
</html>