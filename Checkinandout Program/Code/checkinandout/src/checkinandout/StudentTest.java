// Author: Julien and Lando

package checkinandout;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class StudentTest {

	// Testing of check in method in student
	
	@Test
	void testcheckin() {
		
		Student stest = new Student("1022" ,"julien", "julien@alustudent.com", "24-03-2021", "true", "00:10:20", "Not yet");
		ArrayList<String> list = stest.studentcheckin();
		
		String originallist[] = new String[list.size()];
		for (int j = 0; j<list.size(); j++) {
			originallist[j] = list.get(j);
		}
		String[] expected_output = {"1022" ,"julien", "julien@alustudent.com", "24-03-2021", "true", "00:10:20", "Not yet"};
		
		assertArrayEquals(expected_output, originallist);
	}
	
	// Testing check out method in student 
	
	@Test
	void testcheckout() {
		Student stest0 = new Student();
		Student stest = new Student("1022" ,"julien", "julien@alustudent.com", "24-03-2021", "true", "00:10:20", "Not yet");
		ArrayList<String> list = stest.studentcheckin();
		
		List<List<String>> sdata = new ArrayList<List<String>>();
		sdata.add(list);
		
		String time = "";
		
		String name = "julien";
		List<List<String>> list2 = stest0.checkout(sdata, name);
	
		ArrayList<String> list3 = new ArrayList<String>();
		for(int row = 0; row < list2.size(); row++) {
			for(int column = 0; column < list2.get(row).size(); column++) {
				list3.add(list2.get(row).get(0));
				list3.add(list2.get(row).get(1));
				list3.add(list2.get(row).get(2));
				list3.add(list2.get(row).get(3));
				list3.add(list2.get(row).get(4));
				list3.add(list2.get(row).get(5));
				list3.add(list2.get(row).get(6));
				time = list2.get(row).get(6);
				break;
			}
		}
		
		String listnew[] = new String[list3.size()];
		for (int j = 0; j<list3.size(); j++) {
			listnew[j] = list3.get(j);
		}
		String[] expected = {"1022" ,"julien", "julien@alustudent.com", "24-03-2021", "true", "00:10:20", time};
		
		assertArrayEquals(expected, listnew);
	
	}

}
