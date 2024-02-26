package org.sid.accountservice.service;

import org.sid.accountservice.entities.BankAccount;

import java.util.List;

public interface BankAccountService {
    public List<BankAccount> findAllBankAccounts();
    public BankAccount findBankAccountById(String id);
}
