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
import com.lms.dto.MemberDTO;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookServlet() {
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
		
		String isbn = request.getParameter("isbn-updateBook");
		String title = request.getParameter("title-updateBook");
		String author = request.getParameter("author-updateBook");
		String s_cost = request.getParameter("cost-updateBook");
		String s_quantity = request.getParameter("quantity-updateBook");
		
		int cost = Integer.parseInt(s_cost);
		int quantity = Integer.parseInt(s_quantity);

		
		//System.out.println(isbn);
		
		BooksDTO booksDTO = new BooksDTO();
		
		booksDTO.setISBN(isbn);
		booksDTO.setBook_title(title);
		booksDTO.setAuthor(author);
		booksDTO.setCost(cost);
		booksDTO.setQuantity_initial(quantity);
		
		try {
			int query = BooksDAO.updateBooks(booksDTO);
			System.out.println("BOOK UPDATED");
	        JOptionPane.showMessageDialog(null,"Book Updated!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("AdminSearchDisplay.jsp");
		



	}

}
