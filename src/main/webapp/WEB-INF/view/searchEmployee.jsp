<html>
<head>
    <title>Search Employees</title>
</head>

<body>
	<h1>Search for an Employee</h1>
	<form form: method = "post" name="search" action="/searchEmployee">
	Search by:
	<select name="searchType" id="searchType">
      <option value="name">Name</option>
      <option value="email">Email</option>
      <option value="phoneNumber">Phone Number</option>
      <option value="address">Address</option>
    </select>
    Search query:
    <input type="text" name="query"/>
    <input type="submit" value="search"/>
    </form:form>
</body>
</html>