 package com.api.auth.userauthentication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.api.auth.userauthentication.model.Employee;
import com.api.auth.userauthentication.repository.InMemoryEmployeeRepository;
import com.api.auth.userauthentication.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Qualifier(value = "inMemory")
public class InMemoryEmployeeServiceImpl implements EmployeeService {

	private final InMemoryEmployeeRepository inMemoryEmployeeRepository;
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return inMemoryEmployeeRepository.addEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return inMemoryEmployeeRepository.getAllEmployees();
	}

	@Override
	public Employee findById(Integer id) {
		// TODO Auto-generated method stub
		return inMemoryEmployeeRepository.findById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer id) {
		// TODO Auto-generated method stub
		return inMemoryEmployeeRepository.updateEmployee(employee, id);
	}

	@Override
	public Boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return inMemoryEmployeeRepository.deleteById(id);
	}

}
