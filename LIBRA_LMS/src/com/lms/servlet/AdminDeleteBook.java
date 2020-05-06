package com.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.lms.dao.BooksDAO;
import com.lms.dto.BooksDTO;

/**
 * Servlet implementation class AdminDeleteBook
 */
@WebServlet("/AdminDeleteBook")
public class AdminDeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteBook() {
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
		
		 String isbn_input = JOptionPane.showInputDialog("Enter ISBN to delete");
		// System.out.println(isbn_input);
		 
		
			int input = JOptionPane.showConfirmDialog(null,"Do you want to proceed?", "Confirm Deletion..",JOptionPane.YES_NO_CANCEL_OPTION);
			// 0=yes, 1=no, 2=cancel
				
			System.out.println(input);
			
			if(input==0) {
				try {
					 BooksDTO booksDTO = new BooksDTO();
						
						booksDTO.setISBN(isbn_input);
						int query = BooksDAO.deleteBook(isbn_input);
						JOptionPane.showMessageDialog(null,"Books Deleted");
						response.sendRedirect("AdminSearchDisplay.jsp");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
			}
			}
			
			else if((input==-1) || (input==2) || (input==1))
			{
				JOptionPane.showMessageDialog(null,"Deletion Cancelled");
				response.sendRedirect("AdminSearchDisplay.jsp");
			}
				
				
			} 
			
			
		
	}


