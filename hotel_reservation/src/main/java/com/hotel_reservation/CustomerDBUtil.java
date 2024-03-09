package com.hotel_reservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDBUtil {
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	//validation for login
 
public static boolean validate(String username,String password){
				
		try {
			//DB Connection
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from customer where username ='"+username+"' and password='"+password+"'";
			rs = stmt.executeQuery(sql);
			
			
			
			if(rs.next()) {
			isSuccess = true;
				
			}else {
				isSuccess = false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}

	//Get Customer Login

public static List<Customer> get(String username){
	
	
	ArrayList<Customer> cus = new ArrayList<>();
	
	try {
		
		//DB CONNECTION
		con =DBConnect.getConnection();
		stmt=con.createStatement();
		
		//SQL QUERY
		String sql ="select * from customer where username='"+username+"'";
		
		//RESULTSET
		rs=stmt.executeQuery(sql);
		
		
		while(rs.next()) {
			int id = rs.getInt(1);
			String firstname = rs.getString(2);
			String lastname = rs.getString(3);
			String NIC = rs.getString(4);
			String email = rs.getString(5);
			String phone = rs.getString(6);
			String user = rs.getString(7);
			String password = rs.getString(8);

			
		    Customer c = new Customer(id,firstname,lastname,NIC,email,phone,user,password);
			cus.add(c);
		}
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	return cus;
	
}

	// insert for Register

public static boolean insert(String firstname,String lastname,String NIC,String email,String phone,String username, String password) {
	
	boolean isSuccess = false;
	
	
	
	try {
		//DB Connection
		con = DBConnect.getConnection();
		stmt = con.createStatement(); 
		String sql = "insert into customer values(0,'"+firstname+"','"+lastname+"','"+NIC+"','"+email+"','"+phone+"','"+username+"','"+password+"')";
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

	//update Customer

public static boolean update(String id,String firstname,String lastname, String email,String phone ) {
	
	try {
		
		//DB CONNECTION
		con = DBConnect.getConnection();
		stmt = con.createStatement(); 
		String sql ="update customer set firstname='"+firstname+"',lastname='"+lastname+"',email='"+email+"',phone='"+phone+"'"  
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

	// view Customer
public static List<Customer> view(String Id){
	
	int convertedID =Integer.parseInt(Id);
	
	ArrayList<Customer> cus = new ArrayList<>();
	
	try {
		
		//DB CONNECTION
		con =DBConnect.getConnection();
		stmt=con.createStatement();
		
		//SQL QUERY
		String sql ="select * from customer where id='"+convertedID+"'";
		
		//RESULTSET
		rs=stmt.executeQuery(sql);
		
		
		while(rs.next()) {
			int id = rs.getInt(1);
			String firstname = rs.getString(2);
			String lastname = rs.getString(3);
			String NIC = rs.getString(4);
			String email = rs.getString(5);
			String phone = rs.getString(6);
			String username = rs.getString(7);
			String password = rs.getString(8);

			
		    Customer c = new Customer(id,firstname,lastname,NIC,email,phone,username,password);
			cus.add(c);
		}
	}
	
	catch(Exception e) {
		e.printStackTrace();
	}
	
	
	return cus;
	
}

	//Delete Customer
public static boolean delete(String id) {
	int convertedID =Integer.parseInt(id);
	
	try {
		
		//DB CONNECTION
		con = DBConnect.getConnection();
		stmt = con.createStatement(); 
		String sql ="delete from customer where id ='"+convertedID+"'";
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
