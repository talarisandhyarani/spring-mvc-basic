<html>
<head>
    <title>Delete Project</title>
</head>

<body>
	<h1>Delete a Project</h1>
	<form form: method = "post" name="deleteProject" action="/deleteProject">
        Enter Project ID:
        <input type="number" name="projectId"/>
        <input type="submit" value="delete"/>
    </form:form>


    <c:choose>
        <c:when test="${not empty result}">
            <h2>Project Deleted</h2>
        </c:when>

        <c:when test="${empty result}">
            <h2>Error Deleting Project</h2>
        </c:when>
    </c:choose>
</body>
</html>