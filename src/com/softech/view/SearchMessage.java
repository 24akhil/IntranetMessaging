package com.softech.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchMessage
 */
@WebServlet("/SearchMessage")
public class SearchMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMessage() {
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
		out.println("<script src=assests/messages.js></script>");
		out.println("<html>");
		out.println("<input type=hidden name=mid value="+request.getParameter("mid")+" id=mid>");
		out.println("<span id=result></span>");
		out.println("</html>");
	}

}
