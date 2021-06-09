package checkinandout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Choice_checkin extends JFrame {

	private JPanel contentPane;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Choice_checkin frame = new Choice_checkin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Choice_checkin() {
	
		frame = new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WHO DO YOU WANT TO CHECK IN OR OUT?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(29, 21, 375, 45);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Checkinandout_info student_checkin = new Checkinandout_info();
				student_checkin.setVisible(true);
			}
		});
		btnNewButton.setBounds(26, 96, 111, 60);
		contentPane.add(btnNewButton);
		
		JButton btnStaff = new JButton("Staff");
		btnStaff.setBounds(157, 96, 111, 60);
		contentPane.add(btnStaff);
		
		JButton btnVisitors = new JButton("Visitor");
		btnVisitors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVisitors.setBounds(290, 96, 111, 60);
		contentPane.add(btnVisitors);
	}

}
