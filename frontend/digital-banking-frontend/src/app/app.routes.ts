import { Routes } from '@angular/router';

import { Customers } from './customers/customers/customers';
import { Accounts } from './accounts/accounts/accounts';

export const routes: Routes = [

  {
    path : "customers",
    component : Customers
  },

  {
    path : "accounts",
    component : Accounts
  },

  {
    path : "",
    redirectTo : "/customers",
    pathMatch : "full"
  }

  {
    path : "accounts/:customerId",
    component : Accounts
  }
];
