// Author: Julien and Lando 

package checkinandout;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.print.DocFlavor.URL;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.builder.ToStringBuilder;


public class Main2 {
	
	public static void main(String[] args) {
		
		// Initializing main variables
		
		LocalDate date = LocalDate.now();
		String newdate = date.toString();
		
		Boolean vehicle = true;
		String newvehicle = Boolean.toString(vehicle);
		
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String newtime = sdf.format(cal.getTime()).toString();
		
		Student student = new Student();
		Staff staff = new Staff();
		Visitors visitor = new Visitors();
		
		// Initializing people in all 3 categories
		
		Student student1 = new Student("100" ,"julien", "b.julien@alustudent.com", newdate, newvehicle, newtime, null);
		Student student2 = new Student("200", "lando", "g.landelin@alustudent.com", newdate, newvehicle, newtime, null);
		Staff staff1 = new Staff("300", "brian", "g.brian@alustudent.com", "facilitator", newdate, newvehicle, newtime, null);
		Staff staff2 = new Staff("400", "bruce", "u.bruce@alustudent.com", "facilitator", newdate, newvehicle, newtime, null);
		Visitors visitor1 = new Visitors("20", "nelson", "k.nelson@gmail.com", "culture event", newdate, newvehicle, newtime, null);
		Visitors visitor2 = new Visitors("30", "linda", "i.linda@gmail.com", "application", newdate, newvehicle, newtime, null);
		
		// Passing the records into checkin method in every class
		
		ArrayList<String> studentdata1 = student1.studentcheckin();
		ArrayList<String> studentdata2 = student2.studentcheckin();
		ArrayList<String> staffdata1 = staff1.staffcheckin();
		ArrayList<String> staffdata2 = staff2.staffcheckin();
		ArrayList<String> visitordata1 = visitor1.visitorcheckin();
		ArrayList<String> visitordata2 = visitor2.visitorcheckin();
		
		// Adding the records into an array list to be passed in takeinfo function
		
		List<List<String>> studentdata = new ArrayList<List<String>>();
		studentdata.add(studentdata1);
		studentdata.add(studentdata2);
		
		List<List<String>> staffdata = new ArrayList<List<String>>();
		staffdata.add(staffdata1);
		staffdata.add(staffdata2);
		
		List<List<String>> visitordata = new ArrayList<List<String>>();
		visitordata.add(visitordata1);
		visitordata.add(visitordata2);
		
		// Initializing the people database 
		List<List<String>> rows = new ArrayList<List<String>>();
		
		try (Scanner s = new Scanner(new BufferedReader(new FileReader("people_database.txt")))) {
	        while(s.hasNextLine()) {
	            rows.add(createRow(s.nextLine()));
	        }
	        
	        System.out.println(rows);
	        
	        for(int row = 0; row < rows.size(); row++) {
				for(int column = 0; column < rows.get(row).size(); column++) {
					System.out.println(rows.get(row).get(column));
				}
				
				System.out.print("\n");
	        }
	    }catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	      

		System.out.println("CHECK IN AND CHECK OUT PROGRAM");
		System.out.println("==============================");
		
		System.out.println("\nCurrent Status: ");
		System.out.println("\nPeople who are currently in school");
		System.out.println("----------------------------------\n");
		System.out.println("Students:\n");
//		student.displayStudents(studentdata);
		System.out.println("\nStaff:\n");
		staff.displayStaff(staffdata);
		System.out.println("\nVisitors:\n");
		visitor.displayVisitors(visitordata);
		System.out.println("--------------------------------\n");
			
		// calling takeinfo function
		
		takeinfo(studentdata, staffdata, visitordata,rows, student, staff, visitor);
			
	}
	
	// Function that read from the student database
	
	
	
	public static List<String> createRow(String line) {
		
		List<String> list = new ArrayList<String>();
		String[] words = line.split(" ");
	    List<String> chars = Arrays.asList(words);
	    return chars;
	}
	
	// Function for validating the userID and name entered
	
	public static boolean isValidIDandName(List<List<String>> datainfo, String name, String userid) {
		String namecol;
		String idcol;
		
		System.out.print(name + userid);
		
		for(int row = 0; row < datainfo.size(); row++) {
			for(int column = 0; column < datainfo.get(row).size(); column++) {
				idcol = datainfo.get(row).get(0);
				namecol = datainfo.get(row).get(1);
				if(idcol.contains(userid) && namecol.contains(name)) {
					System.out.print("test successfully");
					return true;
				}
			}
        }
		return false;
	}
	
	
	
	// Function for validating email address entered
	
