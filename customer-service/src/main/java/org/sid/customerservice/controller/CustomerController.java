package org.sid.customerservice.controller;

import lombok.RequiredArgsConstructor;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> customersList(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer customerById(@PathVariable Long id){
        return customerService.getCustomeById(id);
    }

}
