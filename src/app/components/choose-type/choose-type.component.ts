import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-choose-type',
  templateUrl: './choose-type.component.html',
  styleUrls: ['./choose-type.component.css']
})
export class ChooseTypeComponent implements OnInit {

  constructor(public router: Router) { }

  ngOnInit(): void {
  }

  public clickInternal(){
    localStorage.setItem('auditType','Internal');
    this.router.navigate(["/dashboard/submitaudit/auditquestion"]);
  }
  public clickSOX(){
    localStorage.setItem('auditType','SOX');
    this.router.navigate(["/dashboard/submitaudit/auditquestion"]);
  }

}
