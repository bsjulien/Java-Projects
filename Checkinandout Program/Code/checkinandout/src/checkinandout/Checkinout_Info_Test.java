// Author: Julien and Lando

package checkinandout;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class Checkinout_Info_Test {

	// Testing if we can read from student database(text file)
	
	@Test
	void testIsValidIDandName() {
		Checkinandout_info test = new Checkinandout_info();
		
		List<List<String>> rows = new ArrayList<List<String>>();
		
		try (Scanner s = new Scanner(new BufferedReader(new FileReader("students_database.txt")))) {
	        while(s.hasNextLine()) {
	            rows.add(createRow(s.nextLine()));
	        }
	    
	    }catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
		
		assertTrue(test.isValidIDandName(rows, "julien", "1022", "julien@alustudent.com"));
		assertTrue(test.isValidIDandName(rows, "lando", "1023", "lando@alustudent.com"));
		assertFalse(test.isValidIDandName(rows, "peter", "1093", "peter@alustudent.com"));
	}
	
	// Testing if we can read from staff database(text file)
	
	@Test
	void testIsValidStaffIDandName() {
		Checkinandout_info test = new Checkinandout_info();
		
		List<List<String>> rows = new ArrayList<List<String>>();
		
		try (Scanner s = new Scanner(new BufferedReader(new FileReader("staff_database.txt")))) {
	        while(s.hasNextLine()) {
	            rows.add(createRow(s.nextLine()));
	        }
	    
	    }catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
		
		assertTrue(test.isValidIDandName(rows, "ella", "1401", "ella@alueducation.com"));
		assertTrue(test.isValidIDandName(rows, "bobson", "1402", "bobson@alueducation.com"));
		assertFalse(test.isValidIDandName(rows, "ryan", "1083", "peter@gmail.com"));
	}
	
	// Testing if the ValidEmailAddress function works
	
	@Test
	void testIsValidEmail() {
		Checkinandout_info test = new Checkinandout_info();
		
		assertTrue(test.isValidEmailAddress("julien@alustudent.com"));
		assertTrue(test.isValidEmailAddress("ella@alueducation.com"));
		assertFalse(test.isValidEmailAddress("vdat@mka"));
	}
	
	
	// method for return data in terms for array elements
	
	public static List<String> createRow(String line) {
		
		String[] words = line.split(" ");
	    List<String> chars = Arrays.asList(words);
	    return chars;
	}

}
