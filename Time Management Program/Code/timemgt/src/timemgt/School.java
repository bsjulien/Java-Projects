// Authors: Elnam Umutoni and Serge Sugira

package timemgt;

import java.util.ArrayList;

public class School extends Activities{
	
	
	public School() {};
	public School(String title, String date, String fromtime, String totime) {
		super(title, date, fromtime, totime);
	}
	
	// Method for creating school activity
	
	public ArrayList<String> schoolcreate(){
		
		ArrayList<String> list = new ArrayList<String>();
	
		list.add(title);
		list.add(date);
		list.add(fromtime);
		list.add(totime);
		
		return list;
	}
		

}
