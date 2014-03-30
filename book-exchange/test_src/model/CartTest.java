package model;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Verifies the Cart object correctly contains the data
 * @author Pinal Patel
 *
 */
public class CartTest extends TestCase {

	@Test
	/**
	 * Verify that a newly created Cart contains
	 * the data supplied to the constructor
	 */
	public void testConstructor() {
		ArrayList<Book> bookList = new ArrayList<Book>();
		Cart instance = new Cart(bookList);
		
		assertNotNull("Cart instance not null", instance);
		assertEquals("instance book list size", 0, instance.getBookList().size());
		
		Book binstance = new Book(123, "Database Systems", "1234567890888",
				"Database book", "Anonymous", "3", "Listed", "Fair", 25.00);
		instance.addBook(binstance);
		assertEquals("instance book list size", 1, instance.getBookList().size());
		assertEquals("instance total price", 25.00, instance.getTotalPrice(), 0.001);
		Book item0 = instance.getBookList().get(0);
		
		assertNotNull("item0 not null", item0);
		assertEquals("item0 book id", 123, item0.getBookId());
		
		instance.removeBook(binstance);
		assertEquals("instance book list size", 0, instance.getBookList().size());
		
		
		
	}//testConstructor

}//CartTest
