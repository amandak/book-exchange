package model;

import java.security.MessageDigest;

/**
 * User class represents a user for the book-exchange application.
 * @author Pinal
 *
 */
public class User {

	/**
	 * id of the user
	 */
	int userId;
	
	/**
	 * user name
	 */
	String userName;
	
	/**
	 * Role of the user
	 */
	String role;
	
	/**
	 * First name of the user
	 */
	String firstName;
	
	/**
	 * Last name of the user
	 */
	String lastName;
	
	/**
	 * Email address of the user
	 */
	String emailAddress;
	
	/**
	 * Street address of the user
	 */
	String streetAddress;
	
	/**
	 * City for the user's street address
	 */
	String city;
	
	/**
	 * State for the user's street address
	 */
	String state;
	
	/**
	 * Zip code for the user's street address
	 */
	int zip;
	
	/**
	 * Country of the user's address
	 */
	String country;
	
	/**
	 * Initializes all fields to its default values
	 */
	public User()
	{
		
	}//User constructor
	
	/**
	 * Initializes all fields to given parameters
	 * @param userId id of the user
	 * @param userName name of the user
	 * @param role role of the user
	 * @param fName first name of the user
	 * @param lName last name of the user
	 * @param emailAddr email address of the user
	 * @param streetAddr street address of the user
	 * @param city city of the user's street address
	 * @param state state of the user's street address
	 * @param zip zip code of the user's street address
	 * @param country country of the user's address
	 */
	public User(int userId, String userName, String role, String fName, String lName, 
			String emailAddr, String streetAddr, String city, String state, 
			int zip, String country)
	{
		this.userId = userId;
		this.userName = userName;
		this.role = role;
		this.firstName = fName;
		this.lastName = lName;
		this.emailAddress = emailAddr;
		this.streetAddress = streetAddr;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		
	}//User Constructor

	/**
	 * Returns the user id 
	 */
	public int getUserId()
	{
		return this.userId;
	}
	
	/**
	 * Sets the user id
	 * @param userId
	 */
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	
	/**
	 * Returns the name of the user
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}//getUserId

	/**
	 * Returns the role of the user
	 * @return the role
	 */
	public String getRole() {
		return role;
	}//getRole

	/**
	 * Returns the first name of the user
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}//getFirstName

	/**
	 * Returns the last name of the user
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}//getLastName

	/**
	 * Returns the email address of the user
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}//getEmailAddress

	/**
	 * Returns the street address of the user
	 * @return the streetAddress
	 */
	public String getStreetAddress() {
		return streetAddress;
	}//getStreetAddress

	/**
	 * Returns the city of the user's street address
	 * @return the city
	 */
	public String getCity() {
		return city;
	}//getCity

	/**
	 * Returns the state of the user's street adress
	 * @return the state
	 */
	public String getState() {
		return state;
	}//getState

	/**
	 * Returns the zip code of the user's street address
	 * @return the zip
	 */
	public int getZip() {
		return zip;
	}//getZip

	/**
	 * Returns the country of the user's address
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}//getCountry

	/**
	 * Sets the user id 
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}//setUserId

	/**
	 * Sets the role of the user
	 */
	public void setRole(String role) {
		this.role = role;
	}//setRole

	/**
	 * Sets the first name of the user
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}//setFirstName

	/**
	 * Sets the last name of the user
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}//setLastName

	/**
	 * Sets the email address of the user
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}//setEmailAddress

	/**
	 * Sets the street address of the user
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}//setStreetAddress

	/**
	 * Sets the city of the street address
	 */
	public void setCity(String city) {
		this.city = city;
	}//setCity

	/**
	 * Sets the city of the state 
	 */
	public void setState(String state) {
		this.state = state;
	}//setState

	/**
	 * Sets the zip code
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}//setZip

	/**
	 * Sets the country for the user's address
	 */
	public void setCountry(String country) {
		this.country = country;
	}//setCountry
	
	/**
	 * Returns the encrypted password given the 'password' in English language
	 * 
	 */
	public static String getHashed_pw(String password) {
		byte[] plainText = password.getBytes();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } 
        catch (Exception e) {
            System.err.println(e.toString());
        }
    	md.reset();
		md.update(plainText);
		byte[] encodedPassword = md.digest();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < encodedPassword.length; i++) {
			if ((encodedPassword[i] & 0xff) < 0x10) {
				sb.append("0");
			}
			sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
		}
		return sb.toString();
	}//getHashed_pw
	
}//User class
