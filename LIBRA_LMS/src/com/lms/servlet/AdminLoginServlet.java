
package com.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.lms.dao.AdminDAO;


/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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
		//response.sendRedirect("MemberPage.html");
		//PrintWriter out = response.getWriter();
		
		

		String username_admin = request.getParameter("username-admin");
		String password_admin = request.getParameter("password-admin");
		
		//String name= "pjain";
		//String pass = "prashjain";
		
		System.out.println(username_admin);
		System.out.println(password_admin);

		
		try {
			if(  AdminDAO.login(username_admin, password_admin)) {

				HttpSession session = request.getSession();
				session.setAttribute("username_admin", username_admin);
				response.sendRedirect("AdminFile.jsp");

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
