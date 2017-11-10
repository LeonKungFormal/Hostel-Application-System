<%-- 
    Document   : AddApplicationError
    Created on : Jan 2, 2017, 5:31:45 PM
    Author     : Lion
--%>
<%@page import="model.Application"%>
<%
    Application applications = (Application)session.getAttribute("application");
    String name = applications.getName();
    String address = applications.getAddress();
    String contactNum = applications.getContactnum();    
    
    if(name==null)
    name = "";
    if(address==null)
    address = "";
    if(contactNum==null)
    contactNum = "";
    
    String nameError = (String)request.getAttribute("nameError");
    String addressError= (String)request.getAttribute("addressError");
    String contactNumError= (String)request.getAttribute("contactNumError");    
    
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update application</title>
    </head>
<body>
<h1>Update application</h1>
<form action="../UpdateApplication">
    <table border="0">
    <tr>
        <td>Name </td>
        <td>: <input type="text" name="name" size="20" value="<%= name %>" autocomplete="off"></td>
    </tr>
    <tr>
        <td>Gender </td>
        <td>: <input type="radio" name="gender" value="Male" checked="checked" />
            Male
           <input type="radio" name="gender" value="Female" />Female
           <input type="radio" name="gender" value="Gay" />Gay
           <input type="radio" name="gender" value="Lesbian" />Lesbian
           <input type="radio" name="gender" value="Bisexual" />Bisexual
           </td>
    </tr>
    <tr>
        <td>Full Home Address </td>
        <td>: <input type="text" name="address" size="80" value="<%= address %>" autocomplete="off"></td>
    </tr>
    <tr>
        <td>Contact number without dash</td>
        <td>: <input type="text" name="contactNum" size="16" value="<%= contactNum %>" autocomplete="off"></td>
    </tr>    
    
    </table>
    <input type="submit" value="Submit Application">
    <input type="reset" value="Reset">
</form>
<p><a href="index.html">Back to index page</a></p>
</body>
</html>
