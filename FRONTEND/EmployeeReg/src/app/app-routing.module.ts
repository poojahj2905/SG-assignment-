import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {RegisterComponent} from './register/register.component';
import {EmployeeListComponent} from './employee-list/employee-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'register', pathMatch: 'full' },
 // { path: 'employeePortal',  component: EmployeePortalComponent },
  { path: 'register',  component: RegisterComponent },
  { path: 'listOfEmployees', component: EmployeeListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


