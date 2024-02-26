package org.sid.accountservice.service;

import lombok.RequiredArgsConstructor;
import org.sid.accountservice.clients.CustomerRestClient;
import org.sid.accountservice.entities.BankAccount;
import org.sid.accountservice.model.Customer;
import org.sid.accountservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService{

    private final BankAccountRepository bankAccountRepository;
    private final CustomerRestClient customerRestClient;
    @Override
    public List<BankAccount> findAllBankAccounts() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        bankAccounts.forEach(c -> {
            c.setCustomer(
                    customerRestClient.findCustomerById(c.getCustomerId())
            );
        });

        return bankAccounts;
    }

    @Override
    public BankAccount findBankAccountById(String id) {
        Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(id);

        if(optionalBankAccount.isPresent()){
            BankAccount bankAccount = optionalBankAccount.get();
            Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
            bankAccount.setCustomer(customer);

            return bankAccount;
        }
        throw new IllegalArgumentException("bank account not found with id: "+ id);
    }
}
