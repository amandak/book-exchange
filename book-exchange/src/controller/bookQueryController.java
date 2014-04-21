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
		
		String bookIdentifier = request.getParameter("bookId");
		String bookname = request.getParameter("bookname");
		String department = request.getParameter("department");
		String className = request.getParameter("className");
		
		String searchError = "";
		// User is trying to view a single book listing, from listings.jsp
		if(bookIdentifier != null){
			int bookId = -1;
			try{
				bookId = Integer.parseInt(bookIdentifier);
			}catch(NumberFormatException e){
				System.out.println("Error parsing bookId in BookQueryController: " + e.getMessage());
			}
			
			Book book = bookHelper.getBookById(bookId);
			
			if(book != null){
				// Store book in request and redirect to single book view for this book
				request.setAttribute("book", book);
				
				url = "/book.jsp";
				
			}else{
				// Book was not found. Error on our part, since the user got here from the BookListings page
				//TODO - Figure out what to do if we run into this error. Just redirect back to book listings?
			}
		}
		if(bookname != null || !bookname.isEmpty())
		{
			ArrayList<Book> bookList = bookHelper.searchByBookName(bookname);
			session.setAttribute("bookList", bookList);
			url = "/listings.jsp";
		}
		if(department != null && className != null)
		{
			String departmentName = department;
			String classname = className;
			if (department.equals("-1"))
			{
				departmentName = "";
				searchError = "Please select a department.";
				
				url = "/index.jsp";		
			}
			else if (className.equals("-1") || className.equals("all"))
			{
				classname = "";
				ArrayList<Book> bookList = bookHelper.getBookbyBookName(departmentName, classname, "");
				session.setAttribute("bookList", bookList);
				url="/listings.jsp";
			}
			
		}
		bookHelper.closeConnection();
		session.setAttribute("searchError", searchError);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
