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
 * Servlet implementation class SearchBookMemberServlet
 */
@WebServlet("/SearchBookMemberServlet")
public class SearchBookMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBookMemberServlet() {
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
		
		String option = request.getParameter("issueBook-searchBook");
		String input = request.getParameter("search_input_member");
		
		String id = (String)request.getAttribute("id");
		
		System.out.println("option");
		System.out.println(option);
		System.out.println("Input");
		System.out.println(input);
		
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		
			try{  
				//Class.forName("oracle.jdbc.driver.OracleDriver");  
		        Class.forName("com.mysql.jdbc.Driver");
		        java.sql.PreparedStatement ps = null;
				//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
				java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Libra","prashiksha","jain1010");
		       // JOptionPane.showMessageDialog(null,"Connection Successful!!");

				if(option.equals("isbn"))
				{
					ps=con.prepareStatement("select * from Books where ISBN=?");  
					ps.setString(1,input);  

				}
				
				else if(option.equals("author"))
				{
					ps=con.prepareStatement("select * from Books where author=?");  
					ps.setString(1,input);  

				}
				
				else if(option.equals("title"))
				{
					 ps=con.prepareStatement("select * from Books where book_title=?");  
					ps.setString(1,input);  

				}
				
				else if(option.equals("genre"))
				{
					ps=con.prepareStatement("select * from Books where genre=?");  
					ps.setString(1,input);  

				}
				
				else if(option.equals(null))
					response.sendRedirect("MemberPage.jsp");
				
				request.getRequestDispatcher("MemberSearchDisplay.jsp").include(request, response);

			    //out.println("<body background=\"images/logo.svg\">\n" + "");
				out.print("<table width=50% border=1 bgcolor=\"white\" align=\"center\">"); 
				
				  
				java.sql.ResultSet rs=ps.executeQuery();  
				              
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
				out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getInt(6)+"</td><td>"+rs.getInt(7)+"</td></tr>");  
				                  
				}  
				  
				out.print("</table>");  
				out.print("</body>");  

				              
				}catch (Exception e2) {e2.printStackTrace();}  
				          
				finally{out.close();}  
		}
	}


