// Authors: Serge Sugira and Elnam Umutoni

package timemgt;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SetActivities_test {
	
	//Testing validate Java Date function
	
	@Test
	void test_validateJavaDate() {

		assertFalse( SetActivities.validateJavaDate("1:01:2020"));
		assertFalse( SetActivities.validateJavaDate("31/02/2021"));
		assertTrue( SetActivities.validateJavaDate("1/01/2020"));
		
	}
	
	//Testing validate Java Time 
	
	@Test
	void test_validateJavaTime() {
		
		assertFalse( SetActivities.validateJavaTime("1:01:2020"));
		assertFalse( SetActivities.validateJavaTime("01/90/98"));
		assertTrue( SetActivities.validateJavaTime("01:00:00"));
	}
	
	//Testing compare Date
	
	@Test
	void test_compareDate() {
		assertFalse( SetActivities.compareDate("01/09/2021", "02/10/2021"));
		assertFalse( SetActivities.compareDate("01/03/2021", "08/05/2021"));
		assertTrue( SetActivities.compareDate("09/05/2021", "08/05/2021"));
	}
	
	//Testing compare From Time
	
	@Test
	void test_comparefromTime() {
		assertFalse( SetActivities.comparefromTime("01:00:00", "01:10:10", "08/05/2021"));
		assertTrue( SetActivities.comparefromTime("01:00:00", "01:10:10", "10/10/2021"));
		assertTrue( SetActivities.comparefromTime("01:10:10", "01:00:00", "08/05/2021"));
	}
	
	//Testing compare To time
	
	@Test
	void test_comparetoTime() {
		assertFalse( SetActivities.comparetoTime("01:10:00", "01:00:00"));
		assertTrue( SetActivities.comparetoTime("01:10:00", "01:10:30"));
	}
	

}
