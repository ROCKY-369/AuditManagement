import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  header={
    headers: new HttpHeaders().set('Authorization','Bearer '+localStorage.getItem('token')),
  }

  public sendRequestSeverity(auditRequest: any){
    return this.http.post("http://localhost:8009/ProjectExecutionStatus",auditRequest,this.header)
  }
}
