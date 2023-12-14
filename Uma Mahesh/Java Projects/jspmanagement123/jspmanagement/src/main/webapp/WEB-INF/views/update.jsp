<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<form:form method="POST" 
          action="studentdetails" modelAttribute="dataUpdate">
                  <div class="container mt-5">
        <span><h3>Welcome, Enter The Student Details</h3></span>
             <table class="table table-striped">
              <tr>
                    <td><form:label path="id">Id</form:label></td>
                    <td><form:input path="id"/></td>
                </tr> 
                 <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="graduation">Graduation</form:label></td>
                    <td><form:input path="graduation"/></td>
                </tr>
                
                <tr>
                    <td><form:label path="stream">Stream</form:label></td>
                    <td><form:input path="stream"/></td>
                </tr>
                
                
               <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email"/></td>
                </tr>
                 <tr>
                    <td><form:label path="phone">Phone</form:label></td>
                    <td><form:input path="phone"/></td>
                </tr>
                 <tr>
                    <td><form:label path="yop">Year Of pass out</form:label></td>
                    <td><form:input path="yop"/></td>
                </tr>
                 <tr>
                    <td><form:label path="course">Course</form:label></td>
                    <td><form:input path="course"/></td>
                </tr>
                <tr>
                   <!--  <td><input type="submit" value="Submit"/></td> -->
                   <td> <button type="submit" class="btn btn-primary">Save</button></td>
                </tr>
            </table>
            </div>
        </form:form>
</body>
<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</html>