import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AppRoutingModule } from '../app-routing.module';
import { RouterModule } from '@angular/router';
import { AuthGuard } from './guards/AuthGuard';
import { MaterialModule } from '../material/material.module';



@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent
  ],
  
  imports: [CommonModule, AppRoutingModule, RouterModule, MaterialModule],
  providers: [AuthGuard],
  exports : [HeaderComponent, FooterComponent]
})
export class CoreModule { }
