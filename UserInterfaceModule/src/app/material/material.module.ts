import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatIconModule} from '@angular/material/icon';
import {MatFormFieldModule} from '@angular/material/form-field';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatExpansionModule,
    MatIconModule,
    MatFormFieldModule
  ],
  exports: [MatExpansionModule, MatIconModule, MatFormFieldModule]
})
export class MaterialModule { }
