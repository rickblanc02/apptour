package com.example.apptour.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apptour.models.Employee;
import com.example.apptour.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository; 
	
	public ArrayList<Employee> getEmployees(){
		ArrayList<Employee> employees;
		
		employees = (ArrayList<Employee>) employeeRepository.findAll(); 
				
		return employees;
	}
	
	public Employee saveEmployee(Employee employee) {
		
		employee = employeeRepository.save(employee);
		
		return employee;
		
		
	}

}
