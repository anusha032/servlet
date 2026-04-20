<%@ page language="java" %>

<html>
<head>
<title>Result Page</title>
</head>

<body>

<h2>Student Result</h2>

Roll No:
<%= request.getAttribute("roll") %>
<br><br>

Name:
<%= request.getAttribute("name") %>
<br><br>

Subject 1:
<%= request.getAttribute("s1") %>
<br><br>

Subject 2:
<%= request.getAttribute("s2") %>
<br><br>

Subject 3:
<%= request.getAttribute("s3") %>
<br><br>

Subject 4:
<%= request.getAttribute("s4") %>
<br><br>

Subject 5:
<%= request.getAttribute("s5") %>
<br><br>

Average Marks:
<%= request.getAttribute("avg") %>
<br><br>

Result:
<b>
<%= request.getAttribute("result") %>
</b>

<br><br>

<a href="index.jsp">
Go Back to Entry Page
</a>

</body>
</html>