	public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
	}
	
	// Defining the function that performs all the operations
	
	public static void takeinfo(List<List<String>> student_array, List<List<String>> staff_array, List<List<String>> visitor_array, 
			List<List<String>> peopledb, Student student, Staff staff, Visitors visitor) {
		
		LocalDate date = LocalDate.now();
		String newdate = date.toString();
		
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
     
        String newtime = sdf.format(cal.getTime()).toString();
        
		System.out.println("Choose What you want to do:");
		System.out.println("1. Checkin");
		System.out.println("2. Checkout");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Your choice: ");
		int choice = sc.nextInt();
		
		boolean c = true;
		
		// Starting a loop that will let the user to interact with the program until s/he doesn't want to
		while(c) {
			switch(choice) {
				case 1:
					//Starting the loop that will let user checkin more people as s/he want
					while(true) {
						System.out.println("\nWho do you want to checkin: ");
						System.out.println("1. Student");
						System.out.println("2. Staff");
						System.out.println("3. Visitors");
						
						System.out.print("Your choice: ");
						int choice2 = sc.nextInt();
						
						if (choice2 == 1) {
							System.out.println("\nChecking in Student ------\n");
							System.out.print("Student Id: ");
							int stid = sc.nextInt();
							String newstid = String.valueOf(stid);
							System.out.print("Name: ");
							String name = sc.next();
							
							
							if(!isValidIDandName(peopledb, name, newstid)) {
								while(true) {
									System.out.println("The student id or student name is invalid");
									System.out.println("Try again----");
									
									System.out.print("Student Id: ");
									int stid_again = sc.nextInt();
									String newstid_again = String.valueOf(stid_again);
									System.out.print("Name: ");
									String name_again = sc.next();
									
									if(isValidIDandName(peopledb, name_again, newstid_again)) {
										System.out.println("These ones are valid! Proceed--");
										name = name_again;
										newstid = newstid_again;
										break;
									}
								}
							}
							
							System.out.print("Email: ");
							String email = sc.next();
							
							if(!isValidEmailAddress(email)) {
								while(true) {
									System.out.println("That email is invalid");
									System.out.print("Try another email: ");
									String email_try = sc.next();
									
									if(isValidEmailAddress(email_try)) {
										System.out.println("This one is valid! Proceed--");
										email = email_try;
										break;
									}
								}
							}
							
							
							System.out.print("Vehicle(true or false): ");
							boolean vehicle = sc.nextBoolean();
							
							String newvehicle = Boolean.toString(vehicle);
							
							// Adding new student info inputed by the user and displaying it
							Student newstudent = new Student(newstid, name, email, newdate, newvehicle, newtime, null);
							ArrayList<String> studentdata = newstudent.studentcheckin();
							student_array.add(studentdata);
							System.out.println("\nUpdated List of students in the campus");
							System.out.println("-------------------------------------\n");
//							student.displayStudents(student_array);
						}
					
						else if(choice2 == 2) {
							System.out.println("\nChecking in Staff ------\n");
							System.out.print("Staff Id: ");
							int staffid = sc.nextInt();
							
							String newstaffid = String.valueOf(staffid);
							
							System.out.print("Name: ");
							String staffname = sc.next().toLowerCase();
							System.out.print("Email: ");
							String staffemail = sc.next();
							
							if(!isValidEmailAddress(staffemail)) {
								while(true) {
									System.out.println("That email is invalid");
									System.out.print("Try another email: ");
									String email_try = sc.next();
									
									if(isValidEmailAddress(email_try)) {
										System.out.println("This one is valid! Proceed--");
										staffemail = email_try;
										break;
									}
								}
							}
							
							System.out.print("Role: ");
							String staffrole = sc.next();
							System.out.print("Vehicle(true or false): ");
							boolean staffvehicle = sc.nextBoolean();
							
							String newstaffvehicle = Boolean.toString(staffvehicle);
							
							// Adding new staff info inputed by the user and displaying it
							Staff newstaff = new Staff(newstaffid, staffname, staffemail, staffrole, newdate, newstaffvehicle, newtime, null);
							ArrayList<String> staffdata = newstaff.staffcheckin();
							staff_array.add(staffdata);
							System.out.println("\nUpdated List of staff in the campus");
							System.out.println("-------------------------------------\n");
							staff.displayStaff(staff_array);
						}
						
						else {
							System.out.println("\nChecking in Visitor ------\n");
							System.out.print("Visitor Id: ");
							int visitorid = sc.nextInt();
							
							String newvisitorid = String.valueOf(visitorid);
							
							System.out.print("Name: ");
							String visitorname = sc.next().toLowerCase();
							System.out.print("Email: ");
							String visitoremail = sc.next();
							
							if(!isValidEmailAddress(visitoremail)) {
								while(true) {
									System.out.println("That email is invalid");
									System.out.print("Try another email: ");
									String email_try = sc.next();
									
									if(isValidEmailAddress(email_try)) {
										System.out.println("This one is valid! Proceed--");
										visitoremail = email_try;
										break;
									}
								}
							}
							
							System.out.print("Motif: ");
							String visitormotif = sc.next();
							System.out.print("Vehicle(true or false): ");
							boolean visitorvehicle = sc.nextBoolean();
							
							String newvisitorvehicle = Boolean.toString(visitorvehicle);
							
							// Adding new visitor info inputed by the user and displaying it
							Visitors newvisitor = new Visitors(newvisitorid, visitorname, visitoremail, visitormotif, newdate, newvisitorvehicle, newtime, null);
							ArrayList<String> visitordata = newvisitor.visitorcheckin();
							visitor_array.add(visitordata);
							System.out.println("\nUpdated List of visitors in the campus");
							System.out.println("-------------------------------------\n");
							visitor.displayVisitors(visitor_array);
						}
						
						// Letting the user checkin again
						System.out.print("Do you want to checkin again(yes or no): ");
						String resp = sc.next().toLowerCase();
						if(resp.contains("no")) {
							break;
						}
					}
					
					// Letting the user perform other operations after checking in new person
					
					System.out.println("\nChoose What you want to do next\n");
					System.out.println("1. Check out someone");
					System.out.println("2. View a list of all people currently in campus");
					System.out.print("Your answer: ");
					String resp = sc.next();
					if (resp.contains("2")) {
						System.out.println("\nPeople who are currently in school");
						System.out.println("----------------------------------\n");
						System.out.println("Students:\n");
//						student.displayStudents(student_array);
						System.out.println("\nStaff:\n");
						staff.displayStaff(staff_array);
						System.out.println("\nVisitors:\n");
						visitor.displayVisitors(visitor_array);
						System.out.println("--------------------------------\n");
						System.out.print("Thank you for using our program!!!!!");
						c = false;
						break;
					}
				case 2: 
					
					//Starting the loop that will let user checkout more people as s/he want
					boolean out = true;
					while(out) {
						System.out.println("\nWho do you want to checkout: ");
						System.out.println("1. Student");
						System.out.println("2. Staff");
						System.out.println("3. Visitors");
						
						System.out.print("Your choice: ");
						int choice3 = sc.nextInt();
						
						if (choice3 == 1) {
							System.out.print("\nStudent Name: ");
							String studentname = sc.next().toLowerCase();
							
							// Removing student name info inputed by the user and displaying rest of students
							List<List<String>> updated_list = student.checkout(student_array, studentname);
							System.out.println("Updated List of students after checkout");
							System.out.println("-------------------------------------\n");
//							student.displayStudents(updated_list);
						}
						
						else if (choice3 == 2) {
							System.out.print("\nStaff Name: ");
							String staffname = sc.next().toLowerCase();
							
							// Removing staff name info inputed by the user and displaying rest of staff
							List<List<String>> updated_list = staff.checkout(staff_array, staffname);
							System.out.println("Updated List of staff after checkout");
							System.out.println("-------------------------------------\n");
//							student.displayStudents(updated_list);
						}
						
						else {
							System.out.print("\nVisitor Name: ");
							String visitorname = sc.next().toLowerCase();
							
							// Removing visitor name info inputed by the user and displaying rest of visitors
							List<List<String>> updated_list = student.checkout(visitor_array, visitorname);
							System.out.println("Updated List of visitors after checkout");
							System.out.println("-------------------------------------\n");
//							student.displayStudents(updated_list);
						}
						
						//Letting the user checkout again
						System.out.print("Do you want to checkout again(yes or no): ");
						String respc = sc.next().toLowerCase();
						if(respc.contains("no")) {
							break;
						}
					}
					
					// Letting the user perform other operations after checking out a person
					
					System.out.println("\nChoose What you want to do next\n");
					System.out.println("1. Check in someone");
					System.out.println("2. View a list of all people currently in campus");
					System.out.print("Your answer: ");
					String respc = sc.next();
					if (respc.contains("2")) {
						System.out.println("\nPeople who are currently in school");
						System.out.println("----------------------------------\n");
						System.out.println("Students:\n");
//						student.displayStudents(student_array);
						System.out.println("\nStaff:\n");
						staff.displayStaff(staff_array);
						System.out.println("\nVisitors:\n");
						visitor.displayVisitors(visitor_array);
						System.out.println("--------------------------------\n");
						System.out.print("Thank you for using our program!!!!!");
						c = false;
					}
					
					else {
						out = false;
					}	
			}
			choice = 1;
		}
	}
}
