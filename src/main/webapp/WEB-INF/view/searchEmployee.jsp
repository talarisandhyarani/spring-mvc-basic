<html>
<head>
    <title>Search Employees</title>
</head>

<body>
	<h1>Search for an Employee</h1>
	<form form: method = "post" name="search" action="/searchEmployee">
    Search query:
    <input type="text" name="query"/>
    <input type="submit" value="search"/>
    </form:form>


    <c:choose>
        <c:when test="${empty employee}">
            <h2>Please Enter A New Search</h2>
        </c:when>

        <c:when test="${not empty employee}">
            <table border="1px">
            <th>Name</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Email</th>
            <th>Date of Birth</th>
            <th>Hire Date</th>
            <tr>
                <td>${employee.firstName} ${employee.lastName}</td>
                <td>${employee.phoneNumber}</td>
                <td>${employee.address}</td>
                <td>${employee.email}</td>
                <td>${employee.birthDate}</td>
                <td>${employee.hireDate}</td>
            </tr>
            </table>
        </c:when>
    </c:choose>
</body>
</html>