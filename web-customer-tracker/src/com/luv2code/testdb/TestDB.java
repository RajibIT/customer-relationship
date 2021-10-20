package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDB
 */
@WebServlet("/TestDB")
public class TestDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = "customer";
		String pass = "customer";
		String jdbcUrl = "jdbc:mysql://localhost:3306/customer-database?useSSL=false";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			
			PrintWriter out = response.getWriter();
			out.println("connecting to db "+jdbcUrl);
			
			Class.forName(driver);
			Connection myconn = DriverManager.getConnection(jdbcUrl, user, pass);
			out.println("success!!");
			myconn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
