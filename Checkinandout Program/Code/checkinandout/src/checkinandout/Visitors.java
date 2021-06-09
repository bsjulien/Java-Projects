// Author: Julien and Lando

package checkinandout;

import java.util.ArrayList;
import java.util.List;

// Visitors class that handles the checkin and checkout of visitors
public class Visitors extends Person{
	
	public String visitorid;
	public String motif;
	public String timeout;
	
	public Visitors() {};
	public Visitors(String visitorid, String name, String email, String motif, String localDate, String vehicle, String timein, String timeout) {
		super(name, email,localDate, vehicle, timein);
		this.visitorid = visitorid;
		this.motif = motif;
		this.timeout = timeout;
	}
	
	//Method for checking in a visitor
	public ArrayList<String> visitorcheckin(){
			
			ArrayList<String> list = new ArrayList<String>();
			
			list.add(visitorid);
			list.add(name);
			list.add(email);
			list.add(motif);
			list.add(date);
			list.add(vehicle);
			list.add(timein);
			list.add(timeout);
			
			return list;
	}
	
	//Method for checking out a visitor
	public List<List<String>> checkout(List<List<String>> alldata, String visitorname) {
         
		String data;
		String timeout;
		for(int row = 0; row < alldata.size(); row++) {
			for(int column = 0; column < alldata.get(row).size(); column++) {
				data = alldata.get(row).get(1);
				timeout = java.time.LocalTime.now().toString();
				if(data.contains(visitorname)) {
					alldata.get(row).set(7, timeout);
					break;
				}
			}	
		}
		return alldata;
	}
	
}
