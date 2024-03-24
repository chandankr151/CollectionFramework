package com.crud.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import com.crud.DAO.StudentDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/ReadData")
public class ReadData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {

			StudentDaoImpl stdDisplay = new StudentDaoImpl();
			ResultSet data = stdDisplay.displayRecord();

			System.out.println("All available records from Student table are given below: ");
			while (data.next()) {
				out.println("Student ID: " + data.getInt(1) + "\n");
				out.println("Student Name: " + data.getString(2) + "\n");
				out.println("Student City: " + data.getString(3) + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* response.sendRedirect(request.getContextPath() + "/home.jsp"); */
		/// Below is the HTML code written in this Servlet Page to hold page for
		/// 10second and then redirect it to home page...
		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("<title>Redirecting...</title>");
		out.println("<script>");
		out.println("setTimeout(function () {");
		out.println("    window.location.href = 'index.jsp';");
		out.println("}, 10000);"); // 10 seconds
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Redirecting to <em>HOME</em> page...</h1>");
		out.println("<p>If the page does not automatically redirect, <a href='index.jsp'>goHome</a>.</p>");
		out.println("</body>");
		out.println("</html>");
	}
}