import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { PerformanceService } from 'src/app/services/performance/performance.service';

@Component({
  selector: 'app-add-performance',
  templateUrl: './add-performance.component.html',
  styleUrls: ['./add-performance.component.css']
})
export class AddPerformanceComponent {

  performanceForm  = new FormGroup({
    name : new FormControl(""),
    genre : new FormControl(""),
    description : new FormControl(""),
    theaterName : new FormControl(""),
    startTime : new FormControl(new Date()),
    time : new FormControl(new Date())
  })

  constructor(private service : PerformanceService){}

  addPerformance(){
    this.service.addPerformance(this.performanceForm).subscribe(response => console.log(response));
  }

}
