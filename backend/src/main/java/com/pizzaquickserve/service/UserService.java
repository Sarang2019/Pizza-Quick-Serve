package com.pizzaquickserve.service;

import com.pizzaquickserve.dto.AdminDTO;
import com.pizzaquickserve.dto.CustomerDTO;
import com.pizzaquickserve.model.Admin;
import com.pizzaquickserve.model.Customer;
import com.pizzaquickserve.repository.AdminRepository;
import com.pizzaquickserve.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final CustomerRepository customerRepository;
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(CustomerRepository customerRepository, AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @
            Transactional
    public Customer registerCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setEmail(customerDTO.getEmail());
        customer.setName(customerDTO.getName());
        customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        return customerRepository.save(customer);
    }

    @Transactional
    public Admin registerAdmin(AdminDTO adminDTO) {
        Admin admin = new Admin();
        admin.setEmail(adminDTO.getEmail());
        admin.setName(adminDTO.getName());
        admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
        return adminRepository.save(admin);
    }

    public Optional<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Admin> findAllAdmins() {
        return adminRepository.findAll();
    }
}
