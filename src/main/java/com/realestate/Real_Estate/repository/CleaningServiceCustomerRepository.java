package com.realestate.Real_Estate.repository;

import com.realestate.Real_Estate.entity.CleaningServiceCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CleaningServiceCustomerRepository extends JpaRepository<CleaningServiceCustomer, Long> {
}
