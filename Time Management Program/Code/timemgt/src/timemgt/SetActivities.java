// Authors: Serge Sugira and Elnam Umutoni

package timemgt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.sound.sampled.*;
import java.net.*;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.awt.*;


public class SetActivities extends JFrame {

	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panelin1;
	private JPanel panelin2;
	private JPanel panelin3;
	private JPanel panelin1_1;
	private JPanel panelin1_2;
	private JPanel panel2_1;
	private JPanel panel2_2;
	private JPanel panel2_3;
	private JPanel panel2_4;
	private JLayeredPane layeredPane;
	private JLayeredPane layeredPane_1;
	private JLayeredPane layeredPane_2;
	private JLayeredPane layeredPane_3;
	private JPanel contentPane;
	private JTextField HomeTitle;
	private JTextField HomeDate;
	private JTextField HomefromTime;
	private JTextField HometoTime;
	private JTextField assigncourse;
	private JTextField assigndate;
	private JTextField assignfromtime;
	private JTextField assigntotime;
	private JTextField classcourse;
	private JTextField classdate;
	private JTextField classtotime;
	private JTextField classfromtime;
	private JTextField school_other_title;
	private JTextField school_otherfrom_time;
	private JTextField school_other_date;
	private JTextField school_otherto_time;
	private JTextField meetingheader;
	private JTextField meetingdate;
	private JTextField meetingfromtime;
	private JTextField meetingtotime;
	private JTextField work_other_title;
	private JTextField work_otherfrom_time;
	private JTextField work_other_date;
	private JTextField work_otherto_time;
	private JLabel clockvalue;
	private JLabel datevalue;
	private JTable table1;
	private JTable table2;
	private JTable table3;
	private JTable table4;
	DefaultTableModel model1;
	DefaultTableModel model2;
	DefaultTableModel model3;
	DefaultTableModel model4;
	final Object[] homerow;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetActivities frame = new SetActivities();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Function for switching main panel
	
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	// Function for switching the school panel
	
	public void switchSchoolPanels(JPanel panel) {
		layeredPane_1.removeAll();
		layeredPane_1.add(panel);
		layeredPane_1.repaint();
		layeredPane_1.revalidate();
	}
	
	// Function for switching the work panel
	
	public void switchWorkPanels(JPanel panel) {
		layeredPane_2.removeAll();
		layeredPane_2.add(panel);
		layeredPane_2.repaint();
		layeredPane_2.revalidate();
	}
	
	// Function for switching the created activities panel
	
	public void switchActivitiesPanels(JPanel panel) {
		layeredPane_3.removeAll();
		layeredPane_3.add(panel);
		layeredPane_3.repaint();
		layeredPane_3.revalidate();
	}
	
	
	// Function to validate date
	
	public static boolean validateJavaDate(String strDate){
		
		// Check if date is not null
		if (strDate.trim().equals("")){
		    return true;
		}
		// Date is not null
		else{
		   
			// Set preferred date format
			
		    SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
		    sdfrmt.setLenient(false);
		    
		    // Create Date object and parse the string into date
		    
		    try{
		        Date javaDate = sdfrmt.parse(strDate); 
		    }
		    
		    // Date format is invalid
		    
		    catch (ParseException e){
		        return false;
		    }
		    
		    //Return true if date format is valid 
		    return true;
		}
	}
	
	// Function to validate time 
	
	public static boolean validateJavaTime(String time) {
		if (time.trim().equals("")){
		    return true;
		}
		// Date is not null
		else{
			
		    // Set preferred date format
			
			SimpleDateFormat sdfrmt = new SimpleDateFormat("HH:mm:ss");
		    sdfrmt.setLenient(false);
		    
		    // Create date object and parse the string to it
		    
		    try{
		        Date javatime1 = sdfrmt.parse(time);
		    }
		    // Date format is invalid 
		    catch (ParseException e){
		        return false;
		    }
		    // Return true if date format is valid
		    return true;
		}
	}
	
	// Function to compare the current date
	
	public static boolean compareDate(String userdate, String currentdate) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date date1 = sdf.parse(userdate);
			Date date2 = sdf.parse(currentdate);
			
