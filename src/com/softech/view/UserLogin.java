package com.softech.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	PrintWriter out=response.getWriter();

out.println("<html>");

out.println("	<head>");
out.println("	        <link href='template/assets/css/bootstrap.min.css' rel='stylesheet' type='text/css' />");
out.println("	        <link href='template/assets/css/core.css' rel='stylesheet' type='text/css' />");
out.println("	        <link href='template/assets/css/components.css' rel='stylesheet' type='text/css' />");
out.println("	        <link href='template/assets/css/pages.css' rel='stylesheet' type='text/css' />");

out.println("	    </head>");
out.println("	    <body style='background-image:url(template/assets/images/pattern6.png);'>");

out.println("	        <div class='text-center logo-alt-box'>");
out.println("	            <a href='#' class='logo'><img src='template/assets/images/logo.png'></a>");

out.println("	        </div>");

out.println("	        <div class='wrapper-page'>");

out.println("	        	<div class='m-t-30 card-box'>");
out.println("	                <div class='text-center'>");
out.println("	                    <h4 class='text-uppercase font-bold m-b-0'>Sign In</h4>");
out.println("	                </div>");
out.println("	                <div class='panel-body'>");
out.println("	                    <form class='form-horizontal m-t-10' action='checkLogin' method='post'>");

out.println("							<div class='form-group '>");
out.println("	                            <div class='col-xs-12'>");
out.println("	                                <input class='form-control' type='text' required='' placeholder='UserId' name='uid'>");
out.println("	                            </div>");
out.println("	                        </div>");

out.println("	                        <div class='form-group'>");
out.println("	                            <div class='col-xs-12'>");
out.println("	                                <input class='form-control' type='password' required='' placeholder='Password' name='password'>");
out.println("	                            </div>");
out.println("	                        </div>");
out.println("							<div class='form-group text-center m-t-30'>");
out.println("	                            <div class='col-xs-12'>");
out.println("	                                <button class='btn btn-custom btn-bordred btn-block waves-effect waves-light text-uppercase' type='submit'>Log In</button>");
out.println("<br><br><br><a href='UsersRegistrationInterface'> <font color=red size=5>Not Registerd yet! click here to Sign Up</font></a>");
out.println("	                            </div>");
out.println("	                        </div>");


out.println("						</form>");

out.println("	                </div>");
out.println("	            </div>");
out.println("	            <!-- end card-box -->");



out.println("	        </div>");
out.println("	        <!-- end wrapper page -->");


out.println("	        <!-- jQuery  -->");
out.println("	        <script src='template/assets/js/jquery.min.js'></script>");
	out.println("	        <script src='template/assets/js/bootstrap.min.js'></script>");


		out.println("		</body>");

	out.println("</html>");
	out.flush();
}

}
