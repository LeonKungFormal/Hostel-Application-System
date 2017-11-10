<%@page import="java.lang.Integer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="model.Application"%>

<%-- 
    Document   : DisplayApplicationList
    Created on : Dec 31, 2016, 12:22:30 PM
    Author     : Lion
--%>
<% 
    
  ArrayList<ArrayList<Integer>> monthSubmit = (ArrayList<ArrayList<Integer>>)session.getAttribute("monthSubmit");

  List<Integer> yearSubmit= (List<Integer>)session.getAttribute("yearSubmit");

  
  String[] monthName = {"January","February","March","April","May","June",         
                            "July","August","September","October","November",     
                        "December"};  
  
  //to save dropdown list name
  ArrayList<String> DDownName = new ArrayList();
  
  //to save index for 
  ArrayList<ArrayList<Integer>> counter = new ArrayList();
        
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Application drop down list</title>
    </head>
    <h1>Application management</h1>    
<form action="../ProcessStaffFunction" method="post">
<table border="0" cellspacing="10">
    <tr>
        <% for(int k = 0;k<yearSubmit.size();k++) { ;%>
        <th><%= yearSubmit.get(k) %></th>        
        <%}%>
        </tr>
        
        <tr>
        <% for(int k = 0;k<monthSubmit.size();k++) {
            
            DDownName.add("month" + k); %>
        <td><select name="<%= "month" + k %>">
                <% for (int m = 0;m<monthSubmit.get(k).size();m++){%>
                <option value="<%=monthSubmit.get(k).get(m)%>">
                    <%=monthName[monthSubmit.get(k).get(m)-1]%>
                <%}%>
            </select>
            
        </td>
        <%}%>
    </tr>
    <tr>

        <% for(int m = 0;m<yearSubmit.size();m++) {%>
        <% if(m==0){ counter.add(new ArrayList()); 
        counter.get(m).add(yearSubmit.get(m));
        counter.get(m).add(m);
         %>
        <th><input type="radio" name="year" value="<%= yearSubmit.get(m) %>" checked="checked"/>Select This year</th>        
        <%} else { %>
        <th><input type="radio" name="year" value="<%= yearSubmit.get(m) %>"/>Select This year</th> 
        <%}%>
        <%}%>
    </tr>    
    <tr>
        <td colspan="2">
            <input type="submit" value="Delete" name="button"/>
            <input type="submit" value="Update" name="button"/>
        </td>
    </tr>

</table>
</form>
<%
request.setAttribute("DDownName", DDownName);
    request.setAttribute("counter", counter);
        %>
</html>
