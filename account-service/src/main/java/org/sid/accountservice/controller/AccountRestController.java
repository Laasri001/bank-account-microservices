package org.sid.accountservice.controller;

import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.sid.accountservice.entities.BankAccount;
import org.sid.accountservice.service.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountRestController {

    private final BankAccountService bankAccountService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BankAccount> accountList(){
        return bankAccountService.findAllBankAccounts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BankAccount accountById(@PathVariable String id){
        return bankAccountService.findBankAccountById(id);
    }

}
