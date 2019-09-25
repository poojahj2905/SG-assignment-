import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  title = 'Registration Form';
  employee: Employee = new Employee();
  submitted = false;

  // firstName = new FormControl('', [ Validators.required ]);
  // lastName = new FormControl('', [ Validators.required ]);
  // gender = new FormControl('', [ Validators.required ]);
  // dob = new FormControl('', [ Validators.required ]);
  // department = new FormControl('', [ Validators.required ]);

  constructor(private employeeService: EmployeeService) {
   console.log("Came inside Constructor...")    
   }

  ngOnInit() {
  }

  newEmployee(): void {

    this.submitted = false;
    this.employee = new Employee();
    console.log("Inside NEW Employee...."+ this.employee.firstName);

  }

  save() 
  {
    console.log("First Name......."+this.employee.firstName);
    console.log("Last Name......."+this.employee.lastName);
    console.log("Gender......."+this.employee.gender);
    console.log("DOB......."+this.employee.dob);
    console.log("Department......."+this.employee.department);
     this.employeeService.createEmployee(this.employee)
      .subscribe(data => {

        console.log(data)},
       error =>{ 

      console.log(error)});
  
    this.employee = new Employee();
    
  }
  


  onSubmit() {
    this.submitted = true;
    this.save();
  }

  // loginSubmit() 
  // {
  //   console.log("nnnnnn...."+ firstName );
   
  //     console.log('Inside IF....')
  //     this.employeeService.createEmployee(
  //       {
  //         id: this.firstName.value,
  //         firstName: this.firstName.value,
  //         lastName: this.lastName.value,
  //         gender: this.gender.value,
  //         dob: this.dob.value,
  //         department: this.department.value
  //       } ).subscribe(data => console.log(data), error => console.log(error))

    

  // }

 

}




