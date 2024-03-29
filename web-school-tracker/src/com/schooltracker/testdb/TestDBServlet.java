package com.schooltracker.testdb;

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
 * Servlet implementation class testdb
 */
@WebServlet("/testdb")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// setup connection variables
		String user = "webschooltracker";
		String pass = "webschooltracker";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_school_tracker?useSSL=false";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		//connect to database
		try {
			
			PrintWriter out = response.getWriter();
			
			out.println("Connecting to database: " + jdbcUrl);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			out.println("SUCCESS!");
			
			myConn.close();
			
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		

		

		
		
	}

}
