package com.login;

import javax.swing.JFrame;

import java.awt.Choice;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

public class ManagementUI  implements ActionListener{
	
	JFrame frame = new JFrame("UserInfo Manager");
	JPanel inputPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	//Declaration of button
	JButton createButton = new JButton("Create");
	JButton readButton = new JButton("Show");
	JButton updateButton = new JButton("Update");
	JButton deleteButton = new JButton("Delete");
	//Declaration of Text Fields
	JTextField firstNameField = new JTextField();
	JTextField lastNameField = new JTextField();
	JTextField phonenoField = new JTextField();
	JTextField AddressField = new JTextField();
	JTextField IdField = new JTextField();
	JTextField emailField = new JTextField();
	
	 JTable userTable;
	// UI function
	public void RecordUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(848,633);
		
		inputPanel.setLayout(new GridLayout(6, 2));
		JLabel label = new JLabel("First Name: ");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		inputPanel.add(label);
		
		
		firstNameField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		inputPanel.add(firstNameField);
		
		JLabel label_1 = new JLabel("Last Name: ");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		inputPanel.add(label_1);
		
		lastNameField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		inputPanel.add(lastNameField);
		
		JLabel label_2 = new JLabel("Phone No: ");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		inputPanel.add(label_2);
		
		phonenoField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		inputPanel.add(phonenoField);

		JLabel label_3 = new JLabel("Address: ");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		inputPanel.add(label_3);
		
		AddressField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		inputPanel.add(AddressField);
		
		JLabel label_4 = new JLabel("ID: ");
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		inputPanel.add(label_4);
		
		IdField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		inputPanel.add(IdField);
		
		JLabel label_5 = new JLabel("Email: ");
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		inputPanel.add(label_5);
		emailField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		inputPanel.add(emailField);
		
		
	       // Button Attributes
	        createButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        readButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        updateButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        //Adding buttons to button panel
	        buttonPanel.add(createButton);
	        buttonPanel.add(readButton);
	        buttonPanel.add(updateButton);
	        buttonPanel.add(deleteButton);
	        //adding event listener to buttons
	        createButton.addActionListener(this);
	        readButton.addActionListener(this);
	        updateButton.addActionListener(this);
	        deleteButton.addActionListener(this);
	        
//	        String[] columnNames = {"First Name", "Last Name", "Phone Number", "Address" ,"Id","Email ID"};
//	         userTable = new JTable(new Object[][]{}, columnNames);
//	        JScrollPane tableScrollPane = new JScrollPane(userTable);
	        
	        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
	        frame.getContentPane().add(buttonPanel, BorderLayout.CENTER);
	        //frame.getContentPane().add(tableScrollPane, BorderLayout.SOUTH);
	        frame.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MyDbClass dbclass;
		String Fname;
		String lname;
		String pno;
		String Addres;
		int Id;
		String email;
		String value;
		Object obj = e.getSource();
		
		try {
		dbclass = new MyDbClass();
		if(obj==createButton) {
			Fname = firstNameField.getText();
			lname = lastNameField.getText();
			pno = phonenoField.getText();
			Addres = AddressField.getText();
			Id = Integer.parseInt(IdField.getText());
			email= emailField.getText();
			if(!Fname.isEmpty() && Fname.matches("[A-Za-z]+") && !lname.isEmpty() && lname.matches("[A-Za-z]+") && pno.matches("\\d{10}") && email.contains("@") && email.contains(".")) {
				value= dbclass.insert_data(Fname, lname, pno, Addres, Id, email);
				System.out.println(value);
				System.out.println("added");
				firstNameField.setText(null);
				lastNameField.setText(null);
				phonenoField.setText(null);
				AddressField.setText(null);
				IdField.setText(null);
				emailField.setText(null);
				JOptionPane.showMessageDialog(null, "Great your Data is Added","Data Added ",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				System.out.println("Error!! Check your data");
				JOptionPane.showMessageDialog(null, "Error Please enter the data properly","check ",JOptionPane.INFORMATION_MESSAGE);
			}
			
		}
		
		if(obj==readButton) {
			 List<Object[]> userlist= dbclass.display_user();
			Object[][] data = new Object[userlist.size()][6];
			for(int i =0;i<userlist.size();i++) {
				data[i]= userlist.get(i);
			}
			 String[] columnNames = {"First Name", "Last Name", "Phone Number", "Address" ,"Id","Email ID"};
	         userTable = new JTable(data, columnNames);
	         JScrollPane tableScrollPane = new JScrollPane(userTable);
	         frame.getContentPane().add(tableScrollPane, BorderLayout.SOUTH);
	         frame.setVisible(true);
			System.out.println("display");
		}
		
		if(obj==deleteButton) {
			String deleteID =JOptionPane.showInputDialog(null,"enter the id of the user you want to delete:");
			int delID= Integer.parseInt(deleteID);
			System.out.println(delID);
			dbclass.remove_data(delID);
			JOptionPane.showMessageDialog(null, "Data is Removed","Remove ",JOptionPane.INFORMATION_MESSAGE);
			
		}
		if(obj==updateButton) {
			String idString= JOptionPane.showInputDialog(null,"Enter the user id which you want to update the data:");
			int id= Integer.parseInt(idString);
			String columnName= JOptionPane.showInputDialog(null,"Enter what you want to update from the data:");
			String updatedData =  JOptionPane.showInputDialog(null,"enter data you want to update from the data:");
			dbclass.update_data(id, columnName, updatedData);
			JOptionPane.showMessageDialog(null, "Your Data is Updated","Updated ",JOptionPane.INFORMATION_MESSAGE);
		}	
		}
		catch (ClassNotFoundException | SQLException e3) {
			// TODO: handle exception
			e3.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ManagementUI m = new ManagementUI();
		m.RecordUI();
	}
		
}

