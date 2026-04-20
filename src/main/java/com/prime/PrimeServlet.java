//* Build a servlet program to check the given number is prime number or not using HTML with step by
// * step procedure.


package com.prime;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int num = Integer.parseInt(request.getParameter("num"));

            boolean isPrime = true;

            if (num <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= num / 2; i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            // Output
            out.println("<html><body>");
            out.println("<h2>Result</h2>");

            if (isPrime) {
                out.println("<p style='color:green;'>" + num + " is a Prime Number</p>");
            } else {
                out.println("<p style='color:red;'>" + num + " is NOT a Prime Number</p>");
            }

            out.println("<br><a href='PrimeCheck.html'>Check Another</a>");
            out.println("</body></html>");

        } catch (Exception e) {
            out.println("<h3 style='color:red;'>Invalid Input</h3>");
        }
    }
}
