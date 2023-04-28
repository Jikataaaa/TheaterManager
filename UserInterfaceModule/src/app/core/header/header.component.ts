import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  public username = localStorage.getItem("username");

  constructor(private router: Router){}

  get isLoged(){
    let token = localStorage.getItem("token")
    if(token){
      return true
    }
    return false
  }
  get isAdmin(){
    let role = localStorage.getItem("role")
    if(role == "ADMIN"){
      return true
    }
    return false
  }
  logout(){
    localStorage.clear();
    this.router.navigate(['/home'])
  }
}
