package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.lang.model.element.NestingKind;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class MyDbClass {
	
	String url="jdbc:sqlite:C:\\Users\\Sohail\\UserData.db";
	Connection connect;
	Statement statement;
	
	//Constructor method to establish connection with the data base
	public MyDbClass() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		connect=DriverManager.getConnection(url);
		statement= connect.createStatement();
		System.out.println("connected to Db");
	}
    //Method to insert data in the Database
	public String insert_data(String FirstName, String LastName, String PhoneNo,  String Address, int Id, String EmailId) throws SQLException {
		String Query="insert into Userdata values('"+ FirstName + "' ,'"+ LastName +"','" + PhoneNo + "','"+ Address + "','" + Id + "','"+ EmailId+"')";
		statement.execute(Query);
		System.out.println("inserted");
		return Query;
	}
	//Method to update data
	public void update_data(int id, String ColumnName, String newValue) throws SQLException {
		String UpdateQuery="UPDATE Userdata SET "+ColumnName + "= ? WHERE id = ?" ;
		connect = DriverManager.getConnection(url);
		PreparedStatement pt = connect.prepareStatement(UpdateQuery);
		pt.setString(1, newValue);
		pt.setInt(2, id);
		pt.executeUpdate();
		
		try (Connection conn = DriverManager.getConnection(url)) {
		    // Increase the busy timeout to 5 seconds
		    conn.createStatement().execute("PRAGMA busy_timeout = 5000;");
		    
		    // Execute your query or update here
		    PreparedStatement pstmt = conn.prepareStatement(UpdateQuery);
		    pstmt.executeUpdate();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		int retries = 5;
		while (retries > 0) {
		    try (Connection conn = DriverManager.getConnection(url)) {
		        // Execute your query or update
		        PreparedStatement pstmt = conn.prepareStatement(UpdateQuery);
		        pstmt.executeUpdate();
		        break; // Exit loop if successful
		    } catch (SQLException e) {
		        if (e.getMessage().contains("database is locked")) {
		            retries--;
		            try {
		                // Wait for a short period before retrying
		                Thread.sleep(1000);
		            } catch (InterruptedException ie) {
		                ie.printStackTrace();
		            }
		        } else {
		            e.printStackTrace();
		            break;
		        }
		    }
		}
		
//		psmt.setString(1, newValue);
//		psmt.setInt(2, id);
//		int rowsUpdated= psmt.executeUpdate();
//		
//		if(rowsUpdated>0) {
//			System.out.println("data updated");
//		}
//		else {
//			System.out.println("not found");
//		}
		
	}
	//Method to display all the record
	public List<Object[]>  display_user(){
		List<Object[]> userList = new ArrayList<>();
		try {
			
			String displayQuery="SELECT * FROM Userdata";
			statement = connect.createStatement();
			ResultSet rs= statement.executeQuery(displayQuery);
			
			
	            while (rs.next()) {
	            	Object[] userData= new Object[6];
	                userData[0] = rs.getString("firstname");
	                userData[1] = rs.getString("lastname");
	                userData[2] = rs.getString("phoneno");
	                userData[3] = rs.getString("address");
	                userData[4] = rs.getInt("id");
	                userData[5] = rs.getString("EmailID");
	                
	                userList.add(userData);
	                System.out.println(Arrays.toString(userData));
	            }
	        	   rs.close();
	        	   statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
		
		
		
	}
	//Function to Delete Data
	public void remove_data(int id) {
		String removeQuery="DELETE FROM Userdata WHERE Id = ?";
		
		try {
			PreparedStatement pt = connect.prepareStatement(removeQuery);
			pt.setInt(1, id);
			pt.executeUpdate();
			System.out.println("pt");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		int retries = 5;
		while (retries > 0) {
		    try (Connection conn = DriverManager.getConnection(url)) {
		        // Execute your query or update
		        PreparedStatement pt = conn.prepareStatement(removeQuery);
		        pt.executeUpdate();
		        break; // Exit loop if successful
		    } catch (SQLException e) {
		        if (e.getMessage().contains("database is locked")) {
		            retries--;
		            try {
		                // Wait for a short period before retrying
		                Thread.sleep(1000);
		            } catch (InterruptedException ie) {
		                ie.printStackTrace();
		            }
		        } else {
		            e.printStackTrace();
		            break;
		        }
		    }
		}
	}
	
	//Main method
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("running");
		MyDbClass cnt = new MyDbClass();
//		cnt.insert_data("Test 2", "dfdf", "sohail", "dsd 2",1,"fdhgfj");
		System.out.println("done");
//		cnt.update_data(2, "FirstName", "sohail");
//		System.out.println("updated");
//		cnt.remove_data(1);
         cnt.display_user();
		
	}
}
