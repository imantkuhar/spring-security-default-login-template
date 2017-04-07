<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>REDACTOR page</title>
</head>
<body>
	<p>Dear <strong>${user}</strong>. Welcome to REDACTOR Page.</p>
	You can redact everything on this page.
	<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>