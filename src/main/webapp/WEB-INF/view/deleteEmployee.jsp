<html>
<head>
    <title>Delete Employee</title>
</head>

<body>
	<h1>Delete an Employee</h1>
	<form form: method = "post" name="deleteEmployee" action="/deleteEmployee">
        Enter Employee ID:
        <input type="number" name="employeeId"/>
        <input type="submit" value="delete"/>
    </form:form>


    <c:choose>
        <c:when test="${failure}">
            <h2>Error Deleting Employee</h2>
        </c:when>
         <c:otherwise>
         </c:otherwise>
    </c:choose>
</body>
</html>