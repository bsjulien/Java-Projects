// Authors: Serge Sugira and Elnam Umutoni

package timemgt;

import java.util.ArrayList;

public class Work extends Activities{
	
	public Work() {};
	public Work(String title, String date, String fromtime, String totime) {
		super(title, date, fromtime, totime);
	}
	
	// Method for creating activities at work
	
	public ArrayList<String> workcreate(){
		
		ArrayList<String> list = new ArrayList<String>();
	
		list.add(title);
		list.add(date);
		list.add(fromtime);
		list.add(totime);
		
		return list;
	}
	
}
