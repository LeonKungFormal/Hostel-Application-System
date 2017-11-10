<%-- 
    Document   : StaffLoginError
    Created on : Jan 2, 2017, 2:43:26 PM
    Author     : Lion
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String error = (String)session.getAttribute("error");
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login error</title>
    </head>
    <body>
        <h1>Login error</h1>
<form action="../StaffLogin">
    <table border="0">
        <tr><h3><%=error %></h3></tr>
    <tr>
        <td>Username </td>
        <td>: <input type="text" name="name" size="20" autocomplete="off"></td>
    </tr>
    <tr>
        <td>Password</td>
        <td>: <input type="password" name="password" size="20" autocomplete="off"></td>
    </tr>



    </table>
    <p><input type="submit" value="submit">     <input type="reset" value="Reset"></p>
    </form>
    <p><a href="index.html">Back to index page</a></p>
    </body>
</html>
