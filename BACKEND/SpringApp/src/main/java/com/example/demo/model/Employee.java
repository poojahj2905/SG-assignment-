package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

//	@Id
//    private String employeeId;

	@Id
	private String firstName;


	private String lastName;

	
	private String gender;
	
	
	private String dob;
	
	
	private String department;


	public Employee() {
		super();
		
	}


	
	public Employee(String employeeId, String firstName, String lastName, String gender, String dob,
			String department) {
		super();
	//	this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dob = dob;
		this.department = department;
	}




//
//	public String getEmployeeId() {
//		return employeeId;
//	}
//
//
//
//	public void setEmployeeId(String employeeId) {
//		this.employeeId = employeeId;
//	}



	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}



	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dob=" + dob
				+ ", department=" + department + "]";
	}


//
//	@Override
//	public String toString() {
//		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
//				+ ", gender=" + gender + ", dob=" + dob + ", department=" + department + "]";
//	}


	
}
