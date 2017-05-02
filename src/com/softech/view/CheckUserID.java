package com.softech.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.softech.dao.UserRegistrationDAO;

/**
 * Servlet implementation class ChechUserID
 */
@WebServlet("/ChechUserID")
public class CheckUserID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUserID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		 try{
				
		      String uid=request.getParameter("uid");
		      boolean st=UserRegistrationDAO.checkUserId(uid);
		      JSONObject obj=new JSONObject();
		      if(st)
		       {obj.put("value","This Id is Already Exist");
		    	  
		    	   
		       }
		       else
		       {
		    	   obj.put("value","This Id is OK...");
		       } 
		     out.println(obj);
		     }catch(Exception e)
		     {out.println("error");
		    	 
		     }
			

	}

}
