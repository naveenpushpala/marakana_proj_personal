<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view Contact</title>
</head>
<body>

<h1>${contact.name}</h1>
<form action ="contact?add" method="post">
<input type="hidden" name="add">
	<ul>
		<c:set var="address" value="${contact.address}" />
		<li>street: ${address.street}</li>
		<li>city: ${address.city} </li>
		<li>state:${address.state}</li>
		<li>zip:${address.zip} </li>
	</ul>
	<a href="contacts">to list </a>
	<a href="contact?edit&id=${contact.id}">edit contact </a> |<a href="contacts">back to contacts</a>
</form>
</body>
</html>