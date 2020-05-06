package com.lms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lms.dao.MemberDAO;
import com.lms.dto.BooksDTO;
import com.lms.dto.MemberDTO;

/**
 * Servlet implementation class ViewOrderServlet
 */
@WebServlet("/ViewOrderServlet")
public class ViewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String id = request.getParameter("member-id");
		System.out.println(id);
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		 java.sql.PreparedStatement ps = null;
		// java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Libra","prashiksha","jain1010");
		
		
		try {
			//java.util.List<BooksDTO> list= MemberDAO.searchIssuedBookByMemberId(id);
			
			Class.forName("com.mysql.jdbc.Driver");
	        java.sql.PreparedStatement ps1 = null;
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Libra","prashiksha","jain1010");
			ps1=con.prepareStatement("select member_id, ISBN_issue, issue_date, return_date  from Issue_Books where member_id=?;");  
			ps1.setString(1,id);  

			request.getRequestDispatcher("AdminSearchDisplay.jsp").include(request, response);

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
			//out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getInt(6)+"</td></tr>");  
			out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getDate(3)+"</td><td>"+rs.getDate(4)+"</td></tr>");  
              
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
