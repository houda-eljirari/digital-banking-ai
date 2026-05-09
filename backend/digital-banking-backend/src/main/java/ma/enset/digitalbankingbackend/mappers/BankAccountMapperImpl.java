package ma.enset.digitalbankingbackend.mappers;

import ma.enset.digitalbankingbackend.dtos.*;
import ma.enset.digitalbankingbackend.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BankAccountMapperImpl {

    public CustomerDTO fromCustomer(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());

        return customerDTO;
    }

    public Customer fromCustomerDTO(CustomerDTO customerDTO){
        Customer customer = new Customer();

        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());

        return customer;
    }

    public SavingBankAccountDTO fromSavingBankAccount(SavingAccount savingAccount){
        SavingBankAccountDTO dto = new SavingBankAccountDTO();

        dto.setId(savingAccount.getId());
        dto.setBalance(savingAccount.getBalance());
        dto.setCreatedAt(savingAccount.getCreatedAt());
        dto.setStatus(savingAccount.getStatus());
        dto.setCustomerId(savingAccount.getCustomer().getId());
        dto.setCustomerName(savingAccount.getCustomer().getName());
        dto.setInterestRate(savingAccount.getInterestRate());
        dto.setType(savingAccount.getClass().getSimpleName());

        return dto;
    }

    public CurrentBankAccountDTO fromCurrentBankAccount(CurrentAccount currentAccount){
        CurrentBankAccountDTO dto = new CurrentBankAccountDTO();

        dto.setId(currentAccount.getId());
        dto.setBalance(currentAccount.getBalance());
        dto.setCreatedAt(currentAccount.getCreatedAt());
        dto.setStatus(currentAccount.getStatus());
        dto.setCustomerId(currentAccount.getCustomer().getId());
        dto.setCustomerName(currentAccount.getCustomer().getName());
        dto.setOverDraft(currentAccount.getOverDraft());
        dto.setType(currentAccount.getClass().getSimpleName());

        return dto;
    }

    public AccountOperationDTO fromAccountOperation(AccountOperation operation){
        AccountOperationDTO dto = new AccountOperationDTO();

        dto.setId(operation.getId());
        dto.setOperationDate(operation.getOperationDate());
        dto.setAmount(operation.getAmount());
        dto.setType(operation.getType());
        dto.setDescription(operation.getDescription());

        return dto;
    }

}