package com.crud.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.crud.Service.StudentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/CrudProg2")
public class CrudProg2 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			StudentService service = new StudentService();
			service.createTable();
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