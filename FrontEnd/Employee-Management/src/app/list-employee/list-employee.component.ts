import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import e from 'express';

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrl: './list-employee.component.css'
})
export class ListEmployeeComponent implements OnInit {
  employees:Employee[]=[];
  constructor(private employeeService: EmployeeService,private router:Router){}
  ngOnInit(): void {
    this.getEmployees();
  }

  private getEmployees(){
    this.employeeService.getEmployeeList().subscribe(data=>{
      this.employees=data;
    });
  }
  updateEmployee(eid:number){
    this.router.navigate(['update-employee',eid]);
  }
  deleteEmployee(eid:number){
    this.employeeService.deleteEmployee(eid).subscribe(data=>{
      this.getEmployees();
    });
  }
}
