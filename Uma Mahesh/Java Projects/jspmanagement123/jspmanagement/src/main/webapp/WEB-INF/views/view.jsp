<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>view</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style>
body {
  background-color: orange;
  /* You can change the color code to your desired color */
}
.custom-navbar-bg {
    background-color: #b6e1a0; /* Replace with your desired color value */
  }
  
  #searching {
      margin-left: 395px; /* Adjust the margin value as needed */
    }
  
  
  
</style>
</head>
<body>
<!-- navbaar -->
<nav class="navbar navbar-expand-lg navbar-light custom-navbar-bg">
<!-- <nav class="navbar navbar-expand-lg navbar-light bg-light" > -->
  <a class="navbar-brand" href="#"><EM><H2>JSPIDERS</EM></H2></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">About</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="https://jspiders.com/java-full-stack/course">Services</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="">Contact</a>
      </li>
    </ul>
  </div>
</nav>
<form:form method="POST">
<div class="container mt-5">

<span><h1 class="text-center mb-4">Student Details</h1> </span>
 <div class="container mt-1" id="searching">
  <form class="form-inline">
    <input class="form-control mr-sm-2" type="search" placeholder="Enter student id" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
  </form>
</div>

<h1>Total Students : ${count}</h1>
  <span>  <h1><a href="insert"><button type="button" class="btn btn-primary">Add Student</button></a></h1></span>
 <!--  <span>  <h1><a href="home"><button type="button" class="btn btn-primary">Go to Home Page</button></a></h1></span> -->
 
    <table class="table table-striped">
        <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Graduation</th>
                <th>Stream</th>
                <th>Email</th>
                <th>Phone</th>
                <th>YOP</th>
                <th>Course</th>
                 <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="stu" items="${student}">
            <!--  construct an "update" link with customer id -->
						 <c:url var="updateLink" value="/insertupdate">
							<c:param name="stuId" value="${stu.id}" />
						</c:url> 
            <!-- construct an "delete" link with customer id -->
						<c:url var="deleteLink" value="/delete">
							<c:param name="stuId" value="${stu.id}" />
						</c:url>
                <tr>
                    <td>${stu.getId() }</td>
                    <td>${stu.getName() }</td>
                    <td>${stu.getGraduation() }</td>
                    <td>${stu.getStream() }</td>
                    <td>${stu.getEmail() }</td>
                    <td>${stu.getPhone()}</td>
                    <td>${stu.getYop()}</td>
                    <td>${stu.getCourse()}</td> 
                    
                   <td> <a href="${updateLink}"><button type="button" class="btn btn-warning">Edit</button></a>
	        			<a href="${deleteLink}"onclick="if (!(confirm('Are you sure you want to delete this Employee?'))) return false"><button type="button" class="btn btn-danger">delete</button></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
  </form:form>
<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>