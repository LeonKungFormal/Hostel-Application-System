<%-- 
    Document   : DisplayReport
    Created on : Jan 2, 2017, 8:57:01 PM
    Author     : Lion
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
      ArrayList<ArrayList<Integer>> monthSubmit = (ArrayList<ArrayList<Integer>>)session.getAttribute("monthSubmit");

  List<Integer> yearSubmit= (List<Integer>)session.getAttribute("yearSubmit");
//  ArrayList<ArrayList<Integer>> totalAppMonth = (ArrayList<ArrayList<Integer>>)session.getAttribute("totalAppMonth");
  
  String[] monthName = {"January","February","March","April","May","June",         
                            "July","August","September","October","November",     
                        "December"};
  //: totalAppMonth.get(k).get(m) 
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Summary report</title>
    </head>
    <body>
        <h1>Application management</h1> 
        <table border="0" cellspacing="10">
        <% for(int k = 0;k<yearSubmit.size();k++) { ;%>    
        <tr>        
        <th><%= yearSubmit.get(k) %></th>                
        </tr>
            
        <% 
           for (int m = 0;m<monthSubmit.get(k).size();m++){%>
           <tr>
               <td><%=monthName[monthSubmit.get(k).get(m)-1]%> </td><%}%>
            </tr>
            <%}%>
        </table>
        <p>This is the list of month that students submit their application.</p>
        <p><a href="StaffHomepage.html">Return to staff home page</a></p>                 
        
    </body>
</html>
