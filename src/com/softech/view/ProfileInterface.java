package com.softech.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileInterface
 */
@WebServlet("/ProfileInterface")
public class ProfileInterface extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileInterface() {
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
		out.println("<script src=assests/profile.js></script>");
		out.println("<html>");
/////////////////session navigation/////////////
HttpSession ses=request.getSession();
 
try{
String nav="<h3><font color=green><i><b>User Id:"+ses.getValue("SID").toString()+"&nbsp;&nbsp;"+ses.getValue("SNAME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>"+ses.getValue("LTIME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=UserLogout>Logout</a></h3><hr color=red>";
 
}catch(Exception e)
{
	response.sendRedirect("UserLogin");
}
///////////////////////////////////
		out.println("<table width=50%>");
		out.println("<tr><td><b><i>User Id:</i></b></td><td><input type=text name=uid id=uid value="+ses.getValue("SID").toString()+"></td></tr>");
		out.println("<tr><td><b><i>Address:</i></b></td><td><input type=textarea id=add rows=3 cols=50></textarea></td></tr>");
		////////
		out.println("<tr><td><b><i>State:</i></b></td><td><select id=state><option>-Select-</option></select></td></tr>");
		out.println("<tr><td><b><i>City:</i></b></td><td><select id=city><option>-Select-</select></td></tr>");
		///////		
		out.println("<tr><td><b><i>Status:</i></b></td><td><input type=radio id=sts value=Single>Single<input type=radio id=sts value=Married>Married</td></tr>");
		out.println("<tr><td><b><i>Work:</i></b></td><td><textarea id=work rows=3 cols=50></textarea></td></tr>");
		out.println("<tr><td><b><i>Qualification:</i></b></td><td><textarea id=quali rows=3 cols=50></textarea></td></tr>");
		 
		 
		out.println("<tr><td><input type=button value='Submit Profile' id='sbtn'></td><td><input type=Reset></td></tr>");
		out.println("</table>");
		out.println("<br><br><span id=result></span>");
		out.println("</html>");
		out.flush();	
	}

}
