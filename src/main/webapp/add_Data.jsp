<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="entity.Employee"%>
<%@ page import="service.EmployeeService"%>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Employee</title>
    <!-- Add Bootstrap CSS link -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%! 
Employee emp;
%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
emp = (Employee)session.getAttribute("emp");
if(emp != null){
%>
    <div class="container mt-5">
        <h2>Add Employee</h2>
        <form action="add" method="post">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="firstName">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="t3">
                </div>
                <div class="form-group col-md-6">
                    <label for="lastName">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="t4">
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="salary">Salary</label>
                    <input type="number" class="form-control" id="salary" name="t5">
                </div>
                <div class="form-group col-md-6">
                    <label for="userName">User Name</label>
                    <input type="text" class="form-control" id="userName" name="t6">
                </div>
            </div>
            <div class="form-group">
                <label for="userPassword">User Password</label>
                <input type="password" class="form-control" id="userPassword" name="t7">
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="r1" value="true" id="adminRadio">
                <label class="form-check-label" for="adminRadio">Admin</label>
            </div>
            <button type="submit" name="submit" value="Add_data" class="btn btn-primary mt-3">Add Data</button>
        </form>
    </div>

    <!-- Add Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <% }else{
    	response.sendRedirect("login.jsp");
    }
    	%>
<button type="button" name="submit" value="logout" ><a class="btn btn-success" href="login" >logout</a></button>
    	
</body>
</html>
