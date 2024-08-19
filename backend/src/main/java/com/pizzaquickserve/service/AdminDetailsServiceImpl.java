package com.pizzaquickserve.service;

import com.pizzaquickserve.model.Admin;
import com.pizzaquickserve.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Admin> adminOpt = adminRepository.findByEmail(email);
        Admin admin = adminOpt.orElseThrow(() ->
                new UsernameNotFoundException("Admin not found with email: " + email)
        );
        return CustomUserDetails.fromAdmin(admin);
    }
}
