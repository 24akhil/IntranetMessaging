package com.softech.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.softech.dao.ProfileDAO;

/**
 * Servlet implementation class PhotoSubmit
 */
@WebServlet("/PhotoSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class PhotoSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		Part part=request.getPart("upic"); 
		  String savepath="F:/Stuff/java programs/IntranetMessaging/WebContent/icon";
		 FileUpload F=new FileUpload(part,savepath);
		 HttpSession ses=request.getSession();
		 
		 boolean st=ProfileDAO.addPhoto(ses.getValue("SID").toString(), F.filename);
	      if(st)
	      {
	    	// response.sendRedirect("UserHomePage"); 
	      }

		
	}

}
