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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();		
		String id= req.getParameter("id");
		out.println("Delete operation for Book ID:"+id);
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dkdb","root","root@123");
			  PreparedStatement pst=  con.prepareStatement("Delete from book where id="+id);
			  pst.executeUpdate();
			  out.println("Books Deleted");
			  String linkUrl="Validate";                
		      out.println("<br> <a href='" + linkUrl + "'>" + "Home" + "</a>");
			  
		}
		catch(Exception e)
    	{
    		System.out.println(e);
    	}
		
	}

}
