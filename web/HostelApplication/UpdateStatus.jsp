    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update application status</title>
    </head>    
<h3>
<%
  boolean success = (Boolean)session.getAttribute("success");
  if (success)
      out.println("Application successfully updated!.");
  else
      out.println("Error: Unable to add new Application.");
%>
</h3>
<p><a href="index.html">Back to hostel application page</a></p>