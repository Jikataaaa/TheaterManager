import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PerformancesComponent } from './performances/performances.component';
import { AddPerformanceComponent } from './add-performance/add-performance.component';
import { MaterialModule } from '../material/material.module';




@NgModule({
  declarations: [
    PerformancesComponent,
    AddPerformanceComponent
  ],
  imports: [
    CommonModule, MaterialModule
  ]
})
export class PerformanceModule { }
