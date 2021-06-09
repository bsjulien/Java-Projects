// Author: Julien and Lando

package checkinandout;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;

public class Checkinandout_info extends JFrame {

	
	private JPanel contentPane;
	private JTextField stid;
	private JTextField name;
	private JTextField email;
	private JTable table;
	private JTable table2;
	private JTable table3;
	private JFrame frame;
	DefaultTableModel model;
	DefaultTableModel model2;
	DefaultTableModel model3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Checkinandout_info frame = new Checkinandout_info();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Function to take string out of a student text file(database)
	
	public static List<String> createRow(String line) {
	
		String[] words = line.split(" ");
	    List<String> chars = Arrays.asList(words);
	    return chars;
	}
	
	// Function to take string out of a staff text file(database)
	
	public static List<String> createstaffRow(String line) {

		String[] words = line.split(" ");
	    List<String> chars = Arrays.asList(words);
	    return chars;
	}
	
	// Function that check if UserId, Name and Email exist in database
	
	public boolean isValidIDandName(List<List<String>> datainfo, String name, String userid, String email) {
		String namecol;
		String idcol;
		String emailcol;
		
		for(int row = 0; row < datainfo.size(); row++) {
			for(int column = 0; column < datainfo.get(row).size(); column++) {
				idcol = datainfo.get(row).get(0);
				namecol = datainfo.get(row).get(1);
				emailcol = datainfo.get(row).get(2);
				if(idcol.contains(userid) && namecol.contains(name) && emailcol.contains(email)) {
					return true;
				}
			}
        }
		return false;
	}
	
	// Function that check if staffID, name and Email exist in database
	
	public static boolean isValidStaffIDandName(List<List<String>> datainfo, String name, String userid, String email) {
		String namecol;
		String idcol;
		String emailcol;
		
		for(int row = 0; row < datainfo.size(); row++) {
			for(int column = 0; column < datainfo.get(row).size(); column++) {
				idcol = datainfo.get(row).get(0);
				namecol = datainfo.get(row).get(1);
				emailcol = datainfo.get(row).get(2);
				if(idcol.contains(userid) && namecol.contains(name) && emailcol.contains(email)) {
					return true;
				}
			}
        }
		return false;
	}
	
	// Function that validate email
	
