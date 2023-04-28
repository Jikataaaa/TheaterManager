import { Component, OnInit } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { PerformanceService } from '../services/performance/performance.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  panelOpenState = false;
  private performances! : Performance[];

   constructor(private performanceService: PerformanceService){
  }
  async ngOnInit() {
    await this.populatePerformances();
    console.log(this.performances)
  }

  async populatePerformances(){
   const data = this.performanceService.getAllPerformaces();
   this.performances = await lastValueFrom(data);
  }

}
