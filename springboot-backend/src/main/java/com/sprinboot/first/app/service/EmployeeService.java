package com.sprinboot.first.app.service;

import java.util.List;

import com.sprinboot.first.app.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee UpdateEmployee(Employee employee, long id);
	void deleteEmployee(long id);
}
