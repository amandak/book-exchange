package db;
import java.util.ArrayList;

import model.Book;
import model.User;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Test class verifies that BookHelper methods accurately modify Book table in database
 @author Vince Caparell
 */

public class BookHelperTest extends TestCase {

	@Test
	public void testConstructor() {

		/**
		 * Verify that book listing is successfully added to database and data is accurate
		 */
		//Create new book object
		UserHelper userHelper = null;
		try {
			userHelper = new UserHelper();
		} catch (Exception e) {
			System.out.println(e.getClass().getName()+ " Opening connection and creating preparedstatement: " + e.getMessage());
		}
		
		ArrayList<User> userList = userHelper.getAllUsers();
		userHelper.closeConnection();
		
		int userId = userList.get(0).getUserId();
		int bookId = 2;
		String isbn = "9780123747501";
		double price = 35;
		String title = "Computer Organization and Design";
		String desc = "Book in good condition. Cover shows minor signs of wear.";
		String author = "David A. Patterson";
		String ed = "fourth";
		String status = "listed";
		String condition = "GOOD";
		String department = "CSCI";
		String className = "CSCI4720";

		
		Book newBook1 = new Book(userId, bookId, title, isbn, desc, author, ed,
				status, condition, price, className, department);

		/**
		 * Open connection to database by creating object of BookHelper
		 * and add new book listing to Book table
		 */
		BookHelper bookDAO = null;
		try {
			bookDAO = new BookHelper();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		//Method returns id
		
		boolean added = bookDAO.addBook(newBook1); 
		
		assertTrue("added a book", added);
		ArrayList<Book> books = bookDAO.getBookbyBookName("CSCI", "CSCI4720", "Computer Organization");
		Book book = books.get(0);
		
		assertNotNull("book not null", book);
		assertEquals("book name", title, book.getBookName());
		assertEquals("book desc", desc, book.getDescription());
		assertEquals("book price", price, book.getPrice());
		assertEquals("book isbn", isbn, book.getIsbn());
		assertEquals("book author", author, book.getAuthor());
		assertEquals("book edition", ed, book.getEdition());
		assertEquals("book condition", condition, book.getCondition());
		assertEquals("book status", status, book.getStatus());
		assertEquals("book department", department, book.getDepartment());
		assertEquals("book classname", className, book.getClassName());
		assertEquals("book author", author, book.getAuthor());
		
		ArrayList<Book> bookList = bookDAO.getAllBooks();
		int newID1 = bookList.get(0).getBookId();
		/**
		 * Verify that new book data was accurately entered into database
		 */
		Book bookTest = bookDAO.getBookById(newID1);

		//assertEquals("Book ID: ", , bookTest.getID());
		assertEquals("Title", "Computer Organization and Design", bookTest.getBookName());
		assertEquals("ISBN", "9780123747501", bookTest.getIsbn());
		assertEquals("Book description", "Book in good condition. Cover shows minor signs of wear.", bookTest.getDescription());
		assertEquals("Author", "David A. Patterson", bookTest.getAuthor());
		assertEquals("Edition", "fourth", bookTest.getEdition());
		assertEquals("Status", "listed", bookTest.getStatus()); //Modify the status value
		assertEquals("Condition", "GOOD", bookTest.getCondition());
		assertEquals("Price", 35.0, bookTest.getPrice());

		
		/**
		 * Remove book listing from table and verify null
		 */
		bookDAO.deleteBook(newID1);
		Book nullBook = bookDAO.getBookById(newID1);
		assertNull("Removed book listing is not null as expected", nullBook);


		bookDAO.closeConnection();

	}
}


