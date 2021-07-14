import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  isLoggedIn: boolean = false;
  user: string | null | undefined;

  constructor(public login:LoginService,  private router:Router) { }

  ngOnInit(): void {
    this.login.loginStatusSubject.asObservable().subscribe(data=>{
      this.isLoggedIn=this.login.isLoggedIn();
      this.user=this.login.getUser();
    })
  }

  userLogout(){
    this.login.logout();
    console.log("user logged out");
    this.login.loginStatusSubject.next(false)
    window.location.reload();
    this.router.navigate(['login']);
  }

}
