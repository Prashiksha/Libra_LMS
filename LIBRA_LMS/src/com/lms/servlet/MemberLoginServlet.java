
package com.lms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.lms.dao.MemberDAO;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
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
		
		//boolean status = false;
		
		String username_member = request.getParameter("username-member");
		String password_member = request.getParameter("password-member");
		int id=0;
		//String name= "pjain";
		//String pass = "prashjain";
		
		System.out.println(username_member);
		System.out.println(password_member);
		
		
		try {
			if(MemberDAO.login(username_member, password_member)) {
				
				id = MemberDAO.get_user_id(username_member, password_member);
				
				HttpSession session = request.getSession();
				session.setAttribute("username_member", username_member);
				//response.sendRedirect("MemberPage.html");
				request.setAttribute("username_member", username_member);
				request.setAttribute("id", id);

				request.getRequestDispatcher("MemberFile.jsp").forward(request, response);
				//response.sendRedirect("MemberFile.jsp");
				
				request.setAttribute("id",id);
				RequestDispatcher rd = request.getRequestDispatcher("SearchBookMemberServlet");
				rd.forward(request,response);
				

			} else {
				// out.println(" incorrect email or password");
				JOptionPane.showMessageDialog(null,"Incorrect Username/Password..");
				response.sendRedirect("FrontFile.jsp");

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	

}
