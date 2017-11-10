    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add staff status</title>
    </head>    
<h3>
<%
  boolean success = (Boolean)session.getAttribute("success");
  if (success)
      out.println("Staff added successfully.");
  else
      out.println("Error: Unable to add new Staff.");
%>
</h3>
<p><a href="StaffHomepage.html">Back to staff home page page</a></p>
