import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuditQuestions } from '../components/audit-questions';


@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private http:HttpClient) { }

 

  public getQuestionsList(auditType:any): Observable<AuditQuestions[]>{
    return this.http.post<AuditQuestions[]>('http://localhost:8092/AuditCheckListQuestions',auditType);
  }

  public saveResponse(auditResponse:any): Observable<AuditQuestions[]>{
    return this.http.post<AuditQuestions[]>('http://localhost:8092/saveResponses',auditResponse);
  }

}
