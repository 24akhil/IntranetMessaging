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
import com.softech.model.UsersRegistration;

/**
 * Servlet implementation class UsersRegistrationSubmit
 */
@WebServlet("/UsersRegistrationSubmit")
public class UsersRegistrationSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersRegistrationSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
      PrintWriter out=response.getWriter();	
	  UsersRegistration U=new UsersRegistration();
	  U.setUserId(request.getParameter("uid"));
	  U.setUserName(request.getParameter("fn")+" "+request.getParameter("ln"));
	  U.setBirthDate(request.getParameter("bd"));
	  U.setGender(request.getParameter("ug"));
	  U.setEmailId(request.getParameter("em"));
	  U.setPassword(request.getParameter("up"));
	  boolean st=UserRegistrationDAO.addNewrecord(U);
	  try{
	  JSONObject obj = new JSONObject();
	  if(st){
		 
		  obj.put("value","<h1><center>Login Successful please login to avail the service</center></h1><br>"
		  		+ "<h3><center><a href=UserLogin><font color=green>Click here to login</font></a></h3></center>");
		  out.println(obj);
		  //System.out.println(obj);
	  }else{obj.put("value","Database Error...try after some time");}
	  }catch(Exception e){System.out.println(e);}
	  /*
	  out.println("<html><title>Registered Successfully</title>");
	  if(st)
	  {out.println("<h1>Record Submitted</h1></html>");
	  }
	  else
	  {out.println("<h1>Fail to Submit Record</h1></html>");}
	  out.flush();
		*/
	  
	  
	  }
	  
	}






