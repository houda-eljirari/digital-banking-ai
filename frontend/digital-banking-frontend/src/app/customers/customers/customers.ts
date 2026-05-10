import { Component, OnInit } from '@angular/core';

import { CommonModule } from '@angular/common';

import { FormsModule } from '@angular/forms';

import { Customer } from '../../models/customer.model';

import { CustomerService } from '../../services/customer';

@Component({
  selector: 'app-customers',

  standalone: true,

  imports: [
    CommonModule,
    FormsModule
  ],

  templateUrl: './customers.html',

  styleUrl: './customers.css'
})
export class Customers implements OnInit {

  customers!: Array<Customer>;

  keyword : string = "";

  constructor(private customerService : CustomerService) {
  }

  ngOnInit(): void {

    this.handleSearchCustomers();

  }

  handleSearchCustomers() {

    this.customerService.searchCustomers(this.keyword)
      .subscribe({

        next : (data) => {

          this.customers = data;

        },

        error : (err) => {

          console.log(err);

        }

      });

  }

}
