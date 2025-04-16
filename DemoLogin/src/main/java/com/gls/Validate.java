package com.gls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validate
 */
@WebServlet("/Validate")
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
    	PrintWriter out= res.getWriter();
    	try
		{
   Class.forName("com.mysql.cj.jdbc.Driver");
   //Connection con= DriverManager.getConnection("jdbc:mysql://128.66.203.247:3306/exam1","exam1","sumo@123");
   
   Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dkdb","root","root@123");
   PreparedStatement pst=  con.prepareStatement("Select * from book");
   ResultSet rs=  pst.executeQuery();
   while(rs.next())
   		{
	   String id=rs.getString(1);
	   String bname=rs.getString(2);
	   String bprice=rs.getString(3);
	   String linkUrl = "Details?bname=" + bname + "&bprice=" + bprice+ "&id=" + id;
       out.println("<html>");
       out.println("<body>");
       out.println("<a href='" + linkUrl + "'>" + bname + "</a>");
       out.println("</body>");
       out.println("</html>");
      }
   out.close();
		}//try end
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
	}
   
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String uname = req.getParameter("uname");
		String upass= req.getParameter("upass");
		{
			
			//System.out.println(uname);
			try
			{
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   //Connection con= DriverManager.getConnection("jdbc:mysql://128.66.203.247:3306/exam1","exam1","sumo@123");
	   Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dkdb","root","root@123");

	   PreparedStatement pst=  con.prepareStatement("Select * from user WHERE uname=? AND password=?");
	   
	   pst.setString(1,uname);
	   pst.setString(2,upass);
	   ResultSet rs=  pst.executeQuery();
	   
	   if (rs.next())
	        res.sendRedirect("success.jsp");

	   else
		   res.sendRedirect("error.jsp");  
			
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
	
		
	}
}
}
