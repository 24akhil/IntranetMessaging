package com.softech.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.softech.dao.MessageDAO;
import com.softech.model.Messages;

/**
 * Servlet implementation class ComposeMessageSubmit
 */
@WebServlet("/ComposeMessageSubmit")
public class ComposeMessageSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComposeMessageSubmit() {
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
	Messages M=new Messages();
	M.setUserid(request.getParameter("uid"));
	M.setUserid_to(request.getParameter("uto"));
	M.setMsgdatetime(request.getParameter("dt"));
	M.setMessage(request.getParameter("msg"));
	M.setSubject(request.getParameter("sub"));
	M.setStatus("UnRead");
	boolean st=MessageDAO.addNewrecord(M);
	
	if(st)
	{out.println("<font color=green>Message Sent..</font>");
	}
	else
	{
		out.println("<font color=red>Fail to Send Message..</font>");	
	}
		out.flush();
	

	}

}
