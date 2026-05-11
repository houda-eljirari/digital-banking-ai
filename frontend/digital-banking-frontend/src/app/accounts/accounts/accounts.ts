import { Component } from '@angular/core';

import { ActivatedRoute } from '@angular/router';

import { AccountsService } from '../../services/accounts';

import { BankAccount } from '../../models/bank-account.model';

import { CommonModule } from '@angular/common';

import { AccountHistory } from '../../models/account-history.model';

@Component({
  selector: 'app-accounts',

  standalone: true,

  imports: [CommonModule],

  templateUrl: './accounts.html',

  styleUrl: './accounts.css'
})
export class Accounts {

  customerId! : number;

  accounts! : Array<BankAccount>;

  accountHistory! : AccountHistory;

  constructor(
    private route : ActivatedRoute,
    private accountsService : AccountsService
  ) {
  }
  handleGetAccountHistory(accountId : string){

    this.accountsService
      .getAccountHistory(accountId,0,5)
      .subscribe({

        next : (data : any) => {

          this.accountHistory = data;

        },

        error : (err) => {

          console.log(err);

        }

      });

  }
  ngOnInit(): void {

    this.customerId =
      this.route.snapshot.params['customerId'];

    this.accountsService
      .getCustomerAccounts(this.customerId)
      .subscribe({

        next : (data) => {

          this.accounts = data;

          if(this.accounts.length > 0){

            this.handleGetAccountHistory(
              this.accounts[0].id
            );

          }

        },

        error : (err) => {

          console.log(err);

        }

      });

  }

}
