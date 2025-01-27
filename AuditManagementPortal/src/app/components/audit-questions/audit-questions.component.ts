import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { QuestionService } from 'src/app/services/question.service';
import { AuditQuestions } from '../audit-questions';
import Swal from 'sweetalert2';
import { LoginService } from 'src/app/services/login.service';


@Component({
  selector: 'app-audit-questions',
  templateUrl: './audit-questions.component.html',
  styleUrls: ['./audit-questions.component.css']
})
export class AuditQuestionsComponent implements OnInit {

  auditQuestionsList: AuditQuestions[] = [];
  auditQuestionsResponseList: AuditQuestions[] = [];
  
  constructor(private questionService: QuestionService,public router: Router, private login:LoginService) { }

  ngOnInit(): void {
   this.getQuestions();
  }

  public auditType={
    auditType: localStorage.getItem('auditType'),
  }

  private getQuestions(){
    this.questionService.getQuestionsList(this.auditType).subscribe(
      (data)=>{
        this.auditQuestionsList=data;
      },(error)=>{
        alert("error");
        console.log(error);
      })
  }

  public saveResponse(){
    this.questionService.saveResponse(this.auditQuestionsList).subscribe(
      (data)=>{
        this.auditQuestionsList=data;
        console.log(data);
        this.router.navigate(["/dashboard/submitaudit/projectform"])
        console.log("routed to details")
      },(error)=>{
        alert("Session Expired")
        console.log(error);
        Swal.fire('Session Expired','Please Log In Again','error');
        this.login.logout()
        window.location.reload();
        this.router.navigate(['login']);
      })

  }


}
