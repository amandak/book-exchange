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
 * @author Pinal Patel(20% Work Done), Vince Caparell(80% Work Done)
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
		String url = "";
		session.setAttribute("loginError", "");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String logout = request.getParameter("logout"); // This is just a variable that will be set in the request from "user.jsp" if they click the logout button
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		
		// User is logging in from login.jsp
		if((username != null) && (password != null))
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
			    
			    System.out.println("login is verified");
			        User user = helper.getUser(username);
				session.setAttribute("userId", user.getUserId());
				session.setAttribute("role", user.getRole());
				helper.closeConnection();
				System.out.println("before request url");
				String requestURL = "";
				
				if (session.getAttribute("requestUrI") != null)
				    requestURL = session.getAttribute("requestUrI").toString();
				System.out.println("requestURL: "+ requestURL);
				if (requestURL.isEmpty())
				{
	
					url = "/user.jsp";
				}
				else
				{
					
					url = "/"+requestURL;
				}
				
				//url = "/listings.jsp";
				//RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/listings.jsp");
				//dispatcher.forward(request, response);
			}
			else
			{
				helper.closeConnection();
				session.setAttribute("loginError", "You are not an authorized user.");
				
				url = "/login.jsp";
				//RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
				//dispatcher.forward(request, response);
			}
		} 
		// User logging out (from user.jsp?)
		else if (logout != null){
			session.setAttribute("userId", null);
			session.setAttribute("role", null);
			
			// Redirect back to home page
			url = "/index.jsp";
		}
		else
		{
			System.out.println("entered second else");
			if (username.isEmpty() || password.isEmpty())
			{
				session.setAttribute("loginError", "Either username or password is not provided");
				
				url = "/login.jsp";
				//RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
				//dispatcher.forward(request, response);
			}
		}
		System.out.println("url: " + url);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}//doPost

}
