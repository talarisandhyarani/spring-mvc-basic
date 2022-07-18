<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <c:when test="${not empty result}">
            <h2>Employee Deleted</h2>
        </c:when>

        <c:when test="${empty result}">
            <h2>Error Deleting Employee</h2>
        </c:when>
    </c:choose>
</body>
</html>