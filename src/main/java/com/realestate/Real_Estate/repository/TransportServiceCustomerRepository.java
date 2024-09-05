package com.realestate.Real_Estate.repository;

import com.realestate.Real_Estate.entity.TransportServiceCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportServiceCustomerRepository extends JpaRepository<TransportServiceCustomer, Long> {
}
