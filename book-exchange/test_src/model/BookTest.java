package model;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * 
 * Tests that Book object correctly contains the data
 *
 */
public class BookTest extends TestCase {

	@Test
	/**
	 * Verify that a newly created Book contains
	 * the data supplied to the constructor
	 */
	public void testConstructor() {
		Book instance = new Book(12323, 123, "Database Systems", "1234567890888",
				"Database book", "Anonymous", "3", "Listed", "Fair", 25.00, "CSCI4300", "CSCI");

		assertNotNull("Book instance not null", instance);
		assertEquals("instance user id", 12323, instance.getUId());
		assertEquals("instance book id", 123, instance.getBookId());
		assertEquals("instance book name", "Database Systems", instance.getBookName());
		assertEquals("instance book isbn", "1234567890888", instance.getIsbn());
		assertEquals("instance book description", "Database book", instance.getDescription());
		assertEquals("instance book author", "Anonymous", instance.getAuthor());
		assertEquals("instance book edition", "3", instance.getEdition());
		assertEquals("instance book status", "Listed", instance.getStatus());
		assertEquals("instance book condition", "Fair", instance.getCondition());
		assertEquals("instance book price", 25.00, instance.getPrice(), 0.001);
		assertEquals("instance book class title", "CSCI4300", instance.getClassName());
		assertEquals("instance book department", "CSCI", instance.getDepartment());
	
	}//testConstructor

}//BookTest
