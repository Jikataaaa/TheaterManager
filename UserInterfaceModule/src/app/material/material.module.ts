import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import {MatDialogModule} from '@angular/material/dialog';
import { MatNativeDateModule } from '@angular/material/core';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    MatExpansionModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    MatDialogModule,
    MatDatepickerModule,
    MatNativeDateModule,
    ReactiveFormsModule
    
  ],
  exports: [
    MatExpansionModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    MatDialogModule,
    MatDatepickerModule,
    MatNativeDateModule,
    ReactiveFormsModule
  ],
})
export class MaterialModule {}
