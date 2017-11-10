<%-- 
    Document   : SearchStaffResult
    Created on : Jan 3, 2017, 12:31:19 PM
    Author     : Lion
--%>

<%@page import="model.Staff"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<form action="../DeleteStaff">
<%
  Staff staff = (Staff)session.getAttribute("staff");
  SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
  String dates;
  
  if(staff != null){ %>
<h1>Confirm delete this staff?</h1>

<!-- Display items -->
<table border="0">
    <tr>
        <td>Application Name</td>
        <td>: <%= staff.getName() %></td>
    </tr>
    <tr>
        <td>Identity Card Number </td>
        <td>: <%= staff.getPassword() %></td>
    </tr>
    </table>
        <br>
        
        <input type="submit" value="Delete Staff" name="button"/>
        </form>
<% } else { %>    
<h2>Staff not founded!</h2>  
<% } %>
<p><a href="StaffHomepage.html">Back to Staff home page</a></p>
    </body>
</html>
