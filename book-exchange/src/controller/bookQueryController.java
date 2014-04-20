package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Book;
import db.BookHelper;

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
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}//doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
