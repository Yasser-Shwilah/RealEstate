package com.realestate.Real_Estate.repository;

import com.realestate.Real_Estate.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Manager findByUsername(String username);
    Manager findByEmail(String email);
    Manager findByPhoneNumber(int phoneNumber);
}