	public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
	}

	/**
	 * Create the frame.
	 */
	
	
	
	List<List<String>> alldata;
	private JTextField staffid;
	private JTextField staffname;
	private JTextField staffemail;
	private JTextField staffrole;
	private JTextField vid;
	private JTextField vname;
	private JTextField vmotif;
	private JTextField vemail;
	public Checkinandout_info() {
		
		
		
//		frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		frame.setVisible(true);
		
		List<List<String>> newdata;
		
		
		// Reading from student database
		
		List<List<String>> rows = new ArrayList<List<String>>();
		
		try (Scanner s = new Scanner(new BufferedReader(new FileReader("students_database.txt")))) {
	        while(s.hasNextLine()) {
	            rows.add(createRow(s.nextLine()));
	        }
	    
	    }catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
		
		// Reading from staff database
		
		List<List<String>> staffrows = new ArrayList<List<String>>();
		
		try (Scanner s = new Scanner(new BufferedReader(new FileReader("staff_database.txt")))) {
	        while(s.hasNextLine()) {
	            staffrows.add(createstaffRow(s.nextLine()));
	        }
	        
	    }catch (FileNotFoundException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
		
		// starting the program
		
		LocalDate date = LocalDate.now();
		String newdate = date.toString();
		
		Boolean vehicle1 = true;
		String newvehicle = Boolean.toString(vehicle1);
		
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String newtime = sdf.format(cal.getTime()).toString();
		
        LocalTime timenow = java.time.LocalTime.now();
        
		Student student = new Student();
		Staff staff = new Staff();
		Visitors visitor = new Visitors();
		
		// Initializing information in student, staff, visitor class using their constructors
		
		Student student1 = new Student("1022" ,"julien", "julien@alustudent.com", newdate, newvehicle, java.time.LocalTime.now().toString(), "Not yet");
		Student student2 = new Student("1023", "lando", "lando@alustudent.com", newdate, newvehicle, java.time.LocalTime.now().toString(), "Not yet");
		Staff staff1 = new Staff("1401", "ella", "ella@aluseducation.com", "facilitator", newdate, newvehicle, java.time.LocalTime.now().toString(), "Not yet");
		Staff staff2 = new Staff("1402", "bobson", "bobson@alueducation.com", "facilitator", newdate, newvehicle, java.time.LocalTime.now().toString(), "Not yet");
		Visitors visitor1 = new Visitors("1", "nelson", "k.nelson@gmail.com", "culture event", newdate, newvehicle, java.time.LocalTime.now().toString(), "Not yet");
		Visitors visitor2 = new Visitors("2", "linda", "i.linda@gmail.com", "application", newdate, newvehicle, java.time.LocalTime.now().toString(), "Not yet");
		
		// Checking in the initialized information 
		
		ArrayList<String> studentdata1 = student1.studentcheckin();
		ArrayList<String> studentdata2 = student2.studentcheckin();
		ArrayList<String> staffdata1 = staff1.staffcheckin();
		ArrayList<String> staffdata2 = staff2.staffcheckin();
		ArrayList<String> visitordata1 = visitor1.visitorcheckin();
		ArrayList<String> visitordata2 = visitor2.visitorcheckin();
		
		// Declaring an array list that will hold every information about a student, staff or visitor recorded
		
		List<List<String>> studentdata = new ArrayList<List<String>>();
		List<List<String>> staffdata = new ArrayList<List<String>>();
		List<List<String>> visitordata = new ArrayList<List<String>>();
		
		DisplayAll display_all = new DisplayAll(studentdata, staffdata, visitordata);
		
		studentdata.add(studentdata1);
		studentdata.add(studentdata2);
		
//		display_all.sdata = studentdata;
		
		staffdata.add(staffdata1);
		staffdata.add(staffdata2);
		
		visitordata.add(visitordata1);
		visitordata.add(visitordata2);
		
		
//		
//		display_all.sdata = null;
		
		// Dealing with the interface
		
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 920);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHECKING IN AND OUT A STUDENT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(23, 10, 327, 34);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblNewLabel_1 = new JLabel("StudentId: ");
		lblNewLabel_1.setBounds(23, 101, 62, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name: ");
		lblNewLabel_1_1.setBounds(23, 137, 62, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email: ");
		lblNewLabel_1_1_1.setBounds(254, 101, 54, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Vehicle: ");
		lblNewLabel_1_1_1_1.setBounds(254, 137, 62, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		stid = new JTextField();
		stid.setBounds(95, 98, 114, 20);
		contentPane.add(stid);
		stid.setColumns(10);
		
		name = new JTextField();
		name.setBounds(95, 133, 114, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(304, 98, 114, 20);
		contentPane.add(email);
		
		JRadioButton vtrue = new JRadioButton("True");
		
		vtrue.setBounds(304, 132, 62, 23);
		contentPane.add(vtrue);
		
		JRadioButton vfalse = new JRadioButton("False");
		
		// Conditioning the radio buttons
		
		vtrue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vtrue.isSelected()) {
					vfalse.setSelected(false);
				}
			}
		});
		
		vfalse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vfalse.isSelected()) {
					vtrue.setSelected(false);
				}
			}
		});
		vfalse.setBounds(368, 131, 62, 23);
		contentPane.add(vfalse);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 42, 284, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Fill the information below");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(23, 57, 183, 27);
		contentPane.add(lblNewLabel_2);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(435, 98, 437, 131);
		contentPane.add(scrollPane);
		
		// Creating the student table and adding content to it
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"StudentID", "Name", "Email", "Date", "Vehicle", "Timein"};
		final Object[] row = new Object[6];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		// Displaying students that are currently in the school
		
		for(int i = 0; i < studentdata.size(); i++) {
			for(int j = 0; j < studentdata.get(i).size(); j++) {
				row[0] = studentdata.get(i).get(0);
				row[1] = studentdata.get(i).get(1);
				row[2] = studentdata.get(i).get(2);
				row[3] = studentdata.get(i).get(3);
				row[4] = studentdata.get(i).get(4);
				row[5] = studentdata.get(i).get(5);
				model.addRow(row);
				break;
			}
		}
		
		
		JButton btnNewButton = new JButton("CheckIn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				// Validating the user data and adding them to student table
				
				if (stid.getText().equals("") || name.getText().equals("") || email.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill the complete information");
				}
				
				else if(!isValidEmailAddress(email.getText())) {
					JOptionPane.showMessageDialog(null, "Please enter a valid email");
					email.setText("");
				}
				
				else if(!isValidIDandName(rows, name.getText().toLowerCase(), stid.getText(), email.getText().toLowerCase())) {
					JOptionPane.showMessageDialog(null, "Userid or name or email doesnot exist in our database");
					stid.setText("");
					name.setText("");
					email.setText("");
				}
							
				else {
					try{
					    int number = Integer.parseInt(stid.getText());
					    String vselection;
					    
					    if(vtrue.isSelected()) {
					    	vselection = "true";
					    }
					    
					    else {
					    	vselection = "false";
					    }
					    // Adding the userdata to student table
					    row[0] = stid.getText();
						row[1] = name.getText().toLowerCase();
						row[2] = email.getText().toLowerCase();
						row[3] = newdate;
						row[4] = vselection;
						row[5] = java.time.LocalTime.now();
						
						model.addRow(row);
						
						// Adding to student list
						Student newstudent = new Student(stid.getText(), name.getText().toLowerCase(), email.getText().toLowerCase(), 
								newdate, vselection, java.time.LocalTime.now().toString(), "Not yet");
						ArrayList<String> newdata = newstudent.studentcheckin();
						studentdata.add(newdata);
						
						stid.setText("");
						name.setText("");
						email.setText("");
						
						JOptionPane.showMessageDialog(null, "Saved Successfully");
						
					}catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Student ID must be a number");
						stid.setText("");
					}
					
				}
			}
		});
		btnNewButton.setBounds(23, 191, 186, 39);
		contentPane.add(btnNewButton);
		
		// Checkout button
		
		JButton btnNewButton_1 = new JButton("CheckOut");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int column = 1;
				int row = table.getSelectedRow();
				
				if(!table.isRowSelected(row)) {
					JOptionPane.showMessageDialog(null, "Please select a row you want to checkout");
				}
				
				else {
					String value = table.getModel().getValueAt(row, column).toString();
					model.removeRow(row);
					student.checkout(studentdata, value);
					JOptionPane.showMessageDialog(null, "Checked out successfully");
				}
			}
		});
		btnNewButton_1.setBounds(239, 191, 186, 39);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Select a row and click checkout");
		lblNewLabel_3.setBounds(239, 170, 184, 14);
		contentPane.add(lblNewLabel_3);
		
		
		// Check in or out a staff
		
		
		JLabel lblCheckingInAnd = new JLabel("CHECKING IN AND OUT A STAFF");
		lblCheckingInAnd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCheckingInAnd.setBounds(21, 267, 327, 23);
		contentPane.add(lblCheckingInAnd);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(25, 294, 284, 2);
		contentPane.add(separator_2);
		
		JLabel lblNewLabel_4 = new JLabel("StaffId: ");
		lblNewLabel_4.setBounds(23, 352, 62, 14);
		contentPane.add(lblNewLabel_4);
		
		staffid = new JTextField();
		staffid.setBounds(91, 348, 114, 20);
		contentPane.add(staffid);
		staffid.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Name:");
		lblNewLabel_4_1.setBounds(23, 385, 62, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Email: ");
		lblNewLabel_4_1_1.setBounds(254, 349, 62, 14);
		contentPane.add(lblNewLabel_4_1_1);
		
		staffname = new JTextField();
		staffname.setColumns(10);
		staffname.setBounds(92, 381, 114, 20);
		contentPane.add(staffname);
		
		staffemail = new JTextField();
		staffemail.setColumns(10);
		staffemail.setBounds(304, 344, 114, 20);
		contentPane.add(staffemail);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Role: ");
		lblNewLabel_4_1_1_1.setBounds(23, 418, 62, 14);
		contentPane.add(lblNewLabel_4_1_1_1);
		
		staffrole = new JTextField();
		staffrole.setColumns(10);
		staffrole.setBounds(93, 415, 114, 20);
		contentPane.add(staffrole);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Vehicle: ");
		lblNewLabel_4_1_1_1_1.setBounds(254, 382, 62, 14);
		contentPane.add(lblNewLabel_4_1_1_1_1);
		
		JRadioButton vtrue1 = new JRadioButton("True");
		
		vtrue1.setBounds(302, 378, 62, 23);
		contentPane.add(vtrue1);
		
		JRadioButton vfalse1 = new JRadioButton("False");
		
		// Conditioning for radio buttons
		
		vtrue1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vtrue1.isSelected()) {
					vfalse1.setSelected(false);
				}
			}
		});
		vfalse1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vfalse1.isSelected()) {
					vtrue1.setSelected(false);
				}
			}
		});
		vfalse1.setBounds(368, 377, 63, 23);
		contentPane.add(vfalse1);
		
		
		JLabel lblNewLabel_3_1 = new JLabel("Select a row and click checkout");
		lblNewLabel_3_1.setBounds(23, 451, 184, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Staff currently in school");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(443, 307, 183, 27);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Click the button to checkin");
		lblNewLabel_3_2.setBounds(24, 171, 184, 14);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Students currently in school");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(434, 58, 183, 27);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Fill the information below");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_3.setBounds(23, 309, 183, 27);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Click the button to checkin: ");
		lblNewLabel_3_1_1.setBounds(254, 420, 184, 14);
		contentPane.add(lblNewLabel_3_1_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(444, 344, 428, 164);
		contentPane.add(scrollPane_1);
		
		// Creating staff database and add content to it
		
		table2 = new JTable();
		model2 = new DefaultTableModel();
		Object[] staffcolumn = {"StaffID", "Name", "Email", "Role", "Date", "Vehicle", "Timein"};
		final Object[] staffrow = new Object[7];
		model2.setColumnIdentifiers(staffcolumn);
		table2.setModel(model2);
		scrollPane_1.setViewportView(table2);
		
		// Displaying staff that are currently in the school
		
		for(int i = 0; i < staffdata.size(); i++) {
			for(int j = 0; j < staffdata.get(i).size(); j++) {
				staffrow[0] = staffdata.get(i).get(0);
				staffrow[1] = staffdata.get(i).get(1);
				staffrow[2] = staffdata.get(i).get(2);
				staffrow[3] = staffdata.get(i).get(3);
				staffrow[4] = staffdata.get(i).get(4);
				staffrow[5] = staffdata.get(i).get(5);
				staffrow[6] = staffdata.get(i).get(6);
				model2.addRow(staffrow);
				break;
			}
		}
		
		JButton btnNewButton_2 = new JButton("CheckIn");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Validating the user input data and adding them to the staff table
				
				if (staffid.getText().equals("") || staffname.getText().equals("") || staffemail.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill the complete information");
				}
//				
				else if(!isValidEmailAddress(staffemail.getText())) {
					JOptionPane.showMessageDialog(null, "Please enter a valid email");
					staffemail.setText("");
				}
				
				else if(!isValidStaffIDandName(staffrows, staffname.getText().toLowerCase(), staffid.getText(), staffemail.getText().toLowerCase())) {
					JOptionPane.showMessageDialog(null, "Staffid or name or email doesnot exist in our database");
					staffid.setText("");
					staffname.setText("");
					staffemail.setText("");
				}
							
				else {
					try{
					    int number = Integer.parseInt(staffid.getText());
					    String vselection1;
					    
					    if(vtrue1.isSelected()) {
					    	vselection1 = "true";
					    }
					    
					    else {
					    	vselection1 = "false";
					    }
					    
					    // Adding the data to the staff table 
					    
					    staffrow[0] = staffid.getText();
						staffrow[1] = staffname.getText().toLowerCase();
						staffrow[2] = staffemail.getText().toLowerCase();
						staffrow[3] = staffrole.getText().toLowerCase();
						staffrow[4] = newdate;
						staffrow[5] = vselection1;
						staffrow[6] = java.time.LocalTime.now();
						
						model2.addRow(staffrow);
						
						// Adding to staff list
						Staff newstaff = new Staff(staffid.getText(), staffname.getText().toLowerCase(), staffemail.getText().toLowerCase(), staffrole.getText().toLowerCase(),
								newdate, vselection1, java.time.LocalTime.now().toString(), "Not yet");
						ArrayList<String> newstaffdata = newstaff.staffcheckin();
						staffdata.add(newstaffdata);
						
						staffid.setText("");
						staffname.setText("");
						staffemail.setText("");
						staffrole.setText("");
						JOptionPane.showMessageDialog(null, "Saved Successfully");
						
					}catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Staff ID must be a number");
						staffid.setText("");
					}
					
				}
			}
		});
		btnNewButton_2.setBounds(254, 440, 164, 68);
		contentPane.add(btnNewButton_2);
		
		// staff checkout button
		
		JButton btnNewButton_1_1 = new JButton("CheckOut");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int outcolumn = 1;
				int outrow = table2.getSelectedRow();
				
				if(!table2.isRowSelected(outrow)) {
					JOptionPane.showMessageDialog(null, "Please select a row you want to checkout");
				}
				
				else {
					String value = table2.getModel().getValueAt(outrow, outcolumn).toString();
					model2.removeRow(outrow);
					staff.checkout(staffdata, value);
					JOptionPane.showMessageDialog(null, "Checked out successfully");
				}
			}
		});
		btnNewButton_1_1.setBounds(23, 470, 186, 39);
		contentPane.add(btnNewButton_1_1);
		
		
		// Check in or out a visitor
		
		JLabel lblCheckingInAnd_2 = new JLabel("CHECKING IN AND OUT A VISITOR");
		lblCheckingInAnd_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCheckingInAnd_2.setBounds(23, 544, 327, 34);
		contentPane.add(lblCheckingInAnd_2);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Fill the information below");
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_3_1.setBounds(23, 599, 183, 27);
		contentPane.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("VisitorId:");
		lblNewLabel_4_2.setBounds(23, 644, 62, 14);
		contentPane.add(lblNewLabel_4_2);
		
		vid = new JTextField();
		vid.setColumns(10);
		vid.setBounds(95, 640, 114, 20);
		contentPane.add(vid);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Name:");
		lblNewLabel_4_1_2.setBounds(23, 679, 62, 14);
		contentPane.add(lblNewLabel_4_1_2);
		
		vname = new JTextField();
		vname.setColumns(10);
		vname.setBounds(95, 677, 114, 20);
		contentPane.add(vname);
		
		JLabel lblNewLabel_4_1_2_1 = new JLabel("Motif: ");
		lblNewLabel_4_1_2_1.setBounds(23, 718, 62, 14);
		contentPane.add(lblNewLabel_4_1_2_1);
		
		vmotif = new JTextField();
		vmotif.setColumns(10);
		vmotif.setBounds(95, 715, 114, 20);
		contentPane.add(vmotif);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("Email: ");
		lblNewLabel_4_1_1_2.setBounds(254, 640, 62, 14);
		contentPane.add(lblNewLabel_4_1_1_2);
		
		vemail = new JTextField();
		vemail.setColumns(10);
		vemail.setBounds(304, 637, 114, 20);
		contentPane.add(vemail);
		
		JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("Vehicle: ");
		lblNewLabel_4_1_1_1_1_1.setBounds(254, 678, 62, 14);
		contentPane.add(lblNewLabel_4_1_1_1_1_1);
		
		JRadioButton vtrue2 = new JRadioButton("True");
		
		vtrue2.setBounds(302, 673, 62, 23);
		contentPane.add(vtrue2);
		
		JRadioButton vfalse2 = new JRadioButton("False");
		
		// Conditioning for the radio buttons
		
		vtrue2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vtrue2.isSelected()) {
					vfalse2.setSelected(false);
				}
			}
		});
		
		vfalse2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vfalse2.isSelected()) {
					vtrue2.setSelected(false);
				}
			}
		});
		vfalse2.setBounds(368, 672, 63, 23);
		contentPane.add(vfalse2);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Select a row and click checkout");
		lblNewLabel_3_1_2.setBounds(22, 753, 184, 14);
		contentPane.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Click the button to checkin: ");
		lblNewLabel_3_1_1_1.setBounds(254, 720, 184, 14);
		contentPane.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Visitors currently in school");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(443, 599, 183, 27);
		contentPane.add(lblNewLabel_2_1_1);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(23, 578, 284, 2);
		contentPane.add(separator_2_1);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(444, 636, 428, 174);
		contentPane.add(scrollPane_1_1);
		
		// Creating visitors table and adding content to it
		
		table3 = new JTable();
		model3 = new DefaultTableModel();
		Object[] visitorcolumn = {"VisitorID", "Name", "Email", "Motif", "Date", "Vehicle", "Timein"};
		final Object[] visitorrow = new Object[7];
		model3.setColumnIdentifiers(visitorcolumn);
		table3.setModel(model3);
		scrollPane_1_1.setViewportView(table3);
		
		// Displaying visitors that are currently in the school
		
		for(int i = 0; i < visitordata.size(); i++) {
			for(int j = 0; j < visitordata.get(i).size(); j++) {
				visitorrow[0] = visitordata.get(i).get(0);
				visitorrow[1] = visitordata.get(i).get(1);
				visitorrow[2] = visitordata.get(i).get(2);
				visitorrow[3] = visitordata.get(i).get(3);
				visitorrow[4] = visitordata.get(i).get(4);
				visitorrow[5] = visitordata.get(i).get(5);
				visitorrow[6] = visitordata.get(i).get(6);
				model3.addRow(visitorrow);
				break;
			}
		}
		
		JButton btnNewButton_2_2 = new JButton("CheckIn");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Validating the user input data and adding them to the visitor table
				
				if (vid.getText().equals("") || vname.getText().equals("") || vemail.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill the complete information");
				}
