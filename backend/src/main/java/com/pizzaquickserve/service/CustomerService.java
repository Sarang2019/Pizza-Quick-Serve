package com.pizzaquickserve.service;

import com.pizzaquickserve.dto.CustomerDTO;
import com.pizzaquickserve.model.Customer;
import com.pizzaquickserve.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        customer.setName(customerDTO.getName());
        customerRepository.save(customer);
    }
}
