package com.hotel_reservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookingDBUtil {
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	// insert for Booking

			public static boolean insert(String name,String packages,String arrival,String depature) {
				
				boolean isSuccess = false;
				
				
				
				try {
					//DB Connection 
					con = DBConnect.getConnection();
					stmt = con.createStatement(); 
					String sql = "insert into booking values(0,'"+name+"','"+packages+"','"+arrival+"','"+depature+"')";
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
			
			// view Booking
		public static List<Booking> view(String name){
			
			
			ArrayList<Booking> book = new ArrayList<>();
			
			try {
				
				//DB CONNECTION
				con =DBConnect.getConnection();
				stmt=con.createStatement();
				
				//SQL QUERY
				String sql ="select * from booking where name='"+name+"'";
				
				//RESULTSET
				rs=stmt.executeQuery(sql);
				
				
				while(rs.next()) {
					int id = rs.getInt(1);
					String cname = rs.getString(2);
					String packages = rs.getString(3);
					String arrival = rs.getString(4);
					String depature = rs.getString(5);

					
					//factory method pattern - abstract
				    Booking b = new Booking(id,cname,packages,arrival,depature);
					book.add(b);
				}
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
			return book;
			
		}
		
		//update Booking

		public static boolean update(String id,String name,String packages,String arrival,String depature ) {
			
			try {
				
				//DB CONNECTION
				con = DBConnect.getConnection();
				stmt = con.createStatement(); 
				String sql ="update booking set name='"+name+"',packages='"+packages+"',arrival='"+arrival+"',depature='"+depature+"'"  
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

			// get Booking
		public static List<Booking> get(String Id){
			
			int convertedID =Integer.parseInt(Id);
			
			ArrayList<Booking> book = new ArrayList<>();
			
			try {
				
				//DB CONNECTION
				con =DBConnect.getConnection();
				stmt=con.createStatement();
				
				//SQL QUERY
				String sql ="select * from booking where id='"+convertedID+"'";
				
				//RESULTSET
				rs=stmt.executeQuery(sql);
				
				
				while(rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String packages = rs.getString(3);
					String arrival = rs.getString(4);
					String depature = rs.getString(5);

					

					
					Booking b = new Booking(id,name,packages,arrival,depature);
					book.add(b);
				}
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
			
			
			return book;
			
		}
		//Delete Booking
		public static boolean delete(String id) {
			int convertedID =Integer.parseInt(id);
			
			try {
				
				//DB CONNECTION
				con = DBConnect.getConnection();
				stmt = con.createStatement(); 
				String sql ="delete from booking where id ='"+convertedID+"'";
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
