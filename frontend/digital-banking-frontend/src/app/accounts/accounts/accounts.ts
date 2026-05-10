import { Component } from '@angular/core';

import { ActivatedRoute } from '@angular/router';

import { AccountsService } from '../../services/accounts';

import { BankAccount } from '../../models/bank-account.model';

import { CommonModule } from '@angular/common';

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

  constructor(
    private route : ActivatedRoute,
    private accountsService : AccountsService
  ) {
  }

  ngOnInit(): void {

    this.customerId =
      this.route.snapshot.params['customerId'];

    this.accountsService
      .getCustomerAccounts(this.customerId)
      .subscribe({

        next : (data) => {

          this.accounts = data;

        },

        error : (err) => {

          console.log(err);

        }

      });

  }

}
