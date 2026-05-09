package ma.enset.digitalbankingbackend;

import ma.enset.digitalbankingbackend.entities.*;
import ma.enset.digitalbankingbackend.enums.AccountStatus;
import ma.enset.digitalbankingbackend.enums.OperationType;
import ma.enset.digitalbankingbackend.repositories.AccountOperationRepository;
import ma.enset.digitalbankingbackend.repositories.BankAccountRepository;
import ma.enset.digitalbankingbackend.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class DigitalBankingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalBankingBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            CustomerRepository customerRepository,
            BankAccountRepository bankAccountRepository,
            AccountOperationRepository operationRepository
    ) {
        return args -> {

            Stream.of("Houda", "Mohamed", "Sara").forEach(name -> {
                Customer customer = Customer.builder()
                        .name(name)
                        .email(name + "@gmail.com")
                        .build();

                customerRepository.save(customer);
            });

            customerRepository.findAll().forEach(customer -> {

                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random() * 90000);
                currentAccount.setCreatedAt(new Date());
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setCustomer(customer);
                currentAccount.setOverDraft(9000);

                bankAccountRepository.save(currentAccount);

                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setBalance(Math.random() * 120000);
                savingAccount.setCreatedAt(new Date());
                savingAccount.setStatus(AccountStatus.CREATED);
                savingAccount.setCustomer(customer);
                savingAccount.setInterestRate(5.5);

                bankAccountRepository.save(savingAccount);
            });

            bankAccountRepository.findAll().forEach(account -> {

                for (int i = 0; i < 10; i++) {

                    AccountOperation operation = AccountOperation.builder()
                            .operationDate(new Date())
                            .amount(Math.random() * 12000)
                            .type(Math.random() > 0.5 ? OperationType.DEBIT : OperationType.CREDIT)
                            .bankAccount(account)
                            .description("Operation")
                            .build();

                    operationRepository.save(operation);
                }
            });
        };
    }
}