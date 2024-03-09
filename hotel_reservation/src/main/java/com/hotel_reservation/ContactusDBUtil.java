package com.hotel_reservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactusDBUtil {
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	// insert for Contact us

		public static boolean insert(String name,String email,String phone,String message) {
			
			boolean isSuccess = false;
			
			
			
			try {
				//DB Connection
				con = DBConnect.getConnection();
				stmt = con.createStatement(); 
				String sql = "insert into contactus values(0,'"+name+"','"+email+"','"+phone+"','"+message+"')";
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
		
		// view Contact us
	public static List<Contactus> view(String name){
		
		
		ArrayList<Contactus> contact = new ArrayList<>();
		
		try {
			
			//DB CONNECTION
			con =DBConnect.getConnection();
			stmt=con.createStatement();
			
			//SQL QUERY
			String sql ="select * from contactus where name='"+name+"'";
			
			//RESULTSET
			rs=stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String cname = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String message = rs.getString(5);

				//factory method pattern - abstract
			    Contactus c = new Contactus(id,cname,email,phone,message);
				contact.add(c);
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return contact;
		
	}
	
	//update Contact us

	public static boolean update(String id,String name,String email,String phone,String message ) {
		
		try {
			
			//DB CONNECTION
			con = DBConnect.getConnection();
			stmt = con.createStatement(); 
			String sql ="update contactus set name='"+name+"',email='"+email+"',phone='"+phone+"',message='"+message+"'"  
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

		// get Contact us
	public static List<Contactus> get(String Id){
		
		int convertedID =Integer.parseInt(Id);
		
		ArrayList<Contactus> contact = new ArrayList<>();
		
		try {
			
			//DB CONNECTION
			con =DBConnect.getConnection();
			stmt=con.createStatement();
			
			//SQL QUERY
			String sql ="select * from contactus where id='"+convertedID+"'";
			
			//RESULTSET
			rs=stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
				String message = rs.getString(5);

				

				
			    Contactus c = new Contactus(id,name,email,phone,message);
				contact.add(c);
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return contact;
		
	}
	
	//Delete Contact us
	public static boolean delete(String id) {
		int convertedID =Integer.parseInt(id);
		
		try {
			
			//DB CONNECTION
			con = DBConnect.getConnection();
			stmt = con.createStatement(); 
			String sql ="delete from contactus where id ='"+convertedID+"'";
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
