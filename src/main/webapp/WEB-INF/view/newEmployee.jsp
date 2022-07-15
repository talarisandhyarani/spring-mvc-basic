<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<link rel="stylesheet" href="<spring:theme code='styleSheet'/>"/>

<html>
<head></head>
<body bgcolor="<spring:theme code='background'/>">
<h1> New Employee</h2>
<form form: method = "post" name="save" action="save">
<table>

    <tr> First Name: <input type="text" name="firstName"/> </tr>
    <br>
    <tr>Last Name: <input type="text" name="lastName"/></tr>
    <br>
    <tr>Address: <input type="text" name="address"/></tr>
    <br>
    <tr> Phone Number: <input type = "text" name="phoneNumber"/> </tr>
</table>
<input type="submit" value="save"/>
 </form:form>

</body>
</html>