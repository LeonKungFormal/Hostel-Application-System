<%-- 
    Document   : AddApplicationError
    Created on : Jan 2, 2017, 5:31:45 PM
    Author     : Lion
--%>
<%
    
    String name = (String)session.getAttribute("name");
    String ic = (String)session.getAttribute("ic");
    String address = (String)session.getAttribute("address");
    String contactNum = (String)session.getAttribute("contactNum");    
    
    if(name==null)
    name = "";
    if(ic==null)
    ic = "";
    if(address==null)
    address = "";
    if(contactNum==null)
    contactNum = "";
    
    String nameError = (String)session.getAttribute("nameError");
    String ICError = (String)session.getAttribute("ICError");
    String addressError= (String)session.getAttribute("addressError");
    String contactNumError= (String)session.getAttribute("contactNumError");    
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error in submit application</title>
    </head>
<body>
<h1>Submit application error</h1>
<form action="../AddApplication">
    <table border="0">
        <%if(nameError!=null){ %>
        <tr><td></td><td><%= nameError %></td></tr>    
        <%}%>
    <tr>
        <td>Name </td>
        <td>: <input type="text" name="name" size="20" value="<%= name %>" autocomplete="off"></td>
    </tr>
            <%if(ICError!=null){ %>
        <tr><td></td><td><%= ICError %></td></tr>    
        <%}%> 
    <tr>
        <td>Identity Card Number or Passport number without dash</td>
        <td>: <input type="text" name="ic" size="16" value="<%= ic %>" autocomplete="off"></td>
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
        <%if(addressError!=null){ %>
        <tr><td></td><td><%= addressError %></td></tr>    
        <%}%>   
    <tr>
        <td>Full Home Address </td>
        <td>: <input type="text" name="address" size="80" value="<%= address %>" autocomplete="off"></td>
    </tr>
        <%if(contactNumError!=null){ %>
        <tr><td></td><td><%= contactNumError %></td></tr>    
        <%}%>  
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
