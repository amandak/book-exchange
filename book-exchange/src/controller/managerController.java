package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.UserHelper;
import model.User;

/**
 * Servlet implementation class managerController
 * @author Stephen Patton 
 */
public class managerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public managerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserHelper userHelper = null;

		// Instantiate BookHelper
		try{
			userHelper = new UserHelper();
		}catch (Exception e){
			System.out.println("Error instantiating a UserHelper in managerController: " + e.getMessage());
		}

		System.out.println("Entered doGet method of managerController");

		String userRole = (String) session.getAttribute("role");
		Integer userId = (Integer)session.getAttribute("userId");


		String requestUrI = "";
		System.out.println("userRole: "+ userRole);
		System.out.println("userid: "+ userId);
		String searchError = "";
		String errorFind = "";

		if(userRole.equals("admin")){
			ArrayList<User> userList = userHelper.getAllUsers();
			session.setAttribute("userList", userList);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/userManager.jsp");	
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserHelper userHelper = null;

		try{
			userHelper = new UserHelper();
		}catch (Exception e){
			System.out.println("Error instantiating a UserHelper in managerController: " + e.getMessage());
		}

		System.out.println("Entered doGet method of managerController");

		String userRole = (String) session.getAttribute("role");
		Integer userId = (Integer)session.getAttribute("userId");


		System.out.println("userRole: "+ userRole);
		System.out.println("userid: "+ userId);

		//an array of Strings representing User IDs
		String[] removeUsers = request.getParameterValues("remUser");

		if(userRole.equals("admin")){
			if(removeUsers != null){
				System.out.println("Inside the remove condidtion");
				//one iteration deletes a user
				for (int i=0; i < removeUsers.length; i++){
					int uid;
					try{
						uid = Integer.parseInt(removeUsers[i]);
						userHelper.removeUser(uid);
					}
					catch (Exception e){
						e.printStackTrace();	
					}
				}
			}
			//get all of the users and return them to the page
			ArrayList<User> userList = userHelper.getAllUsers();
			session.setAttribute("userList", userList);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/userManager.jsp");	
			dispatcher.forward(request, response);
		}

		
	}
}
