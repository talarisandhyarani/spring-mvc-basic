<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="stylesheet" href="<spring:theme code='styleSheet'/>"/> --%>
<html>
<head></head>
<body>
<h1> Add Member to Project</h2>
<form form: method = "post" name="save" action="/addEmployeeToProject">
<table>

    <tr> Project Id: <input type="number" name="projectId"/> </tr>
    <br>
    <tr> Employee Id: <input type="number" name="employId"/></tr>
    <br>
</table>
<input type="submit" value="add"/>
 </form:form>

</body>
</html>