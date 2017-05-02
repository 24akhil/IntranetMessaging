package com.softech.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.softech.dao.MessageDAO;

/**
 * Servlet implementation class Inbox
 */
@WebServlet("/Inbox")
public class Inbox extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inbox() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession ses=request.getSession(); 
	    out.println("<html>");
	    out.println("<center><b>You have "+MessageDAO.countUnreadMsg(ses.getValue("SID").toString())+" unread messages..</b></center><br>");
	   
	    try{
	    	ResultSet rs=MessageDAO.displayInbox(ses.getValue("SID").toString());
	    	if(rs.next())
	    	{
	    	out.println("<form action=RemoveMessages>");	
	    	out.println("<input type=submit value='Delete' name=btn>&nbsp;&nbsp;<input type=submit value='Trash' name=btn>");
	    	out.println("<input type=hidden name=hdn value=2>");
	    	out.println("<table width=100% cellspacing=2>");
	    	do{
	    	 	
	    	  out.println("<tr><td><input type=checkbox value="+rs.getString(1)+" name=msgid></td>");
	    	  if(rs.getString(7).equalsIgnoreCase("Read"))
	    	  {
	    	  out.println("<td>"+rs.getString(2)+"</td>");
	    	  out.println("<td>"+rs.getString(3)+"</td>");
	    	  out.println("<td>"+rs.getString(4)+"</td>");
	    	  String msg=rs.getString(5);
	    	  if(msg.length()>=40)
	    	  {
	    	  msg=msg.substring(0,40)+"....";	  
	    	  }
	    	  out.println("<td><a href=SearchMessage?mid="+rs.getString(1)+"><b>"+rs.getString(4)+"</b>-"+msg+"</a></td>");
	    	  out.println("<td>"+rs.getString(6)+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString(7)+"</td></tr>");
	    	  }
	    	  else
	    	  {out.println("<td bgcolor=yellow><font color=green><b><i>"+rs.getString(2)+"</i></b></font></td>");
	    	  out.println("<td bgcolor=yellow><font color=green><b><i>"+rs.getString(3)+"</i></b></font></td>");
	    	  out.println("<td bgcolor=yellow><font color=green><b><i>"+rs.getString(4)+"</i></b></font></td>");
	    	  String msg=rs.getString(5);
	    	  if(msg.length()>=40)
	    	  {
	    	  msg=msg.substring(0,40)+"....";	  
	    	  }
	    	  out.println("<td bgcolor=yellow><a href=SearchMessage?mid="+rs.getString(1)+"><b>"+rs.getString(4)+"</b>-"+msg+"</a></td>");
	    	  out.println("<td bgcolor=yellow>"+rs.getString(6)+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString(7)+"</td></tr>");
	    	  }
	    	  
	    	}while(rs.next());
	    	  out.println("</table></form>");
	    	}
	    	else
	    	{out.println("<font color=red><b>No mesages...</b></font>");
	    		}
	    	}catch(Exception e)
	    	{out.println(e);
	    		}



	    			
	    			 	}
	       
	}


