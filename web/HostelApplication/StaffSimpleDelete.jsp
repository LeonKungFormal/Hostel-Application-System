<%-- 
    Document   : StaffSimpleDelete
    Created on : Jan 2, 2017, 12:08:48 AM
    Author     : Lion
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="model.Application"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
  List<Application> applicationsList = (List)session.getAttribute("applicationList");
  SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
  String dates;
  
    ArrayList<String> checkBoxList = new ArrayList();
    int i = 0;
    
  
   %>
<body>
<h1>Select to delete Application </h1>
<form action="../SimpleDelete">
        <table border="1">
    <tr>
        <th>Application Name</th>
        <th>Identity Card Number</th>
        <th>Gender</th>
        <th>Address</th>
        <th>Contact Number</th>
        <th>Application status</th>
        <th>Date Submitted</th>
        <th>Select to delete</th>
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
            <% 
                
                checkBoxList.add(""+i);
            %>
            <td><input type="checkbox" name="<%=checkBoxList.get(i)%>" value="<%=checkBoxList.get(i)%>"/></td>
            <% i++; %>
        </tr>
        
    <% } %>
    </table>
    <% session.setAttribute("checkBoxList", checkBoxList); %>
    <p></p>
    <input type="submit" value="submit">
    </form> 
    <p><a href="StaffHomepage.html">Back to home page</a></p>
    <p><a href="index.html">Back to index page</a></p>
    </body>
</html>
