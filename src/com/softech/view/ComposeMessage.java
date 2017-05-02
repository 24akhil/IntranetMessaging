package com.softech.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ComposeMessage
 */
@WebServlet("/ComposeMessage")
public class ComposeMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComposeMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
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
		////////parameter from freindlist//////////
		String to=request.getParameter("uid");
		if(request.getParameter("uid")==null){
			to="";
		}
		///////////////////////////////////////////
		out.println("<form action=ComposeMessageSubmit >");
		out.println("<table width=50%>");
		out.println("<tr><td><b><i>User Id:</i></b></td><td><input type=text name=uid value="+ses.getValue("SID").toString()+" size=70></td></tr>");
		out.println("<tr><td><b><i>To:</i></b></td><td><input type=text name=uto size=70 value="+to+"></td></tr>");
		Calendar C=Calendar.getInstance();
		String cd=C.get(Calendar.YEAR)+"-"+(C.get(Calendar.MONTH)+1)+"-"+C.get(Calendar.DATE);
		String ct=C.get(Calendar.HOUR)+":"+C.get(Calendar.MINUTE)+":"+C.get(Calendar.SECOND);
		//+" "+(C.get(Calendar.AM_PM)==0?"AM":"PM");
		String d=cd+" "+ct;
		out.println("<tr><td><b><i>Date/Time:</i></b></td><td><input type=text name=dt size=70 value='"+d+"'></td></tr>");
		out.println("<tr><td>Subject</td><td><input type=text name=sub id=sub></td></tr>");
		out.println("</table><br>");
		out.println("<b><i>Type Your Message..</i></b><br>");
		out.println("<textarea rows=10 cols=100 name=msg></textarea><br><br><br>");
		out.println("<input type=submit value='Send Message'>");
		out.println("</table></form></html>");
        out.flush();

	}

}
