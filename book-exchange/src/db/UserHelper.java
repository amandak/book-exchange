package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;

/**
 * This class is a Data Access Object.  It's purpose is to handle 
 * querying/updating the application database for anything User
 * related.
 * @author Team 2 Software, LLC 
 * @author Vince Capparell(20% Work Done), Pinal Patel (80% Work Done)  
 */
public class UserHelper {

	/**
	 * Connection object 
	 */
	private Connection conn;

	protected PreparedStatement getUserStatement;
	protected PreparedStatement verifyUserStatement;
	protected PreparedStatement getAllUsersStatement;
	protected PreparedStatement updateUserPasswordStatement;
	protected PreparedStatement addNewUserStatement;
	protected PreparedStatement isUserPresentStatement;
	protected PreparedStatement removeUserStatement;
	/**
	 * Constructor for a UserHelper object. Creates a Driver Mananager, 
	 * opens a connection to the database, and initializes all prepared statements.
	 */
	public UserHelper() throws Exception
	{
		String JDBC_URL="jdbc:mysql://172.17.152.110:3306/bookExchange";
		String DB_USER = "group2";
		String DB_PASS="poopdeck";
		conn = null;
		//establishes connection with database
		try{

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
		}
		catch(SQLException sqle){
			System.out.println("Exception in setUp:"+sqle.getMessage());
		}


		getUserStatement = conn.prepareStatement("SELECT * FROM user WHERE username=?");
		verifyUserStatement = conn.prepareStatement("SELECT username, password FROM user WHERE username=? AND password=?");
		getAllUsersStatement = conn.prepareStatement("SELECT * FROM user");
		updateUserPasswordStatement = conn.prepareStatement("UPDATE user SET password=? WHERE username=?");
		addNewUserStatement = conn.prepareStatement("INSERT INTO user"
				+ "(username, password, role, firstName, lastName, email, streetAddress, city, state, zip, country) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		isUserPresentStatement = conn.prepareStatement("SELECT count(*) AS amount FROM user");
		removeUserStatement = conn.prepareStatement("DELETE FROM user WHERE uid=?");
		
		
		ResultSet rs = null;
		rs = isUserPresentStatement.executeQuery();
		while(rs.next())
		{
			int count = rs.getInt("amount");
			if (count == 0)
			{
				User newUser = new User("admin", "admin", "John", "Smith", "johnsmith@uga.edu", "1234 LumpKin Street", "Athens", "GA", 30605, "USA");
				this.addNewUser(newUser, "group2");
			}
		}
	}

	/**
	 * Retrieves a single user from the database
	 * @param username	The username of the User we want to retrieve
	 * @return			A User object corresponding to the username requested
	 */
	public User getUser(String username){

		User user = null;
		ResultSet rs = null;

		try {
			getUserStatement.setString(1, username);
			rs = getUserStatement.executeQuery();

			if (rs.next())
			{
				int uid = rs.getInt("uid");
				String userName = rs.getString("username");
				String role = rs.getString("role");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				String streetAddr = rs.getString("streetAddress");
				String city = rs.getString("city");
				String state = rs.getString("state");
				int zip = rs.getInt("zip");
				String country = rs.getString("country");
				
				user = new User(userName, role, firstName, lastName, email, 
						streetAddr, city, state, zip, country);
				user.setUserId(uid);
			}


		} catch (SQLException e) {
			System.out.println(e.getClass().getName() + " setting string and executing getUserStatement: " + e.getMessage());
		}

		return user;
	}

	/**
	 * Checks whether the input password hash matches the stored password hash for a user
	 * @param username		The username currently trying to log in
	 * @param password		The password entered 
	 * @return				True if the login credentials are valid, false otherwise
	 */
	public boolean verifyLogin(String username, String password){

		String hashed_pw = User.getHashed_pw(password);
		boolean verified = false;
		ResultSet rs = null;

		try {
			verifyUserStatement.setString(1, username);
			verifyUserStatement.setString(2, hashed_pw);
			rs = verifyUserStatement.executeQuery();

			if (rs.next())
			{
				String userName = rs.getString("username");
				String passWord = rs.getString("password");
				if (userName.equals(username) && passWord.equals(hashed_pw))
					verified = true;
			}

		} catch (SQLException e) {
			System.out.println(e.getClass().getName() + " setting string and executing verifyUserStatement: " + e.getMessage());
		}



		return verified;
	}

	/**
	 * Retrieves all users from the database
	 * @return		A list of all users stored in the database
	 */
	public ArrayList<User> getAllUsers(){
		ArrayList<User> userList = new ArrayList<User>();

		ResultSet rs = null;

		try {
			rs = getAllUsersStatement.executeQuery();
			while (rs.next())
			{
				int uid = rs.getInt("uid");
				String userName = rs.getString("username");
				String role = rs.getString("role");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String email = rs.getString("email");
				String streetAddr = rs.getString("streetAddress");
				String city = rs.getString("city");
				String state = rs.getString("state");
				int zip = rs.getInt("zip");
				String country = rs.getString("country");
				User user = new User(userName, role, firstName, lastName, email, 
						streetAddr, city, state, zip, country);
				user.setUserId(uid);
				userList.add(user);
			}

		} catch (SQLException e) {
			System.out.println(e.getClass().getName() + " executing getAllUsersStatement: " + e.getMessage());
		}



		return userList;
	}

	/**
	 * Updates a users password in the database
	 * @param username		The name of the user whose password will be changed
	 * @param newPassword	The new password for the user
	 */
	public boolean updateUserPassword(String username, String newPassword)
	{
		boolean updated = false;
		String hashed_pw = User.getHashed_pw(newPassword);
		try 
		{
			getUserStatement.setString(1, username);
			ResultSet rs = getUserStatement.executeQuery();

			if (rs.next())
			{
				if (username.equals(rs.getString("username")))
				{
					updateUserPasswordStatement.setString(1, hashed_pw);
					updateUserPasswordStatement.setString(2, username);
					updateUserPasswordStatement.executeUpdate();
					updated = true;
				}
			}
			else
			{
				updated = false;
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getClass().getName() + " setting string and executing Statement: " + e.getMessage());
		}

		return updated;

	}

	/**
	 * Adds a new user to the database
	 * @param newUser User object 
	 * @param password password
	 */
	public boolean addNewUser(User newUser, String password) {
		boolean addedNewUser = false;
		try 
		{
			getUserStatement.setString(1, newUser.getUserName());
			ResultSet rs = getUserStatement.executeQuery();

			if (rs.next())
			{
				addedNewUser = false;
			}
			else
			{
				addNewUserStatement.setString(1, newUser.getUserName());
				addNewUserStatement.setString(2, User.getHashed_pw(password));
				addNewUserStatement.setString(3, newUser.getRole());
				addNewUserStatement.setString(4, newUser.getFirstName());
				addNewUserStatement.setString(5, newUser.getLastName());
				addNewUserStatement.setString(6, newUser.getEmailAddress());
				addNewUserStatement.setString(7, newUser.getStreetAddress());
				addNewUserStatement.setString(8, newUser.getCity());
				addNewUserStatement.setString(9, newUser.getState());
				addNewUserStatement.setInt(10, newUser.getZip());
				addNewUserStatement.setString(11, newUser.getCountry());
				addNewUserStatement.executeUpdate();
				addedNewUser = true;
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getClass().getName() + " setting string and executing Statement: " + e.getMessage());
		}
		return addedNewUser;
	}
	
	/**
	 * Removes the user 
	 * @param userId id of the user
	 * @return
	 */
	public boolean removeUser(int userId)
	{
		boolean removed = false;
		
		try {
			removeUserStatement.setInt(1, userId);
			int remove = removeUserStatement.executeUpdate();
			if(remove >= 1)
			{
				removed = true;
			}
		} catch (SQLException e) {
			System.out.println(e.getClass().getName() + " removing user: " + e.getMessage());
		}
		
		
		
		return removed;
	}

	/**
	 * Closes connection and all prepared statements
	 */
	public void closeConnection()
	{
		try {
			getUserStatement.close();;
			verifyUserStatement.close();;
			getAllUsersStatement.close();
			updateUserPasswordStatement.close();;
			addNewUserStatement.close();
			isUserPresentStatement.close();
			removeUserStatement.close();
			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getClass().getName() + " Closing connection and PreparedStatements: " + e.getMessage());
		}
	}
}