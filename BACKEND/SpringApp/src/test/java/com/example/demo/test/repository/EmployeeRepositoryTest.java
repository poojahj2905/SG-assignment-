package com.example.demo.test.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.junit.Assert;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class EmployeeRepositoryTest 
{
	
	   @Autowired
	    private EmployeeRepository employeeRepository;

	    private Employee employee;
	
	    @Before
	    public void setUp() throws Exception {
	      employee= new Employee();
	      employee.setFirstName("kavya");
	      employee.setLastName("HJ");
	      employee.setGender("Female");
	      employee.setDob("9thMay");
	      employee.setDepartment("Apple");
	      
	    }

	    @Test
	    public void testRegisterEmployeeSuccess()
	    {
	    	employeeRepository.save(employee);
	    	Employee empObj=employeeRepository.findByFirstName(employee.getFirstName());
	    	Assert.assertEquals(employee.getFirstName(), empObj.getFirstName());
	    }


}
