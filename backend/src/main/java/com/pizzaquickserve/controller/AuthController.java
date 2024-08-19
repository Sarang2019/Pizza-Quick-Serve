package com.pizzaquickserve.controller;

import com.pizzaquickserve.dto.AdminDTO;
import com.pizzaquickserve.dto.CustomerDTO;
import com.pizzaquickserve.service.AdminService;
import com.pizzaquickserve.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AdminService adminService;
    private final CustomerService customerService;

    public AuthController(AdminService adminService, CustomerService customerService) {
        this.adminService = adminService;
        this.customerService = customerService;
    }

    @PostMapping("/admin/register")
    public ResponseEntity<String> registerAdmin(@RequestBody AdminDTO adminDTO) {
        adminService.registerAdmin(adminDTO);
        return ResponseEntity.ok("Admin registered successfully!");
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.registerCustomer(customerDTO);
        return ResponseEntity.ok("Customer registered successfully with email: " + customerDTO.getEmail());
    }
}
