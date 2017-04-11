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

<h1>view contact</h1>
<form action ="contact?add" method="post">
<input type="hidden" name="add">
	<ul>
		<li>street: ${address.street}</li>
		<li>city: ${address.city},${address.state},${address.zip} </li>
</ul>
	<a href="contact?edit&id=${contact.id}">Edit contact </a>|<a href="contacts">back to contact list</a> 
</form>
</body>
</html>