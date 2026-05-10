import { Component, OnInit } from '@angular/core';

import { CommonModule } from '@angular/common';

import { FormsModule } from '@angular/forms';

import { Customer } from '../../models/customer.model';

import { CustomerService } from '../../services/customer';

import { RouterModule } from '@angular/router';

imports: [CommonModule, FormsModule, RouterModule],
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
handleDeleteCustomer(c : Customer) {

  let conf = confirm("Are you sure?");

  if(!conf) return;

  this.customerService.deleteCustomer(c.id)
    .subscribe({

      next : () => {

        this.customers =
          this.customers.filter(data => data.id != c.id);

      },

      error : (err) => {

        console.log(err);

      }

    });

}
}
