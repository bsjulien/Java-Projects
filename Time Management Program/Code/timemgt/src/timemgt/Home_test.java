//Authors: Serge Sugira and Elnam Umutoni

package timemgt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


class Home_test {
	
	// testing home create function 
	
	@Test
	void testhomecreate() {
		
		Home htest = new Home("Waking up" ,"01/01/2022", "00:10:22", "00:10:30");
		ArrayList<String> list = htest.homecreate();
		
		String originallist[] = new String[list.size()];
		for (int j = 0; j<list.size(); j++) {
			originallist[j] = list.get(j);
		}
		String[] expected_output = {"Waking up" ,"01/01/2022", "00:10:22", "00:10:30"};
		
		assertArrayEquals(expected_output, originallist);
	}

}
