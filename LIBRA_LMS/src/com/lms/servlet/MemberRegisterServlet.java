
package com.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.lms.dao.MemberDAO;
import com.lms.dto.MemberDTO;

/**
 * Servlet implementation class MemberRegisterServlet
 */
@WebServlet("/MemberRegisterServlet")
public class MemberRegisterServlet extends HttpServlet {
	
	//static int id = 1001;
	
	private static final long serialVersionUID = 1L;

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
		
		PrintWriter out = response.getWriter();  
		
		String username_register = request.getParameter("username-register");
		String password_register = request.getParameter("password-register");
		//String conpassword_register = request.getParameter("conpassword-register");
		String mobileno_register = request.getParameter("mobileno-register");
		String email_register = request.getParameter("email-register");
		
		int member_id = MemberDAO.id;
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setMember_name(username_register);
		memberDTO.setPassword(password_register);
		memberDTO.setContact(mobileno_register);
		memberDTO.setEmail(email_register);
		
		
		try {
			int query = MemberDAO.registerUser(memberDTO);
			System.out.println("REGISTERED");
            //JOptionPane.showInputDialog(member_id);
           
            JOptionPane.showMessageDialog(null, "Login with your member ID : " +member_id);
			response.sendRedirect("FrontFile.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("NOT REGISTERED");
		}
		
		
		/*try {
			int query_id = MemberDAO.get_user_id(username_register, password_register);
			System.out.println(query_id);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/

		
		
	}

}
