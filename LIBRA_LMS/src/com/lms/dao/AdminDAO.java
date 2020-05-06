package com.lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lms.dto.AdminDTO;
import com.lms.util.DBConnection;

public class AdminDAO {
	
	private static final String Q_ADMIN_LOGIN = "select * from Admin where admin_name=? and admin_password=?";

	private static final String Q_UPDATE_ADMIN_PASSWORD = "update Admin set admin_password=? where admin_name = ?";

	private static final String Q_CHECK_INFO = "select * from Admin where admin_name=? and admin_password=?";
	
	
	public static boolean login(String admin_name, String admin_password) throws Exception {

		boolean status = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBConnection.getConnection();

		pstmt = conn.prepareStatement(Q_ADMIN_LOGIN);
		pstmt.setString(1, admin_name);
		pstmt.setString(2, admin_password);
		rs = pstmt.executeQuery();
		status = rs.next();
		return status;

	}
	
	
	public static int changeAdminPassword(AdminDTO adminDTO) throws Exception {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = DBConnection.getConnection();
		pstmt = conn.prepareStatement(Q_UPDATE_ADMIN_PASSWORD);

		pstmt.setString(1, adminDTO.getAdmin_password());
		pstmt.setString(2, adminDTO.getAdmin_name());

		count = pstmt.executeUpdate();
		//DBConnection.closeConnection();
		return count;
		
	}
	
	public static boolean admin_check_info(String admin_name, String admin_password) throws Exception {

		boolean status = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBConnection.getConnection();

		pstmt = conn.prepareStatement(Q_CHECK_INFO);
		pstmt.setString(1, admin_name);
		pstmt.setString(2, admin_password);

		rs = pstmt.executeQuery();
		status = rs.next();
		return status;

	}

}