//				
				else if(!isValidEmailAddress(vemail.getText())) {
					JOptionPane.showMessageDialog(null, "Please enter a valid email");
					vemail.setText("");
				}
							
				else {
					try{
					    int number = Integer.parseInt(vid.getText());
					    String vselection2;
					    
					    if(vtrue2.isSelected()) {
					    	vselection2 = "true";
					    }
					    
					    else {
					    	vselection2 = "false";
					    }
					    
					    // Adding to the visitors database
					    
					    visitorrow[0] = vid.getText();
						visitorrow[1] = vname.getText().toLowerCase();
						visitorrow[2] = vemail.getText().toLowerCase();
						visitorrow[3] = vmotif.getText().toLowerCase();
						visitorrow[4] = newdate;
						visitorrow[5] = vselection2;
						visitorrow[6] = java.time.LocalTime.now();
						
						model3.addRow(visitorrow);
						
						// Adding to visitor list
						Visitors newvisitor = new Visitors(vid.getText(), vname.getText().toLowerCase(), vemail.getText().toLowerCase(), vmotif.getText().toLowerCase(),
								newdate, vselection2, java.time.LocalTime.now().toString(), "Not yet");
						ArrayList<String> newvisitordata = newvisitor.visitorcheckin();
						visitordata.add(newvisitordata);
						
						vid.setText("");
						vname.setText("");
						vemail.setText("");
						vmotif.setText("");
						JOptionPane.showMessageDialog(null, "Saved Successfully");
						
					}catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Visitor ID must be a number");
						vid.setText("");
					}
					
				}
			}
		});
		btnNewButton_2_2.setBounds(254, 743, 164, 68);
		contentPane.add(btnNewButton_2_2);
		
		// Visitor checkout button
		
		JButton btnNewButton_1_1_1 = new JButton("CheckOut");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int outcolumn2 = 1;
				int outrow2 = table3.getSelectedRow();
				
				if(!table3.isRowSelected(outrow2)) {
					JOptionPane.showMessageDialog(null, "Please select a row you want to checkout");
				}
				
				else {
					String value = table3.getModel().getValueAt(outrow2, outcolumn2).toString();
					model3.removeRow(outrow2);
					visitor.checkout(visitordata, value);
					JOptionPane.showMessageDialog(null, "Checked out successfully");
				}
			}
		});
		btnNewButton_1_1_1.setBounds(22, 772, 186, 39);
		contentPane.add(btnNewButton_1_1_1);
		
		// Calling the display file
		
		JButton btnNewButton_2_1 = new JButton("View Report");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DisplayAll display_all = new DisplayAll(studentdata, staffdata, visitordata);
				display_all.setVisible(true);
			}
		});
		btnNewButton_2_1.setBounds(717, 16, 155, 31);
		contentPane.add(btnNewButton_2_1);
		
	}
}
