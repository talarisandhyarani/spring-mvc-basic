<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Employee Details</title>
</head>

<body>
	<h1>${employee.firstName} ${employee.lastName}</h1>
	<ul>
	    <li>Employee ID: ${employee.id}</li>
	    <li>Email: ${employee.email}</li>
	    <li>Phone Number: ${employee.phoneNumber}</li>
	    <li>Date of Birth: <fmt:formatDate var="birthDate"
                           								value="${employee.birthDate}"
                           								pattern="MM/dd/yyyy"/>${birthDate}</li>
	    <li>Hire Date: <fmt:formatDate var="hireDate"
                       								value="${employee.hireDate}"
                       								pattern="MM/dd/yyyy"/>${hireDate}</li>
	    <%--<li>Current Projects: ${projectList}</li> --%>
	</ul>
</body>
</html>