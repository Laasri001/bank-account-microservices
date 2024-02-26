package org.sid.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
