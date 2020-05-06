package com.lms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.lms.dao.Issue_BookDAO;
import com.lms.dto.Issue_BooksDTO;

/**
 * Servlet implementation class ReturnBookServlet
 */
@WebServlet("/ReturnBookServlet")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBookServlet() {
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
		
		String s_id_input = JOptionPane.showInputDialog("Confirm Member ID..");
		int id_input = Integer.parseInt(s_id_input);
		
		
		String isbn_input = JOptionPane.showInputDialog("Enter ISBN of book to return");
		// System.out.println(isbn_input);
		 
		
			int input = JOptionPane.showConfirmDialog(null,"Confirm Return?", "Return..",JOptionPane.YES_NO_CANCEL_OPTION);
			// 0=yes, 1=no, 2=cancel
				
			System.out.println(input);
			
			if(input==0) {
				try {
					if(Issue_BookDAO.checkReturnBook(isbn_input, id_input)) {
						Issue_BooksDTO issue_booksDTO = new Issue_BooksDTO();
						
						Issue_BooksDTO.setISBN_issue(isbn_input);
						issue_booksDTO.setMember_id(id_input);
						
						
						
					 	int query = Issue_BookDAO.return_delete(id_input, isbn_input);
						JOptionPane.showMessageDialog(null,"Book Returned");
						//response.sendRedirect("MemberSearchDisplay.jsp");
					}
					else {
						JOptionPane.showMessageDialog(null,"Try Again..");
						//response.sendRedirect("MemberSearchDisplay.jsp");

					}

					 
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
			}
			}
			
			else 
			{
				JOptionPane.showMessageDialog(null,"Return Cancelled");
				
			}
			response.sendRedirect("MemberSearchDisplay.jsp");				
			} 
	}


