// Authors: Serge Sugira and Elnam Umutoni

package timemgt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Work_test {
	
	// testing work create function 
	
		@Test
		void testworkcreate() {
			
			Work wtest = new Work("Meeting with CEO" ,"09/09/2022", "08:00:00", "08:10:00");
			ArrayList<String> list = wtest.workcreate();
			
			String originallist[] = new String[list.size()];
			for (int j = 0; j<list.size(); j++) {
				originallist[j] = list.get(j);
			}
			String[] expected_output = {"Meeting with CEO" ,"09/09/2022", "08:00:00", "08:10:00"};
			
			assertArrayEquals(expected_output, originallist);
		}
	

}
