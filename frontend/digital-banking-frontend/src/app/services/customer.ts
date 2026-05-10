import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { Customer } from '../models/customer.model';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  backendHost : string = "http://localhost:8085";

  constructor(private http : HttpClient) {
  }

  public getCustomers() : Observable<Array<Customer>> {

    return this.http.get<Array<Customer>>(
      this.backendHost + "/api/customers"
    );

  }

  public searchCustomers(keyword : string)
    : Observable<Array<Customer>> {

    return this.http.get<Array<Customer>>(
      this.backendHost +
      "/api/customers/search?keyword=" + keyword
    );

  }

  public deleteCustomer(id : number){

    return this.http.delete(
      this.backendHost + "/api/customers/" + id
    );

  }

}
