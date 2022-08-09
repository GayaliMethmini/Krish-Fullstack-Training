import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { order } from '../model/order-model';

@Injectable({
  providedIn: 'root'
})
export class OrderServiceService {

  private orderurl: string = 'http://localhost:8080/order/'

  constructor(private http: HttpClient) { }

  saveOrder(order:order) : Observable <order>{

    return this.http.post<order>(`${this.orderurl}`,order);
    console.log(order);
  }

  getOrder(id:string): Observable<order>{

    return this.http.get<order>(`${this.orderurl}id/${id}`);
  }
}
