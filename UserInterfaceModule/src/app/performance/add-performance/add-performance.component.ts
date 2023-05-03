import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { lastValueFrom } from 'rxjs';
import { PerformanceService } from 'src/app/services/performance/performance.service';
import { TheaterService } from 'src/app/services/theater/theater.service';
import { TheaterSelect } from 'src/app/shared/interfaces/TheaterSelect';

@Component({
  selector: 'app-add-performance',
  templateUrl: './add-performance.component.html',
  styleUrls: ['./add-performance.component.css']
})
export class AddPerformanceComponent implements OnInit{

  performanceForm  = new FormGroup({
    name : new FormControl(""),
    genre : new FormControl(""),
    description : new FormControl(""),
    theaterName : new FormControl(""),
    time : new FormControl(new Date())
  })

  theaters! : TheaterSelect[];

  constructor(private service : PerformanceService, 
    private theaterService : TheaterService){}

   async ngOnInit() {
      await this.populateTheaters();
    }

  addPerformance(){
    this.service.addPerformance(this.performanceForm).subscribe(response => console.log(response));
  }

 async populateTheaters(){
   const response =  this.theaterService.getAll();
   const data = await lastValueFrom(response);
   this.theaters = data;
  }

}
