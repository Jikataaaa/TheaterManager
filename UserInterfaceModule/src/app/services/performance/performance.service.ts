import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PerformanceService {

  private token = localStorage.getItem('token');
  constructor(private http: HttpClient) {
    
  }

  getAllPerformaces(){
    return this.http.get<Performance[]>("http://localhost:8080/performance/all-performances",{
      headers : {
        Authorization : `Bearer ${this.token}`
      }
    });
  }
}
