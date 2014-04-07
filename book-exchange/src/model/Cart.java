package model;

import java.util.ArrayList;


/**
 * Cart class represents the Book items 
 * @author Team 2 Software, LLC
 *
 */
public class Cart {

	/**
	 * List of Books
	 */
	ArrayList<Book> bookList;
	
	/**
	 * Total price for the items in the cart
	 */
	double totalPrice;
	
	/**
	 * Initializes list of Book
	 * @param bookList list of Book
	 */
	public Cart(ArrayList<Book> bookList)
	{
		this.bookList = bookList;
		this.totalPrice = 0;
	}//Cart
	
	/**
	 * Returns the total price for the items in the cart
	 */
	public double getTotalPrice()
	{
		return this.totalPrice;
	}//getTotalPrice
	
	/**
	 * Sets the total price for the order
	 * @param price
	 */
	public void setTotalPrice(double price)
	{
		this.totalPrice = price;
	}//setTotalPrice
	
	/**
	 * Computes the total price for the Book item in the Cart
	 * @return
	 */
	public double computeTotalPrice()
	{
		double sum = 0;
		for (int i = 0; i < bookList.size(); i++)
		{
			sum += bookList.get(0).price;
		}
		return sum;
	}//computeTotalPrice
	
	/**
	 * Returns the list of Book items
	 */
	public ArrayList<Book> getBookList()
	{
		return this.bookList;
	}//getBookList
	
	/**
	 * Adds 'book' to the bookList
	 */
	public void addBook(Book book)
	{
		this.bookList.add(book);
	}//addBook
	
	/**
	 * Removes the book from the bookList
	 * @param book
	 */
	public void removeBook(Book book)
	{
		this.bookList.remove(book);
	}//removeBook
}//Cart class
