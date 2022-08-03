package com.servlets.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class validateServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		String Username =  req.getParameter("Username");
		String password = req.getParameter("password");
		PrintWriter out = res.getWriter();
		if(Username.equals("Archatha") && (password.equals("archu"))) {
			out.println("Welcome " + Username);
			out.println(" ");
			out.println("<a href='validate.html'>Logout</a>");
			
		}
		else {		
			out.println("Invalid Login");
			
		
		}
		
		
	}
}
