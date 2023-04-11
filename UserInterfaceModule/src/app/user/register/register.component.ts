import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  registerForm = new FormGroup({
    username: new FormControl(""),
    password: new FormControl("")
  })

  constructor(private service : UserService){}

  register(){
    this.service.register(this.registerForm);
  }

}
