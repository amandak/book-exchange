package db;

import java.util.ArrayList;

import model.User;

/**
 * This class is a Data Access Object.  It's purpose is to handle 
 * querying/updating the application database for anything User
 * related.
 * @author Team 2 Software, LLC 
 */
public class UserHelper {
	/**
	 * Constructor for a UserHelper object. Creates a Driver Mananager, 
	 * opens a connection to the database, and initializes all prepared statements.
	 */
	public UserHelper(){
		// empty
	}
	
	/**
	 * Retrieves a single user from the database
	 * @param username	The username of the User we want to retrieve
	 * @return			A User object corresponding to the username requested
	 */
	public User getUser(String username){
		return null;
	}
	
	/**
	 * Checks whether the input password hash matches the stored password hash for a user
	 * @param username		The username currently trying to log in
	 * @param password		The password entered 
	 * @return				True if the login credentials are valid, false otherwise
	 */
	public boolean verifyLogin(String username, String password){
		return false;
	}
	
	/**
	 * Retrieves all users from the database
	 * @return		A list of all users stored in the database
	 */
	public ArrayList<User> getAllUsers(){
		return null;
	}
	
	/**
	 * Updates a users password in the database
	 * @param username		The name of the user whose password will be changed
	 * @param newPassword	The new password for the user
	 */
	public void updateUserPassword(String username, String newPassword){
		
	}

	/**
	 * Adds a new user to the database
	 * @param newUser User object 
	 * @param password password
	 */
	public void addNewUser(User newUser, String password) {
		// TODO Auto-generated method stub
		
	}
}