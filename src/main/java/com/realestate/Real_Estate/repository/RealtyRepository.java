package com.realestate.Real_Estate.repository;

import com.realestate.Real_Estate.entity.Realty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealtyRepository extends JpaRepository<Realty, Long> {
}
