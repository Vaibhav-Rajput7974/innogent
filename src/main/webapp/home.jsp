<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entity.Employee"%>
<%@ page import="service.EmployeeService"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
    <!-- Add Bootstrap CSS link -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<P>
<%! 
Employee emp;
boolean cheak;
RequestDispatcher rd;

%>
<%
cheak=false;
emp = (Employee)session.getAttribute("emp");
if(emp != null){

if(emp.isAdmin()){
	%>
<table class="table table-bordered">
 <thead class="thead-dark">
  <tr>
    <th>Admin</th>
    <th>EmployeeId</th>
    <th>First Name</th>
    <th>Last Name </th>
    <th>Salary</th>
  </tr>
  </thead>
   <tbody>
  <% 
  for(int i=0;i<EmployeeService.employeelist.size();i++){
	%>
  <tr>
    <td><%= EmployeeService.employeelist.get(i).isAdmin() %></td>
    <td><%= EmployeeService.employeelist.get(i).getEmpId() %></td>
    <td><%= EmployeeService.employeelist.get(i).getFirstName() %></td>
    <td><%= EmployeeService.employeelist.get(i).getLastName() %></td>
    <td><%= EmployeeService.employeelist.get(i).getSalary() %></td>
   
    <td><button class="btn btn-danger" name="button" value="Delete" ><a href="delete?id=<%= EmployeeService.employeelist.get(i).getEmpId() %>"> Delete</a></button></td>
    <td><button class="btn btn-primary" name="button" value="Update" ><a href="update.jsp?id=<%= EmployeeService.employeelist.get(i).getEmpId() %>"> Update</a></button></td>
  </tr>
  <%
  }
  %>
  </tbody>
</table>
	<button type="button" name="add" value="Add" ><a class="btn btn-success" href="add_Data.jsp" >Add</a></button>
	<%
}else{
%>
<table class="table table-bordered">
<thead class="thead-dark">
  <tr>
    <th>Admin</th>
    <th>EmployeeId</th>
    <th>First Name</th>
    <th>Last Name </th>
    <th>Salary</th>
  </tr>
  <thead>
  <tbody>
  <tr>
    <td><%= emp.isAdmin() %></td>
    <td><%= emp.getEmpId() %></td>
    <td><%= emp.getFirstName() %></td>
    <td><%= emp.getLastName() %></td>
    <td><%= emp.getSalary() %></td>
    <tbody>
</table>
<button class="btn btn-primary" name="button" value="Update" ><a href="userupdate.jsp?id=<%= emp.getEmpId() %>"> Update</a></button>
<% }
}
else{
	response.sendRedirect("login.jsp");
}
%>
<button type="button" name="submit" value="logout" ><a class="btn btn-success" href="login" >logout</a></button>
<!-- Add Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>

</html>