package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.EmployeeAlreadyExistsException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")
public class EmployeeController {

	@Autowired
	public EmployeeRepository employeeRepository;
	
	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public EmployeeService employeeService;
	
	ResponseEntity<?> responseEntity;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		System.out.println("Get all Employees...");

		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);

		return employees;
	}
	
	@GetMapping("/employees/asc")
	public List<Employee> getAllEmployeesByFirstNameAsc() {
		System.out.println("Get all Employees In asc...");

		return employeeService.findAllEmployeesOrderByFirstNameAsc();

	}
	
//	@GetMapping("/employees/asc")
//	public ResponseEntity<?> getAllEmployeesByFirstNameAsc() {
//		System.out.println("Get all Employees In asc...");
//
//		try {
//		List<Employee> employees= employeeService.findAllEmployeesOrderByFirstNameAsc();
//		responseEntity = new ResponseEntity<List<Employee>>(employees , HttpStatus.FOUND);
//		if(employees.size()==0)
//		{
//			responseEntity = new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
//		}
//		}
//		catch(Exception e)
//		{
//        	responseEntity = new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
//
//		}
//		return responseEntity;
//		
//	}
//	
	
	@PostMapping(value = "/employees/register")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee) throws EmployeeAlreadyExistsException{
		System.out.println("First Name is..."+employee.getFirstName());
		System.out.println("Last Name is..."+employee.getLastName());
		System.out.println("Gender is..."+employee.getGender());
		System.out.println("DOB is..."+employee.getDob());
		System.out.println("Department is..."+employee.getDepartment());
		if (employeeService.saveEmployee(employee))
			responseEntity = new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
		else {
			responseEntity = new ResponseEntity<String>("Conflict", HttpStatus.CONFLICT);
		}
		return responseEntity;
		
//		Employee _employee = employeeRepository.save(new Employee(employee.getEmployeeId(),employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getDob(), employee.getDepartment()));
//		return _employee;
	}
	

	
	
}
