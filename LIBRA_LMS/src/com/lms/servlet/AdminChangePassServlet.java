package com.lms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.lms.dao.AdminDAO;
import com.lms.dto.AdminDTO;
/**
 * Servlet implementation class AdminChangePassServlet
 */
@WebServlet("/AdminChangePassServlet")
public class AdminChangePassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminChangePassServlet() {
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
		
		String username = request.getParameter("username-changepass");
		String old_pass = request.getParameter("oldpassword-changepass");
		String new_pass = request.getParameter("newpassword-changepass");
		//String con_pass = request.getParameter("username-changepass");
		
		System.out.println(username);
		System.out.println(old_pass);
		System.out.println(new_pass);
		
		AdminDTO adminDTO = new AdminDTO();
		
		adminDTO.setAdmin_name(username);
		adminDTO.setAdmin_password(new_pass);
		
		try {
			if(AdminDAO.admin_check_info(username, old_pass))
			{
				int query = AdminDAO.changeAdminPassword(adminDTO);
				System.out.println("UPDATED");
		        JOptionPane.showMessageDialog(null,"Password Changed!!");
			}
			else {
				System.out.println("NOT UPDATED");
		        JOptionPane.showMessageDialog(null,"Wrong Initial Credentials!!");
			
			}
			response.sendRedirect("AdminFile.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
