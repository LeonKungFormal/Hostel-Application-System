<%-- 
    Document   : SimpleDeleteStatus
    Created on : Jan 2, 2017, 1:18:19 AM
    Author     : Lion
--%>

<%@page import="java.util.List"%>
<%@page import="model.Application"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%
  List<Application> applicationsList = (List)session.getAttribute("applicationList");
  SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
  String dates;
  
  if(applicationsList != null){ %>
<h1>Remaining application</h1>

<!-- Display items -->
<table border="1">
    <tr>
        <th>Application Name</th>
        <th>Identity Card Number</th>
        <th>Gender</th>
        <th>Address</th>
        <th>Contact Number</th>
        <th>Application Status</th>
        <th>Submitted date</th>
    </tr>
    <% for (Application applications: applicationsList){ %>
        <tr>
            <td><%= applications.getName() %></td>
            <td><%= applications.getIc() %> </td>
            <td><%= applications.getGender() %></td>
            <td><%= applications.getAddress() %></td>
            <td><%= applications.getContactnum() %></td>
            <% if(applications.getStatus()==null) { %>
            <td>Undecided</td>
            <% } else if(applications.getStatus()==true) { %>
            <td>Approve</td>
            <% } else { %>
            <td>Reject</td>
            <% } %>
            <td><%= dates = formatter.format(applications.getDate()) %></td>
        </tr>
        
    <% } %>
    </table>
    <% } %>
<p><a href="StaffHomepage.html">Back to Staff home page</a></p>    
<p><a href="index.html">Back to hostel application page</a></p>
    </body>
</html>
