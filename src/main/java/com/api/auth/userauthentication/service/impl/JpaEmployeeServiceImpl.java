package com.api.auth.userauthentication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.api.auth.userauthentication.model.Employee;
//import com.api.auth.userauthentication.repository.InMemoryEmployeeRepository;
import com.api.auth.userauthentication.repository.JpaEmployeeRepository;
import com.api.auth.userauthentication.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Qualifier(value = "postgresSQLService")
public class JpaEmployeeServiceImpl implements EmployeeService {
	
	private final JpaEmployeeRepository jpaEmployeeRepository;
	
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return jpaEmployeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return jpaEmployeeRepository.findAll();
	}

	@Override
	public Employee findById(Integer id) {
		// TODO Auto-generated method stub
		return jpaEmployeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer id) {
		// TODO Auto-generated method stub
		Employee employDB = jpaEmployeeRepository.findById(id).get();
		
		employDB.setFirstName(employee.getFirstName());
		employDB.setLastName(employee.getLastName());
		employDB.setEmail(employee.getEmail());
		
		return jpaEmployeeRepository.save(employDB);
	}

	@Override
	public Boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		jpaEmployeeRepository.deleteById(id);;
		return true;
	}

}
