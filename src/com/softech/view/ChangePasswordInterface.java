package com.softech.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangePasswordInterface
 */
@WebServlet("/ChangePasswordInterface")
public class ChangePasswordInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordInterface() {
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
		out.println("<script src=assests/jquery-ui.min.js></script>");
		out.println("<script src=assests/jquery.validate.min.js></script>");
		out.println("<link rel=stylesheet type=text/css href=assests/jquery-ui.min.css>"); 
		out.println("<script src=assests/users.js></script>");
		out.println("<html>");
		out.println("<table width=50%>");
		out.println("<tr><td><b><i>Old Password:</i></b></td><td><input type=password name=op id=op></td></tr>");
		out.println("<tr><td><b><i>New Password:</i></b></td><td><input type=password name=up id=up></td></tr>");
		out.println("<tr><td><b><i>Confirm Password:</i></b></td><td><input type=password name=cup id=cup>&nbsp;&nbsp<img src='' id=im></td></tr>");
        out.println("<tr><td><input type=button value='Change Password' id='sbtn' name='sbtn'></td><td><input type=Reset></td></tr>");
		out.println("</table><br><br>");
		out.println("<span id=result><span>");
		out.print("</form></html>");
		out.flush();
	}

	

}
