package db;

import java.util.ArrayList;

import model.Book;

/**
 * This class is a Data Access Object.  It's purpose is to handle 
 * querying/updating the application database for anything User
 * related.
 * @author Team 2 Software, LLC 
 */
public class BookHelper {
	/**
	 * Constructor for a BookHelper object. Creates a Driver Mananager, 
	 * opens a connection to the database, and initializes all prepared statements.
	 */
	public BookHelper(){
		
	}
	
	/**
	 * Retrieves a Book from the database based on the ID specified
	 * @param bookId	The primary-key ID of this Book
	 * @return			The book the with specified ID
	 */
	public Book getBookById(int bookId){
		return null;
	}

	/**
	 * Retrieves all books being sold by a particular user.
	 * @param userName	The username of the seller whose books to retrieve
	 * @return			A list of books being sold by this user
	 */
	public ArrayList<Book> getBooksBySeller(String userName){
		return null;
	}

	/**
	 * Retrieves all books stored in the database
	 * @return	A list of all books currently stored in the database
	 */
	public ArrayList<Book> getAllBooks(){
		return null;
	}

	/**
	 * Retrieves all books currently listed for sale
	 * @return	A list of all books currently listed for sale
	 */
	public ArrayList<Book> getBooksForSale(){
		return null;
	}

	/**
	 * Retrieves all books for a certain department
	 * @param department	The department whose books we want to return
	 * @return				A list of all books for sale in the specified department
	 */
	public ArrayList<Book> getBooksByDepartment(String department){
		return null;
	}
	
	/**
	 * Adds a new book to the database
	 * @param book	The Book to add
	 */
	public int addBook(Book book){
		return 0;
		
	}
	
	/**
	 * Updates a book's status in the database
	 * @param bookId		The primary-key ID of the book to update
	 * @param newStatus		The new status of the book
	 */
	public void updateBookStatus(int bookId, String newStatus){
		
	}
	
	/**
	 * Deletes a book from the database
	 * @param bookId	The primary-key ID of the book to delete
	 */
	public void deleteBook(int bookId){
		
	}

	/**
	 * Changes the book name 
	 * @param bookId book id 
	 * @param bookName name of the book
	 */
	public void setBookName(int bookId, String bookName) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Changes the ISBN number for a book
	 * @param bookId id of the book
	 * @param isbn ISBN of the book 
	 */
	public void setISBN(int bookId, String isbn) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Changes the description for a book
	 * @param bookId id of the book
	 * @param description book description
	 */
	public void setDesc(int bookId, String description) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Changes the author for a book
	 * @param bookId id of the book
	 * @param author name of author
	 */
	public void setAuthor(int bookId, String author) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Changes the edition for a book
	 * @param bookId id of the book
	 * @param edition edition book
	 */
	public void setEdition(int bookId, String edition) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Changes status for a book
	 * @param bookId id of the book
	 * @param status status of the book
	 */
	public void setStatus(int newID1, String status) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Changes the condition for a book
	 * @param bookId id of the book
	 * @param condition condition of the book
	 */
	public void setCondition(int bookId, String condition) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Changes the price for a book
	 * @param bookId id of the book
	 * @param price price of the book
	 */
	public void setPrice(int newID1, int price) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}