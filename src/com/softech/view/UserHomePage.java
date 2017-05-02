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

import com.softech.dao.ProfileDAO;

/**
 * Servlet implementation class UserHomePage
 */
@WebServlet("/UserHomePage")
public class UserHomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserHomePage() {
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
	   
	   try{HttpSession ses=request.getSession();
	   String nav="<h3><font color=green><i><b>User Id:"+ses.getValue("SID").toString();
	   }catch(Exception e){response.sendRedirect("UserLogin");
		   }
       ///////////////check photo////////
	   String src="";
	   try{HttpSession ses=request.getSession();
		   String img=ProfileDAO.checkPhotograph(ses.getValue("SID").toString());
	   if(img==null){
		   if(ses.getValue("GENDER").equals("Male")){
			   src="icon/male.png";
		   }else{
			   src="icon/female.png";
		   }
	   }else{
		   String pic=img;
		   src="icon/"+pic;
	   }
	   }catch(Exception e){
		   System.out.println(e);}
	   /////////////////////////////////
	   /////////////////session navigation/////////////
	   try{ HttpSession ses=request.getSession();
	    String nav="<h3><font color=green><i><b>User Id:"+ses.getValue("SID").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;User Name:<font color=red>"+ses.getValue("SNAME").toString()+"</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>"+ses.getValue("LTIME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AlterPhoto target=mw><img src="+src+" title='Update Picture' width=50 height=50></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=UserLogout>Logout</a><hr color=red>";
	    out.println(nav);
	    }catch(Exception e){
	    	response.sendRedirect("UserLogin");
	    }
	   ///////////////////////////////////
	   
	   ////////UserFirstTimeCheck////////
	   HttpSession ses=request.getSession();
	    ResultSet rs=ProfileDAO.checkFirstTime(ses.getValue("SID").toString());
	    String first="";
	   try{ if(rs.next()){
	    	first="Update profile";
	    }else{first="Set Profile";
	    }
	   }catch(Exception e){
	    	System.out.println(e);
	    }
	    
	    //////////////////////////////////
	   
	  
	    out.println("<table>");
		out.println("<tr><td valign=top><a href=ComposeMessage target=mw ><font color=green>Compose Message</font></a><br><a href=Inbox target=mw ><font color=blue>Inbox</font></a><br><a href=SentMail target=mw><font color=green>Sent</font></a><br><a href=ChangePasswordInterface target=mw ><font color=blue>Change Password</font></a><br><a href=ProfileInterface target=mw ><font color=green>"+first+"</font></a>");
		out.println("<br><a href=FriendsList target=fr ><font color=blue>Friends</font></a><br><iframe name=fr width=200 height=500 frameborder=0></iframe></td>");
		out.println("<td><iframe name=mw width=1000 height=500 frameborder=0 ></iframe></td></tr></table>");
		out.println("</html>");
		out.flush();
	}

	

}
