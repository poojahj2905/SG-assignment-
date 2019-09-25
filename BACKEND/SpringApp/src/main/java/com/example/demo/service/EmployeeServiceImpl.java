package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.EmployeeAlreadyExistsException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

	@Autowired
	public EmployeeRepository employeeRepository;
	
	@Override
	public boolean saveEmployee(Employee employee) throws EmployeeAlreadyExistsException {
		
		Employee opt = employeeRepository.findByFirstName(employee.getFirstName());
		if(opt != null) {
			throw new EmployeeAlreadyExistsException("EmployeeAlreadyExistsException");
		}
		employeeRepository.save(employee);
		return true;
	}

	@Override
	public List<Employee> findAllEmployeesOrderByFirstNameAsc() {
		
		
		List<Employee> employees = employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));

		return employees;
	}

  
	   
}
