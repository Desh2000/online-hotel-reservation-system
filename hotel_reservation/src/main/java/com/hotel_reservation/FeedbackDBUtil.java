package com.hotel_reservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDBUtil {
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	// insert for Feedback

	public static boolean insert(String name,String feedback) {
		
		boolean isSuccess = false;
		
		
		
		try {
			   //DB Connection
			con = DBConnect.getConnection();
			//singleton pattern
			stmt = con.createStatement(); 
			String sql = "insert into feedback values(0,'"+name+"','"+feedback+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}
			
			else {
			isSuccess = false;
			}
		}
		
		catch(Exception e) {	
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	// view Feedback
public static List<Feedback> view(String name){
	
	
	ArrayList<Feedback> feed = new ArrayList<>();
	
	try {
		
		//DB CONNECTION
		con =DBConnect.getConnection();
		stmt=con.createStatement();
		
		//SQL QUERY
		String sql ="select * from feedback where name='"+name+"'";
		
		//RESULTSET
		rs=stmt.executeQuery(sql);
		
		
		while(rs.next()) {
			int id = rs.getInt(1);
			String fname = rs.getString(2);
			String feedback = rs.getString(3);
			
		    Feedback f = new Feedback(id,fname,feedback);
			feed.add(f);
		}
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	return feed;
	
}

//update Feedback

public static boolean update(String id,String name,String feedback ) {
	
	try {
		
		//DB CONNECTION
		con = DBConnect.getConnection();
		stmt = con.createStatement(); 
		String sql ="update feedback set name='"+name+"',feedback='"+feedback+"'"  
		+"where id ='"+id+"'";
		int rs= stmt.executeUpdate(sql);
		
		if(rs>0) {
			isSuccess=true;
		}
		else {
			isSuccess=false;
		}
		
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	return isSuccess;
}

	// get Feedback
public static List<Feedback> get(String Id){
	
	int convertedID =Integer.parseInt(Id);
	
	ArrayList<Feedback> feed = new ArrayList<>();
	
	try {
		
		//DB CONNECTION
		con =DBConnect.getConnection();
		stmt=con.createStatement();
		
		//SQL QUERY
		String sql ="select * from feedback where id='"+convertedID+"'";
		
		//RESULTSET
		rs=stmt.executeQuery(sql);
		
		
		while(rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String feedback = rs.getString(3);
			

			
		    Feedback f = new Feedback(id,name,feedback);
			feed.add(f);
		}
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	return feed;
	
}

//Delete Feedback
public static boolean delete(String id) {
	int convertedID =Integer.parseInt(id);
	
	try {
		
		//DB CONNECTION
		con = DBConnect.getConnection();
		stmt = con.createStatement(); 
		String sql ="delete from feedback where id ='"+convertedID+"'";
		int rs= stmt.executeUpdate(sql);
		
		if(rs>0) {
			isSuccess=true;
		}
		else {
			isSuccess=false;
		}
		
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	return isSuccess;
}


}
