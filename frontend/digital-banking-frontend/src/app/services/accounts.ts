import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable } from 'rxjs';

import { BankAccount } from '../models/bank-account.model';

@Injectable({
  providedIn: 'root'
})
export class AccountsService {

  host : string = "http://localhost:8085/api";

  constructor(private http: HttpClient) { }

  public getCustomerAccounts(
    customerId : number
  ) : Observable<Array<BankAccount>> {

    return this.http.get<Array<BankAccount>>(
      `${this.host}/customers/${customerId}/accounts`
    );

  }
  getAccountHistory(
    accountId : string,
    page : number,
    size : number
  ){

    return this.http.get<any>(
      `${this.host}/accounts/${accountId}/pageOperations?page=${page}&size=${size}`
    );

  }
}
