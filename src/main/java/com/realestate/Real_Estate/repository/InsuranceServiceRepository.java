package com.realestate.Real_Estate.repository;

import com.realestate.Real_Estate.entity.InsuranceService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceServiceRepository extends JpaRepository<InsuranceService, Long> {
}
