// * Build a servlet program to create a cookie to get your name through text box and press submit button(
//* through HTML) to display the message by greeting Welcome back your name ! , you have visited this page
// * n times ( n = number of your visit ) and demonstrate the expiry of cookie also.


package com.cookieServlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("userName");

        int count = 1;
        String existingUser = null;

        Cookie[] cookies = request.getCookies();

        // Read existing cookies
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    existingUser = c.getValue();
                }
                if (c.getName().equals("count")) {
                    count = Integer.parseInt(c.getValue());
                    count++;
                }
            }
        }

        // If user enters name first time
        if (name != null && !name.isEmpty()) {
            existingUser = name;
            count = 1;
        }

        // Create cookies
        Cookie userCookie = new Cookie("user", existingUser);
        Cookie countCookie = new Cookie("count", String.valueOf(count));

        // Set expiry (30 seconds for demo)
        userCookie.setMaxAge(30);
        countCookie.setMaxAge(30);

        response.addCookie(userCookie);
        response.addCookie(countCookie);

        // Output
        out.println("<html><body>");

        if (existingUser != null) {
            out.println("<h2 style='color:blue;'>Welcome back, " + existingUser + "!</h2>");
            out.println("<h3>You have visited this page " + count + " times</h3>");
            out.println("<p style='color:red;'>Note: Cookie expires in 30 seconds</p>");
        } else {
            out.println("<h2 style='color:red;'>Please enter your name first</h2>");
        }

        out.println("<br><a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }
}
