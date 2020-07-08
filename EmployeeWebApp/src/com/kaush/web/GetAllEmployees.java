package com.kaush.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaush.dao.EmployeeDAO;
import com.kaush.dto.Employee;

/**
 * Servlet implementation class GetAllEmployees
 */
@WebServlet("/GetAllEmployees")
public class GetAllEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GetAllEmployees servlet get called...");
		
		EmployeeDAO empDao = new EmployeeDAO();
		List<Employee> empList = empDao.getAllEmployees();
		
		// add employee list to the request object
		request.setAttribute("employeeList", empList);
		
		if(empList != null) {
			RequestDispatcher rd = request.getRequestDispatcher("displayAllEmployees.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
