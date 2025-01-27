import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})

//gaurd to prevent the access of the component without proper privilages

export class DashGaurdGuard implements CanActivate {

  constructor(private login:LoginService, private router:Router){}

  canActivate(              
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if(this.login.isLoggedIn()){
      return true;                                    //can be access only if it returns true
    }
    this.router.navigate(['login']);
    return false;

  }
  
}
