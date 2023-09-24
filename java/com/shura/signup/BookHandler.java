package com.shura.signup;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.shura.domain.*;
import com.shura.Exceptions.*;
import com.shura.repositories.*;

/**
 * Servlet implementation class BookHandler
 */
@WebServlet("/add_book")
public class BookHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			UserRepo repo = new UserRepo();
			User temp = repo.authenticatedUser(request.getCookies());
			request.setAttribute("userName", temp.Name);
			request.setAttribute("userEmail", temp.Email);
			request.setAttribute("userPhone", temp.Mobile);
			request.getRequestDispatcher("To-sell.jsp").forward(request, response);
		}catch(Exception ex) {
			request.setAttribute("message", ex.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Book new_book = new Book();
		new_book.Author = request.getParameter("bauthor");
		new_book.Name = request.getParameter("bname");
		new_book.BookType = request.getParameter("btype");
		new_book.Price = Double.parseDouble(request.getParameter("bprice"));
		new_book.Description = request.getParameter("bdescription");
		new_book.Quantity = Integer.parseInt(request.getParameter("bquantity"));

		try {
		
			if(new_book.Quantity <= 0) {
				throw new Exception("Book should be greater than 0");
			}
			
			UserRepo user_repo = new UserRepo();
			BookRepo repo = new BookRepo();
			
			User auth_user = user_repo.authenticatedUser(request.getCookies());
			new_book.UserId = auth_user.Id;
			
			if(!repo.addBook(new_book)) {
				throw new Exception("registration failed!");
			}

			request.setAttribute("alert", "<div class='alert alert-success'> Book has been registered </div>");
			request.getRequestDispatcher("To-sell.jsp").forward(request, response);

		}catch(BSNotAuthenticated ex) {
			request.setAttribute("alert", "<div class='alert alert-danger'> "+ex.getMessage()+" </div>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}catch(Exception ex) {
			request.setAttribute("alert", "<div class='alert alert-danger'> "+ex.getMessage()+" </div>");
			request.getRequestDispatcher("To-sell.jsp").forward(request, response);
		}
	}

}
