package com.shura.signup;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuyBookHandler
 */
@WebServlet("/BuyBookHandler")


public class BuyBookHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Fetching book information from the purchase form
        String Bookname = request.getParameter("Bname");
        String Author = request.getParameter("author");
        double Price = Double.parseDouble(request.getParameter("price"));
        
        // Saving the book information to the database (assuming you have a database connection)

        // Redirecting to a success page
        response.sendRedirect("To-buy.jsp");
    }
}
