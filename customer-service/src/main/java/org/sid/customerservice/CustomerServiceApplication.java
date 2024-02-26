package org.sid.customerservice;

import org.sid.customerservice.config.GlobalConfig;
import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class})
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			Customer customer1 = Customer.builder()
					.firstName("Zakaria")
					.lastName("Rahali")
					.email("rahali@gmail.com")
					.build();

			Customer customer2 = Customer.builder()
					.firstName("Younes")
					.lastName("laasri")
					.email("laasri@gmail.com")
					.build();

			List<Customer> customers = List.of(customer1,customer2);
			customerRepository.saveAll(customers);
		};
	}
}
