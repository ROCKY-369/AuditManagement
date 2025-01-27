import { Component, OnInit } from '@angular/core';
import { AuditHistoryService } from 'src/app/services/audit-history.service';
import { AuditHistory } from '../audit-history';
import Swal from 'sweetalert2';
import { LoginService } from 'src/app/services/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-audit-history',
  templateUrl: './audit-history.component.html',
  styleUrls: ['./audit-history.component.css']
})
export class AuditHistoryComponent implements OnInit {

  auditHistoryList: AuditHistory[] = [];

  constructor(private historyservice:AuditHistoryService,private login:LoginService, private router:Router) { }

  ngOnInit(): void {
    this.historyservice.getQuestionsList().subscribe(
      (data)=>{
        this.auditHistoryList=data;
        console.log(data);
      },
      (error)=>{
        console.error(error);
        alert("Session Expired")
        Swal.fire('Session Expired','Please Log In Again','error');
        this.login.logout()
        window.location.reload();
        this.router.navigate(['login']);
      })

  }

}
