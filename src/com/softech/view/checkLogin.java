package com.softech.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.softech.dao.UserRegistrationDAO;
import com.softech.model.UsersRegistration;

/**
 * Servlet implementation class checkLogin
 */
@WebServlet("/checkLogin")
public class checkLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out=response.getWriter();
	String uid=request.getParameter("uid");
	String password=request.getParameter("password");
	UsersRegistration u=UserRegistrationDAO.checkUserLogin(uid,password);
	out.println("<html>");
	if(u==null){
		out.println("This ID is not valid");
	}else{
		HttpSession ses=request.getSession();
		ses.putValue("SID",u.getUserId());
		ses.putValue("SNAME",u.getUserName());
		ses.putValue("LTIME", new java.util.Date());
		ses.putValue("GENDER",u.getGender());
		response.sendRedirect("UserHomePage");
	}
	out.println("</html>");
	out.flush();
	}

}
