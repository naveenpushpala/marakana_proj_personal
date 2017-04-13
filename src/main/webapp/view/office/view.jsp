<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${office.name}</title>
</head>
<body>

<h1>${office.name}</h1>
	<ul>
		<c:set var="address" value="${office.address}" />
		<li>street: ${address.street}</li>
		<li>city: ${address.city},${address.state},${address.zip} </li>
</ul>
	<a href="${office.url}&edit">Edit office </a>|
	<a href="${office.company.url}">back to ${office.company.name}</a> 
</form>
</body>
</html>