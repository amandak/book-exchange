package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import db.UserHelper;

/**
 * Servlet implementation class loginController
 */
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute("loginError", "");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		
		if((!username.isEmpty()) && (!password.isEmpty()))
		{
			System.out.println("entered first if");
			UserHelper helper = null;
			
			try {
				helper = new UserHelper();
			} catch (Exception e) {
				System.out.println(e.getClass().getName() + " initializing UserHelper object: " + e.getMessage());
			}
			
			boolean isLoginVerified = helper.verifyLogin(username, password);
			
			if (isLoginVerified)
			{
				
				User user = helper.getUser(username);
				session.setAttribute("userId", user.getUserId());
				session.setAttribute("role", user.getRole());
				helper.closeConnection();
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/listings.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				helper.closeConnection();
				session.setAttribute("loginError", "You are not an authorized user.");
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}
		}
		else
		{
			System.out.println("entered second else");
			if (username.isEmpty() || password.isEmpty())
			{
				session.setAttribute("loginError", "Either username or password is not provided");
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			}
		}
		
	}//doPost

}
