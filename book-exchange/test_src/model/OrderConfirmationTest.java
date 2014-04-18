package model;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Verifies the OrderConfirmation object correctly contains the data
 * @author Pinal Patel
 *
 */
public class OrderConfirmationTest extends TestCase {

	@Test
	/**
	 * Verify that a newly created Cart contains
	 * the data supplied to the constructor
	 */
	public void testConstructor() {
		ArrayList<Book> bookList = new ArrayList<Book>();
		Cart cart = new Cart(bookList);
		
		User user = new User("group2", "Buyer", "Amanda", "Paulasky",
				"amandapalusky@gmail.com", "Atlanta Hwy", "Athens", "GA", 30601, "USA");
		
		OrderConfirmation order = new OrderConfirmation(cart, user, "3/30/2014");
		assertNotNull("order not null", order);
		
		Cart new_cart = order.getCart();
		User new_user = order.getBuyer();
		
		assertNotNull("new_cart not null", new_cart);
		assertNotNull("new_user not null", new_user);
		assertEquals("order date", "3/30/2014", order.getDate());
		
	}//testConstructor

}
