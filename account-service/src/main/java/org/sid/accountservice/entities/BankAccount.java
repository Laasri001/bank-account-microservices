package org.sid.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.sid.accountservice.enums.AccountType;
import org.sid.accountservice.model.Customer;

import java.time.LocalDate;
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private Long customerId;
    @Transient
    private Customer customer;
}
