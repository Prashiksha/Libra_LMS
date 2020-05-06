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
 * Servlet implementation class MemberChangePassServlet
 */
@WebServlet("/MemberChangePassServlet")
public class MemberChangePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberChangePassServlet() {
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
		
		int memberid = Integer.parseInt(request.getParameter("memberid-changepass"));
		String old_pass = request.getParameter("oldpassword-changepass");
		String new_pass = request.getParameter("newpassword-changepass");
		String confirm_pass = request.getParameter("conpassword-changepasss");
		
		System.out.println(memberid);
		System.out.println(old_pass);
		System.out.println(new_pass);
		System.out.println(confirm_pass);
		
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setPassword(new_pass);
		memberDTO.setMember_id(memberid);
		
		try {
			if(MemberDAO.check_info(memberid, old_pass))
			{
				int query = MemberDAO.changePassword(memberDTO);
				System.out.println("UPDATED");
		        JOptionPane.showMessageDialog(null,"Password Changed!!");

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
