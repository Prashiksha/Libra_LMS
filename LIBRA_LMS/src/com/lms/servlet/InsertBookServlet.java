package com.lms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.lms.dao.BooksDAO;
import com.lms.dto.BooksDTO;

/**
 * Servlet implementation class InsertBookServlet
 */
@WebServlet("/InsertBookServlet")
public class InsertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		int save =0;
		
		String ISBN = request.getParameter("ISBN");
		String book_title = request.getParameter("book_title");
		String author = request.getParameter("author");
		
		String language = request.getParameter("language");
		String genre = request.getParameter("genre");
		String cost_string = request.getParameter("cost");
		int cost = Integer.parseInt(cost_string);
		String quantity_initial_string = request.getParameter("quantity_initial");
		int quantity_initial = Integer.parseInt(quantity_initial_string);
		
		
		BooksDTO booksDTO = new BooksDTO();
		
		booksDTO.setISBN(ISBN);
		booksDTO.setBook_title(book_title);
		booksDTO.setAuthor(author);
		booksDTO.setGenre(genre);
		booksDTO.setCost(cost);
		booksDTO.setLanguage(language);
		booksDTO.setQuantity_initial(quantity_initial);
		
		try {
			save = BooksDAO.insertBook(booksDTO);
			System.out.println("INSERTED");
			JOptionPane.showMessageDialog(null,"Book Added..");
			response.sendRedirect("AdminFile.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("NOT INSERTED");
		}

	}

}
