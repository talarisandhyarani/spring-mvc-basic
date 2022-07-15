<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>All Projects</title>
</head>

<body>
	<h1>View All Projects</h1>
    <hr/>
	<table>
	    <style scoped>td {padding:1px;}</style>

        <th>Project ID</th>
        <th>Name</th>
        <th>Start Date</th>
        <th>End Date</th>
        <c:forEach var="project" items="${projects}" >
            <tr>
                <td>${project.project_id}</td>
                <td>${project.project_name}</td>
                <td>${project.start_date}</td>
                <td>${project.end_date}</td>
                <td></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>