			if(date1.before(date2)) {
				return false;
			}
			
		} catch (ParseException e1) {
			return false;
		}
		
		return true;
	}
	
	public static boolean comparefromTime(String usertime, String currenttime, String userdate) {
		
		Date d = new Date();
		SimpleDateFormat cdate = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		try {
			Date time1 = sdf.parse(usertime);
			Date time2 = sdf.parse(currenttime);
		
			
			long elapsed = time1.getTime() - time2.getTime();
			
			if(elapsed < 0 && userdate.equals(cdate.format(d))) {
				return false;
			}
			
		} catch (ParseException e1) {
			return false;
		}
		
		return true;
	}
	
	// Function to compare time
	
	public static boolean comparetoTime(String fromtime, String totime) {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		try {
			Date time1 = sdf.parse(fromtime);
			Date time2 = sdf.parse(totime);
			
			long elapsed = time2.getTime() - time1.getTime();
			
			if(elapsed <= 0) {
				return false;
			}
			
		} catch (ParseException e1) {
			return false;
		}
		
		return true;
	}
	
	
	// Validating functions
	int check = 0;
	
	public boolean validateuserinfo(String title, String date, String fromtime, String totime) {
		
		if (title.equals("") || date.equals("") || fromtime.equals("") || totime.equals("")) {
			JOptionPane.showMessageDialog(null, "Please fill the complete information");
			return false;
		}
		
		else if(!validateJavaDate(date)) {
			JOptionPane.showMessageDialog(null, "Please enter a valid date(use this format: dd/MM/yyyy)");
			return false;
		}
		
		else if(!validateJavaTime(fromtime)) {
			JOptionPane.showMessageDialog(null, "Please enter a valid from time(use this format: HH:mm:ss)");
			return false;
		}
		
		else if(!validateJavaTime(totime)) {
			JOptionPane.showMessageDialog(null, "Please enter a valid to time(use this format: HH/mm/ss)");
			return false;
		}
		
		else if(!compareDate(date, datevalue.getText())) {
			JOptionPane.showMessageDialog(null, "Your Date is in the past. Try putting another one!");
			return false;
		}
		
		else if(!comparefromTime(fromtime, clockvalue.getText(), date)) {
			JOptionPane.showMessageDialog(null, "The Time you inputed has already passed. Try another one!");
			return false;
		}
		
		else if(!comparetoTime(fromtime, totime)) {
			JOptionPane.showMessageDialog(null, "Your (totime) should be greater than the (fromtime)!");
			return false;
		}
		
		else {
			return true;
		}
		
		
	}
	
	// Function to set the time 
	
	public void currentTime(List<List<String>> homedata, List<List<String>> schooldata, List<List<String>> workdata) {
		
		Date d = new Date();
		SimpleDateFormat datef = new SimpleDateFormat("dd/MM/yyyy");
		
		datevalue.setText(datef.format(d));
        
        Thread clock;
        	clock = new Thread() {
        		public void run() {
        			for(;;) {
        				Date d = new Date();
        				SimpleDateFormat timef = new SimpleDateFormat("HH:mm:ss");
        				clockvalue.setText(timef.format(d));
     
        				for(int i = 0; i<homedata.size() + schooldata.size() + workdata.size(); i++) {
        					for(int j = 0; j < 5; j++) {
        						if(clockvalue.getText().equals(table1.getModel().getValueAt(i, 3)) && datevalue.getText().equals(table1.getModel().getValueAt(i, 2))) {
        							
        							AudioInputStream audioStream = null;
        							
        							try {
        								File file = new File("C:\\Program Files (x86)\\Microsoft Office\\Office15\\Groove\\Sounds\\Places\\TOOT.WAV");
            							audioStream = AudioSystem.getAudioInputStream(file);
										Clip clip = AudioSystem.getClip();
										
										clip.open(audioStream);
										clip.start();
										
									} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
        							table1.getModel().setValueAt("Started", i, 5);
        							
        						}
        						
        						if(clockvalue.getText().equals(table1.getModel().getValueAt(i, 4)) && datevalue.getText().equals(table1.getModel().getValueAt(i, 2))) {
        							
        							AudioInputStream audioStream = null;
        							
        							try {
        								File file = new File("C:\\Program Files (x86)\\Microsoft Office\\Office15\\Groove\\Sounds\\Places\\ALARM.WAV");
            							audioStream = AudioSystem.getAudioInputStream(file);
										Clip clip = AudioSystem.getClip();
										
										clip.open(audioStream);
										clip.start();
										
									} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
        							table1.getModel().setValueAt("Finished", i, 5);
        							
        							
        						}
        					}
        					
        				}
        				
        				for(int i = 0; i < homedata.size(); i++) {
        					for(int j = 0; j < homedata.get(i).size(); j++) {
        						if(clockvalue.getText().equals(homedata.get(i).get(2)) && datevalue.getText().equals(homedata.get(i).get(1))) {
                					table2.getModel().setValueAt("started", i, 5);
                					
                				}
        						
        						if(clockvalue.getText().equals(homedata.get(i).get(3)) && datevalue.getText().equals(homedata.get(i).get(1))) {
                					table2.getModel().setValueAt("Finished", i, 5);

                				}
        					}
        				}
        				
        				for(int i = 0; i < schooldata.size(); i++) {
        					for(int j = 0; j < schooldata.get(i).size(); j++) {
        						if(clockvalue.getText().equals(schooldata.get(i).get(2)) && datevalue.getText().equals(schooldata.get(i).get(1))) {
                					table3.getModel().setValueAt("started", i, 5);	
                				}
        						
        						if(clockvalue.getText().equals(schooldata.get(i).get(3)) && datevalue.getText().equals(schooldata.get(i).get(1))) {
                					table3.getModel().setValueAt("Finished", i, 5);

                				}
        					}
        				}
        				
        				for(int i = 0; i < workdata.size(); i++) {
        					for(int j = 0; j < workdata.get(i).size(); j++) {
        						if(clockvalue.getText().equals(workdata.get(i).get(2)) && datevalue.getText().equals(workdata.get(i).get(1)) ) {
                					table4.getModel().setValueAt("started", i, 5);	

                				}
        						
        						if(clockvalue.getText().equals(workdata.get(i).get(3)) && datevalue.getText().equals(workdata.get(i).get(1))) {
                					table4.getModel().setValueAt("Finished", i, 5);

                				}
        					}
        				}

        				try {
        					sleep(1000);
        				}catch(Exception e) {
        					JOptionPane.showMessageDialog(null, e);
        				}
        			}
        		}
        	};
        clock.start();
	}

	/**
	 * Create the frame.
	 */
	public SetActivities() {
		
		List<List<String>> homedata = new ArrayList<List<String>>();
		List<List<String>> schooldata = new ArrayList<List<String>>();
		List<List<String>> workdata = new ArrayList<List<String>>();
		List<List<String>> alldata = new ArrayList<List<String>>();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 836);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CATEGORIES");
		lblNewLabel.setBounds(24, 30, 121, 28);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 68, 184, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(196, 30, 1, 237);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(196, 29, 1, 262);
		contentPane.add(separator_2);
		
		JLabel lblActivities = new JLabel("ACTIVITIES");
		lblActivities.setBounds(213, 29, 121, 28);
		lblActivities.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblActivities);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBounds(25, 92, 155, 42);
		contentPane.add(btnNewButton);
		
		JButton btnSchool = new JButton("School");
		btnSchool.setBounds(26, 154, 155, 42);
		contentPane.add(btnSchool);
		
		JButton btnNewButton_1_1 = new JButton("Work");
		btnNewButton_1_1.setBounds(25, 216, 155, 42);
		contentPane.add(btnNewButton_1_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(196, 29, 2, 352);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		contentPane.add(separator_3);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(207, 68, 439, 304);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panel1 = new JPanel();
		layeredPane.add(panel1, "name_192884707722200");
		panel1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CREATE A HOME ACTIVITY");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 14, 166, 25);
		panel1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Title:");
		lblNewLabel_2.setBounds(10, 69, 36, 14);
		panel1.add(lblNewLabel_2);
		
		HomeTitle = new JTextField();
		HomeTitle.setBounds(13, 88, 163, 20);
		panel1.add(HomeTitle);
		HomeTitle.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Date: (dd/MM/yyyy)");
		lblNewLabel_2_1_1.setBounds(264, 69, 144, 14);
		panel1.add(lblNewLabel_2_1_1);
		
		HomeDate = new JTextField();
		HomeDate.setColumns(10);
		HomeDate.setBounds(262, 88, 146, 20);
		panel1.add(HomeDate);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("From: (HH:mm:ss)");
		lblNewLabel_2_1_1_1.setBounds(10, 154, 166, 14);
		panel1.add(lblNewLabel_2_1_1_1);
		
		HomefromTime = new JTextField();
		HomefromTime.setColumns(10);
		HomefromTime.setBounds(10, 169, 165, 20);
		panel1.add(HomefromTime);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("To: (HH:mm:ss)");
		lblNewLabel_2_1_1_1_1.setBounds(265, 154, 143, 14);
		panel1.add(lblNewLabel_2_1_1_1_1);
		
		HometoTime = new JTextField();
		HometoTime.setColumns(10);
		HometoTime.setBounds(265, 169, 143, 20);
		panel1.add(HometoTime);
		
		JButton HomeCreate = new JButton("Create");
		
		HomeCreate.setBounds(10, 228, 128, 43);
		panel1.add(HomeCreate);
		
		panel2 = new JPanel();
		layeredPane.add(panel2, "name_192889411930700");
		panel2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("ADD A SCHOOL ACTIVITY");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 11, 171, 14);
		panel2.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("Assignment");
		
		btnNewButton_2.setBounds(10, 36, 122, 23);
		panel2.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Class Time");
		
		btnNewButton_2_1.setBounds(142, 36, 110, 23);
		panel2.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Other");
		
		btnNewButton_2_1_1.setBounds(274, 36, 89, 23);
		panel2.add(btnNewButton_2_1_1);
		
		layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(10, 70, 419, 255);
		panel2.add(layeredPane_1);
		layeredPane_1.setLayout(new CardLayout(0, 0));
		
		panelin1 = new JPanel();
		layeredPane_1.add(panelin1, "name_226584354570500");
		panelin1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Adding an assignment");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 11, 149, 14);
		panelin1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5_1 = new JLabel("CourseName:");
		lblNewLabel_5_1.setBounds(11, 47, 80, 14);
		panelin1.add(lblNewLabel_5_1);
		
		assigncourse = new JTextField();
		assigncourse.setColumns(10);
		assigncourse.setBounds(11, 66, 149, 20);
		panelin1.add(assigncourse);
		
		JLabel lblNewLabel_5_2 = new JLabel("Date: (dd/MM/yyyy)");
		lblNewLabel_5_2.setBounds(226, 47, 147, 14);
		panelin1.add(lblNewLabel_5_2);
		
		assigndate = new JTextField();
		assigndate.setColumns(10);
		assigndate.setBounds(226, 66, 147, 20);
		panelin1.add(assigndate);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("From: (HH:mm:ss)");
		lblNewLabel_5_2_1.setBounds(14, 107, 145, 14);
		panelin1.add(lblNewLabel_5_2_1);
		
		assignfromtime = new JTextField();
		assignfromtime.setColumns(10);
		assignfromtime.setBounds(12, 125, 147, 20);
		panelin1.add(assignfromtime);
		
		JLabel lblNewLabel_5_2_1_1 = new JLabel("To: (HH:mm:ss)");
		lblNewLabel_5_2_1_1.setBounds(228, 107, 145, 14);
		panelin1.add(lblNewLabel_5_2_1_1);
		
		assigntotime = new JTextField();
		assigntotime.setColumns(10);
		assigntotime.setBounds(228, 125, 143, 20);
		panelin1.add(assigntotime);
		
		JButton assigncreate = new JButton("Create");
		
		assigncreate.setBounds(10, 180, 118, 39);
		panelin1.add(assigncreate);
		
		panelin2 = new JPanel();
		layeredPane_1.add(panelin2, "name_226589826018800");
		panelin2.setLayout(null);
		
		JLabel lblNewLabel_4_1 = new JLabel("Adding a class time");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_1.setBounds(10, 11, 149, 14);
		panelin2.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_3 = new JLabel("CourseName:");
		lblNewLabel_5_3.setBounds(10, 47, 80, 14);
		panelin2.add(lblNewLabel_5_3);
		
		classcourse = new JTextField();
		classcourse.setColumns(10);
		classcourse.setBounds(10, 68, 149, 20);
		panelin2.add(classcourse);
		
		classdate = new JTextField();
		classdate.setColumns(10);
		classdate.setBounds(211, 68, 149, 20);
		panelin2.add(classdate);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Date: (dd/MM/yyyy)");
		lblNewLabel_5_1_1.setBounds(211, 47, 149, 14);
		panelin2.add(lblNewLabel_5_1_1);
		
		classtotime = new JTextField();
		classtotime.setColumns(10);
		classtotime.setBounds(211, 126, 149, 20);
		panelin2.add(classtotime);
		
		JLabel lblNewLabel_5_2_1_2 = new JLabel("To: (HH:mm:ss)");
		lblNewLabel_5_2_1_2.setBounds(211, 107, 149, 14);
		panelin2.add(lblNewLabel_5_2_1_2);
		
		classfromtime = new JTextField();
		classfromtime.setColumns(10);
		classfromtime.setBounds(10, 126, 149, 20);
		panelin2.add(classfromtime);
		
		JLabel lblNewLabel_5_2_2 = new JLabel("From: (HH:mm:ss)");
		lblNewLabel_5_2_2.setBounds(10, 107, 149, 14);
		panelin2.add(lblNewLabel_5_2_2);
		
		JButton classcreate = new JButton("Create");
		
		classcreate.setBounds(10, 178, 108, 39);
		panelin2.add(classcreate);
		
		panelin3 = new JPanel();
		layeredPane_1.add(panelin3, "name_226603889112800");
		panelin3.setLayout(null);
		
		JLabel lblNewLabel_4_2 = new JLabel("Adding another type of activity:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_2.setBounds(10, 11, 209, 14);
		panelin3.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_5_4 = new JLabel("Title:");
		lblNewLabel_5_4.setBounds(10, 47, 144, 14);
		panelin3.add(lblNewLabel_5_4);
		
		school_other_title = new JTextField();
		school_other_title.setColumns(10);
		school_other_title.setBounds(10, 68, 144, 20);
		panelin3.add(school_other_title);
		
		school_otherfrom_time = new JTextField();
		school_otherfrom_time.setColumns(10);
		school_otherfrom_time.setBounds(10, 138, 144, 20);
		panelin3.add(school_otherfrom_time);
		
		JLabel lblNewLabel_5_2_1_3 = new JLabel("From: (HH:mm:ss)");
		lblNewLabel_5_2_1_3.setBounds(10, 113, 144, 14);
		panelin3.add(lblNewLabel_5_2_1_3);
		
		school_other_date = new JTextField();
		school_other_date.setColumns(10);
		school_other_date.setBounds(211, 68, 144, 20);
		panelin3.add(school_other_date);
		
		JLabel lblNewLabel_5_2_3 = new JLabel("Date: (dd/MM/yyyy)");
		lblNewLabel_5_2_3.setBounds(211, 47, 144, 14);
		panelin3.add(lblNewLabel_5_2_3);
		
		school_otherto_time = new JTextField();
		school_otherto_time.setColumns(10);
		school_otherto_time.setBounds(211, 138, 144, 20);
		panelin3.add(school_otherto_time);
		
		JLabel lblNewLabel_5_2_1_1_1 = new JLabel("To: (HH:mm:ss)");
		lblNewLabel_5_2_1_1_1.setBounds(211, 113, 144, 14);
		panelin3.add(lblNewLabel_5_2_1_1_1);
		
		JButton school_other_create = new JButton("Create");
		
		school_other_create.setBounds(10, 181, 108, 39);
		panelin3.add(school_other_create);
		
		panel3 = new JPanel();
		layeredPane.add(panel3, "name_192895309679700");
		panel3.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("ADD A WORK ACTIVITY");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 11, 151, 14);
		panel3.add(lblNewLabel_6);
		
		JButton btnNewButton_2_2 = new JButton("Meeting");
		
		btnNewButton_2_2.setBounds(10, 36, 114, 23);
		panel3.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_1_2 = new JButton("Other");
		
		btnNewButton_2_1_2.setBounds(147, 36, 89, 23);
		panel3.add(btnNewButton_2_1_2);
		
		layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBounds(10, 70, 419, 255);
		panel3.add(layeredPane_2);
		layeredPane_2.setLayout(new CardLayout(0, 0));
		
		panelin1_1 = new JPanel();
		layeredPane_2.add(panelin1_1, "name_228091122019600");
		panelin1_1.setLayout(null);
		
		JLabel lblNewLabel_4_3 = new JLabel("Adding a meeting");
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_3.setBounds(10, 11, 149, 14);
		panelin1_1.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_5_5 = new JLabel("Person or Title:");
		lblNewLabel_5_5.setBounds(10, 47, 108, 14);
		panelin1_1.add(lblNewLabel_5_5);
		
		meetingheader = new JTextField();
		meetingheader.setColumns(10);
		meetingheader.setBounds(10, 68, 149, 20);
		panelin1_1.add(meetingheader);
		
		meetingdate = new JTextField();
		meetingdate.setColumns(10);
		meetingdate.setBounds(211, 68, 149, 20);
		panelin1_1.add(meetingdate);
		
		JLabel lblNewLabel_5_1_3 = new JLabel("Date: (dd/MM/yyyy)");
		lblNewLabel_5_1_3.setBounds(211, 47, 149, 14);
		panelin1_1.add(lblNewLabel_5_1_3);
		
		meetingfromtime = new JTextField();
		meetingfromtime.setColumns(10);
		meetingfromtime.setBounds(10, 129, 149, 20);
		panelin1_1.add(meetingfromtime);
		
		JLabel lblNewLabel_5_2_1_4 = new JLabel("From: (HH:mm:ss)");
		lblNewLabel_5_2_1_4.setBounds(10, 111, 149, 14);
		panelin1_1.add(lblNewLabel_5_2_1_4);
		
		JButton meetingcreate = new JButton("Create");
		
		meetingcreate.setBounds(10, 187, 108, 39);
		panelin1_1.add(meetingcreate);
		
		meetingtotime = new JTextField();
		meetingtotime.setColumns(10);
		meetingtotime.setBounds(211, 129, 149, 20);
		panelin1_1.add(meetingtotime);
		
		JLabel lblNewLabel_5_2_1_1_2 = new JLabel("To: (HH:mm:ss)");
		lblNewLabel_5_2_1_1_2.setBounds(211, 111, 149, 14);
		panelin1_1.add(lblNewLabel_5_2_1_1_2);
		
		panelin1_2 = new JPanel();
		layeredPane_2.add(panelin1_2, "name_228327413522100");
		panelin1_2.setLayout(null);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Adding another type of activity:");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_2_1.setBounds(10, 11, 209, 14);
		panelin1_2.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_5_4_1 = new JLabel("Title:");
		lblNewLabel_5_4_1.setBounds(10, 47, 62, 14);
		panelin1_2.add(lblNewLabel_5_4_1);
		
		work_other_title = new JTextField();
		work_other_title.setColumns(10);
		work_other_title.setBounds(10, 68, 144, 20);
		panelin1_2.add(work_other_title);
		
		JLabel lblNewLabel_5_2_1_3_1 = new JLabel("From: (HH:mm:ss)");
		lblNewLabel_5_2_1_3_1.setBounds(10, 117, 144, 14);
		panelin1_2.add(lblNewLabel_5_2_1_3_1);
		
		work_otherfrom_time = new JTextField();
		work_otherfrom_time.setColumns(10);
		work_otherfrom_time.setBounds(10, 142, 144, 20);
		panelin1_2.add(work_otherfrom_time);
		
		work_other_date = new JTextField();
		work_other_date.setColumns(10);
		work_other_date.setBounds(211, 68, 144, 20);
		panelin1_2.add(work_other_date);
		
		JLabel lblNewLabel_5_2_3_1 = new JLabel("Date: (dd/MM/yyyy)");
		lblNewLabel_5_2_3_1.setBounds(211, 47, 144, 14);
		panelin1_2.add(lblNewLabel_5_2_3_1);
		
		JButton btnNewButton_3_2_1 = new JButton("Create");
		
		btnNewButton_3_2_1.setBounds(10, 181, 108, 39);
		panelin1_2.add(btnNewButton_3_2_1);
		
		work_otherto_time = new JTextField();
		work_otherto_time.setColumns(10);
		work_otherto_time.setBounds(211, 142, 144, 20);
		panelin1_2.add(work_otherto_time);
		
		JLabel lblNewLabel_5_2_1_1_1_1 = new JLabel("To: (HH:mm:ss)");
		lblNewLabel_5_2_1_1_1_1.setBounds(211, 117, 144, 14);
		panelin1_2.add(lblNewLabel_5_2_1_1_1_1);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 382, 635, 2);
		contentPane.add(separator_4);
		
		JButton btnNewButton_4 = new JButton("All");
		btnNewButton_4.setBounds(19, 438, 79, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblCreatedActivities = new JLabel("CREATED ACTIVITIES");
		lblCreatedActivities.setBounds(21, 393, 311, 28);
		lblCreatedActivities.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblCreatedActivities);
		
		clockvalue = new JLabel("");
		clockvalue.setBounds(590, 395, 56, 23);
		contentPane.add(clockvalue);
		
		
		
		
		JButton btnNewButton_4_1 = new JButton("Home Activities");
		btnNewButton_4_1.setBounds(134, 438, 155, 23);
		contentPane.add(btnNewButton_4_1);
		
		JButton btnNewButton_4_1_1 = new JButton("School Activities");
		btnNewButton_4_1_1.setBounds(319, 438, 155, 23);
		contentPane.add(btnNewButton_4_1_1);
		
		JButton btnNewButton_4_1_1_1 = new JButton("Work Activities");
		btnNewButton_4_1_1_1.setBounds(491, 438, 155, 23);
		contentPane.add(btnNewButton_4_1_1_1);
		
		layeredPane_3 = new JLayeredPane();
		layeredPane_3.setBounds(12, 472, 634, 262);
		contentPane.add(layeredPane_3);
		layeredPane_3.setLayout(new CardLayout(0, 0));
		
		panel2_1 = new JPanel();
		layeredPane_3.add(panel2_1, "name_242324896451100");
		panel2_1.setLayout(null);
		
		JLabel lblNewLabel_4_4 = new JLabel("All Activities");
		lblNewLabel_4_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_4.setBounds(10, 11, 149, 14);
		panel2_1.add(lblNewLabel_4_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 35, 624, 216);
		panel2_1.add(scrollPane);
		
		table1 = new JTable();
		
		model1 = new DefaultTableModel();
		Object[] allcolumn = {"Category", "Title", "Date", "From", "To", "Status"};
		final Object[] allrow = new Object[6];
		model1.setColumnIdentifiers(allcolumn);
		table1.setModel(model1);
		scrollPane.setViewportView(table1);
		
		
		table1.setBounds(11, 36, 601, 215);
