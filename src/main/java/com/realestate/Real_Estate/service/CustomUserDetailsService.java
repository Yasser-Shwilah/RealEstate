package com.realestate.Real_Estate.service;

import com.realestate.Real_Estate.entity.Customer;
import com.realestate.Real_Estate.entity.User;
import com.realestate.Real_Estate.repository.CustomerRepository;
import com.realestate.Real_Estate.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList; 

// @Service
// public class CustomUserDetailsService implements UserDetailsService {

//     @Autowired
//     private CustomerRepository customerRepository;

//     @Autowired
//     private PasswordEncoder passwordEncoder;

//     @Override
//     public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
//         Customer customer = customerRepository.findByUsername(usernameOrEmail);
//         if (customer == null) {
//             customer = customerRepository.findByEmail(usernameOrEmail);
//             if (customer == null) {
//                 throw new UsernameNotFoundException("User not found with username or email: " + usernameOrEmail);
//             }
//         }
//         return new org.springframework.security.core.userdetails.User(
//                 customer.getUsername(),
//                 customer.getPassword(),
//                 new ArrayList<>() 
//         );
//     }

//     public Customer registerCustomer(Customer customer) {
//         customer.setPassword(passwordEncoder.encode(customer.getPassword()));
//         return customerRepository.save(customer);
//     }

//     public Customer findByUsername(String username) {
//         return customerRepository.findByUsername(username);
//     }

//     public Customer findByEmail(String email) {
//         return customerRepository.findByEmail(email);
//     }

//     public Optional<Customer> findById(Long id) {
//         return customerRepository.findById(id);
//     }

//     public List<Customer> findAll() {
//         return customerRepository.findAll();
//     }

//     public void deleteCustomer(Long id) {
//         customerRepository.deleteById(id);
//     }

//     public boolean checkPassword(Customer customer, String rawPassword) {
//         return passwordEncoder.matches(rawPassword, customer.getPassword());
//     }
// }
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(usernameOrEmail);
        if (user == null) {
            user = userRepository.findByEmail(usernameOrEmail);
            if (user == null) {
                throw new UsernameNotFoundException("User not found with username or email: " + usernameOrEmail);
            }
        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                new ArrayList<>() 
        );
    }
}