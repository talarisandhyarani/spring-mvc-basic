<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Employee Search Results</title>
</head>

<body>
	<h1>Employee Search Results</h1>
    <hr/>
	<table>
	    <style scoped>td {padding:1px;}</style>

        <th>Name</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Email</th>
        <th>Date of Birth</th>
        <th>Hire Date</th>
        <c:forEach var="employee" items="${employees}" >
            <tr>
                <td>${employee.firstName} ${employee.lastName}</td>
                <td>${employee.phoneNumber}</td>
                <td>${employee.address}</td>
                <td>${employee.email}</td>
                <td>${employee.birthDate}</td>
                <td>${employee.hireDate}</td>
                <td></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>