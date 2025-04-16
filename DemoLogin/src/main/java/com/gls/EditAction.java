package com.gls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditAction
 */
@WebServlet("/EditAction")
public class EditAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAction() {
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
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		String id= req.getParameter("id");
		String bname= req.getParameter("bname"); 
		String bprice= req.getParameter("bprice");
    	try
		{
   Class.forName("com.mysql.cj.jdbc.Driver");
   //Connection con= DriverManager.getConnection("jdbc:mysql://128.66.203.247:3306/exam1","exam1","sumo@123");
   String updateSQL = "UPDATE book SET bname=?,bprice=? WHERE id=?";
   Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dkdb","root","root@123");
   PreparedStatement pst=  con.prepareStatement(updateSQL);
   pst.setString(1,bname);
   pst.setString(2,bprice);
   pst.setString(3,id);
   pst.executeUpdate();
   out.println("Book Updated");
   out.println("<a href =\"Validate\">Show Books</a>");
   System.out.print("Book Updated");
		}
    	catch(Exception e)
    	{
    		System.out.print(e);
    	}
	
	
	
	
	}

}
