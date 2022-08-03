package com.samples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateuserServlet")
public class UpdateUserServlet extends HttpServlet {
	Connection connection;
	@Override
	public void init() throws ServletException {
		try {
			System.out.println("UpdateUserServlet.init() method. DB connection created");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Archu@2000");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try (Statement statement = connection.createStatement();) {
			String qry = "update user set password=' " + password + "'where email='"+email +"'";
			int rowsUpdated = statement.executeUpdate(qry);
			System.out.println("Query being executed: " + qry);
			System.out.println("Rows : " + rowsUpdated);
			PrintWriter out = response.getWriter();
			out.println("Hurray Updated!!!");
			out.println("<p><a href='Home.html'>Home</a></p>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy() {
		try {
			System.out.println("UpdateUserServlet.destroy() method. DB connection closed");
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
