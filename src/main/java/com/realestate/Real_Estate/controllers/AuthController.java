package com.realestate.Real_Estate.controllers;

import com.realestate.Real_Estate.dto.LoginDto;
import com.realestate.Real_Estate.dto.SignUpDto;
import com.realestate.Real_Estate.entity.Advertisement;
import com.realestate.Real_Estate.entity.Customer;
// import com.realestate.Real_Estate.entity.Role;
import com.realestate.Real_Estate.entity.User;
import com.realestate.Real_Estate.entity.Role.RoleType;
import com.realestate.Real_Estate.repository.CustomerRepository;
import com.realestate.Real_Estate.service.AdvertisementService;
import com.realestate.Real_Estate.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

       @Autowired
    private UserService userService;
    @Autowired

    private AdvertisementService advertisementService;
    // @PostMapping("/signin")
    // public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto){
    //     Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
    //             loginDto.getUsernameOrEmail(), loginDto.getPassword()));

    //     SecurityContextHolder.getContext().setAuthentication(authentication);
    //     return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    // }


    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getUsernameOrEmail(),
                            loginDto.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<>("User signed-in successfully", HttpStatus.OK);

        } catch (BadCredentialsException ex) {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        } catch (Exception ex) {
            return new ResponseEntity<>("An error occurred during authentication", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody SignUpDto signUpDto) {
        if (customerRepository.existsByUsername(signUpDto.getUsername())) {
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        if (customerRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        Customer customer = new Customer();
        customer.setUsername(signUpDto.getUsername());
        customer.setEmail(signUpDto.getEmail());
        customer.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        customerRepository.save(customer);

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }
    @PostMapping("/usersignup")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // @PostMapping("/register/admin")
    // public ResponseEntity<String> registerAdmin(@RequestBody User user) {
    //     try {
    //         userService.registerUser(user, RoleType.ADMIN);
    //     return new ResponseEntity<>("Admin registered successfully", HttpStatus.OK);
    //     } catch (RuntimeException e) {
    //         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    //     }
    // }

    // @PostMapping("/register/manager")
    // public ResponseEntity<String> registerManager(@RequestBody User user) {
    //     try {
    //         userService.registerUser(user, RoleType.MANAGER);
    //         return new ResponseEntity<>("Manager registered successfully", HttpStatus.OK);
    //     } catch (RuntimeException e) {
    //         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    //     }
    // }

    // @PostMapping("/register/customer")
    // public ResponseEntity<String> registerCustomer(@RequestBody User user) {
    //     try {
    //         userService.registerUser(user, RoleType.CUSTOMER);
    //         return new ResponseEntity<>("Customer registered successfully", HttpStatus.OK);
    //     } catch (RuntimeException e) {
    //         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    //     }
     
    // }

    //     @GetMapping("/admins")
    // public ResponseEntity<List<User>> getAllAdmins() {
    //     List<User> admins = userService.getUsersByRole(RoleType.ADMIN);
    //     return new ResponseEntity<>(admins, HttpStatus.OK);
    // }

    // // Endpoint to get all managers
    // @GetMapping("/managers")
    // public ResponseEntity<List<User>> getAllManagers() {
    //     List<User> managers = userService.getUsersByRole(RoleType.MANAGER);
    //     return new ResponseEntity<>(managers, HttpStatus.OK);
    // }

    // // Endpoint to get all customers
    // @GetMapping("/customers")
    // public ResponseEntity<List<User>> getAllCustomers() {
    //     List<User> customers = userService.getUsersByRole(RoleType.CUSTOMER);
    //     return new ResponseEntity<>(customers, HttpStatus.OK);
    // }

    //     // Create
    // @PostMapping("/create")
    // public ResponseEntity<?> createAdvertisement(@RequestBody Advertisement advertisement) {
    //     try {
    //         Advertisement createdAdvertisement = advertisementService.createAdvertisement(advertisement);
    //         return new ResponseEntity<>(createdAdvertisement, HttpStatus.CREATED);
    //     } catch (Exception e) {
    //         // يمكن تسجيل الاستثناءات هنا باستخدام logger
    //         return new ResponseEntity<>("Failed to create advertisement: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }
    // @GetMapping
    // public ResponseEntity<?> getAllAdvertisements() {
    //     try {
    //         List<Advertisement> advertisements = advertisementService.getAllAdvertisements();
    //         return new ResponseEntity<>(advertisements, HttpStatus.OK);
    //     } catch (Exception e) {
    //         // يمكن تسجيل الاستثناءات هنا باستخدام logger
    //         return new ResponseEntity<>("Failed to retrieve advertisements: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }
}
