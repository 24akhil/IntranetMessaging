package com.softech.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SentMail
 */
@WebServlet("/SentMail")
public class SentMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SentMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<script src=assests/jquery-2.2.1.min.js></script>");
		out.println("<link rel=stylesheet type=text/css href=assests/jquery-ui.min.css></link>");
		out.println("<script src=assests/jquery-ui.min.js></script>");
		out.println("<script src=assests/jquery.validate.min.js></script>");
		out.println("<script src=assests/sentmail.js></script>");
		out.println("<html>");
		out.println("<center>");
		out.println("<input type=text size=100 placeholder='Search' id=stxt name=stxt><br><br>");
		out.println("</center>");
		out.println("<form action=RemoveMessages>");	
		out.println("<input type=submit value='Delete' name=btn>&nbsp;&nbsp;<input type=submit value='Trash' name=btn>");
		out.println("<center>");
		out.print("<span id=result></span>");
		out.println("</center>");
		out.println("<input type=hidden value=1 name=hdn>");
		out.println("</form>");
		out.println("</center>");
		out.println("</html>");
		out.flush();
		

	
	
	
	
	}

	

}
