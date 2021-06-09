// Author: Julien and Lando
package checkinandout;

// Person class that is the parent to all other classes
public class Person {
	public String name;
	public String email;
	public String date;
	public String vehicle;
	String timein;
	
	// Creating a constructor
	
	public Person() {}
	public Person(String name, String email, String localDate, String vehicle, String timein) {
		this.name = name;
		this.email = email;
		this.date = localDate;
		this.vehicle = vehicle;
		this.timein = timein;
	 
	}
	
	// Function to capitalize the first letter of every word
	
	public static String capitalize(String str) {
	    if(str == null || str.isEmpty()) {
	        return str;
	    }

	    return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
}
