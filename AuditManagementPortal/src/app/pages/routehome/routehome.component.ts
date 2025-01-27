import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';


@Component({
  selector: 'app-routehome',
  templateUrl: './routehome.component.html',
  styleUrls: ['./routehome.component.css']
})
export class RoutehomeComponent implements OnInit {

  constructor(private login:LoginService, private route:Router) { }

  ngOnInit(): void {
    this.redirect()

  }

  redirect(){
    this.login.validatetoken()
    this.route.navigate(['dashboard'])
  }

}
