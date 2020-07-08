package com.kaush.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaush.dao.EmployeeDAO;
import com.kaush.dto.Employee;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Register servlet get called....");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		double salary = Double.parseDouble(request.getParameter("salary"));
		String department = request.getParameter("department");
		
		Employee emp = new Employee();
		//emp.setId(id);
		emp.setName(username);
		emp.setPassword(password);
		emp.setDepartment(department);
		emp.setSalary(salary);
		
		EmployeeDAO empDao = new EmployeeDAO();
		int rowCount = empDao.addEmployee(emp);
		
		if(rowCount > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
