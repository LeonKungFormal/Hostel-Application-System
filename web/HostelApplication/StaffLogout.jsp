<%-- 
    Document   : StaffLogout
    Created on : Jan 2, 2017, 4:31:13 PM
    Author     : Lion
--%>
<%
session.invalidate(); 
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Logout</title>
    </head>
    <body>
        <h1>Logout Successfully</h1>
        <p><a href="index.html">Back to index page</a></p>
    </body>
</html>
