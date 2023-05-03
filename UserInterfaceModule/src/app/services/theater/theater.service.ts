import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { TheaterSelect } from 'src/app/shared/interfaces/TheaterSelect';

@Injectable({
  providedIn: 'root'
})
export class TheaterService {

  private token = localStorage.getItem('token');
  constructor(private http : HttpClient) { }

  addTheater(form : FormGroup){
    let {name, address, capacity} = form.value;
    return this.http.post("http://localhost:8080/theater/add-theater", {name, address, capacity}, {
      headers : {
        Authorization : `Bearer ${this.token}`
      }
    });
  }
  getAll(){
    return this.http.get<TheaterSelect[]>("http://localhost:8080/theater/all-theaters", {
      headers: {
        Authorization : `Bearer ${this.token}`
      }
    })
  }
}
