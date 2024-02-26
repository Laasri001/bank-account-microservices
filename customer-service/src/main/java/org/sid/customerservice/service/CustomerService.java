package org.sid.customerservice.service;

import org.sid.customerservice.entities.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomers();
    public Customer getCustomeById(Long id);
}
