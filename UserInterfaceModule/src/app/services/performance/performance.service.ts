import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root',
})
export class PerformanceService {
  private token = localStorage.getItem('token');
  constructor(private http: HttpClient) {}

  getAllPerformaces() {
    return this.http.get<Performance[]>(
      'http://localhost:8080/performance/all-performances',
      {
        headers: {
          Authorization: `Bearer ${this.token}`,
        },
      }
    );
  }
  addPerformance(form: FormGroup) {
    let { name, genre, description, theaterName, time } = form.value;
    console.log(time)
    return this.http.post(
      'http://localhost:8080/performance/create-performance',
      { name, description, genre, theaterName, time },
      {
        headers: {
          Authorization: `Bearer ${this.token}`,
        },
      }
    );
  }
}
