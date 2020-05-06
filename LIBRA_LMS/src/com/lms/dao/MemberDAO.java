package com.lms.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.lang.Exception;
import java.util.List;
import java.util.UUID;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.String;

import com.lms.dto.BooksDTO;
import com.lms.dto.MemberDTO;
import com.lms.util.DBConnection;

public class MemberDAO {
	
	private static final String Q_SELECT_ALL_BOOKS_BY_ID = "select ISBN, book_title, author, genre, language, cost from Books where ISBN in (select book_borrowed_isbn from Member where member_id=?)";

	private static final String Q_INSERT_INTO_MEMBER = "insert into Member (member_id, member_name, password, contact, email) values (?, ?, ?, ?, ?)";

	private static final String Q_UPDATE_MEMBER_INFO = "update Member set member_name=?, contact=?, email=? where member_id = ?";

	private static final String Q_UPDATE_PASSWORD = "update Member set password=? where member_id = ?";

	private static final String Q_CHECK_AVAILABILITY = "select quantity_current from Books where isbn = ?" ;
	
	private static final String Q_LOGIN = "select * from Member where member_name=? and password=?";
	
	private static final String Q_CHECK_INFO = "select * from Member where member_id=? and password=?";
	
	private static final String Q_GET_ID = "select member_id from Member where member_name=? and password=?";



	
	public static List<BooksDTO> searchIssuedBookByMemberId(String id) throws Exception {


		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBConnection.getConnection();
		List<BooksDTO> booksDTOList = new ArrayList<>();

		pstmt = conn.prepareStatement(Q_SELECT_ALL_BOOKS_BY_ID);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			BooksDTO booksDTO = new BooksDTO();

			booksDTO.setISBN(rs.getString("ISBN"));
			booksDTO.setBook_title(rs.getString("book_title"));
			booksDTO.setAuthor(rs.getString("author"));
			booksDTO.setGenre(rs.getString("genre"));
			booksDTO.setCost(rs.getInt("cost"));
			booksDTO.setLanguage(rs.getString("language"));
			//booksDTO.setShelf_number(rs.getInt("shelf_number"));
			//booksDTO.setQuantity_initial(rs.getInt("quantity_initial"));
			//booksDTO.setQuantity_current(rs.getInt("quantity_current"));
			booksDTOList.add(booksDTO);

		}
		//DBConnection.closeConnection();

		return booksDTOList;
	}
		
	public static int generate_id() {
		UUID idOne = UUID.randomUUID();
        String str=""+idOne;        
        int uid=str.hashCode();
        String filterStr=""+uid;
        str=filterStr.replaceAll("-", "");
        return Integer.parseInt(str);
	}

	public static int id = generate_id();
	
	
	public static int registerUser(MemberDTO memberDTO) throws Exception {
		
		
		int count = 0;
		
		
        
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DBConnection.getConnection();
	
		pstmt = conn.prepareStatement(Q_INSERT_INTO_MEMBER);

		pstmt.setFloat(1, id);
		pstmt.setString(2, memberDTO.getMember_name());
		pstmt.setString(3, memberDTO.getPassword());
		pstmt.setString(4, memberDTO.getContact());
		pstmt.setString(5, memberDTO.getEmail());
		//pstmt.setString(6, memberDTO.getBook_borrowed_isbn());
		//pstmt.setString(7, memberDTO.getIssue_date());
		//pstmt.setString(8, memberDTO.getReturn_date());
		
		
		//id++;
		count = pstmt.executeUpdate();
		//DBConnection.closeConnection();
		return count;

	}
	
	public static int updateMemberInfo(MemberDTO memberDTO) throws Exception {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DBConnection.getConnection();
		pstmt = conn.prepareStatement(Q_UPDATE_MEMBER_INFO);

		pstmt.setString(1, memberDTO.getMember_name());
		pstmt.setString(2, memberDTO.getContact());
		pstmt.setString(3, memberDTO.getEmail());
		pstmt.setInt(4, memberDTO.getMember_id());

		count = pstmt.executeUpdate();
		DBConnection.closeConnection();
		return count;
		
	}
	
	public static int changePassword(MemberDTO memberDTO) throws Exception {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DBConnection.getConnection();
		pstmt = conn.prepareStatement(Q_UPDATE_PASSWORD);

		pstmt.setString(1, memberDTO.getPassword());
		pstmt.setInt(2, memberDTO.getMember_id());

		count = pstmt.executeUpdate();
		//DBConnection.closeConnection();
		return count;
		
	}
	
	public static boolean checkAvailability(String isbn) throws SQLException
	{
		int quantity = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBConnection.getConnection();

		pstmt = conn.prepareStatement(Q_CHECK_AVAILABILITY);
		pstmt.setString(1, isbn);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			quantity = rs.getInt("quantity_current");
		}
		
		if(quantity > 0) return true;
		else return false;
		
	}


	public static boolean login(String member_name, String password) throws Exception {

		boolean status = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBConnection.getConnection();

		pstmt = conn.prepareStatement(Q_LOGIN);
		pstmt.setString(1, member_name);
		pstmt.setString(2, password);
		rs = pstmt.executeQuery();
		status = rs.next();
		return status;

	}
	
	public static boolean check_info(int member_id, String password) throws Exception {

		boolean status = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBConnection.getConnection();

		pstmt = conn.prepareStatement(Q_CHECK_INFO);
		pstmt.setInt(1, member_id);
		pstmt.setString(2, password);

		rs = pstmt.executeQuery();
		status = rs.next();
		return status;

	}
	
	public static int get_user_id(String member_name, String password) throws Exception {

		int id = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBConnection.getConnection();

		pstmt = conn.prepareStatement(Q_GET_ID);
		
		pstmt.setString(1, member_name);
		pstmt.setString(2, password);

		rs = pstmt.executeQuery();
		rs.next();
		id = rs.getInt(1);
		
		return id;

	}

}