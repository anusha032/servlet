<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>Welcome Page</title>
</head>

<body>

<%

// Get name from textbox
String name =
request.getParameter("userName");

// Create session
session.setAttribute("username", name);

// Set session expiry time (1 minute)
session.setMaxInactiveInterval(60);

%>

<h2 style="color:blue;">

Hello <%= name %> !

</h2>

<p style="color:red;">
Session will expire in 1 minute.
</p>

<br>

<a href="checkSession.jsp">
Check Session Status
</a>

</body>

</html>