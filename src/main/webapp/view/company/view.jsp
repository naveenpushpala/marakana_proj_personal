<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${company.name}</title>
</head>
<body>

<h1>${company.name}</h1>
<ul>
	<c:forEach var="office" items="${company.offices }">
		<li><a href="${office.url}">${office.name}</a></li>	
	</c:forEach>
</ul>
	<a href="${company.url}&edit">Edit person </a>|<a href="contacts">back to contact list</a> 
	<a href="office?add&company_id=${company.id}">add office</a>
	<a href="contacts">back to contact list</a>
</form>
</body>
</html>