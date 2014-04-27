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

		System.out.println("Entered doGet method of bookQueryController");

		String userRole = (String) session.getAttribute("role");
		Integer userId = (Integer)session.getAttribute("userId");
		String bookIdentifier = request.getParameter("bookId");
		String bookname = request.getParameter("bookname");
		String department = request.getParameter("department");
		String className = request.getParameter("className");
		String listBooks = request.getParameter("listBooks");
		String requestUserId = request.getParameter("userId");


		String requestUrI = "";
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
			System.out.println("Entered bookIdentifier if condition");
			int bookId = -1;
			try{
				bookId = Integer.parseInt(bookIdentifier);
			}catch(NumberFormatException e){
				System.out.println("Error parsing bookId in BookQueryController: " + e.getMessage());
			}

			if ((userRole == null || userRole.isEmpty()) && (userId == null))
			{
				System.out.println("Entered user not logged in condition within bookIdentifier");
				loginError = "To view this listing, please login first.";
				url = "/login.jsp";

				requestUrI = request.getRequestURI().toString();
				String[] splitUrl = requestUrI.split("/");
				requestUrI = splitUrl[2];
				String queryUrl = request.getQueryString();
				if (queryUrl != null)
					requestUrI += "?" + queryUrl;
			}
			else{
				System.out.println("Entered user logged in condition within bookIdentifier");
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
			System.out.println("Entered bookname search condition");
			ArrayList<Book> bookList = bookHelper.searchByBookName(bookname);
			session.setAttribute("bookList", bookList);
			url = "/listings.jsp";
		}//second if
		else if(department != null && className != null)
		{
			System.out.println("Entered department and classname condition");
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
		// User has clicked "My Books" or "Remove a Book" from user.jsp
		else if((listBooks != null) && (requestUserId != null)){
			System.out.println("Listing books for My Books or Remove a Book");
			// Retrieve list of books this user has for sale and save it in session
			ArrayList<Book> bookList = bookHelper.getBooksBySeller(userId);
			session.setAttribute("bookList", bookList);

			// Set redirect URL
			url = "/listings.jsp";
		}

		bookHelper.closeConnection();
		System.out.println("requestUrI: "+ requestUrI);
		System.out.println("url: " +url);
		// Set session attributes
		session.setAttribute("requestUrI", requestUrI);
		session.setAttribute("errorFind", errorFind);
		session.setAttribute("searchError", searchError);
		session.setAttribute("loginError", loginError);

		// Redirect user and forward request/response
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entered doPost of bookQueryController");
		//transfer to doGet if asking for viewing a book
		if (request.getParameter("bookId") != null)
		{
			doGet(request, response);
		}
		else {
			HttpSession session = request.getSession();
			Integer userId = (Integer)session.getAttribute("userId");
			System.out.println("Entered doPost of bookQuery");
			// Create a bookHelper object for accessing the book database
			BookHelper bookHelper = null;
			try{
				bookHelper = new BookHelper();
			}catch(Exception e){
				System.out.println("Error creating bookHelper in BookQuery doPost method: " + e.getMessage());
			}


			String bookIdToRemove = request.getParameter("bid");
			String listBooks = request.getParameter("listBooks");
			String requestUserId = request.getParameter("userId");
			
			
			String bookTitle = request.getParameter("bookTitle");
			String author = request.getParameter("author");
			String isbn = request.getParameter("isbn");
			String department = request.getParameter("department");
			String className = request.getParameter("className");
			String edition = request.getParameter("edition");
			String condition = request.getParameter("condition");
			String price = request.getParameter("price");
			String description = request.getParameter("description");
			String url = "";
			String addBookError = "";
			
			
			System.out.println("bookTitle: "+ bookTitle);
			System.out.println("rquestUserId: "+ requestUserId);
			// User is trying to remove a book
			if((bookIdToRemove != null) && (request.getParameter("removeBook") != null)){
				// delete book from the database with the bookid given
				int bookId = Integer.parseInt(bookIdToRemove);

				// Delete book from the database
				bookHelper.deleteBook(bookId);

				// Retrieve list of books this user has for sale and save it in session
				ArrayList<Book> bookList = bookHelper.getBooksBySeller(userId);
				session.setAttribute("bookList", bookList);

				// Set redirect URL
				url = "/listings.jsp";
			} 
			// User has clicked on "My Books" or "Remove a Book" from user.jsp
			else if ((listBooks != null) && (requestUserId != null)){
				// Retrieve list of books this user has for sale and save it in session
				ArrayList<Book> bookList = bookHelper.getBooksBySeller(userId);
				session.setAttribute("bookList", bookList);

				// Set redirect URL
				url = "/listings.jsp";
			}
			//User requests to add a Book
			else if ((bookTitle != null || department != null) && requestUserId != null)
			{
				if (bookTitle.isEmpty())
				{
					addBookError = "Please enter a book title.";
					url = "/addBook.jsp";
				}
				else if (department.isEmpty() || department.equals("-1"))
				{
					addBookError = "Please select a department.";
					url = "/addBook.jsp";
				}
				else if (className.isEmpty())
				{
					addBookError = "Please enter a class name for this book.";
					url = "/addBook.jsp";
				}
				else if (price.isEmpty())
				{
					addBookError = "Please enter selling price for this book.";
					url = "/addBook.jsp";
				}
				else
				{
					double newPrice = 0.0;
					if (!price.isEmpty())	
						newPrice = Double.parseDouble(price);
					Book newBook = new Book(userId, 0, bookTitle, isbn, description, author, 
							edition, Book.STATUS_SELL, condition, newPrice, className, department);
					bookHelper.addBook(newBook);
					
					// Retrieve list of books this user has for sale and save it in session
					ArrayList<Book> bookList = bookHelper.getBooksBySeller(userId);
					session.setAttribute("bookList", bookList);

					// Set redirect URL
					url = "/listings.jsp";
				}
			}
			bookHelper.closeConnection();

			session.setAttribute("addBookError", addBookError);
			// Redirect user and forward request/response
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request, response);

		}
	}
}
