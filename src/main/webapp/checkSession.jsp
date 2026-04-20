<%@ page language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Check Session</title>
</head>
<body>

<%
String user = (String) session.getAttribute("user");

if (user != null) {
%>

<h2>Hello <%= user %> !</h2>

<p style="color:green;">
Session is still active.
</p>

<p>
<a href="checkSession.jsp">
Check Again
</a>
</p>

<%
}
else {
%>

<h2 style="color:red;">
Session Expired!
</h2>

<p>
Please go back and enter your name again.
</p>

<a href="index.jsp">
Go to Home
</a>

<%
}
%>

</body>
</html>