<%@ page language="java" %>
<%@ page import="java.util.Date" %>

<%
String name = request.getParameter("userName");

// Declare expiryDate outside
Date expiryDate = null;

if (name != null) {

    // Create session
    session.setAttribute("user", name);

    // Set session expiry time (1 minute)
    session.setMaxInactiveInterval(60);

    // Calculate expiry time
    long creationTime = session.getCreationTime();
    long expiryTime = creationTime + (60 * 1000);

    expiryDate = new Date(expiryTime);
}
%>

<!DOCTYPE html>
<html>
<head>
<title>Welcome Page</title>
</head>

<body>

<%
if (name != null) {
%>

<h2>Hello <%= name %> !</h2>

<p>
Session will expire at:
<b><%= expiryDate %></b>
</p>

<p>
<a href="checkSession.jsp">
Click here to check session
</a>
</p>

<p>
Wait for 1 minute and click again to see session expiry.
</p>

<%
}
%>

</body>
</html>