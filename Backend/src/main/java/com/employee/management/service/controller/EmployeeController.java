package com.employee.management.service.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.service.EmployeeService;
import com.employee.management.service.entities.Employee;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployees();
	}
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/employees/{eid}")
	public  ResponseEntity<Employee> getEmployeeById(@PathVariable int  eid) {
		return employeeService.getEmployeeById(eid);
	} 
	@PutMapping("/employees/{eid}")
	public ResponseEntity<Employee>  UpdateEmployee( @PathVariable int eid,@RequestBody Employee employee) {
		return employeeService.updateEmployee(eid,employee);
	}
	@DeleteMapping("/employees/{eid}")
	public ResponseEntity<Map<String ,Boolean>>  deleteEmployee( @PathVariable int eid) {
		return employeeService.deleteEmployee(eid);
	}
	
}
