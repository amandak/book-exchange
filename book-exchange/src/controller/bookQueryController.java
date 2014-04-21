package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.BookHelper;
import model.Book;

/**
 * Servlet implementation class bookQueryController
 * @author Vince Capparell
 */
public class bookQueryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public bookQueryController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BookHelper bookHelper = null;
		String url = "";

		// Instantiate BookHelper
		try{
			bookHelper = new BookHelper();
		}catch (Exception e){
			System.out.println("Error instantiating a BookHelper in BookQueryController: " + e.getMessage());
		}

		String userRole = (String) request.getAttribute("role");
		String userId = (String) request.getAttribute("userId");
		String bookIdentifier = request.getParameter("bookId");
		String bookname = request.getParameter("bookname");
		String department = request.getParameter("department");
		String className = request.getParameter("className");

		System.out.println("userRole: "+ userRole);
		System.out.println("userid: "+ userId);
		System.out.println("bookIdentifier: "+ bookIdentifier);
		System.out.println("bookname: " + bookname);
		System.out.println("deparment:  "+ department);
		System.out.println("className: " + className);
		String searchError = "";
		String errorFind = "";
		String loginError = "";
		// User is trying to view a single book listing, from listings.jsp
		if(bookIdentifier != null){
			int bookId = -1;
			try{
				bookId = Integer.parseInt(bookIdentifier);
			}catch(NumberFormatException e){
				System.out.println("Error parsing bookId in BookQueryController: " + e.getMessage());
			}

			if ((userRole == null || userRole.isEmpty()) && (userId == null || userId.isEmpty()))
			{
				loginError = "To view this listing, please login first.";
				url = "/login.jsp";
			}
			else{
				Book book = bookHelper.getBookById(bookId);

				if(book != null){
					// Store book in request and redirect to single book view for this book
					request.setAttribute("book", book);

					url = "/book.jsp";

				}else{
					errorFind = "Could find this book. Please select another book.";
					url = "/listings.jsp";
				}
			}
		}//first if
		else if(bookname != null)
		{
			ArrayList<Book> bookList = bookHelper.searchByBookName(bookname);
			session.setAttribute("bookList", bookList);
			url = "/listings.jsp";
		}//second if
		else if(department != null && className != null)
		{
			String departmentName = department;
			String classname = className;
			if (department.equals("-1"))
			{
				departmentName = "";
				searchError = "Please select a department.";

				url = "/index.jsp";		
			}
			else if (className.equals("-1") || className.equals("all") || !className.isEmpty())
			{
				if (className.equals("-1") || className.equals("all"))
					classname = "";

				ArrayList<Book> bookList = bookHelper.getBookbyBookName(departmentName, classname, "");
				session.setAttribute("bookList", bookList);
				url="/listings.jsp";
			}

		}//third if
		bookHelper.closeConnection();
		session.setAttribute("errorFind", errorFind);
		session.setAttribute("searchError", searchError);
		session.setAttribute("loginError", loginError);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//add a book or request to remove a book
	}

}
