package ma.enset.digitalbankingbackend.services.interfaces;

import ma.enset.digitalbankingbackend.dtos.CustomerDTO;
import ma.enset.digitalbankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {

    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> listCustomers();

    CustomerDTO getCustomer(Long customerId)
            throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);
}