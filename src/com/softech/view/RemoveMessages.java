package com.softech.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softech.dao.MessageDAO;

/**
 * Servlet implementation class RemoveMessages
 */
@WebServlet("/RemoveMessages")
public class RemoveMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveMessages() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String msgid[]=request.getParameterValues("msgid");
		String btn=request.getParameter("btn");
		if(btn.equals("Delete"))
		{ for(int i=0;i<msgid.length;i++)
		{
		MessageDAO.deleteMessage(msgid[i]);	
		}
			
		}
		else if(btn.equals("Trash"))
		{
			for(int i=0;i<msgid.length;i++)
			{
			MessageDAO.trashMessage(msgid[i]);	
			}	 	
		}
		if(request.getParameter("hdn").equals("1")){
			response.sendRedirect("SentMail");
		}else{
		response.sendRedirect("Inbox");
	          }
	}

	}


