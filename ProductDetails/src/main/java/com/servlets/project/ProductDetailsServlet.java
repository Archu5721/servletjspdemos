package com.servlets.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/productdetailsServlet")
public class ProductDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			ServletContext context = config.getServletContext();
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dburl"),
					context.getInitParameter("dbuser"), context.getInitParameter("dbpassword"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		int Productid = Integer.parseInt(request.getParameter("productid"));
		PrintWriter out = response.getWriter();
		try (PreparedStatement statement = connection.prepareStatement("select * from Product where proid=?");) {
			statement.setInt(1, Productid);
			ResultSet results = statement.executeQuery();
			
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>Product Id</th>");
			out.println("<th>Product Name</th>");
			out.println("<th>Cost</th>");
			out.println("</tr>");
			while (results.next()) {
				out.println("<tr>");
				out.println("<td>" + results.getInt(1) + "</td>");
				out.println("<td>" + results.getString(2) + "</td>");
				out.println("<td>" + results.getInt(3) + "</td>");
				out.println("</tr>");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		out.println("</table>");
		out.println("<p><a href='Product.html'>Home Page</a></p>");
	}

	@Override
	public void destroy() {
		try {
			System.out.println("Db Connection closed");
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
