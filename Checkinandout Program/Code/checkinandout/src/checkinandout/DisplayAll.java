// Author: Julien and Landp

package checkinandout;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayAll extends JFrame {

	private JPanel contentPane;
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
					DisplayAll frame = new DisplayAll();
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
	public DisplayAll() {}
	
	List<List<String>> sdata = null;
	List<List<String>> stdata = null;
	List<List<String>> vdata = null;
	
	public DisplayAll(List<List<String>> studentdata, List<List<String>> staffdata, List<List<String>> visitordata) {
		
//		frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.sdata = studentdata;
		this.stdata = staffdata;
		this.vdata = visitordata;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 632);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HERE IS YOUR DAILY REPORT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(113, 11, 279, 25);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(124, 40, 249, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Students who came to school");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(135, 67, 223, 14);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 92, 453, 127);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"StudentID", "Name", "Email", "Date", "Vehicle", "Timein", "Timeout"};
		final Object[] row = new Object[7];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		// Displaying the students that came to school
		
		for(int i = 0; i < sdata.size(); i++) {
			for(int j = 0; j < sdata.get(i).size(); j++) {
				row[0] = sdata.get(i).get(0);
				row[1] = sdata.get(i).get(1);
				row[2] = sdata.get(i).get(2);
				row[3] = sdata.get(i).get(3);
				row[4] = sdata.get(i).get(4);
				row[5] = sdata.get(i).get(5);
				row[6] = sdata.get(i).get(6);
				model.addRow(row);
				break;
			}
		}
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Staff who came to school");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(149, 239, 212, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 264, 453, 127);
		contentPane.add(scrollPane_1);
		
		// Creating staff table and pass info to it
		
		table2 = new JTable();
		model2 = new DefaultTableModel();
		Object[] scolumn = {"StudentID", "Name", "Email", "Role", "Date", "Vehicle", "Timein", "Timeout"};
		final Object[] srow = new Object[8];
		model2.setColumnIdentifiers(scolumn);
		table2.setModel(model2);
		scrollPane_1.setViewportView(table2);
		
		for(int i = 0; i < stdata.size(); i++) {
			for(int j = 0; j < stdata.get(i).size(); j++) {
				srow[0] = stdata.get(i).get(0);
				srow[1] = stdata.get(i).get(1);
				srow[2] = stdata.get(i).get(2);
				srow[3] = stdata.get(i).get(3);
				srow[4] = stdata.get(i).get(4);
				srow[5] = stdata.get(i).get(5);
				srow[6] = stdata.get(i).get(6);
				srow[7] = stdata.get(i).get(7);
				model2.addRow(srow);
				break;
			}
		}
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Visitors who came to school");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(141, 409, 212, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(21, 434, 453, 127);
		contentPane.add(scrollPane_1_1);
		
		// Creating Visitors table and pass info to it
		
		table3 = new JTable();
		model3 = new DefaultTableModel();
		Object[] vcolumn = {"VisitorID", "Name", "Email", "Motif", "Date", "Vehicle", "Timein", "Timeout"};
		final Object[] vrow = new Object[8];
		model3.setColumnIdentifiers(vcolumn);
		table3.setModel(model3);
		scrollPane_1_1.setViewportView(table3);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Checkinandout_info checkinout = new Checkinandout_info();
				checkinout.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(10, 14, 89, 30);
		contentPane.add(btnNewButton);
		
		// Displaying the students that came to school
		
		for(int i = 0; i < vdata.size(); i++) {
			for(int j = 0; j < vdata.get(i).size(); j++) {
				vrow[0] = vdata.get(i).get(0);
				vrow[1] = vdata.get(i).get(1);
				vrow[2] = vdata.get(i).get(2);
				vrow[3] = vdata.get(i).get(3);
				vrow[4] = vdata.get(i).get(4);
				vrow[5] = vdata.get(i).get(5);
				vrow[6] = vdata.get(i).get(6);
				vrow[7] = vdata.get(i).get(7);
				model3.addRow(vrow);
				break;
			}
		}
	}
	
}
