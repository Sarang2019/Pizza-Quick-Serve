package com.pizzaquickserve.service;

import com.pizzaquickserve.model.Admin;
import com.pizzaquickserve.model.Customer;
import com.pizzaquickserve.repository.AdminRepository;
import com.pizzaquickserve.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // First, check if the user is a customer
        Optional<Customer> customerOpt = customerRepository.findByEmail(email);
        if (customerOpt.isPresent()) {
            return CustomUserDetails.fromCustomer(customerOpt.get());
        }

        // If not a customer, check if the user is an admin
        Optional<Admin> adminOpt = adminRepository.findByEmail(email);
        if (adminOpt.isPresent()) {
            return CustomUserDetails.fromAdmin(adminOpt.get());
        }

        throw new UsernameNotFoundException("User not found with email: " + email);
    }
}
