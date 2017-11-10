    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete application status</title>
    </head>    
<h3>
<%
  boolean success = (Boolean)session.getAttribute("success");
  if (success)
      out.println("Application successfully delete!.");
  else
      out.println("Error: Unable to delete new Application.");
%>
</h3>
<p><a href="index.html">Back to hostel application page</a></p>