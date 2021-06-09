// Authors: Serge Sugira and Elnam Umutoni

package timemgt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class School_test {
	
	// testing school create function 
	
	@Test
	void testschoolcreate() {
		
		School stest = new School("Prog assignments" ,"05/12/2022", "07:20:42", "07:20:55");
		ArrayList<String> list = stest.schoolcreate();
		
		String originallist[] = new String[list.size()];
		for (int j = 0; j<list.size(); j++) {
			originallist[j] = list.get(j);
		}
		String[] expected_output = {"Prog assignments" ,"05/12/2022", "07:20:42", "07:20:55"};
		
		assertArrayEquals(expected_output, originallist);
	}

}
