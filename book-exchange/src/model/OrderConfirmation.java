package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * This class is a Data Transfer Object.  It serves as a bundle
 * of data which represents an entire order.
 * @author Team 2 Software, LLC 
 */
public class OrderConfirmation {
	/**
	 * Cart object representing cart.
	 */
	Cart cart;
	
	/**
	 * User object representing user.
	 */
	User buyer;
	
	/**
	 * Date for the order
	 */
	String date;
	/**
	 * Constructor for an OrderConfirmation object.
	 * @param _cart		The cart for this order.
	 * @param _buyer	The customer making this order.
	 * @param _date		The date the sale was processed.
	 */
	public OrderConfirmation(Cart _cart, User _buyer, String _date){
		this.cart = _cart;
		this.buyer = _buyer;
		this.date = _date;
	}
	
	/**
	 * Get method for the Cart of this order confirmation.
	 * @return	A Cart object associated with this order.
	 */
	public Cart getCart(){
		return this.cart;
	}
	
	/**
	 * Get method for the buyer of this order.
	 * @return	A User object associated with the person who placed the order.
	 */
	public User getBuyer(){
		return this.buyer;
	}
	
	/**
	 * Get method for the date of this order.
	 * @return	The date (in String format) that this order was placed.
	 */
	public String getDate(){
		return this.date;
	}
	
	/**
	 * Sets the date to the given parameter
	 * @param date
	 */
	public void setDate(String date)
	{
		this.date = date;
	}
	
	/**
	 * Returns the current date and time
	 */
	public static String getCurrentDate()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy", new Locale("en","US"));
		Date today = new Date();
		String output = formatter.format(today);
		
		return output;
	}//getCurrentDateAndTime
}
