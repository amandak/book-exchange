package db;
import java.security.MessageDigest;
import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import model.*;

/**
 * Test class verifies that UserHelper methods accurately modify Users table in database
 */
public class UserHelperTest extends TestCase {

	// @Test
	public void test() {
       
       /**
       	* Verify that user listing is successfully added to database and data is accurate
       	*/
       	//Create new user object
		int userId = 1;
		String username = "ronmcdon";
		String role = "user";
		String firstName = "Ronald";
		String lastName = "McDonald";
		String emailAddress = "mc@donalds.com";
		String streetAddress = "123 Main Street";
		String city = "Athens";
		String state = "GA";
		int zip = 30601;
		String country = "USA";
		
		User newUser = new User(userId, username, role, firstName, lastName, emailAddress, streetAddress, city, state, zip, country);
       	
       	/**
       	 * Open connection to database by creating object of UserHelper
       	 * and add new user to the table
       	 */
       	UserHelper helper = new UserHelper();
       	
       	
		//add user
       	helper.addNewUser(newUser, "password");
       	
       	/**
       	 * Verify that new user data was accurately entered into database
       	 */
       	User userFromDatabase = helper.getUser("ronmcdon");
    
       	// Assert that the data returned is valid
       	assertEquals("User ID", 1, userFromDatabase.getUserId());
       	assertEquals("User Name", "ronmcdon", userFromDatabase.getUserName());
       	assertEquals("Role", "user", userFromDatabase.getRole());
       	assertEquals("FirstName", "Ronald", userFromDatabase.getFirstName());
       	assertEquals("Last Name", "McDonald", userFromDatabase.getLastName());
       	assertEquals("Email Address", "mc@donald.com", userFromDatabase.getEmailAddress());
       	assertEquals("Street Address", "123 Main Street", userFromDatabase.getStreetAddress());
       	assertEquals("City", "Athens", userFromDatabase.getCity());
       	assertEquals("State", "GA", userFromDatabase.getState());
       	assertEquals("Zip", "30601", userFromDatabase.getZip());
       	assertEquals("Country", "USA", userFromDatabase.getCountry());
       	
       	
       	/*
       	 * Verify that verifyLogin returns the correct boolean based on whether credentials are valid.
       	 */
       	boolean verifyWorks = helper.verifyLogin("username", "password");
       	assertTrue("Login succeeded", verifyWorks);
       	
       	
       	/*
       	 * Verify that the correct number of users is returned
       	 */
       	ArrayList<User> users = helper.getAllUsers();
       	assertEquals("Number of users returned", 2, users.size());
       	
       	/*
       	 * Verify that changing the password for a user works
       	 */
       	String newPassword = "newpassword";		
		helper.updateUserPassword("ronmcdon", newPassword);
		boolean verified = helper.verifyLogin("romcdon", "newpassword");
		assertTrue("Password changed successfully", verified);
	}
}
