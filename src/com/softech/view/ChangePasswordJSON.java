package com.softech.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.softech.dao.UserRegistrationDAO;

/**
 * Servlet implementation class ChangePasswordJSON
 */
@WebServlet("/ChangePasswordJSON")
public class ChangePasswordJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
/////////////////session navigation/////////////
HttpSession ses=request.getSession();

try{
String nav="<h3><font color=green><i><b>User Id:"+ses.getValue("SID").toString()+"&nbsp;&nbsp;"+ses.getValue("SNAME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>"+ses.getValue("LTIME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=UserLogout>Logout</a></h3><hr color=red>";

}catch(Exception e)
{
response.sendRedirect("UserLogin");
}
///////////////////////////////////
try{
	boolean st=UserRegistrationDAO.changePassword(ses.getValue("SID").toString(), request.getParameter("op"),request.getParameter("up"));
	JSONObject obj=new JSONObject();
	if(st){
		 
		obj.put("value","<font color=green><b><i>Password Changed</i></b></font>");
		System.out.println(obj);
		//response.sendRedirect("UserLogin");
	}else
	{obj.put("value","<font color=red><b><i>Fail to Change Password..Pls Check Ur Old Password</i></b></font>");	
	}
	out.println(obj);
}
catch(Exception e){
	System.out.println(e+"passwordfailure");}

	}

}
