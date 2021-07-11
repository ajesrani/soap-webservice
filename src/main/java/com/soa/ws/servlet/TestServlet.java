package com.soa.ws.servlet;

import java.io.IOException;

/*
 * Servlet is a java program that runs inside JVM on the web server. 
 * It is used for developing dynamic web applications.
 * They are used to handle the request obtained from the web server, 
 * process the request, produce the response, then send response back to the web server.
 */

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter pw = res.getWriter();

		String user = req.getParameter("user");
		String password = req.getParameter("password");
		
		//HttpSession session = req.getSession();
		//session.setAttribute("user", user);
		
		if(user == null || password == null) {
			pw.println("<h1>Hello Servlet</h1>");
		}
		else {
			if(password.equals("admin")) {
				//res.sendRedirect("Welcome.html");
				System.out.println(req.getContextPath());
				RequestDispatcher rd = req.getRequestDispatcher("Welcome.html");
                rd.forward(req, res);
			}
			else {
				pw.println("<font color='red'><b>You have entered incorrect user or password</b></font>");
                RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
                rd.include(req, res);
			}
		}
	}
}
