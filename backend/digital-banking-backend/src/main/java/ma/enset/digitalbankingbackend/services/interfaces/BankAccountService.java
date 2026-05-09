package ma.enset.digitalbankingbackend.services.interfaces;

import ma.enset.digitalbankingbackend.dtos.*;
import ma.enset.digitalbankingbackend.exceptions.BalanceNotSufficientException;
import ma.enset.digitalbankingbackend.exceptions.BankAccountNotFoundException;
import ma.enset.digitalbankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {

    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> listCustomers();

    CustomerDTO getCustomer(Long customerId)
            throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO)
            throws CustomerNotFoundException;

    void deleteCustomer(Long customerId)
            throws CustomerNotFoundException;

    CurrentBankAccountDTO saveCurrentBankAccount(
            double initialBalance,
            double overDraft,
            Long customerId
    ) throws CustomerNotFoundException;

    SavingBankAccountDTO saveSavingBankAccount(
            double initialBalance,
            double interestRate,
            Long customerId
    ) throws CustomerNotFoundException;

    BankAccountDTO getBankAccount(String accountId)
            throws BankAccountNotFoundException;

    void debit(
            String accountId,
            double amount,
            String description
    ) throws BankAccountNotFoundException,
            BalanceNotSufficientException;

    void credit(
            String accountId,
            double amount,
            String description
    ) throws BankAccountNotFoundException;

    void transfer(
            String accountSource,
            String accountDestination,
            double amount
    ) throws BankAccountNotFoundException,
            BalanceNotSufficientException;

    List<BankAccountDTO> bankAccountList();

    List<AccountOperationDTO> accountHistory(String accountId);
}