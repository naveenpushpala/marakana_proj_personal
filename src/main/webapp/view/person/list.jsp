<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add person</title>
</head>
<body>
	<c:forEach var="person" items="${persons}">
	<%-- 	<h1>Hello, ${contact.name}!</h1>
		<h1>Hello, ${contact.addressId}!</h1>
	 --%>	
	 <li><a href="person?id=${person.id}">${person.name}</a></li>
	</c:forEach>
	<a href="person?add">add a new person</a>
	
</body>
</html> 