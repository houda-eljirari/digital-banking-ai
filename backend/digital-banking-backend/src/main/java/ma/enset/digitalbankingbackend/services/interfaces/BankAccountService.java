package ma.enset.digitalbankingbackend.services.interfaces;

import ma.enset.digitalbankingbackend.dtos.CustomerDTO;
import ma.enset.digitalbankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {

    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(CustomerDTO customerDTO)
            throws CustomerNotFoundException;

    void deleteCustomer(Long customerId)
            throws CustomerNotFoundException;

    CustomerDTO getCustomer(Long customerId)
            throws CustomerNotFoundException;

    List<CustomerDTO> listCustomers();
}