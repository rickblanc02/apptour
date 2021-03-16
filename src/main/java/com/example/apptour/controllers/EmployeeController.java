package com.example.apptour.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apptour.models.Employee;
import com.example.apptour.services.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class EmployeeController  {
	@Autowired
	EmployeeService employeeService;
	
	//@GetMapping
	@GetMapping("/employees")
	public ArrayList<Employee> getEmployees(){
		
		return employeeService.getEmployees();
				
	}
	
	//@PostMapping
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		
		return this.employeeService.saveEmployee(employee);
		
		
	}

}
