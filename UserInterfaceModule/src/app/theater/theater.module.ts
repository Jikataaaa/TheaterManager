import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddTheaterComponent } from './add-theater/add-theater.component';
import { MaterialModule } from '../material/material.module';



@NgModule({
  declarations: [
    AddTheaterComponent
  ],
  imports: [
    CommonModule,
    MaterialModule
  ]
})
export class TheaterModule { }
