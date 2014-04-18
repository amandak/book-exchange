package db;

import model.Book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**                                                                                                             
 * This class is a Data Access Object.  It's purpose is to handle                                               
 * querying/updating the application database for anything User                                                 
 * related.                                                                                                     
 * @author Team 2 Software, LLC
 * @author Pinal Patel(70% Work Done), Amanda Palusky(30% Work Done)
 */
public class BookHelper {

	protected PreparedStatement getBookByIdStatement;
	protected PreparedStatement getBooksBySellerStatement;
	protected PreparedStatement getAllBooksStatement;
	protected PreparedStatement getBooksByClassStatement;
	protected PreparedStatement getBooksByDepartmentStatement;
	protected PreparedStatement getBooksForSellStatement;
	protected PreparedStatement updateBookStatusStatement;
	protected PreparedStatement deleteBookStatement;
	protected PreparedStatement addBookStatement;
	protected PreparedStatement getBookByBookNameStatement;
	protected PreparedStatement searchByBookNameStatement;
	protected PreparedStatement getClassByDepartment;
	private Connection conn;

	/**
	 * Constructor creates a driver manager and opens connection to database
	 */
	public BookHelper() throws Exception{
		try{

			String JDBC_URL = "jdbc:mysql://172.17.152.110:3306/bookExchange";
			String user     = "group2";
			String password = "poopdeck";

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(JDBC_URL, user, password);
			System.out.println("Successfully connected to database.");
		}
		catch(Exception e){
			System.out.println(e.getClass().getName()+" opening database connection: "+e.getMessage());
		}


		//initializing all prepared statements
		try {
			//PreparedStatement that will retrieve a book that matches the id 
			getBookByIdStatement = conn.prepareStatement("SELECT * FROM book WHERE bid=?");

			//PreparedStatement that will retrieve list of Books by Seller
			getBooksBySellerStatement = conn.prepareStatement("SELECT * FROM book WHERE uid=?");

			//PreparedStatement that will retrieve list of All Books
			getAllBooksStatement = conn.prepareStatement("SELECT * FROM book");

			//PreparedStatement that will retrieve list of Books where its status is Sell
			getBooksForSellStatement = conn.prepareStatement("SELECT * FROM book WHERE status='" + Book.STATUS_SELL + "'");

			//PreparedStatement that will retrieve list of Books by department
			getBooksByDepartmentStatement = conn.prepareStatement("SELECT * FROM book WHERE department=?");

			//PreparedStatement that will retrieve list of Books by Class name
			getBooksByClassStatement = conn.prepareStatement("SELECT * FROM book WHERE className=?");

			//PreparedStatement that insert a Book into book table.
			addBookStatement = conn.prepareStatement("INSERT INTO book (uid, bookName, isbn, description, "
					+ "author, edition, department, className, status, bookCondition, price)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			//PreparedStatement that updates a Book's status
			updateBookStatusStatement = conn.prepareStatement("UPDATE book SET status=? WHERE bid=?");

			//PreparedStatement that deletes a Book from the book table
			deleteBookStatement = conn.prepareStatement("DELETE FROM book WHERE bid=?");

			//PreparedStatement that retrieves Books by bookName
			getBookByBookNameStatement = conn.prepareStatement("SELECT * FROM book WHERE department=? AND className=? AND bookName LIKE(?)");

			//PreparedStatement that retrieves list of Books given only book name
			searchByBookNameStatement = conn.prepareStatement("SELECT * FROM book WHERE bookName LIKE(?)");

			getClassByDepartment = conn.prepareStatement("SELECT className FROM book WHERE department=?");

		} catch (SQLException e) {
			System.out.println(e.getClass().getName() + " initalizing all prepared statements: " + e.getMessage());
		}


	}//constructor


	/**
	 * Retrieves a book listing from the database based on the ID
	 */
	public Book getBookById(int bookId){
		ResultSet rs = null;
		Book bookObj = null;



		try {
			/**
			 * Set parameter in the PreparedStatement and execute
			 */
			getBookByIdStatement.setInt(1, bookId);
			rs = getBookByIdStatement.executeQuery();

			if(rs.next()){

				/**
				 * create Book object with data from book table
				 */ 
				int uid = rs.getInt("uid");
				int bid = rs.getInt("bid");
				String title = rs.getString("bookName");
				String isbn = rs.getString("isbn");
				String desc = rs.getString("description");
				String author = rs.getString("author");
				String ed = rs.getString("edition");
				String department = rs.getString("department");
				String className = rs.getString("className");
				String stat = rs.getString("status");
				String condition = rs.getString("bookCondition");
				double price = rs.getDouble("price");


				bookObj = new Book(uid, bid, title, isbn, desc, 
						author, ed, stat, condition, price, className, department);

			}//if
		} catch (SQLException e) {
			System.out.println(e.getClass().getName() + " Retrieving a Book by id: " + e.getMessage());
		}


		return bookObj; //Return null if the book is not found
	}//getBookById()


	/**
	 * Retrieves all books sold by a specified seller
	 */
	public ArrayList<Book> getBooksBySeller(int userId){
		ArrayList<Book> bookList = new ArrayList<Book>();
		ResultSet rs = null;


		try {
			/**
			 * Set parameter in the PreparedStatement and execute
			 */
			getBooksBySellerStatement.setInt(1, userId);
			rs = getBooksBySellerStatement.executeQuery();

			while(rs.next())
				// create Book object with data from book table	
			{
				int userid = rs.getInt("uid");
				int bid = rs.getInt("bid");
				String title = rs.getString("bookName");
				String isbn = rs.getString("isbn");
				String desc = rs.getString("description");
				String author = rs.getString("author");
				String ed = rs.getString("edition");
				String department = rs.getString("department");
				String className = rs.getString("className");
				String stat = rs.getString("status");
				String condition = rs.getString("bookCondition");
				double price = rs.getDouble("price");


				Book bookObj = new Book(userid, bid, title, isbn, desc, 
						author, ed, stat, condition, price, className, department);
				bookList.add(bookObj);
			}

		} catch (SQLException e) {
			System.out.println(e.getClass().getName() + " Retrieving List of Books by user id: " + e.getMessage());
		}

		return bookList;
	}//getBooksBySeller()



	/**
	 * Retrieves all books stored in database
	 */
	public ArrayList<Book> getAllBooks(){
		ArrayList<Book> allBooks = new ArrayList<Book>();

		ResultSet rs = null;

		try 
		{
			rs = getAllBooksStatement.executeQuery();

			while(rs.next())
				// create Book object with data from book table	
			{
				/**
				 * Create Book object with data from one row in book table.
				 * Then add the Book object to an ArrayList.
				 */ 
				int userid = rs.getInt("uid");
				int bid = rs.getInt("bid");
				String title = rs.getString("bookName");
				String isbn = rs.getString("isbn");
				String desc = rs.getString("description");
				String author = rs.getString("author");
				String ed = rs.getString("edition");
				String department = rs.getString("department");
				String className = rs.getString("className");
				String stat = rs.getString("status");
				String condition = rs.getString("bookCondition");
				double price = rs.getDouble("price");


				Book bookObj = new Book(userid, bid, title, isbn, desc, 
						author, ed, stat, condition, price, className, department);
				//Add bookObj to ArrayList
				allBooks.add(bookObj);


			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getClass().getName() + " Retrieving List of All Books: " + e.getMessage());
		}

		return allBooks;
	}//getAllBooks()


	/**
	 * Retrieves all book currently listed for sale
	 */	 
	public ArrayList<Book> getBooksForSell(){
		ArrayList<Book> bookList = new ArrayList<Book>();
		ResultSet rs = null;

		try
		{
			rs = getBooksForSellStatement.executeQuery();

			while(rs.next())
				// create Book object with data from book table	
			{
				/**
				 * Create Book object with data from one row in book table.
				 * Then add the Book object to an ArrayList.
				 */ 
				int userid = rs.getInt("uid");
				int bid = rs.getInt("bid");
				String title = rs.getString("bookName");
				String isbn = rs.getString("isbn");
				String desc = rs.getString("description");
				String author = rs.getString("author");
				String ed = rs.getString("edition");
				String department = rs.getString("department");
				String className = rs.getString("className");
				String stat = rs.getString("status");
				String condition = rs.getString("bookCondition");
				double price = rs.getDouble("price");


				Book bookObj = new Book(userid, bid, title, isbn, desc, 
						author, ed, stat, condition, price, className, department);
				//Add bookObj to ArrayList
				bookList.add(bookObj);


			}//while
		}
		catch(SQLException e)
		{
			System.out.println(e.getClass().getName() + " Retrieving List of Books that is for Sell : " + e.getMessage());
		}


		return bookList;
	}//getBooksForSell()



	/**
	 * Retrieves all books for a certain department
	 */
	public ArrayList<Book> getBooksByDepartment(String department){

		ArrayList<Book> bookList = new ArrayList<Book>();
		ResultSet rs = null;

		try{
			/**
			 * Set parameter in the MySQL prepared statement and execute
			 */
			getBooksByDepartmentStatement.setString(1, department);;
			rs = getBooksByDepartmentStatement.executeQuery();

			while(rs.next())
				// create Book object with data from book table	
			{
				/**
				 * Create Book object with data from one row in book table.
				 * Then add the Book object to an ArrayList.
				 */ 
				int userid = rs.getInt("uid");
				int bid = rs.getInt("bid");
				String title = rs.getString("bookName");
				String isbn = rs.getString("isbn");
				String desc = rs.getString("description");
				String author = rs.getString("author");
				String ed = rs.getString("edition");
				String departmentName = rs.getString("department");
				String className = rs.getString("className");
				String stat = rs.getString("status");
				String condition = rs.getString("bookCondition");
				double price = rs.getDouble("price");


				Book bookObj = new Book(userid, bid, title, isbn, desc, 
						author, ed, stat, condition, price, className, departmentName);
				//Add bookObj to ArrayList
				bookList.add(bookObj);


			}//while
		}
		catch(SQLException e)
		{
			System.out.println(e.getClass().getName() + " Retrieving List of Books by department : " + e.getMessage());
		}

		return bookList;
	}//getBooksByDepartment()




	/**
	 * Retrieves all books for a certain class
	 */
	public ArrayList<Book> getBooksByClass(String className){
		ArrayList<Book> booksList = new ArrayList<Book>();
		ResultSet rs = null;

		try{
			/**
			 * Create MySQL prepared statement and execute
			 */
			getBooksByClassStatement.setString(1, className); 
			rs = getBooksByClassStatement.executeQuery();

			while(rs.next())
				// create Book object with data from book table	
			{
				/**
				 * Create Book object with data from one row in book table.
				 * Then add the Book object to an ArrayList.
				 */ 
				int userid = rs.getInt("uid");
				int bid = rs.getInt("bid");
				String title = rs.getString("bookName");
				String isbn = rs.getString("isbn");
				String desc = rs.getString("description");
				String author = rs.getString("author");
				String ed = rs.getString("edition");
				String department = rs.getString("department");
				String classTitle = rs.getString("className");
				String stat = rs.getString("status");
				String condition = rs.getString("bookCondition");
				double price = rs.getDouble("price");


				Book bookObj = new Book(userid, bid, title, isbn, desc, 
						author, ed, stat, condition, price, classTitle, department);
				//Add bookObj to ArrayList
				booksList.add(bookObj);


			}//while

		}
		catch(SQLException e){
			System.out.println(e.getClass().getName() + " Retrieving List of Books by Class name : " + e.getMessage());
		}

		return booksList;
	}//getBooksByClass()


	/**
	 * Takes in Book object and places data in the book table.
	 * @return int is the id of newly added book
	 */
	public boolean addBook(Book newBook){

		boolean isAdded = false;
		/**
		 * Get values from newBook object
		 */
		int userId = newBook.getUId();
		String bookName = newBook.getBookName();
		String isbn = newBook.getIsbn();
		String description = newBook.getDescription();
		String author = newBook.getAuthor();
		String edition = newBook.getEdition();
		String department = newBook.getDepartment();
		String className = newBook.getClassName();
		String status = newBook.getStatus();
		String bookCondition = newBook.getCondition();
		double price = newBook.getPrice();		

		try{
			/**
			 * Set parameters in the prepared statement and execute
			 */
			addBookStatement.setInt(1, userId);
			addBookStatement.setString(2, bookName);
			addBookStatement.setString(3, isbn); 
			addBookStatement.setString(4, description);
			addBookStatement.setString(5, author);
			addBookStatement.setString(6, edition);
			addBookStatement.setString(7, department);
			addBookStatement.setString(8, className);
			addBookStatement.setString(9, status);
			addBookStatement.setString(10, bookCondition);
			addBookStatement.setDouble(11, price);

			int added = addBookStatement.executeUpdate();
			if (added >= 1)
				isAdded = true;

		}catch (SQLException e) {
			System.out.println(e.getClass().getName() + " Adding a Book to book table : " + e.getMessage());
		}	

		return isAdded;
	}//addBook()



	/**
	 * Updates a book's status in the database
	 */
	public boolean updateBookStatus(int bookId, String newStatus){
		boolean isUpdated = false;
		try{
			/**
			 * Sets the parameters in prepared statement and execute
			 */

			updateBookStatusStatement.setString(1, newStatus);
			updateBookStatusStatement.setInt(2, bookId);
			int updated = updateBookStatusStatement.executeUpdate();
			if (updated >= 1)
			{
				isUpdated = true;
			}

		}catch (SQLException e) {
			System.out.println(e.getClass().getName() + " Updating a Book status : " + e.getMessage());
		}

		return isUpdated;
	}//updateBookStatus()

	/**
	 * Deletes a book from the database
	 */	  
	public boolean deleteBook(int bookId){
		boolean isDeleted = false;
		try{
			deleteBookStatement.setInt(1, bookId);
			int deleted = deleteBookStatement.executeUpdate();
			if (deleted >= 1)
				isDeleted = true;

		}catch(Exception e){
			System.out.println(e.getClass().getName() + " Deleting a Book from book table  : " + e.getMessage());
		}	

		return isDeleted;
	}//deleteBook()

	/**
	 * Retrieves list of Books which matches bookName provided from given department and class
	 * @param departmentName name of the department
	 * @param className name of the class within department
	 * @param bookName name of the book
	 */
	public ArrayList<Book> getBookbyBookName(String departmentName, String className, String bookName)
	{
		ArrayList<Book> bookList = new ArrayList<Book>();
		String conBookName = "%"+bookName+"%";

		ResultSet rs = null;

		try {
			getBookByBookNameStatement.setString(1, departmentName);
			getBookByBookNameStatement.setString(2, className);
			getBookByBookNameStatement.setString(3, conBookName);

			rs = getBookByBookNameStatement.executeQuery();

			while(rs.next())
				// create Book object with data from book table	
			{
				/**
				 * Create Book object with data from one row in book table.
				 * Then add the Book object to an ArrayList.
				 */ 
				int userid = rs.getInt("uid");
				int bid = rs.getInt("bid");
				String title = rs.getString("bookName");
				String isbn = rs.getString("isbn");
				String desc = rs.getString("description");
				String author = rs.getString("author");
				String ed = rs.getString("edition");
				String department = rs.getString("department");
				String classTitle = rs.getString("className");
				String stat = rs.getString("status");
				String condition = rs.getString("bookCondition");
				double price = rs.getDouble("price");


				Book bookObj = new Book(userid, bid, title, isbn, desc, 
						author, ed, stat, condition, price, classTitle, department);
				//Add bookObj to ArrayList
				bookList.add(bookObj);
			}//while
		} catch (SQLException e) {
			System.out.println(e.getClass().getName() + " Retrieving list of Book objects from book table given bookName : " + e.getMessage());
		}




		return bookList;
	}//getBookbyBookName

	/**
	 * Retrieves all books that matches provided bookName
	 *
	 */
	public ArrayList<Book> searchByBookName(String bookName)
	{

		ArrayList<Book> bookList = new ArrayList<Book>();
		String conBookName = "%"+bookName+"%";

		ResultSet rs = null;

		try {
			searchByBookNameStatement.setString(1, conBookName);

			rs = searchByBookNameStatement.executeQuery();

			while(rs.next())
				// create Book object with data from book table	
			{
				/**
				 * Create Book object with data from one row in book table.
				 * Then add the Book object to an ArrayList.
				 */ 
				int userid = rs.getInt("uid");
				int bid = rs.getInt("bid");
				String title = rs.getString("bookName");
				String isbn = rs.getString("isbn");
				String desc = rs.getString("description");
				String author = rs.getString("author");
				String ed = rs.getString("edition");
				String department = rs.getString("department");
				String classTitle = rs.getString("className");
				String stat = rs.getString("status");
				String condition = rs.getString("bookCondition");
				double price = rs.getDouble("price");


				Book bookObj = new Book(userid, bid, title, isbn, desc, 
						author, ed, stat, condition, price, classTitle, department);
				//Add bookObj to ArrayList
				bookList.add(bookObj);
			}//while
		} catch (SQLException e) {
			System.out.println(e.getClass().getName() + " Retrieving list of Book objects given bookName only : " + e.getMessage());
		}




		return bookList;


	}//searchByBookName

	/**
	 * Retrieves class names by department
	 * @param department
	 * @return
	 */
	public ArrayList<String> getClassByDepartment(String department)
	{
		ArrayList<String> classList = new ArrayList<String>();
		ResultSet rs = null;
		try {
			getClassByDepartment.setString(1, department);
			rs = getClassByDepartment.executeQuery();
			while(rs.next())
			//adds a class name to the class list
			{
				classList.add(rs.getString("className"));
			}
		} catch (SQLException e) {
			System.out.println(e.getClass().getName() + " Retrieving list of Book objects given bookName only : " + e.getMessage());
		}


		return classList;

	}
	/**
	 * Closes all prepared statements and a connection.
	 */
	public void closeConnection()
	{

		try {
			getBookByIdStatement.close();
			getBooksBySellerStatement.close();
			getAllBooksStatement.close();
			getBooksByClassStatement.close();
			getBooksByDepartmentStatement.close();
			getBooksForSellStatement.close();
			updateBookStatusStatement.close();
			deleteBookStatement.close();
			addBookStatement.close();
			getBookByBookNameStatement.close();
			searchByBookNameStatement.close();
			getClassByDepartment.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getClass().getName() + " Closing all PreparedStatement and a connection: " + e.getMessage());
		}

	}//closeConnection

}//BookHelper