package com.kaush.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kaush.db.JDBCConnection;
import com.kaush.dto.Employee;

public class EmployeeDAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	// get employee by id
	public Employee getEmployeeById(int id) {
		con = JDBCConnection.getConnection();
		Employee emp = new Employee();
		try {
			ps = con.prepareStatement("SELECT * FROM employee WHERE id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setPassword(rs.getString("password"));
				emp.setDepartment(rs.getString("department"));
				emp.setSalary(rs.getDouble("salary"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	
	// get employee by username and password
	public Employee getEmployeeByLoginDetails(String username, String password) {
		con = JDBCConnection.getConnection();
		Employee emp = new Employee();
		
		try {
			ps = con.prepareStatement("SELECT * FROM employee WHERE name = ? and password = ? ");
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setPassword(rs.getString(3));
				emp.setDepartment(rs.getString(4));
				emp.setSalary(rs.getDouble(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	
	
	// get all employees
	public List<Employee> getAllEmployees(){
		con = JDBCConnection.getConnection();
		List<Employee> empList = new ArrayList<>();
		
		try {
			ps = con.prepareStatement("select * from employee");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setPassword(rs.getString("password"));
				emp.setDepartment(rs.getString("department"));
				emp.setSalary(rs.getDouble("salary"));
				
				empList.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return empList;
	}
	
	// insert data into employee
	public int addEmployee(Employee emp) {
		con = JDBCConnection.getConnection();
		
		int rowCount = 0;
		try {
			int id = this.getMaxIdInDBTable() + 1;
			ps = con.prepareStatement("INSERT INTO employee values(?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getPassword());
			ps.setString(4, emp.getDepartment());
			ps.setDouble(5, emp.getSalary());
			rowCount = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowCount;
	}
	
	// getting the maximum id
	public int getMaxIdInDBTable() {
		con = JDBCConnection.getConnection();
		int maxId = 0;
		try {
			ps = con.prepareStatement("SELECT * FROM employee ORDER BY id DESC LIMIT 0, 1");
			rs = ps.executeQuery();
			if(rs.next()) {
				maxId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return maxId;
	}
}
