package com.gls;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditBook
 */
@WebServlet("/EditBook")
public class EditBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out= res.getWriter();
		out.println("Edit Book");
		String id = req.getParameter("id");
		String bname = req.getParameter("bname");
        String bprice = req.getParameter("bprice");
        out.println(bname);
        out.println("<form action='EditAction' method='POST'>");
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+id+"'/></td></tr>");  
        out.print("<tr><td>Book Name:</td><td><input type='text' name='bname' value='"+bname+"'/></td></tr>");  
        out.print("<tr><td>Price:</td><td><input type='text' name='bprice' value='"+bprice+"'/></td></tr>"); 
        out.println("<tr><td></td><td><input type='submit'value='EditBook'></td>");
        out.println("</table></form>");
        
        
        
	}

}
