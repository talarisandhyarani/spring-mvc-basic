<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="stylesheet" href="<spring:theme code='styleSheet'/>"/> --%>
<html>
<head></head>
<body>
<h1> New Employee</h2>
<form form: method = "post" name="save" action="/newEmployee">
<table>

    <tr> First Name: <input type="text" name="firstName"/> </tr>
    <br>
    <tr>Last Name: <input type="text" name="lastName"/></tr>
    <br>
    <tr>Email: <input type="text" name="email"/></tr>
    <br>
    <tr>Address: <input type="text" name="address"/></tr>
    <br>
    <tr> Phone Number: <input type = "text" name="phoneNumber"/> </tr>
    <br>
    <tr> Date of Birth: <input type = "date" name="birthDay"/> </tr>
    <br>
     <tr> Hire Date: <input type = "date" name="hireDate"/> </tr>
</table>
<input type="submit" value="save"/>
 </form:form>

</body>
</html>