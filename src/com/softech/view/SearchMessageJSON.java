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
import com.softech.dao.MessageDAO;

/**
 * Servlet implementation class SearchMessageJSON
 */
@WebServlet("/SearchMessageJSON")
public class SearchMessageJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMessageJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		ResultSet rs=MessageDAO.displayMsg(request.getParameter("mid"));
	    ArrayList <JSONObject> json=DBHelper.getFormatedResult(rs);
	    out.println(json);
	}

}
