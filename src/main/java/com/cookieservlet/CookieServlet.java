// * 8a. Build a servlet program to create a cookie to get your name through text box and press submit button(
// * through HTML) to display the message by greeting Welcome back your name ! , you have visited this page
// * n times ( n = number of your visit ) along with the list of cookies and demonstrate the expiry of cookie also.

package com.cookieservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")

public class CookieServlet extends HttpServlet {

protected void doGet(
HttpServletRequest request,
HttpServletResponse response)

throws ServletException, IOException {

response.setContentType("text/html");

PrintWriter out =
response.getWriter();

// Get name from textbox
String name =
request.getParameter("userName");

int count = 1;

String existingUser = null;

Cookie[] cookies =
request.getCookies();

// Read existing cookies
if (cookies != null) {

for (Cookie c : cookies) {

if (c.getName().equals("user")) {

existingUser = c.getValue();

}

if (c.getName().equals("count")) {

count =
Integer.parseInt(c.getValue());

count++;

}

}

}

// First time user
if (name != null && !name.isEmpty()) {

existingUser = name;

count = 1;

}

// Create cookies
Cookie userCookie =
new Cookie("user", existingUser);

Cookie countCookie =
new Cookie("count",
String.valueOf(count));

// Set expiry (30 seconds demo)
userCookie.setMaxAge(30);
countCookie.setMaxAge(30);

// Add cookies
response.addCookie(userCookie);
response.addCookie(countCookie);

// Display output
out.println("<html><body>");

if (existingUser != null) {

out.println(
"<h2 style='color:blue;'>Welcome back "
+ existingUser +
"!</h2>");

out.println(
"<h3>You have visited this page "
+ count +
" times</h3>");

out.println(
"<p style='color:red;'>Cookie will expire in 30 seconds</p>");

}

// Show cookie list
out.println("<h3>List of Cookies:</h3>");

Cookie[] cookieList =
request.getCookies();

if (cookieList != null) {

for (Cookie c : cookieList) {

out.println("<p>");

out.println(
"Cookie Name: "
+ c.getName()
+ "<br>");

out.println(
"Cookie Value: "
+ c.getValue()
+ "<br>");

out.println(
"Max Age: "
+ c.getMaxAge()
+ "<br>");

out.println("</p><hr>");

}

}
else {

out.println(
"<p>No cookies found</p>");

}

out.println(
"<br><a href='cookieForm.html'>Go Back</a>");

out.println("</body></html>");

}
}