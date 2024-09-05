package com.realestate.Real_Estate.repository;

import com.realestate.Real_Estate.entity.RealtyInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealtyInsuranceRepository extends JpaRepository<RealtyInsurance, Long> {
}
