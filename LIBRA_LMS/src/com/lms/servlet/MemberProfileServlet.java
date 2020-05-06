
package com.lms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.lms.dao.MemberDAO;
import com.lms.dto.MemberDTO;

/**
 * Servlet implementation class MemberProfileServlet
 */
@WebServlet("/MemberProfileServlet")
public class MemberProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberProfileServlet() {
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
		
		String s_userid_profile = request.getParameter("userid-profile");
		int userid_profile = Integer.parseInt(s_userid_profile);
		String username_profile = request.getParameter("username-profile");
		String password_profile = request.getParameter("password-profile");
		//String conpassword_register = request.getParameter("conpassword-register");
		String mobileno_profile = request.getParameter("mobile-profile");
		String email_profile = request.getParameter("email-profile");
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setMember_id(userid_profile);
		memberDTO.setMember_name(username_profile);
		memberDTO.setPassword(password_profile);
		memberDTO.setContact(mobileno_profile);
		memberDTO.setEmail(email_profile);
		
		//boolean status = false;
		
		try {
			if(MemberDAO.check_info(userid_profile, password_profile))
			{
				int query = MemberDAO.updateMemberInfo(memberDTO);
				System.out.println("UPDATED");
		        JOptionPane.showMessageDialog(null,"Information Updated!!");

			}
			else {
				System.out.println("NOT UPDATED");
		        JOptionPane.showMessageDialog(null,"Wrong ID/Password!!");
			}
			response.sendRedirect("MemberFile.jsp");

		
			}catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
