<%@page import="model.Staff"%>
<!DOCTYPE html>
<!--
To change this lnameense header, choose Lnameense Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%
    Staff staff = (Staff)session.getAttribute("staff");
    if(staff!=null){
    response.sendRedirect("StaffHomepage.html");
    }
    else {
    %>
<html>
    <head>
        <title>Staff Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=devnamee-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Staff login</h1>
<form action="../StaffLogin">
    <table border="0">
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
<% } %>
