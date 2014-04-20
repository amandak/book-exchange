package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.UserHelper;
import model.User;

/**
 * Servlet implementation class signupController
 * @author Vince Capparell
 */
public class signupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserHelper userHelper = null; 
		HttpSession session = request.getSession();
		
		try{
			userHelper = new UserHelper();
		}catch(Exception e){
			System.out.println("Error creating UserHelper from signupController: " + e.getMessage());
		}
		
		// Retrieve request parameters
		String signupErrorMessage = "";
		String url = "";
		String username = request.getParameter("newusername");
		String email = request.getParameter("email");
		String secondEmail = request.getParameter("email2");
		String password = request.getParameter("newpassword");
		String secondPassword = request.getParameter("newpassword2");
		
		// User is trying to sign up from signup.jsp
		if(username != null){
			// Make sure all required fields were entered
			if(username.isEmpty() || email.isEmpty() || secondEmail.isEmpty() || password.isEmpty() || secondPassword.isEmpty()){
				signupErrorMessage = "Not all required information was specified. Please try again.";
				url = "/signup.jsp";
			}
			// Check if a user with this username already exists
			else if(userHelper.getUser(username) != null){
				signupErrorMessage = "Username already taken.  Please try again with a different Username.";
				url = "/signup.jsp";
			}else{
				// Ensure emails and passwords match
				if(!email.equals(secondEmail)){
					signupErrorMessage = "Emails didn't match. Please try again.";
					url = "/signup.jsp";
				}else if(!password.equals(secondPassword)){
					signupErrorMessage = "Passwords didn't match. Please try again.";
					url = "/signup.jsp";
				}else{
					// Signup was valid. Add new user to database and store user in session. Redirect back to index page
					User newUser = new User(username, "user", "", "", email, "", "", "", -1, "");
					
					// Add new user to database
					userHelper.addNewUser(newUser, password);
					
					// Save user in session
					session.setAttribute("userId", username);
					session.setAttribute("role", "user");
					
					// Redirect to main user page
					url = "/user.jsp";
				}
			}
		}
		
		// Load RequestDispatcher with correct URL and forward request/response
		session.setAttribute("signupError", signupErrorMessage);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
	    dispatcher.forward(request, response);
		
	}
}
