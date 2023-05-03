import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { AuthGuard } from "./core/guards/AuthGuard";
import { HomeComponent } from "./home/home.component";
import { NotFoundComponent } from "./not-found/not-found.component";
import { AddPerformanceComponent } from "./performance/add-performance/add-performance.component";
import { PerformancesComponent } from "./performance/performances/performances.component";
import { LoginComponent } from "./user/login/login.component";
import { RegisterComponent } from "./user/register/register.component";

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: '/home',
  },
  {
    path: 'home',
    component: HomeComponent,
    
  },
  {
    path: 'user/login',
    component: LoginComponent
    
  },
  {
    path: 'user/register',
    component: RegisterComponent,
  },{
    path: 'performance/performances',
    component: PerformancesComponent,
  },
  {
    path: 'performance/add-performance',
    component: AddPerformanceComponent,
    canActivate: [AuthGuard],
    data: {
      role: "USER"
    },
  },

  {
    path: '**',
    component: NotFoundComponent,
  },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
  })
  export class AppRoutingModule {}