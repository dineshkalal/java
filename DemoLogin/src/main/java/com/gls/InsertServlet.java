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
 * Servlet implementation class InsertServlet
 */
@WebServlet(name = "Insert", urlPatterns = { "/Insert" })
public class InsertServlet extends HttpServlet {
	
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		
		String bname= req.getParameter("bname"); 
		String bprice= req.getParameter("bprice");
    	try
		{
   Class.forName("com.mysql.cj.jdbc.Driver");
   //Connection con= DriverManager.getConnection("jdbc:mysql://128.66.203.247:3306/exam1","exam1","sumo@123");
   String insertSQL = "INSERT INTO book (bname, bprice) VALUES (?, ?)";
   Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dkdb","root","root@123");
   PreparedStatement pst=  con.prepareStatement(insertSQL);
   pst.setString(1,bname);
   pst.setString(2,bprice);
   pst.executeUpdate();
   out.println("Book Added into the database");
   out.println("<a href =\"Validate\">Show Books</a>");
   System.out.print("Book Added");
		}
    	catch(Exception e)
    	{
    		System.out.print(e);
    	}
		
	}

}
