package com.shura.signup;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.shura.repositories.*;
import com.shura.domain.*;
import com.shura.Exceptions.*;

/**
 * Servlet implementation class LoginHandler
 */
@WebServlet("/Login")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginHandler() {
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
			User user = repo.authenticatedUser(request.getCookies());
			request.setAttribute("userId", user.Id);
			request.setAttribute("userName", user.Name);
			request.setAttribute("userEmai", user.Email);
			request.setAttribute("userPhone", user.Mobile);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}catch(BSNotAuthenticated ex) {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			
			UserRepo repo = new UserRepo();
			User found_user = repo.login(email, password);
            response.addCookie(new Cookie("user", String.valueOf(found_user.Id)));
            
            request.setAttribute("user", found_user);
            request.getRequestDispatcher("home.jsp").forward(request, response);

		}catch(BSNotFound | ClassNotFoundException | SQLException ex) {
			request.setAttribute("alert", "<div class='alert alert-danger'> "+ex.getMessage()+" </div>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
