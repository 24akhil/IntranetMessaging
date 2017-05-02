package com.softech.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.softech.dao.DBHelper;
import com.softech.dao.MessageDAO;

/**
 * Servlet implementation class SentMailJSON
 */
@WebServlet("/SentMailJSON")
public class SentMailJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SentMailJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		/////////////////////////
		HttpSession ses=request.getSession();		
		try{ 
		    String nav="<h3><font color=green><i><b>User Id:"+ses.getValue("SID").toString()+"&nbsp User Name:"+ses.getValue("SNAME").toString()+"&nbsp;&nbsp;</font>"+ses.getValue("LTIME").toString()+"&nbsp;&nbsp;&nbsp;&nbsp;<a href=UserLogout>Logout</a></h3><hr color=red>";
		    
		    }catch(Exception e){
		    	response.sendRedirect("UserLogin");
		    }

		try{
			ResultSet rs=MessageDAO.displaySent(ses.getValue("SID").toString(),request.getParameter("pat"));
			ArrayList<JSONObject> json=DBHelper.getFormatedResult(rs);
			out.println(json);
			
		}catch(Exception e){}
		
		

	}

}
