package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.BookHelper;

/**
 * Servlet implementation class coursePicker
 */
public class coursePicker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public coursePicker() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BookHelper helper = null;
		try {
			helper = new BookHelper();
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + " Initializing BookHelper object: " + e.getMessage());
		}
		ArrayList<String> stringList = helper.getClassByDepartment(request.getParameter("department"));

		PrintWriter out = response.getWriter();
		out.write("<select name=\"className\">");
		out.write("<option value=\"\">Select a Class</option>");
		for(String a : stringList)
		{

			out.write("<option value=\""+ a + "\">" + a + "</option>");
		}
		out.write("</select>");



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
