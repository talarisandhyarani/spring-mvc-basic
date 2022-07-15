<html>
<head>
    <title>All Employees</title>
</head>

<body>
	<h1>View All Employees</h1>
	<h2>${employees.toString()}</h2>
    <c:forEach var="employee" items="${employees}" >
        ${employee.toString()}
    </c:forEach>
</body>
</html>