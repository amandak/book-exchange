package db;
import model.Book;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Test class verifies that BookHelper methods accurately modify Book table in database
 */

public class BookHelperTest extends TestCase {

	@Test
	public void testConstructor() {


		//TODO: Add another book listing to test


		/**
		 * Verify that book listing is successfully added to database and data is accurate
		 */
		//Create new book object
		int userId = 23;
		int bookId = 2;
		String isbn = "9780123747501";
		double price = 35;
		String title = "Computer Organization and Design";
		String desc = "Book in good condition. Cover shows minor signs of wear.";
		String author = "David A. Patterson";
		String ed = "fourth";
		String status = "listed"; //Does this specify that book is for sale, sold, or traded?
		String condition = "GOOD";

		//Should we pass in ID as param? Or should that be automatically set by database?
		Book newBook1 = new Book(userId, bookId, title, isbn, desc, author, ed, status, condition, price);

		/**
		 * Open connection to database by creating object of BookHelper
		 * and add new book listing to Book table
		 */
		BookHelper bookDAO = new BookHelper();
		//Method returns id
		//Change this if we want to set id instead of it automatically getting set
		int newID1 = bookDAO.addBook(newBook1); 

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
		assertEquals("Status", "", bookTest.getStatus()); //Modify the status value
		assertEquals("Condition", "GOOD", bookTest.getCondition());
		assertEquals("Price", 35, bookTest.getPrice());

		/**
		 * Update a current book listing and verify that modifications made to Book table are accurate
		 */
		//update title bookDAO.setTitle(newID1)
		bookDAO.setBookName(newID1, "Organizacion de la Computadora");
		bookDAO.setISBN(newID1, "9780123747503");
		bookDAO.setDesc(newID1, "Cover torn off. Book is in terrible shape.");
		bookDAO.setAuthor(newID1, "John L. Hennessy");
		bookDAO.setEdition(newID1, "third");
		bookDAO.setStatus(newID1, ""); //Change this
		bookDAO.setCondition(newID1, "acceptable");
		bookDAO.setPrice(newID1, 4);

		//Update bookTest object with the modifications
		bookTest = bookDAO.getBookById(newID1);

		assertEquals("title modified", "Organizacion de la Computadora", bookTest.getBookName());
		assertEquals("ISBN modified", "9780123747503", bookTest.getIsbn());
		assertEquals("Description modified", "Cover torn off. Book is in terrible shape.", bookTest.getDescription());
		assertEquals("Author modified", "John L. Hennessy", bookTest.getAuthor());
		assertEquals("Edition modified", "third", bookTest.getEdition());
		assertEquals("Status modified", "", bookTest.getStatus());
		assertEquals("Condition modified", "acceptable", bookTest.getCondition());
		assertEquals("Price modified", 4, bookTest.getPrice());

		//Should we have more getters in BookHelper as well? I'm not sure if we would need them.


		/**
		 * Remove book listing from table and verify null
		 */
		bookDAO.deleteBook(newID1);
		Book nullBook = bookDAO.getBookById(newID1);
		assertNull("Removed book listing is not null as expected", nullBook);


		

	}
}


