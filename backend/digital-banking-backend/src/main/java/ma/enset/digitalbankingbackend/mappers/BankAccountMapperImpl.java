package ma.enset.digitalbankingbackend.mappers;

import ma.enset.digitalbankingbackend.dtos.*;
import ma.enset.digitalbankingbackend.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BankAccountMapperImpl {

    public CustomerDTO fromCustomer(Customer customer) {

        CustomerDTO customerDTO = new CustomerDTO();

        BeanUtils.copyProperties(customer, customerDTO);

        return customerDTO;
    }

    public Customer fromCustomerDTO(CustomerDTO customerDTO) {

        Customer customer = new Customer();

        BeanUtils.copyProperties(customerDTO, customer);

        return customer;
    }

    public SavingBankAccountDTO fromSavingBankAccount(SavingAccount savingAccount) {

        SavingBankAccountDTO dto = new SavingBankAccountDTO();

        BeanUtils.copyProperties(savingAccount, dto);

        dto.setType("Saving Account");

        return dto;
    }

    public CurrentBankAccountDTO fromCurrentBankAccount(CurrentAccount currentAccount) {

        CurrentBankAccountDTO dto = new CurrentBankAccountDTO();

        BeanUtils.copyProperties(currentAccount, dto);

        dto.setType("Current Account");

        return dto;
    }

    public AccountOperationDTO fromAccountOperation(AccountOperation accountOperation) {

        AccountOperationDTO dto = new AccountOperationDTO();

        BeanUtils.copyProperties(accountOperation, dto);

        return dto;
    }
}