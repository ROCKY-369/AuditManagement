import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';
import { AuditResponse } from '../audit-response';

@Component({
  selector: 'app-project-form',
  templateUrl: './project-form.component.html',
  styleUrls: ['./project-form.component.css']
})
export class ProjectFormComponent implements OnInit {

  constructor( private user: UserService, private router: Router, private login:LoginService) { }

  ngOnInit(): void {
  }

  public auditDetails={
    "auditType":localStorage.getItem('auditType'),
  }

  public auditRequest={
    "projectName":'',
    "projectManagerName":'',
    "applicationOwnerName":'',
    "auditDetails":this.auditDetails,
  }

 
  public removeAuditType(){
    localStorage.removeItem('auditType')
  }

  

  public submitAudit(){
    this.user.sendRequestSeverity(this.auditRequest).subscribe(
      (data)=>{
        console.log(data)
        console.log("success")
        Swal.fire('Audit Details Recieved','You can view the Audit Status in the Audit History. Redirecting...','success');
        this.router.navigate(["/dashboard/audithistory"])
        
      },
      (error)=>{
        console.log(error)
        alert("Session Expired")
        Swal.fire('Session Expired','Please Log In Again','error');
        this.login.logout()
        window.location.reload();
        this.router.navigate(['login']);

      }
    )
  }

}
