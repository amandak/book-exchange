package model;

/**
 * This class is a Data Transfer Object.  It serves as a bundle
 * of data which represents a Book.
 * @author Team 2 Software, LLC 
 * @author Pinal Patel (50% Work Done), Vince Caparell(50% Work Done)
 */
public class Book {
	
	public static final String STATUS_SELL = "Sell";
	
	public static final String STATUS_EXCHANGE = "Exchange";
	
	public static final String STATUS_PURCHASED = "Purchased";
	
	public static final String CONDITION_NEW = "New";
	
	public static final String CONDITION_LIKE_NEW = "Like New";
	
	public static final String CONDITION_VERY_GOOD = "Very Good";
	
	public static final String CONDITION_GOOD = "Good";
	
	public static final String CONDITION_ACCEPTABLE = "Acceptable";
	/**
	 * user id
	 */
	int uid;
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
	 * Name of class where book is used
	 */
	String classTitle;

	/**
	 * Name of department that includes 
	 * the class where the book is used
	 */
	String department;

	/**
	 * Price of the book
	 */
	double price;
	
	String user;
	
	String email;

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
	 * @param _classTitle   The name of the class that the book is for
	 * @param _department  
	 *///bookId, title, isbn, desc, author, ed, stat, condition, price, department, classTitle
	public Book(int _uid, int _bookId, String _bookName, String _isbn, String _description, 
			String _author, String _edition, String _status, String _condition, double price, 
			String _classTitle, String _department){
		this.uid = _uid;
		this.bookId = _bookId;
		this.bookName = _bookName;
		this.isbn = _isbn;
		this.description = _description;
		this.author = _author;
		this.edition = _edition;
		this.condition = _condition;
		this.status = _status;
		this.price = price;
		this.classTitle = _classTitle;
		this.department = _department;

	}//Book constructor

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
	 * @param classTitle the name of the class where the book is used
	 */
	public void setClassTitle(String classTitle){
		this.classTitle = classTitle;
	}


	/**
	 * User's first and last name
	 * @param user
	 */
	public void setUser(String user)
	{
		this.user = user;
		
	}
	
	/**
	 * Returns user's first and last name
	 * @return
	 */
	public String getUser()
	{
		return this.user;
		
	}
	
	/**
	 * Sets user's email address with this book
	 * @param email
	 */
	public void setEmail(String email)
	{
		this.email = email;
		
	}
	
	/**
	 * Returns user's email address with this book
	 * @return
	 */
	public String getEmail()
	{
		return this.email;
	}
	/**
	 * @param department the name of the department where the book is used
	 */
	public void setDepartment(String department){
		this.department = department;
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

	public String getClassTitle(){
		return this.classTitle;
	}//getClass

	public String getDepartment(){
		return this.department;
	}//getDepartment

	/**
	 * Get method for the price of the book
	 * @return	The price of the book
	 */
	public double getPrice(){
		return this.price;	
	}//getPrice

	/**
	 * Get method for the user id 
	 * @return The id of the user
	 */
	public int getUId()
	{
		return this.uid;
	}

}//Book class
