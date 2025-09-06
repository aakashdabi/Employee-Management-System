import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrl: './update-employee.component.css'
})
export class UpdateEmployeeComponent implements OnInit{
  eid:number=0;
  employee:Employee=new Employee();
  constructor(private employeeService:EmployeeService ,private route:ActivatedRoute,private router:Router){}

  ngOnInit(): void {
    this.eid=this.route.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.eid).subscribe(data=>{
      this.employee=data;
    });
  }

  onSubmit(){
    this.employeeService.updateEmployee(this.eid,this.employee).subscribe(data=>{
      this.employee=data;
      this.goToEmployee();
    })
  }
  goToEmployee(){
    this.router.navigate(['/employees']);
  }

}
