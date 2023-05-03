import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { TheaterService } from 'src/app/services/theater/theater.service';

@Component({
  selector: 'app-add-theater',
  templateUrl: './add-theater.component.html',
  styleUrls: ['./add-theater.component.css']
})
export class AddTheaterComponent {

  theaterForm  = new FormGroup({
    name : new FormControl(""),
    address : new FormControl(""),
    capacity : new FormControl(),
  })

  constructor(private service: TheaterService){}

  addTheater(){
    this.service.addTheater(this.theaterForm).subscribe(response => console.log(response));
  }

}
