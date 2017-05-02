package com.softech.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsersRegistrationInterface
 */
@WebServlet("/UsersRegistrationInterface")
public class UsersRegistrationInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UsersRegistrationInterface() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out=response.getWriter(); 
	out.println("<script src=assests/jquery-2.2.1.min.js></script>");
	out.println("<link rel=stylesheet type=text/css href=assests/jquery-ui.min.css></link>");
	out.println("<script src=assests/jquery-ui.min.js></script>");
	out.println("<script src=assests/jquery.validate.min.js></script>");
	out.println("<script src=assests/users.js></script>");
	out.println("<html>");
	//out.println("<form action=UsersRegistrationSubmit method=post>");
	out.println("<h2>Register Here First.......</h2>");
	out.println("<h3>Already a user&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp<a href=UserLogin><i>'Press here to LOGIN'</i></a></h3>");
	out.println("<table width=50%>");
	out.println("<tr><td><b><i>User Id:</i></b></td><td><input type=text name=uid id=uid><span id=msg></span></td></tr>");
	out.println("<tr><td><b><i>Name:</i></b></td><td><input type=text name=fn placeholder='First Name'>&nbsp;&nbsp;<input type=text name=ln placeholder='Last Name'></td></tr>");
	out.println("<tr><td><b><i>Birth Date:</i></b></td><td><input type=text name=bd id=bd></td></tr>");
	out.println("<tr><td><b><i>Gender:</i></b></td><td><input type=radio name=ug value=Male>Male<input type=radio name=ug value=Female>Female</td></tr>");
	out.println("<tr><td><b><i>Email:</i></b></td><td><input type=email name=em></td></tr>");
	out.println("<tr><td><b><i>Password:</i></b></td><td><input type=password name=up id=up><img src='' id=im></td></tr>");
	out.println("<tr><td><b><i>Confirm Password:</i></b></td><td><input type=password name=cup id=cup></td></tr>");
	out.println("<tr><td><input type=Button value='Sign Up' id=pro_sbtn></td><td><input type=Reset></td></tr>");
	out.println("</table></form>");
	out.println("<span  name=result id=result></span></html>");
	out.flush();
		 	}

}
