import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { LoginService } from "./login.service";

//Interceptor to add jwt token in the header


@Injectable()
export class AuthInterceptor implements HttpInterceptor{

    constructor(private login:LoginService){}

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> { 

        //add the jwt token (from local storage) request
        let authReq=req;
        const token=this.login.getToken();
        if(token!=null){
            authReq=authReq.clone({setHeaders:{'Authorization':'Bearer '+localStorage.getItem("token")},});
        }
        return next.handle(authReq);
    }  
}

export const authInterceptorProviders=[     //Creating Array
    {
        provide: HTTP_INTERCEPTORS,
        useClass: AuthInterceptor,
        multi: true
    }
]