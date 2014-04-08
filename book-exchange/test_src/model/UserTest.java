package model;

import model.User;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests that User object correctly contains the data
 * 
 *
 */
public class UserTest extends TestCase {

	@Test
	/**
	 * Verify that a newly created User contains
	 * the data supplied to the constructor
	 */
	public void testConstructor() {
		User instance = new User();
		
		assertNotNull("User instance is not null", instance);
		
		assertEquals("instance user id", 0 ,instance.getUserId());
		assertEquals("instance role", "", instance.getRole());
		assertEquals("instance first name", "", instance.getFirstName());
		assertEquals("instacen last name", "", instance.getLastName());
		assertEquals("instance email address", "", instance.getEmailAddress());
		assertEquals("instance street address", "", instance.getStreetAddress());
		assertEquals("instance city", "", instance.getCity());
		assertEquals("instance state", "", instance.getState());
		assertEquals("instance zip", 0, instance.getZip());
		assertEquals("instance country", "", instance.getCountry());
		
		
		instance.setUserName("group2");
		instance.setRole("Seller");
		instance.setFirstName("Pinal");
		instance.setLastName("Patel");
		instance.setEmailAddress("pmpatel7988@gmail.com");
		instance.setStreetAddress("Lexington Road");
		instance.setCity("Athens");
		instance.setState("Georgia");
		instance.setZip(30605);
		instance.setCountry("USA");
		
		assertEquals("instance user id", "group2" ,instance.getUserName());
		assertEquals("instance role", "Seller", instance.getRole());
		assertEquals("instance first name", "Pinal", instance.getFirstName());
		assertEquals("instacen last name", "Patel", instance.getLastName());
		assertEquals("instance email address", "pmpatel7988@gmail.com", instance.getEmailAddress());
		assertEquals("instance street address", "Lexington Road", instance.getStreetAddress());
		assertEquals("instance city", "Athens", instance.getCity());
		assertEquals("instance state", "Georgia", instance.getState());
		assertEquals("instance zip", 30605, instance.getZip());
		assertEquals("instance country", "USA", instance.getCountry());
	
		
		
		User instance2 = new User("group2", "Buyer", "Amanda", "Paulasky",
				"amandapalusky@gmail.com", "Atlanta Hwy", "Athens", "GA", 30601, "USA");
		
		assertNotNull("User instance2 is not null", instance2);
		
		assertEquals("instance2 user id", "group2" ,instance2.getUserName());
		assertEquals("instance2 role", "Buyer", instance2.getRole());
		assertEquals("instance2 first name", "Amanda", instance2.getFirstName());
		assertEquals("instacen2 last name", "Paulasky", instance2.getLastName());
		assertEquals("instance2 email address", "amandapalusky@gmail.com", instance2.getEmailAddress());
		assertEquals("instance2 street address", "Atlanta Hwy", instance2.getStreetAddress());
		assertEquals("instance2 city", "Athens", instance2.getCity());
		assertEquals("instance2 state", "GA", instance2.getState());
		assertEquals("instance2 zip", 30601, instance2.getZip());
		assertEquals("instance2 country", "USA", instance2.getCountry());
		
		
	}//testConstructor

}//UserTest 
