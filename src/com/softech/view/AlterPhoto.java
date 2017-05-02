package com.softech.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlterPhoto
 */
@WebServlet("/AlterPhoto")
public class AlterPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterPhoto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<html><form  action=PhotoSubmit method=post enctype=\"multipart/form-data\">");
		  out.println("<table>");
		  out.println("<tr><td><b><i>Photograph:</i></b></td><td><input type=file name=upic size=40></td></tr>");
		  out.println("<tr><td><input type=submit></td><td><input type=reset></td></tr>");
		  out.println("</table></form></html>");
	}

}
