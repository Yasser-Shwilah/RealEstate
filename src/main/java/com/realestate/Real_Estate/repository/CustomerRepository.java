package com.realestate.Real_Estate.repository;

import com.realestate.Real_Estate.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUsername(String username);
    Customer findByEmail(String email);

    boolean existsByUsername(String username);  

    boolean existsByEmail(String email); 
}
