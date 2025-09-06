import { Component } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import {Router } from '@angular/router';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
styleUrls: ['./create-employee.component.css']})
export class CreateEmployeeComponent {
  employee:Employee= new Employee();
  constructor(private employeeService:EmployeeService, private route:Router){}
  ngOnInit(): void {
}
  onSubmit() {
  console.log("Employee data:", this.employee);
  this.insertEmployee();
}

 insertEmployee() {
  this.employee.eid;
  this.employeeService.createEmployee(this.employee).subscribe({
    next: data => {
      console.log("Saved successfully:", data);
      this.gotoEmployeeList();
    },
    error: err => {
      console.error("Error from backend:", err);
    }
  });
}


  gotoEmployeeList(){
    this.route.navigate(['employees']);
  }
} 
