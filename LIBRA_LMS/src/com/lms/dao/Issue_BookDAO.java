package com.lms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.lms.dto.Issue_BooksDTO;
import com.lms.util.DBConnection;

public class Issue_BookDAO {
	
	private static final String Q_INSERT_INTO_ISSUE_BOOKS = "insert into Issue_Books (return_date, member_id, ISBN_issue, issue_date) values (?, ?, ?, ?)";

	private static final String Q_VALID_ISBN = "select * from Books where ISBN=?";
	
	private static final String Q_RETURN_ISBN = "select * from Issue_Books where ISBN_issue=? and member_id=?";
	
	private static final String Q_VALID_ID = "select * from Member where member_id=?";
	
	private static final String Q_DELETE_FROM_ISSUE_BOOKS = "delete from Issue_Books where member_id=? and ISBN_issue=?";


	
	public static Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        return new Date(c.getTimeInMillis());
    }
	
	public static long difference_in_days(Date return_date) {
		
		long millis=System.currentTimeMillis(); 
		java.sql.Date current_date=new java.sql.Date(millis);
		
		long diff = return_date.getTime() - current_date.getTime();

		return diff;
		
	}
	public static  int insertIssue_Book(Issue_BooksDTO issue_booksDTO) throws Exception {
		int count = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DBConnection.getConnection();
		pstmt = conn.prepareStatement(Q_INSERT_INTO_ISSUE_BOOKS);

		//int member_id = MemberDAO.id;
		
		long millis=System.currentTimeMillis();  
		
        java.sql.Date issue_date=new java.sql.Date(millis);
		//System.out.println(issue_date);
		
		java.sql.Date return_date = addDays(issue_date, 7);
		//System.out.println(return_date);

		pstmt.setDate(1, return_date);
		pstmt.setInt(2, issue_booksDTO.getMember_id() );
		pstmt.setString(3, issue_booksDTO.getISBN_issue());
		pstmt.setDate(4, issue_date);
		

		count = pstmt.executeUpdate();
		//DBConnection.closeConnection();
		return count;

	}
	
	public static boolean checkISBN(String isbn) throws SQLException
	{
		//int quantity = 0;
		boolean status = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBConnection.getConnection();

		pstmt = conn.prepareStatement(Q_VALID_ISBN);
		pstmt.setString(1, isbn);
		rs = pstmt.executeQuery();
		
		status = rs.next();
		
		return status;
		
	}
	
	public static boolean checkID(int id) throws SQLException
	{
		
		boolean status = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBConnection.getConnection();

		pstmt = conn.prepareStatement(Q_VALID_ID);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		
		status = rs.next();
		
		return status;
		
	}
	
	public static boolean checkReturnBook(String ISBN, int id) throws SQLException
	{
		
		boolean status = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBConnection.getConnection();

		pstmt = conn.prepareStatement(Q_RETURN_ISBN);
		pstmt.setString(1, ISBN);
		pstmt.setInt(2, id);
		rs = pstmt.executeQuery();
		
		status = rs.next();
		
		return status;
		
	}

	public static int return_delete(int id, String isbn) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBConnection.getConnection();
		
		pstmt = conn.prepareStatement(Q_DELETE_FROM_ISSUE_BOOKS);
		pstmt.setInt(1, id);
		pstmt.setString(2, isbn);
		int i = pstmt.executeUpdate();

		//DBConnection.closeConnection();

		return i;
		
	}


}
