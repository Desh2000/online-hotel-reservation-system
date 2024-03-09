package com.hotel_reservation;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnect {

    private static String url = "jdbc:mysql://localhost:3306/hotel_reservation";
    private static String user = "root";
    private static String pass = "isuru123";
    private static Connection con;

    public static Connection getConnection() {
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            //Singleton pattern
            con = DriverManager.getConnection(url, user,pass);
        } catch (Exception e) {
            System.out.println("Database connection is not successful !!!");
            e.printStackTrace(); // Print the error for debugging purposes
        }
        return con;
    }
}
