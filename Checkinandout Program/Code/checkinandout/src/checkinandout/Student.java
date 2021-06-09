// Author: Julien and Lando

package checkinandout;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// Student class that handles the checkin and checkout of students
public class Student extends Person{
	
	public String studentid; 
	public String timeout;
	
	public Student() {};
	public Student(String studentid, String name, String email, String localDate, String vehicle, String timein, String timeout
			) {
		super(name, email, localDate, vehicle, timein);
		this.studentid = studentid; 
		this.timeout = timeout;
	}
	
	
	// Method for checking in a student
	public ArrayList<String> studentcheckin(){
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add(studentid);
		list.add(name);
		list.add(email);
		list.add(date);
		list.add(vehicle);
		list.add(timein);
		list.add(timeout);
		
		return list;
	}
	
	//Method for checking out a student
	public List<List<String>> checkout(List<List<String>> alldata, String studentname) {
		
		String data;
		String timeout;
		for(int row = 0; row < alldata.size(); row++) {
			for(int column = 0; column < alldata.get(row).size(); column++) {
				data = alldata.get(row).get(1);
				timeout = java.time.LocalTime.now().toString();
				if(data.contains(studentname)) {
					alldata.get(row).set(6, timeout);
					break;
				}
			}	
		}
		return alldata;
	}
	
}
