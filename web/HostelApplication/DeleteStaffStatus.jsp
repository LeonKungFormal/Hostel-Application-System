    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete staff status</title>
    </head>    
<h3>
<%
  boolean success = (Boolean)session.getAttribute("success");
  if (success)
      out.println("Staff successfully delete!");
  else
      out.println("Error: Unable to delete Staff.");
%>
</h3>
<p><a href="StaffHomePage.html">Back to hostel application page</a></p>
