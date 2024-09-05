package com.realestate.Real_Estate.repository;

import com.realestate.Real_Estate.entity.TransportService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportServiceRepository extends JpaRepository<TransportService, Long> {
}
