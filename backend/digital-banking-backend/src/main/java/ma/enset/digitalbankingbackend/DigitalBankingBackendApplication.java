package ma.enset.digitalbankingbackend;

import ma.enset.digitalbankingbackend.dtos.BankAccountDTO;
import ma.enset.digitalbankingbackend.dtos.CurrentBankAccountDTO;
import ma.enset.digitalbankingbackend.dtos.CustomerDTO;
import ma.enset.digitalbankingbackend.dtos.SavingBankAccountDTO;
import ma.enset.digitalbankingbackend.exceptions.BalanceNotSufficientException;
import ma.enset.digitalbankingbackend.exceptions.BankAccountNotFoundException;
import ma.enset.digitalbankingbackend.exceptions.CustomerNotFoundException;
import ma.enset.digitalbankingbackend.services.interfaces.BankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class DigitalBankingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalBankingBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountService bankAccountService) {
        return args -> {

            Stream.of("Houda", "Yassine", "Imane")
                    .forEach(name -> {

                        CustomerDTO customer = new CustomerDTO();

                        customer.setName(name);

                        customer.setEmail(name + "@gmail.com");

                        bankAccountService.saveCustomer(customer);
                    });

            bankAccountService.listCustomers().forEach(customer -> {

                try {

                    bankAccountService.saveCurrentBankAccount(
                            Math.random() * 90000,
                            9000,
                            customer.getId()
                    );

                    bankAccountService.saveSavingBankAccount(
                            Math.random() * 120000,
                            5.5,
                            customer.getId()
                    );

                } catch (CustomerNotFoundException e) {
                    e.printStackTrace();
                }
            });

            List<BankAccountDTO> bankAccounts =
                    bankAccountService.bankAccountList();

            for (BankAccountDTO bankAccount : bankAccounts) {

                for (int i = 0; i < 10; i++) {

                    try {

                        bankAccountService.credit(
                                bankAccount.getId(),
                                10000 + Math.random() * 120000,
                                "Credit"
                        );

                        bankAccountService.debit(
                                bankAccount.getId(),
                                1000 + Math.random() * 9000,
                                "Debit"
                        );

                    } catch (BankAccountNotFoundException |
                             BalanceNotSufficientException e) {

                        e.printStackTrace();
                    }
                }
            }
        };
    }
}