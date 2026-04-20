<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<title>Session Status</title>
</head>

<body>

<%

// Get session value
String user =
(String) session.getAttribute("username");

if (user != null) {

%>

<h2 style="color:green;">

Hello <%= user %> !

</h2>

<p>
Session is still active.
</p>

<%

}
else {

%>

<h2 style="color:red;">

Session Expired !

</h2>

<p>
Please enter your name again.
</p>

<a href="index.jsp">
Go Back
</a>

<%

}

%>

</body>

</html>