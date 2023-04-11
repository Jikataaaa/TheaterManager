import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {


  loginForm = new FormGroup({
    username: new FormControl(""),
    password: new FormControl("")
  })

  constructor(private service : UserService){}

  login(){
    this.service.login(this.loginForm);
  }
}
