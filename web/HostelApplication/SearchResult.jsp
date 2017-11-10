<%-- 
    Document   : SearchResult
    Created on : Dec 29, 2016, 9:56:56 PM
    Author     : Lion
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.Application"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Your Application</title>
    </head>
<form action="../ProcessResult">
<%
  Application applications = (Application)session.getAttribute("application");
  SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
  String dates;
  
  if(applications != null){ %>
<h1>Your Application detail</h1>

<!-- Display items -->
<table border="0">
    <tr>
        <td>Application Name</td>
        <td>: <%= applications.getName() %></td>
    </tr>
    <tr>
        <td>Identity Card Number </td>
        <td>: <%= applications.getIc() %></td>
    </tr>
    <tr>
        <td>Gender </td>
        <td>: <%= applications.getGender() %></td>
    </tr>
    <tr>
        <td>Home Address </td>
        <td>: <%= applications.getAddress() %></td>
    </tr>
    <tr>
        <td>Contact number </td>
        <td>: <%= applications.getContactnum() %></td>
    </tr>    
    <tr>
    <td>Status </td>
            <% if(applications.getStatus()==null) { %>
            <td>: Undecided</td>
            <% } else if(applications.getStatus()==true) { %>
            <td>: Approve</td>
            <% } else { %>
            <td>: Reject</td>
            <% } %>
    </tr>
    <tr>
    <td>Date submitted </td>
        <td>: <%= dates = formatter.format(applications.getDate()) %></td>
    </tr>
    
    </table>
        <br>
        
        <input type="submit" value="UpdateApplication" name="button"/>
        <input type="submit" value="DeleteApplication" name="button"/>
        </form>
<% } else { %>    
<h2>Record not founded!</h2>  
<% } %>
<p><a href="index.html">Back to home page</a></p>
</html>
