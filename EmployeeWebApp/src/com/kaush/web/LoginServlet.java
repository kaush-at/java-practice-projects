package com.kaush.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kaush.dao.EmployeeDAO;
import com.kaush.dto.Employee;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Login servlet get called....");

		// extract details comming from front end
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// Create a session and add username to it(then can access in fron end to show user)
		HttpSession session = request.getSession();
		session.setAttribute("userName", username);
		session.setAttribute("password", password);

		if (username.equalsIgnoreCase("HR") && password.equalsIgnoreCase("123")) {
			RequestDispatcher rd = request.getRequestDispatcher("hrHomePage.jsp");
			rd.forward(request, response);
		} else {
			EmployeeDAO empDao = new EmployeeDAO();
			Employee emp = empDao.getEmployeeByLoginDetails(username, password);
			
			if (emp != null) {
				RequestDispatcher rd = request.getRequestDispatcher("employeeHomePage.jsp");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
