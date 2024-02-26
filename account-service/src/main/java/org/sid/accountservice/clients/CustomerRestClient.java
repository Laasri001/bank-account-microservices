package org.sid.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.sid.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    @GetMapping("/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);


    @CircuitBreaker(name = "customerService" , fallbackMethod = "getAllCustomers")
    @GetMapping("/customers")
    List<Customer> allCustomers();

        default Customer getDefaultCustomer(Long id,Exception e){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("Not Available");
        customer.setLastName("Not Available");
        customer.setEmail("Not Available");

        return customer;
    }

    default List<Customer> getAllCustomers(Exception e){
            return List.of();
    }
}
