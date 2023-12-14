<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<style type="text/css">
	body {
		padding-top: 150px;
		font-size: 20px;
		background-color:#abc146;
    }
    div{
    	width: 420px;
    	height: 400px;
    	border : 3px solid black;
    	border-radius: 30px;
    	background-color:#e8c152;
    }
   
</style>
</head>
<body>
	<center>
	<h1>Insert User</h1>
	<div>
	<br>
	<br>
	<table cellpadding="4" cellspacing="6">
	<form:form action="save" modelAttribute="user">
		<tr><th>Id : </th> <td> <form:input path="userId"/></td>
		<tr><th>Name : </th> <td> <form:input path="userName"/></td>
		<tr><th>PhoneNumber : </th> <td> <form:input path="userPhno"/></td>
		<tr><th>mail : </th> <td> <form:input path="mail"/></td>
		<tr><th>Password : </th> <td> <form:input path="password"/></td>
		<tr align="center"><td><button class="btn btn-primary">SaveUser</button></td>
			<td><a href="display" ><button type="button" class="btn btn-dark">Back</button></a></td>
		</tr>
	</form:form>
	</table>
	</div>
	</center>
</body>
</html>