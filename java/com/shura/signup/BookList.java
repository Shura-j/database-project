package com.shura.signup;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import com.shura.domain.*;
import com.shura.repositories.*;
import com.shura.Exceptions.*;

/**
 * Servlet implementation class BookList
 */
@WebServlet("/book_list")
public class BookList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			UserRepo repo = new UserRepo();
			BookRepo book_repo = new BookRepo();
			
			User temp = repo.authenticatedUser(request.getCookies());
			request.setAttribute("userName", temp.Name);
			request.setAttribute("userEmail", temp.Email);
			request.setAttribute("userPhone", temp.Mobile);
			
			ArrayList<Book> books = book_repo.getByUser(temp.Id);
			request.setAttribute("books", books);
			
			request.getRequestDispatcher("To-buy.jsp").forward(request, response);
		}catch(BSNotFound ex) {
			request.setAttribute("alert", ex.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);
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
		try {
			BookRepo book_repo = new BookRepo();
			UserRepo repo = new UserRepo();
			User temp = repo.authenticatedUser(request.getCookies());
			ArrayList<Book> books = book_repo.getByUser(temp.Id);
			request.setAttribute("books", books);
			request.getRequestDispatcher("To.jsp").forward(request, response);
		}catch(Exception ex) {
			
		}
	}

}
