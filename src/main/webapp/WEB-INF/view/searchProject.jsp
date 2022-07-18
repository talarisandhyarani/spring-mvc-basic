<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search Projects</title>
</head>

<body>
	<h1>Search for a Project</h1>
	<form form: method = "post" name="search" action="/searchProject">

    Search query:
    <input type="text" name="query"/>
    <input type="submit" value="search"/>
    </form:form>


    <c:choose>
        <c:when test="${empty projectList}">
            <h2>Please Enter A New Search</h2>
        </c:when>

        <c:when test="${not empty projectList}">

            <table border="1px">
                <th>Project ID</th>
                <th>Name</th>
                <th>Start Date</th>
                <th>End Date</th>
                <c:forEach var="project" items="${projectList}" >
                    <tr>
                        <td>${project.project_id}</td>
                        <td>${project.project_name}</td>
                        <td>${project.start_date}</td>
                        <td>${project.end_date}</td>
                        <td></td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
    </c:choose>
</body>
</html>