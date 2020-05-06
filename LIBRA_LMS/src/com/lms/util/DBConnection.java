package com.lms.util;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;

import javax.swing.JOptionPane;


public class DBConnection {
	
	private static Connection conn;
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver loaded successfully");
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Libra","prashiksha","jain1010");
             //JOptionPane.showMessageDialog(null,"Connection Successful!!");
            
        }
        catch(Exception ex){
                ex.printStackTrace();
                
                //JOptionPane.showMessageDialog(null,"Connection UnSuccessful........!!");
      
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try{
            conn.close();
         //JOptionPane.showMessageDialog(null,"disconnected Successfully!!");
      
        }
        catch(Exception ex){
             //JOptionPane.showMessageDialog(null,"disconnection UnSuccessful!!");
      
          ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) throws Exception {
    	
    	//System.out.println(getConnection());
    	/*
         * 
         * ***Main method only to check insertion of data in db directly from here***
         * 
        Statement stmt = null;
        System.out.println("Inserting records into the table...");
        try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        String sql = "INSERT INTO Books " +
                     "VALUES ('9783161484100', 'title', 'author', 'genre', 200, 'Hindi', 2, 100, 50)";
        try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*** To check DAO and DTO ***
		BooksDTO booksDTO = new BooksDTO();
    	int x = BooksDAO.insertBook(booksDTO);
    	System.out.println(x);
     	*/
		}  

}
