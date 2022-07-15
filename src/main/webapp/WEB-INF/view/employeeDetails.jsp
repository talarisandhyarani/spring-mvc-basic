<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Employee Details</title>
</head>

<body>
	<h1>${employee.firstName} ${employee.lastName}</h1>
	<ul>
	    <li>Employee ID: ${employee.employee_id}</li>
	    <li>Email: ${employee.email}</li>
	    <li>Phone Number: ${employee.phoneNumber}</li>
	    <li>Date of Birth: ${employee.birthDay}</li>
	    <li>Hire Date: ${employee.hireDate}</li>
	   <%-- <li>Current Projects: ${projectList}</li> --%>
	</ul>
</body>
</html>