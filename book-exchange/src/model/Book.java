package model;

/**
 * This class is a Data Transfer Object.  It serves as a bundle
 * of data which represents a Book.
 * @author Team 2 Software, LLC 
 */
public class Book {
	
	/**
	 * ID of the book.
	 */
	int bookId;
	
	/**
	 * Name of the book.
	 */
	String bookName;
	
	/**
	 * ISBN number of the book
	 */
	String isbn;
	
	/**
	 * Description of the book
	 */
	String description;
	
	/**
	 * Author of the book
	 */
	String author;
	
	/**
	 * Edition of the book
	 */
	String edition;
	
	/**
	 * Status of the book
	 */
	String status;
	
	/**
	 * Condition of the book
	 */
	String condition;
	
	/**
	 * Price of the book
	 */
	double price;
	
	/**
	 * Constructor for a book object.  
	 * @param _bookId		The primary-key ID of the book.
	 * @param _bookName		The name of the book.
	 * @param _isbn			The ISBN of the book.
	 * @param _desciption	The description of the book.
	 * @param _author		The author of the book.
	 * @param _edition		The edition of the book.
	 * @param _status		The status of the book (listed, sold, etc.)
	 * @param _condition	The condition of the book (good, fair, bad, etc.)
	 * @param price			The price of the book.
	 */
	public Book(int _bookId, String _bookName, String _isbn, String _desciption, String _author, String _edition, String _status, String _condition, double price){
		
	}
	
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @param edition the edition to set
	 */
	public void setEdition(String edition) {
		this.edition = edition;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Get method for the ID of this book
	 * @return	The primary-key ID of the book
	 */
	public int getBookId(){
		return this.bookId;
	}//getBookId
	
	/**
	 * Get method for the name of the book
	 * @return	The name of the book
	 */
	public String getBookName(){
		return this.bookName;
	}//getBookName
	
	/**
	 * Get method for the ISBN of the book
	 * @return	The ISBN of the book
	 */
	public String getIsbn(){
		return this.isbn;
	}//getIsbn
	
	/**
	 * Get method for the description of the book
	 * @return	The description of the book
	 */
	public String getDescription(){
		return this.description;
	}//getDescription
	
	/**
	 * Get method for the author of the book
	 * @return	The author of the book
	 */
	public String getAuthor(){
		return this.author;
	}//getAuthor
	
	/**
	 * Get method for the edition of the book
	 * @return	The edition of the book
	 */
	public String getEdition(){
		return this.edition;
	}//getEdition
	
	/**
	 * Get method for the status of the book
	 * @return	The status of the book
	 */
	public String getStatus(){
		return this.status;
	}//getStatus
	
	/**
	 * Get method for the condition of the book
	 * @return	The condition of the book
	 */
	public String getCondition(){
		return this.condition;
	}//getCondition
	
	/**
	 * Get method for the price of the book
	 * @return	The price of the book
	 */
	public double getPrice(){
		return this.price;	
	}//getPrice
	
	
	
}//Book class
