package com.employee.management.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.employee.management.exception.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.employee.management.service.entities.Employee;
import com.employee.management.service.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	public Employee createEmployee(Employee e) {
		return employeeRepository.save(e);
	}
	public ResponseEntity<Employee> getEmployeeById( int  eid) {
		Employee e= employeeRepository.findById(eid).orElseThrow(()-> new EmployeeNotFoundException("Employee with id"+eid+"not found"));
		return ResponseEntity.ok(e);
	}
	public ResponseEntity<Employee>  updateEmployee(  int eid, Employee employee) {
		Employee e= employeeRepository.findById(eid).orElseThrow(()-> new EmployeeNotFoundException("Employee with id"+eid+"not found"));
		e.setEname(employee.getEname());
		e.setDesignation(employee.getDesignation());
		e.setSalary(employee.getSalary());
		employeeRepository.save(e);
		return ResponseEntity.ok(e);
	}
	
	public ResponseEntity<Map<String ,Boolean>>  deleteEmployee(int eid) {
		Employee e= employeeRepository.findById(eid).orElseThrow(()-> new EmployeeNotFoundException("Employee with id"+eid+"not found"));
		 employeeRepository.delete(e);
		 Map<String ,Boolean> response=new HashMap<>();
		 response.put("Deleted",Boolean.TRUE);
		 return ResponseEntity.ok(response);
	}
}
