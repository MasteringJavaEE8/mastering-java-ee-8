package com.packt.chapter1.helloworld.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.packt.javaee.ejbapi.UserEJBAPI;
import com.packt.javaee.exception.MessageException;

@WebServlet(name = "InsertUserDetailsServlet", urlPatterns = { "/InsertUserDetailsServlet" })
public class InsertUserDetailsServlet extends HttpServlet {
	@EJB
	private UserEJBAPI userEJB;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String user_name = request.getParameter("user_name");
		String user_job_role = request.getParameter("user_job_role");
		try {
			userEJB.insertUserDetails(user_name, user_job_role);
		} catch (MessageException nme) {
			throw new ServletException(nme);
		}

		response.sendRedirect("./DisplayUserDetailsServlet");
	}

}