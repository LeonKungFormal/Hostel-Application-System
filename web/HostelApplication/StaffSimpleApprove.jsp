<%-- 
    Document   : StaffSimpleApprove
    Created on : Jan 1, 2017, 9:41:43 PM
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
        <title>Simple approve</title>
    </head>
    <%
  List<Application> applicationsList = (List)session.getAttribute("applicationList");
  SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
  String dates;
  
    ArrayList<String> radioButtonList = new ArrayList();
    String nameCreator;
    int i = 0;
    
  
   %>
<body>
<h1>Approve Application </h1>
<form action="../SimpleApprove">
        <table border="1">
    <tr>
        <th>Application Name</th>
        <th>Identity Card Number</th>
        <th>Gender</th>
        <th>Address</th>
        <th>Contact Number</th>
        <th>Submitted date</th>
        <th>Approve Application</th>
        <th>Reject Application</th>
        <th>Check here if undecided</th>
    </tr>
    <% for (Application applications: applicationsList){ %>
        <tr>
            <td><%= applications.getName() %></td>
            <td><%= applications.getIc() %> </td>
            <td><%= applications.getGender() %></td>
            <td><%= applications.getAddress() %></td>
            <td><%= applications.getContactnum() %></td>
            <td><%= dates = formatter.format(applications.getDate()) %></td>
            <% 
                nameCreator = "choice" + i; 
                radioButtonList.add(nameCreator);
            %>
            <td><input type="radio" name="<%=nameCreator%>" value="true"  /></td>
            <td><input type="radio" name="<%=nameCreator%>" value="false" /></td>
            <td><input type="radio" name="<%=nameCreator%>" value="null" checked="checked" /></td>
            <% i++; %>
        </tr>
        
    <% } %>
    </table>
    <% session.setAttribute("radioButtonList", radioButtonList); %>
    <p></p>
    <input type="submit" value="submit">
    </form> 
    <p><a href="StaffHomepage.html">Back to Staff home page</a></p>
    <p><a href="index.html">Back to home page</a></p>
    </body>
</html>
