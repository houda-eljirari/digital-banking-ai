package ma.enset.digitalbankingbackend.web;

import lombok.AllArgsConstructor;
import ma.enset.digitalbankingbackend.dtos.*;
import ma.enset.digitalbankingbackend.exceptions.BalanceNotSufficientException;
import ma.enset.digitalbankingbackend.exceptions.BankAccountNotFoundException;
import ma.enset.digitalbankingbackend.services.interfaces.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @AllArgsConstructor
    @RequestMapping("/api")
    public class BankAccountRestController {

        private BankAccountService bankAccountService;

        @GetMapping("/accounts")
        public List<BankAccountDTO> listAccounts() {

            return bankAccountService.bankAccountList();
        }

        @GetMapping("/accounts/{accountId}")
        public BankAccountDTO getBankAccount(
                @PathVariable String accountId)
                throws BankAccountNotFoundException {

            return bankAccountService.getBankAccount(accountId);
        }

        @GetMapping("/accounts/{accountId}/operations")
        public AccountHistoryDTO getHistory(
                @PathVariable String accountId,
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "5") int size)
                throws BankAccountNotFoundException {

            return bankAccountService.getAccountHistory(
                    accountId,
                    page,
                    size
            );
        }

        @PostMapping("/accounts/debit")
        public void debit(@RequestBody DebitDTO debitDTO)
                throws BankAccountNotFoundException,
                BalanceNotSufficientException {

            bankAccountService.debit(
                    debitDTO.getAccountId(),
                    debitDTO.getAmount(),
                    debitDTO.getDescription()
            );
        }

        @PostMapping("/accounts/credit")
        public void credit(@RequestBody CreditDTO creditDTO)
                throws BankAccountNotFoundException {

            bankAccountService.credit(
                    creditDTO.getAccountId(),
                    creditDTO.getAmount(),
                    creditDTO.getDescription()
            );
        }

        @PostMapping("/accounts/transfer")
        public void transfer(
                @RequestBody TransferRequestDTO transferRequestDTO)
                throws BankAccountNotFoundException,
                BalanceNotSufficientException {

            bankAccountService.transfer(
                    transferRequestDTO.getAccountSource(),
                    transferRequestDTO.getAccountDestination(),
                    transferRequestDTO.getAmount()
            );
        }
}