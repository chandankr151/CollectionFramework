package com.crud.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.crud.DAO.StudentDaoImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/UpdateRecord")
public class UpdateRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String city = request.getParameter("city");

		StudentDaoImpl stdUpdate = new StudentDaoImpl();
		int flag = stdUpdate.updateRecord(id, name, city);

		if (flag == 1) {
			out.println("Record with given id updated Successfully into database!!!");
		} else {
			out.println("Error occured while updating record into database!!!");
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