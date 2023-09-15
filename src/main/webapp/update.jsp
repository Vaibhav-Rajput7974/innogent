<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="entity.Employee"%>
<%@ page import="service.EmployeeService"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Employee</title>
    <!-- Add Bootstrap CSS link -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <form action="update" method="post">
            <h2>Update Employee</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th>Employee ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Salary</th>
                        <th>User Name</th>
                        <th>User Password</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    int empId;
                    RequestDispatcher rd;
                    EmployeeService e;
                    Employee emp1;
                    Employee emp;
                    emp = (Employee)session.getAttribute("emp");
                    if(emp != null){
                        empId = Integer.parseInt(request.getParameter("id"));
                    %>
                    <tr>
                        <td><input readonly type="text" class="form-control" name="t1" value="<%= empId %>"></td>
                        <td><input type="text" class="form-control" name="t2"></td>
                        <td><input type="text" class="form-control" name="t3"></td>
                        <td><input type="number" class="form-control" name="t4"></td>
                        <td><input type="text" class="form-control" name="t5"></td>
                        <td><input type="text" class="form-control" name="t6"></td>
                    </tr>
                </tbody>
            </table>
            <%
            e=new EmployeeService();
            emp1=e.update(empId);
            if(!emp1.isAdmin()){
            %>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="r1" value="true" id="adminRadio">
                <label class="form-check-label" for="adminRadio">Admin</label>
            </div>
            <% } %>
            <button type="submit" name="submit" value="Add_data" class="btn btn-primary">Update</button>
            </form>
            <%
            }else{
            response.sendRedirect("login.jsp");
            }
            %>
        </div>
<button type="button" name="submit" value="logout" ><a class="btn btn-success" href="login" >logout</a></button>

        <!-- Add Bootstrap JS and jQuery -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
