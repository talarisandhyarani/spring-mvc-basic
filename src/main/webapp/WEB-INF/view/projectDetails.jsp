<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Project Details</title>
</head>

<body>
	<h1>${project.project_name}</h1>
	<ul>
	    <li>Project ID: ${project.project_id}</li>
	    <li>Project Description: ${project.projectDescription}</li>
	    <li>Start Date: ${project.start_date}</li>
	    <li>Start Date: ${project.end_date}</li>
	    <%--<li>Current Project Members: ${projectMemberList}</li>--%>
	</ul>
	<button type="button" href="/projectDetails/${id}/delete">Delete Project</button>
</body>
</html>