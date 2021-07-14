import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  constructor(public login:LoginService,   private router:Router) { }

  ngOnInit(): void {
  }

  userLogout(){
    this.login.logout();
    console.log("user logged out");
    this.login.loginStatusSubject.next(false)
    window.location.reload();
    this.router.navigate(['login']);
  }
}
