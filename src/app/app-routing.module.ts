import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuditHistoryComponent } from './components/audit-history/audit-history.component';
import { AuditQuestionsComponent } from './components/audit-questions/audit-questions.component';
import { AuditResponseComponent } from './components/audit-response/audit-response.component';
import { ChooseTypeComponent } from './components/choose-type/choose-type.component';
import { ProjectFormComponent } from './components/project-form/project-form.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { LoginComponent } from './pages/login/login.component';
import { RoutehomeComponent } from './pages/routehome/routehome.component';
import { DashGaurdGuard } from './services/dash-gaurd.guard';

const routes: Routes = [
  {
    path:'',
    component:RoutehomeComponent,
    pathMatch:'full',
  },
  {
    path: 'login',
    component: LoginComponent ,
    pathMatch:'full',
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    canActivate: [DashGaurdGuard],
    children: [
      {
        path:'',
        component:WelcomeComponent,
        pathMatch:'full',
      },
      {
        path:'submitaudit',
        component:AuditResponseComponent,
        children:[
          {
            path:'',
            component:ChooseTypeComponent,
            pathMatch:'full',

          },
          {
            path:'projectform',
            component:ProjectFormComponent,
            pathMatch:'full',
          },
          {
            path:'auditquestion',
            component:AuditQuestionsComponent,
            pathMatch:'full',
          },
        ]
      },
      {
        path:'audithistory',
        component:AuditHistoryComponent,
        pathMatch:'full'
      }
      
    ]
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
