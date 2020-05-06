package com.lms.dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.lang.Exception;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.lang.String;
import com.lms.dto.BooksDTO;
import com.lms.util.DBConnection;

public class BooksDAO {

	
	    /*QUERY FOR ADDING BOOK IN BOOKS TABLE*/
		
		private static final String Q_INSERT_INTO_BOOKS = "insert into Books (ISBN, book_title, author, language, genre, cost, quantity_initial) values (?, ?, ?, ?, ?, ?, ?)";

		/*QUERIES FOR UPDATING BOOK DETAILS IN BOOKS TABLE*/
		
		private static final String Q_UPDATE_INTO_BOOKS = "update Books set book_title=?, author=?, cost=?, quantity_initial=? where ISBN = ?";

		/*QUERIES FOR SEARCHING IN BOOKS TABLE*/
		
		private static final String Q_SELECT_ALL_BOOKS_BY_ISBN = "select * from Books where ISBN=?";
		
		private static final String Q_SELECT_ALL_BOOKS_BY_AUTHOR = "select * from Books where author=?";

		private static final String Q_SELECT_ALL_BOOKS_BY_TITLE = "select * from Books where book_title=?";

		private static final String Q_SELECT_ALL_BOOKS_BY_GENRE = "select * from Books where genre=?";

		private static final String Q_SELECT_ALL_BOOKS = "select * from Books";

		/*QUERIES FOR DELETING BOOK DETAILS IN BOOKS TABLE*/
		
		private static final String Q_DELETE_BOOK_BY_ISBN = "delete from Books where ISBN=?";


		public static int insertBook(BooksDTO booksDTO) throws Exception {
			int count = 0;

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(Q_INSERT_INTO_BOOKS);

			pstmt.setString(1, booksDTO.getISBN());
			pstmt.setString(2, booksDTO.getBook_title());
			pstmt.setString(3, booksDTO.getAuthor());
			pstmt.setString(4, booksDTO.getLanguage());
			pstmt.setString(5, booksDTO.getGenre());
			pstmt.setInt(6, booksDTO.getCost());
			pstmt.setInt(7, booksDTO.getQuantity_initial());
			//pstmt.setInt(7, booksDTO.getShelf_number());
			
			//pstmt.setInt(9, booksDTO.getQuantity_current());

			count = pstmt.executeUpdate();
			//DBConnection.closeConnection();
			return count;

		}

		public static BooksDTO searchBookByISBN(String isbn) throws Exception {

			BooksDTO booksDTO = new BooksDTO();

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			conn = DBConnection.getConnection();

			pstmt = conn.prepareStatement(Q_SELECT_ALL_BOOKS_BY_ISBN);
			pstmt.setString(1, isbn);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				booksDTO.setISBN(rs.getString("ISBN"));
				booksDTO.setBook_title(rs.getString("book_title"));
				booksDTO.setAuthor(rs.getString("author"));
				booksDTO.setGenre(rs.getString("genre"));
				booksDTO.setCost(rs.getInt("cost"));
				booksDTO.setLanguage(rs.getString("language"));
				//booksDTO.setShelf_number(rs.getInt("shelf_number"));
				booksDTO.setQuantity_initial(rs.getInt("quantity_initial"));
				//booksDTO.setQuantity_current(rs.getInt("quantity_current"));
			}
			//DBConnection.closeConnection();

			return booksDTO;
		}
		
		public static BooksDTO searchBookByTitle(String title) throws Exception {

			BooksDTO booksDTO = new BooksDTO();

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			conn = DBConnection.getConnection();

			pstmt = conn.prepareStatement(Q_SELECT_ALL_BOOKS_BY_TITLE);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				booksDTO.setISBN(rs.getString("ISBN"));
				booksDTO.setBook_title(rs.getString("book_title"));
				booksDTO.setAuthor(rs.getString("author"));
				booksDTO.setGenre(rs.getString("genre"));
				booksDTO.setCost(rs.getInt("cost"));
				booksDTO.setLanguage(rs.getString("language"));
				//booksDTO.setShelf_number(rs.getInt("shelf_number"));
				booksDTO.setQuantity_initial(rs.getInt("quantity_initial"));
				//booksDTO.setQuantity_current(rs.getInt("quantity_current"));
			}
			//DBConnection.closeConnection();

			return booksDTO;
		}
		
		public static List<BooksDTO> searchBookByAuthor(String author) throws Exception {


			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			conn = DBConnection.getConnection();
			List<BooksDTO> booksDTOList = new ArrayList<>();


			pstmt = conn.prepareStatement(Q_SELECT_ALL_BOOKS_BY_AUTHOR);
			pstmt.setString(1, author);
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
				booksDTO.setQuantity_initial(rs.getInt("quantity_initial"));
				//booksDTO.setQuantity_current(rs.getInt("quantity_current"));
				booksDTOList.add(booksDTO);

			}
			//DBConnection.closeConnection();
			return booksDTOList;
		}
		
		public static List<BooksDTO> searchBookByGenre(String genre) throws Exception {

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			conn = DBConnection.getConnection();

			List<BooksDTO> booksDTOList = new ArrayList<>();

			pstmt = conn.prepareStatement(Q_SELECT_ALL_BOOKS_BY_GENRE);
			pstmt.setString(1, genre);
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
				booksDTO.setQuantity_initial(rs.getInt("quantity_initial"));
				//booksDTO.setQuantity_current(rs.getInt("quantity_current"));
				booksDTOList.add(booksDTO);
			}
			//DBConnection.closeConnection();

			return booksDTOList;
		}		

		public static List<BooksDTO> getAllBooks() throws Exception {

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			conn = DBConnection.getConnection();
			List<BooksDTO> booksDTOList = new ArrayList<>();
			pstmt = conn.prepareStatement(Q_SELECT_ALL_BOOKS);
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
				booksDTO.setQuantity_initial(rs.getInt("quantity_initial"));
				//booksDTO.setQuantity_current(rs.getInt("quantity_current"));
				booksDTOList.add(booksDTO);
				
			}
			//DBConnection.closeConnection();

			return booksDTOList;

		}


		public static int deleteBook(String isbn) throws Exception {

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			conn = DBConnection.getConnection();

			pstmt = conn.prepareStatement(Q_DELETE_BOOK_BY_ISBN);
			pstmt.setString(1, isbn);
			int i = pstmt.executeUpdate();

			//DBConnection.closeConnection();

			return i;
			
		}
		
		public static int updateBooks(BooksDTO booksDTO) throws Exception {
			int count = 0;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(Q_UPDATE_INTO_BOOKS);

			pstmt.setString(1, booksDTO.getBook_title());
			pstmt.setString(2, booksDTO.getAuthor());
			//pstmt.setString(3, booksDTO.getGenre());
			pstmt.setInt(3, booksDTO.getCost());
			//pstmt.setString(5, booksDTO.getLanguage());
			//pstmt.setInt(6, booksDTO.getShelf_number());
			pstmt.setInt(4, booksDTO.getQuantity_initial());
			//pstmt.setInt(8, booksDTO.getQuantity_current());
			pstmt.setString(5, booksDTO.getISBN());

			count = pstmt.executeUpdate();
			//DBConnection.closeConnection();
			return count;

		}
		
}