<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
	integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<a href="loaduser"><button type="button" class="btn btn-primary">
		insert
	</button></a>
	<br>
	<br>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">UserId</th>
				<th scope="col">UserName</th>
				<th scope="col">UserPhno</th>
				<th scope="col">Mail</th>
				<th scope="col">Password</th>
				<th scope="col">Edit</th>
				<th scope="col">Delete</th>
			</tr>
		</thead>

		<c:forEach var="user" items="${getuser}">
			<tbody>

				<tr>
					<th scope="row">${user.getUserId()}</th>
					<td>${user.getUserName()}</td>
					<td>${user.getUserPhno()}</td>
					<td>${user.getMail()}</td>
					<td>${user.getPassword()}</td>
					<td><a href="edituser?id=${user.getUserId()}"><button type="button" class="btn btn-warning">Edit</button></a></td>
		            <td><a href="deleteuser?id=${user.getUserId()}"><button type="button" class="btn btn-danger" onclick="confirmDelete()">Delete</button></a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	<script type="text/javascript">
	function confirmDelete() {
	    return confirm("Are you sure you want to delete this item?");
	}
	</script>
</body>
</html>