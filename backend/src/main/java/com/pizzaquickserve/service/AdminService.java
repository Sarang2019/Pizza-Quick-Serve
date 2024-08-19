package com.pizzaquickserve.service;

import com.pizzaquickserve.dto.AdminDTO;
import com.pizzaquickserve.model.Admin;
import com.pizzaquickserve.model.Role;
import com.pizzaquickserve.repository.AdminRepository;
import com.pizzaquickserve.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // This method will initialize roles if they don't exist in the database
    @PostConstruct
    public void initRoles() {
        if (!roleRepository.existsByName("ROLE_ADMIN")) {
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);
        }

        if (!roleRepository.existsByName("ROLE_USER")) {
            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);
        }
    }

    public void registerAdmin(AdminDTO adminDTO) {
        Admin admin = new Admin();
        admin.setEmail(adminDTO.getEmail());
        admin.setName(adminDTO.getName());
        admin.setPassword(passwordEncoder.encode(adminDTO.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role adminRole = roleRepository.findByName("ROLE_ADMIN")
                .orElseThrow(() -> new RuntimeException("Admin Role not found"));
        roles.add(adminRole);
        admin.setRoles(roles);

        adminRepository.save(admin);
    }
}
