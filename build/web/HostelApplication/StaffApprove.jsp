<%-- 
    Document   : StaffApprove
    Created on : Jan 1, 2017, 12:59:35 AM
    Author     : Lion
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.Application"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    ArrayList<Application> applicationsSelected = (ArrayList<Application>)session.getAttribute("applicationsSelected");;
    
    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
    String dates;
    
    ArrayList<String> checkBoxList = new ArrayList<String>();
    String nameCreator;
    int i = 0;
    session.setAttribute("checkBoxList", checkBoxList);
    
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Approval Application Page</title>
    </head>
    <body>
<form action="../SearchApplication">
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
    <% for (Application applications: applicationsSelected){ %>
        <tr>
            <td><%= applications.getName() %></td>
            <td><%= applications.getIc() %> </td>
            <td><%= applications.getGender() %></td>
            <td><%= applications.getAddress() %></td>
            <td><%= applications.getContactnum() %></td>
            <td><%= dates = formatter.format(applications.getDate()) %></td>
            <% 
                nameCreator = "choice" + i; 
                checkBoxList.add(nameCreator);
            %>
            <td><input type="radio" name="<%=nameCreator%>" value="true"  /></td>
            <td><input type="radio" name="<%=nameCreator%>" value="false" /></td>
            <td><input type="radio" name="<%=nameCreator%>" value="null" checked="checked" /></td>
            <% i++; %>
        </tr>
        
    <% } %>
    </table>
    
    </form>    
    </body>
</html>
