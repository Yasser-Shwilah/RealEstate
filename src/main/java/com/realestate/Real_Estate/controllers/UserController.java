package com.realestate.Real_Estate.controllers;


import com.realestate.Real_Estate.entity.User;
import com.realestate.Real_Estate.entity.Role.RoleType;
import com.realestate.Real_Estate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    
    @PostMapping("/register/admin")
    public ResponseEntity<String> registerAdmin(@RequestBody User user) {
        try {
            userService.registerUser(user, RoleType.ADMIN);
        return new ResponseEntity<>("Admin registered successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register/manager")
    public ResponseEntity<String> registerManager(@RequestBody User user) {
        try {
            userService.registerUser(user, RoleType.MANAGER);
            return new ResponseEntity<>("Manager registered successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register/customer")
    public ResponseEntity<String> registerCustomer(@RequestBody User user) {
        try {
            userService.registerUser(user, RoleType.CUSTOMER);
            return new ResponseEntity<>("Customer registered successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
     
    }
    // Endpoint to get all admins
    @GetMapping("/admins")
    public ResponseEntity<List<User>> getAllAdmins() {
        List<User> admins = userService.getUsersByRole(RoleType.ADMIN);
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    // Endpoint to get all managers
    @GetMapping("/managers")
    public ResponseEntity<List<User>> getAllManagers() {
        List<User> managers = userService.getUsersByRole(RoleType.MANAGER);
        return new ResponseEntity<>(managers, HttpStatus.OK);
    }

    // Endpoint to get all customers
    @GetMapping("/customers")
    public ResponseEntity<List<User>> getAllCustomers() {
        List<User> customers = userService.getUsersByRole(RoleType.CUSTOMER);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
