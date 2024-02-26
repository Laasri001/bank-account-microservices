package org.sid.accountservice;

import org.sid.accountservice.clients.CustomerRestClient;
import org.sid.accountservice.entities.BankAccount;
import org.sid.accountservice.enums.AccountType;
import org.sid.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;
@EnableFeignClients
@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient){
        return args -> {
            customerRestClient.allCustomers().forEach(
                    c -> {
                        BankAccount bankAccount1 = BankAccount.builder()
                                .accountId(UUID.randomUUID().toString())
                                .balance(Math.random() * 50000)
                                .createAt(LocalDate.now())
                                .currency("MAD")
                                .type(AccountType.CURRENT_ACOUNT)
                                .customerId(c.getId())
                                .build();
                        BankAccount bankAccount2 = BankAccount.builder()
                                .accountId(UUID.randomUUID().toString())
                                .balance(Math.random() * 860)
                                .createAt(LocalDate.now())
                                .currency("MAD")
                                .type(AccountType.SAVING_ACCOUNT)
                                .customerId(c.getId())
                                .build();

                        bankAccountRepository.save(bankAccount1);
                        bankAccountRepository.save(bankAccount2);
                    }
            );


        };
    }

}