//		panel2_1.add(table1);
		
		
		
		panel2_2 = new JPanel();
		layeredPane_3.add(panel2_2, "name_242417193135500");
		panel2_2.setLayout(null);
		
		JLabel lblNewLabel_4_5 = new JLabel("Home Activities");
		lblNewLabel_4_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_5.setBounds(10, 11, 149, 14);
		panel2_2.add(lblNewLabel_4_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 36, 624, 215);
		panel2_2.add(scrollPane_1);
		
		table2 = new JTable();
		model2 = new DefaultTableModel();
		Object[] homecolumn = {"Category","Title", "Date", "From", "To", "Status"};
		homerow = new Object[6];
		model2.setColumnIdentifiers(homecolumn);
		table2.setModel(model2);
		scrollPane_1.setViewportView(table2);
		
		table2.setBounds(10, 35, 602, 216);
//		panel2_2.add(table2);
		
		
		
		panel2_3 = new JPanel();
		layeredPane_3.add(panel2_3, "name_242420662050700");
		panel2_3.setLayout(null);
		
		JLabel lblNewLabel_4_6 = new JLabel("School Activities");
		lblNewLabel_4_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_6.setBounds(10, 11, 149, 14);
		panel2_3.add(lblNewLabel_4_6);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 36, 623, 215);
		panel2_3.add(scrollPane_2);
		
		table3 = new JTable();
		model3 = new DefaultTableModel();
		Object[] schoolcolumn = {"Category","Course Name", "Date", "From", "To", "Status"};
		final Object[] schoolrow = new Object[6];
		model3.setColumnIdentifiers(schoolcolumn);
		table3.setModel(model3);
		scrollPane_2.setViewportView(table3);
		
		table3.setBounds(10, 36, 602, 215);
