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

import org.json.JSONObject;

import com.softech.dao.DBHelper;
import com.softech.dao.UserRegistrationDAO;

/**
 * Servlet implementation class friendsJSON
 */
@WebServlet("/friendsJSON")
public class friendsJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public friendsJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		System.out.println("qwert"+request.getParameter("pat"));
		ResultSet rs=UserRegistrationDAO.friendslist(request.getParameter("pat"));
		ArrayList<JSONObject> json=DBHelper.getFormatedResult(rs);
		out.println(json);
	}

}
