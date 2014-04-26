package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
		helper.closeConnection();
		PrintWriter out = response.getWriter();
		out.write("<select class=\"dropdownMenu\" name=\"className\">");
		out.write("<option value=\"-1\">Select a Class</option>");
		if (stringList.size() == 0)
		{
			out.write("<option value=\"-1\">No Class Available</option>");
		}
		else {
			out.write("<option value=\"all\">All Classes</option>");
		}
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
