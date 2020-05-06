package com.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class ViewIssuedBooksServlet
 */
@WebServlet("/ViewIssuedBooksServlet")
public class ViewIssuedBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewIssuedBooksServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String s_id_input = JOptionPane.showInputDialog("Confirm your Member ID..");

		String member_id = request.getParameter("s_id_input");
		
		int id_input = Integer.parseInt(s_id_input);
		
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		 java.sql.PreparedStatement ps = null;
		// java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Libra","prashiksha","jain1010");
		
		
		try {
			//java.util.List<BooksDTO> list= MemberDAO.searchIssuedBookByMemberId(id);
			
			
			
			
			
			Class.forName("com.mysql.jdbc.Driver");
	        java.sql.PreparedStatement ps1 = null;
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Libra","prashiksha","jain1010");
			ps1=con.prepareStatement("select * from Issue_Books where member_id=?;");  
			ps1.setInt(1,id_input);  

			request.getRequestDispatcher("MemberSearchDisplay.jsp").include(request, response);

			 //out.println("<body background=\"images/logo.svg\">\n" + "");
			out.print("<table width=50% border=1 bgcolor=\"white\" align=\"center\">"); 
			  
			java.sql.ResultSet rs=ps1.executeQuery();  
			              
			//request.getRequestDispatcher("AdminPage.js").include(request, response);

			
			/* Printing column names */  
			java.sql.ResultSetMetaData rsmd=rs.getMetaData();  
			int total=rsmd.getColumnCount();  
			out.print("<tr>");  
			for(int i=1;i<=total;i++)  
			{  
			out.print("<th>"+rsmd.getColumnName(i)+"</th>");  
			}  
			  
			out.print("</tr>");  
			              
			/* Printing result */  
			  
			while(rs.next())  
			{  
			out.print("<tr><td>"+rs.getDate(1)+"</td><td>"+rs.getInt(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getDate(4)+"</td></tr>");  
			                  
			}  
			  
			out.print("</table>");  
			out.print("</body>");  
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
