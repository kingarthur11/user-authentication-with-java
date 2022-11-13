package com.api.auth.userauthentication.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.auth.userauthentication.model.Employee;
import com.api.auth.userauthentication.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/employees")
public class EmployeeResource {
	
	private final EmployeeService employeeService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(EmployeeResource.class);

	@GetMapping 
	public ResponseEntity<List<Employee>> getEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@GetMapping ("{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(employeeService.findById(id));
	}
	
	@PostMapping 
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		employee.setId(employeeService.getAllEmployees().size() + 1);
		return ResponseEntity.created(getLocation(employee.getId())).body(employeeService.addEmployee(employee));
	}
	

	private URI getLocation(Integer id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
	}

	@DeleteMapping ("{id}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(employeeService.deleteById(id));
	}
	
//	@PutMapping  ("{id}")
//	public ResponseEntity<Employee> updateEmployee(@RequestBody @PathVariable("id") Employee employee, Integer id ) {
//		LOGGER.info("this is a save endpoint" + employee);
//		return employee;
////		return ResponseEntity.ok(employeeService.updateEmployee(employee, id));
//	}
	
	@PutMapping  ("{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Integer id ) {
		LOGGER.info("this is a save endpoint" + employee);
		return ResponseEntity.ok(employeeService.updateEmployee(employee, id));
	}
}
