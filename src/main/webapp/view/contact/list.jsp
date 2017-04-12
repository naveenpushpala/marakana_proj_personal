<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contacts</title>
</head>
<body>
	Contacts From JSP 
	
	<ul>
	<c:forEach var="contact" items="${contacts}">
		<li><a href="${contact.url}">${contact.name}</a></li>
	</c:forEach>
	</ul>
	<a href="person?add"> add a new contact</a>|<a href="company?add">add new company</a>
	
</body>
</html>