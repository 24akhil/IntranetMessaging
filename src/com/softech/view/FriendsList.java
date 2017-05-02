package com.softech.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softech.dao.UserRegistrationDAO;

/**
 * Servlet implementation class FriendsList
 */
@WebServlet("/FriendsList")
public class FriendsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendsList() {
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
		out.println("<script src=assests/jquery-2.2.1.min.js></script>");
		out.println("<link rel=stylesheet type=text/css href=assests/jquery-ui.min.css></link>");
		out.println("<script src=assests/jquery-ui.min.js></script>");
		out.println("<script src=assests/jquery.validate.min.js></script>");
		out.println("<script src=assests/friends.js></script>");
		/*try{
			while(rs.next()){
				out.println("<a href=ComposeMessage target=mw?userId>"+rs.getString(1)+"</a><br>");
				}
		}catch(Exception e){
			System.out.println(e);
		}*/
		out.println("<input type=text size=10 placeholder='Search Friend' id=stxt name=stxt><br><br>");
		out.println("<span id=result></span>");
		out.println("</html>");
		out.flush();
	}

}