//		panel2_3.add(table3);
		
		
		
		panel2_4 = new JPanel();
		layeredPane_3.add(panel2_4, "name_242424305922900");
		panel2_4.setLayout(null);
		
		JLabel lblNewLabel_4_7 = new JLabel("Work Activities");
		lblNewLabel_4_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4_7.setBounds(10, 11, 149, 14);
		panel2_4.add(lblNewLabel_4_7);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 36, 623, 215);
		panel2_4.add(scrollPane_3);
		
		table4 = new JTable();
		model4 = new DefaultTableModel();
		Object[] workcolumn = {"Category","Title", "Date", "From", "To", "Status"};
		final Object[] workrow = new Object[5];
		model4.setColumnIdentifiers(workcolumn);
		table4.setModel(model4);
		scrollPane_3.setViewportView(table4);
		
		table4.setBounds(10, 36, 602, 215);
//		panel2_4.add(table4);
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Clock:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(539, 399, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("Date:");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1.setBounds(397, 399, 46, 14);
		contentPane.add(lblNewLabel_7_1);
		
		datevalue = new JLabel("");
		datevalue.setBounds(438, 395, 72, 22);
		contentPane.add(datevalue);
		
		
		
		
		
		// buttons to switch main panels
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel1);
			}
		});
		
		btnSchool.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel2);
			}
		});
		
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel3);
			}
		});
		
		// Buttons to switch school panels
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchSchoolPanels(panelin1);
			}
		});
		
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchSchoolPanels(panelin2);
			}
		});
		
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchSchoolPanels(panelin3);
			}
		});
		
		// Buttons to switch work panels
		
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchWorkPanels(panelin1_1);
			}
		});
		
		btnNewButton_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchWorkPanels(panelin1_2);
			}
		});
		
		// Buttons to switch created activities panel
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchActivitiesPanels(panel2_1);
			}
			
		});
		
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchActivitiesPanels(panel2_2);
			}
		});
		
		btnNewButton_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchActivitiesPanels(panel2_3);
			}
		});
		
		btnNewButton_4_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchActivitiesPanels(panel2_4);
			}
		});
		
		
		// Printing the clock running
		currentTime(homedata, schooldata, workdata);
		
		// Saving a home activity
		
		HomeCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Validating the user entry info
				
				
				
				if(validateuserinfo(HomeTitle.getText(), HomeDate.getText(), HomefromTime.getText(), HometoTime.getText())) {
				
					homerow[0] = "Home";
					homerow[1] = HomeTitle.getText();
					homerow[2] = HomeDate.getText();
					homerow[3] = HomefromTime.getText();
					homerow[4] = HometoTime.getText();
					
					
					model2.addRow(homerow);
					model1.addRow(homerow);
	
					HomeTitle.setText("");
					
					JOptionPane.showMessageDialog(null, "Saved Successfully");		
					
					// Putting the information in the home class
					
					Home home = new Home(HomeTitle.getText(), HomeDate.getText(), HomefromTime.getText(), HometoTime.getText());
					ArrayList<String> newhomedata = home.homecreate();
					homedata.add(newhomedata);
				}
			}
		});
		
		// Saving an assignment activity
		
		assigncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(validateuserinfo(assigncourse.getText(), assigndate.getText() ,assignfromtime.getText(), assigntotime.getText())) {
					
					schoolrow[0] = "Assignment";
					schoolrow[1] = assigncourse.getText();
					schoolrow[2] = assigndate.getText();
					schoolrow[3] = assignfromtime.getText();
					schoolrow[4] = assigntotime.getText();
					
					model3.addRow(schoolrow);
					model1.addRow(schoolrow);
					
					assigncourse.setText("");
					
					JOptionPane.showMessageDialog(null, "Saved Successfully");	
					
					School school = new School(assigncourse.getText(), assigndate.getText(), assignfromtime.getText(), assigntotime.getText());
					ArrayList<String> newschooldata = school.schoolcreate();
					schooldata.add(newschooldata);
				}
				
				
			}
		});
		
		// Saving a class activity
		
		classcreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(validateuserinfo(classcourse.getText(), classdate.getText(), classfromtime.getText(), classtotime.getText())) {
					schoolrow[0] = "Class Time";
					schoolrow[1] = classcourse.getText();
					schoolrow[2] = classdate.getText();
					schoolrow[3] = classfromtime.getText();
					schoolrow[4] = classtotime.getText();
					
					model3.addRow(schoolrow);
					model1.addRow(schoolrow);
					
					classcourse.setText("");
					
					JOptionPane.showMessageDialog(null, "Saved Successfully");	
					
					School school = new School(classcourse.getText(), classdate.getText(), classfromtime.getText(), classtotime.getText());
					ArrayList<String> newschooldata = school.schoolcreate();
					schooldata.add(newschooldata);
				}
				
			}
		});
		
		// Saving another school activity
		
		school_other_create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(validateuserinfo(school_other_title.getText(), school_other_date.getText(), school_otherfrom_time.getText(), school_otherto_time.getText())) {
					schoolrow[0] = "Other";
					schoolrow[1] = school_other_title.getText();
					schoolrow[2] = school_other_date.getText();
					schoolrow[3] = school_otherfrom_time.getText();
					schoolrow[4] = school_otherto_time.getText();
					
					model3.addRow(schoolrow);
					model1.addRow(schoolrow);
					
					school_other_title.setText("");
					
					JOptionPane.showMessageDialog(null, "Saved Successfully");	
					
					School school = new School(school_other_title.getText(), school_other_date.getText(), school_otherfrom_time.getText(), school_otherto_time.getText());
					ArrayList<String> newschooldata = school.schoolcreate();
					schooldata.add(newschooldata);
				}
				
			}
		});
		
		// Saving a work meeting activity
		
		meetingcreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(validateuserinfo(meetingheader.getText(), meetingdate.getText(), meetingfromtime.getText(), meetingtotime.getText())) {
					workrow[0] = "Meeting";
					workrow[1] = meetingheader.getText();
					workrow[2] = meetingdate.getText();
					workrow[3] = meetingfromtime.getText();
					workrow[4] = meetingtotime.getText();
					
					model4.addRow(workrow);
					model1.addRow(workrow);
					
					meetingheader.setText("");
					
					JOptionPane.showMessageDialog(null, "Saved Successfully");	
					
					Work work = new Work(meetingheader.getText(), meetingdate.getText(), meetingfromtime.getText(), meetingtotime.getText());
					ArrayList<String> newworkdata = work.workcreate();
					workdata.add(newworkdata);
				}
				
			}
		});
		
		// Saving other work activity
		
		btnNewButton_3_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (validateuserinfo(work_other_title.getText(), work_other_date.getText(), work_otherfrom_time.getText(), work_otherto_time.getText())) {
					workrow[0] = "Other";
					workrow[1] = work_other_title.getText();
					workrow[2] = work_other_date.getText();
					workrow[3] = work_otherfrom_time.getText();
					workrow[4] = work_otherto_time.getText();
					
					model4.addRow(workrow);
					model1.addRow(workrow);
					
					work_other_title.setText("");
					
					JOptionPane.showMessageDialog(null, "Saved Successfully");	
					
					Work work = new Work(work_other_title.getText(), work_other_date.getText(), work_otherfrom_time.getText(), work_otherto_time.getText());
					ArrayList<String> newworkdata = work.workcreate();
					workdata.add(newworkdata);
				}
				
			}
		});
		
		
	}
}
