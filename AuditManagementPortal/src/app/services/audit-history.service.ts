import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuditHistory } from '../components/audit-history';

@Injectable({
  providedIn: 'root'
})
export class AuditHistoryService {

  constructor(private http:HttpClient) { }

  public getQuestionsList(): Observable<AuditHistory[]>{
    return this.http.get<AuditHistory[]>('http://localhost:8009/getAuditHistory');
  }
}
