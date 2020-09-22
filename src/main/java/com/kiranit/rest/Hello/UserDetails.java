package com.kiranit.rest.Hello;

public class UserDetails {

	
	private String firstName;
	private String lastName;
	private String city;
	
	public UserDetails()
	{
		
	}
	
	public UserDetails(String firstName,String lastName, String city)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.city=city;
	}
	
	// generating getters-setters
	
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{ 
		this.firstName=firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName=lastName;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public void setCity(String city)
	{ 
		this.city=city;
	}

	/*Generate toString method*/
	@Override
	public String toString() {
		return "UserDetails [firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + "]";
	}
	
	
	
	
	
}
