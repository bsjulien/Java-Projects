// Author: Julien and Lando

package checkinandout;

import java.util.ArrayList;
import java.util.List;

//Staff class that handles the checkin and checkout of staff
public class Staff extends Person{
	
	public String staffid;
	public String role;
	public String timeout;
	
	public Staff() {};
	public Staff(String staffid, String name, String email, String role, String localDate, String vehicle, String timein, String timeout
			) {
		super(name, email, localDate, vehicle, timein);
		this.staffid = staffid;
		this.role = role;
		this.timeout = timeout;
	}
	
	//Method for checking in staff
	public ArrayList<String> staffcheckin(){
			
			ArrayList<String> list = new ArrayList<String>();
			
			list.add(staffid);
			list.add(name);
			list.add(email);
			list.add(role);
			list.add(date);
			list.add(vehicle);
			list.add(timein);
			list.add(timeout);
			
			return list;
	}
	
	//Method for checking out a staff
	public List<List<String>> checkout(List<List<String>> alldata, String staffname) {
         
		String data;
		String timeout;
		for(int row = 0; row < alldata.size(); row++) {
			for(int column = 0; column < alldata.get(row).size(); column++) {
				data = alldata.get(row).get(1);
				timeout = java.time.LocalTime.now().toString();
				if(data.contains(staffname)) {
					alldata.get(row).set(7, timeout);
					break;
				}
			}	
		}
		return alldata;
	}
	
	//Method for displaying a staff
	public void displayStaff(List<List<String>> alldata) {
		 
		for(int row = 0; row < alldata.size(); row++) {
			for(int column = 0; column < alldata.get(row).size(); column++) {		
				staffid = alldata.get(row).get(0);
				name = alldata.get(row).get(1);
				email = alldata.get(row).get(2);
				role = alldata.get(row).get(3);
				date = alldata.get(row).get(4);
				vehicle = alldata.get(row).get(5);
				timein = alldata.get(row).get(6);
			
				System.out.println(String.format( "StaffId: %s\nName: %s\nEmail: %s\nRole: %s\nDate: %s\nVehicle: %s\nTimein %s"
			    		  , staffid, capitalize(name), email, role,  date, vehicle, timein));
				break;
			}
			System.out.println();
		}
		 
	}
}
