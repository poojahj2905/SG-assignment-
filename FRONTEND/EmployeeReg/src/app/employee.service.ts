import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import {Injectable} from '@angular/core';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseUrl = 'http://localhost:8083/api/employees';

    constructor(private http: HttpClient) { }

  createEmployee(employee: Object): Observable<Object> 
  {
    return this.http.post(`${this.baseUrl}` + `/register`, employee);
  }


  getEmployeesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

 

  getEmployeesListByFirstNameAsc(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+`/asc`);
  }





}