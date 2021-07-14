import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public loginStatusSubject=new Subject<boolean>();

  constructor(private http: HttpClient) { }

  //genetrate tokens

  public generateToken(loginData: any){
    return this.http.post('http://localhost:8008/authorization/login',loginData)
  }
  public validStatus:any;

  public validatetoken(){
    this.http.get('http://localhost:8008/authorization/validate').subscribe(
      (data)=>{
        console.log(data)
        this.validStatus=data
        if(this.validStatus.validStatus){
          this.logout();
        }
        return true;
      },(error)=>{
        console.log(error)
        this.logout();
        return false;
      });
      
  }

  public loginUser(token: string){           //add token to browser's local storage
    localStorage.setItem("token",token);
    return true;
  }

  //check if the tokn is available or not
  public isLoggedIn(){
    let tokenString = localStorage.getItem("token"); //get the token from localStorage
    if(tokenString==undefined || tokenString=='' || tokenString== null){
      return false;
    }
    else{
     return true;
    }
  }

  //logout: remove the token from the local storage
  public logout(){
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    return true;
  }

  //get token 
  public getToken(){
    return localStorage.getItem("token");
  }

  //save user in local storage
  public setUser(user: string){
    localStorage.setItem("user", user);
  }

  public getUser(){
    return localStorage.getItem("user");
  }

  public getUserAsJson(){
    let userStr=localStorage.getItem('user');
    if(userStr!=null){
      return JSON.parse(userStr);
    }else{
      this.logout();
      return null;
    }
  }


}
