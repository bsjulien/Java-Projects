// Authors: Serge Sugira and Elnam Umutoni

package timemgt;

import java.util.ArrayList;

public class Home extends Activities{
	
	public Home() {};
	public Home(String title, String date, String fromtime, String totime) {
		super(title, date, fromtime, totime);
	}
	
	// Method for creating an activity at home
	
	public ArrayList<String> homecreate(){
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add(title);
		list.add(date);
		list.add(fromtime);
		list.add(totime);
		
		return list;
	}
	
}
