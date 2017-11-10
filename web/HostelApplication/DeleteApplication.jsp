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
        <title>Delete confirmation</title>
    </head>
<form action="../DeleteApplication">
<%
  Application applications = (Application)session.getAttribute("application");
  SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
  String dates;
  session.setAttribute("applications",applications);
  if(applications != null){ %>
<h1>Confirm delete? </h1>

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
        <td>Date Submitted </td>
        <td>: <%= dates = formatter.format(applications.getDate()) %></td>
    </tr>
    </table>
        <br>
        
        <input type="submit" value="Delete"/>
        </form>
<% } %>
<p><a href="SearchResult.jsp">Return to view your current application</a></p>
<p><a href="index.html">Back to index page</a></p>
</html>
