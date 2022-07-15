<html>
<head>
    <title>All Employees</title>
</head>

<body>
	<h1>View All Employees</h1>
    <c:forEach var="employee" items="${employeeList}" >
        ${employee}
    </c:forEach>
</body>
</html>