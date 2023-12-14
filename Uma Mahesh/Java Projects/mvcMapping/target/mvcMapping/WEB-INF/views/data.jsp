<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Data</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>


	<form:form method="POST" action="showDetails" modelAttribute="studentbean">
		<div class="container mt-5">
			<span><h3>Welcome, Enter The Student Details</h3></span>
			<table class="table table-striped">
				<tr>
					<td><form:label path="name">Name</form:label>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td><form:label path="age">Age</form:label>
					<td><form:input path="age" /></td>
				</tr>
				<tr>
					<td><form:label path="maths">maths</form:label>
					<td><form:input path="maths" /></td>
				</tr>
					<tr>
					<td><form:label path="english">english</form:label>
					<td><form:input path="english" /></td>
				</tr>
					<tr>
					<td><form:label path="social">social</form:label>
					<td><form:input path="social" /></td>
				</tr>
					<tr>
					<td><form:label path="totalMarks">totalMarks</form:label>
					<td><form:input path="totalMarks" /></td>
				</tr>
				<tr>
					<!--  <td><input type="submit" value="Submit"/></td> -->
					<td>
						<button type="submit" class="btn btn-warning">Submit</button>
					</td>
				</tr>
			</table>
		</div>
	</form:form>
</body>
<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</html>