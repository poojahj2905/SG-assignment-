import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees: Observable<Employee[]>;
  
  constructor(private employeeService: EmployeeService) { }
  
    ngOnInit() {
      this.reloadData();
    }

    reloadData() {
      this.employees = this.employeeService.getEmployeesListByFirstNameAsc();
    }

}
