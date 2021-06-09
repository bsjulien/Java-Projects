// Author: Julien and Lando

package checkinandout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 512, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabelTitle = new JLabel("CHECK IN AND OUT PROGRAM");
		lblNewLabelTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabelTitle.setBounds(102, 85, 280, 23);
		frame.getContentPane().add(lblNewLabelTitle);
		
		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Checkinandout_info checkinout = new Checkinandout_info();
				checkinout.setVisible(true);
			}
		});
		btnNewButton.setBounds(163, 130, 149, 48);
		frame.getContentPane().add(btnNewButton);
	}
}
