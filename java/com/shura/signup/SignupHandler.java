package com.shura.signup;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.shura.domain.*;
import com.shura.repositories.UserRepo;


/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/register")
public class SignupHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("registration.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User current_user = new User();
		String repass = request.getParameter("re_pass");

		current_user.Email = request.getParameter("email"); 
		current_user.Password = request.getParameter("pass");  
		current_user.Mobile = request.getParameter("contact");
		current_user.Name = request.getParameter("uname");

		if( !repass.equals(current_user.Password) ) {
			request.setAttribute("alert", "<div class=\"alert alert-danger\"> password does not match </div>");
			request.getRequestDispatcher("registration.jsp").forward(request, response);
			return;
		}
		
		try {

			UserRepo repo = new UserRepo();
			boolean result = repo.addUser(current_user);
			
			request.setAttribute("alert", (result ? "<div class='alert alert-success'>registered successfully </div>" : "<div class='alert alert-danger'>Not Registered some error occured! </div>"));
			
			
		}catch(ClassNotFoundException | SQLException e) {
			request.setAttribute("alert", "<div class='alert alert-success'> "+e.getMessage()+" </div>");
		}
		
		request.getRequestDispatcher("registration.jsp").forward(request, response);
	
	}
		
}	


