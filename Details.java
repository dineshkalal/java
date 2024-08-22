package com.gls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Details
 */
@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = res.getWriter();
		String id = req.getParameter("id");
		String bname = req.getParameter("bname");
        String bprice = req.getParameter("bprice");
        
        // Display the received variables
        out.println("<html>");
        out.println("<body> <center>");
        out.println("<h1>Book Name: " + bname + "</h1>");
        out.println("<h1>Book Price: " + bprice + "</h1>");
        
        
        String delUrl="Delete?id="+id;
        out.println("<a href='" + delUrl + "'>" + "Delete" + "</a>");
        
        String editUrl="EditBook?id="+id+"&bname="+bname+"&bprice="+bprice;
        out.println("<a href='" + editUrl + "'>" + "Edit" + "</a>");
        
        String linkUrl="login.jsp";                
        out.println("<a href='" + linkUrl + "'>" + "Home" + "</a>");
        
        out.println("</center></body>");
        out.println("</html>");
        
        out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
