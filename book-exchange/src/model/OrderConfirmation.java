package model;

/**
 * This class is a Data Transfer Object.  It serves as a bundle
 * of data which represents an entire order.
 * @author Team 2 Software, LLC 
 */
public class OrderConfirmation {
	/**
	 * Constructor for an OrderConfirmation object.
	 * @param _cart		The cart for this order.
	 * @param _buyer	The customer making this order.
	 * @param _date		The date the sale was processed.
	 */
	public OrderConfirmation(Cart _cart, User _buyer, String _date){
		
	}
	
	/**
	 * Get method for the Cart of this order confirmation.
	 * @return	A Cart object associated with this order.
	 */
	public Cart getCart(){
		return null;
	}
	
	/**
	 * Get method for the buyer of this order.
	 * @return	A User object associated with the person who placed the order.
	 */
	public User getBuyer(){
		return null;
	}
	
	/**
	 * Get method for the date of this order.
	 * @return	The date (in String format) that this order was placed.
	 */
	public String getDate(){
		return null;
	}
}
