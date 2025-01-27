import { Component, OnInit } from '@angular/core';
import {MatSnackBar} from '@angular/material/snack-bar';
import { LoginService } from 'src/app/services/login.service';
  

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData={
    userName: '',
    password: '',
  };

  constructor( private snack: MatSnackBar, private login:LoginService ) { }

  ngOnInit(): void {
  }
  hide = true;

    formSubmit(){
      console.log("login form submitted")
      if(this.loginData.userName.trim()==''|| this.loginData.userName==null){
          this.snack.open("Username is required.", '',{
            duration:3000,
          });
          return;
      }
      if(this.loginData.password.trim()==''|| this.loginData.password==null){
        this.snack.open("Password is required.", '',{
          duration:3000,
        });
        return;
    }
    //requesting the setver to generate a token
    this.login.generateToken(this.loginData).subscribe(
      (data:any)=>{
        console.log("success");
        console.log(data)
        this.login.loginStatusSubject.next(true);
        //login
        this.login.loginUser(data.jwtAuthToken);
        this.login.setUser(data.userName)
        console.log(this.login.getUser())
        window.location.href='/dashboard'

      },
      (error)=>{
        console.log("Error !");
        console.log(error);
        this.snack.open("Invalid Details !! Try Again",'',{duration:3000})
      }
    )

  }
  

}
