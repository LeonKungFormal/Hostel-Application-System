<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="model.Application"%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show full application</title>
    </head>
<!-- retrieve session object, applicationList -->
<%
  List<Application> applicationsList = (List)session.getAttribute("applicationList");
  SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
  String dates;
  
  if(applicationsList != null){ %>
<h1>View All Application </h1>

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
<form action="../ViewProcess" method="post">    
    <input type="submit" name="button" value="Approve Applications">
    <input type="submit" name="button" value="Delete Applications">
</form>
<% } else { %>    
<h2>Record not founded!</h2>  
<% } %>
<p><a href="StaffHomepage.html">Back to staff home page</a></p>
<p><a href="index.html">Back to index page</a></p>