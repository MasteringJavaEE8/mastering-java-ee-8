package com.packt.chapter1.helloworld.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.packt.javaee.ejbapi.UserEJBAPI;
import com.packt.javaee.exception.MessageException;
import com.packt.javaee.jpa.User;

@WebServlet(name = "DisplayUserDetailsServlet", urlPatterns = { "/DisplayUserDetailsServlet" })
public class DisplayUserDetailsServlet extends HttpServlet {
	@EJB
	private UserEJBAPI userEJB;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Mastering Java EE 8</title>");
			out.println("</head>");
			out.println("<style type=\"text/css\">");
			out.println(".container {width: 500px;clear: both;}");
			out.println("input[type=text], select {width: 100%;padding: 12px 20px;margin: 8px 0;display: inline-block;border: 1px solid #ccc;border-radius: 4px;box-sizing: border-box;}");
			out.println("input[type=submit] {width: 100%;background-color: #e27a3f;color: white;padding: 14px 20px;margin: 8px 0;border: none;border-radius: 4px;cursor: pointer;}");
			out.println("input[type=submit]:hover {background-color: #45a049;} h1 { font-weight:normal; } h2 { font-weight:normal; } h3 { font-weight:normal; }");
			out.println("div {border-radius: 10px;background-color: #f2f2f2;padding: 20px; margin-left:50px; margin-right:50px }");
			out.println("</style>");
			out.println("<body>");
			out.println("<div align='center'>");
			out.println("<h1 style=\"color:#e27a3f;\">Wellcome to Mastering Java EE 8 from PACKT Publishing&reg; </h1>");
			out.println("<h2> <span font-weight:normal> You have successfully set your Java EE 8 Play Ground !!! </span> </h2>");
			out.println("<div class=\"container\">");
			out.println("<div>");
			out.println("<form action='./InsertUserDetailsServlet' method='POST'>");
			out.println("<label> Enter your name : </label>");
			out.println("<input type='text' name='user_name'> ");
			out.println("<br>");
			out.println("<label> Enter your job role  : </label>");
			out.println("<input type='text' name='user_job_role'> ");
			out.println("<br>");
			out.println("<input type='submit' value='Enter'>");
			out.println("</form>");
			out.println("</div>");
			out.println("</div>");
			out.println("<br>");
			String userInfo;
			try {
				User user = userEJB.getUserDetails();
				userInfo = "<h3>Hello "
						+ user.getUserName()
						+ "!,You are a "
						+ user.getUserJobRole()
						+ "</h3><br> <h3>Data you entered went through Servlet component &rarr; EJB compoent &rarr; JPA component &rarr; Database and back to the User Interface</h3>";
			} catch (MessageException nme) {
				userInfo = "<h3>you should enter name and job role...</h3>";
			}
			out.println(userInfo + "</b>");
			out.println("<br>");
			out.println("<br>");
			out.println("<br>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}
}