package com.api.auth.userauthentication.service;

import java.util.List;

import com.api.auth.userauthentication.model.Employee;

public interface EmployeeService {
	
	Employee addEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Employee findById(Integer id);
	
	Employee updateEmployee(Employee employee, Integer id);
	
	Boolean deleteById(Integer id);

}
