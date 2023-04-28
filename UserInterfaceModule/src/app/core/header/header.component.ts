import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { AdminDialogComponent } from 'src/app/shared/dialogs/admin-dialog/admin-dialog.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  public username = localStorage.getItem("username");

  constructor(private router: Router, public dialog: MatDialog){}

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
  openAdminDialog(){
    const dialogRef = this.dialog.open(AdminDialogComponent,   {
      height : '50%',
      width : '50%'
    });
  }
}

