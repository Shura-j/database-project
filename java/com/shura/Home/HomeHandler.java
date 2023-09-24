package com.shura.Home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shura.Exceptions.BSNotAuthenticated;
import com.shura.domain.User;
import com.shura.repositories.UserRepo;

/**
 * Servlet implementation class HomeHandler
 */
@WebServlet("/home")
public class HomeHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeHandler() {
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
			request.setAttribute("user", user);
//			request.setAttribute("userId", user.Id);
//			request.setAttribute("userName", user.Name);
//			request.setAttribute("userEmai", user.Email);
//			request.setAttribute("userPhone", user.Mobile);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}catch(BSNotAuthenticated ex) {
			request.setAttribute("alert", "<div class='alert alert-danger'> "+ex.getMessage()+" </div>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}catch(Exception ex) {
			request.setAttribute("message", ex.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
