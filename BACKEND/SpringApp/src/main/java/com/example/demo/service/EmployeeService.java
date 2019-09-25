package com.example.demo.service;

import java.util.List;

import com.example.demo.exceptions.EmployeeAlreadyExistsException;
import com.example.demo.model.Employee;

public interface EmployeeService {

    boolean saveEmployee(Employee employee) throws EmployeeAlreadyExistsException ;
    
    List<Employee> findAllEmployeesOrderByFirstNameAsc();
    
   
    
    
}
