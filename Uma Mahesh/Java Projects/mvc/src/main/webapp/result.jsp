<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align:center">
<h1>details entered in database...</h1>
<c:forEach var="i" items="${student}" >
	<h4> Name : ${i.name}</h4>
	<h4> Age : ${i.age}</h4>
	<h4> Section : ${i.section}</h4>
</c:forEach>
</body>
</html>