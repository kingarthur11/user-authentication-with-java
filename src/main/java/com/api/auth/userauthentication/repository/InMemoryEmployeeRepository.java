package com.api.auth.userauthentication.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.auth.userauthentication.model.Employee;

@Repository
public class InMemoryEmployeeRepository {

	private static final List<Employee> DATABASE = new ArrayList<>();
	
	static {
		DATABASE.add(new Employee(1, "John", "Chima", "johnsmith@gmail.com"));
		DATABASE.add(new Employee(2, "Michale", "Uchechi", "chaima@gmail.com"));
		DATABASE.add(new Employee(3, "Rachel", "Chisom", "chdisom@gmail.com"));
		DATABASE.add(new Employee(4, "Samuel", "Chidimma", "dimma@gmail.com"));
		DATABASE.add(new Employee(5, "Sandra", "Ebuka", "ebuka@gmail.com"));
	}
	
	public Employee addEmployee(Employee employee) {
		DATABASE.add(employee);
		return employee;
	}
	
	public List<Employee> getAllEmployees() {
		return List.copyOf(DATABASE);
	}
	
	public Employee findById(Integer id) {
		return DATABASE.stream().filter(empl -> id.equals(empl.getId())).findFirst().orElseThrow();
	}
	
	public Employee updateEmployee(Employee employee, Integer id) {
		Employee emploDB = DATABASE.stream().filter(empl -> id.equals(empl.getId())).findFirst().orElseThrow();
		emploDB.setFirstName(employee.getFirstName());
		emploDB.setLastName(employee.getLastName());
		emploDB.setEmail(employee.getEmail());
		
		return emploDB;
	}
	
	public Boolean deleteById(Integer id) {
		Employee emploDB = DATABASE.stream().filter(empl -> id.equals(empl.getId())).findFirst().orElseThrow();
		DATABASE.remove(emploDB);
		return true;
	}
}
