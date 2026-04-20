<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="javax.servlet.http.Cookie" %>

<!DOCTYPE html>
<html>

<head>

<title>Setting Cookie</title>

<style>

.info-box {
margin: 20px;
padding: 15px;
border: 1px solid #ddd;
border-radius: 5px;
background-color: #f9f9f9;
}

.success {
color: green;
}

</style>

</head>

<body>

<div class="info-box">

<%

// Get parameters
String name = request.getParameter("cookieName");
String domain = request.getParameter("domain");
String maxAge = request.getParameter("maxAge");

if (name != null && domain != null && maxAge != null) {

// Get cookie list from session
List<Map<String, String>> cookieList =
(List<Map<String, String>>)
session.getAttribute("cookieList");

// If list not exist, create new
if (cookieList == null) {

cookieList =
new ArrayList<Map<String, String>>();

}

// Get current time
long currentTimeSeconds =
System.currentTimeMillis() / 1000;

// Format time
SimpleDateFormat sdf =
new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

String timestamp =
sdf.format(new Date());

// Create cookie entry
Map<String, String> cookieEntry =
new HashMap<String, String>();

cookieEntry.put("name", name);
cookieEntry.put("domain", domain);
cookieEntry.put("maxAge", maxAge);
cookieEntry.put("setTime",
String.valueOf(currentTimeSeconds));

// Create actual cookie
Cookie cookie =
new Cookie(name, "value");

// Set max age
cookie.setMaxAge(
Integer.parseInt(maxAge));

// IMPORTANT:
// Do NOT use setDomain()
// It causes cookie failure in localhost

response.addCookie(cookie);

// Add to list
cookieList.add(cookieEntry);

// Save back to session
session.setAttribute(
"cookieList",
cookieList);

%>

<h3 class="success">
Cookie Set Successfully
</h3>

<p>
<strong>Cookie Name:</strong>
<%= name %>
</p>

<p>
<strong>Domain:</strong>
<%= domain %>
</p>

<p>
<strong>Max Age:</strong>
<%= maxAge %> seconds
</p>

<p>
<strong>Set Time:</strong>
<%= timestamp %>
</p>

<%

} else {

%>

<p style="color:red;">
Invalid input values
</p>

<%

}

%>

<p>

<a href="index.jsp">
Return to Cookie List
</a>

</p>

</div>

</body>

</html>