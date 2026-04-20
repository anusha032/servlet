// * 8b. Build a servlet program to create a cookie to get your name through text box and press submit button(
//* through HTML) to display the message by greeting Welcome back your name ! , you have visited this page
//* n times ( n = number of your visit ) along with the list of cookies and its setvalues and demonstrate the
//* expiry of cookie also.



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

PrintWriter out = response.getWriter();

// Get name from textbox
String name = request.getParameter("userName");

int count = 1;

String user = null;

Cookie[] cookies = request.getCookies();

// Read existing cookies
if (cookies != null) {

for (Cookie c : cookies) {

if (c.getName().equals("user")) {

user = c.getValue();

}

if (c.getName().equals("count")) {

count = Integer.parseInt(c.getValue());
count++;

}

}

}

// First visit
if (name != null && !name.isEmpty()) {

user = name;
count = 1;

}

// Create cookies
Cookie userCookie =
new Cookie("user", user);

Cookie countCookie =
new Cookie("count",
String.valueOf(count));

// Set expiry (30 seconds)
userCookie.setMaxAge(30);
countCookie.setMaxAge(30);

// Add cookies
response.addCookie(userCookie);
response.addCookie(countCookie);

// Output
out.println("<html><body>");

out.println("<h2 style='color:blue;'>");
out.println("Welcome back " + user + " !");
out.println("</h2>");

out.println("<h3>");
out.println("You have visited this page "
+ count + " times");
out.println("</h3>");

out.println("<p style='color:red;'>");
out.println("Cookie expires in 30 seconds");
out.println("</p>");

// Display cookie list with set values
out.println("<h3>List of Cookies with Set Values:</h3>");

Cookie[] cookieList =
request.getCookies();

if (cookieList != null) {

for (Cookie c : cookieList) {

out.println("<p>");

out.println(
"Cookie Name: "
+ c.getName() + "<br>");

out.println(
"Cookie Value: "
+ c.getValue() + "<br>");

out.println(
"Set Max Age: "
+ c.getMaxAge() + "<br>");

out.println("</p><hr>");

}

}
else {

out.println(
"<p>No cookies found</p>");

}

// Back link
out.println(
"<br><a href='cookieForm.html'>Go Back</a>");

out.println("</body></html>");

}
}