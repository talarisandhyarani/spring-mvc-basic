<html>
<head>
    <title>Project Details</title>
</head>

<body>
	<h1>${projectName}</h1>
	<ul>
	    <li>Project ID: ${id}</li>
	    <li>Project Description: ${projectDescription}</li>
	    <li>Start Date: ${startDate}</li>
	    <li>Current Project Members: ${projectMemberList}</li>
	</ul>
	<button type="button" href="/projectDetails/${id}/delete">Delete Project</button>
</body>
</html>