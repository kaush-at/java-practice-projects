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
 * Servlet implementation class GetEmployeeById
 */
@WebServlet("/GetEmployeeById")
public class GetEmployeeById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("GetEmployeeById servlet get called...");
		int id = Integer.parseInt(request.getParameter("searchByIDText"));
		
		EmployeeDAO empDao = new EmployeeDAO();
		Employee emp = empDao.getEmployeeById(id);
		
		// set searched employee to the request object
		request.setAttribute("employee", emp);
		
		if(emp != null) {
			RequestDispatcher rd = request.getRequestDispatcher("displayEmployee.jsp");
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
