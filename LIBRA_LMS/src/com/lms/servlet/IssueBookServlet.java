package com.lms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.lms.dao.BooksDAO;
import com.lms.dao.Issue_BookDAO;
import com.lms.dto.BooksDTO;
import com.lms.dto.Issue_BooksDTO;

/**
 * Servlet implementation class IssueBookServlet
 */
@WebServlet("/IssueBookServlet")
public class IssueBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssueBookServlet() {
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
		
		String s_id_input = JOptionPane.showInputDialog("Confirm your Member ID..");

		String member_id = request.getParameter("s_id_input");
		
		int id_input = Integer.parseInt(s_id_input);
		
		

		
		String isbn_input = JOptionPane.showInputDialog("Enter ISBN of book to issue");
		// System.out.println(isbn_input);
		 
		
			int input = JOptionPane.showConfirmDialog(null,"Do you want to proceed?", "Issue..",JOptionPane.YES_NO_CANCEL_OPTION);
			// 0=yes, 1=no, 2=cancel
				
			System.out.println(input);
			
			if(input==0) {
				try {
					if(Issue_BookDAO.checkISBN(isbn_input)) {
						Issue_BooksDTO issue_booksDTO = new Issue_BooksDTO();
						
						issue_booksDTO.setMember_id(id_input);
						
					 	Issue_BooksDTO.setISBN_issue(isbn_input);
					 	System.out.println(isbn_input);
						
					 	int query = Issue_BookDAO.insertIssue_Book(issue_booksDTO);
						JOptionPane.showMessageDialog(null,"Book Issued");
					}
					else {
						JOptionPane.showMessageDialog(null,"Book Not Found");

					}

					 
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
			}
			}
			
			else 
			{
				JOptionPane.showMessageDialog(null,"Deletion Cancelled");
				
			}
			response.sendRedirect("MemberSearchDisplay.jsp");
				
			} 
	}


