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

import com.softech.dao.ProfileDAO;
import com.softech.model.Profile;

/**
 * Servlet implementation class ProfileSubmitJSON
 */
@WebServlet("/ProfileSubmitJSON")
public class ProfileSubmitJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileSubmitJSON() {
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
Profile p=new Profile();
p.setUserid(request.getParameter("uid"));
p.setAddress(request.getParameter("add"));
p.setCity(request.getParameter("city"));
p.setQualification(request.getParameter("quali"));
p.setState(request.getParameter("state"));
p.setStatus(request.getParameter("sts"));
p.setWork(request.getParameter("work"));
JSONObject json=new JSONObject();
out.println("<html>");
out.println("profile");
try{
boolean st=ProfileDAO.addNewRecord(p);
if(st){json.put("value","<font color=green>Profile Updated<font>");


}else{json.put("value","<font color=green>Updation Failed<font>");


}
System.out.println(json);
out.println(json);
}catch(Exception e){System.out.println(e);
		}
out.println("</html>");

}catch(Exception e){
System.out.println(e);
	}


}
	}


